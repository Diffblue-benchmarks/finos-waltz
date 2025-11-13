package org.finos.waltz.model.software_catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.software_catalog.ImmutableSoftwareCatalog.Builder;
import org.finos.waltz.model.software_catalog.ImmutableSoftwareCatalog.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSoftwareCatalogDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllPackages(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllPackages(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllPackages(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllPackages(Iterable)"})
  void testBuilderAddAllPackages_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();

    // Act
    Builder actualAddAllPackagesResult = builderResult.addAllPackages(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllPackagesResult);
  }

  /**
   * Test Builder {@link Builder#addAllUsages(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllUsages(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllUsages(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllUsages(Iterable)"})
  void testBuilderAddAllUsages_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();

    // Act
    Builder actualAddAllUsagesResult = builderResult.addAllUsages(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllUsagesResult);
  }

  /**
   * Test Builder {@link Builder#addAllVersions(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllVersions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllVersions(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllVersions(Iterable)"})
  void testBuilderAddAllVersions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();

    // Act
    Builder actualAddAllVersionsResult = builderResult.addAllVersions(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllVersionsResult);
  }

  /**
   * Test Builder {@link Builder#addPackages(SoftwarePackage)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableSoftwarePackage.Json} (default constructor).
   *   <li>Then builder build packages size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addPackages(SoftwarePackage)}
   */
  @Test
  @DisplayName(
      "Test Builder addPackages(SoftwarePackage) with 'element'; when Json (default constructor); then builder build packages size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addPackages(SoftwarePackage)"})
  void testBuilderAddPackagesWithElement_whenJson_thenBuilderBuildPackagesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();
    ImmutableSoftwarePackage.Json element = new ImmutableSoftwarePackage.Json();

    // Act
    Builder actualAddPackagesResult = builderResult.addPackages(element);

    // Assert
    List<SoftwarePackage> packagesResult = builderResult.build().packages();
    assertEquals(1, packagesResult.size());
    assertSame(element, packagesResult.get(0));
    assertSame(builderResult, actualAddPackagesResult);
  }

  /**
   * Test Builder {@link Builder#addPackages(SoftwarePackage[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableSoftwarePackage.Json} (default constructor).
   *   <li>Then builder build packages size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addPackages(SoftwarePackage[])}
   */
  @Test
  @DisplayName(
      "Test Builder addPackages(SoftwarePackage[]) with 'elements'; when Json (default constructor); then builder build packages size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addPackages(SoftwarePackage[])"})
  void testBuilderAddPackagesWithElements_whenJson_thenBuilderBuildPackagesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();
    ImmutableSoftwarePackage.Json json = new ImmutableSoftwarePackage.Json();

    // Act
    Builder actualAddPackagesResult = builderResult.addPackages(json);

    // Assert
    List<SoftwarePackage> packagesResult = builderResult.build().packages();
    assertEquals(1, packagesResult.size());
    assertSame(json, packagesResult.get(0));
    assertSame(builderResult, actualAddPackagesResult);
  }

  /**
   * Test Builder {@link Builder#addUsages(SoftwareUsage)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableSoftwareUsage.Json} (default constructor).
   *   <li>Then builder build usages size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addUsages(SoftwareUsage)}
   */
  @Test
  @DisplayName(
      "Test Builder addUsages(SoftwareUsage) with 'element'; when Json (default constructor); then builder build usages size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addUsages(SoftwareUsage)"})
  void testBuilderAddUsagesWithElement_whenJson_thenBuilderBuildUsagesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();
    ImmutableSoftwareUsage.Json element = new ImmutableSoftwareUsage.Json();

    // Act
    Builder actualAddUsagesResult = builderResult.addUsages(element);

    // Assert
    List<SoftwareUsage> usagesResult = builderResult.build().usages();
    assertEquals(1, usagesResult.size());
    assertSame(element, usagesResult.get(0));
    assertSame(builderResult, actualAddUsagesResult);
  }

  /**
   * Test Builder {@link Builder#addUsages(SoftwareUsage[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableSoftwareUsage.Json} (default constructor).
   *   <li>Then builder build usages size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addUsages(SoftwareUsage[])}
   */
  @Test
  @DisplayName(
      "Test Builder addUsages(SoftwareUsage[]) with 'elements'; when Json (default constructor); then builder build usages size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addUsages(SoftwareUsage[])"})
  void testBuilderAddUsagesWithElements_whenJson_thenBuilderBuildUsagesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();
    ImmutableSoftwareUsage.Json json = new ImmutableSoftwareUsage.Json();

    // Act
    Builder actualAddUsagesResult = builderResult.addUsages(json);

    // Assert
    List<SoftwareUsage> usagesResult = builderResult.build().usages();
    assertEquals(1, usagesResult.size());
    assertSame(json, usagesResult.get(0));
    assertSame(builderResult, actualAddUsagesResult);
  }

  /**
   * Test Builder {@link Builder#addVersions(SoftwareVersion)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableSoftwareVersion.Json} (default constructor).
   *   <li>Then builder build versions size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addVersions(SoftwareVersion)}
   */
  @Test
  @DisplayName(
      "Test Builder addVersions(SoftwareVersion) with 'element'; when Json (default constructor); then builder build versions size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addVersions(SoftwareVersion)"})
  void testBuilderAddVersionsWithElement_whenJson_thenBuilderBuildVersionsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();
    ImmutableSoftwareVersion.Json element = new ImmutableSoftwareVersion.Json();

    // Act
    Builder actualAddVersionsResult = builderResult.addVersions(element);

    // Assert
    List<SoftwareVersion> versionsResult = builderResult.build().versions();
    assertEquals(1, versionsResult.size());
    assertSame(element, versionsResult.get(0));
    assertSame(builderResult, actualAddVersionsResult);
  }

  /**
   * Test Builder {@link Builder#addVersions(SoftwareVersion[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableSoftwareVersion.Json} (default constructor).
   *   <li>Then builder build versions size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addVersions(SoftwareVersion[])}
   */
  @Test
  @DisplayName(
      "Test Builder addVersions(SoftwareVersion[]) with 'elements'; when Json (default constructor); then builder build versions size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addVersions(SoftwareVersion[])"})
  void testBuilderAddVersionsWithElements_whenJson_thenBuilderBuildVersionsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();
    ImmutableSoftwareVersion.Json json = new ImmutableSoftwareVersion.Json();

    // Act
    Builder actualAddVersionsResult = builderResult.addVersions(json);

    // Assert
    List<SoftwareVersion> versionsResult = builderResult.build().versions();
    assertEquals(1, versionsResult.size());
    assertSame(json, versionsResult.get(0));
    assertSame(builderResult, actualAddVersionsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareCatalog Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableSoftwareCatalog.builder().build().packages().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(SoftwareCatalog)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SoftwareCatalog)}
   */
  @Test
  @DisplayName("Test Builder from(SoftwareCatalog); when builder build; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SoftwareCatalog)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();

    // Act
    Builder actualFromResult = builderResult.from(ImmutableSoftwareCatalog.builder().build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#packages(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#packages(Iterable)}
   */
  @Test
  @DisplayName("Test Builder packages(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.packages(Iterable)"})
  void testBuilderPackages_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();

    // Act
    Builder actualPackagesResult = builderResult.packages(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualPackagesResult);
  }

  /**
   * Test Builder {@link Builder#usages(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#usages(Iterable)}
   */
  @Test
  @DisplayName("Test Builder usages(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.usages(Iterable)"})
  void testBuilderUsages_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();

    // Act
    Builder actualUsagesResult = builderResult.usages(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualUsagesResult);
  }

  /**
   * Test Builder {@link Builder#versions(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#versions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder versions(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.versions(Iterable)"})
  void testBuilderVersions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();

    // Act
    Builder actualVersionsResult = builderResult.versions(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualVersionsResult);
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#copyOf(SoftwareCatalog)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return packages Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareCatalog#copyOf(SoftwareCatalog)}
   */
  @Test
  @DisplayName("Test copyOf(SoftwareCatalog); when builder build; then return packages Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareCatalog ImmutableSoftwareCatalog.copyOf(SoftwareCatalog)"})
  void testCopyOf_whenBuilderBuild_thenReturnPackagesEmpty() {
    // Arrange
    ImmutableSoftwareCatalog instance = ImmutableSoftwareCatalog.builder().build();

    // Act
    ImmutableSoftwareCatalog actualCopyOfResult = ImmutableSoftwareCatalog.copyOf(instance);

    // Assert
    List<SoftwarePackage> packagesResult = actualCopyOfResult.packages();
    assertTrue(packagesResult.isEmpty());
    assertSame(packagesResult, actualCopyOfResult.usages());
    assertSame(packagesResult, actualCopyOfResult.versions());
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#equals(Object)}, and {@link
   * ImmutableSoftwareCatalog#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSoftwareCatalog#equals(Object)}
   *   <li>{@link ImmutableSoftwareCatalog#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareCatalog.equals(Object)",
    "int ImmutableSoftwareCatalog.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSoftwareCatalog immutableSoftwareCatalog = ImmutableSoftwareCatalog.builder().build();
    ImmutableSoftwareCatalog immutableSoftwareCatalog2 = ImmutableSoftwareCatalog.builder().build();

    // Act and Assert
    assertEquals(immutableSoftwareCatalog, immutableSoftwareCatalog2);
    assertEquals(immutableSoftwareCatalog.hashCode(), immutableSoftwareCatalog2.hashCode());
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#equals(Object)}, and {@link
   * ImmutableSoftwareCatalog#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSoftwareCatalog#equals(Object)}
   *   <li>{@link ImmutableSoftwareCatalog#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareCatalog.equals(Object)",
    "int ImmutableSoftwareCatalog.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSoftwareCatalog immutableSoftwareCatalog = ImmutableSoftwareCatalog.builder().build();

    // Act and Assert
    assertEquals(immutableSoftwareCatalog, immutableSoftwareCatalog);
    int expectedHashCodeResult = immutableSoftwareCatalog.hashCode();
    assertEquals(expectedHashCodeResult, immutableSoftwareCatalog.hashCode());
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareCatalog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareCatalog.equals(Object)",
    "int ImmutableSoftwareCatalog.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();

    ImmutableSoftwarePackage.Builder builderResult2 = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    builderResult.addPackages(
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableSoftwareCatalog.builder().build());
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareCatalog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareCatalog.equals(Object)",
    "int ImmutableSoftwareCatalog.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();
    builderResult.addUsages(
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableSoftwareCatalog.builder().build());
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareCatalog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareCatalog.equals(Object)",
    "int ImmutableSoftwareCatalog.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();

    ImmutableSoftwareVersion.Builder builderResult2 = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    builderResult.addVersions(
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableSoftwareCatalog.builder().build());
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareCatalog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareCatalog.equals(Object)",
    "int ImmutableSoftwareCatalog.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableSoftwareCatalog.builder().build(), null);
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareCatalog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareCatalog.equals(Object)",
    "int ImmutableSoftwareCatalog.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSoftwareCatalog.builder().build(), "Different type to ImmutableSoftwareCatalog");
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableSoftwarePackage.Json} (default
   *       constructor).
   *   <li>Then packages first return {@link ImmutableSoftwarePackage.Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareCatalog#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add Json (default constructor); then packages first return Json")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareCatalog ImmutableSoftwareCatalog.fromJson(Json)"})
  void testFromJson_givenArrayListAddJson_thenPackagesFirstReturnJson() {
    // Arrange
    ArrayList<SoftwarePackage> packages = new ArrayList<>();
    packages.add(new ImmutableSoftwarePackage.Json());

    ArrayList<SoftwareUsage> usages = new ArrayList<>();
    usages.add(new ImmutableSoftwareUsage.Json());

    ArrayList<SoftwareVersion> versions = new ArrayList<>();
    ImmutableSoftwareVersion.Json json = new ImmutableSoftwareVersion.Json();
    versions.add(json);

    Json json2 = new Json();
    json2.setPackages(packages);
    json2.setUsages(usages);
    json2.setVersions(versions);

    // Act
    ImmutableSoftwareCatalog actualFromJsonResult = ImmutableSoftwareCatalog.fromJson(json2);

    // Assert
    List<SoftwarePackage> packagesResult = actualFromJsonResult.packages();
    assertEquals(1, packagesResult.size());
    SoftwarePackage getResult = packagesResult.get(0);
    assertTrue(getResult instanceof ImmutableSoftwarePackage.Json);
    List<SoftwareVersion> versionsResult = actualFromJsonResult.versions();
    assertEquals(1, versionsResult.size());
    assertTrue(versionsResult.get(0) instanceof ImmutableSoftwareVersion.Json);
    Optional<Long> optional = json.id;
    assertSame(optional, ((ImmutableSoftwarePackage.Json) getResult).externalId);
    assertSame(optional, ((ImmutableSoftwarePackage.Json) getResult).id);
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Usages is {@code null}.
   *   <li>Then return usages Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareCatalog#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Usages is 'null'; then return usages Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareCatalog ImmutableSoftwareCatalog.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonUsagesIsNull_thenReturnUsagesEmpty() {
    // Arrange
    ArrayList<SoftwarePackage> packages = new ArrayList<>();
    packages.add(new ImmutableSoftwarePackage.Json());

    ArrayList<SoftwareVersion> versions = new ArrayList<>();
    ImmutableSoftwareVersion.Json json = new ImmutableSoftwareVersion.Json();
    versions.add(json);

    Json json2 = new Json();
    json2.setPackages(packages);
    json2.setUsages(null);
    json2.setVersions(versions);

    // Act
    ImmutableSoftwareCatalog actualFromJsonResult = ImmutableSoftwareCatalog.fromJson(json2);

    // Assert
    List<SoftwarePackage> packagesResult = actualFromJsonResult.packages();
    assertEquals(1, packagesResult.size());
    SoftwarePackage getResult = packagesResult.get(0);
    assertTrue(getResult instanceof ImmutableSoftwarePackage.Json);
    List<SoftwareVersion> versionsResult = actualFromJsonResult.versions();
    assertEquals(1, versionsResult.size());
    assertTrue(versionsResult.get(0) instanceof ImmutableSoftwareVersion.Json);
    assertTrue(actualFromJsonResult.usages().isEmpty());
    Optional<Long> optional = json.id;
    assertSame(optional, ((ImmutableSoftwarePackage.Json) getResult).externalId);
    assertSame(optional, ((ImmutableSoftwarePackage.Json) getResult).id);
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Versions is {@code null}.
   *   <li>Then return versions Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareCatalog#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Versions is 'null'; then return versions Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareCatalog ImmutableSoftwareCatalog.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonVersionsIsNull_thenReturnVersionsEmpty() {
    // Arrange
    ArrayList<SoftwarePackage> packages = new ArrayList<>();
    ImmutableSoftwarePackage.Json json = new ImmutableSoftwarePackage.Json();
    packages.add(json);

    ArrayList<SoftwareUsage> usages = new ArrayList<>();
    usages.add(new ImmutableSoftwareUsage.Json());

    Json json2 = new Json();
    json2.setPackages(packages);
    json2.setUsages(usages);
    json2.setVersions(null);

    // Act
    ImmutableSoftwareCatalog actualFromJsonResult = ImmutableSoftwareCatalog.fromJson(json2);

    // Assert
    List<SoftwarePackage> packagesResult = actualFromJsonResult.packages();
    assertEquals(1, packagesResult.size());
    assertTrue(actualFromJsonResult.versions().isEmpty());
    assertSame(json, packagesResult.get(0));
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return packages size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareCatalog#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return packages size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareCatalog ImmutableSoftwareCatalog.fromJson(Json)"})
  void testFromJson_thenReturnPackagesSizeIsTwo() {
    // Arrange
    ArrayList<SoftwarePackage> packages = new ArrayList<>();

    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    packages.add(
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build());
    ImmutableSoftwarePackage.Json json = new ImmutableSoftwarePackage.Json();
    packages.add(json);

    ArrayList<SoftwareUsage> usages = new ArrayList<>();
    usages.add(new ImmutableSoftwareUsage.Json());

    ArrayList<SoftwareVersion> versions = new ArrayList<>();
    versions.add(new ImmutableSoftwareVersion.Json());

    Json json2 = new Json();
    json2.setPackages(packages);
    json2.setUsages(usages);
    json2.setVersions(versions);

    // Act
    ImmutableSoftwareCatalog actualFromJsonResult = ImmutableSoftwareCatalog.fromJson(json2);

    // Assert
    List<SoftwarePackage> packagesResult = actualFromJsonResult.packages();
    assertEquals(2, packagesResult.size());
    assertTrue(packagesResult.get(0) instanceof ImmutableSoftwarePackage);
    SoftwarePackage getResult = packagesResult.get(1);
    assertTrue(getResult instanceof ImmutableSoftwarePackage.Json);
    assertSame(json, getResult);
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Packages is {@code null}.
   *   <li>Then return not versions first {@link ImmutableSoftwareVersion.Json#created} Present.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareCatalog#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Packages is 'null'; then return not versions first created Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareCatalog ImmutableSoftwareCatalog.fromJson(Json)"})
  void testFromJson_whenJsonPackagesIsNull_thenReturnNotVersionsFirstCreatedPresent() {
    // Arrange
    ArrayList<SoftwareUsage> usages = new ArrayList<>();
    usages.add(new ImmutableSoftwareUsage.Json());

    ArrayList<SoftwareVersion> versions = new ArrayList<>();
    versions.add(new ImmutableSoftwareVersion.Json());

    Json json = new Json();
    json.setPackages(null);
    json.setUsages(usages);
    json.setVersions(versions);

    // Act
    ImmutableSoftwareCatalog actualFromJsonResult = ImmutableSoftwareCatalog.fromJson(json);

    // Assert
    List<SoftwareVersion> versionsResult = actualFromJsonResult.versions();
    assertEquals(1, versionsResult.size());
    SoftwareVersion getResult = versionsResult.get(0);
    assertTrue(getResult instanceof ImmutableSoftwareVersion.Json);
    Optional<UserTimestamp> optional = ((ImmutableSoftwareVersion.Json) getResult).created;
    assertFalse(optional.isPresent());
    assertTrue(actualFromJsonResult.packages().isEmpty());
    assertSame(optional, ((ImmutableSoftwareVersion.Json) getResult).externalId);
    assertSame(optional, ((ImmutableSoftwareVersion.Json) getResult).id);
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return usages is {@link Json} (default constructor) {@link Json#versions}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareCatalog#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return usages is Json (default constructor) versions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareCatalog ImmutableSoftwareCatalog.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnUsagesIsJsonVersions() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableSoftwareCatalog actualFromJsonResult = ImmutableSoftwareCatalog.fromJson(json);

    // Assert
    List<SoftwareVersion> softwareVersionList = json.versions;
    assertSame(softwareVersionList, actualFromJsonResult.usages());
    assertSame(softwareVersionList, actualFromJsonResult.versions());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSoftwareCatalog#toString()}
   *   <li>{@link ImmutableSoftwareCatalog#packages()}
   *   <li>{@link ImmutableSoftwareCatalog#usages()}
   *   <li>{@link ImmutableSoftwareCatalog#versions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ImmutableSoftwareCatalog.packages()",
    "String ImmutableSoftwareCatalog.toString()",
    "List ImmutableSoftwareCatalog.usages()",
    "List ImmutableSoftwareCatalog.versions()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSoftwareCatalog immutableSoftwareCatalog = ImmutableSoftwareCatalog.builder().build();

    // Act
    String actualToStringResult = immutableSoftwareCatalog.toString();
    List<SoftwarePackage> actualPackagesResult = immutableSoftwareCatalog.packages();
    List<SoftwareUsage> actualUsagesResult = immutableSoftwareCatalog.usages();
    List<SoftwareVersion> actualVersionsResult = immutableSoftwareCatalog.versions();

    // Assert
    assertEquals("SoftwareCatalog{packages=[], usages=[], versions=[]}", actualToStringResult);
    assertTrue(actualPackagesResult.isEmpty());
    assertSame(actualPackagesResult, actualUsagesResult);
    assertSame(actualPackagesResult, actualVersionsResult);
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertTrue(actualJson.packages.isEmpty());
    assertTrue(actualJson.usages.isEmpty());
    assertTrue(actualJson.versions.isEmpty());
  }

  /**
   * Test Json {@link Json#packages()}.
   *
   * <p>Method under test: {@link Json#packages()}
   */
  @Test
  @DisplayName("Test Json packages()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.packages()"})
  void testJsonPackages() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().packages());
  }

  /**
   * Test Json {@link Json#usages()}.
   *
   * <p>Method under test: {@link Json#usages()}
   */
  @Test
  @DisplayName("Test Json usages()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.usages()"})
  void testJsonUsages() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().usages());
  }

  /**
   * Test Json {@link Json#versions()}.
   *
   * <p>Method under test: {@link Json#versions()}
   */
  @Test
  @DisplayName("Test Json versions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.versions()"})
  void testJsonVersions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().versions());
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#withPackages(SoftwarePackage[])} with {@code
   * SoftwarePackage[]}.
   *
   * <p>Method under test: {@link ImmutableSoftwareCatalog#withPackages(SoftwarePackage[])}
   */
  @Test
  @DisplayName("Test withPackages(SoftwarePackage[]) with 'SoftwarePackage[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwareCatalog ImmutableSoftwareCatalog.withPackages(SoftwarePackage[])"
  })
  void testWithPackagesWithSoftwarePackage() {
    // Arrange
    ImmutableSoftwareCatalog immutableSoftwareCatalog = ImmutableSoftwareCatalog.builder().build();

    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    ImmutableSoftwareCatalog actualWithPackagesResult =
        immutableSoftwareCatalog.withPackages(
            builderResult
                .created(created)
                .description("The characteristics of someone or something")
                .externalId("42")
                .group("Group")
                .id(1L)
                .isNotable(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .vendor("Vendor")
                .build());

    // Assert
    List<SoftwarePackage> packagesResult = actualWithPackagesResult.packages();
    assertEquals(1, packagesResult.size());
    SoftwarePackage getResult = packagesResult.get(0);
    assertTrue(getResult instanceof ImmutableSoftwarePackage);
    assertEquals("Group", getResult.group());
    assertEquals("Name", getResult.name());
    assertEquals("Provenance", getResult.provenance());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals("Vendor", getResult.vendor());
    assertEquals(EntityKind.ALL, getResult.kind());
    List<SoftwareUsage> usagesResult = actualWithPackagesResult.usages();
    assertTrue(usagesResult.isEmpty());
    assertTrue(getResult.isNotable());
    assertSame(usagesResult, actualWithPackagesResult.versions());
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#withUsages(SoftwareUsage[])} with {@code SoftwareUsage[]}.
   *
   * <p>Method under test: {@link ImmutableSoftwareCatalog#withUsages(SoftwareUsage[])}
   */
  @Test
  @DisplayName("Test withUsages(SoftwareUsage[]) with 'SoftwareUsage[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwareCatalog ImmutableSoftwareCatalog.withUsages(SoftwareUsage[])"
  })
  void testWithUsagesWithSoftwareUsage() {
    // Arrange
    ImmutableSoftwareCatalog immutableSoftwareCatalog = ImmutableSoftwareCatalog.builder().build();

    // Act
    ImmutableSoftwareCatalog actualWithUsagesResult =
        immutableSoftwareCatalog.withUsages(
            ImmutableSoftwareUsage.builder()
                .applicationId(1L)
                .licenceId(1L)
                .provenance("Provenance")
                .softwarePackageId(1L)
                .softwareVersionId(1L)
                .build());

    // Assert
    List<SoftwareUsage> usagesResult = actualWithUsagesResult.usages();
    assertEquals(1, usagesResult.size());
    SoftwareUsage getResult = usagesResult.get(0);
    assertTrue(getResult instanceof ImmutableSoftwareUsage);
    assertEquals("Provenance", getResult.provenance());
    assertEquals(1L, getResult.licenceId().longValue());
    assertEquals(1L, getResult.applicationId());
    assertEquals(1L, getResult.softwarePackageId());
    assertEquals(1L, getResult.softwareVersionId());
    List<SoftwarePackage> packagesResult = actualWithUsagesResult.packages();
    assertTrue(packagesResult.isEmpty());
    assertSame(packagesResult, actualWithUsagesResult.versions());
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#withVersions(SoftwareVersion[])} with {@code
   * SoftwareVersion[]}.
   *
   * <p>Method under test: {@link ImmutableSoftwareCatalog#withVersions(SoftwareVersion[])}
   */
  @Test
  @DisplayName("Test withVersions(SoftwareVersion[]) with 'SoftwareVersion[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwareCatalog ImmutableSoftwareCatalog.withVersions(SoftwareVersion[])"
  })
  void testWithVersionsWithSoftwareVersion() {
    // Arrange
    ImmutableSoftwareCatalog immutableSoftwareCatalog = ImmutableSoftwareCatalog.builder().build();

    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    LocalDate releaseDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableSoftwareCatalog actualWithVersionsResult =
        immutableSoftwareCatalog.withVersions(
            builderResult
                .created(created)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .releaseDate(releaseDate)
                .softwarePackageId(1L)
                .version("1.0.2")
                .build());

    // Assert
    List<SoftwareVersion> versionsResult = actualWithVersionsResult.versions();
    assertEquals(1, versionsResult.size());
    SoftwareVersion getResult = versionsResult.get(0);
    assertTrue(getResult instanceof ImmutableSoftwareVersion);
    assertEquals("1.0.2", getResult.version());
    LocalDate releaseDateResult = getResult.releaseDate();
    assertEquals("1970-01-01", releaseDateResult.toString());
    assertEquals("Name", getResult.name());
    assertEquals("Provenance", getResult.provenance());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(1L, getResult.softwarePackageId());
    assertEquals(EntityKind.ALL, getResult.kind());
    List<SoftwarePackage> packagesResult = actualWithVersionsResult.packages();
    assertTrue(packagesResult.isEmpty());
    assertSame(packagesResult, actualWithVersionsResult.usages());
    assertSame(releaseDate, releaseDateResult);
  }
}
