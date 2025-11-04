package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ApiTypesDiffblueTest {
  /**
   * Method under test: {@link ApiTypes#getCellTypes()}
   */
  @Test
  void testGetCellTypes() {
    // Arrange and Act
    Map<String, String> actualCellTypes = (new ApiTypes()).getCellTypes();

    // Assert
    assertEquals(2, actualCellTypes.size());
    assertEquals("/types/1/schema#id=CellValue", actualCellTypes.get(ApiTypes.VALCELL));
    assertEquals("/types/1/schema#id=KeyCell", actualCellTypes.get(ApiTypes.KEYCELL));
  }

  /**
   * Method under test: default or parameterless constructor of {@link ApiTypes}
   */
  @Test
  void testNewApiTypes() {
    // Arrange, Act and Assert
    Map<String, String> cellTypes = (new ApiTypes()).getCellTypes();
    assertEquals(2, cellTypes.size());
    assertEquals("/types/1/schema#id=CellValue", cellTypes.get(ApiTypes.VALCELL));
    assertEquals("/types/1/schema#id=KeyCell", cellTypes.get(ApiTypes.KEYCELL));
  }
}
