package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link ApiTypes} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ApiTypes)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ApiTypes); when ApiTypes (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApiTypes)"})
  void testBuilderFrom_whenApiTypes_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApiTypes.builder();

    // Act
    Builder actualFromResult = builderResult.from(new ApiTypes());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableApiTypes#copyOf(ApiTypes)}.
   *
   * <ul>
   *   <li>When {@link ApiTypes} (default constructor).
   *   <li>Then return CellTypes size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApiTypes#copyOf(ApiTypes)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ApiTypes); when ApiTypes (default constructor); then return CellTypes size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApiTypes ImmutableApiTypes.copyOf(ApiTypes)"})
  void testCopyOf_whenApiTypes_thenReturnCellTypesSizeIsTwo() {
    // Arrange and Act
    ImmutableApiTypes actualCopyOfResult = ImmutableApiTypes.copyOf(new ApiTypes());

    // Assert
    Map<String, String> cellTypes = actualCopyOfResult.getCellTypes();
    assertEquals(2, cellTypes.size());
    assertEquals("/types/1/schema#id=CellValue", cellTypes.get(ApiTypes.VALCELL));
    assertEquals("/types/1/schema#id=KeyCell", cellTypes.get(ApiTypes.KEYCELL));
  }

  /**
   * Test {@link ImmutableApiTypes#copyOf(ApiTypes)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return CellTypes size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApiTypes#copyOf(ApiTypes)}
   */
  @Test
  @DisplayName("Test copyOf(ApiTypes); when builder build; then return CellTypes size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApiTypes#equals(Object)}
   *   <li>{@link ImmutableApiTypes#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApiTypes.equals(Object)",
    "int ImmutableApiTypes.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableApiTypes immutableApiTypes = ImmutableApiTypes.builder().build();
    ImmutableApiTypes immutableApiTypes2 = ImmutableApiTypes.builder().build();

    // Act and Assert
    assertEquals(immutableApiTypes, immutableApiTypes2);
    assertEquals(immutableApiTypes.hashCode(), immutableApiTypes2.hashCode());
  }

  /**
   * Test {@link ImmutableApiTypes#equals(Object)}, and {@link ImmutableApiTypes#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApiTypes#equals(Object)}
   *   <li>{@link ImmutableApiTypes#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApiTypes.equals(Object)",
    "int ImmutableApiTypes.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableApiTypes immutableApiTypes = ImmutableApiTypes.builder().build();

    // Act and Assert
    assertEquals(immutableApiTypes, immutableApiTypes);
    int expectedHashCodeResult = immutableApiTypes.hashCode();
    assertEquals(expectedHashCodeResult, immutableApiTypes.hashCode());
  }

  /**
   * Test {@link ImmutableApiTypes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApiTypes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApiTypes.equals(Object)",
    "int ImmutableApiTypes.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableApiTypes.builder().build(), null);
  }

  /**
   * Test {@link ImmutableApiTypes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApiTypes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApiTypes.equals(Object)",
    "int ImmutableApiTypes.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableApiTypes.builder().build(), "Different type to ImmutableApiTypes");
  }

  /**
   * Test {@link ImmutableApiTypes#fromJson(Json)}.
   *
   * <p>Method under test: {@link ImmutableApiTypes#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApiTypes ImmutableApiTypes.fromJson(Json)"})
  void testFromJson() {
    // Arrange and Act
    ImmutableApiTypes actualFromJsonResult = ImmutableApiTypes.fromJson(new Json());

    // Assert
    Map<String, String> cellTypes = actualFromJsonResult.getCellTypes();
    assertEquals(2, cellTypes.size());
    assertEquals("/types/1/schema#id=CellValue", cellTypes.get(ApiTypes.VALCELL));
    assertEquals("/types/1/schema#id=KeyCell", cellTypes.get(ApiTypes.KEYCELL));
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
    // Arrange, Act and Assert
    Map<String, String> cellTypes = new Json().getCellTypes();
    assertEquals(2, cellTypes.size());
    assertEquals("/types/1/schema#id=CellValue", cellTypes.get(ApiTypes.VALCELL));
    assertEquals("/types/1/schema#id=KeyCell", cellTypes.get(ApiTypes.KEYCELL));
  }

  /**
   * Test {@link ImmutableApiTypes#toString()}.
   *
   * <p>Method under test: {@link ImmutableApiTypes#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableApiTypes.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("ApiTypes{}", ImmutableApiTypes.builder().build().toString());
  }
}
