package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.finos.waltz.model.database_information.DatabaseInformation;
import org.junit.jupiter.api.Test;

class ImmutableApplicationDatabasesDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableApplicationDatabases.Builder#addAllDatabases(Iterable)}
   */
  @Test
  void testBuilderAddAllDatabases() {
    // Arrange
    ImmutableApplicationDatabases.Builder builderResult = ImmutableApplicationDatabases.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDatabases(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationDatabases.Builder#addDatabases(DatabaseInformation)}
   */
  @Test
  void testBuilderAddDatabases() {
    // Arrange
    ImmutableApplicationDatabases.Builder builderResult = ImmutableApplicationDatabases.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDatabases(mock(DatabaseInformation.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationDatabases.Builder#addDatabases(DatabaseInformation[])}
   */
  @Test
  void testBuilderAddDatabases2() {
    // Arrange
    ImmutableApplicationDatabases.Builder builderResult = ImmutableApplicationDatabases.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDatabases(mock(DatabaseInformation.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationDatabases.Builder#applicationId(Long)}
   */
  @Test
  void testBuilderApplicationId() {
    // Arrange
    ImmutableApplicationDatabases.Builder builderResult = ImmutableApplicationDatabases.builder();

    // Act
    ImmutableApplicationDatabases.Builder actualApplicationIdResult = builderResult.applicationId(1L);

    // Assert
    assertEquals(1L, builderResult.build().applicationId().longValue());
    assertSame(builderResult, actualApplicationIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationDatabases.Builder#applicationId(Long)}
   */
  @Test
  void testBuilderApplicationId2() {
    // Arrange
    ImmutableApplicationDatabases.Builder builderResult = ImmutableApplicationDatabases.builder();
    builderResult.addDatabases(mock(DatabaseInformation.class));

    // Act
    ImmutableApplicationDatabases.Builder actualApplicationIdResult = builderResult.applicationId(1L);

    // Assert
    ImmutableApplicationDatabases buildResult = builderResult.build();
    assertEquals(1, buildResult.databases().size());
    assertEquals(1L, buildResult.applicationId().longValue());
    assertSame(builderResult, actualApplicationIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationDatabases.Builder#databases(Iterable)}
   */
  @Test
  void testBuilderDatabases() {
    // Arrange
    ImmutableApplicationDatabases.Builder builderResult = ImmutableApplicationDatabases.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.databases(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationDatabases.Builder#from(ApplicationDatabases)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableApplicationDatabases.Builder builderResult = ImmutableApplicationDatabases.builder();
    ApplicationDatabases instance = mock(ApplicationDatabases.class);
    when(instance.applicationId()).thenReturn(1L);
    when(instance.databases()).thenReturn(new ArrayList<>());

    // Act
    ImmutableApplicationDatabases.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicationId();
    verify(instance).databases();
    assertEquals(1L, builderResult.build().applicationId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationDatabases.Builder#from(ApplicationDatabases)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableApplicationDatabases.Builder builderResult = ImmutableApplicationDatabases.builder();

    ArrayList<DatabaseInformation> databaseInformationList = new ArrayList<>();
    databaseInformationList.add(mock(DatabaseInformation.class));
    ApplicationDatabases instance = mock(ApplicationDatabases.class);
    when(instance.applicationId()).thenReturn(1L);
    when(instance.databases()).thenReturn(databaseInformationList);

    // Act
    ImmutableApplicationDatabases.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicationId();
    verify(instance).databases();
    ImmutableApplicationDatabases buildResult = builderResult.build();
    assertEquals(1, buildResult.databases().size());
    assertEquals(1L, buildResult.applicationId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationDatabases#copyOf(ApplicationDatabases)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ApplicationDatabases instance = mock(ApplicationDatabases.class);
    when(instance.applicationId()).thenReturn(1L);
    when(instance.databases()).thenReturn(new ArrayList<>());

    // Act
    ImmutableApplicationDatabases actualCopyOfResult = ImmutableApplicationDatabases.copyOf(instance);

    // Assert
    verify(instance).applicationId();
    verify(instance).databases();
    assertEquals(1L, actualCopyOfResult.applicationId().longValue());
    assertTrue(actualCopyOfResult.databases().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationDatabases#copyOf(ApplicationDatabases)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<DatabaseInformation> databaseInformationList = new ArrayList<>();
    databaseInformationList.add(mock(DatabaseInformation.class));
    ApplicationDatabases instance = mock(ApplicationDatabases.class);
    when(instance.applicationId()).thenReturn(1L);
    when(instance.databases()).thenReturn(databaseInformationList);

    // Act
    ImmutableApplicationDatabases actualCopyOfResult = ImmutableApplicationDatabases.copyOf(instance);

    // Assert
    verify(instance).applicationId();
    verify(instance).databases();
    assertEquals(1, actualCopyOfResult.databases().size());
    assertEquals(1L, actualCopyOfResult.applicationId().longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationDatabases#copyOf(ApplicationDatabases)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<DatabaseInformation> databaseInformationList = new ArrayList<>();
    databaseInformationList.add(mock(DatabaseInformation.class));
    databaseInformationList.add(mock(DatabaseInformation.class));
    ApplicationDatabases instance = mock(ApplicationDatabases.class);
    when(instance.applicationId()).thenReturn(1L);
    when(instance.databases()).thenReturn(databaseInformationList);

    // Act
    ImmutableApplicationDatabases actualCopyOfResult = ImmutableApplicationDatabases.copyOf(instance);

    // Assert
    verify(instance).applicationId();
    verify(instance).databases();
    assertEquals(1L, actualCopyOfResult.applicationId().longValue());
    assertEquals(databaseInformationList, actualCopyOfResult.databases());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationDatabases#fromJson(ImmutableApplicationDatabases.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableApplicationDatabases.Json json = new ImmutableApplicationDatabases.Json();
    json.setApplicationId(1L);
    json.setDatabases(null);

    // Act
    ImmutableApplicationDatabases actualFromJsonResult = ImmutableApplicationDatabases.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.applicationId().longValue());
    assertTrue(actualFromJsonResult.databases().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationDatabases#fromJson(ImmutableApplicationDatabases.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ArrayList<DatabaseInformation> databases = new ArrayList<>();
    databases.add(mock(DatabaseInformation.class));

    ImmutableApplicationDatabases.Json json = new ImmutableApplicationDatabases.Json();
    json.setApplicationId(1L);
    json.setDatabases(databases);

    // Act
    ImmutableApplicationDatabases actualFromJsonResult = ImmutableApplicationDatabases.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.databases().size());
    assertEquals(1L, actualFromJsonResult.applicationId().longValue());
  }

  /**
   * Method under test: {@link ImmutableApplicationDatabases.Json#applicationId()}
   */
  @Test
  void testJsonApplicationId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplicationDatabases.Json()).applicationId());
  }

  /**
   * Method under test: {@link ImmutableApplicationDatabases.Json#databases()}
   */
  @Test
  void testJsonDatabases() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplicationDatabases.Json()).databases());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableApplicationDatabases.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableApplicationDatabases.Json actualJson = new ImmutableApplicationDatabases.Json();

    // Assert
    assertNull(actualJson.applicationId);
    assertTrue(actualJson.databases.isEmpty());
  }
}
