package org.finos.waltz.model.data_type_usage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.usage_info.UsageInfo;
import org.junit.jupiter.api.Test;

class ImmutableDataTypeUsageDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableDataTypeUsage#builder()}
   *   <li>{@link ImmutableDataTypeUsage#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableDataTypeUsage.Builder actualBuilderResult = ImmutableDataTypeUsage.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.provenance("Provenance"));
  }

  /**
   * Method under test: {@link ImmutableDataTypeUsage.Builder#dataTypeId(Long)}
   */
  @Test
  void testBuilderDataTypeId() {
    // Arrange
    ImmutableDataTypeUsage.Builder builderResult = ImmutableDataTypeUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypeId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeUsage.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableDataTypeUsage.Builder builderResult = ImmutableDataTypeUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeUsage.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableDataTypeUsage.Builder builderResult = ImmutableDataTypeUsage.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableDataTypeUsage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableDataTypeUsage.Builder#from(DataTypeUsage)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableDataTypeUsage.Builder builderResult = ImmutableDataTypeUsage.builder();
    DataTypeUsage instance = mock(DataTypeUsage.class);
    when(instance.dataTypeId()).thenThrow(new IllegalStateException("instance"));
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).provenance();
    verify(instance).dataTypeId();
  }

  /**
   * Method under test: {@link ImmutableDataTypeUsage.Builder#from(DataTypeUsage)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableDataTypeUsage.Builder builderResult = ImmutableDataTypeUsage.builder();
    DataTypeUsage instance = mock(DataTypeUsage.class);
    when(instance.usage()).thenThrow(new IllegalStateException("instance"));
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).provenance();
    verify(instance).dataTypeId();
    verify(instance).entityReference();
    verify(instance).usage();
  }

  /**
   * Method under test: {@link ImmutableDataTypeUsage.Builder#from(DataTypeUsage)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableDataTypeUsage.Builder builderResult = ImmutableDataTypeUsage.builder();
    DataTypeUsage instance = mock(DataTypeUsage.class);
    when(instance.usage()).thenReturn(mock(UsageInfo.class));
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableDataTypeUsage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    verify(instance).dataTypeId();
    verify(instance).entityReference();
    verify(instance).usage();
    ImmutableDataTypeUsage buildResult = builderResult.build();
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1L, buildResult.dataTypeId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableDataTypeUsage.Builder#usage(UsageInfo)}
   */
  @Test
  void testBuilderUsage() {
    // Arrange
    ImmutableDataTypeUsage.Builder builderResult = ImmutableDataTypeUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.usage(mock(UsageInfo.class)));
  }

  /**
   * Method under test: {@link ImmutableDataTypeUsage#copyOf(DataTypeUsage)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    DataTypeUsage instance = mock(DataTypeUsage.class);
    when(instance.usage()).thenReturn(mock(UsageInfo.class));
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableDataTypeUsage actualCopyOfResult = ImmutableDataTypeUsage.copyOf(instance);

    // Assert
    verify(instance).provenance();
    verify(instance).dataTypeId();
    verify(instance).entityReference();
    verify(instance).usage();
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.dataTypeId().longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeUsage#fromJson(ImmutableDataTypeUsage.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableDataTypeUsage.Json json = new ImmutableDataTypeUsage.Json();
    json.setUsage(mock(UsageInfo.class));
    json.setDataTypeId(1L);
    json.setEntityReference(mock(EntityReference.class));

    // Act
    ImmutableDataTypeUsage actualFromJsonResult = ImmutableDataTypeUsage.fromJson(json);

    // Assert
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertEquals(1L, actualFromJsonResult.dataTypeId().longValue());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
    UsageInfo expectedUsageResult = json.usage;
    assertSame(expectedUsageResult, actualFromJsonResult.usage());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeUsage#fromJson(ImmutableDataTypeUsage.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableDataTypeUsage.Json json = new ImmutableDataTypeUsage.Json();
    json.setProvenance("entityReference");
    json.setUsage(mock(UsageInfo.class));
    json.setDataTypeId(1L);
    json.setEntityReference(mock(EntityReference.class));

    // Act
    ImmutableDataTypeUsage actualFromJsonResult = ImmutableDataTypeUsage.fromJson(json);

    // Assert
    assertEquals("entityReference", actualFromJsonResult.provenance());
    assertEquals(1L, actualFromJsonResult.dataTypeId().longValue());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
    UsageInfo expectedUsageResult = json.usage;
    assertSame(expectedUsageResult, actualFromJsonResult.usage());
  }

  /**
   * Method under test: {@link ImmutableDataTypeUsage.Json#dataTypeId()}
   */
  @Test
  void testJsonDataTypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDataTypeUsage.Json()).dataTypeId());
  }

  /**
   * Method under test: {@link ImmutableDataTypeUsage.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDataTypeUsage.Json()).entityReference());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableDataTypeUsage.Json}
   *   <li>{@link ImmutableDataTypeUsage.Json#setDataTypeId(Long)}
   *   <li>{@link ImmutableDataTypeUsage.Json#setEntityReference(EntityReference)}
   *   <li>{@link ImmutableDataTypeUsage.Json#setProvenance(String)}
   *   <li>{@link ImmutableDataTypeUsage.Json#setUsage(UsageInfo)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableDataTypeUsage.Json actualJson = new ImmutableDataTypeUsage.Json();
    actualJson.setDataTypeId(1L);
    actualJson.setEntityReference(null);
    actualJson.setProvenance("Provenance");
    actualJson.setUsage(null);

    // Assert
    assertEquals(1L, actualJson.dataTypeId.longValue());
  }

  /**
   * Method under test: {@link ImmutableDataTypeUsage.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDataTypeUsage.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableDataTypeUsage.Json#usage()}
   */
  @Test
  void testJsonUsage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDataTypeUsage.Json()).usage());
  }
}
