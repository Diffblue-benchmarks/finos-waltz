package org.finos.waltz.model.system_version;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

class ImmutableSystemVersionInfoDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSystemVersionInfo.Builder#addAllDatabaseVersions(Iterable)}
   */
  @Test
  void testBuilderAddAllDatabaseVersions() {
    // Arrange
    ImmutableSystemVersionInfo.Builder builderResult = ImmutableSystemVersionInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDatabaseVersions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSystemVersionInfo.Builder#addAllDatabaseVersions(Iterable)}
   */
  @Test
  void testBuilderAddAllDatabaseVersions2() {
    // Arrange
    ImmutableSystemVersionInfo.Builder builderResult = ImmutableSystemVersionInfo.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDatabaseVersions(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableSystemVersionInfo.Builder#addDatabaseVersions(String)}
   */
  @Test
  void testBuilderAddDatabaseVersions() {
    // Arrange
    ImmutableSystemVersionInfo.Builder builderResult = ImmutableSystemVersionInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDatabaseVersions("Element"));
  }

  /**
   * Method under test:
   * {@link ImmutableSystemVersionInfo.Builder#addDatabaseVersions(String[])}
   */
  @Test
  void testBuilderAddDatabaseVersions2() {
    // Arrange
    ImmutableSystemVersionInfo.Builder builderResult = ImmutableSystemVersionInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDatabaseVersions("Elements"));
  }

  /**
   * Method under test:
   * {@link ImmutableSystemVersionInfo.Builder#databaseVersions(Iterable)}
   */
  @Test
  void testBuilderDatabaseVersions() {
    // Arrange
    ImmutableSystemVersionInfo.Builder builderResult = ImmutableSystemVersionInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.databaseVersions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSystemVersionInfo.Builder#databaseVersions(Iterable)}
   */
  @Test
  void testBuilderDatabaseVersions2() {
    // Arrange
    ImmutableSystemVersionInfo.Builder builderResult = ImmutableSystemVersionInfo.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.databaseVersions(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableSystemVersionInfo.Builder#from(SystemVersionInfo)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSystemVersionInfo.Builder builderResult = ImmutableSystemVersionInfo.builder();
    SystemVersionInfo instance = mock(SystemVersionInfo.class);
    when(instance.databaseVersions()).thenReturn(new ArrayList<>());
    when(instance.packageVersion()).thenReturn("1.0.2");

    // Act
    ImmutableSystemVersionInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).databaseVersions();
    verify(instance).packageVersion();
    assertEquals("1.0.2", builderResult.build().packageVersion());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSystemVersionInfo.Builder#from(SystemVersionInfo)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSystemVersionInfo.Builder builderResult = ImmutableSystemVersionInfo.builder();
    SystemVersionInfo instance = mock(SystemVersionInfo.class);
    when(instance.databaseVersions()).thenThrow(new IllegalStateException("instance"));
    when(instance.packageVersion()).thenReturn("1.0.2");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).databaseVersions();
    verify(instance).packageVersion();
  }

  /**
   * Method under test:
   * {@link ImmutableSystemVersionInfo.Builder#from(SystemVersionInfo)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSystemVersionInfo.Builder builderResult = ImmutableSystemVersionInfo.builder();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("instance");
    SystemVersionInfo instance = mock(SystemVersionInfo.class);
    when(instance.databaseVersions()).thenReturn(stringList);
    when(instance.packageVersion()).thenReturn("1.0.2");

    // Act
    ImmutableSystemVersionInfo.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableSystemVersionInfo.Builder#packageVersion(String)}
   */
  @Test
  void testBuilderPackageVersion() {
    // Arrange
    ImmutableSystemVersionInfo.Builder builderResult = ImmutableSystemVersionInfo.builder();

    // Act
    ImmutableSystemVersionInfo.Builder actualPackageVersionResult = builderResult.packageVersion("1.0.2");

    // Assert
    assertEquals("1.0.2", builderResult.build().packageVersion());
    assertSame(builderResult, actualPackageVersionResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSystemVersionInfo#copyOf(SystemVersionInfo)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SystemVersionInfo instance = mock(SystemVersionInfo.class);
    when(instance.databaseVersions()).thenReturn(new ArrayList<>());
    when(instance.packageVersion()).thenReturn("1.0.2");

    // Act
    ImmutableSystemVersionInfo actualCopyOfResult = ImmutableSystemVersionInfo.copyOf(instance);

    // Assert
    verify(instance).databaseVersions();
    verify(instance).packageVersion();
    assertEquals("1.0.2", actualCopyOfResult.packageVersion());
    assertTrue(actualCopyOfResult.databaseVersions().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSystemVersionInfo#copyOf(SystemVersionInfo)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("instance");
    SystemVersionInfo instance = mock(SystemVersionInfo.class);
    when(instance.databaseVersions()).thenReturn(stringList);
    when(instance.packageVersion()).thenReturn("1.0.2");

    // Act
    ImmutableSystemVersionInfo actualCopyOfResult = ImmutableSystemVersionInfo.copyOf(instance);

    // Assert
    verify(instance).databaseVersions();
    verify(instance).packageVersion();
    assertEquals("1.0.2", actualCopyOfResult.packageVersion());
    List<String> databaseVersionsResult = actualCopyOfResult.databaseVersions();
    assertEquals(1, databaseVersionsResult.size());
    assertEquals("instance", databaseVersionsResult.get(0));
  }

  /**
   * Method under test:
   * {@link ImmutableSystemVersionInfo#copyOf(SystemVersionInfo)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("packageVersion");
    stringList.add("instance");
    SystemVersionInfo instance = mock(SystemVersionInfo.class);
    when(instance.databaseVersions()).thenReturn(stringList);
    when(instance.packageVersion()).thenReturn("1.0.2");

    // Act
    ImmutableSystemVersionInfo actualCopyOfResult = ImmutableSystemVersionInfo.copyOf(instance);

    // Assert
    verify(instance).databaseVersions();
    verify(instance).packageVersion();
    assertEquals("1.0.2", actualCopyOfResult.packageVersion());
    assertEquals(stringList, actualCopyOfResult.databaseVersions());
  }

  /**
   * Method under test:
   * {@link ImmutableSystemVersionInfo#fromJson(ImmutableSystemVersionInfo.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSystemVersionInfo.Json json = new ImmutableSystemVersionInfo.Json();
    json.setPackageVersion("Json");
    json.setDatabaseVersions(null);

    // Act
    ImmutableSystemVersionInfo actualFromJsonResult = ImmutableSystemVersionInfo.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.packageVersion());
    assertTrue(actualFromJsonResult.databaseVersions().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSystemVersionInfo#fromJson(ImmutableSystemVersionInfo.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ArrayList<String> databaseVersions = new ArrayList<>();
    databaseVersions.add("Json");

    ImmutableSystemVersionInfo.Json json = new ImmutableSystemVersionInfo.Json();
    json.setPackageVersion("Json");
    json.setDatabaseVersions(databaseVersions);

    // Act
    ImmutableSystemVersionInfo actualFromJsonResult = ImmutableSystemVersionInfo.fromJson(json);

    // Assert
    List<String> databaseVersionsResult = actualFromJsonResult.databaseVersions();
    assertEquals(1, databaseVersionsResult.size());
    assertEquals("Json", databaseVersionsResult.get(0));
    assertEquals("Json", actualFromJsonResult.packageVersion());
  }

  /**
   * Method under test:
   * {@link ImmutableSystemVersionInfo#fromJson(ImmutableSystemVersionInfo.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ArrayList<String> databaseVersions = new ArrayList<>();
    databaseVersions.add("packageVersion");
    databaseVersions.add("Json");

    ImmutableSystemVersionInfo.Json json = new ImmutableSystemVersionInfo.Json();
    json.setPackageVersion("Json");
    json.setDatabaseVersions(databaseVersions);

    // Act
    ImmutableSystemVersionInfo actualFromJsonResult = ImmutableSystemVersionInfo.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.packageVersion());
    assertEquals(databaseVersions, actualFromJsonResult.databaseVersions());
  }

  /**
   * Method under test: {@link ImmutableSystemVersionInfo.Json#databaseVersions()}
   */
  @Test
  void testJsonDatabaseVersions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSystemVersionInfo.Json()).databaseVersions());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSystemVersionInfo.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSystemVersionInfo.Json actualJson = new ImmutableSystemVersionInfo.Json();

    // Assert
    assertNull(actualJson.packageVersion);
    assertTrue(actualJson.databaseVersions.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableSystemVersionInfo.Json#packageVersion()}
   */
  @Test
  void testJsonPackageVersion() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSystemVersionInfo.Json()).packageVersion());
  }
}
