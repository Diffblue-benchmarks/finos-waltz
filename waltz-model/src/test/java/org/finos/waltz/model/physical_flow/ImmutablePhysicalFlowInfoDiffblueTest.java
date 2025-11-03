package org.finos.waltz.model.physical_flow;

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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowInfo.Builder;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowInfoDiffblueTest {
  /**
   * Test {@link ImmutablePhysicalFlowInfo#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowInfo#builder()}
   *   <li>{@link ImmutablePhysicalFlowInfo#physicalFlowDescription(String)}
   *   <li>{@link ImmutablePhysicalFlowInfo#physicalFlowExternalId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutablePhysicalFlowInfo Builder.build()", "Builder Builder.physicalFlowDescription(String)",
      "Builder Builder.physicalFlowExternalId(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualPhysicalFlowDescriptionResult = ImmutablePhysicalFlowInfo.builder()
        .physicalFlowDescription("Physical Flow Description");

    // Assert
    assertSame(actualPhysicalFlowDescriptionResult, actualPhysicalFlowDescriptionResult.physicalFlowExternalId("42"));
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
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDataTypes(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addDataTypes(EntityReference)} with {@code element}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addDataTypes(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder addDataTypes(EntityReference) with 'element'; when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDataTypes(EntityReference)"})
  void testBuilderAddDataTypesWithElement_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDataTypes(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#addDataTypes(EntityReference[])} with {@code elements}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addDataTypes(EntityReference[])}
   */
  @Test
  @DisplayName("Test Builder addDataTypes(EntityReference[]) with 'elements'; when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDataTypes(EntityReference[])"})
  void testBuilderAddDataTypesWithElements_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDataTypes(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#criticality(CriticalityValue)}.
   * <ul>
   *   <li>When {@link CriticalityValue} with value is {@code 42}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#criticality(CriticalityValue)}
   */
  @Test
  @DisplayName("Test Builder criticality(CriticalityValue); when CriticalityValue with value is '42'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.criticality(CriticalityValue)"})
  void testBuilderCriticality_whenCriticalityValueWithValueIs42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.criticality(CriticalityValue.of("42")));
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
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypes(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#frequencyKind(FrequencyKindValue)}.
   * <ul>
   *   <li>When {@link FrequencyKindValue} with value is {@code 42}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#frequencyKind(FrequencyKindValue)}
   */
  @Test
  @DisplayName("Test Builder frequencyKind(FrequencyKindValue); when FrequencyKindValue with value is '42'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.frequencyKind(FrequencyKindValue)"})
  void testBuilderFrequencyKind_whenFrequencyKindValueWithValueIs42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.frequencyKind(FrequencyKindValue.of("42")));
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowInfo)}.
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowInfo)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowInfo)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();
    PhysicalFlowInfo instance = mock(PhysicalFlowInfo.class);
    when(instance.specification()).thenThrow(new IllegalStateException("instance"));
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).source();
    verify(instance).specification();
    verify(instance).target();
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowInfo)}.
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowInfo)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowInfo)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();
    PhysicalFlowInfo instance = mock(PhysicalFlowInfo.class);
    when(instance.logicalFlow()).thenThrow(new IllegalStateException("instance"));
    when(instance.specification()).thenReturn(mock(EntityReference.class));
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).logicalFlow();
    verify(instance).source();
    verify(instance).specification();
    verify(instance).target();
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowInfo)}.
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowInfo)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowInfo)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();
    PhysicalFlowInfo instance = mock(PhysicalFlowInfo.class);
    when(instance.dataTypes()).thenThrow(new IllegalStateException("instance"));
    when(instance.criticality()).thenReturn(CriticalityValue.of("42"));
    when(instance.frequencyKind()).thenReturn(FrequencyKindValue.of("42"));
    when(instance.physicalFlowDescription()).thenReturn("Physical Flow Description");
    when(instance.physicalFlowExternalId()).thenReturn("42");
    when(instance.transportKindValue()).thenReturn(TransportKindValue.of("42"));
    when(instance.logicalFlow()).thenReturn(mock(EntityReference.class));
    when(instance.specification()).thenReturn(mock(EntityReference.class));
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).criticality();
    verify(instance).dataTypes();
    verify(instance).frequencyKind();
    verify(instance).logicalFlow();
    verify(instance).physicalFlowDescription();
    verify(instance).physicalFlowExternalId();
    verify(instance).source();
    verify(instance).specification();
    verify(instance).target();
    verify(instance).transportKindValue();
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowInfo)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return build physicalFlowExternalId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowInfo)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowInfo); given ArrayList(); then return build physicalFlowExternalId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowInfo)"})
  void testBuilderFrom_givenArrayList_thenReturnBuildPhysicalFlowExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();
    PhysicalFlowInfo instance = mock(PhysicalFlowInfo.class);
    when(instance.dataTypes()).thenReturn(new ArrayList<>());
    when(instance.criticality()).thenReturn(CriticalityValue.of("42"));
    when(instance.frequencyKind()).thenReturn(FrequencyKindValue.of("42"));
    when(instance.physicalFlowDescription()).thenReturn("Physical Flow Description");
    when(instance.physicalFlowExternalId()).thenReturn("42");
    when(instance.transportKindValue()).thenReturn(TransportKindValue.of("42"));
    when(instance.logicalFlow()).thenReturn(mock(EntityReference.class));
    when(instance.specification()).thenReturn(mock(EntityReference.class));
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).criticality();
    verify(instance).dataTypes();
    verify(instance).frequencyKind();
    verify(instance).logicalFlow();
    verify(instance).physicalFlowDescription();
    verify(instance).physicalFlowExternalId();
    verify(instance).source();
    verify(instance).specification();
    verify(instance).target();
    verify(instance).transportKindValue();
    ImmutablePhysicalFlowInfo buildResult = actualFromResult.build();
    assertEquals("42", buildResult.physicalFlowExternalId());
    ImmutablePhysicalFlowInfo buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.physicalFlowExternalId());
    assertEquals("Physical Flow Description", buildResult.physicalFlowDescription());
    assertEquals("Physical Flow Description", buildResult2.physicalFlowDescription());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowInfo)}.
   * <ul>
   *   <li>Then return build dataTypes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowInfo)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowInfo); then return build dataTypes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowInfo)"})
  void testBuilderFrom_thenReturnBuildDataTypesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(mock(EntityReference.class));
    PhysicalFlowInfo instance = mock(PhysicalFlowInfo.class);
    when(instance.dataTypes()).thenReturn(entityReferenceList);
    when(instance.criticality()).thenReturn(CriticalityValue.of("42"));
    when(instance.frequencyKind()).thenReturn(FrequencyKindValue.of("42"));
    when(instance.physicalFlowDescription()).thenReturn("Physical Flow Description");
    when(instance.physicalFlowExternalId()).thenReturn("42");
    when(instance.transportKindValue()).thenReturn(TransportKindValue.of("42"));
    when(instance.logicalFlow()).thenReturn(mock(EntityReference.class));
    when(instance.specification()).thenReturn(mock(EntityReference.class));
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).criticality();
    verify(instance).dataTypes();
    verify(instance).frequencyKind();
    verify(instance).logicalFlow();
    verify(instance).physicalFlowDescription();
    verify(instance).physicalFlowExternalId();
    verify(instance).source();
    verify(instance).specification();
    verify(instance).target();
    verify(instance).transportKindValue();
    assertEquals(1, actualFromResult.build().dataTypes().size());
    assertEquals(1, builderResult.build().dataTypes().size());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowInfo)}.
   * <ul>
   *   <li>Then return build physicalFlowDescription is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowInfo)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowInfo); then return build physicalFlowDescription is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowInfo)"})
  void testBuilderFrom_thenReturnBuildPhysicalFlowDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();
    PhysicalFlowInfo instance = mock(PhysicalFlowInfo.class);
    when(instance.dataTypes()).thenReturn(new ArrayList<>());
    when(instance.criticality()).thenReturn(CriticalityValue.of("42"));
    when(instance.frequencyKind()).thenReturn(FrequencyKindValue.of("42"));
    when(instance.physicalFlowDescription()).thenReturn(null);
    when(instance.physicalFlowExternalId()).thenReturn("42");
    when(instance.transportKindValue()).thenReturn(TransportKindValue.of("42"));
    when(instance.logicalFlow()).thenReturn(mock(EntityReference.class));
    when(instance.specification()).thenReturn(mock(EntityReference.class));
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).criticality();
    verify(instance).dataTypes();
    verify(instance).frequencyKind();
    verify(instance).logicalFlow();
    verify(instance).physicalFlowDescription();
    verify(instance).physicalFlowExternalId();
    verify(instance).source();
    verify(instance).specification();
    verify(instance).target();
    verify(instance).transportKindValue();
    ImmutablePhysicalFlowInfo buildResult = actualFromResult.build();
    assertEquals("42", buildResult.physicalFlowExternalId());
    ImmutablePhysicalFlowInfo buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.physicalFlowExternalId());
    assertNull(buildResult.physicalFlowDescription());
    assertNull(buildResult2.physicalFlowDescription());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowInfo)}.
   * <ul>
   *   <li>Then return build physicalFlowExternalId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowInfo)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowInfo); then return build physicalFlowExternalId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowInfo)"})
  void testBuilderFrom_thenReturnBuildPhysicalFlowExternalIdIsNull() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();
    PhysicalFlowInfo instance = mock(PhysicalFlowInfo.class);
    when(instance.dataTypes()).thenReturn(new ArrayList<>());
    when(instance.criticality()).thenReturn(CriticalityValue.of("42"));
    when(instance.frequencyKind()).thenReturn(FrequencyKindValue.of("42"));
    when(instance.physicalFlowDescription()).thenReturn("Physical Flow Description");
    when(instance.physicalFlowExternalId()).thenReturn(null);
    when(instance.transportKindValue()).thenReturn(TransportKindValue.of("42"));
    when(instance.logicalFlow()).thenReturn(mock(EntityReference.class));
    when(instance.specification()).thenReturn(mock(EntityReference.class));
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).criticality();
    verify(instance).dataTypes();
    verify(instance).frequencyKind();
    verify(instance).logicalFlow();
    verify(instance).physicalFlowDescription();
    verify(instance).physicalFlowExternalId();
    verify(instance).source();
    verify(instance).specification();
    verify(instance).target();
    verify(instance).transportKindValue();
    ImmutablePhysicalFlowInfo buildResult = actualFromResult.build();
    assertEquals("Physical Flow Description", buildResult.physicalFlowDescription());
    ImmutablePhysicalFlowInfo buildResult2 = builderResult.build();
    assertEquals("Physical Flow Description", buildResult2.physicalFlowDescription());
    assertNull(buildResult.physicalFlowExternalId());
    assertNull(buildResult2.physicalFlowExternalId());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowInfo)}.
   * <ul>
   *   <li>When {@link PhysicalFlowInfo} {@link PhysicalFlowInfo#target()} throw {@link IllegalStateException#IllegalStateException(String)} with {@code instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowInfo)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowInfo); when PhysicalFlowInfo target() throw IllegalStateException(String) with 'instance'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowInfo)"})
  void testBuilderFrom_whenPhysicalFlowInfoTargetThrowIllegalStateExceptionWithInstance() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();
    PhysicalFlowInfo instance = mock(PhysicalFlowInfo.class);
    when(instance.target()).thenThrow(new IllegalStateException("instance"));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).source();
    verify(instance).target();
  }

  /**
   * Test Builder {@link Builder#logicalFlow(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#logicalFlow(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder logicalFlow(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.logicalFlow(EntityReference)"})
  void testBuilderLogicalFlow_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.logicalFlow(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#source(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#source(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder source(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.source(EntityReference)"})
  void testBuilderSource_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.source(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#specification(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#specification(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder specification(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.specification(EntityReference)"})
  void testBuilderSpecification_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.specification(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#target(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#target(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder target(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.target(EntityReference)"})
  void testBuilderTarget_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.target(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#transportKindValue(TransportKindValue)}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#transportKindValue(TransportKindValue)}
   */
  @Test
  @DisplayName("Test Builder transportKindValue(TransportKindValue); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.transportKindValue(TransportKindValue)"})
  void testBuilderTransportKindValue_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.transportKindValue(TransportKindValue.of("42")));
  }

  /**
   * Test Json {@link Json#criticality()}.
   * <p>
   * Method under test: {@link Json#criticality()}
   */
  @Test
  @DisplayName("Test Json criticality()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CriticalityValue Json.criticality()"})
  void testJsonCriticality() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).criticality());
  }

  /**
   * Test Json {@link Json#dataTypes()}.
   * <p>
   * Method under test: {@link Json#dataTypes()}
   */
  @Test
  @DisplayName("Test Json dataTypes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List Json.dataTypes()"})
  void testJsonDataTypes() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).dataTypes());
  }

  /**
   * Test Json {@link Json#frequencyKind()}.
   * <p>
   * Method under test: {@link Json#frequencyKind()}
   */
  @Test
  @DisplayName("Test Json frequencyKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FrequencyKindValue Json.frequencyKind()"})
  void testJsonFrequencyKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).frequencyKind());
  }

  /**
   * Test Json {@link Json#logicalFlow()}.
   * <p>
   * Method under test: {@link Json#logicalFlow()}
   */
  @Test
  @DisplayName("Test Json logicalFlow()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.logicalFlow()"})
  void testJsonLogicalFlow() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).logicalFlow());
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
    assertNull(actualJson.physicalFlowDescription);
    assertNull(actualJson.physicalFlowExternalId);
    assertNull(actualJson.logicalFlow);
    assertNull(actualJson.source);
    assertNull(actualJson.specification);
    assertNull(actualJson.target);
    assertNull(actualJson.criticality);
    assertNull(actualJson.frequencyKind);
    assertNull(actualJson.transportKindValue);
    assertTrue(actualJson.dataTypes.isEmpty());
  }

  /**
   * Test Json {@link Json#physicalFlowDescription()}.
   * <p>
   * Method under test: {@link Json#physicalFlowDescription()}
   */
  @Test
  @DisplayName("Test Json physicalFlowDescription()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.physicalFlowDescription()"})
  void testJsonPhysicalFlowDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).physicalFlowDescription());
  }

  /**
   * Test Json {@link Json#physicalFlowExternalId()}.
   * <p>
   * Method under test: {@link Json#physicalFlowExternalId()}
   */
  @Test
  @DisplayName("Test Json physicalFlowExternalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.physicalFlowExternalId()"})
  void testJsonPhysicalFlowExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).physicalFlowExternalId());
  }

  /**
   * Test Json {@link Json#source()}.
   * <p>
   * Method under test: {@link Json#source()}
   */
  @Test
  @DisplayName("Test Json source()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.source()"})
  void testJsonSource() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).source());
  }

  /**
   * Test Json {@link Json#specification()}.
   * <p>
   * Method under test: {@link Json#specification()}
   */
  @Test
  @DisplayName("Test Json specification()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.specification()"})
  void testJsonSpecification() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).specification());
  }

  /**
   * Test Json {@link Json#target()}.
   * <p>
   * Method under test: {@link Json#target()}
   */
  @Test
  @DisplayName("Test Json target()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.target()"})
  void testJsonTarget() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).target());
  }

  /**
   * Test Json {@link Json#transportKindValue()}.
   * <p>
   * Method under test: {@link Json#transportKindValue()}
   */
  @Test
  @DisplayName("Test Json transportKindValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportKindValue Json.transportKindValue()"})
  void testJsonTransportKindValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).transportKindValue());
  }
}
