package org.finos.waltz.model.logical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.application.AssessmentsView;
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.datatype.DataTypeDecorator;
import org.finos.waltz.model.flow_classification.FlowClassification;
import org.junit.jupiter.api.Test;

class ImmutableDataTypeDecoratorViewDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView.Builder#addAllClassifications(Iterable)}
   */
  @Test
  void testBuilderAddAllClassifications() {
    // Arrange
    ImmutableDataTypeDecoratorView.Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllClassifications(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView.Builder#addAllDataTypeDecorators(Iterable)}
   */
  @Test
  void testBuilderAddAllDataTypeDecorators() {
    // Arrange
    ImmutableDataTypeDecoratorView.Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDataTypeDecorators(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView.Builder#addAllDataTypes(Iterable)}
   */
  @Test
  void testBuilderAddAllDataTypes() {
    // Arrange
    ImmutableDataTypeDecoratorView.Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDataTypes(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView.Builder#addClassifications(FlowClassification)}
   */
  @Test
  void testBuilderAddClassifications() {
    // Arrange
    ImmutableDataTypeDecoratorView.Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addClassifications(mock(FlowClassification.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView.Builder#addClassifications(FlowClassification[])}
   */
  @Test
  void testBuilderAddClassifications2() {
    // Arrange
    ImmutableDataTypeDecoratorView.Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addClassifications(mock(FlowClassification.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView.Builder#addDataTypeDecorators(DataTypeDecorator)}
   */
  @Test
  void testBuilderAddDataTypeDecorators() {
    // Arrange
    ImmutableDataTypeDecoratorView.Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDataTypeDecorators(mock(DataTypeDecorator.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView.Builder#addDataTypeDecorators(DataTypeDecorator[])}
   */
  @Test
  void testBuilderAddDataTypeDecorators2() {
    // Arrange
    ImmutableDataTypeDecoratorView.Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDataTypeDecorators(mock(DataTypeDecorator.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView.Builder#addDataTypes(DataType)}
   */
  @Test
  void testBuilderAddDataTypes() {
    // Arrange
    ImmutableDataTypeDecoratorView.Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDataTypes(mock(DataType.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView.Builder#addDataTypes(DataType[])}
   */
  @Test
  void testBuilderAddDataTypes2() {
    // Arrange
    ImmutableDataTypeDecoratorView.Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDataTypes(mock(DataType.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView.Builder#classifications(Iterable)}
   */
  @Test
  void testBuilderClassifications() {
    // Arrange
    ImmutableDataTypeDecoratorView.Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.classifications(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView.Builder#dataTypeDecorators(Iterable)}
   */
  @Test
  void testBuilderDataTypeDecorators() {
    // Arrange
    ImmutableDataTypeDecoratorView.Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypeDecorators(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView.Builder#dataTypes(Iterable)}
   */
  @Test
  void testBuilderDataTypes() {
    // Arrange
    ImmutableDataTypeDecoratorView.Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypes(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView.Builder#flowClassificationRules(FlowClassificationRulesView)}
   */
  @Test
  void testBuilderFlowClassificationRules() {
    // Arrange
    ImmutableDataTypeDecoratorView.Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.flowClassificationRules(new ImmutableFlowClassificationRulesView.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView.Builder#flowClassificationRules(FlowClassificationRulesView)}
   */
  @Test
  void testBuilderFlowClassificationRules2() {
    // Arrange
    ImmutableDataTypeDecoratorView.Builder builderResult = ImmutableDataTypeDecoratorView.builder();
    builderResult.addDataTypeDecorators(mock(DataTypeDecorator.class));

    // Act and Assert
    assertSame(builderResult, builderResult.flowClassificationRules(new ImmutableFlowClassificationRulesView.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView.Builder#from(DataTypeDecoratorView)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableDataTypeDecoratorView.Builder builderResult = ImmutableDataTypeDecoratorView.builder();
    DataTypeDecoratorView instance = mock(DataTypeDecoratorView.class);
    ImmutableFlowClassificationRulesView.Json json = new ImmutableFlowClassificationRulesView.Json();
    when(instance.flowClassificationRules()).thenReturn(json);
    when(instance.classifications()).thenReturn(new HashSet<>());
    when(instance.dataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.primaryAssessments()).thenReturn(mock(AssessmentsView.class));

    // Act
    ImmutableDataTypeDecoratorView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).classifications();
    verify(instance).dataTypeDecorators();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).primaryAssessments();
    ImmutableDataTypeDecoratorView buildResult = builderResult.build();
    assertSame(json, buildResult.flowClassificationRules());
    assertSame(builderResult, actualFromResult);
    Set<FlowClassification> flowClassificationSet = json.flowClassifications;
    assertSame(flowClassificationSet, buildResult.classifications());
    assertSame(flowClassificationSet, buildResult.dataTypeDecorators());
    assertSame(flowClassificationSet, buildResult.dataTypes());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView.Builder#from(DataTypeDecoratorView)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableDataTypeDecoratorView.Builder builderResult = ImmutableDataTypeDecoratorView.builder();
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
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView.Builder#from(DataTypeDecoratorView)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableDataTypeDecoratorView.Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    HashSet<FlowClassification> flowClassificationSet = new HashSet<>();
    flowClassificationSet.add(mock(FlowClassification.class));
    DataTypeDecoratorView instance = mock(DataTypeDecoratorView.class);
    ImmutableFlowClassificationRulesView.Json json = new ImmutableFlowClassificationRulesView.Json();
    when(instance.flowClassificationRules()).thenReturn(json);
    when(instance.classifications()).thenReturn(flowClassificationSet);
    when(instance.dataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.primaryAssessments()).thenReturn(mock(AssessmentsView.class));

    // Act
    ImmutableDataTypeDecoratorView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).classifications();
    verify(instance).dataTypeDecorators();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).primaryAssessments();
    ImmutableDataTypeDecoratorView buildResult = builderResult.build();
    assertEquals(1, buildResult.classifications().size());
    assertSame(json, buildResult.flowClassificationRules());
    assertSame(builderResult, actualFromResult);
    Set<FlowClassification> flowClassificationSet2 = json.flowClassifications;
    assertSame(flowClassificationSet2, buildResult.dataTypeDecorators());
    assertSame(flowClassificationSet2, buildResult.dataTypes());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView.Builder#from(DataTypeDecoratorView)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableDataTypeDecoratorView.Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    HashSet<DataTypeDecorator> dataTypeDecoratorSet = new HashSet<>();
    dataTypeDecoratorSet.add(mock(DataTypeDecorator.class));
    DataTypeDecoratorView instance = mock(DataTypeDecoratorView.class);
    ImmutableFlowClassificationRulesView.Json json = new ImmutableFlowClassificationRulesView.Json();
    when(instance.flowClassificationRules()).thenReturn(json);
    when(instance.classifications()).thenReturn(new HashSet<>());
    when(instance.dataTypeDecorators()).thenReturn(dataTypeDecoratorSet);
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.primaryAssessments()).thenReturn(mock(AssessmentsView.class));

    // Act
    ImmutableDataTypeDecoratorView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).classifications();
    verify(instance).dataTypeDecorators();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).primaryAssessments();
    ImmutableDataTypeDecoratorView buildResult = builderResult.build();
    assertEquals(1, buildResult.dataTypeDecorators().size());
    assertSame(json, buildResult.flowClassificationRules());
    assertSame(builderResult, actualFromResult);
    Set<FlowClassification> flowClassificationSet = json.flowClassifications;
    assertSame(flowClassificationSet, buildResult.classifications());
    assertSame(flowClassificationSet, buildResult.dataTypes());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView.Builder#from(DataTypeDecoratorView)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableDataTypeDecoratorView.Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    HashSet<DataType> dataTypeSet = new HashSet<>();
    dataTypeSet.add(mock(DataType.class));
    DataTypeDecoratorView instance = mock(DataTypeDecoratorView.class);
    ImmutableFlowClassificationRulesView.Json json = new ImmutableFlowClassificationRulesView.Json();
    when(instance.flowClassificationRules()).thenReturn(json);
    when(instance.classifications()).thenReturn(new HashSet<>());
    when(instance.dataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.dataTypes()).thenReturn(dataTypeSet);
    when(instance.primaryAssessments()).thenReturn(mock(AssessmentsView.class));

    // Act
    ImmutableDataTypeDecoratorView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).classifications();
    verify(instance).dataTypeDecorators();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).primaryAssessments();
    ImmutableDataTypeDecoratorView buildResult = builderResult.build();
    assertEquals(1, buildResult.dataTypes().size());
    assertSame(json, buildResult.flowClassificationRules());
    assertSame(builderResult, actualFromResult);
    Set<FlowClassification> flowClassificationSet = json.flowClassifications;
    assertSame(flowClassificationSet, buildResult.classifications());
    assertSame(flowClassificationSet, buildResult.dataTypeDecorators());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView.Builder#primaryAssessments(AssessmentsView)}
   */
  @Test
  void testBuilderPrimaryAssessments() {
    // Arrange
    ImmutableDataTypeDecoratorView.Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.primaryAssessments(mock(AssessmentsView.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView#copyOf(DataTypeDecoratorView)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    DataTypeDecoratorView instance = mock(DataTypeDecoratorView.class);
    ImmutableFlowClassificationRulesView.Json json = new ImmutableFlowClassificationRulesView.Json();
    when(instance.flowClassificationRules()).thenReturn(json);
    when(instance.classifications()).thenReturn(new HashSet<>());
    when(instance.dataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.primaryAssessments()).thenReturn(mock(AssessmentsView.class));

    // Act
    ImmutableDataTypeDecoratorView actualCopyOfResult = ImmutableDataTypeDecoratorView.copyOf(instance);

    // Assert
    verify(instance).classifications();
    verify(instance).dataTypeDecorators();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).primaryAssessments();
    Set<FlowClassification> classificationsResult = actualCopyOfResult.classifications();
    assertTrue(classificationsResult.isEmpty());
    assertSame(json, actualCopyOfResult.flowClassificationRules());
    Set<FlowClassification> flowClassificationSet = json.flowClassifications;
    assertSame(flowClassificationSet, classificationsResult);
    assertSame(flowClassificationSet, actualCopyOfResult.dataTypeDecorators());
    assertSame(flowClassificationSet, actualCopyOfResult.dataTypes());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView#copyOf(DataTypeDecoratorView)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<FlowClassification> flowClassificationSet = new HashSet<>();
    flowClassificationSet.add(mock(FlowClassification.class));
    DataTypeDecoratorView instance = mock(DataTypeDecoratorView.class);
    ImmutableFlowClassificationRulesView.Json json = new ImmutableFlowClassificationRulesView.Json();
    when(instance.flowClassificationRules()).thenReturn(json);
    when(instance.classifications()).thenReturn(flowClassificationSet);
    when(instance.dataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.primaryAssessments()).thenReturn(mock(AssessmentsView.class));

    // Act
    ImmutableDataTypeDecoratorView actualCopyOfResult = ImmutableDataTypeDecoratorView.copyOf(instance);

    // Assert
    verify(instance).classifications();
    verify(instance).dataTypeDecorators();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).primaryAssessments();
    assertEquals(1, actualCopyOfResult.classifications().size());
    Set<DataTypeDecorator> dataTypeDecoratorsResult = actualCopyOfResult.dataTypeDecorators();
    assertTrue(dataTypeDecoratorsResult.isEmpty());
    assertSame(json, actualCopyOfResult.flowClassificationRules());
    Set<FlowClassification> flowClassificationSet2 = json.flowClassifications;
    assertSame(flowClassificationSet2, dataTypeDecoratorsResult);
    assertSame(flowClassificationSet2, actualCopyOfResult.dataTypes());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView#copyOf(DataTypeDecoratorView)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<FlowClassification> flowClassificationSet = new HashSet<>();
    flowClassificationSet.add(mock(FlowClassification.class));
    flowClassificationSet.add(mock(FlowClassification.class));
    DataTypeDecoratorView instance = mock(DataTypeDecoratorView.class);
    ImmutableFlowClassificationRulesView.Json json = new ImmutableFlowClassificationRulesView.Json();
    when(instance.flowClassificationRules()).thenReturn(json);
    when(instance.classifications()).thenReturn(flowClassificationSet);
    when(instance.dataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.primaryAssessments()).thenReturn(mock(AssessmentsView.class));

    // Act
    ImmutableDataTypeDecoratorView actualCopyOfResult = ImmutableDataTypeDecoratorView.copyOf(instance);

    // Assert
    verify(instance).classifications();
    verify(instance).dataTypeDecorators();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).primaryAssessments();
    Set<DataTypeDecorator> dataTypeDecoratorsResult = actualCopyOfResult.dataTypeDecorators();
    assertTrue(dataTypeDecoratorsResult.isEmpty());
    assertEquals(flowClassificationSet, actualCopyOfResult.classifications());
    assertSame(json, actualCopyOfResult.flowClassificationRules());
    Set<FlowClassification> flowClassificationSet2 = json.flowClassifications;
    assertSame(flowClassificationSet2, dataTypeDecoratorsResult);
    assertSame(flowClassificationSet2, actualCopyOfResult.dataTypes());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView#copyOf(DataTypeDecoratorView)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<DataTypeDecorator> dataTypeDecoratorSet = new HashSet<>();
    dataTypeDecoratorSet.add(mock(DataTypeDecorator.class));
    DataTypeDecoratorView instance = mock(DataTypeDecoratorView.class);
    ImmutableFlowClassificationRulesView.Json json = new ImmutableFlowClassificationRulesView.Json();
    when(instance.flowClassificationRules()).thenReturn(json);
    when(instance.classifications()).thenReturn(new HashSet<>());
    when(instance.dataTypeDecorators()).thenReturn(dataTypeDecoratorSet);
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.primaryAssessments()).thenReturn(mock(AssessmentsView.class));

    // Act
    ImmutableDataTypeDecoratorView actualCopyOfResult = ImmutableDataTypeDecoratorView.copyOf(instance);

    // Assert
    verify(instance).classifications();
    verify(instance).dataTypeDecorators();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).primaryAssessments();
    assertEquals(1, actualCopyOfResult.dataTypeDecorators().size());
    Set<FlowClassification> classificationsResult = actualCopyOfResult.classifications();
    assertTrue(classificationsResult.isEmpty());
    assertSame(json, actualCopyOfResult.flowClassificationRules());
    Set<FlowClassification> flowClassificationSet = json.flowClassifications;
    assertSame(flowClassificationSet, classificationsResult);
    assertSame(flowClassificationSet, actualCopyOfResult.dataTypes());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView#copyOf(DataTypeDecoratorView)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    HashSet<DataType> dataTypeSet = new HashSet<>();
    dataTypeSet.add(mock(DataType.class));
    DataTypeDecoratorView instance = mock(DataTypeDecoratorView.class);
    ImmutableFlowClassificationRulesView.Json json = new ImmutableFlowClassificationRulesView.Json();
    when(instance.flowClassificationRules()).thenReturn(json);
    when(instance.classifications()).thenReturn(new HashSet<>());
    when(instance.dataTypeDecorators()).thenReturn(new HashSet<>());
    when(instance.dataTypes()).thenReturn(dataTypeSet);
    when(instance.primaryAssessments()).thenReturn(mock(AssessmentsView.class));

    // Act
    ImmutableDataTypeDecoratorView actualCopyOfResult = ImmutableDataTypeDecoratorView.copyOf(instance);

    // Assert
    verify(instance).classifications();
    verify(instance).dataTypeDecorators();
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).primaryAssessments();
    assertEquals(1, actualCopyOfResult.dataTypes().size());
    Set<FlowClassification> classificationsResult = actualCopyOfResult.classifications();
    assertTrue(classificationsResult.isEmpty());
    assertSame(json, actualCopyOfResult.flowClassificationRules());
    Set<FlowClassification> flowClassificationSet = json.flowClassifications;
    assertSame(flowClassificationSet, classificationsResult);
    assertSame(flowClassificationSet, actualCopyOfResult.dataTypeDecorators());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView#fromJson(ImmutableDataTypeDecoratorView.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableDataTypeDecoratorView.Json json = new ImmutableDataTypeDecoratorView.Json();
    json.setDataTypeDecorators(null);
    json.setDataTypes(null);
    json.setClassifications(null);
    json.setPrimaryAssessments(mock(AssessmentsView.class));
    ImmutableFlowClassificationRulesView.Json flowClassificationRules = new ImmutableFlowClassificationRulesView.Json();
    json.setFlowClassificationRules(flowClassificationRules);

    // Act
    ImmutableDataTypeDecoratorView actualFromJsonResult = ImmutableDataTypeDecoratorView.fromJson(json);

    // Assert
    Set<FlowClassification> classificationsResult = actualFromJsonResult.classifications();
    assertTrue(classificationsResult.isEmpty());
    assertSame(flowClassificationRules, actualFromJsonResult.flowClassificationRules());
    AssessmentsView expectedPrimaryAssessmentsResult = json.primaryAssessments;
    assertSame(expectedPrimaryAssessmentsResult, actualFromJsonResult.primaryAssessments());
    Set<FlowClassification> flowClassificationSet = flowClassificationRules.flowClassifications;
    assertSame(flowClassificationSet, classificationsResult);
    assertSame(flowClassificationSet, actualFromJsonResult.dataTypeDecorators());
    assertSame(flowClassificationSet, actualFromJsonResult.dataTypes());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView#fromJson(ImmutableDataTypeDecoratorView.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<FlowClassification> classifications = new LinkedHashSet<>();
    classifications.add(mock(FlowClassification.class));

    ImmutableDataTypeDecoratorView.Json json = new ImmutableDataTypeDecoratorView.Json();
    json.setDataTypeDecorators(null);
    json.setDataTypes(null);
    json.setClassifications(classifications);
    json.setPrimaryAssessments(mock(AssessmentsView.class));
    ImmutableFlowClassificationRulesView.Json flowClassificationRules = new ImmutableFlowClassificationRulesView.Json();
    json.setFlowClassificationRules(flowClassificationRules);

    // Act
    ImmutableDataTypeDecoratorView actualFromJsonResult = ImmutableDataTypeDecoratorView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.classifications().size());
    Set<DataTypeDecorator> dataTypeDecoratorsResult = actualFromJsonResult.dataTypeDecorators();
    assertTrue(dataTypeDecoratorsResult.isEmpty());
    assertSame(flowClassificationRules, actualFromJsonResult.flowClassificationRules());
    AssessmentsView expectedPrimaryAssessmentsResult = json.primaryAssessments;
    assertSame(expectedPrimaryAssessmentsResult, actualFromJsonResult.primaryAssessments());
    Set<FlowClassification> flowClassificationSet = flowClassificationRules.flowClassifications;
    assertSame(flowClassificationSet, dataTypeDecoratorsResult);
    assertSame(flowClassificationSet, actualFromJsonResult.dataTypes());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView.Json#classifications()}
   */
  @Test
  void testJsonClassifications() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDataTypeDecoratorView.Json()).classifications());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView.Json#dataTypeDecorators()}
   */
  @Test
  void testJsonDataTypeDecorators() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDataTypeDecoratorView.Json()).dataTypeDecorators());
  }

  /**
   * Method under test: {@link ImmutableDataTypeDecoratorView.Json#dataTypes()}
   */
  @Test
  void testJsonDataTypes() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDataTypeDecoratorView.Json()).dataTypes());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView.Json#flowClassificationRules()}
   */
  @Test
  void testJsonFlowClassificationRules() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDataTypeDecoratorView.Json()).flowClassificationRules());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableDataTypeDecoratorView.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableDataTypeDecoratorView.Json actualJson = new ImmutableDataTypeDecoratorView.Json();

    // Assert
    assertNull(actualJson.primaryAssessments);
    assertNull(actualJson.flowClassificationRules);
    assertTrue(actualJson.classifications.isEmpty());
    assertTrue(actualJson.dataTypeDecorators.isEmpty());
    assertTrue(actualJson.dataTypes.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorView.Json#primaryAssessments()}
   */
  @Test
  void testJsonPrimaryAssessments() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDataTypeDecoratorView.Json()).primaryAssessments());
  }
}
