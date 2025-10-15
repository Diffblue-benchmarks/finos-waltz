package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.LifecycleStatus;
import org.finos.waltz.model.database_information.DatabaseInformation;
import org.finos.waltz.model.database_information.ImmutableDatabaseInformation;
import org.finos.waltz.web.json.ImmutableApplicationDatabases.Builder;
import org.finos.waltz.web.json.ImmutableApplicationDatabases.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableApplicationDatabasesDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllDatabases(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllDatabases(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllDatabases(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllDatabases(Iterable)"})
  void testBuilderAddAllDatabases_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationDatabases.builder();

    // Act
    Builder actualAddAllDatabasesResult = builderResult.addAllDatabases(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllDatabasesResult);
  }

  /**
   * Test Builder {@link Builder#addDatabases(DatabaseInformation)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link DatabaseInformation}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addDatabases(DatabaseInformation)}
   */
  @Test
  @DisplayName(
      "Test Builder addDatabases(DatabaseInformation) with 'element'; when DatabaseInformation; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addDatabases(DatabaseInformation)"})
  void testBuilderAddDatabasesWithElement_whenDatabaseInformation_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationDatabases.builder();

    // Act
    Builder actualAddDatabasesResult = builderResult.addDatabases(mock(DatabaseInformation.class));

    // Assert
    assertSame(builderResult, actualAddDatabasesResult);
  }

  /**
   * Test Builder {@link Builder#addDatabases(DatabaseInformation[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link DatabaseInformation}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addDatabases(DatabaseInformation[])}
   */
  @Test
  @DisplayName(
      "Test Builder addDatabases(DatabaseInformation[]) with 'elements'; when DatabaseInformation; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addDatabases(DatabaseInformation[])"})
  void testBuilderAddDatabasesWithElements_whenDatabaseInformation_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationDatabases.builder();

    // Act
    Builder actualAddDatabasesResult = builderResult.addDatabases(mock(DatabaseInformation.class));

    // Assert
    assertSame(builderResult, actualAddDatabasesResult);
  }

  /**
   * Test Builder {@link Builder#applicationId(Long)}.
   *
   * <p>Method under test: {@link Builder#applicationId(Long)}
   */
  @Test
  @DisplayName("Test Builder applicationId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplicationDatabases Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableApplicationDatabases actualImmutableApplicationDatabases =
        ImmutableApplicationDatabases.builder().applicationId(1L).build();

    // Assert
    assertEquals(1L, actualImmutableApplicationDatabases.applicationId().longValue());
    assertTrue(actualImmutableApplicationDatabases.databases().isEmpty());
  }

  /**
   * Test Builder {@link Builder#databases(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#databases(Iterable)}
   */
  @Test
  @DisplayName("Test Builder databases(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.databases(Iterable)"})
  void testBuilderDatabases_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationDatabases.builder();

    // Act
    Builder actualDatabasesResult = builderResult.databases(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualDatabasesResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationDatabases)}.
   *
   * <ul>
   *   <li>Then builder build is builder applicationId one build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ApplicationDatabases)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ApplicationDatabases); then builder build is builder applicationId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationDatabases)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderApplicationIdOneBuild() {
    // Arrange
    Builder builderResult = ImmutableApplicationDatabases.builder();
    ImmutableApplicationDatabases instance =
        ImmutableApplicationDatabases.builder().applicationId(1L).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableApplicationDatabases actualImmutableApplicationDatabases = builderResult.build();
    assertEquals(instance, actualImmutableApplicationDatabases);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationDatabases)}.
   *
   * <ul>
   *   <li>Then return build databases size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ApplicationDatabases)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationDatabases); then return build databases size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationDatabases)"})
  void testBuilderFrom_thenReturnBuildDatabasesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableApplicationDatabases.builder();

    Builder builderResult2 = ImmutableApplicationDatabases.builder();

    ImmutableDatabaseInformation.Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    builderResult2.addDatabases(
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build());

    // Act and Assert
    List<DatabaseInformation> databasesResult =
        builderResult.from(builderResult2.applicationId(1L).build()).build().databases();
    assertEquals(1, databasesResult.size());
    DatabaseInformation getResult = databasesResult.get(0);
    assertTrue(getResult instanceof ImmutableDatabaseInformation);
    assertEquals("1.0.2", getResult.dbmsVersion());
    assertEquals("Database Name", getResult.databaseName());
    assertEquals("Dbms Name", getResult.dbmsName());
    assertEquals("Dbms Vendor", getResult.dbmsVendor());
    assertEquals("Instance Name", getResult.instanceName());
    assertEquals("Provenance", getResult.provenance());
    assertEquals(EntityKind.ALL, getResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, getResult.lifecycleStatus());
  }

  /**
   * Test {@link ImmutableApplicationDatabases#copyOf(ApplicationDatabases)}.
   *
   * <ul>
   *   <li>Then return applicationId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationDatabases#copyOf(ApplicationDatabases)}
   */
  @Test
  @DisplayName("Test copyOf(ApplicationDatabases); then return applicationId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationDatabases ImmutableApplicationDatabases.copyOf(ApplicationDatabases)"
  })
  void testCopyOf_thenReturnApplicationIdLongValueIsOne() {
    // Arrange
    ImmutableApplicationDatabases instance =
        ImmutableApplicationDatabases.builder().applicationId(1L).build();

    // Act
    ImmutableApplicationDatabases actualCopyOfResult =
        ImmutableApplicationDatabases.copyOf(instance);

    // Assert
    assertEquals(1L, actualCopyOfResult.applicationId().longValue());
    assertTrue(actualCopyOfResult.databases().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationDatabases#equals(Object)}, and {@link
   * ImmutableApplicationDatabases#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationDatabases#equals(Object)}
   *   <li>{@link ImmutableApplicationDatabases#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationDatabases.equals(Object)",
    "int ImmutableApplicationDatabases.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableApplicationDatabases immutableApplicationDatabases =
        ImmutableApplicationDatabases.builder().applicationId(1L).build();
    ImmutableApplicationDatabases immutableApplicationDatabases2 =
        ImmutableApplicationDatabases.builder().applicationId(1L).build();

    // Act and Assert
    assertEquals(immutableApplicationDatabases, immutableApplicationDatabases2);
    assertEquals(
        immutableApplicationDatabases.hashCode(), immutableApplicationDatabases2.hashCode());
  }

  /**
   * Test {@link ImmutableApplicationDatabases#equals(Object)}, and {@link
   * ImmutableApplicationDatabases#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationDatabases#equals(Object)}
   *   <li>{@link ImmutableApplicationDatabases#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationDatabases.equals(Object)",
    "int ImmutableApplicationDatabases.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableApplicationDatabases immutableApplicationDatabases =
        ImmutableApplicationDatabases.builder().applicationId(1L).build();

    // Act and Assert
    assertEquals(immutableApplicationDatabases, immutableApplicationDatabases);
    int expectedHashCodeResult = immutableApplicationDatabases.hashCode();
    assertEquals(expectedHashCodeResult, immutableApplicationDatabases.hashCode());
  }

  /**
   * Test {@link ImmutableApplicationDatabases#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationDatabases#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationDatabases.equals(Object)",
    "int ImmutableApplicationDatabases.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationDatabases.builder();

    ImmutableDatabaseInformation.Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    builderResult.addDatabases(
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build());
    ImmutableApplicationDatabases immutableApplicationDatabases =
        builderResult.applicationId(1L).build();

    // Act and Assert
    assertNotEquals(
        immutableApplicationDatabases,
        ImmutableApplicationDatabases.builder().applicationId(1L).build());
  }

  /**
   * Test {@link ImmutableApplicationDatabases#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationDatabases#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationDatabases.equals(Object)",
    "int ImmutableApplicationDatabases.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableApplicationDatabases immutableApplicationDatabases =
        ImmutableApplicationDatabases.builder().applicationId(2L).build();

    // Act and Assert
    assertNotEquals(
        immutableApplicationDatabases,
        ImmutableApplicationDatabases.builder().applicationId(1L).build());
  }

  /**
   * Test {@link ImmutableApplicationDatabases#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationDatabases#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationDatabases.equals(Object)",
    "int ImmutableApplicationDatabases.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableApplicationDatabases.builder().applicationId(1L).build(), null);
  }

  /**
   * Test {@link ImmutableApplicationDatabases#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationDatabases#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationDatabases.equals(Object)",
    "int ImmutableApplicationDatabases.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableApplicationDatabases.builder().applicationId(1L).build(),
        "Different type to ImmutableApplicationDatabases");
  }

  /**
   * Test {@link ImmutableApplicationDatabases#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link DatabaseInformation}.
   *   <li>Then return databases size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationDatabases#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add DatabaseInformation; then return databases size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplicationDatabases ImmutableApplicationDatabases.fromJson(Json)"})
  void testFromJson_givenArrayListAddDatabaseInformation_thenReturnDatabasesSizeIsOne() {
    // Arrange
    ArrayList<DatabaseInformation> databases = new ArrayList<>();
    databases.add(mock(DatabaseInformation.class));

    Json json = new Json();
    json.setApplicationId(1L);
    json.setDatabases(databases);

    // Act
    ImmutableApplicationDatabases actualFromJsonResult =
        ImmutableApplicationDatabases.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.databases().size());
    assertEquals(1L, actualFromJsonResult.applicationId().longValue());
  }

  /**
   * Test {@link ImmutableApplicationDatabases#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link Json} (default constructor) ApplicationId is one.
   *   <li>Then return databases Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationDatabases#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList(); when Json (default constructor) ApplicationId is one; then return databases Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplicationDatabases ImmutableApplicationDatabases.fromJson(Json)"})
  void testFromJson_givenArrayList_whenJsonApplicationIdIsOne_thenReturnDatabasesEmpty() {
    // Arrange
    Json json = new Json();
    json.setApplicationId(1L);
    json.setDatabases(new ArrayList<>());

    // Act
    ImmutableApplicationDatabases actualFromJsonResult =
        ImmutableApplicationDatabases.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.applicationId().longValue());
    assertTrue(actualFromJsonResult.databases().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationDatabases#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Databases is {@code null}.
   *   <li>Then return databases Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationDatabases#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Databases is 'null'; then return databases Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplicationDatabases ImmutableApplicationDatabases.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonDatabasesIsNull_thenReturnDatabasesEmpty() {
    // Arrange
    Json json = new Json();
    json.setApplicationId(1L);
    json.setDatabases(null);

    // Act
    ImmutableApplicationDatabases actualFromJsonResult =
        ImmutableApplicationDatabases.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.applicationId().longValue());
    assertTrue(actualFromJsonResult.databases().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationDatabases#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return databases size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationDatabases#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return databases size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplicationDatabases ImmutableApplicationDatabases.fromJson(Json)"})
  void testFromJson_thenReturnDatabasesSizeIsTwo() {
    // Arrange
    ArrayList<DatabaseInformation> databases = new ArrayList<>();

    ImmutableDatabaseInformation.Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    databases.add(
        dbmsVersionResult
            .endOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .instanceName("Instance Name")
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .provenance("Provenance")
            .build());
    databases.add(mock(DatabaseInformation.class));

    Json json = new Json();
    json.setApplicationId(1L);
    json.setDatabases(databases);

    // Act
    ImmutableApplicationDatabases actualFromJsonResult =
        ImmutableApplicationDatabases.fromJson(json);

    // Assert
    List<DatabaseInformation> databasesResult = actualFromJsonResult.databases();
    assertEquals(2, databasesResult.size());
    DatabaseInformation getResult = databasesResult.get(0);
    assertTrue(getResult instanceof ImmutableDatabaseInformation);
    assertEquals("1.0.2", getResult.dbmsVersion());
    assertEquals("Database Name", getResult.databaseName());
    assertEquals("Dbms Name", getResult.dbmsName());
    assertEquals("Dbms Vendor", getResult.dbmsVendor());
    assertEquals("Instance Name", getResult.instanceName());
    assertEquals("Provenance", getResult.provenance());
    assertEquals(EntityKind.ALL, getResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, getResult.lifecycleStatus());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationDatabases#toString()}
   *   <li>{@link ImmutableApplicationDatabases#applicationId()}
   *   <li>{@link ImmutableApplicationDatabases#databases()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ImmutableApplicationDatabases.applicationId()",
    "List ImmutableApplicationDatabases.databases()",
    "String ImmutableApplicationDatabases.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableApplicationDatabases immutableApplicationDatabases =
        ImmutableApplicationDatabases.builder().applicationId(1L).build();

    // Act
    String actualToStringResult = immutableApplicationDatabases.toString();
    Long actualApplicationIdResult = immutableApplicationDatabases.applicationId();
    List<DatabaseInformation> actualDatabasesResult = immutableApplicationDatabases.databases();

    // Assert
    assertEquals("ApplicationDatabases{applicationId=1, databases=[]}", actualToStringResult);
    assertEquals(1L, actualApplicationIdResult.longValue());
    assertTrue(actualDatabasesResult.isEmpty());
  }

  /**
   * Test Json {@link Json#applicationId()}.
   *
   * <p>Method under test: {@link Json#applicationId()}
   */
  @Test
  @DisplayName("Test Json applicationId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.applicationId()"})
  void testJsonApplicationId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().applicationId());
  }

  /**
   * Test Json {@link Json#databases()}.
   *
   * <p>Method under test: {@link Json#databases()}
   */
  @Test
  @DisplayName("Test Json databases()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.databases()"})
  void testJsonDatabases() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().databases());
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
    assertNull(actualJson.applicationId);
    assertTrue(actualJson.databases.isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationDatabases#withApplicationId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return applicationId longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationDatabases#withApplicationId(Long)}
   */
  @Test
  @DisplayName(
      "Test withApplicationId(Long); when forty-two; then return applicationId longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationDatabases ImmutableApplicationDatabases.withApplicationId(Long)"
  })
  void testWithApplicationId_whenFortyTwo_thenReturnApplicationIdLongValueIsFortyTwo() {
    // Arrange and Act
    ImmutableApplicationDatabases actualWithApplicationIdResult =
        ImmutableApplicationDatabases.builder().applicationId(1L).build().withApplicationId(42L);

    // Assert
    assertEquals(42L, actualWithApplicationIdResult.applicationId().longValue());
    assertTrue(actualWithApplicationIdResult.databases().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationDatabases#withApplicationId(Long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return builder applicationId one build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationDatabases#withApplicationId(Long)}
   */
  @Test
  @DisplayName(
      "Test withApplicationId(Long); when one; then return builder applicationId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationDatabases ImmutableApplicationDatabases.withApplicationId(Long)"
  })
  void testWithApplicationId_whenOne_thenReturnBuilderApplicationIdOneBuild() {
    // Arrange
    ImmutableApplicationDatabases immutableApplicationDatabases =
        ImmutableApplicationDatabases.builder().applicationId(1L).build();

    // Act
    ImmutableApplicationDatabases actualWithApplicationIdResult =
        immutableApplicationDatabases.withApplicationId(1L);

    // Assert
    assertSame(immutableApplicationDatabases, actualWithApplicationIdResult);
  }

  /**
   * Test {@link ImmutableApplicationDatabases#withDatabases(DatabaseInformation[])} with {@code
   * DatabaseInformation[]}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationDatabases#withDatabases(DatabaseInformation[])}
   */
  @Test
  @DisplayName("Test withDatabases(DatabaseInformation[]) with 'DatabaseInformation[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationDatabases ImmutableApplicationDatabases.withDatabases(DatabaseInformation[])"
  })
  void testWithDatabasesWithDatabaseInformation() {
    // Arrange
    ImmutableApplicationDatabases immutableApplicationDatabases =
        ImmutableApplicationDatabases.builder().applicationId(1L).build();

    ImmutableDatabaseInformation.Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");

    // Act
    ImmutableApplicationDatabases actualWithDatabasesResult =
        immutableApplicationDatabases.withDatabases(
            dbmsVersionResult
                .endOfLifeDate(
                    Date.from(
                        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .externalId("42")
                .id(1L)
                .instanceName("Instance Name")
                .kind(EntityKind.ALL)
                .lifecycleStatus(LifecycleStatus.ACTIVE)
                .provenance("Provenance")
                .build());

    // Assert
    List<DatabaseInformation> databasesResult = actualWithDatabasesResult.databases();
    assertEquals(1, databasesResult.size());
    DatabaseInformation getResult = databasesResult.get(0);
    assertTrue(getResult instanceof ImmutableDatabaseInformation);
    assertEquals("1.0.2", getResult.dbmsVersion());
    assertEquals("Database Name", getResult.databaseName());
    assertEquals("Dbms Name", getResult.dbmsName());
    assertEquals("Dbms Vendor", getResult.dbmsVendor());
    assertEquals("Instance Name", getResult.instanceName());
    assertEquals("Provenance", getResult.provenance());
    assertEquals(1L, actualWithDatabasesResult.applicationId().longValue());
    assertEquals(EntityKind.ALL, getResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, getResult.lifecycleStatus());
  }
}
