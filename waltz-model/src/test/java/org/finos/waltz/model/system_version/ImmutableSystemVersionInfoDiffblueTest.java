package org.finos.waltz.model.system_version;

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
   * <ul>
   *   <li>Given {@code Elements}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllDatabaseVersions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllDatabaseVersions(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllDatabaseVersions(Iterable)"})
  void testBuilderAddAllDatabaseVersions_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableSystemVersionInfo.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDatabaseVersions(elements));
  }

  /**
   * Test Builder {@link Builder#addAllDatabaseVersions(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllDatabaseVersions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllDatabaseVersions(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllDatabaseVersions(Iterable)"})
  void testBuilderAddAllDatabaseVersions_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSystemVersionInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDatabaseVersions(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addDatabaseVersions(String)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addDatabaseVersions(String)}
   */
  @Test
  @DisplayName("Test Builder addDatabaseVersions(String) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDatabaseVersions(String)"})
  void testBuilderAddDatabaseVersionsWithElement() {
    // Arrange
    Builder builderResult = ImmutableSystemVersionInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDatabaseVersions("Element"));
  }

  /**
   * Test Builder {@link Builder#addDatabaseVersions(String[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addDatabaseVersions(String[])}
   */
  @Test
  @DisplayName("Test Builder addDatabaseVersions(String[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDatabaseVersions(String[])"})
  void testBuilderAddDatabaseVersionsWithElements() {
    // Arrange
    Builder builderResult = ImmutableSystemVersionInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDatabaseVersions("Elements"));
  }

  /**
   * Test Builder {@link Builder#databaseVersions(Iterable)}.
   * <ul>
   *   <li>Given {@code Elements}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#databaseVersions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder databaseVersions(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.databaseVersions(Iterable)"})
  void testBuilderDatabaseVersions_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableSystemVersionInfo.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.databaseVersions(elements));
  }

  /**
   * Test Builder {@link Builder#databaseVersions(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#databaseVersions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder databaseVersions(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.databaseVersions(Iterable)"})
  void testBuilderDatabaseVersions_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSystemVersionInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.databaseVersions(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(SystemVersionInfo)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then builder build packageVersion is {@code 1.0.2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SystemVersionInfo)}
   */
  @Test
  @DisplayName("Test Builder from(SystemVersionInfo); given ArrayList(); then builder build packageVersion is '1.0.2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SystemVersionInfo)"})
  void testBuilderFrom_givenArrayList_thenBuilderBuildPackageVersionIs102() {
    // Arrange
    Builder builderResult = ImmutableSystemVersionInfo.builder();
    SystemVersionInfo instance = mock(SystemVersionInfo.class);
    when(instance.databaseVersions()).thenReturn(new ArrayList<>());
    when(instance.packageVersion()).thenReturn("1.0.2");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).databaseVersions();
    verify(instance).packageVersion();
    assertEquals("1.0.2", builderResult.build().packageVersion());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SystemVersionInfo)}.
   * <ul>
   *   <li>Then builder build databaseVersions size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SystemVersionInfo)}
   */
  @Test
  @DisplayName("Test Builder from(SystemVersionInfo); then builder build databaseVersions size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SystemVersionInfo)"})
  void testBuilderFrom_thenBuilderBuildDatabaseVersionsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSystemVersionInfo.builder();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("instance");
    SystemVersionInfo instance = mock(SystemVersionInfo.class);
    when(instance.databaseVersions()).thenReturn(stringList);
    when(instance.packageVersion()).thenReturn("1.0.2");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).databaseVersions();
    verify(instance).packageVersion();
    ImmutableSystemVersionInfo buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.packageVersion());
    List<String> databaseVersionsResult = buildResult.databaseVersions();
    assertEquals(1, databaseVersionsResult.size());
    assertEquals("instance", databaseVersionsResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SystemVersionInfo)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SystemVersionInfo)}
   */
  @Test
  @DisplayName("Test Builder from(SystemVersionInfo); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SystemVersionInfo)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSystemVersionInfo.builder();
    SystemVersionInfo instance = mock(SystemVersionInfo.class);
    when(instance.databaseVersions()).thenThrow(new IllegalStateException("instance"));
    when(instance.packageVersion()).thenReturn("1.0.2");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).databaseVersions();
    verify(instance).packageVersion();
  }

  /**
   * Test Builder {@link Builder#packageVersion(String)}.
   * <p>
   * Method under test: {@link Builder#packageVersion(String)}
   */
  @Test
  @DisplayName("Test Builder packageVersion(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.packageVersion(String)"})
  void testBuilderPackageVersion() {
    // Arrange
    Builder builderResult = ImmutableSystemVersionInfo.builder();

    // Act
    Builder actualPackageVersionResult = builderResult.packageVersion("1.0.2");

    // Assert
    assertEquals("1.0.2", builderResult.build().packageVersion());
    assertSame(builderResult, actualPackageVersionResult);
  }

  /**
   * Test Json {@link Json#databaseVersions()}.
   * <p>
   * Method under test: {@link Json#databaseVersions()}
   */
  @Test
  @DisplayName("Test Json databaseVersions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.databaseVersions()"})
  void testJsonDatabaseVersions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).databaseVersions());
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
    assertNull(actualJson.packageVersion);
    assertTrue(actualJson.databaseVersions.isEmpty());
  }

  /**
   * Test Json {@link Json#packageVersion()}.
   * <p>
   * Method under test: {@link Json#packageVersion()}
   */
  @Test
  @DisplayName("Test Json packageVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.packageVersion()"})
  void testJsonPackageVersion() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).packageVersion());
  }
}
