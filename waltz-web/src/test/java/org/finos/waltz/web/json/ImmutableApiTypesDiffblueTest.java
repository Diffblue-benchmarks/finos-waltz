package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ImmutableApiTypesDiffblueTest {
  /**
   * Method under test: {@link ImmutableApiTypes.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    Map<String, String> cellTypes = ImmutableApiTypes.builder().build().getCellTypes();
    assertEquals(2, cellTypes.size());
    assertEquals("/types/1/schema#id=CellValue", cellTypes.get(ApiTypes.VALCELL));
    assertEquals("/types/1/schema#id=KeyCell", cellTypes.get(ApiTypes.KEYCELL));
  }

  /**
   * Method under test: {@link ImmutableApiTypes.Builder#from(ApiTypes)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableApiTypes.Builder builderResult = ImmutableApiTypes.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.from(new ApiTypes()));
  }

  /**
   * Method under test: {@link ImmutableApiTypes#copyOf(ApiTypes)}
   */
  @Test
  void testCopyOf() {
    // Arrange, Act and Assert
    Map<String, String> cellTypes = ImmutableApiTypes.copyOf(new ApiTypes()).getCellTypes();
    assertEquals(2, cellTypes.size());
    assertEquals("/types/1/schema#id=CellValue", cellTypes.get(ApiTypes.VALCELL));
    assertEquals("/types/1/schema#id=KeyCell", cellTypes.get(ApiTypes.KEYCELL));
  }

  /**
   * Method under test: {@link ImmutableApiTypes#fromJson(ImmutableApiTypes.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange, Act and Assert
    Map<String, String> cellTypes = ImmutableApiTypes.fromJson(new ImmutableApiTypes.Json()).getCellTypes();
    assertEquals(2, cellTypes.size());
    assertEquals("/types/1/schema#id=CellValue", cellTypes.get(ApiTypes.VALCELL));
    assertEquals("/types/1/schema#id=KeyCell", cellTypes.get(ApiTypes.KEYCELL));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableApiTypes.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange, Act and Assert
    Map<String, String> cellTypes = (new ImmutableApiTypes.Json()).getCellTypes();
    assertEquals(2, cellTypes.size());
    assertEquals("/types/1/schema#id=CellValue", cellTypes.get(ApiTypes.VALCELL));
    assertEquals("/types/1/schema#id=KeyCell", cellTypes.get(ApiTypes.KEYCELL));
  }
}
