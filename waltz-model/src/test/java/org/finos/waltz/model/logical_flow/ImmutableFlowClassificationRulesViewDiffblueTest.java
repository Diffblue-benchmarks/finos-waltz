package org.finos.waltz.model.logical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.flow_classification.FlowClassification;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRule;
import org.junit.jupiter.api.Test;

class ImmutableFlowClassificationRulesViewDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView.Builder#addAllDataTypes(Iterable)}
   */
  @Test
  void testBuilderAddAllDataTypes() {
    // Arrange
    ImmutableFlowClassificationRulesView.Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDataTypes(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView.Builder#addAllFlowClassificationRules(Iterable)}
   */
  @Test
  void testBuilderAddAllFlowClassificationRules() {
    // Arrange
    ImmutableFlowClassificationRulesView.Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllFlowClassificationRules(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView.Builder#addAllFlowClassifications(Iterable)}
   */
  @Test
  void testBuilderAddAllFlowClassifications() {
    // Arrange
    ImmutableFlowClassificationRulesView.Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllFlowClassifications(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView.Builder#addDataTypes(DataType)}
   */
  @Test
  void testBuilderAddDataTypes() {
    // Arrange
    ImmutableFlowClassificationRulesView.Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act
    ImmutableFlowClassificationRulesView.Builder actualAddDataTypesResult = builderResult
        .addDataTypes(mock(DataType.class));

    // Assert
    assertEquals(1, builderResult.build().dataTypes().size());
    assertSame(builderResult, actualAddDataTypesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView.Builder#addDataTypes(DataType[])}
   */
  @Test
  void testBuilderAddDataTypes2() {
    // Arrange
    ImmutableFlowClassificationRulesView.Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act
    ImmutableFlowClassificationRulesView.Builder actualAddDataTypesResult = builderResult
        .addDataTypes(mock(DataType.class));

    // Assert
    assertEquals(1, builderResult.build().dataTypes().size());
    assertSame(builderResult, actualAddDataTypesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView.Builder#addFlowClassificationRules(FlowClassificationRule)}
   */
  @Test
  void testBuilderAddFlowClassificationRules() {
    // Arrange
    ImmutableFlowClassificationRulesView.Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act
    ImmutableFlowClassificationRulesView.Builder actualAddFlowClassificationRulesResult = builderResult
        .addFlowClassificationRules(mock(FlowClassificationRule.class));

    // Assert
    assertEquals(1, builderResult.build().flowClassificationRules().size());
    assertSame(builderResult, actualAddFlowClassificationRulesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView.Builder#addFlowClassificationRules(FlowClassificationRule[])}
   */
  @Test
  void testBuilderAddFlowClassificationRules2() {
    // Arrange
    ImmutableFlowClassificationRulesView.Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act
    ImmutableFlowClassificationRulesView.Builder actualAddFlowClassificationRulesResult = builderResult
        .addFlowClassificationRules(mock(FlowClassificationRule.class));

    // Assert
    assertEquals(1, builderResult.build().flowClassificationRules().size());
    assertSame(builderResult, actualAddFlowClassificationRulesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView.Builder#addFlowClassifications(FlowClassification)}
   */
  @Test
  void testBuilderAddFlowClassifications() {
    // Arrange
    ImmutableFlowClassificationRulesView.Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act
    ImmutableFlowClassificationRulesView.Builder actualAddFlowClassificationsResult = builderResult
        .addFlowClassifications(mock(FlowClassification.class));

    // Assert
    assertEquals(1, builderResult.build().flowClassifications().size());
    assertSame(builderResult, actualAddFlowClassificationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView.Builder#addFlowClassifications(FlowClassification[])}
   */
  @Test
  void testBuilderAddFlowClassifications2() {
    // Arrange
    ImmutableFlowClassificationRulesView.Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act
    ImmutableFlowClassificationRulesView.Builder actualAddFlowClassificationsResult = builderResult
        .addFlowClassifications(mock(FlowClassification.class));

    // Assert
    assertEquals(1, builderResult.build().flowClassifications().size());
    assertSame(builderResult, actualAddFlowClassificationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableFlowClassificationRulesView.builder().build().dataTypes().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView.Builder#dataTypes(Iterable)}
   */
  @Test
  void testBuilderDataTypes() {
    // Arrange
    ImmutableFlowClassificationRulesView.Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypes(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView.Builder#flowClassificationRules(Iterable)}
   */
  @Test
  void testBuilderFlowClassificationRules() {
    // Arrange
    ImmutableFlowClassificationRulesView.Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.flowClassificationRules(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView.Builder#flowClassifications(Iterable)}
   */
  @Test
  void testBuilderFlowClassifications() {
    // Arrange
    ImmutableFlowClassificationRulesView.Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.flowClassifications(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView.Builder#from(FlowClassificationRulesView)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableFlowClassificationRulesView.Builder builderResult = ImmutableFlowClassificationRulesView.builder();
    FlowClassificationRulesView instance = mock(FlowClassificationRulesView.class);
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.flowClassificationRules()).thenReturn(new HashSet<>());
    when(instance.flowClassifications()).thenReturn(new HashSet<>());

    // Act
    ImmutableFlowClassificationRulesView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).flowClassifications();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView.Builder#from(FlowClassificationRulesView)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableFlowClassificationRulesView.Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    HashSet<DataType> dataTypeSet = new HashSet<>();
    dataTypeSet.add(mock(DataType.class));
    FlowClassificationRulesView instance = mock(FlowClassificationRulesView.class);
    when(instance.dataTypes()).thenReturn(dataTypeSet);
    when(instance.flowClassificationRules()).thenReturn(new HashSet<>());
    when(instance.flowClassifications()).thenReturn(new HashSet<>());

    // Act
    ImmutableFlowClassificationRulesView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).flowClassifications();
    assertEquals(1, builderResult.build().dataTypes().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView.Builder#from(FlowClassificationRulesView)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableFlowClassificationRulesView.Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    HashSet<FlowClassificationRule> flowClassificationRuleSet = new HashSet<>();
    flowClassificationRuleSet.add(mock(FlowClassificationRule.class));
    FlowClassificationRulesView instance = mock(FlowClassificationRulesView.class);
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.flowClassificationRules()).thenReturn(flowClassificationRuleSet);
    when(instance.flowClassifications()).thenReturn(new HashSet<>());

    // Act
    ImmutableFlowClassificationRulesView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).flowClassifications();
    assertEquals(1, builderResult.build().flowClassificationRules().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView.Builder#from(FlowClassificationRulesView)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableFlowClassificationRulesView.Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    HashSet<FlowClassification> flowClassificationSet = new HashSet<>();
    flowClassificationSet.add(mock(FlowClassification.class));
    FlowClassificationRulesView instance = mock(FlowClassificationRulesView.class);
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.flowClassificationRules()).thenReturn(new HashSet<>());
    when(instance.flowClassifications()).thenReturn(flowClassificationSet);

    // Act
    ImmutableFlowClassificationRulesView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).flowClassifications();
    assertEquals(1, builderResult.build().flowClassifications().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView#copyOf(FlowClassificationRulesView)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    FlowClassificationRulesView instance = mock(FlowClassificationRulesView.class);
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.flowClassificationRules()).thenReturn(new HashSet<>());
    when(instance.flowClassifications()).thenReturn(new HashSet<>());

    // Act
    ImmutableFlowClassificationRulesView actualCopyOfResult = ImmutableFlowClassificationRulesView.copyOf(instance);

    // Assert
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).flowClassifications();
    Set<DataType> dataTypesResult = actualCopyOfResult.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualCopyOfResult.flowClassificationRules());
    assertSame(dataTypesResult, actualCopyOfResult.flowClassifications());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView#copyOf(FlowClassificationRulesView)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<DataType> dataTypeSet = new HashSet<>();
    dataTypeSet.add(mock(DataType.class));
    FlowClassificationRulesView instance = mock(FlowClassificationRulesView.class);
    when(instance.dataTypes()).thenReturn(dataTypeSet);
    when(instance.flowClassificationRules()).thenReturn(new HashSet<>());
    when(instance.flowClassifications()).thenReturn(new HashSet<>());

    // Act
    ImmutableFlowClassificationRulesView actualCopyOfResult = ImmutableFlowClassificationRulesView.copyOf(instance);

    // Assert
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).flowClassifications();
    assertEquals(1, actualCopyOfResult.dataTypes().size());
    Set<FlowClassificationRule> flowClassificationRulesResult = actualCopyOfResult.flowClassificationRules();
    assertTrue(flowClassificationRulesResult.isEmpty());
    assertSame(flowClassificationRulesResult, actualCopyOfResult.flowClassifications());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView#copyOf(FlowClassificationRulesView)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<DataType> dataTypeSet = new HashSet<>();
    dataTypeSet.add(mock(DataType.class));
    dataTypeSet.add(mock(DataType.class));
    FlowClassificationRulesView instance = mock(FlowClassificationRulesView.class);
    when(instance.dataTypes()).thenReturn(dataTypeSet);
    when(instance.flowClassificationRules()).thenReturn(new HashSet<>());
    when(instance.flowClassifications()).thenReturn(new HashSet<>());

    // Act
    ImmutableFlowClassificationRulesView actualCopyOfResult = ImmutableFlowClassificationRulesView.copyOf(instance);

    // Assert
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).flowClassifications();
    Set<FlowClassificationRule> flowClassificationRulesResult = actualCopyOfResult.flowClassificationRules();
    assertTrue(flowClassificationRulesResult.isEmpty());
    assertEquals(dataTypeSet, actualCopyOfResult.dataTypes());
    assertSame(flowClassificationRulesResult, actualCopyOfResult.flowClassifications());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView#copyOf(FlowClassificationRulesView)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<FlowClassificationRule> flowClassificationRuleSet = new HashSet<>();
    flowClassificationRuleSet.add(mock(FlowClassificationRule.class));
    FlowClassificationRulesView instance = mock(FlowClassificationRulesView.class);
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.flowClassificationRules()).thenReturn(flowClassificationRuleSet);
    when(instance.flowClassifications()).thenReturn(new HashSet<>());

    // Act
    ImmutableFlowClassificationRulesView actualCopyOfResult = ImmutableFlowClassificationRulesView.copyOf(instance);

    // Assert
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).flowClassifications();
    assertEquals(1, actualCopyOfResult.flowClassificationRules().size());
    Set<DataType> dataTypesResult = actualCopyOfResult.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualCopyOfResult.flowClassifications());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView#copyOf(FlowClassificationRulesView)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    HashSet<FlowClassification> flowClassificationSet = new HashSet<>();
    flowClassificationSet.add(mock(FlowClassification.class));
    FlowClassificationRulesView instance = mock(FlowClassificationRulesView.class);
    when(instance.dataTypes()).thenReturn(new HashSet<>());
    when(instance.flowClassificationRules()).thenReturn(new HashSet<>());
    when(instance.flowClassifications()).thenReturn(flowClassificationSet);

    // Act
    ImmutableFlowClassificationRulesView actualCopyOfResult = ImmutableFlowClassificationRulesView.copyOf(instance);

    // Assert
    verify(instance).dataTypes();
    verify(instance).flowClassificationRules();
    verify(instance).flowClassifications();
    assertEquals(1, actualCopyOfResult.flowClassifications().size());
    Set<DataType> dataTypesResult = actualCopyOfResult.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualCopyOfResult.flowClassificationRules());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView#fromJson(ImmutableFlowClassificationRulesView.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableFlowClassificationRulesView.Json json = new ImmutableFlowClassificationRulesView.Json();

    // Act
    ImmutableFlowClassificationRulesView actualFromJsonResult = ImmutableFlowClassificationRulesView.fromJson(json);

    // Assert
    Set<DataType> dataTypesResult = actualFromJsonResult.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    Set<FlowClassification> flowClassificationSet = json.flowClassifications;
    assertSame(flowClassificationSet, dataTypesResult);
    assertSame(flowClassificationSet, actualFromJsonResult.flowClassificationRules());
    assertSame(flowClassificationSet, actualFromJsonResult.flowClassifications());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView#fromJson(ImmutableFlowClassificationRulesView.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableFlowClassificationRulesView.Json json = new ImmutableFlowClassificationRulesView.Json();
    json.setFlowClassificationRules(null);
    json.setFlowClassifications(null);
    json.setDataTypes(null);

    // Act
    ImmutableFlowClassificationRulesView actualFromJsonResult = ImmutableFlowClassificationRulesView.fromJson(json);

    // Assert
    Set<DataType> dataTypesResult = actualFromJsonResult.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualFromJsonResult.flowClassificationRules());
    assertSame(dataTypesResult, actualFromJsonResult.flowClassifications());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView#fromJson(ImmutableFlowClassificationRulesView.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<DataType> dataTypes = new LinkedHashSet<>();
    dataTypes.add(mock(DataType.class));

    ImmutableFlowClassificationRulesView.Json json = new ImmutableFlowClassificationRulesView.Json();
    json.setFlowClassificationRules(null);
    json.setFlowClassifications(null);
    json.setDataTypes(dataTypes);

    // Act
    ImmutableFlowClassificationRulesView actualFromJsonResult = ImmutableFlowClassificationRulesView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.dataTypes().size());
    Set<FlowClassificationRule> flowClassificationRulesResult = actualFromJsonResult.flowClassificationRules();
    assertTrue(flowClassificationRulesResult.isEmpty());
    assertSame(flowClassificationRulesResult, actualFromJsonResult.flowClassifications());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView#fromJson(ImmutableFlowClassificationRulesView.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    LinkedHashSet<FlowClassification> flowClassifications = new LinkedHashSet<>();
    flowClassifications.add(mock(FlowClassification.class));

    ImmutableFlowClassificationRulesView.Json json = new ImmutableFlowClassificationRulesView.Json();
    json.setFlowClassificationRules(null);
    json.setFlowClassifications(flowClassifications);
    json.setDataTypes(null);

    // Act
    ImmutableFlowClassificationRulesView actualFromJsonResult = ImmutableFlowClassificationRulesView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.flowClassifications().size());
    Set<DataType> dataTypesResult = actualFromJsonResult.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualFromJsonResult.flowClassificationRules());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView#fromJson(ImmutableFlowClassificationRulesView.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    LinkedHashSet<FlowClassificationRule> flowClassificationRules = new LinkedHashSet<>();
    flowClassificationRules.add(mock(FlowClassificationRule.class));

    ImmutableFlowClassificationRulesView.Json json = new ImmutableFlowClassificationRulesView.Json();
    json.setFlowClassificationRules(flowClassificationRules);
    json.setFlowClassifications(null);
    json.setDataTypes(null);

    // Act
    ImmutableFlowClassificationRulesView actualFromJsonResult = ImmutableFlowClassificationRulesView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.flowClassificationRules().size());
    Set<DataType> dataTypesResult = actualFromJsonResult.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualFromJsonResult.flowClassifications());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView.Json#dataTypes()}
   */
  @Test
  void testJsonDataTypes() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRulesView.Json()).dataTypes());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView.Json#flowClassificationRules()}
   */
  @Test
  void testJsonFlowClassificationRules() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRulesView.Json()).flowClassificationRules());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRulesView.Json#flowClassifications()}
   */
  @Test
  void testJsonFlowClassifications() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRulesView.Json()).flowClassifications());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableFlowClassificationRulesView.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableFlowClassificationRulesView.Json actualJson = new ImmutableFlowClassificationRulesView.Json();

    // Assert
    assertTrue(actualJson.dataTypes.isEmpty());
    assertTrue(actualJson.flowClassificationRules.isEmpty());
    assertTrue(actualJson.flowClassifications.isEmpty());
  }
}
