package org.finos.waltz.model.software_catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.software_catalog.ImmutableSoftwareSummaryStatistics.Builder;
import org.finos.waltz.model.software_catalog.ImmutableSoftwareSummaryStatistics.Json;
import org.finos.waltz.model.tally.Tally;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSoftwareSummaryStatisticsDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllGroupCounts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllGroupCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllGroupCounts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllGroupCounts(Iterable)"})
  void testBuilderAddAllGroupCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllGroupCounts(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllNameCounts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllNameCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllNameCounts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllNameCounts(Iterable)"})
  void testBuilderAddAllNameCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllNameCounts(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllVendorCounts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllVendorCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllVendorCounts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllVendorCounts(Iterable)"})
  void testBuilderAddAllVendorCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllVendorCounts(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addGroupCounts(Tally)} with {@code element}.
   * <ul>
   *   <li>Then builder build groupCounts size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addGroupCounts(Tally)}
   */
  @Test
  @DisplayName("Test Builder addGroupCounts(Tally) with 'element'; then builder build groupCounts size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addGroupCounts(Tally)"})
  void testBuilderAddGroupCountsWithElement_thenBuilderBuildGroupCountsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();
    Tally<String> element = mock(Tally.class);

    // Act
    Builder actualAddGroupCountsResult = builderResult.addGroupCounts(element);

    // Assert
    List<Tally<String>> groupCountsResult = builderResult.build().groupCounts();
    assertEquals(1, groupCountsResult.size());
    assertSame(builderResult, actualAddGroupCountsResult);
    assertSame(element, groupCountsResult.get(0));
  }

  /**
   * Test Builder {@link Builder#addGroupCounts(Tally[])} with {@code elements}.
   * <ul>
   *   <li>Then builder build groupCounts size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addGroupCounts(Tally[])}
   */
  @Test
  @DisplayName("Test Builder addGroupCounts(Tally[]) with 'elements'; then builder build groupCounts size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addGroupCounts(Tally[])"})
  void testBuilderAddGroupCountsWithElements_thenBuilderBuildGroupCountsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    // Act
    Builder actualAddGroupCountsResult = builderResult.addGroupCounts(mock(Tally.class));

    // Assert
    assertEquals(1, builderResult.build().groupCounts().size());
    assertSame(builderResult, actualAddGroupCountsResult);
  }

  /**
   * Test Builder {@link Builder#addNameCounts(Tally)} with {@code element}.
   * <ul>
   *   <li>Then builder build nameCounts size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addNameCounts(Tally)}
   */
  @Test
  @DisplayName("Test Builder addNameCounts(Tally) with 'element'; then builder build nameCounts size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addNameCounts(Tally)"})
  void testBuilderAddNameCountsWithElement_thenBuilderBuildNameCountsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();
    Tally<String> element = mock(Tally.class);

    // Act
    Builder actualAddNameCountsResult = builderResult.addNameCounts(element);

    // Assert
    List<Tally<String>> nameCountsResult = builderResult.build().nameCounts();
    assertEquals(1, nameCountsResult.size());
    assertSame(builderResult, actualAddNameCountsResult);
    assertSame(element, nameCountsResult.get(0));
  }

  /**
   * Test Builder {@link Builder#addNameCounts(Tally[])} with {@code elements}.
   * <ul>
   *   <li>Then builder build nameCounts size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addNameCounts(Tally[])}
   */
  @Test
  @DisplayName("Test Builder addNameCounts(Tally[]) with 'elements'; then builder build nameCounts size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addNameCounts(Tally[])"})
  void testBuilderAddNameCountsWithElements_thenBuilderBuildNameCountsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    // Act
    Builder actualAddNameCountsResult = builderResult.addNameCounts(mock(Tally.class));

    // Assert
    assertEquals(1, builderResult.build().nameCounts().size());
    assertSame(builderResult, actualAddNameCountsResult);
  }

  /**
   * Test Builder {@link Builder#addVendorCounts(Tally)} with {@code element}.
   * <ul>
   *   <li>Then builder build vendorCounts size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addVendorCounts(Tally)}
   */
  @Test
  @DisplayName("Test Builder addVendorCounts(Tally) with 'element'; then builder build vendorCounts size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addVendorCounts(Tally)"})
  void testBuilderAddVendorCountsWithElement_thenBuilderBuildVendorCountsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();
    Tally<String> element = mock(Tally.class);

    // Act
    Builder actualAddVendorCountsResult = builderResult.addVendorCounts(element);

    // Assert
    List<Tally<String>> vendorCountsResult = builderResult.build().vendorCounts();
    assertEquals(1, vendorCountsResult.size());
    assertSame(builderResult, actualAddVendorCountsResult);
    assertSame(element, vendorCountsResult.get(0));
  }

  /**
   * Test Builder {@link Builder#addVendorCounts(Tally[])} with {@code elements}.
   * <ul>
   *   <li>Then builder build vendorCounts size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addVendorCounts(Tally[])}
   */
  @Test
  @DisplayName("Test Builder addVendorCounts(Tally[]) with 'elements'; then builder build vendorCounts size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addVendorCounts(Tally[])"})
  void testBuilderAddVendorCountsWithElements_thenBuilderBuildVendorCountsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    // Act
    Builder actualAddVendorCountsResult = builderResult.addVendorCounts(mock(Tally.class));

    // Assert
    assertEquals(1, builderResult.build().vendorCounts().size());
    assertSame(builderResult, actualAddVendorCountsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSoftwareSummaryStatistics Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableSoftwareSummaryStatistics.builder().build().groupCounts().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(SoftwareSummaryStatistics)}.
   * <ul>
   *   <li>Then return build groupCounts size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SoftwareSummaryStatistics)}
   */
  @Test
  @DisplayName("Test Builder from(SoftwareSummaryStatistics); then return build groupCounts size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SoftwareSummaryStatistics)"})
  void testBuilderFrom_thenReturnBuildGroupCountsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();
    Builder builderResult2 = ImmutableSoftwareSummaryStatistics.builder();
    builderResult2.addGroupCounts(mock(Tally.class));
    builderResult2.addVendorCounts(mock(Tally.class));
    ImmutableSoftwareSummaryStatistics instance = builderResult2.build();

    // Act and Assert
    ImmutableSoftwareSummaryStatistics buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.groupCounts().size());
    assertEquals(1, buildResult.vendorCounts().size());
    assertTrue(buildResult.nameCounts().isEmpty());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(SoftwareSummaryStatistics)}.
   * <ul>
   *   <li>Then return build nameCounts is build groupCounts.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SoftwareSummaryStatistics)}
   */
  @Test
  @DisplayName("Test Builder from(SoftwareSummaryStatistics); then return build nameCounts is build groupCounts")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SoftwareSummaryStatistics)"})
  void testBuilderFrom_thenReturnBuildNameCountsIsBuildGroupCounts() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();
    Builder builderResult2 = ImmutableSoftwareSummaryStatistics.builder();
    builderResult2.addVendorCounts(mock(Tally.class));
    ImmutableSoftwareSummaryStatistics instance = builderResult2.build();

    // Act and Assert
    ImmutableSoftwareSummaryStatistics buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.vendorCounts().size());
    List<Tally<String>> groupCountsResult = buildResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertEquals(instance, builderResult.build());
    assertSame(groupCountsResult, buildResult.nameCounts());
  }

  /**
   * Test Builder {@link Builder#from(SoftwareSummaryStatistics)}.
   * <ul>
   *   <li>When builder addNameCounts {@link Tally}.</li>
   *   <li>Then return build nameCounts size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SoftwareSummaryStatistics)}
   */
  @Test
  @DisplayName("Test Builder from(SoftwareSummaryStatistics); when builder addNameCounts Tally; then return build nameCounts size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SoftwareSummaryStatistics)"})
  void testBuilderFrom_whenBuilderAddNameCountsTally_thenReturnBuildNameCountsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();
    Builder builderResult2 = ImmutableSoftwareSummaryStatistics.builder();
    builderResult2.addNameCounts(mock(Tally.class));
    builderResult2.addVendorCounts(mock(Tally.class));
    ImmutableSoftwareSummaryStatistics instance = builderResult2.build();

    // Act and Assert
    ImmutableSoftwareSummaryStatistics buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.nameCounts().size());
    assertEquals(1, buildResult.vendorCounts().size());
    assertTrue(buildResult.groupCounts().isEmpty());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(SoftwareSummaryStatistics)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return build vendorCounts is build groupCounts.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SoftwareSummaryStatistics)}
   */
  @Test
  @DisplayName("Test Builder from(SoftwareSummaryStatistics); when builder build; then return build vendorCounts is build groupCounts")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SoftwareSummaryStatistics)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuildVendorCountsIsBuildGroupCounts() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();
    ImmutableSoftwareSummaryStatistics instance = ImmutableSoftwareSummaryStatistics.builder().build();

    // Act and Assert
    ImmutableSoftwareSummaryStatistics buildResult = builderResult.from(instance).build();
    List<Tally<String>> groupCountsResult = buildResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertEquals(instance, builderResult.build());
    assertSame(groupCountsResult, buildResult.nameCounts());
    assertSame(groupCountsResult, buildResult.vendorCounts());
  }

  /**
   * Test Builder {@link Builder#groupCounts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#groupCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder groupCounts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.groupCounts(Iterable)"})
  void testBuilderGroupCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.groupCounts(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#nameCounts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#nameCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder nameCounts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.nameCounts(Iterable)"})
  void testBuilderNameCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.nameCounts(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#vendorCounts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#vendorCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder vendorCounts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.vendorCounts(Iterable)"})
  void testBuilderVendorCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.vendorCounts(new ArrayList<>()));
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#copyOf(SoftwareSummaryStatistics)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return groupCounts Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareSummaryStatistics#copyOf(SoftwareSummaryStatistics)}
   */
  @Test
  @DisplayName("Test copyOf(SoftwareSummaryStatistics); when builder build; then return groupCounts Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableSoftwareSummaryStatistics ImmutableSoftwareSummaryStatistics.copyOf(SoftwareSummaryStatistics)"})
  void testCopyOf_whenBuilderBuild_thenReturnGroupCountsEmpty() {
    // Arrange
    ImmutableSoftwareSummaryStatistics instance = ImmutableSoftwareSummaryStatistics.builder().build();

    // Act
    ImmutableSoftwareSummaryStatistics actualCopyOfResult = ImmutableSoftwareSummaryStatistics.copyOf(instance);

    // Assert
    List<Tally<String>> groupCountsResult = actualCopyOfResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertSame(groupCountsResult, actualCopyOfResult.nameCounts());
    assertSame(groupCountsResult, actualCopyOfResult.vendorCounts());
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#equals(Object)}, and {@link ImmutableSoftwareSummaryStatistics#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSoftwareSummaryStatistics#equals(Object)}
   *   <li>{@link ImmutableSoftwareSummaryStatistics#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSoftwareSummaryStatistics.equals(Object)",
      "int ImmutableSoftwareSummaryStatistics.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSoftwareSummaryStatistics buildResult = ImmutableSoftwareSummaryStatistics.builder().build();
    ImmutableSoftwareSummaryStatistics buildResult2 = ImmutableSoftwareSummaryStatistics.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#equals(Object)}, and {@link ImmutableSoftwareSummaryStatistics#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSoftwareSummaryStatistics#equals(Object)}
   *   <li>{@link ImmutableSoftwareSummaryStatistics#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSoftwareSummaryStatistics.equals(Object)",
      "int ImmutableSoftwareSummaryStatistics.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSoftwareSummaryStatistics buildResult = ImmutableSoftwareSummaryStatistics.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareSummaryStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSoftwareSummaryStatistics.equals(Object)",
      "int ImmutableSoftwareSummaryStatistics.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();
    builderResult.addVendorCounts(mock(Tally.class));
    ImmutableSoftwareSummaryStatistics buildResult = builderResult.build();
    ImmutableSoftwareSummaryStatistics buildResult2 = ImmutableSoftwareSummaryStatistics.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareSummaryStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSoftwareSummaryStatistics.equals(Object)",
      "int ImmutableSoftwareSummaryStatistics.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();
    builderResult.addGroupCounts(mock(Tally.class));
    ImmutableSoftwareSummaryStatistics buildResult = builderResult.build();
    ImmutableSoftwareSummaryStatistics buildResult2 = ImmutableSoftwareSummaryStatistics.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareSummaryStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSoftwareSummaryStatistics.equals(Object)",
      "int ImmutableSoftwareSummaryStatistics.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();
    builderResult.addNameCounts(mock(Tally.class));
    ImmutableSoftwareSummaryStatistics buildResult = builderResult.build();
    ImmutableSoftwareSummaryStatistics buildResult2 = ImmutableSoftwareSummaryStatistics.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareSummaryStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSoftwareSummaryStatistics.equals(Object)",
      "int ImmutableSoftwareSummaryStatistics.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableSoftwareSummaryStatistics buildResult = ImmutableSoftwareSummaryStatistics.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareSummaryStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSoftwareSummaryStatistics.equals(Object)",
      "int ImmutableSoftwareSummaryStatistics.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableSoftwareSummaryStatistics buildResult = ImmutableSoftwareSummaryStatistics.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableSoftwareSummaryStatistics");
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Json} (default constructor) VendorCounts is {@code null}.</li>
   *   <li>Then return groupCounts Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareSummaryStatistics#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) VendorCounts is 'null'; then return groupCounts Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSoftwareSummaryStatistics ImmutableSoftwareSummaryStatistics.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonVendorCountsIsNull_thenReturnGroupCountsEmpty() {
    // Arrange
    Json json = new Json();
    json.setVendorCounts(null);
    json.setGroupCounts(null);
    json.setNameCounts(null);

    // Act
    ImmutableSoftwareSummaryStatistics actualFromJsonResult = ImmutableSoftwareSummaryStatistics.fromJson(json);

    // Assert
    List<Tally<String>> groupCountsResult = actualFromJsonResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertSame(groupCountsResult, actualFromJsonResult.nameCounts());
    assertSame(groupCountsResult, actualFromJsonResult.vendorCounts());
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor) GroupCounts is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return groupCounts size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareSummaryStatistics#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor) GroupCounts is ArrayList(); then return groupCounts size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSoftwareSummaryStatistics ImmutableSoftwareSummaryStatistics.fromJson(Json)"})
  void testFromJson_whenJsonGroupCountsIsArrayList_thenReturnGroupCountsSizeIsOne() {
    // Arrange
    ArrayList<Tally<String>> groupCounts = new ArrayList<>();
    groupCounts.add(mock(Tally.class));

    Json json = new Json();
    json.setVendorCounts(null);
    json.setGroupCounts(groupCounts);
    json.setNameCounts(null);

    // Act
    ImmutableSoftwareSummaryStatistics actualFromJsonResult = ImmutableSoftwareSummaryStatistics.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.groupCounts().size());
    List<Tally<String>> nameCountsResult = actualFromJsonResult.nameCounts();
    assertTrue(nameCountsResult.isEmpty());
    assertSame(nameCountsResult, actualFromJsonResult.vendorCounts());
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor) NameCounts is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return nameCounts size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareSummaryStatistics#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor) NameCounts is ArrayList(); then return nameCounts size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSoftwareSummaryStatistics ImmutableSoftwareSummaryStatistics.fromJson(Json)"})
  void testFromJson_whenJsonNameCountsIsArrayList_thenReturnNameCountsSizeIsOne() {
    // Arrange
    ArrayList<Tally<String>> nameCounts = new ArrayList<>();
    nameCounts.add(mock(Tally.class));

    Json json = new Json();
    json.setVendorCounts(null);
    json.setGroupCounts(null);
    json.setNameCounts(nameCounts);

    // Act and Assert
    assertEquals(1, ImmutableSoftwareSummaryStatistics.fromJson(json).nameCounts().size());
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor) VendorCounts is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return vendorCounts size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareSummaryStatistics#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor) VendorCounts is ArrayList(); then return vendorCounts size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSoftwareSummaryStatistics ImmutableSoftwareSummaryStatistics.fromJson(Json)"})
  void testFromJson_whenJsonVendorCountsIsArrayList_thenReturnVendorCountsSizeIsOne() {
    // Arrange
    ArrayList<Tally<String>> vendorCounts = new ArrayList<>();
    vendorCounts.add(mock(Tally.class));

    Json json = new Json();
    json.setVendorCounts(vendorCounts);
    json.setGroupCounts(null);
    json.setNameCounts(null);

    // Act and Assert
    assertEquals(1, ImmutableSoftwareSummaryStatistics.fromJson(json).vendorCounts().size());
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return nameCounts is {@link Json} (default constructor) {@link Json#vendorCounts}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareSummaryStatistics#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return nameCounts is Json (default constructor) vendorCounts")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSoftwareSummaryStatistics ImmutableSoftwareSummaryStatistics.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnNameCountsIsJsonVendorCounts() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableSoftwareSummaryStatistics actualFromJsonResult = ImmutableSoftwareSummaryStatistics.fromJson(json);

    // Assert
    List<Tally<String>> tallyList = json.vendorCounts;
    assertSame(tallyList, actualFromJsonResult.nameCounts());
    assertSame(tallyList, actualFromJsonResult.vendorCounts());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSoftwareSummaryStatistics#toString()}
   *   <li>{@link ImmutableSoftwareSummaryStatistics#groupCounts()}
   *   <li>{@link ImmutableSoftwareSummaryStatistics#nameCounts()}
   *   <li>{@link ImmutableSoftwareSummaryStatistics#vendorCounts()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ImmutableSoftwareSummaryStatistics.groupCounts()",
      "List ImmutableSoftwareSummaryStatistics.nameCounts()", "String ImmutableSoftwareSummaryStatistics.toString()",
      "List ImmutableSoftwareSummaryStatistics.vendorCounts()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableSoftwareSummaryStatistics buildResult = ImmutableSoftwareSummaryStatistics.builder().build();

    // Act
    String actualToStringResult = buildResult.toString();
    List<Tally<String>> actualGroupCountsResult = buildResult.groupCounts();
    List<Tally<String>> actualNameCountsResult = buildResult.nameCounts();
    List<Tally<String>> actualVendorCountsResult = buildResult.vendorCounts();

    // Assert
    assertEquals("SoftwareSummaryStatistics{vendorCounts=[], groupCounts=[], nameCounts=[]}", actualToStringResult);
    assertTrue(actualGroupCountsResult.isEmpty());
    assertSame(actualGroupCountsResult, actualNameCountsResult);
    assertSame(actualGroupCountsResult, actualVendorCountsResult);
  }

  /**
   * Test Json {@link Json#groupCounts()}.
   * <p>
   * Method under test: {@link Json#groupCounts()}
   */
  @Test
  @DisplayName("Test Json groupCounts()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.groupCounts()"})
  void testJsonGroupCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).groupCounts());
  }

  /**
   * Test Json {@link Json#nameCounts()}.
   * <p>
   * Method under test: {@link Json#nameCounts()}
   */
  @Test
  @DisplayName("Test Json nameCounts()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.nameCounts()"})
  void testJsonNameCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).nameCounts());
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
    assertTrue(actualJson.groupCounts.isEmpty());
    assertTrue(actualJson.nameCounts.isEmpty());
    assertTrue(actualJson.vendorCounts.isEmpty());
  }

  /**
   * Test Json {@link Json#vendorCounts()}.
   * <p>
   * Method under test: {@link Json#vendorCounts()}
   */
  @Test
  @DisplayName("Test Json vendorCounts()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.vendorCounts()"})
  void testJsonVendorCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).vendorCounts());
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#withGroupCounts(Tally[])} with {@code Tally[]}.
   * <ul>
   *   <li>When {@link Tally}.</li>
   *   <li>Then return groupCounts size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareSummaryStatistics#withGroupCounts(Tally[])}
   */
  @Test
  @DisplayName("Test withGroupCounts(Tally[]) with 'Tally[]'; when Tally; then return groupCounts size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSoftwareSummaryStatistics ImmutableSoftwareSummaryStatistics.withGroupCounts(Tally[])"})
  void testWithGroupCountsWithTally_whenTally_thenReturnGroupCountsSizeIsOne() {
    // Arrange
    ImmutableSoftwareSummaryStatistics buildResult = ImmutableSoftwareSummaryStatistics.builder().build();

    // Act
    ImmutableSoftwareSummaryStatistics actualWithGroupCountsResult = buildResult.withGroupCounts(mock(Tally.class));

    // Assert
    assertEquals(1, actualWithGroupCountsResult.groupCounts().size());
    List<Tally<String>> nameCountsResult = actualWithGroupCountsResult.nameCounts();
    assertTrue(nameCountsResult.isEmpty());
    assertSame(nameCountsResult, actualWithGroupCountsResult.vendorCounts());
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#withNameCounts(Tally[])} with {@code Tally[]}.
   * <ul>
   *   <li>When {@link Tally}.</li>
   *   <li>Then return nameCounts size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareSummaryStatistics#withNameCounts(Tally[])}
   */
  @Test
  @DisplayName("Test withNameCounts(Tally[]) with 'Tally[]'; when Tally; then return nameCounts size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSoftwareSummaryStatistics ImmutableSoftwareSummaryStatistics.withNameCounts(Tally[])"})
  void testWithNameCountsWithTally_whenTally_thenReturnNameCountsSizeIsOne() {
    // Arrange
    ImmutableSoftwareSummaryStatistics buildResult = ImmutableSoftwareSummaryStatistics.builder().build();

    // Act
    ImmutableSoftwareSummaryStatistics actualWithNameCountsResult = buildResult.withNameCounts(mock(Tally.class));

    // Assert
    assertEquals(1, actualWithNameCountsResult.nameCounts().size());
    List<Tally<String>> groupCountsResult = actualWithNameCountsResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertSame(groupCountsResult, actualWithNameCountsResult.vendorCounts());
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#withVendorCounts(Tally[])} with {@code Tally[]}.
   * <ul>
   *   <li>When {@link Tally}.</li>
   *   <li>Then return vendorCounts size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSoftwareSummaryStatistics#withVendorCounts(Tally[])}
   */
  @Test
  @DisplayName("Test withVendorCounts(Tally[]) with 'Tally[]'; when Tally; then return vendorCounts size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSoftwareSummaryStatistics ImmutableSoftwareSummaryStatistics.withVendorCounts(Tally[])"})
  void testWithVendorCountsWithTally_whenTally_thenReturnVendorCountsSizeIsOne() {
    // Arrange
    ImmutableSoftwareSummaryStatistics buildResult = ImmutableSoftwareSummaryStatistics.builder().build();

    // Act
    ImmutableSoftwareSummaryStatistics actualWithVendorCountsResult = buildResult.withVendorCounts(mock(Tally.class));

    // Assert
    assertEquals(1, actualWithVendorCountsResult.vendorCounts().size());
    List<Tally<String>> groupCountsResult = actualWithVendorCountsResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertSame(groupCountsResult, actualWithVendorCountsResult.nameCounts());
  }
}
