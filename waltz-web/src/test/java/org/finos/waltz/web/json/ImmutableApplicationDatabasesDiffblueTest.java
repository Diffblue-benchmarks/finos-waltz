package org.finos.waltz.web.json;

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
import org.finos.waltz.model.database_information.DatabaseInformation;
import org.finos.waltz.web.json.ImmutableApplicationDatabases.Builder;
import org.finos.waltz.web.json.ImmutableApplicationDatabases.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableApplicationDatabasesDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllDatabases(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllDatabases(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllDatabases(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllDatabases(Iterable)"})
  void testBuilderAddAllDatabases_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationDatabases.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDatabases(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addDatabases(DatabaseInformation)} with {@code element}.
   * <ul>
   *   <li>When {@link DatabaseInformation}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addDatabases(DatabaseInformation)}
   */
  @Test
  @DisplayName("Test Builder addDatabases(DatabaseInformation) with 'element'; when DatabaseInformation; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDatabases(DatabaseInformation)"})
  void testBuilderAddDatabasesWithElement_whenDatabaseInformation_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationDatabases.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDatabases(mock(DatabaseInformation.class)));
  }

  /**
   * Test Builder {@link Builder#addDatabases(DatabaseInformation[])} with {@code elements}.
   * <ul>
   *   <li>When {@link DatabaseInformation}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addDatabases(DatabaseInformation[])}
   */
  @Test
  @DisplayName("Test Builder addDatabases(DatabaseInformation[]) with 'elements'; when DatabaseInformation; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDatabases(DatabaseInformation[])"})
  void testBuilderAddDatabasesWithElements_whenDatabaseInformation_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationDatabases.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDatabases(mock(DatabaseInformation.class)));
  }

  /**
   * Test Builder {@link Builder#applicationId(Long)}.
   * <p>
   * Method under test: {@link Builder#applicationId(Long)}
   */
  @Test
  @DisplayName("Test Builder applicationId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.applicationId(Long)"})
  void testBuilderApplicationId() {
    // Arrange
    Builder builderResult = ImmutableApplicationDatabases.builder();

    // Act
    Builder actualApplicationIdResult = builderResult.applicationId(1L);

    // Assert
    assertEquals(1L, builderResult.build().applicationId().longValue());
    assertSame(builderResult, actualApplicationIdResult);
  }

  /**
   * Test Builder {@link Builder#databases(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#databases(Iterable)}
   */
  @Test
  @DisplayName("Test Builder databases(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.databases(Iterable)"})
  void testBuilderDatabases_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationDatabases.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.databases(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(ApplicationDatabases)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then builder build applicationId longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApplicationDatabases)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationDatabases); given ArrayList(); then builder build applicationId longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationDatabases)"})
  void testBuilderFrom_givenArrayList_thenBuilderBuildApplicationIdLongValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableApplicationDatabases.builder();
    ApplicationDatabases instance = mock(ApplicationDatabases.class);
    when(instance.applicationId()).thenReturn(1L);
    when(instance.databases()).thenReturn(new ArrayList<>());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicationId();
    verify(instance).databases();
    assertEquals(1L, builderResult.build().applicationId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationDatabases)}.
   * <ul>
   *   <li>Then builder build databases size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApplicationDatabases)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationDatabases); then builder build databases size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationDatabases)"})
  void testBuilderFrom_thenBuilderBuildDatabasesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableApplicationDatabases.builder();

    ArrayList<DatabaseInformation> databaseInformationList = new ArrayList<>();
    databaseInformationList.add(mock(DatabaseInformation.class));
    ApplicationDatabases instance = mock(ApplicationDatabases.class);
    when(instance.applicationId()).thenReturn(1L);
    when(instance.databases()).thenReturn(databaseInformationList);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicationId();
    verify(instance).databases();
    ImmutableApplicationDatabases buildResult = builderResult.build();
    assertEquals(1, buildResult.databases().size());
    assertEquals(1L, buildResult.applicationId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Json {@link Json#applicationId()}.
   * <p>
   * Method under test: {@link Json#applicationId()}
   */
  @Test
  @DisplayName("Test Json applicationId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.applicationId()"})
  void testJsonApplicationId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).applicationId());
  }

  /**
   * Test Json {@link Json#databases()}.
   * <p>
   * Method under test: {@link Json#databases()}
   */
  @Test
  @DisplayName("Test Json databases()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List Json.databases()"})
  void testJsonDatabases() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).databases());
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
    assertNull(actualJson.applicationId);
    assertTrue(actualJson.databases.isEmpty());
  }
}
