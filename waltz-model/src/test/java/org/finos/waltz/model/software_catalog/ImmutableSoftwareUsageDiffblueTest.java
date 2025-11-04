package org.finos.waltz.model.software_catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableSoftwareUsageDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSoftwareUsage#builder()}
   *   <li>{@link ImmutableSoftwareUsage#licenceId(Long)}
   *   <li>{@link ImmutableSoftwareUsage#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableSoftwareUsage.Builder actualLicenceIdResult = ImmutableSoftwareUsage.builder().licenceId(1L);

    // Assert
    assertSame(actualLicenceIdResult, actualLicenceIdResult.provenance("Provenance"));
  }

  /**
   * Method under test: {@link ImmutableSoftwareUsage.Builder#applicationId(long)}
   */
  @Test
  void testBuilderApplicationId() {
    // Arrange
    ImmutableSoftwareUsage.Builder builderResult = ImmutableSoftwareUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applicationId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareUsage.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSoftwareUsage.Builder builderResult = ImmutableSoftwareUsage.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableSoftwareUsage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSoftwareUsage.Builder#from(SoftwareUsage)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSoftwareUsage.Builder builderResult = ImmutableSoftwareUsage.builder();
    SoftwareUsage instance = mock(SoftwareUsage.class);
    when(instance.licenceId()).thenReturn(1L);
    when(instance.applicationId()).thenReturn(1L);
    when(instance.softwarePackageId()).thenReturn(1L);
    when(instance.softwareVersionId()).thenReturn(1L);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableSoftwareUsage.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableSoftwareUsage.Builder#from(SoftwareUsage)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSoftwareUsage.Builder builderResult = ImmutableSoftwareUsage.builder();
    SoftwareUsage instance = mock(SoftwareUsage.class);
    when(instance.softwareVersionId()).thenThrow(new IllegalStateException("instance"));
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).provenance();
    verify(instance).softwareVersionId();
  }

  /**
   * Method under test: {@link ImmutableSoftwareUsage.Builder#from(SoftwareUsage)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSoftwareUsage.Builder builderResult = ImmutableSoftwareUsage.builder();
    SoftwareUsage instance = mock(SoftwareUsage.class);
    when(instance.licenceId()).thenReturn(null);
    when(instance.applicationId()).thenReturn(1L);
    when(instance.softwarePackageId()).thenReturn(1L);
    when(instance.softwareVersionId()).thenReturn(1L);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableSoftwareUsage.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableSoftwareUsage.Builder#softwarePackageId(long)}
   */
  @Test
  void testBuilderSoftwarePackageId() {
    // Arrange
    ImmutableSoftwareUsage.Builder builderResult = ImmutableSoftwareUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.softwarePackageId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareUsage.Builder#softwareVersionId(long)}
   */
  @Test
  void testBuilderSoftwareVersionId() {
    // Arrange
    ImmutableSoftwareUsage.Builder builderResult = ImmutableSoftwareUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.softwareVersionId(1L));
  }

  /**
   * Method under test: {@link ImmutableSoftwareUsage#copyOf(SoftwareUsage)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SoftwareUsage instance = mock(SoftwareUsage.class);
    when(instance.licenceId()).thenReturn(1L);
    when(instance.applicationId()).thenReturn(1L);
    when(instance.softwarePackageId()).thenReturn(1L);
    when(instance.softwareVersionId()).thenReturn(1L);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableSoftwareUsage actualCopyOfResult = ImmutableSoftwareUsage.copyOf(instance);

    // Assert
    verify(instance).provenance();
    verify(instance).applicationId();
    verify(instance).licenceId();
    verify(instance).softwarePackageId();
    verify(instance).softwareVersionId();
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.licenceId().longValue());
    assertEquals(1L, actualCopyOfResult.applicationId());
    assertEquals(1L, actualCopyOfResult.softwarePackageId());
    assertEquals(1L, actualCopyOfResult.softwareVersionId());
  }

  /**
   * Method under test: {@link ImmutableSoftwareUsage#copyOf(SoftwareUsage)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    SoftwareUsage instance = mock(SoftwareUsage.class);
    when(instance.licenceId()).thenReturn(null);
    when(instance.applicationId()).thenReturn(1L);
    when(instance.softwarePackageId()).thenReturn(1L);
    when(instance.softwareVersionId()).thenReturn(1L);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableSoftwareUsage actualCopyOfResult = ImmutableSoftwareUsage.copyOf(instance);

    // Assert
    verify(instance).provenance();
    verify(instance).applicationId();
    verify(instance).licenceId();
    verify(instance).softwarePackageId();
    verify(instance).softwareVersionId();
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.licenceId());
    assertEquals(1L, actualCopyOfResult.applicationId());
    assertEquals(1L, actualCopyOfResult.softwarePackageId());
    assertEquals(1L, actualCopyOfResult.softwareVersionId());
  }

  /**
   * Method under test: {@link ImmutableSoftwareUsage.Json#applicationId()}
   */
  @Test
  void testJsonApplicationId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwareUsage.Json()).applicationId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableSoftwareUsage.Json}
   *   <li>{@link ImmutableSoftwareUsage.Json#setLicenceId(Long)}
   *   <li>{@link ImmutableSoftwareUsage.Json#setProvenance(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableSoftwareUsage.Json actualJson = new ImmutableSoftwareUsage.Json();
    actualJson.setLicenceId(1L);
    actualJson.setProvenance("Provenance");

    // Assert
    assertEquals(1L, actualJson.licenceId.longValue());
  }

  /**
   * Method under test: {@link ImmutableSoftwareUsage.Json#licenceId()}
   */
  @Test
  void testJsonLicenceId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwareUsage.Json()).licenceId());
  }

  /**
   * Method under test: {@link ImmutableSoftwareUsage.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwareUsage.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableSoftwareUsage.Json#setApplicationId(long)}
   */
  @Test
  void testJsonSetApplicationId() {
    // Arrange
    ImmutableSoftwareUsage.Json json = new ImmutableSoftwareUsage.Json();

    // Act
    json.setApplicationId(1L);

    // Assert
    assertEquals(1L, json.applicationId);
    assertTrue(json.applicationIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareUsage.Json#setSoftwarePackageId(long)}
   */
  @Test
  void testJsonSetSoftwarePackageId() {
    // Arrange
    ImmutableSoftwareUsage.Json json = new ImmutableSoftwareUsage.Json();

    // Act
    json.setSoftwarePackageId(1L);

    // Assert
    assertEquals(1L, json.softwarePackageId);
    assertTrue(json.softwarePackageIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareUsage.Json#setSoftwareVersionId(long)}
   */
  @Test
  void testJsonSetSoftwareVersionId() {
    // Arrange
    ImmutableSoftwareUsage.Json json = new ImmutableSoftwareUsage.Json();

    // Act
    json.setSoftwareVersionId(1L);

    // Assert
    assertEquals(1L, json.softwareVersionId);
    assertTrue(json.softwareVersionIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableSoftwareUsage.Json#softwarePackageId()}
   */
  @Test
  void testJsonSoftwarePackageId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwareUsage.Json()).softwarePackageId());
  }

  /**
   * Method under test: {@link ImmutableSoftwareUsage.Json#softwareVersionId()}
   */
  @Test
  void testJsonSoftwareVersionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwareUsage.Json()).softwareVersionId());
  }
}
