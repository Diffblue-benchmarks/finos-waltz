package org.finos.waltz.model.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowInfo#builder()}
   *   <li>{@link ImmutablePhysicalFlowInfo#physicalFlowDescription(String)}
   *   <li>{@link ImmutablePhysicalFlowInfo#physicalFlowExternalId(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutablePhysicalFlowInfo.Builder actualPhysicalFlowDescriptionResult = ImmutablePhysicalFlowInfo.builder()
        .physicalFlowDescription("Physical Flow Description");

    // Assert
    assertSame(actualPhysicalFlowDescriptionResult, actualPhysicalFlowDescriptionResult.physicalFlowExternalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowInfo.Builder#addAllDataTypes(Iterable)}
   */
  @Test
  void testBuilderAddAllDataTypes() {
    // Arrange
    ImmutablePhysicalFlowInfo.Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDataTypes(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowInfo.Builder#addDataTypes(EntityReference)}
   */
  @Test
  void testBuilderAddDataTypes() {
    // Arrange
    ImmutablePhysicalFlowInfo.Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDataTypes(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowInfo.Builder#addDataTypes(EntityReference[])}
   */
  @Test
  void testBuilderAddDataTypes2() {
    // Arrange
    ImmutablePhysicalFlowInfo.Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDataTypes(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowInfo.Builder#criticality(CriticalityValue)}
   */
  @Test
  void testBuilderCriticality() {
    // Arrange
    ImmutablePhysicalFlowInfo.Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.criticality(CriticalityValue.of("42")));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowInfo.Builder#criticality(CriticalityValue)}
   */
  @Test
  void testBuilderCriticality2() {
    // Arrange
    ImmutablePhysicalFlowInfo.Builder builderResult = ImmutablePhysicalFlowInfo.builder();
    builderResult.addDataTypes(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.criticality(CriticalityValue.of("42")));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowInfo.Builder#dataTypes(Iterable)}
   */
  @Test
  void testBuilderDataTypes() {
    // Arrange
    ImmutablePhysicalFlowInfo.Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypes(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowInfo.Builder#frequencyKind(FrequencyKindValue)}
   */
  @Test
  void testBuilderFrequencyKind() {
    // Arrange
    ImmutablePhysicalFlowInfo.Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.frequencyKind(FrequencyKindValue.of("42")));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowInfo.Builder#frequencyKind(FrequencyKindValue)}
   */
  @Test
  void testBuilderFrequencyKind2() {
    // Arrange
    ImmutablePhysicalFlowInfo.Builder builderResult = ImmutablePhysicalFlowInfo.builder();
    builderResult.addDataTypes(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.frequencyKind(FrequencyKindValue.of("42")));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowInfo.Builder#from(PhysicalFlowInfo)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePhysicalFlowInfo.Builder builderResult = ImmutablePhysicalFlowInfo.builder();
    PhysicalFlowInfo instance = mock(PhysicalFlowInfo.class);
    when(instance.target()).thenThrow(new IllegalStateException("instance"));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).source();
    verify(instance).target();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowInfo.Builder#from(PhysicalFlowInfo)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutablePhysicalFlowInfo.Builder builderResult = ImmutablePhysicalFlowInfo.builder();
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
   * Method under test:
   * {@link ImmutablePhysicalFlowInfo.Builder#from(PhysicalFlowInfo)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutablePhysicalFlowInfo.Builder builderResult = ImmutablePhysicalFlowInfo.builder();
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
   * Method under test:
   * {@link ImmutablePhysicalFlowInfo.Builder#from(PhysicalFlowInfo)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutablePhysicalFlowInfo.Builder builderResult = ImmutablePhysicalFlowInfo.builder();
    PhysicalFlowInfo instance = mock(PhysicalFlowInfo.class);
    when(instance.dataTypes()).thenReturn(new ArrayList<>());
    CriticalityValue ofResult = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult);
    FrequencyKindValue ofResult2 = FrequencyKindValue.of("42");
    when(instance.frequencyKind()).thenReturn(ofResult2);
    when(instance.physicalFlowDescription()).thenReturn("Physical Flow Description");
    when(instance.physicalFlowExternalId()).thenReturn("42");
    TransportKindValue ofResult3 = TransportKindValue.of("42");
    when(instance.transportKindValue()).thenReturn(ofResult3);
    when(instance.logicalFlow()).thenReturn(mock(EntityReference.class));
    when(instance.specification()).thenReturn(mock(EntityReference.class));
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutablePhysicalFlowInfo.Builder actualFromResult = builderResult.from(instance);

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
    ImmutablePhysicalFlowInfo buildResult = builderResult.build();
    assertEquals("42", buildResult.physicalFlowExternalId());
    assertEquals("Physical Flow Description", buildResult.physicalFlowDescription());
    assertSame(ofResult, buildResult.criticality());
    assertSame(ofResult2, buildResult.frequencyKind());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult3, buildResult.transportKindValue());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowInfo.Builder#from(PhysicalFlowInfo)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutablePhysicalFlowInfo.Builder builderResult = ImmutablePhysicalFlowInfo.builder();
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
   * Method under test:
   * {@link ImmutablePhysicalFlowInfo.Builder#from(PhysicalFlowInfo)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutablePhysicalFlowInfo.Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(mock(EntityReference.class));
    PhysicalFlowInfo instance = mock(PhysicalFlowInfo.class);
    when(instance.dataTypes()).thenReturn(entityReferenceList);
    CriticalityValue ofResult = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult);
    FrequencyKindValue ofResult2 = FrequencyKindValue.of("42");
    when(instance.frequencyKind()).thenReturn(ofResult2);
    when(instance.physicalFlowDescription()).thenReturn("Physical Flow Description");
    when(instance.physicalFlowExternalId()).thenReturn("42");
    TransportKindValue ofResult3 = TransportKindValue.of("42");
    when(instance.transportKindValue()).thenReturn(ofResult3);
    when(instance.logicalFlow()).thenReturn(mock(EntityReference.class));
    when(instance.specification()).thenReturn(mock(EntityReference.class));
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutablePhysicalFlowInfo.Builder actualFromResult = builderResult.from(instance);

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
    ImmutablePhysicalFlowInfo buildResult = builderResult.build();
    assertEquals("42", buildResult.physicalFlowExternalId());
    assertEquals("Physical Flow Description", buildResult.physicalFlowDescription());
    assertEquals(1, buildResult.dataTypes().size());
    assertSame(ofResult, buildResult.criticality());
    assertSame(ofResult2, buildResult.frequencyKind());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult3, buildResult.transportKindValue());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowInfo.Builder#from(PhysicalFlowInfo)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutablePhysicalFlowInfo.Builder builderResult = ImmutablePhysicalFlowInfo.builder();
    PhysicalFlowInfo instance = mock(PhysicalFlowInfo.class);
    when(instance.dataTypes()).thenReturn(new ArrayList<>());
    CriticalityValue ofResult = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult);
    FrequencyKindValue ofResult2 = FrequencyKindValue.of("42");
    when(instance.frequencyKind()).thenReturn(ofResult2);
    when(instance.physicalFlowDescription()).thenReturn(null);
    when(instance.physicalFlowExternalId()).thenReturn("42");
    TransportKindValue ofResult3 = TransportKindValue.of("42");
    when(instance.transportKindValue()).thenReturn(ofResult3);
    when(instance.logicalFlow()).thenReturn(mock(EntityReference.class));
    when(instance.specification()).thenReturn(mock(EntityReference.class));
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutablePhysicalFlowInfo.Builder actualFromResult = builderResult.from(instance);

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
    ImmutablePhysicalFlowInfo buildResult = builderResult.build();
    assertEquals("42", buildResult.physicalFlowExternalId());
    assertNull(buildResult.physicalFlowDescription());
    assertSame(ofResult, buildResult.criticality());
    assertSame(ofResult2, buildResult.frequencyKind());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult3, buildResult.transportKindValue());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowInfo.Builder#from(PhysicalFlowInfo)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutablePhysicalFlowInfo.Builder builderResult = ImmutablePhysicalFlowInfo.builder();
    PhysicalFlowInfo instance = mock(PhysicalFlowInfo.class);
    when(instance.dataTypes()).thenReturn(new ArrayList<>());
    CriticalityValue ofResult = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult);
    FrequencyKindValue ofResult2 = FrequencyKindValue.of("42");
    when(instance.frequencyKind()).thenReturn(ofResult2);
    when(instance.physicalFlowDescription()).thenReturn("Physical Flow Description");
    when(instance.physicalFlowExternalId()).thenReturn(null);
    TransportKindValue ofResult3 = TransportKindValue.of("42");
    when(instance.transportKindValue()).thenReturn(ofResult3);
    when(instance.logicalFlow()).thenReturn(mock(EntityReference.class));
    when(instance.specification()).thenReturn(mock(EntityReference.class));
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutablePhysicalFlowInfo.Builder actualFromResult = builderResult.from(instance);

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
    ImmutablePhysicalFlowInfo buildResult = builderResult.build();
    assertEquals("Physical Flow Description", buildResult.physicalFlowDescription());
    assertNull(buildResult.physicalFlowExternalId());
    assertSame(ofResult, buildResult.criticality());
    assertSame(ofResult2, buildResult.frequencyKind());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult3, buildResult.transportKindValue());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowInfo.Builder#logicalFlow(EntityReference)}
   */
  @Test
  void testBuilderLogicalFlow() {
    // Arrange
    ImmutablePhysicalFlowInfo.Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.logicalFlow(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowInfo.Builder#source(EntityReference)}
   */
  @Test
  void testBuilderSource() {
    // Arrange
    ImmutablePhysicalFlowInfo.Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.source(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowInfo.Builder#specification(EntityReference)}
   */
  @Test
  void testBuilderSpecification() {
    // Arrange
    ImmutablePhysicalFlowInfo.Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.specification(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowInfo.Builder#target(EntityReference)}
   */
  @Test
  void testBuilderTarget() {
    // Arrange
    ImmutablePhysicalFlowInfo.Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.target(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowInfo.Builder#transportKindValue(TransportKindValue)}
   */
  @Test
  void testBuilderTransportKindValue() {
    // Arrange
    ImmutablePhysicalFlowInfo.Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.transportKindValue(TransportKindValue.of("42")));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowInfo.Builder#transportKindValue(TransportKindValue)}
   */
  @Test
  void testBuilderTransportKindValue2() {
    // Arrange
    ImmutablePhysicalFlowInfo.Builder builderResult = ImmutablePhysicalFlowInfo.builder();
    builderResult.addDataTypes(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.transportKindValue(TransportKindValue.of("42")));
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowInfo#copyOf(PhysicalFlowInfo)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    PhysicalFlowInfo instance = mock(PhysicalFlowInfo.class);
    when(instance.dataTypes()).thenReturn(new ArrayList<>());
    CriticalityValue ofResult = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult);
    FrequencyKindValue ofResult2 = FrequencyKindValue.of("42");
    when(instance.frequencyKind()).thenReturn(ofResult2);
    when(instance.physicalFlowDescription()).thenReturn("Physical Flow Description");
    when(instance.physicalFlowExternalId()).thenReturn("42");
    TransportKindValue ofResult3 = TransportKindValue.of("42");
    when(instance.transportKindValue()).thenReturn(ofResult3);
    when(instance.logicalFlow()).thenReturn(mock(EntityReference.class));
    when(instance.specification()).thenReturn(mock(EntityReference.class));
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutablePhysicalFlowInfo actualCopyOfResult = ImmutablePhysicalFlowInfo.copyOf(instance);

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
    CriticalityValue criticalityResult = actualCopyOfResult.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyKindResult = actualCopyOfResult.frequencyKind();
    assertEquals("42", frequencyKindResult.value());
    assertEquals("42", actualCopyOfResult.physicalFlowExternalId());
    TransportKindValue transportKindValueResult = actualCopyOfResult.transportKindValue();
    assertEquals("42", transportKindValueResult.value());
    assertEquals("Physical Flow Description", actualCopyOfResult.physicalFlowDescription());
    assertTrue(actualCopyOfResult.dataTypes().isEmpty());
    assertSame(ofResult, criticalityResult);
    assertSame(ofResult2, frequencyKindResult);
    assertSame(ofResult3, transportKindValueResult);
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowInfo#copyOf(PhysicalFlowInfo)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(mock(EntityReference.class));
    PhysicalFlowInfo instance = mock(PhysicalFlowInfo.class);
    when(instance.dataTypes()).thenReturn(entityReferenceList);
    CriticalityValue ofResult = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult);
    FrequencyKindValue ofResult2 = FrequencyKindValue.of("42");
    when(instance.frequencyKind()).thenReturn(ofResult2);
    when(instance.physicalFlowDescription()).thenReturn("Physical Flow Description");
    when(instance.physicalFlowExternalId()).thenReturn("42");
    TransportKindValue ofResult3 = TransportKindValue.of("42");
    when(instance.transportKindValue()).thenReturn(ofResult3);
    when(instance.logicalFlow()).thenReturn(mock(EntityReference.class));
    when(instance.specification()).thenReturn(mock(EntityReference.class));
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutablePhysicalFlowInfo actualCopyOfResult = ImmutablePhysicalFlowInfo.copyOf(instance);

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
    CriticalityValue criticalityResult = actualCopyOfResult.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyKindResult = actualCopyOfResult.frequencyKind();
    assertEquals("42", frequencyKindResult.value());
    assertEquals("42", actualCopyOfResult.physicalFlowExternalId());
    TransportKindValue transportKindValueResult = actualCopyOfResult.transportKindValue();
    assertEquals("42", transportKindValueResult.value());
    assertEquals("Physical Flow Description", actualCopyOfResult.physicalFlowDescription());
    assertEquals(1, actualCopyOfResult.dataTypes().size());
    assertSame(ofResult, criticalityResult);
    assertSame(ofResult2, frequencyKindResult);
    assertSame(ofResult3, transportKindValueResult);
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowInfo#copyOf(PhysicalFlowInfo)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(mock(EntityReference.class));
    entityReferenceList.add(mock(EntityReference.class));
    PhysicalFlowInfo instance = mock(PhysicalFlowInfo.class);
    when(instance.dataTypes()).thenReturn(entityReferenceList);
    CriticalityValue ofResult = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult);
    FrequencyKindValue ofResult2 = FrequencyKindValue.of("42");
    when(instance.frequencyKind()).thenReturn(ofResult2);
    when(instance.physicalFlowDescription()).thenReturn("Physical Flow Description");
    when(instance.physicalFlowExternalId()).thenReturn("42");
    TransportKindValue ofResult3 = TransportKindValue.of("42");
    when(instance.transportKindValue()).thenReturn(ofResult3);
    when(instance.logicalFlow()).thenReturn(mock(EntityReference.class));
    when(instance.specification()).thenReturn(mock(EntityReference.class));
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutablePhysicalFlowInfo actualCopyOfResult = ImmutablePhysicalFlowInfo.copyOf(instance);

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
    CriticalityValue criticalityResult = actualCopyOfResult.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyKindResult = actualCopyOfResult.frequencyKind();
    assertEquals("42", frequencyKindResult.value());
    assertEquals("42", actualCopyOfResult.physicalFlowExternalId());
    TransportKindValue transportKindValueResult = actualCopyOfResult.transportKindValue();
    assertEquals("42", transportKindValueResult.value());
    assertEquals("Physical Flow Description", actualCopyOfResult.physicalFlowDescription());
    assertEquals(entityReferenceList, actualCopyOfResult.dataTypes());
    assertSame(ofResult, criticalityResult);
    assertSame(ofResult2, frequencyKindResult);
    assertSame(ofResult3, transportKindValueResult);
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowInfo.Json#criticality()}
   */
  @Test
  void testJsonCriticality() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowInfo.Json()).criticality());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowInfo.Json#dataTypes()}
   */
  @Test
  void testJsonDataTypes() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowInfo.Json()).dataTypes());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowInfo.Json#frequencyKind()}
   */
  @Test
  void testJsonFrequencyKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowInfo.Json()).frequencyKind());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowInfo.Json#logicalFlow()}
   */
  @Test
  void testJsonLogicalFlow() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowInfo.Json()).logicalFlow());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutablePhysicalFlowInfo.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutablePhysicalFlowInfo.Json actualJson = new ImmutablePhysicalFlowInfo.Json();

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
   * Method under test:
   * {@link ImmutablePhysicalFlowInfo.Json#physicalFlowDescription()}
   */
  @Test
  void testJsonPhysicalFlowDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowInfo.Json()).physicalFlowDescription());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowInfo.Json#physicalFlowExternalId()}
   */
  @Test
  void testJsonPhysicalFlowExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowInfo.Json()).physicalFlowExternalId());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowInfo.Json#source()}
   */
  @Test
  void testJsonSource() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowInfo.Json()).source());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowInfo.Json#specification()}
   */
  @Test
  void testJsonSpecification() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowInfo.Json()).specification());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowInfo.Json#target()}
   */
  @Test
  void testJsonTarget() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowInfo.Json()).target());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowInfo.Json#transportKindValue()}
   */
  @Test
  void testJsonTransportKindValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowInfo.Json()).transportKindValue());
  }
}
