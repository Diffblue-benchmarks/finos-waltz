package org.finos.waltz.model.data_type_usage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.data_type_usage.ImmutableDataTypeUsage.Builder;
import org.finos.waltz.model.data_type_usage.ImmutableDataTypeUsage.Json;
import org.finos.waltz.model.usage_info.UsageInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDataTypeUsageDiffblueTest {
  /**
   * Test {@link ImmutableDataTypeUsage#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableDataTypeUsage#builder()}
   *   <li>{@link ImmutableDataTypeUsage#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableDataTypeUsage Builder.build()", "Builder Builder.provenance(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableDataTypeUsage.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.provenance("Provenance"));
  }

  /**
   * Test Builder {@link Builder#dataTypeId(Long)}.
   * <p>
   * Method under test: {@link Builder#dataTypeId(Long)}
   */
  @Test
  @DisplayName("Test Builder dataTypeId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.dataTypeId(Long)"})
  void testBuilderDataTypeId() {
    // Arrange
    Builder builderResult = ImmutableDataTypeUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypeId(1L));
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(DataTypeUsage)} with {@code DataTypeUsage}.
   * <p>
   * Method under test: {@link Builder#from(DataTypeUsage)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeUsage) with 'DataTypeUsage'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataTypeUsage)"})
  void testBuilderFromWithDataTypeUsage() {
    // Arrange
    Builder builderResult = ImmutableDataTypeUsage.builder();
    DataTypeUsage instance = mock(DataTypeUsage.class);
    when(instance.dataTypeId()).thenThrow(new IllegalStateException("instance"));
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).provenance();
    verify(instance).dataTypeId();
  }

  /**
   * Test Builder {@link Builder#from(DataTypeUsage)} with {@code DataTypeUsage}.
   * <p>
   * Method under test: {@link Builder#from(DataTypeUsage)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeUsage) with 'DataTypeUsage'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataTypeUsage)"})
  void testBuilderFromWithDataTypeUsage2() {
    // Arrange
    Builder builderResult = ImmutableDataTypeUsage.builder();
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
   * Test Builder {@link Builder#from(DataTypeUsage)} with {@code DataTypeUsage}.
   * <ul>
   *   <li>Then builder build provenance is {@code Provenance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DataTypeUsage)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeUsage) with 'DataTypeUsage'; then builder build provenance is 'Provenance'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataTypeUsage)"})
  void testBuilderFromWithDataTypeUsage_thenBuilderBuildProvenanceIsProvenance() {
    // Arrange
    Builder builderResult = ImmutableDataTypeUsage.builder();
    DataTypeUsage instance = mock(DataTypeUsage.class);
    when(instance.usage()).thenReturn(mock(UsageInfo.class));
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   * <ul>
   *   <li>Given {@code Provenance}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'; given 'Provenance'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider_givenProvenance_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeUsage.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#usage(UsageInfo)}.
   * <ul>
   *   <li>When {@link UsageInfo}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#usage(UsageInfo)}
   */
  @Test
  @DisplayName("Test Builder usage(UsageInfo); when UsageInfo; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.usage(UsageInfo)"})
  void testBuilderUsage_whenUsageInfo_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.usage(mock(UsageInfo.class)));
  }

  /**
   * Test Json {@link Json#dataTypeId()}.
   * <p>
   * Method under test: {@link Json#dataTypeId()}
   */
  @Test
  @DisplayName("Test Json dataTypeId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.dataTypeId()"})
  void testJsonDataTypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).dataTypeId());
  }

  /**
   * Test Json {@link Json#entityReference()}.
   * <p>
   * Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityReference());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDataTypeId(Long)}
   *   <li>{@link Json#setEntityReference(EntityReference)}
   *   <li>{@link Json#setProvenance(String)}
   *   <li>{@link Json#setUsage(UsageInfo)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setDataTypeId(Long)",
      "void Json.setEntityReference(EntityReference)", "void Json.setProvenance(String)",
      "void Json.setUsage(UsageInfo)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDataTypeId(1L);
    actualJson.setEntityReference(null);
    actualJson.setProvenance("Provenance");
    actualJson.setUsage(null);

    // Assert
    assertEquals(1L, actualJson.dataTypeId.longValue());
  }

  /**
   * Test Json {@link Json#provenance()}.
   * <p>
   * Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).provenance());
  }

  /**
   * Test Json {@link Json#usage()}.
   * <p>
   * Method under test: {@link Json#usage()}
   */
  @Test
  @DisplayName("Test Json usage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UsageInfo Json.usage()"})
  void testJsonUsage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).usage());
  }
}
