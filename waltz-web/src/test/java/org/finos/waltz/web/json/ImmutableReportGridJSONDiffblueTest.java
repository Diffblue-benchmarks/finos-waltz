package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ImmutableReportGridJSONDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableReportGridJSON#builder()}
   *   <li>{@link ImmutableReportGridJSON#type(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableReportGridJSON.Builder actualBuilderResult = ImmutableReportGridJSON.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.type("Type"));
  }

  /**
   * Method under test: {@link ImmutableReportGridJSON.Builder#apiTypes(ApiTypes)}
   */
  @Test
  void testBuilderApiTypes() {
    // Arrange
    ImmutableReportGridJSON.Builder builderResult = ImmutableReportGridJSON.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.apiTypes(new ApiTypes()));
  }

  /**
   * Method under test: {@link ImmutableReportGridJSON.Builder#from(JsonAPI)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableReportGridJSON.Builder builderResult = ImmutableReportGridJSON.builder();
    JsonAPI instance = mock(JsonAPI.class);
    when(instance.apiTypes()).thenReturn(new ApiTypes());
    when(instance.type()).thenReturn("Type");

    // Act
    ImmutableReportGridJSON.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).apiTypes();
    verify(instance).type();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableReportGridJSON.Builder#from(JsonAPI)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableReportGridJSON.Builder builderResult = ImmutableReportGridJSON.builder();
    JsonAPI instance = mock(JsonAPI.class);
    when(instance.apiTypes()).thenThrow(new IllegalStateException("instance"));
    when(instance.type()).thenReturn("Type");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).apiTypes();
    verify(instance).type();
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridJSON.Builder#from(ReportGridJSON)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableReportGridJSON.Builder builderResult = ImmutableReportGridJSON.builder();
    ReportGridJSON instance = mock(ReportGridJSON.class);
    ApiTypes apiTypes = new ApiTypes();
    when(instance.apiTypes()).thenReturn(apiTypes);
    ImmutableGrid.Json json = new ImmutableGrid.Json();
    when(instance.grid()).thenReturn(json);
    when(instance.type()).thenReturn("Type");
    when(instance.id()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridJSON.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).apiTypes();
    verify(instance).grid();
    verify(instance).id();
    verify(instance).name();
    verify(instance).type();
    ImmutableReportGridJSON buildResult = builderResult.build();
    assertEquals("42", buildResult.id());
    assertEquals("Name", buildResult.name());
    assertEquals("Type", buildResult.type());
    assertSame(apiTypes, buildResult.apiTypes());
    assertSame(json, buildResult.grid());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridJSON.Builder#from(ReportGridJSON)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableReportGridJSON.Builder builderResult = ImmutableReportGridJSON.builder();
    ReportGridJSON instance = mock(ReportGridJSON.class);
    when(instance.apiTypes()).thenThrow(new IllegalStateException("instance"));
    when(instance.grid()).thenReturn(new ImmutableGrid.Json());
    when(instance.type()).thenReturn("Type");
    when(instance.id()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).apiTypes();
    verify(instance).grid();
    verify(instance).id();
    verify(instance).name();
    verify(instance).type();
  }

  /**
   * Method under test: {@link ImmutableReportGridJSON.Builder#grid(Grid)}
   */
  @Test
  void testBuilderGrid() {
    // Arrange
    ImmutableReportGridJSON.Builder builderResult = ImmutableReportGridJSON.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.grid(new ImmutableGrid.Json()));
  }

  /**
   * Method under test: {@link ImmutableReportGridJSON.Builder#id(String)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableReportGridJSON.Builder builderResult = ImmutableReportGridJSON.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id("42"));
  }

  /**
   * Method under test: {@link ImmutableReportGridJSON.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableReportGridJSON.Builder builderResult = ImmutableReportGridJSON.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableReportGridJSON#copyOf(ReportGridJSON)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ReportGridJSON instance = mock(ReportGridJSON.class);
    ApiTypes apiTypes = new ApiTypes();
    when(instance.apiTypes()).thenReturn(apiTypes);
    ImmutableGrid.Json json = new ImmutableGrid.Json();
    when(instance.grid()).thenReturn(json);
    when(instance.type()).thenReturn("Type");
    when(instance.id()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridJSON actualCopyOfResult = ImmutableReportGridJSON.copyOf(instance);

    // Assert
    verify(instance).apiTypes();
    verify(instance).grid();
    verify(instance).id();
    verify(instance).name();
    verify(instance).type();
    assertEquals("42", actualCopyOfResult.id());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Type", actualCopyOfResult.type());
    assertSame(apiTypes, actualCopyOfResult.apiTypes());
    assertSame(json, actualCopyOfResult.grid());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridJSON#fromJson(ImmutableReportGridJSON.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableReportGridJSON.Json json = new ImmutableReportGridJSON.Json();
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
   * Method under test:
   * {@link ImmutableReportGridJSON#fromJson(ImmutableReportGridJSON.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableReportGridJSON.Json json = new ImmutableReportGridJSON.Json();
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
   * Method under test: {@link ImmutableReportGridJSON.Json#apiTypes()}
   */
  @Test
  void testJsonApiTypes() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridJSON.Json()).apiTypes());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableReportGridJSON.Json}
   *   <li>{@link ImmutableReportGridJSON.Json#setApiTypes(ApiTypes)}
   *   <li>{@link ImmutableReportGridJSON.Json#setGrid(Grid)}
   *   <li>{@link ImmutableReportGridJSON.Json#setId(String)}
   *   <li>{@link ImmutableReportGridJSON.Json#setName(String)}
   *   <li>{@link ImmutableReportGridJSON.Json#setType(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableReportGridJSON.Json actualJson = new ImmutableReportGridJSON.Json();
    actualJson.setApiTypes(new ApiTypes());
    actualJson.setGrid(new ImmutableGrid.Json());
    actualJson.setId("42");
    actualJson.setName("Name");
    actualJson.setType("Type");

    // Assert
    Map<String, String> cellTypes = actualJson.apiTypes.getCellTypes();
    assertEquals(2, cellTypes.size());
    assertEquals("/types/1/schema#id=CellValue", cellTypes.get(ApiTypes.VALCELL));
    assertEquals("/types/1/schema#id=KeyCell", cellTypes.get(ApiTypes.KEYCELL));
    assertFalse(((ImmutableGrid.Json) actualJson.grid).columnDescriptors.isPresent());
    assertTrue(((ImmutableGrid.Json) actualJson.grid).rows.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableReportGridJSON.Json#grid()}
   */
  @Test
  void testJsonGrid() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridJSON.Json()).grid());
  }

  /**
   * Method under test: {@link ImmutableReportGridJSON.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridJSON.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableReportGridJSON.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridJSON.Json()).name());
  }

  /**
   * Method under test: {@link ImmutableReportGridJSON.Json#type()}
   */
  @Test
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridJSON.Json()).type());
  }
}
