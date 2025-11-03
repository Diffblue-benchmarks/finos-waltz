package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ch.qos.logback.core.util.COWArrayList;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.report_grid.ImmutableReportGridColumnDefinitionsUpdateCommand.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridColumnDefinitionsUpdateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridColumnDefinitionsUpdateCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllDerivedColumnDefinitions(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllDerivedColumnDefinitions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllDerivedColumnDefinitions(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllDerivedColumnDefinitions(Iterable)"})
  void testBuilderAddAllDerivedColumnDefinitions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDerivedColumnDefinitions(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllFixedColumnDefinitions(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllFixedColumnDefinitions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllFixedColumnDefinitions(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllFixedColumnDefinitions(Iterable)"})
  void testBuilderAddAllFixedColumnDefinitions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllFixedColumnDefinitions(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName("Test Builder addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition)"})
  void testBuilderAddDerivedColumnDefinitionsWithElement() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand.builder();
    ImmutableReportGridDerivedColumnDefinition.Json element = new ImmutableReportGridDerivedColumnDefinition.Json();

    // Act
    Builder actualAddDerivedColumnDefinitionsResult = builderResult.addDerivedColumnDefinitions(element);

    // Assert
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult = builderResult.build()
        .derivedColumnDefinitions();
    assertEquals(1, derivedColumnDefinitionsResult.size());
    assertSame(element, derivedColumnDefinitionsResult.get(0));
    assertSame(builderResult, actualAddDerivedColumnDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[])}
   */
  @Test
  @DisplayName("Test Builder addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[])"})
  void testBuilderAddDerivedColumnDefinitionsWithElements() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand.builder();
    ImmutableReportGridDerivedColumnDefinition.Json json = new ImmutableReportGridDerivedColumnDefinition.Json();

    // Act
    Builder actualAddDerivedColumnDefinitionsResult = builderResult.addDerivedColumnDefinitions(json);

    // Assert
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult = builderResult.build()
        .derivedColumnDefinitions();
    assertEquals(1, derivedColumnDefinitionsResult.size());
    assertSame(json, derivedColumnDefinitionsResult.get(0));
    assertSame(builderResult, actualAddDerivedColumnDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addFixedColumnDefinitions(ReportGridFixedColumnDefinition)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addFixedColumnDefinitions(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName("Test Builder addFixedColumnDefinitions(ReportGridFixedColumnDefinition) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addFixedColumnDefinitions(ReportGridFixedColumnDefinition)"})
  void testBuilderAddFixedColumnDefinitionsWithElement() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand.builder();
    ImmutableReportGridFixedColumnDefinition.Json element = new ImmutableReportGridFixedColumnDefinition.Json();

    // Act
    Builder actualAddFixedColumnDefinitionsResult = builderResult.addFixedColumnDefinitions(element);

    // Assert
    List<ReportGridFixedColumnDefinition> fixedColumnDefinitionsResult = builderResult.build().fixedColumnDefinitions();
    assertEquals(1, fixedColumnDefinitionsResult.size());
    assertSame(element, fixedColumnDefinitionsResult.get(0));
    assertSame(builderResult, actualAddFixedColumnDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addFixedColumnDefinitions(ReportGridFixedColumnDefinition[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addFixedColumnDefinitions(ReportGridFixedColumnDefinition[])}
   */
  @Test
  @DisplayName("Test Builder addFixedColumnDefinitions(ReportGridFixedColumnDefinition[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addFixedColumnDefinitions(ReportGridFixedColumnDefinition[])"})
  void testBuilderAddFixedColumnDefinitionsWithElements() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand.builder();
    ImmutableReportGridFixedColumnDefinition.Json json = new ImmutableReportGridFixedColumnDefinition.Json();

    // Act
    Builder actualAddFixedColumnDefinitionsResult = builderResult.addFixedColumnDefinitions(json);

    // Assert
    List<ReportGridFixedColumnDefinition> fixedColumnDefinitionsResult = builderResult.build().fixedColumnDefinitions();
    assertEquals(1, fixedColumnDefinitionsResult.size());
    assertSame(json, fixedColumnDefinitionsResult.get(0));
    assertSame(builderResult, actualAddFixedColumnDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableReportGridColumnDefinitionsUpdateCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableReportGridColumnDefinitionsUpdateCommand.builder().build().derivedColumnDefinitions().isEmpty());
  }

  /**
   * Test Builder {@link Builder#derivedColumnDefinitions(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#derivedColumnDefinitions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder derivedColumnDefinitions(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.derivedColumnDefinitions(Iterable)"})
  void testBuilderDerivedColumnDefinitions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.derivedColumnDefinitions(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#fixedColumnDefinitions(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#fixedColumnDefinitions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder fixedColumnDefinitions(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.fixedColumnDefinitions(Iterable)"})
  void testBuilderFixedColumnDefinitions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.fixedColumnDefinitions(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(ReportGridColumnDefinitionsUpdateCommand)}.
   * <ul>
   *   <li>Given {@link ImmutableReportGridDerivedColumnDefinition.Json} (default constructor).</li>
   *   <li>Then build fixedColumnDefinitions first return {@link ImmutableReportGridFixedColumnDefinition.Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridColumnDefinitionsUpdateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridColumnDefinitionsUpdateCommand); given Json (default constructor); then build fixedColumnDefinitions first return Json")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridColumnDefinitionsUpdateCommand)"})
  void testBuilderFrom_givenJson_thenBuildFixedColumnDefinitionsFirstReturnJson() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand.builder();
    Builder builderResult2 = ImmutableReportGridColumnDefinitionsUpdateCommand.builder();
    ImmutableReportGridDerivedColumnDefinition.Json element = new ImmutableReportGridDerivedColumnDefinition.Json();
    builderResult2.addDerivedColumnDefinitions(element);
    ImmutableReportGridFixedColumnDefinition.Json element2 = new ImmutableReportGridFixedColumnDefinition.Json();
    builderResult2.addFixedColumnDefinitions(element2);
    ImmutableReportGridColumnDefinitionsUpdateCommand instance = builderResult2.build();

    // Act and Assert
    ImmutableReportGridColumnDefinitionsUpdateCommand buildResult = builderResult.from(instance).build();
    List<ReportGridFixedColumnDefinition> fixedColumnDefinitionsResult = buildResult.fixedColumnDefinitions();
    assertEquals(1, fixedColumnDefinitionsResult.size());
    ReportGridFixedColumnDefinition getResult = fixedColumnDefinitionsResult.get(0);
    assertTrue(getResult instanceof ImmutableReportGridFixedColumnDefinition.Json);
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult = buildResult.derivedColumnDefinitions();
    assertEquals(1, derivedColumnDefinitionsResult.size());
    assertSame(element, derivedColumnDefinitionsResult.get(0));
    assertSame(element2.externalId, ((ImmutableReportGridFixedColumnDefinition.Json) getResult).externalId);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridColumnDefinitionsUpdateCommand)}.
   * <ul>
   *   <li>Given {@link ImmutableReportGridFixedColumnDefinition.Json} (default constructor).</li>
   *   <li>Then builder build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridColumnDefinitionsUpdateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridColumnDefinitionsUpdateCommand); given Json (default constructor); then builder build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridColumnDefinitionsUpdateCommand)"})
  void testBuilderFrom_givenJson_thenBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand.builder();
    Builder builderResult2 = ImmutableReportGridColumnDefinitionsUpdateCommand.builder();
    ImmutableReportGridFixedColumnDefinition.Json element = new ImmutableReportGridFixedColumnDefinition.Json();
    builderResult2.addFixedColumnDefinitions(element);
    ImmutableReportGridColumnDefinitionsUpdateCommand instance = builderResult2.build();

    // Act and Assert
    List<ReportGridFixedColumnDefinition> fixedColumnDefinitionsResult = builderResult.from(instance)
        .build()
        .fixedColumnDefinitions();
    assertEquals(1, fixedColumnDefinitionsResult.size());
    assertEquals(instance, builderResult.build());
    assertSame(element, fixedColumnDefinitionsResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(ReportGridColumnDefinitionsUpdateCommand)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridColumnDefinitionsUpdateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridColumnDefinitionsUpdateCommand); when builder build; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridColumnDefinitionsUpdateCommand)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand.builder();
    ImmutableReportGridColumnDefinitionsUpdateCommand instance = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder()
        .build();

    // Act and Assert
    assertSame(builderResult, builderResult.from(instance));
  }

  /**
   * Test {@link ImmutableReportGridColumnDefinitionsUpdateCommand#copyOf(ReportGridColumnDefinitionsUpdateCommand)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return derivedColumnDefinitions Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableReportGridColumnDefinitionsUpdateCommand#copyOf(ReportGridColumnDefinitionsUpdateCommand)}
   */
  @Test
  @DisplayName("Test copyOf(ReportGridColumnDefinitionsUpdateCommand); when builder build; then return derivedColumnDefinitions Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableReportGridColumnDefinitionsUpdateCommand ImmutableReportGridColumnDefinitionsUpdateCommand.copyOf(ReportGridColumnDefinitionsUpdateCommand)"})
  void testCopyOf_whenBuilderBuild_thenReturnDerivedColumnDefinitionsEmpty() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand instance = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder()
        .build();

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand actualCopyOfResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .copyOf(instance);

    // Assert
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult = actualCopyOfResult
        .derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(derivedColumnDefinitionsResult, actualCopyOfResult.fixedColumnDefinitions());
  }

  /**
   * Test {@link ImmutableReportGridColumnDefinitionsUpdateCommand#equals(Object)}, and {@link ImmutableReportGridColumnDefinitionsUpdateCommand#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableReportGridColumnDefinitionsUpdateCommand#equals(Object)}
   *   <li>{@link ImmutableReportGridColumnDefinitionsUpdateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableReportGridColumnDefinitionsUpdateCommand.equals(Object)",
      "int ImmutableReportGridColumnDefinitionsUpdateCommand.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand buildResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder()
        .build();
    ImmutableReportGridColumnDefinitionsUpdateCommand buildResult2 = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder()
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridColumnDefinitionsUpdateCommand#equals(Object)}, and {@link ImmutableReportGridColumnDefinitionsUpdateCommand#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableReportGridColumnDefinitionsUpdateCommand#equals(Object)}
   *   <li>{@link ImmutableReportGridColumnDefinitionsUpdateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableReportGridColumnDefinitionsUpdateCommand.equals(Object)",
      "int ImmutableReportGridColumnDefinitionsUpdateCommand.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand buildResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder()
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridColumnDefinitionsUpdateCommand#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableReportGridColumnDefinitionsUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableReportGridColumnDefinitionsUpdateCommand.equals(Object)",
      "int ImmutableReportGridColumnDefinitionsUpdateCommand.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand.builder();
    builderResult.addFixedColumnDefinitions(new ImmutableReportGridFixedColumnDefinition.Json());
    ImmutableReportGridColumnDefinitionsUpdateCommand buildResult = builderResult.build();
    ImmutableReportGridColumnDefinitionsUpdateCommand buildResult2 = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder()
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableReportGridColumnDefinitionsUpdateCommand#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableReportGridColumnDefinitionsUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableReportGridColumnDefinitionsUpdateCommand.equals(Object)",
      "int ImmutableReportGridColumnDefinitionsUpdateCommand.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand.builder();
    builderResult.addDerivedColumnDefinitions(new ImmutableReportGridDerivedColumnDefinition.Json());
    ImmutableReportGridColumnDefinitionsUpdateCommand buildResult = builderResult.build();
    ImmutableReportGridColumnDefinitionsUpdateCommand buildResult2 = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder()
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableReportGridColumnDefinitionsUpdateCommand#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableReportGridColumnDefinitionsUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableReportGridColumnDefinitionsUpdateCommand.equals(Object)",
      "int ImmutableReportGridColumnDefinitionsUpdateCommand.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand buildResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder()
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableReportGridColumnDefinitionsUpdateCommand#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableReportGridColumnDefinitionsUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableReportGridColumnDefinitionsUpdateCommand.equals(Object)",
      "int ImmutableReportGridColumnDefinitionsUpdateCommand.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand buildResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder()
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableReportGridColumnDefinitionsUpdateCommand");
  }

  /**
   * Test {@link ImmutableReportGridColumnDefinitionsUpdateCommand#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableReportGridDerivedColumnDefinition.Json} (default constructor).</li>
   *   <li>Then return fixedColumnDefinitions Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableReportGridColumnDefinitionsUpdateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add Json (default constructor); then return fixedColumnDefinitions Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableReportGridColumnDefinitionsUpdateCommand ImmutableReportGridColumnDefinitionsUpdateCommand.fromJson(Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnFixedColumnDefinitionsEmpty() {
    // Arrange
    ArrayList<ReportGridDerivedColumnDefinition> derivedColumnDefinitions = new ArrayList<>();
    derivedColumnDefinitions.add(new ImmutableReportGridDerivedColumnDefinition.Json());

    Json json = new Json();
    json.setFixedColumnDefinitions(null);
    json.setDerivedColumnDefinitions(derivedColumnDefinitions);

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand actualFromJsonResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.fixedColumnDefinitions().isEmpty());
    assertEquals(derivedColumnDefinitions, actualFromJsonResult.derivedColumnDefinitions());
  }

  /**
   * Test {@link ImmutableReportGridColumnDefinitionsUpdateCommand#fromJson(Json)}.
   * <ul>
   *   <li>Then return fixedColumnDefinitions is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableReportGridColumnDefinitionsUpdateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return fixedColumnDefinitions is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableReportGridColumnDefinitionsUpdateCommand ImmutableReportGridColumnDefinitionsUpdateCommand.fromJson(Json)"})
  void testFromJson_thenReturnFixedColumnDefinitionsIsArrayList() {
    // Arrange
    ArrayList<ReportGridFixedColumnDefinition> fixedColumnDefinitions = new ArrayList<>();
    fixedColumnDefinitions.add(new ImmutableReportGridFixedColumnDefinition.Json());

    Json json = new Json();
    json.setFixedColumnDefinitions(fixedColumnDefinitions);
    json.setDerivedColumnDefinitions(null);

    // Act and Assert
    assertEquals(fixedColumnDefinitions,
        ImmutableReportGridColumnDefinitionsUpdateCommand.fromJson(json).fixedColumnDefinitions());
  }

  /**
   * Test {@link ImmutableReportGridColumnDefinitionsUpdateCommand#fromJson(Json)}.
   * <ul>
   *   <li>Then return fixedColumnDefinitions is derivedColumnDefinitions.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableReportGridColumnDefinitionsUpdateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return fixedColumnDefinitions is derivedColumnDefinitions")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableReportGridColumnDefinitionsUpdateCommand ImmutableReportGridColumnDefinitionsUpdateCommand.fromJson(Json)"})
  void testFromJson_thenReturnFixedColumnDefinitionsIsDerivedColumnDefinitions() {
    // Arrange
    Json json = new Json();
    json.setFixedColumnDefinitions(null);
    json.setDerivedColumnDefinitions(null);

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand actualFromJsonResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .fromJson(json);

    // Assert
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult = actualFromJsonResult
        .derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(derivedColumnDefinitionsResult, actualFromJsonResult.fixedColumnDefinitions());
  }

  /**
   * Test {@link ImmutableReportGridColumnDefinitionsUpdateCommand#fromJson(Json)}.
   * <ul>
   *   <li>Then return fixedColumnDefinitions is {@link Json} (default constructor) {@link Json#fixedColumnDefinitions}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableReportGridColumnDefinitionsUpdateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return fixedColumnDefinitions is Json (default constructor) fixedColumnDefinitions")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableReportGridColumnDefinitionsUpdateCommand ImmutableReportGridColumnDefinitionsUpdateCommand.fromJson(Json)"})
  void testFromJson_thenReturnFixedColumnDefinitionsIsJsonFixedColumnDefinitions() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand actualFromJsonResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.derivedColumnDefinitions().isEmpty());
    List<ReportGridFixedColumnDefinition> expectedFixedColumnDefinitionsResult = json.fixedColumnDefinitions;
    assertSame(expectedFixedColumnDefinitionsResult, actualFromJsonResult.fixedColumnDefinitions());
  }

  /**
   * Test {@link ImmutableReportGridColumnDefinitionsUpdateCommand#fromJson(Json)}.
   * <ul>
   *   <li>Then return fixedColumnDefinitions size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableReportGridColumnDefinitionsUpdateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return fixedColumnDefinitions size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableReportGridColumnDefinitionsUpdateCommand ImmutableReportGridColumnDefinitionsUpdateCommand.fromJson(Json)"})
  void testFromJson_thenReturnFixedColumnDefinitionsSizeIsTwo() {
    // Arrange
    ArrayList<ReportGridFixedColumnDefinition> reportGridFixedColumnDefinitionList = new ArrayList<>();
    reportGridFixedColumnDefinitionList.add(new ImmutableReportGridFixedColumnDefinition.Json());
    ImmutableReportGridFixedColumnDefinition.Json json = new ImmutableReportGridFixedColumnDefinition.Json();
    reportGridFixedColumnDefinitionList.add(json);
    COWArrayList<ReportGridFixedColumnDefinition> fixedColumnDefinitions = mock(COWArrayList.class);
    when(fixedColumnDefinitions.iterator()).thenReturn(reportGridFixedColumnDefinitionList.iterator());
    COWArrayList<ReportGridDerivedColumnDefinition> derivedColumnDefinitions = mock(COWArrayList.class);

    ArrayList<ReportGridDerivedColumnDefinition> reportGridDerivedColumnDefinitionList = new ArrayList<>();
    when(derivedColumnDefinitions.iterator()).thenReturn(reportGridDerivedColumnDefinitionList.iterator());

    Json json2 = new Json();
    json2.setFixedColumnDefinitions(fixedColumnDefinitions);
    json2.setDerivedColumnDefinitions(derivedColumnDefinitions);

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand actualFromJsonResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .fromJson(json2);

    // Assert
    verify(fixedColumnDefinitions).iterator();
    verify(derivedColumnDefinitions).iterator();
    List<ReportGridFixedColumnDefinition> fixedColumnDefinitionsResult = actualFromJsonResult.fixedColumnDefinitions();
    assertEquals(2, fixedColumnDefinitionsResult.size());
    assertSame(json, fixedColumnDefinitionsResult.get(1));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableReportGridColumnDefinitionsUpdateCommand#toString()}
   *   <li>{@link ImmutableReportGridColumnDefinitionsUpdateCommand#derivedColumnDefinitions()}
   *   <li>{@link ImmutableReportGridColumnDefinitionsUpdateCommand#fixedColumnDefinitions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ImmutableReportGridColumnDefinitionsUpdateCommand.derivedColumnDefinitions()",
      "List ImmutableReportGridColumnDefinitionsUpdateCommand.fixedColumnDefinitions()",
      "String ImmutableReportGridColumnDefinitionsUpdateCommand.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand buildResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder()
        .build();

    // Act
    String actualToStringResult = buildResult.toString();
    List<ReportGridDerivedColumnDefinition> actualDerivedColumnDefinitionsResult = buildResult
        .derivedColumnDefinitions();
    List<ReportGridFixedColumnDefinition> actualFixedColumnDefinitionsResult = buildResult.fixedColumnDefinitions();

    // Assert
    assertEquals("ReportGridColumnDefinitionsUpdateCommand{fixedColumnDefinitions=[], derivedColumnDefinitions=[]}",
        actualToStringResult);
    assertTrue(actualDerivedColumnDefinitionsResult.isEmpty());
    assertSame(actualDerivedColumnDefinitionsResult, actualFixedColumnDefinitionsResult);
  }

  /**
   * Test Json {@link Json#derivedColumnDefinitions()}.
   * <p>
   * Method under test: {@link Json#derivedColumnDefinitions()}
   */
  @Test
  @DisplayName("Test Json derivedColumnDefinitions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.derivedColumnDefinitions()"})
  void testJsonDerivedColumnDefinitions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).derivedColumnDefinitions());
  }

  /**
   * Test Json {@link Json#fixedColumnDefinitions()}.
   * <p>
   * Method under test: {@link Json#fixedColumnDefinitions()}
   */
  @Test
  @DisplayName("Test Json fixedColumnDefinitions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.fixedColumnDefinitions()"})
  void testJsonFixedColumnDefinitions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).fixedColumnDefinitions());
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
    assertTrue(actualJson.derivedColumnDefinitions.isEmpty());
    assertTrue(actualJson.fixedColumnDefinitions.isEmpty());
  }

  /**
   * Test {@link ImmutableReportGridColumnDefinitionsUpdateCommand#withDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[])} with {@code ReportGridDerivedColumnDefinition[]}.
   * <p>
   * Method under test: {@link ImmutableReportGridColumnDefinitionsUpdateCommand#withDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[])}
   */
  @Test
  @DisplayName("Test withDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[]) with 'ReportGridDerivedColumnDefinition[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableReportGridColumnDefinitionsUpdateCommand ImmutableReportGridColumnDefinitionsUpdateCommand.withDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[])"})
  void testWithDerivedColumnDefinitionsWithReportGridDerivedColumnDefinition() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand buildResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder()
        .build();
    ImmutableReportGridDerivedColumnDefinition.Json json = new ImmutableReportGridDerivedColumnDefinition.Json();

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand actualWithDerivedColumnDefinitionsResult = buildResult
        .withDerivedColumnDefinitions(json);

    // Assert
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult = actualWithDerivedColumnDefinitionsResult
        .derivedColumnDefinitions();
    assertEquals(1, derivedColumnDefinitionsResult.size());
    assertTrue(actualWithDerivedColumnDefinitionsResult.fixedColumnDefinitions().isEmpty());
    assertSame(json, derivedColumnDefinitionsResult.get(0));
  }

  /**
   * Test {@link ImmutableReportGridColumnDefinitionsUpdateCommand#withFixedColumnDefinitions(ReportGridFixedColumnDefinition[])} with {@code ReportGridFixedColumnDefinition[]}.
   * <p>
   * Method under test: {@link ImmutableReportGridColumnDefinitionsUpdateCommand#withFixedColumnDefinitions(ReportGridFixedColumnDefinition[])}
   */
  @Test
  @DisplayName("Test withFixedColumnDefinitions(ReportGridFixedColumnDefinition[]) with 'ReportGridFixedColumnDefinition[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableReportGridColumnDefinitionsUpdateCommand ImmutableReportGridColumnDefinitionsUpdateCommand.withFixedColumnDefinitions(ReportGridFixedColumnDefinition[])"})
  void testWithFixedColumnDefinitionsWithReportGridFixedColumnDefinition() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand buildResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder()
        .build();
    ImmutableReportGridFixedColumnDefinition.Json json = new ImmutableReportGridFixedColumnDefinition.Json();

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand actualWithFixedColumnDefinitionsResult = buildResult
        .withFixedColumnDefinitions(json);

    // Assert
    List<ReportGridFixedColumnDefinition> fixedColumnDefinitionsResult = actualWithFixedColumnDefinitionsResult
        .fixedColumnDefinitions();
    assertEquals(1, fixedColumnDefinitionsResult.size());
    assertTrue(actualWithFixedColumnDefinitionsResult.derivedColumnDefinitions().isEmpty());
    assertSame(json, fixedColumnDefinitionsResult.get(0));
  }
}
