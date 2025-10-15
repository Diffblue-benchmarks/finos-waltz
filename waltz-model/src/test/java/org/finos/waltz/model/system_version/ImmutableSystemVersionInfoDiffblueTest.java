package org.finos.waltz.model.system_version;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.finos.waltz.model.system_version.ImmutableSystemVersionInfo.Builder;
import org.finos.waltz.model.system_version.ImmutableSystemVersionInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSystemVersionInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllDatabaseVersions(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code Elements}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllDatabaseVersions(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllDatabaseVersions(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllDatabaseVersions(Iterable)"})
  void testBuilderAddAllDatabaseVersions_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableSystemVersionInfo.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    Builder actualAddAllDatabaseVersionsResult = builderResult.addAllDatabaseVersions(elements);

    // Assert
    assertSame(builderResult, actualAddAllDatabaseVersionsResult);
  }

  /**
   * Test Builder {@link Builder#addAllDatabaseVersions(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllDatabaseVersions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllDatabaseVersions(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllDatabaseVersions(Iterable)"})
  void testBuilderAddAllDatabaseVersions_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSystemVersionInfo.builder();

    // Act
    Builder actualAddAllDatabaseVersionsResult =
        builderResult.addAllDatabaseVersions(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllDatabaseVersionsResult);
  }

  /**
   * Test Builder {@link Builder#addDatabaseVersions(String)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addDatabaseVersions(String)}
   */
  @Test
  @DisplayName("Test Builder addDatabaseVersions(String) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addDatabaseVersions(String)"})
  void testBuilderAddDatabaseVersionsWithElement() {
    // Arrange
    Builder builderResult = ImmutableSystemVersionInfo.builder();

    // Act
    Builder actualAddDatabaseVersionsResult = builderResult.addDatabaseVersions("Element");

    // Assert
    assertSame(builderResult, actualAddDatabaseVersionsResult);
  }

  /**
   * Test Builder {@link Builder#addDatabaseVersions(String[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addDatabaseVersions(String[])}
   */
  @Test
  @DisplayName("Test Builder addDatabaseVersions(String[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addDatabaseVersions(String[])"})
  void testBuilderAddDatabaseVersionsWithElements() {
    // Arrange
    Builder builderResult = ImmutableSystemVersionInfo.builder();

    // Act
    Builder actualAddDatabaseVersionsResult = builderResult.addDatabaseVersions("Elements");

    // Assert
    assertSame(builderResult, actualAddDatabaseVersionsResult);
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
  @MethodsUnderTest({"ImmutableSystemVersionInfo Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableSystemVersionInfo actualImmutableSystemVersionInfo =
        ImmutableSystemVersionInfo.builder().packageVersion("1.0.2").build();

    // Assert
    assertEquals("1.0.2", actualImmutableSystemVersionInfo.packageVersion());
    assertTrue(actualImmutableSystemVersionInfo.databaseVersions().isEmpty());
  }

  /**
   * Test Builder {@link Builder#databaseVersions(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code Elements}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#databaseVersions(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder databaseVersions(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.databaseVersions(Iterable)"})
  void testBuilderDatabaseVersions_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableSystemVersionInfo.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    Builder actualDatabaseVersionsResult = builderResult.databaseVersions(elements);

    // Assert
    assertSame(builderResult, actualDatabaseVersionsResult);
  }

  /**
   * Test Builder {@link Builder#databaseVersions(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#databaseVersions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder databaseVersions(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.databaseVersions(Iterable)"})
  void testBuilderDatabaseVersions_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSystemVersionInfo.builder();

    // Act
    Builder actualDatabaseVersionsResult = builderResult.databaseVersions(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualDatabaseVersionsResult);
  }

  /**
   * Test Builder {@link Builder#from(SystemVersionInfo)}.
   *
   * <ul>
   *   <li>Given {@code instance}.
   *   <li>When builder addDatabaseVersions {@code instance}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SystemVersionInfo)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SystemVersionInfo); given 'instance'; when builder addDatabaseVersions 'instance'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SystemVersionInfo)"})
  void testBuilderFrom_givenInstance_whenBuilderAddDatabaseVersionsInstance() {
    // Arrange
    Builder builderResult = ImmutableSystemVersionInfo.builder();

    Builder builderResult2 = ImmutableSystemVersionInfo.builder();
    builderResult2.addDatabaseVersions("instance");
    ImmutableSystemVersionInfo instance = builderResult2.packageVersion("1.0.2").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSystemVersionInfo actualImmutableSystemVersionInfo = builderResult.build();
    assertEquals(instance, actualImmutableSystemVersionInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SystemVersionInfo)}.
   *
   * <ul>
   *   <li>Then builder build is builder packageVersion {@code 1.0.2} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SystemVersionInfo)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SystemVersionInfo); then builder build is builder packageVersion '1.0.2' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SystemVersionInfo)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderPackageVersion102Build() {
    // Arrange
    Builder builderResult = ImmutableSystemVersionInfo.builder();
    ImmutableSystemVersionInfo instance =
        ImmutableSystemVersionInfo.builder().packageVersion("1.0.2").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSystemVersionInfo actualImmutableSystemVersionInfo = builderResult.build();
    assertEquals(instance, actualImmutableSystemVersionInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#packageVersion(String)}.
   *
   * <ul>
   *   <li>When {@code 1.0.2}.
   *   <li>Then builder build packageVersion is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#packageVersion(String)}
   */
  @Test
  @DisplayName(
      "Test Builder packageVersion(String); when '1.0.2'; then builder build packageVersion is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.packageVersion(String)"})
  void testBuilderPackageVersion_when102_thenBuilderBuildPackageVersionIs102() {
    // Arrange
    Builder builderResult = ImmutableSystemVersionInfo.builder();

    // Act
    Builder actualPackageVersionResult = builderResult.packageVersion("1.0.2");

    // Assert
    assertEquals("1.0.2", builderResult.build().packageVersion());
    assertSame(builderResult, actualPackageVersionResult);
  }

  /**
   * Test {@link ImmutableSystemVersionInfo#copyOf(SystemVersionInfo)}.
   *
   * <ul>
   *   <li>When builder packageVersion {@code 1.0.2} build.
   *   <li>Then return packageVersion is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSystemVersionInfo#copyOf(SystemVersionInfo)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SystemVersionInfo); when builder packageVersion '1.0.2' build; then return packageVersion is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSystemVersionInfo ImmutableSystemVersionInfo.copyOf(SystemVersionInfo)"
  })
  void testCopyOf_whenBuilderPackageVersion102Build_thenReturnPackageVersionIs102() {
    // Arrange
    ImmutableSystemVersionInfo instance =
        ImmutableSystemVersionInfo.builder().packageVersion("1.0.2").build();

    // Act
    ImmutableSystemVersionInfo actualCopyOfResult = ImmutableSystemVersionInfo.copyOf(instance);

    // Assert
    assertEquals("1.0.2", actualCopyOfResult.packageVersion());
    assertTrue(actualCopyOfResult.databaseVersions().isEmpty());
  }

  /**
   * Test {@link ImmutableSystemVersionInfo#equals(Object)}, and {@link
   * ImmutableSystemVersionInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSystemVersionInfo#equals(Object)}
   *   <li>{@link ImmutableSystemVersionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSystemVersionInfo.equals(Object)",
    "int ImmutableSystemVersionInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSystemVersionInfo immutableSystemVersionInfo =
        ImmutableSystemVersionInfo.builder().packageVersion("1.0.2").build();
    ImmutableSystemVersionInfo immutableSystemVersionInfo2 =
        ImmutableSystemVersionInfo.builder().packageVersion("1.0.2").build();

    // Act and Assert
    assertEquals(immutableSystemVersionInfo, immutableSystemVersionInfo2);
    assertEquals(immutableSystemVersionInfo.hashCode(), immutableSystemVersionInfo2.hashCode());
  }

  /**
   * Test {@link ImmutableSystemVersionInfo#equals(Object)}, and {@link
   * ImmutableSystemVersionInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSystemVersionInfo#equals(Object)}
   *   <li>{@link ImmutableSystemVersionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSystemVersionInfo.equals(Object)",
    "int ImmutableSystemVersionInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSystemVersionInfo immutableSystemVersionInfo =
        ImmutableSystemVersionInfo.builder().packageVersion("1.0.2").build();

    // Act and Assert
    assertEquals(immutableSystemVersionInfo, immutableSystemVersionInfo);
    int expectedHashCodeResult = immutableSystemVersionInfo.hashCode();
    assertEquals(expectedHashCodeResult, immutableSystemVersionInfo.hashCode());
  }

  /**
   * Test {@link ImmutableSystemVersionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSystemVersionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSystemVersionInfo.equals(Object)",
    "int ImmutableSystemVersionInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSystemVersionInfo.builder();
    builderResult.addDatabaseVersions("1.0.2");
    ImmutableSystemVersionInfo immutableSystemVersionInfo =
        builderResult.packageVersion("1.0.2").build();

    // Act and Assert
    assertNotEquals(
        immutableSystemVersionInfo,
        ImmutableSystemVersionInfo.builder().packageVersion("1.0.2").build());
  }

  /**
   * Test {@link ImmutableSystemVersionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSystemVersionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSystemVersionInfo.equals(Object)",
    "int ImmutableSystemVersionInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableSystemVersionInfo immutableSystemVersionInfo =
        ImmutableSystemVersionInfo.builder().packageVersion("java.text").build();

    // Act and Assert
    assertNotEquals(
        immutableSystemVersionInfo,
        ImmutableSystemVersionInfo.builder().packageVersion("1.0.2").build());
  }

  /**
   * Test {@link ImmutableSystemVersionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSystemVersionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSystemVersionInfo.equals(Object)",
    "int ImmutableSystemVersionInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableSystemVersionInfo.builder().packageVersion("1.0.2").build(), null);
  }

  /**
   * Test {@link ImmutableSystemVersionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSystemVersionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSystemVersionInfo.equals(Object)",
    "int ImmutableSystemVersionInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSystemVersionInfo.builder().packageVersion("1.0.2").build(),
        "Different type to ImmutableSystemVersionInfo");
  }

  /**
   * Test {@link ImmutableSystemVersionInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code Json}.
   *   <li>Then return databaseVersions size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSystemVersionInfo#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add 'Json'; then return databaseVersions size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSystemVersionInfo ImmutableSystemVersionInfo.fromJson(Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnDatabaseVersionsSizeIsOne() {
    // Arrange
    ArrayList<String> databaseVersions = new ArrayList<>();
    databaseVersions.add("Json");

    Json json = new Json();
    json.setPackageVersion("Json");
    json.setDatabaseVersions(databaseVersions);

    // Act
    ImmutableSystemVersionInfo actualFromJsonResult = ImmutableSystemVersionInfo.fromJson(json);

    // Assert
    List<String> databaseVersionsResult = actualFromJsonResult.databaseVersions();
    assertEquals(1, databaseVersionsResult.size());
    assertEquals("Json", databaseVersionsResult.get(0));
  }

  /**
   * Test {@link ImmutableSystemVersionInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return packageVersion is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSystemVersionInfo#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList(); then return packageVersion is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSystemVersionInfo ImmutableSystemVersionInfo.fromJson(Json)"})
  void testFromJson_givenArrayList_thenReturnPackageVersionIsJson() {
    // Arrange
    Json json = new Json();
    json.setPackageVersion("Json");
    json.setDatabaseVersions(new ArrayList<>());

    // Act
    ImmutableSystemVersionInfo actualFromJsonResult = ImmutableSystemVersionInfo.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.packageVersion());
    assertTrue(actualFromJsonResult.databaseVersions().isEmpty());
  }

  /**
   * Test {@link ImmutableSystemVersionInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return databaseVersions is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSystemVersionInfo#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return databaseVersions is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSystemVersionInfo ImmutableSystemVersionInfo.fromJson(Json)"})
  void testFromJson_thenReturnDatabaseVersionsIsArrayList() {
    // Arrange
    ArrayList<String> databaseVersions = new ArrayList<>();
    databaseVersions.add("packageVersion");
    databaseVersions.add("Json");

    Json json = new Json();
    json.setPackageVersion("Json");
    json.setDatabaseVersions(databaseVersions);

    // Act
    ImmutableSystemVersionInfo actualFromJsonResult = ImmutableSystemVersionInfo.fromJson(json);

    // Assert
    assertEquals(databaseVersions, actualFromJsonResult.databaseVersions());
  }

  /**
   * Test {@link ImmutableSystemVersionInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) DatabaseVersions is {@code null}.
   *   <li>Then return packageVersion is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSystemVersionInfo#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) DatabaseVersions is 'null'; then return packageVersion is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSystemVersionInfo ImmutableSystemVersionInfo.fromJson(Json)"})
  void testFromJson_whenJsonDatabaseVersionsIsNull_thenReturnPackageVersionIsJson() {
    // Arrange
    Json json = new Json();
    json.setPackageVersion("Json");
    json.setDatabaseVersions(null);

    // Act
    ImmutableSystemVersionInfo actualFromJsonResult = ImmutableSystemVersionInfo.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.packageVersion());
    assertTrue(actualFromJsonResult.databaseVersions().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSystemVersionInfo#toString()}
   *   <li>{@link ImmutableSystemVersionInfo#databaseVersions()}
   *   <li>{@link ImmutableSystemVersionInfo#packageVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ImmutableSystemVersionInfo.databaseVersions()",
    "String ImmutableSystemVersionInfo.packageVersion()",
    "String ImmutableSystemVersionInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSystemVersionInfo immutableSystemVersionInfo =
        ImmutableSystemVersionInfo.builder().packageVersion("1.0.2").build();

    // Act
    String actualToStringResult = immutableSystemVersionInfo.toString();
    List<String> actualDatabaseVersionsResult = immutableSystemVersionInfo.databaseVersions();

    // Assert
    assertEquals("1.0.2", immutableSystemVersionInfo.packageVersion());
    assertEquals(
        "SystemVersionInfo{packageVersion=1.0.2, databaseVersions=[]}", actualToStringResult);
    assertTrue(actualDatabaseVersionsResult.isEmpty());
  }

  /**
   * Test Json {@link Json#databaseVersions()}.
   *
   * <p>Method under test: {@link Json#databaseVersions()}
   */
  @Test
  @DisplayName("Test Json databaseVersions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.databaseVersions()"})
  void testJsonDatabaseVersions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().databaseVersions());
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
    assertNull(actualJson.packageVersion);
    assertTrue(actualJson.databaseVersions.isEmpty());
  }

  /**
   * Test Json {@link Json#packageVersion()}.
   *
   * <p>Method under test: {@link Json#packageVersion()}
   */
  @Test
  @DisplayName("Test Json packageVersion()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.packageVersion()"})
  void testJsonPackageVersion() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().packageVersion());
  }

  /**
   * Test {@link ImmutableSystemVersionInfo#withDatabaseVersions(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@code Elements}.
   *   <li>Then return packageVersion is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSystemVersionInfo#withDatabaseVersions(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withDatabaseVersions(Iterable) with 'Iterable'; given 'Elements'; then return packageVersion is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSystemVersionInfo ImmutableSystemVersionInfo.withDatabaseVersions(Iterable)"
  })
  void testWithDatabaseVersionsWithIterable_givenElements_thenReturnPackageVersionIs102() {
    // Arrange
    ImmutableSystemVersionInfo immutableSystemVersionInfo =
        ImmutableSystemVersionInfo.builder().packageVersion("1.0.2").build();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    ImmutableSystemVersionInfo actualWithDatabaseVersionsResult =
        immutableSystemVersionInfo.withDatabaseVersions(elements);

    // Assert
    assertEquals("1.0.2", actualWithDatabaseVersionsResult.packageVersion());
    List<String> databaseVersionsResult = actualWithDatabaseVersionsResult.databaseVersions();
    assertEquals(1, databaseVersionsResult.size());
    assertEquals("Elements", databaseVersionsResult.get(0));
  }

  /**
   * Test {@link ImmutableSystemVersionInfo#withDatabaseVersions(String[])} with {@code String[]}.
   *
   * <p>Method under test: {@link ImmutableSystemVersionInfo#withDatabaseVersions(String[])}
   */
  @Test
  @DisplayName("Test withDatabaseVersions(String[]) with 'String[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSystemVersionInfo ImmutableSystemVersionInfo.withDatabaseVersions(String[])"
  })
  void testWithDatabaseVersionsWithString() {
    // Arrange and Act
    ImmutableSystemVersionInfo actualWithDatabaseVersionsResult =
        ImmutableSystemVersionInfo.builder()
            .packageVersion("1.0.2")
            .build()
            .withDatabaseVersions("Elements");

    // Assert
    assertEquals("1.0.2", actualWithDatabaseVersionsResult.packageVersion());
    List<String> databaseVersionsResult = actualWithDatabaseVersionsResult.databaseVersions();
    assertEquals(1, databaseVersionsResult.size());
    assertEquals("Elements", databaseVersionsResult.get(0));
  }

  /**
   * Test {@link ImmutableSystemVersionInfo#withPackageVersion(String)}.
   *
   * <ul>
   *   <li>Then return builder packageVersion {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSystemVersionInfo#withPackageVersion(String)}
   */
  @Test
  @DisplayName("Test withPackageVersion(String); then return builder packageVersion '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSystemVersionInfo ImmutableSystemVersionInfo.withPackageVersion(String)"
  })
  void testWithPackageVersion_thenReturnBuilderPackageVersion42Build() {
    // Arrange
    ImmutableSystemVersionInfo immutableSystemVersionInfo =
        ImmutableSystemVersionInfo.builder().packageVersion("42").build();

    // Act
    ImmutableSystemVersionInfo actualWithPackageVersionResult =
        immutableSystemVersionInfo.withPackageVersion("42");

    // Assert
    assertSame(immutableSystemVersionInfo, actualWithPackageVersionResult);
  }

  /**
   * Test {@link ImmutableSystemVersionInfo#withPackageVersion(String)}.
   *
   * <ul>
   *   <li>Then return packageVersion is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSystemVersionInfo#withPackageVersion(String)}
   */
  @Test
  @DisplayName("Test withPackageVersion(String); then return packageVersion is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSystemVersionInfo ImmutableSystemVersionInfo.withPackageVersion(String)"
  })
  void testWithPackageVersion_thenReturnPackageVersionIs42() {
    // Arrange and Act
    ImmutableSystemVersionInfo actualWithPackageVersionResult =
        ImmutableSystemVersionInfo.builder()
            .packageVersion("1.0.2")
            .build()
            .withPackageVersion("42");

    // Assert
    assertEquals("42", actualWithPackageVersionResult.packageVersion());
    assertTrue(actualWithPackageVersionResult.databaseVersions().isEmpty());
  }
}
