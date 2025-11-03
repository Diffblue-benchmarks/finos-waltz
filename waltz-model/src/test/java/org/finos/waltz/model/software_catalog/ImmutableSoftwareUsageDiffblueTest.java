package org.finos.waltz.model.software_catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.software_catalog.ImmutableSoftwareUsage.Builder;
import org.finos.waltz.model.software_catalog.ImmutableSoftwareUsage.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSoftwareUsageDiffblueTest {
  /**
   * Test {@link ImmutableSoftwareUsage#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSoftwareUsage#builder()}
   *   <li>{@link ImmutableSoftwareUsage#licenceId(Long)}
   *   <li>{@link ImmutableSoftwareUsage#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSoftwareUsage Builder.build()", "Builder Builder.licenceId(Long)",
      "Builder Builder.provenance(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualLicenceIdResult = ImmutableSoftwareUsage.builder().licenceId(1L);

    // Assert
    assertSame(actualLicenceIdResult, actualLicenceIdResult.provenance("Provenance"));
  }

  /**
   * Test Builder {@link Builder#applicationId(long)}.
   * <p>
   * Method under test: {@link Builder#applicationId(long)}
   */
  @Test
  @DisplayName("Test Builder applicationId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.applicationId(long)"})
  void testBuilderApplicationId() {
    // Arrange
    Builder builderResult = ImmutableSoftwareUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applicationId(1L));
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
    Builder builderResult = ImmutableSoftwareUsage.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SoftwareUsage)} with {@code SoftwareUsage}.
   * <ul>
   *   <li>Then builder build licenceId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SoftwareUsage)}
   */
  @Test
  @DisplayName("Test Builder from(SoftwareUsage) with 'SoftwareUsage'; then builder build licenceId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SoftwareUsage)"})
  void testBuilderFromWithSoftwareUsage_thenBuilderBuildLicenceIdIsNull() {
    // Arrange
    Builder builderResult = ImmutableSoftwareUsage.builder();
    SoftwareUsage instance = mock(SoftwareUsage.class);
    when(instance.licenceId()).thenReturn(null);
    when(instance.applicationId()).thenReturn(1L);
    when(instance.softwarePackageId()).thenReturn(1L);
    when(instance.softwareVersionId()).thenReturn(1L);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    verify(instance).applicationId();
    verify(instance).licenceId();
    verify(instance).softwarePackageId();
    verify(instance).softwareVersionId();
    ImmutableSoftwareUsage buildResult = builderResult.build();
    assertEquals("Provenance", buildResult.provenance());
    assertNull(buildResult.licenceId());
    assertEquals(1L, buildResult.applicationId());
    assertEquals(1L, buildResult.softwarePackageId());
    assertEquals(1L, buildResult.softwareVersionId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SoftwareUsage)} with {@code SoftwareUsage}.
   * <ul>
   *   <li>Then builder build licenceId longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SoftwareUsage)}
   */
  @Test
  @DisplayName("Test Builder from(SoftwareUsage) with 'SoftwareUsage'; then builder build licenceId longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SoftwareUsage)"})
  void testBuilderFromWithSoftwareUsage_thenBuilderBuildLicenceIdLongValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableSoftwareUsage.builder();
    SoftwareUsage instance = mock(SoftwareUsage.class);
    when(instance.licenceId()).thenReturn(1L);
    when(instance.applicationId()).thenReturn(1L);
    when(instance.softwarePackageId()).thenReturn(1L);
    when(instance.softwareVersionId()).thenReturn(1L);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    verify(instance).applicationId();
    verify(instance).licenceId();
    verify(instance).softwarePackageId();
    verify(instance).softwareVersionId();
    ImmutableSoftwareUsage buildResult = builderResult.build();
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1L, buildResult.licenceId().longValue());
    assertEquals(1L, buildResult.applicationId());
    assertEquals(1L, buildResult.softwarePackageId());
    assertEquals(1L, buildResult.softwareVersionId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SoftwareUsage)} with {@code SoftwareUsage}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SoftwareUsage)}
   */
  @Test
  @DisplayName("Test Builder from(SoftwareUsage) with 'SoftwareUsage'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SoftwareUsage)"})
  void testBuilderFromWithSoftwareUsage_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSoftwareUsage.builder();
    SoftwareUsage instance = mock(SoftwareUsage.class);
    when(instance.softwareVersionId()).thenThrow(new IllegalStateException("instance"));
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).provenance();
    verify(instance).softwareVersionId();
  }

  /**
   * Test Builder {@link Builder#softwarePackageId(long)}.
   * <p>
   * Method under test: {@link Builder#softwarePackageId(long)}
   */
  @Test
  @DisplayName("Test Builder softwarePackageId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.softwarePackageId(long)"})
  void testBuilderSoftwarePackageId() {
    // Arrange
    Builder builderResult = ImmutableSoftwareUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.softwarePackageId(1L));
  }

  /**
   * Test Builder {@link Builder#softwareVersionId(long)}.
   * <p>
   * Method under test: {@link Builder#softwareVersionId(long)}
   */
  @Test
  @DisplayName("Test Builder softwareVersionId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.softwareVersionId(long)"})
  void testBuilderSoftwareVersionId() {
    // Arrange
    Builder builderResult = ImmutableSoftwareUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.softwareVersionId(1L));
  }

  /**
   * Test Json {@link Json#applicationId()}.
   * <p>
   * Method under test: {@link Json#applicationId()}
   */
  @Test
  @DisplayName("Test Json applicationId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.applicationId()"})
  void testJsonApplicationId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).applicationId());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setLicenceId(Long)}
   *   <li>{@link Json#setProvenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setLicenceId(Long)", "void Json.setProvenance(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setLicenceId(1L);
    actualJson.setProvenance("Provenance");

    // Assert
    assertEquals(1L, actualJson.licenceId.longValue());
  }

  /**
   * Test Json {@link Json#licenceId()}.
   * <p>
   * Method under test: {@link Json#licenceId()}
   */
  @Test
  @DisplayName("Test Json licenceId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.licenceId()"})
  void testJsonLicenceId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).licenceId());
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
   * Test Json {@link Json#setApplicationId(long)}.
   * <p>
   * Method under test: {@link Json#setApplicationId(long)}
   */
  @Test
  @DisplayName("Test Json setApplicationId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setApplicationId(long)"})
  void testJsonSetApplicationId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setApplicationId(1L);

    // Assert
    assertEquals(1L, json.applicationId);
    assertTrue(json.applicationIdIsSet);
  }

  /**
   * Test Json {@link Json#setSoftwarePackageId(long)}.
   * <p>
   * Method under test: {@link Json#setSoftwarePackageId(long)}
   */
  @Test
  @DisplayName("Test Json setSoftwarePackageId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setSoftwarePackageId(long)"})
  void testJsonSetSoftwarePackageId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setSoftwarePackageId(1L);

    // Assert
    assertEquals(1L, json.softwarePackageId);
    assertTrue(json.softwarePackageIdIsSet);
  }

  /**
   * Test Json {@link Json#setSoftwareVersionId(long)}.
   * <p>
   * Method under test: {@link Json#setSoftwareVersionId(long)}
   */
  @Test
  @DisplayName("Test Json setSoftwareVersionId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setSoftwareVersionId(long)"})
  void testJsonSetSoftwareVersionId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setSoftwareVersionId(1L);

    // Assert
    assertEquals(1L, json.softwareVersionId);
    assertTrue(json.softwareVersionIdIsSet);
  }

  /**
   * Test Json {@link Json#softwarePackageId()}.
   * <p>
   * Method under test: {@link Json#softwarePackageId()}
   */
  @Test
  @DisplayName("Test Json softwarePackageId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.softwarePackageId()"})
  void testJsonSoftwarePackageId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).softwarePackageId());
  }

  /**
   * Test Json {@link Json#softwareVersionId()}.
   * <p>
   * Method under test: {@link Json#softwareVersionId()}
   */
  @Test
  @DisplayName("Test Json softwareVersionId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.softwareVersionId()"})
  void testJsonSoftwareVersionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).softwareVersionId());
  }
}
