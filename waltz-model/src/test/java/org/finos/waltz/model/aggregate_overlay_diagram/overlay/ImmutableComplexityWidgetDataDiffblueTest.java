package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

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
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableComplexityWidgetData.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableComplexityWidgetData.Json;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.complexity.ComplexityKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableComplexityWidgetDataDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllApplications(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllApplications(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllApplications(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllApplications(Iterable)"})
  void testBuilderAddAllApplications_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllApplications(new ArrayList<>()));
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
    Builder builderResult = ImmutableComplexityWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllCellData(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllComplexityKinds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllComplexityKinds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllComplexityKinds(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllComplexityKinds(Iterable)"})
  void testBuilderAddAllComplexityKinds_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllComplexityKinds(new ArrayList<>()));
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
    Builder builderResult = ImmutableComplexityWidgetData.builder();

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
    Builder builderResult = ImmutableComplexityWidgetData.builder();

    // Act
    Builder actualAddApplicationsResult = builderResult.addApplications(mock(Application.class));

    // Assert
    assertEquals(1, builderResult.build().applications().size());
    assertSame(builderResult, actualAddApplicationsResult);
  }

  /**
   * Test Builder {@link Builder#addCellData(ComplexityWidgetDatum)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableComplexityWidgetDatum.Json} (default constructor).</li>
   *   <li>Then builder build cellData size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addCellData(ComplexityWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder addCellData(ComplexityWidgetDatum) with 'element'; when Json (default constructor); then builder build cellData size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addCellData(ComplexityWidgetDatum)"})
  void testBuilderAddCellDataWithElement_whenJson_thenBuilderBuildCellDataSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetData.builder();

    // Act
    Builder actualAddCellDataResult = builderResult.addCellData(new ImmutableComplexityWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Test Builder {@link Builder#addCellData(ComplexityWidgetDatum[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableComplexityWidgetDatum.Json} (default constructor).</li>
   *   <li>Then builder build cellData size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addCellData(ComplexityWidgetDatum[])}
   */
  @Test
  @DisplayName("Test Builder addCellData(ComplexityWidgetDatum[]) with 'elements'; when Json (default constructor); then builder build cellData size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addCellData(ComplexityWidgetDatum[])"})
  void testBuilderAddCellDataWithElements_whenJson_thenBuilderBuildCellDataSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetData.builder();

    // Act
    Builder actualAddCellDataResult = builderResult.addCellData(new ImmutableComplexityWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Test Builder {@link Builder#addComplexityKinds(ComplexityKind)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addComplexityKinds(ComplexityKind)}
   */
  @Test
  @DisplayName("Test Builder addComplexityKinds(ComplexityKind) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addComplexityKinds(ComplexityKind)"})
  void testBuilderAddComplexityKindsWithElement() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetData.builder();

    // Act
    Builder actualAddComplexityKindsResult = builderResult.addComplexityKinds(mock(ComplexityKind.class));

    // Assert
    assertEquals(1, builderResult.build().complexityKinds().size());
    assertSame(builderResult, actualAddComplexityKindsResult);
  }

  /**
   * Test Builder {@link Builder#addComplexityKinds(ComplexityKind[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addComplexityKinds(ComplexityKind[])}
   */
  @Test
  @DisplayName("Test Builder addComplexityKinds(ComplexityKind[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addComplexityKinds(ComplexityKind[])"})
  void testBuilderAddComplexityKindsWithElements() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetData.builder();

    // Act
    Builder actualAddComplexityKindsResult = builderResult.addComplexityKinds(mock(ComplexityKind.class));

    // Assert
    assertEquals(1, builderResult.build().complexityKinds().size());
    assertSame(builderResult, actualAddComplexityKindsResult);
  }

  /**
   * Test Builder {@link Builder#applications(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#applications(Iterable)}
   */
  @Test
  @DisplayName("Test Builder applications(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.applications(Iterable)"})
  void testBuilderApplications_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applications(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableComplexityWidgetData Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableComplexityWidgetData.builder().build().applications().isEmpty());
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
    Builder builderResult = ImmutableComplexityWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.cellData(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#complexityKinds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#complexityKinds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder complexityKinds(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.complexityKinds(Iterable)"})
  void testBuilderComplexityKinds_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.complexityKinds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(ComplexityWidgetData)}.
   * <ul>
   *   <li>Given {@link ImmutableComplexityWidgetDatum.Json} (default constructor).</li>
   *   <li>Then return build complexityKinds is {@link ImmutableComplexityWidgetDatum.Json} (default constructor) {@link ImmutableComplexityWidgetDatum.Json#complexities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ComplexityWidgetData)}
   */
  @Test
  @DisplayName("Test Builder from(ComplexityWidgetData); given Json (default constructor); then return build complexityKinds is Json (default constructor) complexities")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ComplexityWidgetData)"})
  void testBuilderFrom_givenJson_thenReturnBuildComplexityKindsIsJsonComplexities() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetData.builder();
    Builder builderResult2 = ImmutableComplexityWidgetData.builder();
    ImmutableComplexityWidgetDatum.Json element = new ImmutableComplexityWidgetDatum.Json();
    builderResult2.addCellData(element);
    ImmutableComplexityWidgetData instance = builderResult2.build();

    // Act and Assert
    ImmutableComplexityWidgetData buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.cellData().size());
    assertTrue(buildResult.applications().isEmpty());
    assertEquals(instance, builderResult.build());
    Set<ComplexityEntry> expectedComplexityKindsResult = element.complexities;
    assertSame(expectedComplexityKindsResult, buildResult.complexityKinds());
  }

  /**
   * Test Builder {@link Builder#from(ComplexityWidgetData)}.
   * <ul>
   *   <li>Then return build applications size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ComplexityWidgetData)}
   */
  @Test
  @DisplayName("Test Builder from(ComplexityWidgetData); then return build applications size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ComplexityWidgetData)"})
  void testBuilderFrom_thenReturnBuildApplicationsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetData.builder();
    Builder builderResult2 = ImmutableComplexityWidgetData.builder();
    builderResult2.addApplications(mock(Application.class));
    builderResult2.addCellData(new ImmutableComplexityWidgetDatum.Json());
    ImmutableComplexityWidgetData instance = builderResult2.build();

    // Act and Assert
    ImmutableComplexityWidgetData buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.applications().size());
    assertEquals(1, buildResult.cellData().size());
    assertTrue(buildResult.complexityKinds().isEmpty());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(ComplexityWidgetData)}.
   * <ul>
   *   <li>Then return build complexityKinds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ComplexityWidgetData)}
   */
  @Test
  @DisplayName("Test Builder from(ComplexityWidgetData); then return build complexityKinds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ComplexityWidgetData)"})
  void testBuilderFrom_thenReturnBuildComplexityKindsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetData.builder();
    Builder builderResult2 = ImmutableComplexityWidgetData.builder();
    builderResult2.addComplexityKinds(mock(ComplexityKind.class));
    builderResult2.addCellData(new ImmutableComplexityWidgetDatum.Json());
    ImmutableComplexityWidgetData instance = builderResult2.build();

    // Act and Assert
    ImmutableComplexityWidgetData buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.cellData().size());
    assertEquals(1, buildResult.complexityKinds().size());
    assertTrue(buildResult.applications().isEmpty());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(ComplexityWidgetData)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return build cellData is build applications.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ComplexityWidgetData)}
   */
  @Test
  @DisplayName("Test Builder from(ComplexityWidgetData); when builder build; then return build cellData is build applications")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ComplexityWidgetData)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuildCellDataIsBuildApplications() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetData.builder();
    ImmutableComplexityWidgetData instance = ImmutableComplexityWidgetData.builder().build();

    // Act and Assert
    ImmutableComplexityWidgetData buildResult = builderResult.from(instance).build();
    Set<Application> applicationsResult = buildResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertEquals(instance, builderResult.build());
    assertSame(applicationsResult, buildResult.cellData());
    assertSame(applicationsResult, buildResult.complexityKinds());
  }

  /**
   * Test {@link ImmutableComplexityWidgetData#copyOf(ComplexityWidgetData)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return applications Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableComplexityWidgetData#copyOf(ComplexityWidgetData)}
   */
  @Test
  @DisplayName("Test copyOf(ComplexityWidgetData); when builder build; then return applications Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableComplexityWidgetData ImmutableComplexityWidgetData.copyOf(ComplexityWidgetData)"})
  void testCopyOf_whenBuilderBuild_thenReturnApplicationsEmpty() {
    // Arrange
    ImmutableComplexityWidgetData instance = ImmutableComplexityWidgetData.builder().build();

    // Act
    ImmutableComplexityWidgetData actualCopyOfResult = ImmutableComplexityWidgetData.copyOf(instance);

    // Assert
    Set<Application> applicationsResult = actualCopyOfResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualCopyOfResult.cellData());
    assertSame(applicationsResult, actualCopyOfResult.complexityKinds());
  }

  /**
   * Test {@link ImmutableComplexityWidgetData#equals(Object)}, and {@link ImmutableComplexityWidgetData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableComplexityWidgetData#equals(Object)}
   *   <li>{@link ImmutableComplexityWidgetData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableComplexityWidgetData.equals(Object)",
      "int ImmutableComplexityWidgetData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableComplexityWidgetData buildResult = ImmutableComplexityWidgetData.builder().build();
    ImmutableComplexityWidgetData buildResult2 = ImmutableComplexityWidgetData.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableComplexityWidgetData#equals(Object)}, and {@link ImmutableComplexityWidgetData#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableComplexityWidgetData#equals(Object)}
   *   <li>{@link ImmutableComplexityWidgetData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableComplexityWidgetData.equals(Object)",
      "int ImmutableComplexityWidgetData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableComplexityWidgetData buildResult = ImmutableComplexityWidgetData.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableComplexityWidgetData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableComplexityWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableComplexityWidgetData.equals(Object)",
      "int ImmutableComplexityWidgetData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetData.builder();
    builderResult.addCellData(new ImmutableComplexityWidgetDatum.Json());
    ImmutableComplexityWidgetData buildResult = builderResult.build();
    ImmutableComplexityWidgetData buildResult2 = ImmutableComplexityWidgetData.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableComplexityWidgetData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableComplexityWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableComplexityWidgetData.equals(Object)",
      "int ImmutableComplexityWidgetData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetData.builder();
    builderResult.addApplications(mock(Application.class));
    ImmutableComplexityWidgetData buildResult = builderResult.build();
    ImmutableComplexityWidgetData buildResult2 = ImmutableComplexityWidgetData.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableComplexityWidgetData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableComplexityWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableComplexityWidgetData.equals(Object)",
      "int ImmutableComplexityWidgetData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetData.builder();
    builderResult.addComplexityKinds(mock(ComplexityKind.class));
    ImmutableComplexityWidgetData buildResult = builderResult.build();
    ImmutableComplexityWidgetData buildResult2 = ImmutableComplexityWidgetData.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableComplexityWidgetData#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableComplexityWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableComplexityWidgetData.equals(Object)",
      "int ImmutableComplexityWidgetData.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableComplexityWidgetData buildResult = ImmutableComplexityWidgetData.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableComplexityWidgetData#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableComplexityWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableComplexityWidgetData.equals(Object)",
      "int ImmutableComplexityWidgetData.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableComplexityWidgetData buildResult = ImmutableComplexityWidgetData.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableComplexityWidgetData");
  }

  /**
   * Test {@link ImmutableComplexityWidgetData#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link Application}.</li>
   *   <li>Then return applications size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableComplexityWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given LinkedHashSet() add Application; then return applications size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableComplexityWidgetData ImmutableComplexityWidgetData.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddApplication_thenReturnApplicationsSizeIsOne() {
    // Arrange
    LinkedHashSet<Application> applications = new LinkedHashSet<>();
    applications.add(mock(Application.class));

    Json json = new Json();
    json.setCellData(null);
    json.setApplications(applications);
    json.setComplexityKinds(null);

    // Act
    ImmutableComplexityWidgetData actualFromJsonResult = ImmutableComplexityWidgetData.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.applications().size());
    Set<ComplexityWidgetDatum> cellDataResult = actualFromJsonResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualFromJsonResult.complexityKinds());
  }

  /**
   * Test {@link ImmutableComplexityWidgetData#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link ImmutableComplexityWidgetDatum.Json} (default constructor).</li>
   *   <li>Then return cellData is {@link LinkedHashSet#LinkedHashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableComplexityWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return cellData is LinkedHashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableComplexityWidgetData ImmutableComplexityWidgetData.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddJson_thenReturnCellDataIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<ComplexityWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableComplexityWidgetDatum.Json());
    ImmutableComplexityWidgetDatum.Json json = new ImmutableComplexityWidgetDatum.Json();
    cellData.add(json);

    Json json2 = new Json();
    json2.setCellData(cellData);
    json2.setApplications(null);
    json2.setComplexityKinds(null);

    // Act
    ImmutableComplexityWidgetData actualFromJsonResult = ImmutableComplexityWidgetData.fromJson(json2);

    // Assert
    assertEquals(cellData, actualFromJsonResult.cellData());
    Set<ComplexityEntry> expectedComplexityKindsResult = json.complexities;
    assertSame(expectedComplexityKindsResult, actualFromJsonResult.complexityKinds());
  }

  /**
   * Test {@link ImmutableComplexityWidgetData#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link ImmutableComplexityWidgetDatum.Json} (default constructor).</li>
   *   <li>Then return cellData size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableComplexityWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return cellData size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableComplexityWidgetData ImmutableComplexityWidgetData.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddJson_thenReturnCellDataSizeIsOne() {
    // Arrange
    LinkedHashSet<ComplexityWidgetDatum> cellData = new LinkedHashSet<>();
    ImmutableComplexityWidgetDatum.Json json = new ImmutableComplexityWidgetDatum.Json();
    cellData.add(json);

    Json json2 = new Json();
    json2.setCellData(cellData);
    json2.setApplications(null);
    json2.setComplexityKinds(null);

    // Act
    ImmutableComplexityWidgetData actualFromJsonResult = ImmutableComplexityWidgetData.fromJson(json2);

    // Assert
    assertEquals(1, actualFromJsonResult.cellData().size());
    Set<ComplexityEntry> expectedComplexityKindsResult = json.complexities;
    assertSame(expectedComplexityKindsResult, actualFromJsonResult.complexityKinds());
  }

  /**
   * Test {@link ImmutableComplexityWidgetData#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Json} (default constructor) CellData is {@code null}.</li>
   *   <li>Then return applications Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableComplexityWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) CellData is 'null'; then return applications Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableComplexityWidgetData ImmutableComplexityWidgetData.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonCellDataIsNull_thenReturnApplicationsEmpty() {
    // Arrange
    Json json = new Json();
    json.setCellData(null);
    json.setApplications(null);
    json.setComplexityKinds(null);

    // Act
    ImmutableComplexityWidgetData actualFromJsonResult = ImmutableComplexityWidgetData.fromJson(json);

    // Assert
    Set<Application> applicationsResult = actualFromJsonResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualFromJsonResult.cellData());
    assertSame(applicationsResult, actualFromJsonResult.complexityKinds());
  }

  /**
   * Test {@link ImmutableComplexityWidgetData#fromJson(Json)}.
   * <ul>
   *   <li>Then return complexityKinds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableComplexityWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return complexityKinds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableComplexityWidgetData ImmutableComplexityWidgetData.fromJson(Json)"})
  void testFromJson_thenReturnComplexityKindsSizeIsOne() {
    // Arrange
    LinkedHashSet<ComplexityKind> complexityKinds = new LinkedHashSet<>();
    complexityKinds.add(mock(ComplexityKind.class));

    Json json = new Json();
    json.setCellData(null);
    json.setApplications(null);
    json.setComplexityKinds(complexityKinds);

    // Act and Assert
    assertEquals(1, ImmutableComplexityWidgetData.fromJson(json).complexityKinds().size());
  }

  /**
   * Test {@link ImmutableComplexityWidgetData#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return cellData is {@link Json} (default constructor) {@link Json#complexityKinds}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableComplexityWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return cellData is Json (default constructor) complexityKinds")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableComplexityWidgetData ImmutableComplexityWidgetData.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnCellDataIsJsonComplexityKinds() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableComplexityWidgetData actualFromJsonResult = ImmutableComplexityWidgetData.fromJson(json);

    // Assert
    Set<ComplexityKind> complexityKindSet = json.complexityKinds;
    assertSame(complexityKindSet, actualFromJsonResult.cellData());
    assertSame(complexityKindSet, actualFromJsonResult.complexityKinds());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableComplexityWidgetData#toString()}
   *   <li>{@link ImmutableComplexityWidgetData#applications()}
   *   <li>{@link ImmutableComplexityWidgetData#cellData()}
   *   <li>{@link ImmutableComplexityWidgetData#complexityKinds()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ImmutableComplexityWidgetData.applications()", "Set ImmutableComplexityWidgetData.cellData()",
      "Set ImmutableComplexityWidgetData.complexityKinds()", "String ImmutableComplexityWidgetData.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableComplexityWidgetData buildResult = ImmutableComplexityWidgetData.builder().build();

    // Act
    String actualToStringResult = buildResult.toString();
    Set<Application> actualApplicationsResult = buildResult.applications();
    Set<ComplexityWidgetDatum> actualCellDataResult = buildResult.cellData();
    Set<ComplexityKind> actualComplexityKindsResult = buildResult.complexityKinds();

    // Assert
    assertEquals("ComplexityWidgetData{cellData=[], applications=[], complexityKinds=[]}", actualToStringResult);
    assertTrue(actualApplicationsResult.isEmpty());
    assertSame(actualApplicationsResult, actualCellDataResult);
    assertSame(actualApplicationsResult, actualComplexityKindsResult);
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
   * Test Json {@link Json#complexityKinds()}.
   * <p>
   * Method under test: {@link Json#complexityKinds()}
   */
  @Test
  @DisplayName("Test Json complexityKinds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.complexityKinds()"})
  void testJsonComplexityKinds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).complexityKinds());
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
    assertTrue(actualJson.complexityKinds.isEmpty());
  }

  /**
   * Test {@link ImmutableComplexityWidgetData#withApplications(Application[])} with {@code Application[]}.
   * <ul>
   *   <li>Then return applications size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableComplexityWidgetData#withApplications(Application[])}
   */
  @Test
  @DisplayName("Test withApplications(Application[]) with 'Application[]'; then return applications size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableComplexityWidgetData ImmutableComplexityWidgetData.withApplications(Application[])"})
  void testWithApplicationsWithApplication_thenReturnApplicationsSizeIsOne() {
    // Arrange
    ImmutableComplexityWidgetData buildResult = ImmutableComplexityWidgetData.builder().build();

    // Act
    ImmutableComplexityWidgetData actualWithApplicationsResult = buildResult.withApplications(mock(Application.class));

    // Assert
    assertEquals(1, actualWithApplicationsResult.applications().size());
    Set<ComplexityWidgetDatum> cellDataResult = actualWithApplicationsResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualWithApplicationsResult.complexityKinds());
  }

  /**
   * Test {@link ImmutableComplexityWidgetData#withCellData(ComplexityWidgetDatum[])} with {@code ComplexityWidgetDatum[]}.
   * <ul>
   *   <li>When {@link ImmutableComplexityWidgetDatum.Json} (default constructor).</li>
   *   <li>Then return cellData size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableComplexityWidgetData#withCellData(ComplexityWidgetDatum[])}
   */
  @Test
  @DisplayName("Test withCellData(ComplexityWidgetDatum[]) with 'ComplexityWidgetDatum[]'; when Json (default constructor); then return cellData size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableComplexityWidgetData ImmutableComplexityWidgetData.withCellData(ComplexityWidgetDatum[])"})
  void testWithCellDataWithComplexityWidgetDatum_whenJson_thenReturnCellDataSizeIsOne() {
    // Arrange
    ImmutableComplexityWidgetData buildResult = ImmutableComplexityWidgetData.builder().build();
    ImmutableComplexityWidgetDatum.Json json = new ImmutableComplexityWidgetDatum.Json();

    // Act
    ImmutableComplexityWidgetData actualWithCellDataResult = buildResult.withCellData(json);

    // Assert
    assertEquals(1, actualWithCellDataResult.cellData().size());
    assertTrue(actualWithCellDataResult.applications().isEmpty());
    Set<ComplexityEntry> expectedComplexityKindsResult = json.complexities;
    assertSame(expectedComplexityKindsResult, actualWithCellDataResult.complexityKinds());
  }

  /**
   * Test {@link ImmutableComplexityWidgetData#withComplexityKinds(ComplexityKind[])} with {@code ComplexityKind[]}.
   * <ul>
   *   <li>Then return complexityKinds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableComplexityWidgetData#withComplexityKinds(ComplexityKind[])}
   */
  @Test
  @DisplayName("Test withComplexityKinds(ComplexityKind[]) with 'ComplexityKind[]'; then return complexityKinds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableComplexityWidgetData ImmutableComplexityWidgetData.withComplexityKinds(ComplexityKind[])"})
  void testWithComplexityKindsWithComplexityKind_thenReturnComplexityKindsSizeIsOne() {
    // Arrange
    ImmutableComplexityWidgetData buildResult = ImmutableComplexityWidgetData.builder().build();

    // Act
    ImmutableComplexityWidgetData actualWithComplexityKindsResult = buildResult
        .withComplexityKinds(mock(ComplexityKind.class));

    // Assert
    assertEquals(1, actualWithComplexityKindsResult.complexityKinds().size());
    Set<Application> applicationsResult = actualWithComplexityKindsResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualWithComplexityKindsResult.cellData());
  }
}
