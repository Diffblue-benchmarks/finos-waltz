package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ApiTypesDiffblueTest {
  /**
   * Test new {@link ApiTypes} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ApiTypes}
   */
  @Test
  @DisplayName("Test new ApiTypes (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiTypes.<init>()"})
  void testNewApiTypes() {
    // Arrange, Act and Assert
    Map<String, String> cellTypes = new ApiTypes().getCellTypes();
    assertEquals(2, cellTypes.size());
    assertEquals("/types/1/schema#id=CellValue", cellTypes.get(ApiTypes.VALCELL));
    assertEquals("/types/1/schema#id=KeyCell", cellTypes.get(ApiTypes.KEYCELL));
  }

  /**
   * Test {@link ApiTypes#getCellTypes()}.
   *
   * <p>Method under test: {@link ApiTypes#getCellTypes()}
   */
  @Test
  @DisplayName("Test getCellTypes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ApiTypes.getCellTypes()"})
  void testGetCellTypes() {
    // Arrange and Act
    Map<String, String> actualCellTypes = ImmutableApiTypes.builder().build().getCellTypes();

    // Assert
    assertEquals(2, actualCellTypes.size());
    assertEquals("/types/1/schema#id=CellValue", actualCellTypes.get(ApiTypes.VALCELL));
    assertEquals("/types/1/schema#id=KeyCell", actualCellTypes.get(ApiTypes.KEYCELL));
  }
}
