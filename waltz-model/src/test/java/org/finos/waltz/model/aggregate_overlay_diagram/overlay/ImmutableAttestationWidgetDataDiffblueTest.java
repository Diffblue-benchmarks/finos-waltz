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
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAttestationWidgetData.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAttestationWidgetData.Json;
import org.finos.waltz.model.application.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAttestationWidgetDataDiffblueTest {
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
    Builder builderResult = ImmutableAttestationWidgetData.builder();

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
    Builder builderResult = ImmutableAttestationWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllCellData(new ArrayList<>()));
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
    Builder builderResult = ImmutableAttestationWidgetData.builder();

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
    Builder builderResult = ImmutableAttestationWidgetData.builder();

    // Act
    Builder actualAddApplicationsResult = builderResult.addApplications(mock(Application.class));

    // Assert
    assertEquals(1, builderResult.build().applications().size());
    assertSame(builderResult, actualAddApplicationsResult);
  }

  /**
   * Test Builder {@link Builder#addCellData(AttestationWidgetDatum)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableAttestationWidgetDatum.Json} (default constructor).</li>
   *   <li>Then builder build cellData size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addCellData(AttestationWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder addCellData(AttestationWidgetDatum) with 'element'; when Json (default constructor); then builder build cellData size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addCellData(AttestationWidgetDatum)"})
  void testBuilderAddCellDataWithElement_whenJson_thenBuilderBuildCellDataSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetData.builder();

    // Act
    Builder actualAddCellDataResult = builderResult.addCellData(new ImmutableAttestationWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Test Builder {@link Builder#addCellData(AttestationWidgetDatum[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableAttestationWidgetDatum.Json} (default constructor).</li>
   *   <li>Then builder build cellData size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addCellData(AttestationWidgetDatum[])}
   */
  @Test
  @DisplayName("Test Builder addCellData(AttestationWidgetDatum[]) with 'elements'; when Json (default constructor); then builder build cellData size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addCellData(AttestationWidgetDatum[])"})
  void testBuilderAddCellDataWithElements_whenJson_thenBuilderBuildCellDataSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetData.builder();

    // Act
    Builder actualAddCellDataResult = builderResult.addCellData(new ImmutableAttestationWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
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
    Builder builderResult = ImmutableAttestationWidgetData.builder();

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
  @MethodsUnderTest({"ImmutableAttestationWidgetData Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableAttestationWidgetData.builder().build().applications().isEmpty());
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
    Builder builderResult = ImmutableAttestationWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.cellData(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(AttestationWidgetData)}.
   * <ul>
   *   <li>Given array of {@link Application} with {@link Application}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AttestationWidgetData)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationWidgetData); given array of Application with Application; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationWidgetData)"})
  void testBuilderFrom_givenArrayOfApplicationWithApplication_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetData.builder();
    Builder builderResult2 = ImmutableAttestationWidgetData.builder();
    builderResult2.addApplications(mock(Application.class));
    builderResult2.addCellData(new ImmutableAttestationWidgetDatum.Json());
    ImmutableAttestationWidgetData instance = builderResult2.build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestationWidgetData)}.
   * <ul>
   *   <li>Given {@link ImmutableAttestationWidgetDatum.Json} (default constructor).</li>
   *   <li>Then return build is builder build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AttestationWidgetData)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationWidgetData); given Json (default constructor); then return build is builder build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationWidgetData)"})
  void testBuilderFrom_givenJson_thenReturnBuildIsBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetData.builder();
    Builder builderResult2 = ImmutableAttestationWidgetData.builder();
    builderResult2.addCellData(new ImmutableAttestationWidgetDatum.Json());
    ImmutableAttestationWidgetData instance = builderResult2.build();

    // Act and Assert
    assertEquals(instance, builderResult.from(instance).build());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(AttestationWidgetData)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return build is builder build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AttestationWidgetData)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationWidgetData); when builder build; then return build is builder build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationWidgetData)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuildIsBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetData.builder();
    ImmutableAttestationWidgetData instance = ImmutableAttestationWidgetData.builder().build();

    // Act and Assert
    assertEquals(instance, builderResult.from(instance).build());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#copyOf(AttestationWidgetData)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return applications Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAttestationWidgetData#copyOf(AttestationWidgetData)}
   */
  @Test
  @DisplayName("Test copyOf(AttestationWidgetData); when builder build; then return applications Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAttestationWidgetData ImmutableAttestationWidgetData.copyOf(AttestationWidgetData)"})
  void testCopyOf_whenBuilderBuild_thenReturnApplicationsEmpty() {
    // Arrange
    ImmutableAttestationWidgetData instance = ImmutableAttestationWidgetData.builder().build();

    // Act
    ImmutableAttestationWidgetData actualCopyOfResult = ImmutableAttestationWidgetData.copyOf(instance);

    // Assert
    Set<Application> applicationsResult = actualCopyOfResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualCopyOfResult.cellData());
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#equals(Object)}, and {@link ImmutableAttestationWidgetData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAttestationWidgetData#equals(Object)}
   *   <li>{@link ImmutableAttestationWidgetData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAttestationWidgetData.equals(Object)",
      "int ImmutableAttestationWidgetData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAttestationWidgetData buildResult = ImmutableAttestationWidgetData.builder().build();
    ImmutableAttestationWidgetData buildResult2 = ImmutableAttestationWidgetData.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#equals(Object)}, and {@link ImmutableAttestationWidgetData#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAttestationWidgetData#equals(Object)}
   *   <li>{@link ImmutableAttestationWidgetData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAttestationWidgetData.equals(Object)",
      "int ImmutableAttestationWidgetData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAttestationWidgetData buildResult = ImmutableAttestationWidgetData.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAttestationWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAttestationWidgetData.equals(Object)",
      "int ImmutableAttestationWidgetData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetData.builder();
    builderResult.addCellData(new ImmutableAttestationWidgetDatum.Json());
    ImmutableAttestationWidgetData buildResult = builderResult.build();
    ImmutableAttestationWidgetData buildResult2 = ImmutableAttestationWidgetData.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAttestationWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAttestationWidgetData.equals(Object)",
      "int ImmutableAttestationWidgetData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetData.builder();
    builderResult.addApplications(mock(Application.class));
    ImmutableAttestationWidgetData buildResult = builderResult.build();
    ImmutableAttestationWidgetData buildResult2 = ImmutableAttestationWidgetData.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAttestationWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAttestationWidgetData.equals(Object)",
      "int ImmutableAttestationWidgetData.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableAttestationWidgetData buildResult = ImmutableAttestationWidgetData.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAttestationWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAttestationWidgetData.equals(Object)",
      "int ImmutableAttestationWidgetData.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableAttestationWidgetData buildResult = ImmutableAttestationWidgetData.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableAttestationWidgetData");
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link Application}.</li>
   *   <li>Then return applications size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAttestationWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given LinkedHashSet() add Application; then return applications size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAttestationWidgetData ImmutableAttestationWidgetData.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddApplication_thenReturnApplicationsSizeIsOne() {
    // Arrange
    LinkedHashSet<Application> applications = new LinkedHashSet<>();
    applications.add(mock(Application.class));

    Json json = new Json();
    json.setCellData(null);
    json.setApplications(applications);

    // Act
    ImmutableAttestationWidgetData actualFromJsonResult = ImmutableAttestationWidgetData.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.applications().size());
    assertTrue(actualFromJsonResult.cellData().isEmpty());
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link ImmutableAttestationWidgetDatum.Json} (default constructor).</li>
   *   <li>Then return cellData is {@link LinkedHashSet#LinkedHashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAttestationWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return cellData is LinkedHashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAttestationWidgetData ImmutableAttestationWidgetData.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddJson_thenReturnCellDataIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<AttestationWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableAttestationWidgetDatum.Json());
    cellData.add(new ImmutableAttestationWidgetDatum.Json());

    Json json = new Json();
    json.setCellData(cellData);
    json.setApplications(null);

    // Act
    ImmutableAttestationWidgetData actualFromJsonResult = ImmutableAttestationWidgetData.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.applications().isEmpty());
    assertEquals(cellData, actualFromJsonResult.cellData());
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link ImmutableAttestationWidgetDatum.Json} (default constructor).</li>
   *   <li>Then return cellData size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAttestationWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return cellData size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAttestationWidgetData ImmutableAttestationWidgetData.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddJson_thenReturnCellDataSizeIsOne() {
    // Arrange
    LinkedHashSet<AttestationWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableAttestationWidgetDatum.Json());

    Json json = new Json();
    json.setCellData(cellData);
    json.setApplications(null);

    // Act
    ImmutableAttestationWidgetData actualFromJsonResult = ImmutableAttestationWidgetData.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.cellData().size());
    assertTrue(actualFromJsonResult.applications().isEmpty());
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Json} (default constructor) CellData is {@code null}.</li>
   *   <li>Then return cellData is applications.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAttestationWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) CellData is 'null'; then return cellData is applications")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAttestationWidgetData ImmutableAttestationWidgetData.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonCellDataIsNull_thenReturnCellDataIsApplications() {
    // Arrange
    Json json = new Json();
    json.setCellData(null);
    json.setApplications(null);

    // Act
    ImmutableAttestationWidgetData actualFromJsonResult = ImmutableAttestationWidgetData.fromJson(json);

    // Assert
    Set<Application> applicationsResult = actualFromJsonResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualFromJsonResult.cellData());
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return cellData is {@link Json} (default constructor) {@link Json#cellData}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAttestationWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return cellData is Json (default constructor) cellData")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAttestationWidgetData ImmutableAttestationWidgetData.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnCellDataIsJsonCellData() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableAttestationWidgetData actualFromJsonResult = ImmutableAttestationWidgetData.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.applications().isEmpty());
    Set<AttestationWidgetDatum> expectedCellDataResult = json.cellData;
    assertSame(expectedCellDataResult, actualFromJsonResult.cellData());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAttestationWidgetData#toString()}
   *   <li>{@link ImmutableAttestationWidgetData#applications()}
   *   <li>{@link ImmutableAttestationWidgetData#cellData()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ImmutableAttestationWidgetData.applications()",
      "Set ImmutableAttestationWidgetData.cellData()", "String ImmutableAttestationWidgetData.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableAttestationWidgetData buildResult = ImmutableAttestationWidgetData.builder().build();

    // Act
    String actualToStringResult = buildResult.toString();
    Set<Application> actualApplicationsResult = buildResult.applications();
    Set<AttestationWidgetDatum> actualCellDataResult = buildResult.cellData();

    // Assert
    assertEquals("AttestationWidgetData{cellData=[], applications=[]}", actualToStringResult);
    assertTrue(actualApplicationsResult.isEmpty());
    assertSame(actualApplicationsResult, actualCellDataResult);
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
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#withApplications(Application[])} with {@code Application[]}.
   * <ul>
   *   <li>Then return applications size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAttestationWidgetData#withApplications(Application[])}
   */
  @Test
  @DisplayName("Test withApplications(Application[]) with 'Application[]'; then return applications size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAttestationWidgetData ImmutableAttestationWidgetData.withApplications(Application[])"})
  void testWithApplicationsWithApplication_thenReturnApplicationsSizeIsOne() {
    // Arrange
    ImmutableAttestationWidgetData buildResult = ImmutableAttestationWidgetData.builder().build();

    // Act
    ImmutableAttestationWidgetData actualWithApplicationsResult = buildResult.withApplications(mock(Application.class));

    // Assert
    assertEquals(1, actualWithApplicationsResult.applications().size());
    assertTrue(actualWithApplicationsResult.cellData().isEmpty());
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#withCellData(AttestationWidgetDatum[])} with {@code AttestationWidgetDatum[]}.
   * <ul>
   *   <li>When {@link ImmutableAttestationWidgetDatum.Json} (default constructor).</li>
   *   <li>Then return cellData size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAttestationWidgetData#withCellData(AttestationWidgetDatum[])}
   */
  @Test
  @DisplayName("Test withCellData(AttestationWidgetDatum[]) with 'AttestationWidgetDatum[]'; when Json (default constructor); then return cellData size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAttestationWidgetData ImmutableAttestationWidgetData.withCellData(AttestationWidgetDatum[])"})
  void testWithCellDataWithAttestationWidgetDatum_whenJson_thenReturnCellDataSizeIsOne() {
    // Arrange
    ImmutableAttestationWidgetData buildResult = ImmutableAttestationWidgetData.builder().build();

    // Act
    ImmutableAttestationWidgetData actualWithCellDataResult = buildResult
        .withCellData(new ImmutableAttestationWidgetDatum.Json());

    // Assert
    assertEquals(1, actualWithCellDataResult.cellData().size());
    assertTrue(actualWithCellDataResult.applications().isEmpty());
  }
}
