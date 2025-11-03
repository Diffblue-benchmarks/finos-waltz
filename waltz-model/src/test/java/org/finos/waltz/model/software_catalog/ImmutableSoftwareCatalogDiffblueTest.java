package org.finos.waltz.model.software_catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.software_catalog.ImmutableSoftwareCatalog.Builder;
import org.finos.waltz.model.software_catalog.ImmutableSoftwareCatalog.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSoftwareCatalogDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllPackages(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllPackages(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllPackages(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllPackages(Iterable)"})
  void testBuilderAddAllPackages_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllPackages(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllUsages(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllUsages(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllUsages(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllUsages(Iterable)"})
  void testBuilderAddAllUsages_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllUsages(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllVersions(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllVersions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllVersions(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllVersions(Iterable)"})
  void testBuilderAddAllVersions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllVersions(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addPackages(SoftwarePackage)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableSoftwarePackage.Json} (default constructor).</li>
   *   <li>Then builder build packages size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addPackages(SoftwarePackage)}
   */
  @Test
  @DisplayName("Test Builder addPackages(SoftwarePackage) with 'element'; when Json (default constructor); then builder build packages size is one")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link ImmutableSoftwarePackage.Json} (default constructor).</li>
   *   <li>Then builder build packages size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addPackages(SoftwarePackage[])}
   */
  @Test
  @DisplayName("Test Builder addPackages(SoftwarePackage[]) with 'elements'; when Json (default constructor); then builder build packages size is one")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link ImmutableSoftwareUsage.Json} (default constructor).</li>
   *   <li>Then builder build usages size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addUsages(SoftwareUsage)}
   */
  @Test
  @DisplayName("Test Builder addUsages(SoftwareUsage) with 'element'; when Json (default constructor); then builder build usages size is one")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link ImmutableSoftwareUsage.Json} (default constructor).</li>
   *   <li>Then builder build usages size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addUsages(SoftwareUsage[])}
   */
  @Test
  @DisplayName("Test Builder addUsages(SoftwareUsage[]) with 'elements'; when Json (default constructor); then builder build usages size is one")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link ImmutableSoftwareVersion.Json} (default constructor).</li>
   *   <li>Then builder build versions size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addVersions(SoftwareVersion)}
   */
  @Test
  @DisplayName("Test Builder addVersions(SoftwareVersion) with 'element'; when Json (default constructor); then builder build versions size is one")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link ImmutableSoftwareVersion.Json} (default constructor).</li>
   *   <li>Then builder build versions size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addVersions(SoftwareVersion[])}
   */
  @Test
  @DisplayName("Test Builder addVersions(SoftwareVersion[]) with 'elements'; when Json (default constructor); then builder build versions size is one")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSoftwareCatalog Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableSoftwareCatalog.builder().build().packages().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(SoftwareCatalog)}.
   * <ul>
   *   <li>Given {@link ImmutableSoftwareVersion.Json} (default constructor).</li>
   *   <li>Then build packages first return {@link ImmutableSoftwarePackage.Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SoftwareCatalog)}
   */
  @Test
  @DisplayName("Test Builder from(SoftwareCatalog); given Json (default constructor); then build packages first return Json")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SoftwareCatalog)"})
  void testBuilderFrom_givenJson_thenBuildPackagesFirstReturnJson() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();
    Builder builderResult2 = ImmutableSoftwareCatalog.builder();
    ImmutableSoftwareVersion.Json element = new ImmutableSoftwareVersion.Json();
    builderResult2.addVersions(element);
    builderResult2.addPackages(new ImmutableSoftwarePackage.Json());
    ImmutableSoftwareCatalog instance = builderResult2.build();

    // Act and Assert
    ImmutableSoftwareCatalog buildResult = builderResult.from(instance).build();
    List<SoftwarePackage> packagesResult = buildResult.packages();
    assertEquals(1, packagesResult.size());
    SoftwarePackage getResult = packagesResult.get(0);
    assertTrue(getResult instanceof ImmutableSoftwarePackage.Json);
    List<SoftwareVersion> versionsResult = buildResult.versions();
    assertEquals(1, versionsResult.size());
    assertSame(element, versionsResult.get(0));
    Optional<Long> optional = element.id;
    assertSame(optional, ((ImmutableSoftwarePackage.Json) getResult).externalId);
    assertSame(optional, ((ImmutableSoftwarePackage.Json) getResult).id);
  }

  /**
   * Test Builder {@link Builder#from(SoftwareCatalog)}.
   * <ul>
   *   <li>Given {@link ImmutableSoftwareUsage.Json} (default constructor).</li>
   *   <li>Then return build usages size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SoftwareCatalog)}
   */
  @Test
  @DisplayName("Test Builder from(SoftwareCatalog); given Json (default constructor); then return build usages size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SoftwareCatalog)"})
  void testBuilderFrom_givenJson_thenReturnBuildUsagesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();
    Builder builderResult2 = ImmutableSoftwareCatalog.builder();
    ImmutableSoftwareUsage.Json element = new ImmutableSoftwareUsage.Json();
    builderResult2.addUsages(element);
    builderResult2.addPackages(new ImmutableSoftwarePackage.Json());
    ImmutableSoftwareCatalog instance = builderResult2.build();

    // Act and Assert
    ImmutableSoftwareCatalog buildResult = builderResult.from(instance).build();
    List<SoftwareUsage> usagesResult = buildResult.usages();
    assertEquals(1, usagesResult.size());
    assertTrue(buildResult.versions().isEmpty());
    assertSame(element, usagesResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(SoftwareCatalog)}.
   * <ul>
   *   <li>Given {@link ImmutableSoftwarePackage.Json} (default constructor).</li>
   *   <li>When builder addPackages {@link ImmutableSoftwarePackage.Json} (default constructor).</li>
   *   <li>Then return build usages Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SoftwareCatalog)}
   */
  @Test
  @DisplayName("Test Builder from(SoftwareCatalog); given Json (default constructor); when builder addPackages Json (default constructor); then return build usages Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SoftwareCatalog)"})
  void testBuilderFrom_givenJson_whenBuilderAddPackagesJson_thenReturnBuildUsagesEmpty() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();
    Builder builderResult2 = ImmutableSoftwareCatalog.builder();
    ImmutableSoftwarePackage.Json element = new ImmutableSoftwarePackage.Json();
    builderResult2.addPackages(element);
    ImmutableSoftwareCatalog instance = builderResult2.build();

    // Act and Assert
    ImmutableSoftwareCatalog buildResult = builderResult.from(instance).build();
    List<SoftwarePackage> packagesResult = buildResult.packages();
    assertEquals(1, packagesResult.size());
    List<SoftwareUsage> usagesResult = buildResult.usages();
    assertTrue(usagesResult.isEmpty());
    assertEquals(instance, builderResult.build());
    assertSame(element, packagesResult.get(0));
    assertSame(usagesResult, buildResult.versions());
  }

  /**
   * Test Builder {@link Builder#from(SoftwareCatalog)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return build packages Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SoftwareCatalog)}
   */
  @Test
  @DisplayName("Test Builder from(SoftwareCatalog); when builder build; then return build packages Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SoftwareCatalog)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuildPackagesEmpty() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();
    ImmutableSoftwareCatalog instance = ImmutableSoftwareCatalog.builder().build();

    // Act and Assert
    ImmutableSoftwareCatalog buildResult = builderResult.from(instance).build();
    List<SoftwarePackage> packagesResult = buildResult.packages();
    assertTrue(packagesResult.isEmpty());
    assertEquals(instance, builderResult.build());
    assertSame(packagesResult, buildResult.usages());
    assertSame(packagesResult, buildResult.versions());
  }

  /**
   * Test Builder {@link Builder#packages(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#packages(Iterable)}
   */
  @Test
  @DisplayName("Test Builder packages(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.packages(Iterable)"})
  void testBuilderPackages_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.packages(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#usages(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#usages(Iterable)}
   */
  @Test
  @DisplayName("Test Builder usages(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.usages(Iterable)"})
  void testBuilderUsages_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.usages(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#versions(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#versions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder versions(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.versions(Iterable)"})
  void testBuilderVersions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.versions(new ArrayList<>()));
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#copyOf(SoftwareCatalog)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return packages Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareCatalog#copyOf(SoftwareCatalog)}
   */
  @Test
  @DisplayName("Test copyOf(SoftwareCatalog); when builder build; then return packages Empty")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link ImmutableSoftwareCatalog#equals(Object)}, and {@link ImmutableSoftwareCatalog#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSoftwareCatalog#equals(Object)}
   *   <li>{@link ImmutableSoftwareCatalog#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSoftwareCatalog.equals(Object)", "int ImmutableSoftwareCatalog.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSoftwareCatalog buildResult = ImmutableSoftwareCatalog.builder().build();
    ImmutableSoftwareCatalog buildResult2 = ImmutableSoftwareCatalog.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#equals(Object)}, and {@link ImmutableSoftwareCatalog#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSoftwareCatalog#equals(Object)}
   *   <li>{@link ImmutableSoftwareCatalog#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSoftwareCatalog.equals(Object)", "int ImmutableSoftwareCatalog.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSoftwareCatalog buildResult = ImmutableSoftwareCatalog.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareCatalog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSoftwareCatalog.equals(Object)", "int ImmutableSoftwareCatalog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();
    builderResult.addPackages(new ImmutableSoftwarePackage.Json());
    ImmutableSoftwareCatalog buildResult = builderResult.build();
    ImmutableSoftwareCatalog buildResult2 = ImmutableSoftwareCatalog.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareCatalog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSoftwareCatalog.equals(Object)", "int ImmutableSoftwareCatalog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();
    builderResult.addUsages(new ImmutableSoftwareUsage.Json());
    ImmutableSoftwareCatalog buildResult = builderResult.build();
    ImmutableSoftwareCatalog buildResult2 = ImmutableSoftwareCatalog.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareCatalog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSoftwareCatalog.equals(Object)", "int ImmutableSoftwareCatalog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableSoftwareCatalog.builder();
    builderResult.addVersions(new ImmutableSoftwareVersion.Json());
    ImmutableSoftwareCatalog buildResult = builderResult.build();
    ImmutableSoftwareCatalog buildResult2 = ImmutableSoftwareCatalog.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareCatalog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSoftwareCatalog.equals(Object)", "int ImmutableSoftwareCatalog.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableSoftwareCatalog buildResult = ImmutableSoftwareCatalog.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareCatalog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSoftwareCatalog.equals(Object)", "int ImmutableSoftwareCatalog.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableSoftwareCatalog buildResult = ImmutableSoftwareCatalog.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableSoftwareCatalog");
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableSoftwarePackage.Json} (default constructor).</li>
   *   <li>Then return usages Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareCatalog#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add Json (default constructor); then return usages Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSoftwareCatalog ImmutableSoftwareCatalog.fromJson(Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnUsagesEmpty() {
    // Arrange
    ArrayList<SoftwarePackage> packages = new ArrayList<>();
    packages.add(new ImmutableSoftwarePackage.Json());

    Json json = new Json();
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
   * Test {@link ImmutableSoftwareCatalog#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableSoftwareUsage.Json} (default constructor).</li>
   *   <li>Then return usages is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareCatalog#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add Json (default constructor); then return usages is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSoftwareCatalog ImmutableSoftwareCatalog.fromJson(Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnUsagesIsArrayList() {
    // Arrange
    ArrayList<SoftwareUsage> usages = new ArrayList<>();
    usages.add(new ImmutableSoftwareUsage.Json());

    Json json = new Json();
    json.setPackages(null);
    json.setUsages(usages);
    json.setVersions(null);

    // Act and Assert
    assertEquals(usages, ImmutableSoftwareCatalog.fromJson(json).usages());
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableSoftwareVersion.Json} (default constructor).</li>
   *   <li>Then return versions is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareCatalog#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add Json (default constructor); then return versions is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSoftwareCatalog ImmutableSoftwareCatalog.fromJson(Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnVersionsIsArrayList() {
    // Arrange
    ArrayList<SoftwareVersion> versions = new ArrayList<>();
    versions.add(new ImmutableSoftwareVersion.Json());

    Json json = new Json();
    json.setPackages(null);
    json.setUsages(null);
    json.setVersions(versions);

    // Act and Assert
    assertEquals(versions, ImmutableSoftwareCatalog.fromJson(json).versions());
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableSoftwareVersion.Json} (default constructor).</li>
   *   <li>Then return versions size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareCatalog#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add Json (default constructor); then return versions size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSoftwareCatalog ImmutableSoftwareCatalog.fromJson(Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnVersionsSizeIsTwo() {
    // Arrange
    ArrayList<SoftwareVersion> versions = new ArrayList<>();
    versions.add(new ImmutableSoftwareVersion.Json());
    ImmutableSoftwareVersion.Json json = new ImmutableSoftwareVersion.Json();
    versions.add(json);

    Json json2 = new Json();
    json2.setPackages(null);
    json2.setUsages(null);
    json2.setVersions(versions);

    // Act and Assert
    List<SoftwareVersion> versionsResult = ImmutableSoftwareCatalog.fromJson(json2).versions();
    assertEquals(2, versionsResult.size());
    assertSame(json, versionsResult.get(1));
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Json} (default constructor) Versions is {@code null}.</li>
   *   <li>Then return packages Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareCatalog#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) Versions is 'null'; then return packages Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSoftwareCatalog ImmutableSoftwareCatalog.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonVersionsIsNull_thenReturnPackagesEmpty() {
    // Arrange
    Json json = new Json();
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
   * Test {@link ImmutableSoftwareCatalog#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return usages is {@link Json} (default constructor) {@link Json#versions}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareCatalog#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return usages is Json (default constructor) versions")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSoftwareCatalog#toString()}
   *   <li>{@link ImmutableSoftwareCatalog#packages()}
   *   <li>{@link ImmutableSoftwareCatalog#usages()}
   *   <li>{@link ImmutableSoftwareCatalog#versions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ImmutableSoftwareCatalog.packages()", "String ImmutableSoftwareCatalog.toString()",
      "List ImmutableSoftwareCatalog.usages()", "List ImmutableSoftwareCatalog.versions()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableSoftwareCatalog buildResult = ImmutableSoftwareCatalog.builder().build();

    // Act
    String actualToStringResult = buildResult.toString();
    List<SoftwarePackage> actualPackagesResult = buildResult.packages();
    List<SoftwareUsage> actualUsagesResult = buildResult.usages();
    List<SoftwareVersion> actualVersionsResult = buildResult.versions();

    // Assert
    assertEquals("SoftwareCatalog{packages=[], usages=[], versions=[]}", actualToStringResult);
    assertTrue(actualPackagesResult.isEmpty());
    assertSame(actualPackagesResult, actualUsagesResult);
    assertSame(actualPackagesResult, actualVersionsResult);
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
    assertTrue(actualJson.packages.isEmpty());
    assertTrue(actualJson.usages.isEmpty());
    assertTrue(actualJson.versions.isEmpty());
  }

  /**
   * Test Json {@link Json#packages()}.
   * <p>
   * Method under test: {@link Json#packages()}
   */
  @Test
  @DisplayName("Test Json packages()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.packages()"})
  void testJsonPackages() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).packages());
  }

  /**
   * Test Json {@link Json#usages()}.
   * <p>
   * Method under test: {@link Json#usages()}
   */
  @Test
  @DisplayName("Test Json usages()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.usages()"})
  void testJsonUsages() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).usages());
  }

  /**
   * Test Json {@link Json#versions()}.
   * <p>
   * Method under test: {@link Json#versions()}
   */
  @Test
  @DisplayName("Test Json versions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.versions()"})
  void testJsonVersions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).versions());
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#withPackages(SoftwarePackage[])} with {@code SoftwarePackage[]}.
   * <ul>
   *   <li>When {@link ImmutableSoftwarePackage.Json} (default constructor).</li>
   *   <li>Then return packages size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareCatalog#withPackages(SoftwarePackage[])}
   */
  @Test
  @DisplayName("Test withPackages(SoftwarePackage[]) with 'SoftwarePackage[]'; when Json (default constructor); then return packages size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSoftwareCatalog ImmutableSoftwareCatalog.withPackages(SoftwarePackage[])"})
  void testWithPackagesWithSoftwarePackage_whenJson_thenReturnPackagesSizeIsOne() {
    // Arrange
    ImmutableSoftwareCatalog buildResult = ImmutableSoftwareCatalog.builder().build();
    ImmutableSoftwarePackage.Json json = new ImmutableSoftwarePackage.Json();

    // Act
    ImmutableSoftwareCatalog actualWithPackagesResult = buildResult.withPackages(json);

    // Assert
    List<SoftwarePackage> packagesResult = actualWithPackagesResult.packages();
    assertEquals(1, packagesResult.size());
    List<SoftwareUsage> usagesResult = actualWithPackagesResult.usages();
    assertTrue(usagesResult.isEmpty());
    assertSame(json, packagesResult.get(0));
    assertSame(usagesResult, actualWithPackagesResult.versions());
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#withUsages(SoftwareUsage[])} with {@code SoftwareUsage[]}.
   * <ul>
   *   <li>When {@link ImmutableSoftwareUsage.Json} (default constructor).</li>
   *   <li>Then return usages size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareCatalog#withUsages(SoftwareUsage[])}
   */
  @Test
  @DisplayName("Test withUsages(SoftwareUsage[]) with 'SoftwareUsage[]'; when Json (default constructor); then return usages size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSoftwareCatalog ImmutableSoftwareCatalog.withUsages(SoftwareUsage[])"})
  void testWithUsagesWithSoftwareUsage_whenJson_thenReturnUsagesSizeIsOne() {
    // Arrange
    ImmutableSoftwareCatalog buildResult = ImmutableSoftwareCatalog.builder().build();
    ImmutableSoftwareUsage.Json json = new ImmutableSoftwareUsage.Json();

    // Act
    ImmutableSoftwareCatalog actualWithUsagesResult = buildResult.withUsages(json);

    // Assert
    List<SoftwareUsage> usagesResult = actualWithUsagesResult.usages();
    assertEquals(1, usagesResult.size());
    List<SoftwarePackage> packagesResult = actualWithUsagesResult.packages();
    assertTrue(packagesResult.isEmpty());
    assertSame(json, usagesResult.get(0));
    assertSame(packagesResult, actualWithUsagesResult.versions());
  }

  /**
   * Test {@link ImmutableSoftwareCatalog#withVersions(SoftwareVersion[])} with {@code SoftwareVersion[]}.
   * <ul>
   *   <li>When {@link ImmutableSoftwareVersion.Json} (default constructor).</li>
   *   <li>Then return versions size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareCatalog#withVersions(SoftwareVersion[])}
   */
  @Test
  @DisplayName("Test withVersions(SoftwareVersion[]) with 'SoftwareVersion[]'; when Json (default constructor); then return versions size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSoftwareCatalog ImmutableSoftwareCatalog.withVersions(SoftwareVersion[])"})
  void testWithVersionsWithSoftwareVersion_whenJson_thenReturnVersionsSizeIsOne() {
    // Arrange
    ImmutableSoftwareCatalog buildResult = ImmutableSoftwareCatalog.builder().build();
    ImmutableSoftwareVersion.Json json = new ImmutableSoftwareVersion.Json();

    // Act
    ImmutableSoftwareCatalog actualWithVersionsResult = buildResult.withVersions(json);

    // Assert
    List<SoftwareVersion> versionsResult = actualWithVersionsResult.versions();
    assertEquals(1, versionsResult.size());
    List<SoftwarePackage> packagesResult = actualWithVersionsResult.packages();
    assertTrue(packagesResult.isEmpty());
    assertSame(json, versionsResult.get(0));
    assertSame(packagesResult, actualWithVersionsResult.usages());
  }
}
