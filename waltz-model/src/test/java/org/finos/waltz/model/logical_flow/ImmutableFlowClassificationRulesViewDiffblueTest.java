package org.finos.waltz.model.logical_flow;

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
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.flow_classification.FlowClassification;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRule;
import org.finos.waltz.model.logical_flow.ImmutableFlowClassificationRulesView.Builder;
import org.finos.waltz.model.logical_flow.ImmutableFlowClassificationRulesView.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowClassificationRulesViewDiffblueTest {
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
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDataTypes(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllFlowClassificationRules(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllFlowClassificationRules(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllFlowClassificationRules(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllFlowClassificationRules(Iterable)"})
  void testBuilderAddAllFlowClassificationRules_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllFlowClassificationRules(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllFlowClassifications(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllFlowClassifications(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllFlowClassifications(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllFlowClassifications(Iterable)"})
  void testBuilderAddAllFlowClassifications_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllFlowClassifications(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addDataTypes(DataType)} with {@code element}.
   * <ul>
   *   <li>Then builder build dataTypes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addDataTypes(DataType)}
   */
  @Test
  @DisplayName("Test Builder addDataTypes(DataType) with 'element'; then builder build dataTypes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDataTypes(DataType)"})
  void testBuilderAddDataTypesWithElement_thenBuilderBuildDataTypesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act
    Builder actualAddDataTypesResult = builderResult.addDataTypes(mock(DataType.class));

    // Assert
    assertEquals(1, builderResult.build().dataTypes().size());
    assertSame(builderResult, actualAddDataTypesResult);
  }

  /**
   * Test Builder {@link Builder#addDataTypes(DataType[])} with {@code elements}.
   * <ul>
   *   <li>Then builder build dataTypes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addDataTypes(DataType[])}
   */
  @Test
  @DisplayName("Test Builder addDataTypes(DataType[]) with 'elements'; then builder build dataTypes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDataTypes(DataType[])"})
  void testBuilderAddDataTypesWithElements_thenBuilderBuildDataTypesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act
    Builder actualAddDataTypesResult = builderResult.addDataTypes(mock(DataType.class));

    // Assert
    assertEquals(1, builderResult.build().dataTypes().size());
    assertSame(builderResult, actualAddDataTypesResult);
  }

  /**
   * Test Builder {@link Builder#addFlowClassificationRules(FlowClassificationRule)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addFlowClassificationRules(FlowClassificationRule)}
   */
  @Test
  @DisplayName("Test Builder addFlowClassificationRules(FlowClassificationRule) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addFlowClassificationRules(FlowClassificationRule)"})
  void testBuilderAddFlowClassificationRulesWithElement() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act
    Builder actualAddFlowClassificationRulesResult = builderResult
        .addFlowClassificationRules(mock(FlowClassificationRule.class));

    // Assert
    assertEquals(1, builderResult.build().flowClassificationRules().size());
    assertSame(builderResult, actualAddFlowClassificationRulesResult);
  }

  /**
   * Test Builder {@link Builder#addFlowClassificationRules(FlowClassificationRule[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addFlowClassificationRules(FlowClassificationRule[])}
   */
  @Test
  @DisplayName("Test Builder addFlowClassificationRules(FlowClassificationRule[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addFlowClassificationRules(FlowClassificationRule[])"})
  void testBuilderAddFlowClassificationRulesWithElements() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act
    Builder actualAddFlowClassificationRulesResult = builderResult
        .addFlowClassificationRules(mock(FlowClassificationRule.class));

    // Assert
    assertEquals(1, builderResult.build().flowClassificationRules().size());
    assertSame(builderResult, actualAddFlowClassificationRulesResult);
  }

  /**
   * Test Builder {@link Builder#addFlowClassifications(FlowClassification)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addFlowClassifications(FlowClassification)}
   */
  @Test
  @DisplayName("Test Builder addFlowClassifications(FlowClassification) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addFlowClassifications(FlowClassification)"})
  void testBuilderAddFlowClassificationsWithElement() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act
    Builder actualAddFlowClassificationsResult = builderResult.addFlowClassifications(mock(FlowClassification.class));

    // Assert
    assertEquals(1, builderResult.build().flowClassifications().size());
    assertSame(builderResult, actualAddFlowClassificationsResult);
  }

  /**
   * Test Builder {@link Builder#addFlowClassifications(FlowClassification[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addFlowClassifications(FlowClassification[])}
   */
  @Test
  @DisplayName("Test Builder addFlowClassifications(FlowClassification[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addFlowClassifications(FlowClassification[])"})
  void testBuilderAddFlowClassificationsWithElements() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act
    Builder actualAddFlowClassificationsResult = builderResult.addFlowClassifications(mock(FlowClassification.class));

    // Assert
    assertEquals(1, builderResult.build().flowClassifications().size());
    assertSame(builderResult, actualAddFlowClassificationsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFlowClassificationRulesView Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableFlowClassificationRulesView.builder().build().dataTypes().isEmpty());
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
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypes(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#flowClassificationRules(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#flowClassificationRules(Iterable)}
   */
  @Test
  @DisplayName("Test Builder flowClassificationRules(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.flowClassificationRules(Iterable)"})
  void testBuilderFlowClassificationRules_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.flowClassificationRules(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#flowClassifications(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#flowClassifications(Iterable)}
   */
  @Test
  @DisplayName("Test Builder flowClassifications(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.flowClassifications(Iterable)"})
  void testBuilderFlowClassifications_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.flowClassifications(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRulesView)}.
   * <ul>
   *   <li>Then return build dataTypes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowClassificationRulesView)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassificationRulesView); then return build dataTypes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRulesView)"})
  void testBuilderFrom_thenReturnBuildDataTypesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();
    Builder builderResult2 = ImmutableFlowClassificationRulesView.builder();
    builderResult2.addDataTypes(mock(DataType.class));
    builderResult2.addFlowClassificationRules(mock(FlowClassificationRule.class));
    ImmutableFlowClassificationRulesView instance = builderResult2.build();

    // Act and Assert
    ImmutableFlowClassificationRulesView buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.dataTypes().size());
    assertEquals(1, buildResult.flowClassificationRules().size());
    assertTrue(buildResult.flowClassifications().isEmpty());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRulesView)}.
   * <ul>
   *   <li>Then return build flowClassificationRules is build dataTypes.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowClassificationRulesView)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassificationRulesView); then return build flowClassificationRules is build dataTypes")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRulesView)"})
  void testBuilderFrom_thenReturnBuildFlowClassificationRulesIsBuildDataTypes() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();
    ImmutableFlowClassificationRulesView instance = ImmutableFlowClassificationRulesView.builder().build();

    // Act and Assert
    ImmutableFlowClassificationRulesView buildResult = builderResult.from(instance).build();
    Set<DataType> dataTypesResult = buildResult.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertEquals(instance, builderResult.build());
    assertSame(dataTypesResult, buildResult.flowClassificationRules());
    assertSame(dataTypesResult, buildResult.flowClassifications());
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRulesView)}.
   * <ul>
   *   <li>Then return build flowClassifications is build dataTypes.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowClassificationRulesView)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassificationRulesView); then return build flowClassifications is build dataTypes")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRulesView)"})
  void testBuilderFrom_thenReturnBuildFlowClassificationsIsBuildDataTypes() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();
    Builder builderResult2 = ImmutableFlowClassificationRulesView.builder();
    builderResult2.addFlowClassificationRules(mock(FlowClassificationRule.class));
    ImmutableFlowClassificationRulesView instance = builderResult2.build();

    // Act and Assert
    ImmutableFlowClassificationRulesView buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.flowClassificationRules().size());
    Set<DataType> dataTypesResult = buildResult.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertEquals(instance, builderResult.build());
    assertSame(dataTypesResult, buildResult.flowClassifications());
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRulesView)}.
   * <ul>
   *   <li>Then return build flowClassifications size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowClassificationRulesView)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassificationRulesView); then return build flowClassifications size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRulesView)"})
  void testBuilderFrom_thenReturnBuildFlowClassificationsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();
    Builder builderResult2 = ImmutableFlowClassificationRulesView.builder();
    builderResult2.addFlowClassifications(mock(FlowClassification.class));
    builderResult2.addFlowClassificationRules(mock(FlowClassificationRule.class));
    ImmutableFlowClassificationRulesView instance = builderResult2.build();

    // Act and Assert
    ImmutableFlowClassificationRulesView buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.flowClassificationRules().size());
    assertEquals(1, buildResult.flowClassifications().size());
    assertTrue(buildResult.dataTypes().isEmpty());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#copyOf(FlowClassificationRulesView)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return dataTypes Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRulesView#copyOf(FlowClassificationRulesView)}
   */
  @Test
  @DisplayName("Test copyOf(FlowClassificationRulesView); when builder build; then return dataTypes Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableFlowClassificationRulesView ImmutableFlowClassificationRulesView.copyOf(FlowClassificationRulesView)"})
  void testCopyOf_whenBuilderBuild_thenReturnDataTypesEmpty() {
    // Arrange
    ImmutableFlowClassificationRulesView instance = ImmutableFlowClassificationRulesView.builder().build();

    // Act
    ImmutableFlowClassificationRulesView actualCopyOfResult = ImmutableFlowClassificationRulesView.copyOf(instance);

    // Assert
    Set<DataType> dataTypesResult = actualCopyOfResult.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualCopyOfResult.flowClassificationRules());
    assertSame(dataTypesResult, actualCopyOfResult.flowClassifications());
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#equals(Object)}, and {@link ImmutableFlowClassificationRulesView#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRulesView#equals(Object)}
   *   <li>{@link ImmutableFlowClassificationRulesView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableFlowClassificationRulesView.equals(Object)",
      "int ImmutableFlowClassificationRulesView.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableFlowClassificationRulesView buildResult = ImmutableFlowClassificationRulesView.builder().build();
    ImmutableFlowClassificationRulesView buildResult2 = ImmutableFlowClassificationRulesView.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#equals(Object)}, and {@link ImmutableFlowClassificationRulesView#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRulesView#equals(Object)}
   *   <li>{@link ImmutableFlowClassificationRulesView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableFlowClassificationRulesView.equals(Object)",
      "int ImmutableFlowClassificationRulesView.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableFlowClassificationRulesView buildResult = ImmutableFlowClassificationRulesView.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRulesView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableFlowClassificationRulesView.equals(Object)",
      "int ImmutableFlowClassificationRulesView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();
    builderResult.addFlowClassificationRules(mock(FlowClassificationRule.class));
    ImmutableFlowClassificationRulesView buildResult = builderResult.build();
    ImmutableFlowClassificationRulesView buildResult2 = ImmutableFlowClassificationRulesView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRulesView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableFlowClassificationRulesView.equals(Object)",
      "int ImmutableFlowClassificationRulesView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();
    builderResult.addFlowClassifications(mock(FlowClassification.class));
    ImmutableFlowClassificationRulesView buildResult = builderResult.build();
    ImmutableFlowClassificationRulesView buildResult2 = ImmutableFlowClassificationRulesView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRulesView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableFlowClassificationRulesView.equals(Object)",
      "int ImmutableFlowClassificationRulesView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();
    builderResult.addDataTypes(mock(DataType.class));
    ImmutableFlowClassificationRulesView buildResult = builderResult.build();
    ImmutableFlowClassificationRulesView buildResult2 = ImmutableFlowClassificationRulesView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRulesView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableFlowClassificationRulesView.equals(Object)",
      "int ImmutableFlowClassificationRulesView.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableFlowClassificationRulesView buildResult = ImmutableFlowClassificationRulesView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRulesView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableFlowClassificationRulesView.equals(Object)",
      "int ImmutableFlowClassificationRulesView.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableFlowClassificationRulesView buildResult = ImmutableFlowClassificationRulesView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableFlowClassificationRulesView");
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link DataType}.</li>
   *   <li>Then return dataTypes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRulesView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given LinkedHashSet() add DataType; then return dataTypes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFlowClassificationRulesView ImmutableFlowClassificationRulesView.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddDataType_thenReturnDataTypesSizeIsOne() {
    // Arrange
    LinkedHashSet<DataType> dataTypes = new LinkedHashSet<>();
    dataTypes.add(mock(DataType.class));

    Json json = new Json();
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
   * Test {@link ImmutableFlowClassificationRulesView#fromJson(Json)}.
   * <ul>
   *   <li>Then return flowClassificationRules size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRulesView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return flowClassificationRules size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFlowClassificationRulesView ImmutableFlowClassificationRulesView.fromJson(Json)"})
  void testFromJson_thenReturnFlowClassificationRulesSizeIsOne() {
    // Arrange
    LinkedHashSet<FlowClassificationRule> flowClassificationRules = new LinkedHashSet<>();
    flowClassificationRules.add(mock(FlowClassificationRule.class));

    Json json = new Json();
    json.setFlowClassificationRules(flowClassificationRules);
    json.setFlowClassifications(null);
    json.setDataTypes(null);

    // Act and Assert
    assertEquals(1, ImmutableFlowClassificationRulesView.fromJson(json).flowClassificationRules().size());
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#fromJson(Json)}.
   * <ul>
   *   <li>Then return flowClassifications size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRulesView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return flowClassifications size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFlowClassificationRulesView ImmutableFlowClassificationRulesView.fromJson(Json)"})
  void testFromJson_thenReturnFlowClassificationsSizeIsOne() {
    // Arrange
    LinkedHashSet<FlowClassification> flowClassifications = new LinkedHashSet<>();
    flowClassifications.add(mock(FlowClassification.class));

    Json json = new Json();
    json.setFlowClassificationRules(null);
    json.setFlowClassifications(flowClassifications);
    json.setDataTypes(null);

    // Act and Assert
    assertEquals(1, ImmutableFlowClassificationRulesView.fromJson(json).flowClassifications().size());
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor) FlowClassificationRules is {@code null}.</li>
   *   <li>Then return dataTypes Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRulesView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor) FlowClassificationRules is 'null'; then return dataTypes Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFlowClassificationRulesView ImmutableFlowClassificationRulesView.fromJson(Json)"})
  void testFromJson_whenJsonFlowClassificationRulesIsNull_thenReturnDataTypesEmpty() {
    // Arrange
    Json json = new Json();
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
   * Test {@link ImmutableFlowClassificationRulesView#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return flowClassificationRules is {@link Json} (default constructor) {@link Json#flowClassifications}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRulesView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return flowClassificationRules is Json (default constructor) flowClassifications")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFlowClassificationRulesView ImmutableFlowClassificationRulesView.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnFlowClassificationRulesIsJsonFlowClassifications() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableFlowClassificationRulesView actualFromJsonResult = ImmutableFlowClassificationRulesView.fromJson(json);

    // Assert
    Set<FlowClassification> flowClassificationSet = json.flowClassifications;
    assertSame(flowClassificationSet, actualFromJsonResult.flowClassificationRules());
    assertSame(flowClassificationSet, actualFromJsonResult.flowClassifications());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRulesView#toString()}
   *   <li>{@link ImmutableFlowClassificationRulesView#dataTypes()}
   *   <li>{@link ImmutableFlowClassificationRulesView#flowClassificationRules()}
   *   <li>{@link ImmutableFlowClassificationRulesView#flowClassifications()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ImmutableFlowClassificationRulesView.dataTypes()",
      "Set ImmutableFlowClassificationRulesView.flowClassificationRules()",
      "Set ImmutableFlowClassificationRulesView.flowClassifications()",
      "String ImmutableFlowClassificationRulesView.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableFlowClassificationRulesView buildResult = ImmutableFlowClassificationRulesView.builder().build();

    // Act
    String actualToStringResult = buildResult.toString();
    Set<DataType> actualDataTypesResult = buildResult.dataTypes();
    Set<FlowClassificationRule> actualFlowClassificationRulesResult = buildResult.flowClassificationRules();
    Set<FlowClassification> actualFlowClassificationsResult = buildResult.flowClassifications();

    // Assert
    assertEquals("FlowClassificationRulesView{flowClassificationRules=[], flowClassifications=[], dataTypes=[]}",
        actualToStringResult);
    assertTrue(actualDataTypesResult.isEmpty());
    assertSame(actualDataTypesResult, actualFlowClassificationRulesResult);
    assertSame(actualDataTypesResult, actualFlowClassificationsResult);
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
  @MethodsUnderTest({"Set Json.flowClassificationRules()"})
  void testJsonFlowClassificationRules() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).flowClassificationRules());
  }

  /**
   * Test Json {@link Json#flowClassifications()}.
   * <p>
   * Method under test: {@link Json#flowClassifications()}
   */
  @Test
  @DisplayName("Test Json flowClassifications()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.flowClassifications()"})
  void testJsonFlowClassifications() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).flowClassifications());
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
    assertTrue(actualJson.dataTypes.isEmpty());
    assertTrue(actualJson.flowClassificationRules.isEmpty());
    assertTrue(actualJson.flowClassifications.isEmpty());
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#withDataTypes(DataType[])} with {@code DataType[]}.
   * <ul>
   *   <li>When {@link DataType}.</li>
   *   <li>Then return dataTypes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRulesView#withDataTypes(DataType[])}
   */
  @Test
  @DisplayName("Test withDataTypes(DataType[]) with 'DataType[]'; when DataType; then return dataTypes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableFlowClassificationRulesView ImmutableFlowClassificationRulesView.withDataTypes(DataType[])"})
  void testWithDataTypesWithDataType_whenDataType_thenReturnDataTypesSizeIsOne() {
    // Arrange
    ImmutableFlowClassificationRulesView buildResult = ImmutableFlowClassificationRulesView.builder().build();

    // Act
    ImmutableFlowClassificationRulesView actualWithDataTypesResult = buildResult.withDataTypes(mock(DataType.class));

    // Assert
    assertEquals(1, actualWithDataTypesResult.dataTypes().size());
    Set<FlowClassificationRule> flowClassificationRulesResult = actualWithDataTypesResult.flowClassificationRules();
    assertTrue(flowClassificationRulesResult.isEmpty());
    assertSame(flowClassificationRulesResult, actualWithDataTypesResult.flowClassifications());
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#withFlowClassificationRules(FlowClassificationRule[])} with {@code FlowClassificationRule[]}.
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRulesView#withFlowClassificationRules(FlowClassificationRule[])}
   */
  @Test
  @DisplayName("Test withFlowClassificationRules(FlowClassificationRule[]) with 'FlowClassificationRule[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableFlowClassificationRulesView ImmutableFlowClassificationRulesView.withFlowClassificationRules(FlowClassificationRule[])"})
  void testWithFlowClassificationRulesWithFlowClassificationRule() {
    // Arrange
    ImmutableFlowClassificationRulesView buildResult = ImmutableFlowClassificationRulesView.builder().build();

    // Act
    ImmutableFlowClassificationRulesView actualWithFlowClassificationRulesResult = buildResult
        .withFlowClassificationRules(mock(FlowClassificationRule.class));

    // Assert
    assertEquals(1, actualWithFlowClassificationRulesResult.flowClassificationRules().size());
    Set<DataType> dataTypesResult = actualWithFlowClassificationRulesResult.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualWithFlowClassificationRulesResult.flowClassifications());
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#withFlowClassifications(FlowClassification[])} with {@code FlowClassification[]}.
   * <p>
   * Method under test: {@link ImmutableFlowClassificationRulesView#withFlowClassifications(FlowClassification[])}
   */
  @Test
  @DisplayName("Test withFlowClassifications(FlowClassification[]) with 'FlowClassification[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableFlowClassificationRulesView ImmutableFlowClassificationRulesView.withFlowClassifications(FlowClassification[])"})
  void testWithFlowClassificationsWithFlowClassification() {
    // Arrange
    ImmutableFlowClassificationRulesView buildResult = ImmutableFlowClassificationRulesView.builder().build();

    // Act
    ImmutableFlowClassificationRulesView actualWithFlowClassificationsResult = buildResult
        .withFlowClassifications(mock(FlowClassification.class));

    // Assert
    assertEquals(1, actualWithFlowClassificationsResult.flowClassifications().size());
    Set<DataType> dataTypesResult = actualWithFlowClassificationsResult.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualWithFlowClassificationsResult.flowClassificationRules());
  }
}
