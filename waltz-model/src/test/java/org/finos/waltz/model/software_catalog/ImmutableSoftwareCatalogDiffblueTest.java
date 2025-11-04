package org.finos.waltz.model.software_catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ch.qos.logback.core.util.COWArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.UserTimestamp;
import org.junit.jupiter.api.Test;

class ImmutableSoftwareCatalogDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSoftwareCatalog.Builder#addAllPackages(Iterable)}
   */
  @Test
  void testBuilderAddAllPackages() {
    // Arrange
    ImmutableSoftwareCatalog.Builder builderResult = ImmutableSoftwareCatalog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllPackages(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareCatalog.Builder#addAllUsages(Iterable)}
   */
  @Test
  void testBuilderAddAllUsages() {
    // Arrange
    ImmutableSoftwareCatalog.Builder builderResult = ImmutableSoftwareCatalog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllUsages(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareCatalog.Builder#addAllUsages(Iterable)}
   */
  @Test
  void testBuilderAddAllUsages2() {
    // Arrange
    ImmutableSoftwarePackage.Json element = new ImmutableSoftwarePackage.Json();
    Optional<UserTimestamp> created = Optional.of(mock(UserTimestamp.class));
    element.setCreated(created);
    ImmutableSoftwareCatalog.Builder builderResult = ImmutableSoftwareCatalog.builder();
    builderResult.addPackages(element);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllUsages(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareCatalog.Builder#addAllVersions(Iterable)}
   */
  @Test
  void testBuilderAddAllVersions() {
    // Arrange
    ImmutableSoftwareCatalog.Builder builderResult = ImmutableSoftwareCatalog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllVersions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareCatalog.Builder#addPackages(SoftwarePackage)}
   */
  @Test
  void testBuilderAddPackages() {
    // Arrange
    ImmutableSoftwareCatalog.Builder builderResult = ImmutableSoftwareCatalog.builder();
    ImmutableSoftwarePackage.Json element = new ImmutableSoftwarePackage.Json();

    // Act
    ImmutableSoftwareCatalog.Builder actualAddPackagesResult = builderResult.addPackages(element);

    // Assert
    List<SoftwarePackage> packagesResult = builderResult.build().packages();
    assertEquals(1, packagesResult.size());
    assertSame(element, packagesResult.get(0));
    assertSame(builderResult, actualAddPackagesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareCatalog.Builder#addPackages(SoftwarePackage)}
   */
  @Test
  void testBuilderAddPackages2() {
    // Arrange
    ImmutableSoftwareCatalog.Builder builderResult = ImmutableSoftwareCatalog.builder();

    ImmutableSoftwarePackage.Json element = new ImmutableSoftwarePackage.Json();
    Optional<UserTimestamp> created = Optional.of(mock(UserTimestamp.class));
    element.setCreated(created);

    // Act
    ImmutableSoftwareCatalog.Builder actualAddPackagesResult = builderResult.addPackages(element);

    // Assert
    List<SoftwarePackage> packagesResult = builderResult.build().packages();
    assertEquals(1, packagesResult.size());
    assertSame(element, packagesResult.get(0));
    assertSame(builderResult, actualAddPackagesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareCatalog.Builder#addPackages(SoftwarePackage[])}
   */
  @Test
  void testBuilderAddPackages3() {
    // Arrange
    ImmutableSoftwareCatalog.Builder builderResult = ImmutableSoftwareCatalog.builder();
    ImmutableSoftwarePackage.Json json = new ImmutableSoftwarePackage.Json();

    // Act
    ImmutableSoftwareCatalog.Builder actualAddPackagesResult = builderResult.addPackages(json);

    // Assert
    List<SoftwarePackage> packagesResult = builderResult.build().packages();
    assertEquals(1, packagesResult.size());
    assertSame(json, packagesResult.get(0));
    assertSame(builderResult, actualAddPackagesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareCatalog.Builder#addPackages(SoftwarePackage[])}
   */
  @Test
  void testBuilderAddPackages4() {
    // Arrange
    ImmutableSoftwareCatalog.Builder builderResult = ImmutableSoftwareCatalog.builder();

    ImmutableSoftwarePackage.Json json = new ImmutableSoftwarePackage.Json();
    Optional<UserTimestamp> created = Optional.of(mock(UserTimestamp.class));
    json.setCreated(created);

    // Act
    ImmutableSoftwareCatalog.Builder actualAddPackagesResult = builderResult.addPackages(json);

    // Assert
    List<SoftwarePackage> packagesResult = builderResult.build().packages();
    assertEquals(1, packagesResult.size());
    assertSame(json, packagesResult.get(0));
    assertSame(builderResult, actualAddPackagesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareCatalog.Builder#addUsages(SoftwareUsage)}
   */
  @Test
  void testBuilderAddUsages() {
    // Arrange
    ImmutableSoftwareCatalog.Builder builderResult = ImmutableSoftwareCatalog.builder();
    ImmutableSoftwareUsage.Json element = new ImmutableSoftwareUsage.Json();

    // Act
    ImmutableSoftwareCatalog.Builder actualAddUsagesResult = builderResult.addUsages(element);

    // Assert
    List<SoftwareUsage> usagesResult = builderResult.build().usages();
    assertEquals(1, usagesResult.size());
    assertSame(element, usagesResult.get(0));
    assertSame(builderResult, actualAddUsagesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareCatalog.Builder#addUsages(SoftwareUsage[])}
   */
  @Test
  void testBuilderAddUsages2() {
    // Arrange
    ImmutableSoftwareCatalog.Builder builderResult = ImmutableSoftwareCatalog.builder();
    ImmutableSoftwareUsage.Json json = new ImmutableSoftwareUsage.Json();

    // Act
    ImmutableSoftwareCatalog.Builder actualAddUsagesResult = builderResult.addUsages(json);

    // Assert
    List<SoftwareUsage> usagesResult = builderResult.build().usages();
    assertEquals(1, usagesResult.size());
    assertSame(json, usagesResult.get(0));
    assertSame(builderResult, actualAddUsagesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareCatalog.Builder#addVersions(SoftwareVersion)}
   */
  @Test
  void testBuilderAddVersions() {
    // Arrange
    ImmutableSoftwareCatalog.Builder builderResult = ImmutableSoftwareCatalog.builder();
    ImmutableSoftwareVersion.Json element = new ImmutableSoftwareVersion.Json();

    // Act
    ImmutableSoftwareCatalog.Builder actualAddVersionsResult = builderResult.addVersions(element);

    // Assert
    List<SoftwareVersion> versionsResult = builderResult.build().versions();
    assertEquals(1, versionsResult.size());
    assertSame(element, versionsResult.get(0));
    assertSame(builderResult, actualAddVersionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareCatalog.Builder#addVersions(SoftwareVersion)}
   */
  @Test
  void testBuilderAddVersions2() {
    // Arrange
    ImmutableSoftwareCatalog.Builder builderResult = ImmutableSoftwareCatalog.builder();

    ImmutableSoftwareVersion.Json element = new ImmutableSoftwareVersion.Json();
    Optional<UserTimestamp> created = Optional.of(mock(UserTimestamp.class));
    element.setCreated(created);

    // Act
    ImmutableSoftwareCatalog.Builder actualAddVersionsResult = builderResult.addVersions(element);

    // Assert
    List<SoftwareVersion> versionsResult = builderResult.build().versions();
    assertEquals(1, versionsResult.size());
    assertSame(element, versionsResult.get(0));
    assertSame(builderResult, actualAddVersionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareCatalog.Builder#addVersions(SoftwareVersion[])}
   */
  @Test
  void testBuilderAddVersions3() {
    // Arrange
    ImmutableSoftwareCatalog.Builder builderResult = ImmutableSoftwareCatalog.builder();
    ImmutableSoftwareVersion.Json json = new ImmutableSoftwareVersion.Json();

    // Act
    ImmutableSoftwareCatalog.Builder actualAddVersionsResult = builderResult.addVersions(json);

    // Assert
    List<SoftwareVersion> versionsResult = builderResult.build().versions();
    assertEquals(1, versionsResult.size());
    assertSame(json, versionsResult.get(0));
    assertSame(builderResult, actualAddVersionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareCatalog.Builder#addVersions(SoftwareVersion[])}
   */
  @Test
  void testBuilderAddVersions4() {
    // Arrange
    ImmutableSoftwareCatalog.Builder builderResult = ImmutableSoftwareCatalog.builder();

    ImmutableSoftwareVersion.Json json = new ImmutableSoftwareVersion.Json();
    Optional<UserTimestamp> created = Optional.of(mock(UserTimestamp.class));
    json.setCreated(created);

    // Act
    ImmutableSoftwareCatalog.Builder actualAddVersionsResult = builderResult.addVersions(json);

    // Assert
    List<SoftwareVersion> versionsResult = builderResult.build().versions();
    assertEquals(1, versionsResult.size());
    assertSame(json, versionsResult.get(0));
    assertSame(builderResult, actualAddVersionsResult);
  }

  /**
   * Method under test: {@link ImmutableSoftwareCatalog.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableSoftwareCatalog.builder().build().packages().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareCatalog.Builder#from(SoftwareCatalog)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSoftwareCatalog.Builder builderResult = ImmutableSoftwareCatalog.builder();
    SoftwareCatalog instance = mock(SoftwareCatalog.class);
    when(instance.packages()).thenReturn(new ArrayList<>());
    when(instance.usages()).thenReturn(new ArrayList<>());
    when(instance.versions()).thenReturn(new ArrayList<>());

    // Act
    ImmutableSoftwareCatalog.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).packages();
    verify(instance).usages();
    verify(instance).versions();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareCatalog.Builder#from(SoftwareCatalog)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSoftwareCatalog.Builder builderResult = ImmutableSoftwareCatalog.builder();

    ArrayList<SoftwarePackage> softwarePackageList = new ArrayList<>();
    ImmutableSoftwarePackage.Json json = new ImmutableSoftwarePackage.Json();
    softwarePackageList.add(json);
    SoftwareCatalog instance = mock(SoftwareCatalog.class);
    when(instance.packages()).thenReturn(softwarePackageList);
    when(instance.usages()).thenReturn(new ArrayList<>());
    when(instance.versions()).thenReturn(new ArrayList<>());

    // Act
    ImmutableSoftwareCatalog.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).packages();
    verify(instance).usages();
    verify(instance).versions();
    List<SoftwarePackage> packagesResult = builderResult.build().packages();
    assertEquals(1, packagesResult.size());
    assertSame(json, packagesResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareCatalog.Builder#from(SoftwareCatalog)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSoftwareCatalog.Builder builderResult = ImmutableSoftwareCatalog.builder();

    ArrayList<SoftwareUsage> softwareUsageList = new ArrayList<>();
    ImmutableSoftwareUsage.Json json = new ImmutableSoftwareUsage.Json();
    softwareUsageList.add(json);
    SoftwareCatalog instance = mock(SoftwareCatalog.class);
    when(instance.packages()).thenReturn(new ArrayList<>());
    when(instance.usages()).thenReturn(softwareUsageList);
    when(instance.versions()).thenReturn(new ArrayList<>());

    // Act
    ImmutableSoftwareCatalog.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).packages();
    verify(instance).usages();
    verify(instance).versions();
    List<SoftwareUsage> usagesResult = builderResult.build().usages();
    assertEquals(1, usagesResult.size());
    assertSame(json, usagesResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareCatalog.Builder#from(SoftwareCatalog)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSoftwareCatalog.Builder builderResult = ImmutableSoftwareCatalog.builder();

    ArrayList<SoftwareVersion> softwareVersionList = new ArrayList<>();
    ImmutableSoftwareVersion.Json json = new ImmutableSoftwareVersion.Json();
    softwareVersionList.add(json);
    SoftwareCatalog instance = mock(SoftwareCatalog.class);
    when(instance.packages()).thenReturn(new ArrayList<>());
    when(instance.usages()).thenReturn(new ArrayList<>());
    when(instance.versions()).thenReturn(softwareVersionList);

    // Act
    ImmutableSoftwareCatalog.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).packages();
    verify(instance).usages();
    verify(instance).versions();
    List<SoftwareVersion> versionsResult = builderResult.build().versions();
    assertEquals(1, versionsResult.size());
    assertSame(json, versionsResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareCatalog.Builder#packages(Iterable)}
   */
  @Test
  void testBuilderPackages() {
    // Arrange
    ImmutableSoftwareCatalog.Builder builderResult = ImmutableSoftwareCatalog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.packages(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableSoftwareCatalog.Builder#usages(Iterable)}
   */
  @Test
  void testBuilderUsages() {
    // Arrange
    ImmutableSoftwareCatalog.Builder builderResult = ImmutableSoftwareCatalog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.usages(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableSoftwareCatalog.Builder#usages(Iterable)}
   */
  @Test
  void testBuilderUsages2() {
    // Arrange
    ImmutableSoftwarePackage.Json element = new ImmutableSoftwarePackage.Json();
    Optional<UserTimestamp> created = Optional.of(mock(UserTimestamp.class));
    element.setCreated(created);
    ImmutableSoftwareCatalog.Builder builderResult = ImmutableSoftwareCatalog.builder();
    builderResult.addPackages(element);

    // Act and Assert
    assertSame(builderResult, builderResult.usages(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareCatalog.Builder#versions(Iterable)}
   */
  @Test
  void testBuilderVersions() {
    // Arrange
    ImmutableSoftwareCatalog.Builder builderResult = ImmutableSoftwareCatalog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.versions(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableSoftwareCatalog#copyOf(SoftwareCatalog)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SoftwareCatalog instance = mock(SoftwareCatalog.class);
    when(instance.packages()).thenReturn(new ArrayList<>());
    when(instance.usages()).thenReturn(new ArrayList<>());
    when(instance.versions()).thenReturn(new ArrayList<>());

    // Act
    ImmutableSoftwareCatalog actualCopyOfResult = ImmutableSoftwareCatalog.copyOf(instance);

    // Assert
    verify(instance).packages();
    verify(instance).usages();
    verify(instance).versions();
    List<SoftwarePackage> packagesResult = actualCopyOfResult.packages();
    assertTrue(packagesResult.isEmpty());
    assertSame(packagesResult, actualCopyOfResult.usages());
    assertSame(packagesResult, actualCopyOfResult.versions());
  }

  /**
   * Method under test: {@link ImmutableSoftwareCatalog#copyOf(SoftwareCatalog)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<SoftwarePackage> softwarePackageList = new ArrayList<>();
    softwarePackageList.add(new ImmutableSoftwarePackage.Json());
    SoftwareCatalog instance = mock(SoftwareCatalog.class);
    when(instance.packages()).thenReturn(softwarePackageList);
    when(instance.usages()).thenReturn(new ArrayList<>());
    when(instance.versions()).thenReturn(new ArrayList<>());

    // Act
    ImmutableSoftwareCatalog actualCopyOfResult = ImmutableSoftwareCatalog.copyOf(instance);

    // Assert
    verify(instance).packages();
    verify(instance).usages();
    verify(instance).versions();
    List<SoftwareUsage> usagesResult = actualCopyOfResult.usages();
    assertTrue(usagesResult.isEmpty());
    assertEquals(softwarePackageList, actualCopyOfResult.packages());
    assertSame(usagesResult, actualCopyOfResult.versions());
  }

  /**
   * Method under test: {@link ImmutableSoftwareCatalog#copyOf(SoftwareCatalog)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<SoftwarePackage> softwarePackageList = new ArrayList<>();
    softwarePackageList.add(new ImmutableSoftwarePackage.Json());
    softwarePackageList.add(new ImmutableSoftwarePackage.Json());
    SoftwareCatalog instance = mock(SoftwareCatalog.class);
    when(instance.packages()).thenReturn(softwarePackageList);
    when(instance.usages()).thenReturn(new ArrayList<>());
    when(instance.versions()).thenReturn(new ArrayList<>());

    // Act
    ImmutableSoftwareCatalog actualCopyOfResult = ImmutableSoftwareCatalog.copyOf(instance);

    // Assert
    verify(instance).packages();
    verify(instance).usages();
    verify(instance).versions();
    List<SoftwareUsage> usagesResult = actualCopyOfResult.usages();
    assertTrue(usagesResult.isEmpty());
    assertEquals(softwarePackageList, actualCopyOfResult.packages());
    assertSame(usagesResult, actualCopyOfResult.versions());
  }

  /**
   * Method under test: {@link ImmutableSoftwareCatalog#copyOf(SoftwareCatalog)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ArrayList<SoftwareUsage> softwareUsageList = new ArrayList<>();
    softwareUsageList.add(new ImmutableSoftwareUsage.Json());
    SoftwareCatalog instance = mock(SoftwareCatalog.class);
    when(instance.packages()).thenReturn(new ArrayList<>());
    when(instance.usages()).thenReturn(softwareUsageList);
    when(instance.versions()).thenReturn(new ArrayList<>());

    // Act
    ImmutableSoftwareCatalog actualCopyOfResult = ImmutableSoftwareCatalog.copyOf(instance);

    // Assert
    verify(instance).packages();
    verify(instance).usages();
    verify(instance).versions();
    List<SoftwarePackage> packagesResult = actualCopyOfResult.packages();
    assertTrue(packagesResult.isEmpty());
    assertEquals(softwareUsageList, actualCopyOfResult.usages());
    assertSame(packagesResult, actualCopyOfResult.versions());
  }

  /**
   * Method under test: {@link ImmutableSoftwareCatalog#copyOf(SoftwareCatalog)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    ArrayList<SoftwareVersion> softwareVersionList = new ArrayList<>();
    softwareVersionList.add(new ImmutableSoftwareVersion.Json());
    SoftwareCatalog instance = mock(SoftwareCatalog.class);
    when(instance.packages()).thenReturn(new ArrayList<>());
    when(instance.usages()).thenReturn(new ArrayList<>());
    when(instance.versions()).thenReturn(softwareVersionList);

    // Act
    ImmutableSoftwareCatalog actualCopyOfResult = ImmutableSoftwareCatalog.copyOf(instance);

    // Assert
    verify(instance).packages();
    verify(instance).usages();
    verify(instance).versions();
    List<SoftwarePackage> packagesResult = actualCopyOfResult.packages();
    assertTrue(packagesResult.isEmpty());
    assertEquals(softwareVersionList, actualCopyOfResult.versions());
    assertSame(packagesResult, actualCopyOfResult.usages());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareCatalog#fromJson(ImmutableSoftwareCatalog.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSoftwareCatalog.Json json = new ImmutableSoftwareCatalog.Json();

    // Act
    ImmutableSoftwareCatalog actualFromJsonResult = ImmutableSoftwareCatalog.fromJson(json);

    // Assert
    List<SoftwarePackage> packagesResult = actualFromJsonResult.packages();
    assertTrue(packagesResult.isEmpty());
    List<SoftwareVersion> softwareVersionList = json.versions;
    assertSame(softwareVersionList, packagesResult);
    assertSame(softwareVersionList, actualFromJsonResult.usages());
    assertSame(softwareVersionList, actualFromJsonResult.versions());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareCatalog#fromJson(ImmutableSoftwareCatalog.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableSoftwareCatalog.Json json = new ImmutableSoftwareCatalog.Json();
    json.setPackages(null);
    json.setUsages(null);
    json.setVersions(null);

    // Act
    ImmutableSoftwareCatalog actualFromJsonResult = ImmutableSoftwareCatalog.fromJson(json);

    // Assert
    List<SoftwarePackage> packagesResult = actualFromJsonResult.packages();
    assertTrue(packagesResult.isEmpty());
    assertSame(packagesResult, actualFromJsonResult.usages());
    assertSame(packagesResult, actualFromJsonResult.versions());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareCatalog#fromJson(ImmutableSoftwareCatalog.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ArrayList<SoftwareVersion> versions = new ArrayList<>();
    versions.add(new ImmutableSoftwareVersion.Json());

    ImmutableSoftwareCatalog.Json json = new ImmutableSoftwareCatalog.Json();
    json.setPackages(null);
    json.setUsages(null);
    json.setVersions(versions);

    // Act
    ImmutableSoftwareCatalog actualFromJsonResult = ImmutableSoftwareCatalog.fromJson(json);

    // Assert
    List<SoftwarePackage> packagesResult = actualFromJsonResult.packages();
    assertTrue(packagesResult.isEmpty());
    assertEquals(versions, actualFromJsonResult.versions());
    assertSame(packagesResult, actualFromJsonResult.usages());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareCatalog#fromJson(ImmutableSoftwareCatalog.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    ArrayList<SoftwareUsage> usages = new ArrayList<>();
    usages.add(new ImmutableSoftwareUsage.Json());

    ImmutableSoftwareCatalog.Json json = new ImmutableSoftwareCatalog.Json();
    json.setPackages(null);
    json.setUsages(usages);
    json.setVersions(null);

    // Act
    ImmutableSoftwareCatalog actualFromJsonResult = ImmutableSoftwareCatalog.fromJson(json);

    // Assert
    List<SoftwarePackage> packagesResult = actualFromJsonResult.packages();
    assertTrue(packagesResult.isEmpty());
    assertEquals(usages, actualFromJsonResult.usages());
    assertSame(packagesResult, actualFromJsonResult.versions());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareCatalog#fromJson(ImmutableSoftwareCatalog.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    ArrayList<SoftwarePackage> packages = new ArrayList<>();
    packages.add(new ImmutableSoftwarePackage.Json());

    ImmutableSoftwareCatalog.Json json = new ImmutableSoftwareCatalog.Json();
    json.setPackages(packages);
    json.setUsages(null);
    json.setVersions(null);

    // Act
    ImmutableSoftwareCatalog actualFromJsonResult = ImmutableSoftwareCatalog.fromJson(json);

    // Assert
    List<SoftwareUsage> usagesResult = actualFromJsonResult.usages();
    assertTrue(usagesResult.isEmpty());
    assertEquals(packages, actualFromJsonResult.packages());
    assertSame(usagesResult, actualFromJsonResult.versions());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareCatalog#fromJson(ImmutableSoftwareCatalog.Json)}
   */
  @Test
  void testFromJson6() {
    // Arrange
    COWArrayList<SoftwarePackage> packages = mock(COWArrayList.class);

    ArrayList<SoftwarePackage> softwarePackageList = new ArrayList<>();
    when(packages.iterator()).thenReturn(softwarePackageList.iterator());

    ImmutableSoftwareCatalog.Json json = new ImmutableSoftwareCatalog.Json();
    json.setPackages(packages);
    json.setUsages(null);
    json.setVersions(null);

    // Act
    ImmutableSoftwareCatalog actualFromJsonResult = ImmutableSoftwareCatalog.fromJson(json);

    // Assert
    verify(packages).iterator();
    List<SoftwarePackage> packagesResult = actualFromJsonResult.packages();
    assertTrue(packagesResult.isEmpty());
    assertSame(packagesResult, actualFromJsonResult.usages());
    assertSame(packagesResult, actualFromJsonResult.versions());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareCatalog#fromJson(ImmutableSoftwareCatalog.Json)}
   */
  @Test
  void testFromJson7() {
    // Arrange
    ArrayList<SoftwarePackage> softwarePackageList = new ArrayList<>();
    softwarePackageList.add(new ImmutableSoftwarePackage.Json());
    softwarePackageList.add(new ImmutableSoftwarePackage.Json());
    COWArrayList<SoftwarePackage> packages = mock(COWArrayList.class);
    when(packages.iterator()).thenReturn(softwarePackageList.iterator());
    COWArrayList<SoftwareUsage> usages = mock(COWArrayList.class);

    ArrayList<SoftwareUsage> softwareUsageList = new ArrayList<>();
    when(usages.iterator()).thenReturn(softwareUsageList.iterator());
    COWArrayList<SoftwareVersion> versions = mock(COWArrayList.class);

    ArrayList<SoftwareVersion> softwareVersionList = new ArrayList<>();
    when(versions.iterator()).thenReturn(softwareVersionList.iterator());

    ImmutableSoftwareCatalog.Json json = new ImmutableSoftwareCatalog.Json();
    json.setPackages(packages);
    json.setUsages(usages);
    json.setVersions(versions);

    // Act
    ImmutableSoftwareCatalog actualFromJsonResult = ImmutableSoftwareCatalog.fromJson(json);

    // Assert
    verify(packages).iterator();
    verify(usages).iterator();
    verify(versions).iterator();
    List<SoftwareUsage> usagesResult = actualFromJsonResult.usages();
    assertTrue(usagesResult.isEmpty());
    assertEquals(softwarePackageList, actualFromJsonResult.packages());
    assertSame(usagesResult, actualFromJsonResult.versions());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSoftwareCatalog.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSoftwareCatalog.Json actualJson = new ImmutableSoftwareCatalog.Json();

    // Assert
    assertTrue(actualJson.packages.isEmpty());
    assertTrue(actualJson.usages.isEmpty());
    assertTrue(actualJson.versions.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableSoftwareCatalog.Json#packages()}
   */
  @Test
  void testJsonPackages() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwareCatalog.Json()).packages());
  }

  /**
   * Method under test: {@link ImmutableSoftwareCatalog.Json#usages()}
   */
  @Test
  void testJsonUsages() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwareCatalog.Json()).usages());
  }

  /**
   * Method under test: {@link ImmutableSoftwareCatalog.Json#versions()}
   */
  @Test
  void testJsonVersions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwareCatalog.Json()).versions());
  }
}
