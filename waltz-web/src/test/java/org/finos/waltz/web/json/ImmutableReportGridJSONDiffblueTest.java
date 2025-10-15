package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Map;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.web.json.ImmutableReportGridJSON.Builder;
import org.finos.waltz.web.json.ImmutableReportGridJSON.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridJSONDiffblueTest {
  /**
   * Test Builder {@link Builder#apiTypes(ApiTypes)}.
   *
   * <ul>
   *   <li>When {@link ApiTypes} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#apiTypes(ApiTypes)}
   */
  @Test
  @DisplayName(
      "Test Builder apiTypes(ApiTypes); when ApiTypes (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.apiTypes(ApiTypes)"})
  void testBuilderApiTypes_whenApiTypes_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridJSON.builder();

    // Act
    Builder actualApiTypesResult = builderResult.apiTypes(new ApiTypes());

    // Assert
    assertSame(builderResult, actualApiTypesResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#type(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridJSON Builder.build()", "Builder Builder.type(String)"})
  void testBuilderBuild() {
    // Arrange
    ImmutableApiTypes apiTypes = ImmutableApiTypes.builder().build();

    // Act
    Builder actualApiTypesResult = ImmutableReportGridJSON.builder().apiTypes(apiTypes);
    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();
    ImmutableGrid grid = builderResult.columnDescriptors(new ArrayList<>()).build();
    ImmutableReportGridJSON actualImmutableReportGridJSON =
        actualApiTypesResult.grid(grid).id("42").name("Name").type("Type").build();

    // Assert
    assertEquals("42", actualImmutableReportGridJSON.id());
    assertEquals("Name", actualImmutableReportGridJSON.name());
    assertEquals("Type", actualImmutableReportGridJSON.type());
    assertSame(apiTypes, actualImmutableReportGridJSON.apiTypes());
    assertSame(grid, actualImmutableReportGridJSON.grid());
  }

  /**
   * Test Builder {@link Builder#from(JsonAPI)} with {@code JsonAPI}.
   *
   * <p>Method under test: {@link Builder#from(JsonAPI)}
   */
  @Test
  @DisplayName("Test Builder from(JsonAPI) with 'JsonAPI'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(JsonAPI)"})
  void testBuilderFromWithJsonAPI() {
    // Arrange
    Builder builderResult = ImmutableReportGridJSON.builder();

    Builder apiTypesResult =
        ImmutableReportGridJSON.builder().apiTypes(ImmutableApiTypes.builder().build());

    ImmutableGrid.Builder builderResult2 = ImmutableGrid.builder();
    ImmutableReportGridJSON instance =
        apiTypesResult
            .grid(builderResult2.columnDescriptors(new ArrayList<>()).build())
            .id("42")
            .name("Name")
            .type("Type")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((JsonAPI) instance);

    // Assert
    ImmutableReportGridJSON actualImmutableReportGridJSON = builderResult.build();
    assertEquals(instance, actualImmutableReportGridJSON);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridJSON)} with {@code ReportGridJSON}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridJSON)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridJSON) with 'ReportGridJSON'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridJSON)"})
  void testBuilderFromWithReportGridJSON() {
    // Arrange
    Builder builderResult = ImmutableReportGridJSON.builder();

    Builder apiTypesResult =
        ImmutableReportGridJSON.builder().apiTypes(ImmutableApiTypes.builder().build());

    ImmutableGrid.Builder builderResult2 = ImmutableGrid.builder();
    ImmutableReportGridJSON instance =
        apiTypesResult
            .grid(builderResult2.columnDescriptors(new ArrayList<>()).build())
            .id("42")
            .name("Name")
            .type("Type")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableReportGridJSON actualImmutableReportGridJSON = builderResult.build();
    assertEquals(instance, actualImmutableReportGridJSON);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#grid(Grid)}.
   *
   * <ul>
   *   <li>When {@link ImmutableGrid.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#grid(Grid)}
   */
  @Test
  @DisplayName("Test Builder grid(Grid); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.grid(Grid)"})
  void testBuilderGrid_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridJSON.builder();

    // Act
    Builder actualGridResult = builderResult.grid(new ImmutableGrid.Json());

    // Assert
    assertSame(builderResult, actualGridResult);
  }

  /**
   * Test Builder {@link Builder#id(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#id(String)}
   */
  @Test
  @DisplayName("Test Builder id(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(String)"})
  void testBuilderId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridJSON.builder();

    // Act
    Builder actualIdResult = builderResult.id("42");

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridJSON.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test {@link ImmutableReportGridJSON#copyOf(ReportGridJSON)}.
   *
   * <ul>
   *   <li>Then apiTypes return {@link ImmutableApiTypes}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridJSON#copyOf(ReportGridJSON)}
   */
  @Test
  @DisplayName("Test copyOf(ReportGridJSON); then apiTypes return ImmutableApiTypes")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridJSON ImmutableReportGridJSON.copyOf(ReportGridJSON)"})
  void testCopyOf_thenApiTypesReturnImmutableApiTypes() {
    // Arrange
    Builder apiTypesResult =
        ImmutableReportGridJSON.builder().apiTypes(ImmutableApiTypes.builder().build());

    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();
    ImmutableReportGridJSON instance =
        apiTypesResult
            .grid(builderResult.columnDescriptors(new ArrayList<>()).build())
            .id("42")
            .name("Name")
            .type("Type")
            .build();

    // Act
    ImmutableReportGridJSON actualCopyOfResult = ImmutableReportGridJSON.copyOf(instance);

    // Assert
    ApiTypes apiTypesResult2 = actualCopyOfResult.apiTypes();
    assertTrue(apiTypesResult2 instanceof ImmutableApiTypes);
    Grid gridResult = actualCopyOfResult.grid();
    assertTrue(gridResult instanceof ImmutableGrid);
    Map<String, String> cellTypes = apiTypesResult2.getCellTypes();
    assertEquals(2, cellTypes.size());
    assertEquals("/types/1/schema#id=CellValue", cellTypes.get(ApiTypes.VALCELL));
    assertEquals("/types/1/schema#id=KeyCell", cellTypes.get(ApiTypes.KEYCELL));
    assertEquals("42", actualCopyOfResult.id());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Type", actualCopyOfResult.type());
    assertTrue(gridResult.rows().isEmpty());
  }

  /**
   * Test {@link ImmutableReportGridJSON#equals(Object)}, and {@link
   * ImmutableReportGridJSON#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridJSON#equals(Object)}
   *   <li>{@link ImmutableReportGridJSON#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridJSON.equals(Object)",
    "int ImmutableReportGridJSON.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder apiTypesResult =
        ImmutableReportGridJSON.builder().apiTypes(ImmutableApiTypes.builder().build());

    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();
    ImmutableReportGridJSON immutableReportGridJSON =
        apiTypesResult
            .grid(builderResult.columnDescriptors(new ArrayList<>()).build())
            .id("42")
            .name("Name")
            .type("Type")
            .build();

    Builder apiTypesResult2 =
        ImmutableReportGridJSON.builder().apiTypes(ImmutableApiTypes.builder().build());

    ImmutableGrid.Builder builderResult2 = ImmutableGrid.builder();
    ImmutableReportGridJSON immutableReportGridJSON2 =
        apiTypesResult2
            .grid(builderResult2.columnDescriptors(new ArrayList<>()).build())
            .id("42")
            .name("Name")
            .type("Type")
            .build();

    // Act and Assert
    assertEquals(immutableReportGridJSON, immutableReportGridJSON2);
    assertEquals(immutableReportGridJSON.hashCode(), immutableReportGridJSON2.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridJSON#equals(Object)}, and {@link
   * ImmutableReportGridJSON#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridJSON#equals(Object)}
   *   <li>{@link ImmutableReportGridJSON#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridJSON.equals(Object)",
    "int ImmutableReportGridJSON.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder apiTypesResult =
        ImmutableReportGridJSON.builder().apiTypes(ImmutableApiTypes.builder().build());

    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();
    ImmutableReportGridJSON immutableReportGridJSON =
        apiTypesResult
            .grid(builderResult.columnDescriptors(new ArrayList<>()).build())
            .id("42")
            .name("Name")
            .type("Type")
            .build();

    // Act and Assert
    assertEquals(immutableReportGridJSON, immutableReportGridJSON);
    int expectedHashCodeResult = immutableReportGridJSON.hashCode();
    assertEquals(expectedHashCodeResult, immutableReportGridJSON.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridJSON#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridJSON#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridJSON.equals(Object)",
    "int ImmutableReportGridJSON.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();

    ImmutableRow.Builder builderResult2 = ImmutableRow.builder();
    builderResult.addRows(
        builderResult2
            .id(
                ImmutableKeyCell.builder()
                    .externalId("42")
                    .kind(EntityKind.ALL)
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .type("Type")
                    .waltzId(1L)
                    .build())
            .build());
    ImmutableGrid grid = builderResult.columnDescriptors(new ArrayList<>()).build();
    ImmutableReportGridJSON immutableReportGridJSON =
        ImmutableReportGridJSON.builder()
            .apiTypes(ImmutableApiTypes.builder().build())
            .grid(grid)
            .id("42")
            .name("Name")
            .type("Type")
            .build();

    Builder apiTypesResult =
        ImmutableReportGridJSON.builder().apiTypes(ImmutableApiTypes.builder().build());

    ImmutableGrid.Builder builderResult3 = ImmutableGrid.builder();

    // Act and Assert
    assertNotEquals(
        immutableReportGridJSON,
        apiTypesResult
            .grid(builderResult3.columnDescriptors(new ArrayList<>()).build())
            .id("42")
            .name("Name")
            .type("Type")
            .build());
  }

  /**
   * Test {@link ImmutableReportGridJSON#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridJSON#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridJSON.equals(Object)",
    "int ImmutableReportGridJSON.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder apiTypesResult =
        ImmutableReportGridJSON.builder().apiTypes(ImmutableApiTypes.builder().build());

    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();
    ImmutableReportGridJSON immutableReportGridJSON =
        apiTypesResult
            .grid(builderResult.columnDescriptors(new ArrayList<>()).build())
            .id("Type")
            .name("Name")
            .type("Type")
            .build();

    Builder apiTypesResult2 =
        ImmutableReportGridJSON.builder().apiTypes(ImmutableApiTypes.builder().build());

    ImmutableGrid.Builder builderResult2 = ImmutableGrid.builder();

    // Act and Assert
    assertNotEquals(
        immutableReportGridJSON,
        apiTypesResult2
            .grid(builderResult2.columnDescriptors(new ArrayList<>()).build())
            .id("42")
            .name("Name")
            .type("Type")
            .build());
  }

  /**
   * Test {@link ImmutableReportGridJSON#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridJSON#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridJSON.equals(Object)",
    "int ImmutableReportGridJSON.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder apiTypesResult =
        ImmutableReportGridJSON.builder().apiTypes(ImmutableApiTypes.builder().build());

    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();
    ImmutableReportGridJSON immutableReportGridJSON =
        apiTypesResult
            .grid(builderResult.columnDescriptors(new ArrayList<>()).build())
            .id("42")
            .name("Type")
            .type("Type")
            .build();

    Builder apiTypesResult2 =
        ImmutableReportGridJSON.builder().apiTypes(ImmutableApiTypes.builder().build());

    ImmutableGrid.Builder builderResult2 = ImmutableGrid.builder();

    // Act and Assert
    assertNotEquals(
        immutableReportGridJSON,
        apiTypesResult2
            .grid(builderResult2.columnDescriptors(new ArrayList<>()).build())
            .id("42")
            .name("Name")
            .type("Type")
            .build());
  }

  /**
   * Test {@link ImmutableReportGridJSON#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridJSON#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridJSON.equals(Object)",
    "int ImmutableReportGridJSON.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder apiTypesResult =
        ImmutableReportGridJSON.builder().apiTypes(ImmutableApiTypes.builder().build());

    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();
    ImmutableReportGridJSON immutableReportGridJSON =
        apiTypesResult
            .grid(builderResult.columnDescriptors(new ArrayList<>()).build())
            .id("42")
            .name("Name")
            .type("42")
            .build();

    Builder apiTypesResult2 =
        ImmutableReportGridJSON.builder().apiTypes(ImmutableApiTypes.builder().build());

    ImmutableGrid.Builder builderResult2 = ImmutableGrid.builder();

    // Act and Assert
    assertNotEquals(
        immutableReportGridJSON,
        apiTypesResult2
            .grid(builderResult2.columnDescriptors(new ArrayList<>()).build())
            .id("42")
            .name("Name")
            .type("Type")
            .build());
  }

  /**
   * Test {@link ImmutableReportGridJSON#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridJSON#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridJSON.equals(Object)",
    "int ImmutableReportGridJSON.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder apiTypesResult =
        ImmutableReportGridJSON.builder().apiTypes(ImmutableApiTypes.builder().build());

    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();

    // Act and Assert
    assertNotEquals(
        apiTypesResult
            .grid(builderResult.columnDescriptors(new ArrayList<>()).build())
            .id("42")
            .name("Name")
            .type("Type")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableReportGridJSON#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridJSON#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridJSON.equals(Object)",
    "int ImmutableReportGridJSON.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder apiTypesResult =
        ImmutableReportGridJSON.builder().apiTypes(ImmutableApiTypes.builder().build());

    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();

    // Act and Assert
    assertNotEquals(
        apiTypesResult
            .grid(builderResult.columnDescriptors(new ArrayList<>()).build())
            .id("42")
            .name("Name")
            .type("Type")
            .build(),
        "Different type to ImmutableReportGridJSON");
  }

  /**
   * Test {@link ImmutableReportGridJSON#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ApiTypes} (default constructor).
   *   <li>Then return type is {@link ReportGridJSON#REPORT_GRID_TYPE}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridJSON#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ApiTypes (default constructor); then return type is REPORT_GRID_TYPE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridJSON ImmutableReportGridJSON.fromJson(Json)"})
  void testFromJson_givenApiTypes_thenReturnTypeIsReport_grid_type() {
    // Arrange
    Json json = new Json();
    ApiTypes apiTypes = new ApiTypes();
    json.setApiTypes(apiTypes);
    json.setType(null);
    json.setId("Json");
    json.setName("Json");
    ImmutableGrid.Json grid = new ImmutableGrid.Json();
    json.setGrid(grid);

    // Act
    ImmutableReportGridJSON actualFromJsonResult = ImmutableReportGridJSON.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.id());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals(ReportGridJSON.REPORT_GRID_TYPE, actualFromJsonResult.type());
    assertSame(apiTypes, actualFromJsonResult.apiTypes());
    assertSame(grid, actualFromJsonResult.grid());
  }

  /**
   * Test {@link ImmutableReportGridJSON#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ApiTypes} (default constructor).
   *   <li>When {@link Json} (default constructor) Type is {@code Json}.
   *   <li>Then return type is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridJSON#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ApiTypes (default constructor); when Json (default constructor) Type is 'Json'; then return type is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridJSON ImmutableReportGridJSON.fromJson(Json)"})
  void testFromJson_givenApiTypes_whenJsonTypeIsJson_thenReturnTypeIsJson() {
    // Arrange
    Json json = new Json();
    ApiTypes apiTypes = new ApiTypes();
    json.setApiTypes(apiTypes);
    json.setType("Json");
    json.setId("Json");
    json.setName("Json");
    ImmutableGrid.Json grid = new ImmutableGrid.Json();
    json.setGrid(grid);

    // Act
    ImmutableReportGridJSON actualFromJsonResult = ImmutableReportGridJSON.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.id());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.type());
    assertSame(apiTypes, actualFromJsonResult.apiTypes());
    assertSame(grid, actualFromJsonResult.grid());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridJSON#toString()}
   *   <li>{@link ImmutableReportGridJSON#apiTypes()}
   *   <li>{@link ImmutableReportGridJSON#grid()}
   *   <li>{@link ImmutableReportGridJSON#id()}
   *   <li>{@link ImmutableReportGridJSON#name()}
   *   <li>{@link ImmutableReportGridJSON#type()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApiTypes ImmutableReportGridJSON.apiTypes()",
    "Grid ImmutableReportGridJSON.grid()",
    "String ImmutableReportGridJSON.id()",
    "String ImmutableReportGridJSON.name()",
    "String ImmutableReportGridJSON.toString()",
    "String ImmutableReportGridJSON.type()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder apiTypesResult =
        ImmutableReportGridJSON.builder().apiTypes(ImmutableApiTypes.builder().build());

    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();
    ImmutableReportGridJSON immutableReportGridJSON =
        apiTypesResult
            .grid(builderResult.columnDescriptors(new ArrayList<>()).build())
            .id("42")
            .name("Name")
            .type("Type")
            .build();

    // Act
    String actualToStringResult = immutableReportGridJSON.toString();
    ApiTypes actualApiTypesResult = immutableReportGridJSON.apiTypes();
    Grid actualGridResult = immutableReportGridJSON.grid();
    String actualIdResult = immutableReportGridJSON.id();
    String actualNameResult = immutableReportGridJSON.name();

    // Assert
    assertTrue(actualApiTypesResult instanceof ImmutableApiTypes);
    assertTrue(actualGridResult instanceof ImmutableGrid);
    assertEquals("42", actualIdResult);
    assertEquals("Name", actualNameResult);
    assertEquals(
        "ReportGridJSON{apiTypes=ApiTypes{}, type=Type, id=42, name=Name, grid=Grid{columnDescriptors=[],"
            + " rows=[]}}",
        actualToStringResult);
    assertEquals("Type", immutableReportGridJSON.type());
  }

  /**
   * Test Json {@link Json#apiTypes()}.
   *
   * <p>Method under test: {@link Json#apiTypes()}
   */
  @Test
  @DisplayName("Test Json apiTypes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ApiTypes Json.apiTypes()"})
  void testJsonApiTypes() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().apiTypes());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setApiTypes(ApiTypes)}
   *   <li>{@link Json#setGrid(Grid)}
   *   <li>{@link Json#setId(String)}
   *   <li>{@link Json#setName(String)}
   *   <li>{@link Json#setType(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setApiTypes(ApiTypes)",
    "void Json.setGrid(Grid)",
    "void Json.setId(String)",
    "void Json.setName(String)",
    "void Json.setType(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setApiTypes(ImmutableApiTypes.builder().build());
    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();
    actualJson.setGrid(builderResult.columnDescriptors(new ArrayList<>()).build());
    actualJson.setId("42");
    actualJson.setName("Name");
    actualJson.setType("Type");

    // Assert
    ApiTypes apiTypes = actualJson.apiTypes;
    assertTrue(apiTypes instanceof ImmutableApiTypes);
    Grid grid = actualJson.grid;
    assertTrue(grid instanceof ImmutableGrid);
    Map<String, String> cellTypes = apiTypes.getCellTypes();
    assertEquals(2, cellTypes.size());
    assertEquals("/types/1/schema#id=CellValue", cellTypes.get(ApiTypes.VALCELL));
    assertEquals("/types/1/schema#id=KeyCell", cellTypes.get(ApiTypes.KEYCELL));
    assertEquals("42", actualJson.id);
    assertEquals("Name", actualJson.name);
    assertEquals("Type", actualJson.type);
    assertTrue(grid.rows().isEmpty());
  }

  /**
   * Test Json {@link Json#grid()}.
   *
   * <p>Method under test: {@link Json#grid()}
   */
  @Test
  @DisplayName("Test Json grid()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Grid Json.grid()"})
  void testJsonGrid() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().grid());
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
  }

  /**
   * Test Json {@link Json#type()}.
   *
   * <p>Method under test: {@link Json#type()}
   */
  @Test
  @DisplayName("Test Json type()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.type()"})
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().type());
  }

  /**
   * Test {@link ImmutableReportGridJSON#withApiTypes(ApiTypes)}.
   *
   * <p>Method under test: {@link ImmutableReportGridJSON#withApiTypes(ApiTypes)}
   */
  @Test
  @DisplayName("Test withApiTypes(ApiTypes)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridJSON ImmutableReportGridJSON.withApiTypes(ApiTypes)"})
  void testWithApiTypes() {
    // Arrange
    Builder apiTypesResult =
        ImmutableReportGridJSON.builder().apiTypes(ImmutableApiTypes.builder().build());

    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();
    ImmutableReportGridJSON immutableReportGridJSON =
        apiTypesResult
            .grid(builderResult.columnDescriptors(new ArrayList<>()).build())
            .id("42")
            .name("Name")
            .type("Type")
            .build();

    // Act
    ImmutableReportGridJSON actualWithApiTypesResult =
        immutableReportGridJSON.withApiTypes(ImmutableApiTypes.builder().build());

    // Assert
    assertEquals(immutableReportGridJSON, actualWithApiTypesResult);
  }

  /**
   * Test {@link ImmutableReportGridJSON#withGrid(Grid)}.
   *
   * <p>Method under test: {@link ImmutableReportGridJSON#withGrid(Grid)}
   */
  @Test
  @DisplayName("Test withGrid(Grid)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridJSON ImmutableReportGridJSON.withGrid(Grid)"})
  void testWithGrid() {
    // Arrange
    Builder apiTypesResult =
        ImmutableReportGridJSON.builder().apiTypes(ImmutableApiTypes.builder().build());

    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();
    ImmutableReportGridJSON immutableReportGridJSON =
        apiTypesResult
            .grid(builderResult.columnDescriptors(new ArrayList<>()).build())
            .id("42")
            .name("Name")
            .type("Type")
            .build();

    ImmutableGrid.Builder builderResult2 = ImmutableGrid.builder();

    // Act
    ImmutableReportGridJSON actualWithGridResult =
        immutableReportGridJSON.withGrid(
            builderResult2.columnDescriptors(new ArrayList<>()).build());

    // Assert
    assertEquals(immutableReportGridJSON, actualWithGridResult);
  }

  /**
   * Test {@link ImmutableReportGridJSON#withId(String)}.
   *
   * <p>Method under test: {@link ImmutableReportGridJSON#withId(String)}
   */
  @Test
  @DisplayName("Test withId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridJSON ImmutableReportGridJSON.withId(String)"})
  void testWithId() {
    // Arrange
    Builder apiTypesResult =
        ImmutableReportGridJSON.builder().apiTypes(ImmutableApiTypes.builder().build());

    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();
    ImmutableReportGridJSON immutableReportGridJSON =
        apiTypesResult
            .grid(builderResult.columnDescriptors(new ArrayList<>()).build())
            .id("42")
            .name("Name")
            .type("Type")
            .build();

    // Act
    ImmutableReportGridJSON actualWithIdResult = immutableReportGridJSON.withId("42");

    // Assert
    assertSame(immutableReportGridJSON, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableReportGridJSON#withId(String)}.
   *
   * <ul>
   *   <li>Then apiTypes return {@link ImmutableApiTypes}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridJSON#withId(String)}
   */
  @Test
  @DisplayName("Test withId(String); then apiTypes return ImmutableApiTypes")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridJSON ImmutableReportGridJSON.withId(String)"})
  void testWithId_thenApiTypesReturnImmutableApiTypes() {
    // Arrange
    Builder apiTypesResult =
        ImmutableReportGridJSON.builder().apiTypes(ImmutableApiTypes.builder().build());

    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();

    // Act
    ImmutableReportGridJSON actualWithIdResult =
        apiTypesResult
            .grid(builderResult.columnDescriptors(new ArrayList<>()).build())
            .id("id")
            .name("Name")
            .type("Type")
            .build()
            .withId("42");

    // Assert
    ApiTypes apiTypesResult2 = actualWithIdResult.apiTypes();
    assertTrue(apiTypesResult2 instanceof ImmutableApiTypes);
    Grid gridResult = actualWithIdResult.grid();
    assertTrue(gridResult instanceof ImmutableGrid);
    Map<String, String> cellTypes = apiTypesResult2.getCellTypes();
    assertEquals(2, cellTypes.size());
    assertEquals("/types/1/schema#id=CellValue", cellTypes.get(ApiTypes.VALCELL));
    assertEquals("/types/1/schema#id=KeyCell", cellTypes.get(ApiTypes.KEYCELL));
    assertEquals("42", actualWithIdResult.id());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Type", actualWithIdResult.type());
    assertTrue(gridResult.rows().isEmpty());
  }

  /**
   * Test {@link ImmutableReportGridJSON#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableReportGridJSON#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridJSON ImmutableReportGridJSON.withName(String)"})
  void testWithName() {
    // Arrange
    Builder apiTypesResult =
        ImmutableReportGridJSON.builder().apiTypes(ImmutableApiTypes.builder().build());

    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();
    ImmutableReportGridJSON immutableReportGridJSON =
        apiTypesResult
            .grid(builderResult.columnDescriptors(new ArrayList<>()).build())
            .id("42")
            .name("42")
            .type("Type")
            .build();

    // Act
    ImmutableReportGridJSON actualWithNameResult = immutableReportGridJSON.withName("42");

    // Assert
    assertSame(immutableReportGridJSON, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableReportGridJSON#withName(String)}.
   *
   * <ul>
   *   <li>Then apiTypes return {@link ImmutableApiTypes}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridJSON#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then apiTypes return ImmutableApiTypes")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridJSON ImmutableReportGridJSON.withName(String)"})
  void testWithName_thenApiTypesReturnImmutableApiTypes() {
    // Arrange
    Builder apiTypesResult =
        ImmutableReportGridJSON.builder().apiTypes(ImmutableApiTypes.builder().build());

    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();

    // Act
    ImmutableReportGridJSON actualWithNameResult =
        apiTypesResult
            .grid(builderResult.columnDescriptors(new ArrayList<>()).build())
            .id("42")
            .name("Name")
            .type("Type")
            .build()
            .withName("42");

    // Assert
    ApiTypes apiTypesResult2 = actualWithNameResult.apiTypes();
    assertTrue(apiTypesResult2 instanceof ImmutableApiTypes);
    Grid gridResult = actualWithNameResult.grid();
    assertTrue(gridResult instanceof ImmutableGrid);
    Map<String, String> cellTypes = apiTypesResult2.getCellTypes();
    assertEquals(2, cellTypes.size());
    assertEquals("/types/1/schema#id=CellValue", cellTypes.get(ApiTypes.VALCELL));
    assertEquals("/types/1/schema#id=KeyCell", cellTypes.get(ApiTypes.KEYCELL));
    assertEquals("42", actualWithNameResult.id());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Type", actualWithNameResult.type());
    assertTrue(gridResult.rows().isEmpty());
  }

  /**
   * Test {@link ImmutableReportGridJSON#withType(String)}.
   *
   * <p>Method under test: {@link ImmutableReportGridJSON#withType(String)}
   */
  @Test
  @DisplayName("Test withType(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridJSON ImmutableReportGridJSON.withType(String)"})
  void testWithType() {
    // Arrange
    Builder apiTypesResult =
        ImmutableReportGridJSON.builder().apiTypes(ImmutableApiTypes.builder().build());

    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();
    ImmutableReportGridJSON immutableReportGridJSON =
        apiTypesResult
            .grid(builderResult.columnDescriptors(new ArrayList<>()).build())
            .id("42")
            .name("Name")
            .type("42")
            .build();

    // Act
    ImmutableReportGridJSON actualWithTypeResult = immutableReportGridJSON.withType("42");

    // Assert
    assertSame(immutableReportGridJSON, actualWithTypeResult);
  }

  /**
   * Test {@link ImmutableReportGridJSON#withType(String)}.
   *
   * <ul>
   *   <li>Then apiTypes return {@link ImmutableApiTypes}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridJSON#withType(String)}
   */
  @Test
  @DisplayName("Test withType(String); then apiTypes return ImmutableApiTypes")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridJSON ImmutableReportGridJSON.withType(String)"})
  void testWithType_thenApiTypesReturnImmutableApiTypes() {
    // Arrange
    Builder apiTypesResult =
        ImmutableReportGridJSON.builder().apiTypes(ImmutableApiTypes.builder().build());

    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();

    // Act
    ImmutableReportGridJSON actualWithTypeResult =
        apiTypesResult
            .grid(builderResult.columnDescriptors(new ArrayList<>()).build())
            .id("42")
            .name("Name")
            .type("Type")
            .build()
            .withType("42");

    // Assert
    ApiTypes apiTypesResult2 = actualWithTypeResult.apiTypes();
    assertTrue(apiTypesResult2 instanceof ImmutableApiTypes);
    Grid gridResult = actualWithTypeResult.grid();
    assertTrue(gridResult instanceof ImmutableGrid);
    Map<String, String> cellTypes = apiTypesResult2.getCellTypes();
    assertEquals(2, cellTypes.size());
    assertEquals("/types/1/schema#id=CellValue", cellTypes.get(ApiTypes.VALCELL));
    assertEquals("/types/1/schema#id=KeyCell", cellTypes.get(ApiTypes.KEYCELL));
    assertEquals("42", actualWithTypeResult.id());
    assertEquals("42", actualWithTypeResult.type());
    assertEquals("Name", actualWithTypeResult.name());
    assertTrue(gridResult.rows().isEmpty());
  }
}
