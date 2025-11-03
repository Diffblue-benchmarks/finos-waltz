package org.finos.waltz.model.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowCreateCommand.Builder;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowCreateCommand.Json;
import org.finos.waltz.model.physical_specification.PhysicalSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowCreateCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllDataTypeIds(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllDataTypeIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllDataTypeIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllDataTypeIds(Iterable)"})
  void testBuilderAddAllDataTypeIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDataTypeIds(elements));
  }

  /**
   * Test Builder {@link Builder#addAllDataTypeIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllDataTypeIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllDataTypeIds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllDataTypeIds(Iterable)"})
  void testBuilderAddAllDataTypeIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDataTypeIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addDataTypeIds(long)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addDataTypeIds(long)}
   */
  @Test
  @DisplayName("Test Builder addDataTypeIds(long) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDataTypeIds(long)"})
  void testBuilderAddDataTypeIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDataTypeIds(1L));
  }

  /**
   * Test Builder {@link Builder#addDataTypeIds(long[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addDataTypeIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addDataTypeIds(long[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDataTypeIds(long[])"})
  void testBuilderAddDataTypeIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDataTypeIds(1L, -5L, 1L, -5L));
  }

  /**
   * Test Builder {@link Builder#dataTypeIds(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#dataTypeIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder dataTypeIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.dataTypeIds(Iterable)"})
  void testBuilderDataTypeIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypeIds(elements));
  }

  /**
   * Test Builder {@link Builder#dataTypeIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#dataTypeIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder dataTypeIds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.dataTypeIds(Iterable)"})
  void testBuilderDataTypeIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypeIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#flowAttributes(FlowAttributes)}.
   * <ul>
   *   <li>When {@link ImmutableFlowAttributes.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#flowAttributes(FlowAttributes)}
   */
  @Test
  @DisplayName("Test Builder flowAttributes(FlowAttributes); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.flowAttributes(FlowAttributes)"})
  void testBuilderFlowAttributes_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.flowAttributes(new ImmutableFlowAttributes.Json()));
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowCreateCommand)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add minus two.</li>
   *   <li>Then return build dataTypeIds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowCreateCommand); given HashSet() add minus two; then return build dataTypeIds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowCreateCommand)"})
  void testBuilderFrom_givenHashSetAddMinusTwo_thenReturnBuildDataTypeIdsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(-2L);
    PhysicalFlowCreateCommand instance = mock(PhysicalFlowCreateCommand.class);
    when(instance.dataTypeIds()).thenReturn(resultLongSet);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.flowAttributes()).thenReturn(new ImmutableFlowAttributes.Json());
    when(instance.specification()).thenReturn(mock(PhysicalSpecification.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dataTypeIds();
    verify(instance).flowAttributes();
    verify(instance).logicalFlowId();
    verify(instance).specification();
    Set<Long> dataTypeIdsResult = actualFromResult.build().dataTypeIds();
    assertEquals(1, dataTypeIdsResult.size());
    Set<Long> dataTypeIdsResult2 = builderResult.build().dataTypeIds();
    assertEquals(1, dataTypeIdsResult2.size());
    assertTrue(dataTypeIdsResult.contains(-2L));
    assertTrue(dataTypeIdsResult2.contains(-2L));
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowCreateCommand)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then builder build logicalFlowId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowCreateCommand); given HashSet(); then builder build logicalFlowId is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowCreateCommand)"})
  void testBuilderFrom_givenHashSet_thenBuilderBuildLogicalFlowIdIsOne() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();
    PhysicalFlowCreateCommand instance = mock(PhysicalFlowCreateCommand.class);
    when(instance.dataTypeIds()).thenReturn(new HashSet<>());
    when(instance.logicalFlowId()).thenReturn(1L);
    ImmutableFlowAttributes.Json json = new ImmutableFlowAttributes.Json();
    when(instance.flowAttributes()).thenReturn(json);
    when(instance.specification()).thenReturn(mock(PhysicalSpecification.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dataTypeIds();
    verify(instance).flowAttributes();
    verify(instance).logicalFlowId();
    verify(instance).specification();
    ImmutablePhysicalFlowCreateCommand buildResult = builderResult.build();
    assertEquals(1L, buildResult.logicalFlowId());
    assertSame(json, buildResult.flowAttributes());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowCreateCommand)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowCreateCommand); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowCreateCommand)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();
    PhysicalFlowCreateCommand instance = mock(PhysicalFlowCreateCommand.class);
    when(instance.dataTypeIds()).thenThrow(new IllegalStateException("instance"));
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.flowAttributes()).thenReturn(new ImmutableFlowAttributes.Json());
    when(instance.specification()).thenReturn(mock(PhysicalSpecification.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).dataTypeIds();
    verify(instance).flowAttributes();
    verify(instance).logicalFlowId();
    verify(instance).specification();
  }

  /**
   * Test Builder {@link Builder#logicalFlowId(long)}.
   * <p>
   * Method under test: {@link Builder#logicalFlowId(long)}
   */
  @Test
  @DisplayName("Test Builder logicalFlowId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.logicalFlowId(long)"})
  void testBuilderLogicalFlowId() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.logicalFlowId(1L));
  }

  /**
   * Test Builder {@link Builder#specification(PhysicalSpecification)}.
   * <ul>
   *   <li>When {@link PhysicalSpecification}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#specification(PhysicalSpecification)}
   */
  @Test
  @DisplayName("Test Builder specification(PhysicalSpecification); when PhysicalSpecification; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.specification(PhysicalSpecification)"})
  void testBuilderSpecification_whenPhysicalSpecification_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.specification(mock(PhysicalSpecification.class)));
  }

  /**
   * Test Json {@link Json#dataTypeIds()}.
   * <p>
   * Method under test: {@link Json#dataTypeIds()}
   */
  @Test
  @DisplayName("Test Json dataTypeIds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.dataTypeIds()"})
  void testJsonDataTypeIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).dataTypeIds());
  }

  /**
   * Test Json {@link Json#flowAttributes()}.
   * <p>
   * Method under test: {@link Json#flowAttributes()}
   */
  @Test
  @DisplayName("Test Json flowAttributes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowAttributes Json.flowAttributes()"})
  void testJsonFlowAttributes() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).flowAttributes());
  }

  /**
   * Test Json {@link Json#logicalFlowId()}.
   * <p>
   * Method under test: {@link Json#logicalFlowId()}
   */
  @Test
  @DisplayName("Test Json logicalFlowId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.logicalFlowId()"})
  void testJsonLogicalFlowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).logicalFlowId());
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
    assertNull(actualJson.flowAttributes);
    assertNull(actualJson.specification);
    assertEquals(0L, actualJson.logicalFlowId);
    assertFalse(actualJson.dataTypeIdsIsSet);
    assertFalse(actualJson.logicalFlowIdIsSet);
    assertTrue(actualJson.dataTypeIds.isEmpty());
  }

  /**
   * Test Json {@link Json#setDataTypeIds(Set)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link HashSet#HashSet()} add one.</li>
   *   <li>Then {@link Json} (default constructor) {@link Json#dataTypeIds} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Json#setDataTypeIds(Set)}
   */
  @Test
  @DisplayName("Test Json setDataTypeIds(Set); given one; when HashSet() add one; then Json (default constructor) dataTypeIds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setDataTypeIds(Set)"})
  void testJsonSetDataTypeIds_givenOne_whenHashSetAddOne_thenJsonDataTypeIdsSizeIsOne() {
    // Arrange
    Json json = new Json();

    HashSet<Long> dataTypeIds = new HashSet<>();
    dataTypeIds.add(1L);

    // Act
    json.setDataTypeIds(dataTypeIds);

    // Assert
    Set<Long> resultLongSet = json.dataTypeIds;
    assertEquals(1, resultLongSet.size());
    assertTrue(resultLongSet.contains(1L));
    assertTrue(json.dataTypeIdsIsSet);
  }

  /**
   * Test Json {@link Json#setDataTypeIds(Set)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link HashSet#HashSet()} add zero.</li>
   *   <li>Then {@link Json} (default constructor) {@link Json#dataTypeIds} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Json#setDataTypeIds(Set)}
   */
  @Test
  @DisplayName("Test Json setDataTypeIds(Set); given zero; when HashSet() add zero; then Json (default constructor) dataTypeIds size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setDataTypeIds(Set)"})
  void testJsonSetDataTypeIds_givenZero_whenHashSetAddZero_thenJsonDataTypeIdsSizeIsTwo() {
    // Arrange
    Json json = new Json();

    HashSet<Long> dataTypeIds = new HashSet<>();
    dataTypeIds.add(0L);
    dataTypeIds.add(1L);

    // Act
    json.setDataTypeIds(dataTypeIds);

    // Assert
    Set<Long> resultLongSet = json.dataTypeIds;
    assertEquals(2, resultLongSet.size());
    assertTrue(resultLongSet.contains(0L));
    assertTrue(resultLongSet.contains(1L));
    assertTrue(json.dataTypeIdsIsSet);
  }

  /**
   * Test Json {@link Json#setDataTypeIds(Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then {@link Json} (default constructor) {@link Json#dataTypeIds} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Json#setDataTypeIds(Set)}
   */
  @Test
  @DisplayName("Test Json setDataTypeIds(Set); when HashSet(); then Json (default constructor) dataTypeIds Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setDataTypeIds(Set)"})
  void testJsonSetDataTypeIds_whenHashSet_thenJsonDataTypeIdsEmpty() {
    // Arrange
    Json json = new Json();

    // Act
    json.setDataTypeIds(new HashSet<>());

    // Assert
    assertTrue(json.dataTypeIds.isEmpty());
    assertTrue(json.dataTypeIdsIsSet);
  }

  /**
   * Test Json {@link Json#setDataTypeIds(Set)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link Json} (default constructor) {@link Json#dataTypeIds} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Json#setDataTypeIds(Set)}
   */
  @Test
  @DisplayName("Test Json setDataTypeIds(Set); when 'null'; then Json (default constructor) dataTypeIds is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setDataTypeIds(Set)"})
  void testJsonSetDataTypeIds_whenNull_thenJsonDataTypeIdsIsNull() {
    // Arrange
    Json json = new Json();

    // Act
    json.setDataTypeIds(null);

    // Assert
    assertNull(json.dataTypeIds);
    assertFalse(json.dataTypeIdsIsSet);
  }

  /**
   * Test Json {@link Json#setLogicalFlowId(long)}.
   * <p>
   * Method under test: {@link Json#setLogicalFlowId(long)}
   */
  @Test
  @DisplayName("Test Json setLogicalFlowId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setLogicalFlowId(long)"})
  void testJsonSetLogicalFlowId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setLogicalFlowId(1L);

    // Assert
    assertEquals(1L, json.logicalFlowId);
    assertTrue(json.logicalFlowIdIsSet);
  }

  /**
   * Test Json {@link Json#specification()}.
   * <p>
   * Method under test: {@link Json#specification()}
   */
  @Test
  @DisplayName("Test Json specification()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PhysicalSpecification Json.specification()"})
  void testJsonSpecification() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).specification());
  }
}
