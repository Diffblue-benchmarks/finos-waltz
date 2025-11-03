package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.finos.waltz.web.json.ImmutableApiTypes.Builder;
import org.finos.waltz.web.json.ImmutableApiTypes.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableApiTypesDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableApiTypes Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    Map<String, String> cellTypes = ImmutableApiTypes.builder().build().getCellTypes();
    assertEquals(2, cellTypes.size());
    assertEquals("/types/1/schema#id=CellValue", cellTypes.get(ApiTypes.VALCELL));
    assertEquals("/types/1/schema#id=KeyCell", cellTypes.get(ApiTypes.KEYCELL));
  }

  /**
   * Test Builder {@link Builder#from(ApiTypes)}.
   * <ul>
   *   <li>When {@link ApiTypes} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApiTypes)}
   */
  @Test
  @DisplayName("Test Builder from(ApiTypes); when ApiTypes (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApiTypes)"})
  void testBuilderFrom_whenApiTypes_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApiTypes.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.from(new ApiTypes()));
  }

  /**
   * Test {@link ImmutableApiTypes#copyOf(ApiTypes)}.
   * <ul>
   *   <li>When {@link ApiTypes} (default constructor).</li>
   *   <li>Then return CellTypes size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableApiTypes#copyOf(ApiTypes)}
   */
  @Test
  @DisplayName("Test copyOf(ApiTypes); when ApiTypes (default constructor); then return CellTypes size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableApiTypes ImmutableApiTypes.copyOf(ApiTypes)"})
  void testCopyOf_whenApiTypes_thenReturnCellTypesSizeIsTwo() {
    // Arrange, Act and Assert
    Map<String, String> cellTypes = ImmutableApiTypes.copyOf(new ApiTypes()).getCellTypes();
    assertEquals(2, cellTypes.size());
    assertEquals("/types/1/schema#id=CellValue", cellTypes.get(ApiTypes.VALCELL));
    assertEquals("/types/1/schema#id=KeyCell", cellTypes.get(ApiTypes.KEYCELL));
  }

  /**
   * Test {@link ImmutableApiTypes#copyOf(ApiTypes)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return CellTypes size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableApiTypes#copyOf(ApiTypes)}
   */
  @Test
  @DisplayName("Test copyOf(ApiTypes); when builder build; then return CellTypes size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableApiTypes ImmutableApiTypes.copyOf(ApiTypes)"})
  void testCopyOf_whenBuilderBuild_thenReturnCellTypesSizeIsTwo() {
    // Arrange
    ImmutableApiTypes instance = ImmutableApiTypes.builder().build();

    // Act and Assert
    Map<String, String> cellTypes = ImmutableApiTypes.copyOf(instance).getCellTypes();
    assertEquals(2, cellTypes.size());
    assertEquals("/types/1/schema#id=CellValue", cellTypes.get(ApiTypes.VALCELL));
    assertEquals("/types/1/schema#id=KeyCell", cellTypes.get(ApiTypes.KEYCELL));
  }

  /**
   * Test {@link ImmutableApiTypes#equals(Object)}, and {@link ImmutableApiTypes#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableApiTypes#equals(Object)}
   *   <li>{@link ImmutableApiTypes#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableApiTypes.equals(Object)", "int ImmutableApiTypes.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableApiTypes buildResult = ImmutableApiTypes.builder().build();
    ImmutableApiTypes buildResult2 = ImmutableApiTypes.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableApiTypes#equals(Object)}, and {@link ImmutableApiTypes#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableApiTypes#equals(Object)}
   *   <li>{@link ImmutableApiTypes#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableApiTypes.equals(Object)", "int ImmutableApiTypes.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableApiTypes buildResult = ImmutableApiTypes.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableApiTypes#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableApiTypes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableApiTypes.equals(Object)", "int ImmutableApiTypes.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableApiTypes buildResult = ImmutableApiTypes.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableApiTypes#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableApiTypes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableApiTypes.equals(Object)", "int ImmutableApiTypes.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableApiTypes buildResult = ImmutableApiTypes.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableApiTypes");
  }

  /**
   * Test {@link ImmutableApiTypes#fromJson(Json)}.
   * <p>
   * Method under test: {@link ImmutableApiTypes#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableApiTypes ImmutableApiTypes.fromJson(Json)"})
  void testFromJson() {
    // Arrange, Act and Assert
    Map<String, String> cellTypes = ImmutableApiTypes.fromJson(new Json()).getCellTypes();
    assertEquals(2, cellTypes.size());
    assertEquals("/types/1/schema#id=CellValue", cellTypes.get(ApiTypes.VALCELL));
    assertEquals("/types/1/schema#id=KeyCell", cellTypes.get(ApiTypes.KEYCELL));
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
    // Arrange, Act and Assert
    Map<String, String> cellTypes = (new Json()).getCellTypes();
    assertEquals(2, cellTypes.size());
    assertEquals("/types/1/schema#id=CellValue", cellTypes.get(ApiTypes.VALCELL));
    assertEquals("/types/1/schema#id=KeyCell", cellTypes.get(ApiTypes.KEYCELL));
  }

  /**
   * Test {@link ImmutableApiTypes#toString()}.
   * <p>
   * Method under test: {@link ImmutableApiTypes#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ImmutableApiTypes.toString()"})
  void testToString() {
    // Arrange
    ImmutableApiTypes buildResult = ImmutableApiTypes.builder().build();

    // Act and Assert
    assertEquals("ApiTypes{}", buildResult.toString());
  }
}
