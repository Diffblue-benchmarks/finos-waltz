package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.finos.waltz.web.json.ImmutableReportGridJSON.Builder;
import org.finos.waltz.web.json.ImmutableReportGridJSON.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridJSONDiffblueTest {
  /**
   * Test {@link ImmutableReportGridJSON#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableReportGridJSON#builder()}
   *   <li>{@link ImmutableReportGridJSON#type(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableReportGridJSON Builder.build()", "Builder Builder.type(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableReportGridJSON.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.type("Type"));
  }

  /**
   * Test Builder {@link Builder#apiTypes(ApiTypes)}.
   * <ul>
   *   <li>When {@link ApiTypes} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#apiTypes(ApiTypes)}
   */
  @Test
  @DisplayName("Test Builder apiTypes(ApiTypes); when ApiTypes (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.apiTypes(ApiTypes)"})
  void testBuilderApiTypes_whenApiTypes_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridJSON.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.apiTypes(new ApiTypes()));
  }

  /**
   * Test Builder {@link Builder#from(JsonAPI)} with {@code JsonAPI}.
   * <ul>
   *   <li>Given {@link ApiTypes} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(JsonAPI)}
   */
  @Test
  @DisplayName("Test Builder from(JsonAPI) with 'JsonAPI'; given ApiTypes (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(JsonAPI)"})
  void testBuilderFromWithJsonAPI_givenApiTypes_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridJSON.builder();
    JsonAPI instance = mock(JsonAPI.class);
    when(instance.apiTypes()).thenReturn(new ApiTypes());
    when(instance.type()).thenReturn("Type");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).apiTypes();
    verify(instance).type();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(JsonAPI)} with {@code JsonAPI}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(JsonAPI)}
   */
  @Test
  @DisplayName("Test Builder from(JsonAPI) with 'JsonAPI'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(JsonAPI)"})
  void testBuilderFromWithJsonAPI_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableReportGridJSON.builder();
    JsonAPI instance = mock(JsonAPI.class);
    when(instance.apiTypes()).thenThrow(new IllegalStateException("instance"));
    when(instance.type()).thenReturn("Type");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).apiTypes();
    verify(instance).type();
  }

  /**
   * Test Builder {@link Builder#from(ReportGridJSON)} with {@code ReportGridJSON}.
   * <ul>
   *   <li>Given {@link ApiTypes} (default constructor).</li>
   *   <li>Then builder build id is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridJSON)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridJSON) with 'ReportGridJSON'; given ApiTypes (default constructor); then builder build id is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridJSON)"})
  void testBuilderFromWithReportGridJSON_givenApiTypes_thenBuilderBuildIdIs42() {
    // Arrange
    Builder builderResult = ImmutableReportGridJSON.builder();
    ReportGridJSON instance = mock(ReportGridJSON.class);
    ApiTypes apiTypes = new ApiTypes();
    when(instance.apiTypes()).thenReturn(apiTypes);
    ImmutableGrid.Json json = new ImmutableGrid.Json();
    when(instance.grid()).thenReturn(json);
    when(instance.type()).thenReturn("Type");
    when(instance.id()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(ReportGridJSON)} with {@code ReportGridJSON}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridJSON)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridJSON) with 'ReportGridJSON'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridJSON)"})
  void testBuilderFromWithReportGridJSON_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableReportGridJSON.builder();
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
   * Test Builder {@link Builder#grid(Grid)}.
   * <ul>
   *   <li>When {@link ImmutableGrid.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#grid(Grid)}
   */
  @Test
  @DisplayName("Test Builder grid(Grid); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.grid(Grid)"})
  void testBuilderGrid_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridJSON.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.grid(new ImmutableGrid.Json()));
  }

  /**
   * Test Builder {@link Builder#id(String)}.
   * <p>
   * Method under test: {@link Builder#id(String)}
   */
  @Test
  @DisplayName("Test Builder id(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(String)"})
  void testBuilderId() {
    // Arrange
    Builder builderResult = ImmutableReportGridJSON.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id("42"));
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableReportGridJSON.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Json {@link Json#apiTypes()}.
   * <p>
   * Method under test: {@link Json#apiTypes()}
   */
  @Test
  @DisplayName("Test Json apiTypes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApiTypes Json.apiTypes()"})
  void testJsonApiTypes() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).apiTypes());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setApiTypes(ApiTypes)", "void Json.setGrid(Grid)",
      "void Json.setId(String)", "void Json.setName(String)", "void Json.setType(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
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
   * Test Json {@link Json#grid()}.
   * <p>
   * Method under test: {@link Json#grid()}
   */
  @Test
  @DisplayName("Test Json grid()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Grid Json.grid()"})
  void testJsonGrid() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).grid());
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
  }

  /**
   * Test Json {@link Json#type()}.
   * <p>
   * Method under test: {@link Json#type()}
   */
  @Test
  @DisplayName("Test Json type()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.type()"})
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).type());
  }
}
