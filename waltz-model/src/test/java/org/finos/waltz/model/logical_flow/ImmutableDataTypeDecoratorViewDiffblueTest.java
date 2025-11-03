package org.finos.waltz.model.logical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.application.AssessmentsView;
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.datatype.DataTypeDecorator;
import org.finos.waltz.model.flow_classification.FlowClassification;
import org.finos.waltz.model.logical_flow.ImmutableDataTypeDecoratorView.Builder;
import org.finos.waltz.model.logical_flow.ImmutableDataTypeDecoratorView.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDataTypeDecoratorViewDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllClassifications(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllClassifications(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllClassifications(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllClassifications(Iterable)"})
  void testBuilderAddAllClassifications_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllClassifications(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllDataTypeDecorators(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllDataTypeDecorators(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllDataTypeDecorators(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllDataTypeDecorators(Iterable)"})
  void testBuilderAddAllDataTypeDecorators_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDataTypeDecorators(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllDataTypes(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllDataTypes(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllDataTypes(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllDataTypes(Iterable)"})
  void testBuilderAddAllDataTypes_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDataTypes(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addClassifications(FlowClassification)} with {@code element}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addClassifications(FlowClassification)}
   */
  @Test
  @DisplayName("Test Builder addClassifications(FlowClassification) with 'element'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addClassifications(FlowClassification)"})
  void testBuilderAddClassificationsWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addClassifications(mock(FlowClassification.class)));
  }

  /**
   * Test Builder {@link Builder#addClassifications(FlowClassification[])} with {@code elements}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addClassifications(FlowClassification[])}
   */
  @Test
  @DisplayName("Test Builder addClassifications(FlowClassification[]) with 'elements'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addClassifications(FlowClassification[])"})
  void testBuilderAddClassificationsWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addClassifications(mock(FlowClassification.class)));
  }

  /**
   * Test Builder {@link Builder#addDataTypeDecorators(DataTypeDecorator)} with {@code element}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addDataTypeDecorators(DataTypeDecorator)}
   */
  @Test
  @DisplayName("Test Builder addDataTypeDecorators(DataTypeDecorator) with 'element'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDataTypeDecorators(DataTypeDecorator)"})
  void testBuilderAddDataTypeDecoratorsWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDataTypeDecorators(mock(DataTypeDecorator.class)));
  }

  /**
   * Test Builder {@link Builder#addDataTypeDecorators(DataTypeDecorator[])} with {@code elements}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addDataTypeDecorators(DataTypeDecorator[])}
   */
  @Test
  @DisplayName("Test Builder addDataTypeDecorators(DataTypeDecorator[]) with 'elements'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDataTypeDecorators(DataTypeDecorator[])"})
  void testBuilderAddDataTypeDecoratorsWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDataTypeDecorators(mock(DataTypeDecorator.class)));
  }

  /**
   * Test Builder {@link Builder#addDataTypes(DataType)} with {@code element}.
   * <ul>
   *   <li>When {@link DataType}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addDataTypes(DataType)}
   */
  @Test
  @DisplayName("Test Builder addDataTypes(DataType) with 'element'; when DataType; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDataTypes(DataType)"})
  void testBuilderAddDataTypesWithElement_whenDataType_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDataTypes(mock(DataType.class)));
  }

  /**
   * Test Builder {@link Builder#addDataTypes(DataType[])} with {@code elements}.
   * <ul>
   *   <li>When {@link DataType}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addDataTypes(DataType[])}
   */
  @Test
  @DisplayName("Test Builder addDataTypes(DataType[]) with 'elements'; when DataType; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDataTypes(DataType[])"})
  void testBuilderAddDataTypesWithElements_whenDataType_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDataTypes(mock(DataType.class)));
  }

  /**
   * Test Builder {@link Builder#classifications(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#classifications(Iterable)}
   */
  @Test
  @DisplayName("Test Builder classifications(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.classifications(Iterable)"})
  void testBuilderClassifications_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.classifications(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#dataTypeDecorators(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#dataTypeDecorators(Iterable)}
   */
  @Test
  @DisplayName("Test Builder dataTypeDecorators(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.dataTypeDecorators(Iterable)"})
  void testBuilderDataTypeDecorators_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypeDecorators(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#dataTypes(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#dataTypes(Iterable)}
   */
  @Test
  @DisplayName("Test Builder dataTypes(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.dataTypes(Iterable)"})
  void testBuilderDataTypes_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypes(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#flowClassificationRules(FlowClassificationRulesView)}.
   * <ul>
   *   <li>When {@link ImmutableFlowClassificationRulesView.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#flowClassificationRules(FlowClassificationRulesView)}
   */
  @Test
  @DisplayName("Test Builder flowClassificationRules(FlowClassificationRulesView); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.flowClassificationRules(FlowClassificationRulesView)"})
  void testBuilderFlowClassificationRules_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.flowClassificationRules(new ImmutableFlowClassificationRulesView.Json()));
  }

  /**
   * Test Builder {@link Builder#from(DataTypeDecoratorView)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link DataType}.</li>
   *   <li>Then return build dataTypes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DataTypeDecoratorView)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeDecoratorView); given HashSet() add DataType; then return build dataTypes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataTypeDecoratorView)"})
  void testBuilderFrom_givenHashSetAddDataType_thenReturnBuildDataTypesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    HashSet<DataType> dataTypeSet = new HashSet<>();
    dataTypeSet.add(mock(DataType.class));
    DataTypeDecoratorView instance = mock(DataTypeDecoratorView.class);
    when(instance.flowClassificationRules()).thenReturn(new ImmutableFlowClassificationRulesView.Json());
    when(instance.classifications()).thenReturn(new HashSet<>());
    when(instance.dataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.dataTypes()).thenReturn(dataTypeSet);
    when(instance.primaryAssessments()).thenReturn(mock(AssessmentsView.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).classifications();
    verify(instance).dataTypeDecorators();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).primaryAssessments();
    assertEquals(1, actualFromResult.build().dataTypes().size());
    assertEquals(1, builderResult.build().dataTypes().size());
  }

  /**
   * Test Builder {@link Builder#from(DataTypeDecoratorView)}.
   * <ul>
   *   <li>Then build flowClassificationRules return {@link ImmutableFlowClassificationRulesView.Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DataTypeDecoratorView)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeDecoratorView); then build flowClassificationRules return Json")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataTypeDecoratorView)"})
  void testBuilderFrom_thenBuildFlowClassificationRulesReturnJson() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    HashSet<FlowClassification> flowClassificationSet = new HashSet<>();
    flowClassificationSet.add(mock(FlowClassification.class));
    DataTypeDecoratorView instance = mock(DataTypeDecoratorView.class);
    when(instance.flowClassificationRules()).thenReturn(new ImmutableFlowClassificationRulesView.Json());
    when(instance.classifications()).thenReturn(flowClassificationSet);
    when(instance.dataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.primaryAssessments()).thenReturn(mock(AssessmentsView.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).classifications();
    verify(instance).dataTypeDecorators();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).primaryAssessments();
    ImmutableDataTypeDecoratorView buildResult = actualFromResult.build();
    FlowClassificationRulesView flowClassificationRulesResult = buildResult.flowClassificationRules();
    assertTrue(flowClassificationRulesResult instanceof ImmutableFlowClassificationRulesView.Json);
    assertEquals(1, buildResult.classifications().size());
    assertEquals(1, builderResult.build().classifications().size());
    Set<DataTypeDecorator> dataTypeDecoratorsResult = buildResult.dataTypeDecorators();
    assertTrue(dataTypeDecoratorsResult.isEmpty());
    assertSame(dataTypeDecoratorsResult, buildResult.dataTypes());
    assertSame(dataTypeDecoratorsResult,
        ((ImmutableFlowClassificationRulesView.Json) flowClassificationRulesResult).dataTypes);
    assertSame(dataTypeDecoratorsResult,
        ((ImmutableFlowClassificationRulesView.Json) flowClassificationRulesResult).flowClassificationRules);
    assertSame(dataTypeDecoratorsResult,
        ((ImmutableFlowClassificationRulesView.Json) flowClassificationRulesResult).flowClassifications);
  }

  /**
   * Test Builder {@link Builder#from(DataTypeDecoratorView)}.
   * <ul>
   *   <li>Then return build dataTypeDecorators is {@link ImmutableFlowClassificationRulesView.Json} (default constructor) {@link ImmutableFlowClassificationRulesView.Json#flowClassifications}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DataTypeDecoratorView)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeDecoratorView); then return build dataTypeDecorators is Json (default constructor) flowClassifications")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataTypeDecoratorView)"})
  void testBuilderFrom_thenReturnBuildDataTypeDecoratorsIsJsonFlowClassifications() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();
    DataTypeDecoratorView instance = mock(DataTypeDecoratorView.class);
    ImmutableFlowClassificationRulesView.Json json = new ImmutableFlowClassificationRulesView.Json();
    when(instance.flowClassificationRules()).thenReturn(json);
    when(instance.classifications()).thenReturn(new HashSet<>());
    when(instance.dataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.primaryAssessments()).thenReturn(mock(AssessmentsView.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).classifications();
    verify(instance).dataTypeDecorators();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).primaryAssessments();
    Set<FlowClassification> expectedDataTypeDecoratorsResult = json.flowClassifications;
    assertSame(expectedDataTypeDecoratorsResult, actualFromResult.build().dataTypeDecorators());
  }

  /**
   * Test Builder {@link Builder#from(DataTypeDecoratorView)}.
   * <ul>
   *   <li>Then return build dataTypeDecorators size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DataTypeDecoratorView)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeDecoratorView); then return build dataTypeDecorators size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataTypeDecoratorView)"})
  void testBuilderFrom_thenReturnBuildDataTypeDecoratorsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    HashSet<DataTypeDecorator> dataTypeDecoratorSet = new HashSet<>();
    dataTypeDecoratorSet.add(mock(DataTypeDecorator.class));
    DataTypeDecoratorView instance = mock(DataTypeDecoratorView.class);
    when(instance.flowClassificationRules()).thenReturn(new ImmutableFlowClassificationRulesView.Json());
    when(instance.classifications()).thenReturn(new HashSet<>());
    when(instance.dataTypeDecorators()).thenReturn(dataTypeDecoratorSet);
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.primaryAssessments()).thenReturn(mock(AssessmentsView.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).classifications();
    verify(instance).dataTypeDecorators();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).primaryAssessments();
    assertEquals(1, actualFromResult.build().dataTypeDecorators().size());
    assertEquals(1, builderResult.build().dataTypeDecorators().size());
  }

  /**
   * Test Builder {@link Builder#from(DataTypeDecoratorView)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DataTypeDecoratorView)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeDecoratorView); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataTypeDecoratorView)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();
    DataTypeDecoratorView instance = mock(DataTypeDecoratorView.class);
    when(instance.flowClassificationRules()).thenThrow(new IllegalStateException("instance"));
    when(instance.classifications()).thenReturn(new HashSet<>());
    when(instance.dataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.primaryAssessments()).thenReturn(mock(AssessmentsView.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).classifications();
    verify(instance).dataTypeDecorators();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).primaryAssessments();
  }

  /**
   * Test Builder {@link Builder#primaryAssessments(AssessmentsView)}.
   * <p>
   * Method under test: {@link Builder#primaryAssessments(AssessmentsView)}
   */
  @Test
  @DisplayName("Test Builder primaryAssessments(AssessmentsView)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.primaryAssessments(AssessmentsView)"})
  void testBuilderPrimaryAssessments() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.primaryAssessments(mock(AssessmentsView.class)));
  }

  /**
   * Test Json {@link Json#classifications()}.
   * <p>
   * Method under test: {@link Json#classifications()}
   */
  @Test
  @DisplayName("Test Json classifications()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.classifications()"})
  void testJsonClassifications() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).classifications());
  }

  /**
   * Test Json {@link Json#dataTypeDecorators()}.
   * <p>
   * Method under test: {@link Json#dataTypeDecorators()}
   */
  @Test
  @DisplayName("Test Json dataTypeDecorators()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.dataTypeDecorators()"})
  void testJsonDataTypeDecorators() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).dataTypeDecorators());
  }

  /**
   * Test Json {@link Json#dataTypes()}.
   * <p>
   * Method under test: {@link Json#dataTypes()}
   */
  @Test
  @DisplayName("Test Json dataTypes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.dataTypes()"})
  void testJsonDataTypes() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).dataTypes());
  }

  /**
   * Test Json {@link Json#flowClassificationRules()}.
   * <p>
   * Method under test: {@link Json#flowClassificationRules()}
   */
  @Test
  @DisplayName("Test Json flowClassificationRules()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowClassificationRulesView Json.flowClassificationRules()"})
  void testJsonFlowClassificationRules() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).flowClassificationRules());
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
    assertNull(actualJson.primaryAssessments);
    assertNull(actualJson.flowClassificationRules);
    assertTrue(actualJson.classifications.isEmpty());
    assertTrue(actualJson.dataTypeDecorators.isEmpty());
    assertTrue(actualJson.dataTypes.isEmpty());
  }

  /**
   * Test Json {@link Json#primaryAssessments()}.
   * <p>
   * Method under test: {@link Json#primaryAssessments()}
   */
  @Test
  @DisplayName("Test Json primaryAssessments()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssessmentsView Json.primaryAssessments()"})
  void testJsonPrimaryAssessments() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).primaryAssessments());
  }
}
