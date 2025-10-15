package org.finos.waltz.model.software_catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.software_catalog.ImmutableSoftwareSummaryStatistics.Builder;
import org.finos.waltz.model.software_catalog.ImmutableSoftwareSummaryStatistics.Json;
import org.finos.waltz.model.tally.ImmutableOrderedTally;
import org.finos.waltz.model.tally.Tally;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSoftwareSummaryStatisticsDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllGroupCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllGroupCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllGroupCounts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllGroupCounts(Iterable)"})
  void testBuilderAddAllGroupCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    // Act
    Builder actualAddAllGroupCountsResult = builderResult.addAllGroupCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllGroupCountsResult);
  }

  /**
   * Test Builder {@link Builder#addAllNameCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllNameCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllNameCounts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllNameCounts(Iterable)"})
  void testBuilderAddAllNameCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    // Act
    Builder actualAddAllNameCountsResult = builderResult.addAllNameCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllNameCountsResult);
  }

  /**
   * Test Builder {@link Builder#addAllVendorCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllVendorCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllVendorCounts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllVendorCounts(Iterable)"})
  void testBuilderAddAllVendorCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    // Act
    Builder actualAddAllVendorCountsResult = builderResult.addAllVendorCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllVendorCountsResult);
  }

  /**
   * Test Builder {@link Builder#addGroupCounts(Tally)} with {@code element}.
   *
   * <ul>
   *   <li>Then builder build groupCounts size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addGroupCounts(Tally)}
   */
  @Test
  @DisplayName(
      "Test Builder addGroupCounts(Tally) with 'element'; then builder build groupCounts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then builder build groupCounts size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addGroupCounts(Tally[])}
   */
  @Test
  @DisplayName(
      "Test Builder addGroupCounts(Tally[]) with 'elements'; then builder build groupCounts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then builder build nameCounts size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addNameCounts(Tally)}
   */
  @Test
  @DisplayName(
      "Test Builder addNameCounts(Tally) with 'element'; then builder build nameCounts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then builder build nameCounts size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addNameCounts(Tally[])}
   */
  @Test
  @DisplayName(
      "Test Builder addNameCounts(Tally[]) with 'elements'; then builder build nameCounts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then builder build vendorCounts size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addVendorCounts(Tally)}
   */
  @Test
  @DisplayName(
      "Test Builder addVendorCounts(Tally) with 'element'; then builder build vendorCounts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then builder build vendorCounts size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addVendorCounts(Tally[])}
   */
  @Test
  @DisplayName(
      "Test Builder addVendorCounts(Tally[]) with 'elements'; then builder build vendorCounts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareSummaryStatistics Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableSoftwareSummaryStatistics.builder().build().groupCounts().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(SoftwareSummaryStatistics)}.
   *
   * <ul>
   *   <li>Then return build groupCounts size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SoftwareSummaryStatistics)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SoftwareSummaryStatistics); then return build groupCounts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SoftwareSummaryStatistics)"})
  void testBuilderFrom_thenReturnBuildGroupCountsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    Builder builderResult2 = ImmutableSoftwareSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult3 = ImmutableOrderedTally.builder();
    builderResult2.addGroupCounts(builderResult3.count(10.0d).id("42").index(1).build());

    ImmutableOrderedTally.Builder<String> builderResult4 = ImmutableOrderedTally.builder();
    builderResult2.addVendorCounts(builderResult4.count(10.0d).id("42").index(1).build());

    // Act and Assert
    ImmutableSoftwareSummaryStatistics immutableSoftwareSummaryStatistics =
        builderResult.from(builderResult2.build()).build();
    List<Tally<String>> groupCountsResult = immutableSoftwareSummaryStatistics.groupCounts();
    assertEquals(1, groupCountsResult.size());
    Tally<String> getResult = groupCountsResult.get(0);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    assertEquals("42", getResult.id());
    assertEquals(1, ((ImmutableOrderedTally<String>) getResult).index());
    assertEquals(10.0d, getResult.count());
    assertTrue(immutableSoftwareSummaryStatistics.nameCounts().isEmpty());
    assertEquals(groupCountsResult, immutableSoftwareSummaryStatistics.vendorCounts());
  }

  /**
   * Test Builder {@link Builder#from(SoftwareSummaryStatistics)}.
   *
   * <ul>
   *   <li>Then return build nameCounts size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SoftwareSummaryStatistics)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SoftwareSummaryStatistics); then return build nameCounts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SoftwareSummaryStatistics)"})
  void testBuilderFrom_thenReturnBuildNameCountsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    Builder builderResult2 = ImmutableSoftwareSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult3 = ImmutableOrderedTally.builder();
    builderResult2.addNameCounts(builderResult3.count(10.0d).id("42").index(1).build());

    ImmutableOrderedTally.Builder<String> builderResult4 = ImmutableOrderedTally.builder();
    builderResult2.addVendorCounts(builderResult4.count(10.0d).id("42").index(1).build());

    // Act and Assert
    ImmutableSoftwareSummaryStatistics immutableSoftwareSummaryStatistics =
        builderResult.from(builderResult2.build()).build();
    List<Tally<String>> nameCountsResult = immutableSoftwareSummaryStatistics.nameCounts();
    assertEquals(1, nameCountsResult.size());
    Tally<String> getResult = nameCountsResult.get(0);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    assertEquals("42", getResult.id());
    assertEquals(1, ((ImmutableOrderedTally<String>) getResult).index());
    assertEquals(10.0d, getResult.count());
    assertEquals(nameCountsResult, immutableSoftwareSummaryStatistics.vendorCounts());
  }

  /**
   * Test Builder {@link Builder#from(SoftwareSummaryStatistics)}.
   *
   * <ul>
   *   <li>Then return build vendorCounts size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SoftwareSummaryStatistics)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SoftwareSummaryStatistics); then return build vendorCounts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SoftwareSummaryStatistics)"})
  void testBuilderFrom_thenReturnBuildVendorCountsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    Builder builderResult2 = ImmutableSoftwareSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult3 = ImmutableOrderedTally.builder();
    builderResult2.addVendorCounts(builderResult3.count(10.0d).id("42").index(1).build());

    // Act and Assert
    List<Tally<String>> vendorCountsResult =
        builderResult.from(builderResult2.build()).build().vendorCounts();
    assertEquals(1, vendorCountsResult.size());
    Tally<String> getResult = vendorCountsResult.get(0);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    assertEquals("42", getResult.id());
    assertEquals(1, ((ImmutableOrderedTally<String>) getResult).index());
    assertEquals(10.0d, getResult.count());
  }

  /**
   * Test Builder {@link Builder#from(SoftwareSummaryStatistics)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return build groupCounts Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SoftwareSummaryStatistics)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SoftwareSummaryStatistics); when builder build; then return build groupCounts Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SoftwareSummaryStatistics)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuildGroupCountsEmpty() {
    // Arrange, Act and Assert
    ImmutableSoftwareSummaryStatistics immutableSoftwareSummaryStatistics =
        ImmutableSoftwareSummaryStatistics.builder()
            .from(ImmutableSoftwareSummaryStatistics.builder().build())
            .build();
    List<Tally<String>> groupCountsResult = immutableSoftwareSummaryStatistics.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertSame(groupCountsResult, immutableSoftwareSummaryStatistics.nameCounts());
    assertSame(groupCountsResult, immutableSoftwareSummaryStatistics.vendorCounts());
  }

  /**
   * Test Builder {@link Builder#groupCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#groupCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder groupCounts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.groupCounts(Iterable)"})
  void testBuilderGroupCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    // Act
    Builder actualGroupCountsResult = builderResult.groupCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualGroupCountsResult);
  }

  /**
   * Test Builder {@link Builder#nameCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#nameCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder nameCounts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.nameCounts(Iterable)"})
  void testBuilderNameCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    // Act
    Builder actualNameCountsResult = builderResult.nameCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualNameCountsResult);
  }

  /**
   * Test Builder {@link Builder#vendorCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#vendorCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder vendorCounts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.vendorCounts(Iterable)"})
  void testBuilderVendorCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    // Act
    Builder actualVendorCountsResult = builderResult.vendorCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualVendorCountsResult);
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#copyOf(SoftwareSummaryStatistics)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return groupCounts Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSoftwareSummaryStatistics#copyOf(SoftwareSummaryStatistics)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SoftwareSummaryStatistics); when builder build; then return groupCounts Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwareSummaryStatistics ImmutableSoftwareSummaryStatistics.copyOf(SoftwareSummaryStatistics)"
  })
  void testCopyOf_whenBuilderBuild_thenReturnGroupCountsEmpty() {
    // Arrange
    ImmutableSoftwareSummaryStatistics instance =
        ImmutableSoftwareSummaryStatistics.builder().build();

    // Act
    ImmutableSoftwareSummaryStatistics actualCopyOfResult =
        ImmutableSoftwareSummaryStatistics.copyOf(instance);

    // Assert
    List<Tally<String>> groupCountsResult = actualCopyOfResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertSame(groupCountsResult, actualCopyOfResult.nameCounts());
    assertSame(groupCountsResult, actualCopyOfResult.vendorCounts());
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#equals(Object)}, and {@link
   * ImmutableSoftwareSummaryStatistics#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSoftwareSummaryStatistics#equals(Object)}
   *   <li>{@link ImmutableSoftwareSummaryStatistics#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareSummaryStatistics.equals(Object)",
    "int ImmutableSoftwareSummaryStatistics.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSoftwareSummaryStatistics immutableSoftwareSummaryStatistics =
        ImmutableSoftwareSummaryStatistics.builder().build();
    ImmutableSoftwareSummaryStatistics immutableSoftwareSummaryStatistics2 =
        ImmutableSoftwareSummaryStatistics.builder().build();

    // Act and Assert
    assertEquals(immutableSoftwareSummaryStatistics, immutableSoftwareSummaryStatistics2);
    assertEquals(
        immutableSoftwareSummaryStatistics.hashCode(),
        immutableSoftwareSummaryStatistics2.hashCode());
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#equals(Object)}, and {@link
   * ImmutableSoftwareSummaryStatistics#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSoftwareSummaryStatistics#equals(Object)}
   *   <li>{@link ImmutableSoftwareSummaryStatistics#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareSummaryStatistics.equals(Object)",
    "int ImmutableSoftwareSummaryStatistics.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSoftwareSummaryStatistics immutableSoftwareSummaryStatistics =
        ImmutableSoftwareSummaryStatistics.builder().build();

    // Act and Assert
    assertEquals(immutableSoftwareSummaryStatistics, immutableSoftwareSummaryStatistics);
    int expectedHashCodeResult = immutableSoftwareSummaryStatistics.hashCode();
    assertEquals(expectedHashCodeResult, immutableSoftwareSummaryStatistics.hashCode());
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareSummaryStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareSummaryStatistics.equals(Object)",
    "int ImmutableSoftwareSummaryStatistics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult2 = ImmutableOrderedTally.builder();
    builderResult.addVendorCounts(builderResult2.count(10.0d).id("42").index(1).build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableSoftwareSummaryStatistics.builder().build());
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareSummaryStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareSummaryStatistics.equals(Object)",
    "int ImmutableSoftwareSummaryStatistics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult2 = ImmutableOrderedTally.builder();
    builderResult.addGroupCounts(builderResult2.count(10.0d).id("42").index(1).build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableSoftwareSummaryStatistics.builder().build());
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareSummaryStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareSummaryStatistics.equals(Object)",
    "int ImmutableSoftwareSummaryStatistics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult2 = ImmutableOrderedTally.builder();
    builderResult.addNameCounts(builderResult2.count(10.0d).id("42").index(1).build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableSoftwareSummaryStatistics.builder().build());
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareSummaryStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareSummaryStatistics.equals(Object)",
    "int ImmutableSoftwareSummaryStatistics.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableSoftwareSummaryStatistics.builder().build(), null);
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareSummaryStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareSummaryStatistics.equals(Object)",
    "int ImmutableSoftwareSummaryStatistics.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSoftwareSummaryStatistics.builder().build(),
        "Different type to ImmutableSoftwareSummaryStatistics");
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) NameCounts is {@code null}.
   *   <li>Then return groupCounts Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareSummaryStatistics#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) NameCounts is 'null'; then return groupCounts Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwareSummaryStatistics ImmutableSoftwareSummaryStatistics.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonNameCountsIsNull_thenReturnGroupCountsEmpty() {
    // Arrange
    Json json = new Json();
    json.setVendorCounts(null);
    json.setGroupCounts(null);
    json.setNameCounts(null);

    // Act
    ImmutableSoftwareSummaryStatistics actualFromJsonResult =
        ImmutableSoftwareSummaryStatistics.fromJson(json);

    // Assert
    List<Tally<String>> groupCountsResult = actualFromJsonResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertSame(groupCountsResult, actualFromJsonResult.nameCounts());
    assertSame(groupCountsResult, actualFromJsonResult.vendorCounts());
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return nameCounts size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareSummaryStatistics#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return nameCounts size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwareSummaryStatistics ImmutableSoftwareSummaryStatistics.fromJson(Json)"
  })
  void testFromJson_thenReturnNameCountsSizeIsTwo() {
    // Arrange
    ArrayList<Tally<String>> nameCounts = new ArrayList<>();

    ImmutableOrderedTally.Builder<String> builderResult = ImmutableOrderedTally.builder();
    nameCounts.add(builderResult.count(10.0d).id("42").index(1).build());
    nameCounts.add(mock(Tally.class));

    Json json = new Json();
    json.setVendorCounts(null);
    json.setGroupCounts(null);
    json.setNameCounts(nameCounts);

    // Act
    ImmutableSoftwareSummaryStatistics actualFromJsonResult =
        ImmutableSoftwareSummaryStatistics.fromJson(json);

    // Assert
    List<Tally<String>> nameCountsResult = actualFromJsonResult.nameCounts();
    assertEquals(2, nameCountsResult.size());
    Tally<String> getResult = nameCountsResult.get(0);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    assertEquals("42", getResult.id());
    assertEquals(1, ((ImmutableOrderedTally<String>) getResult).index());
    assertEquals(10.0d, getResult.count());
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) GroupCounts is {@link ArrayList#ArrayList()}.
   *   <li>Then return groupCounts size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareSummaryStatistics#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) GroupCounts is ArrayList(); then return groupCounts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwareSummaryStatistics ImmutableSoftwareSummaryStatistics.fromJson(Json)"
  })
  void testFromJson_whenJsonGroupCountsIsArrayList_thenReturnGroupCountsSizeIsOne() {
    // Arrange
    ArrayList<Tally<String>> groupCounts = new ArrayList<>();
    groupCounts.add(mock(Tally.class));

    Json json = new Json();
    json.setVendorCounts(null);
    json.setGroupCounts(groupCounts);
    json.setNameCounts(null);

    // Act
    ImmutableSoftwareSummaryStatistics actualFromJsonResult =
        ImmutableSoftwareSummaryStatistics.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.groupCounts().size());
    List<Tally<String>> nameCountsResult = actualFromJsonResult.nameCounts();
    assertTrue(nameCountsResult.isEmpty());
    assertSame(nameCountsResult, actualFromJsonResult.vendorCounts());
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) NameCounts is {@link ArrayList#ArrayList()}.
   *   <li>Then return nameCounts size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareSummaryStatistics#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) NameCounts is ArrayList(); then return nameCounts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwareSummaryStatistics ImmutableSoftwareSummaryStatistics.fromJson(Json)"
  })
  void testFromJson_whenJsonNameCountsIsArrayList_thenReturnNameCountsSizeIsOne() {
    // Arrange
    ArrayList<Tally<String>> nameCounts = new ArrayList<>();
    nameCounts.add(mock(Tally.class));

    Json json = new Json();
    json.setVendorCounts(null);
    json.setGroupCounts(null);
    json.setNameCounts(nameCounts);

    // Act
    ImmutableSoftwareSummaryStatistics actualFromJsonResult =
        ImmutableSoftwareSummaryStatistics.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.nameCounts().size());
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) VendorCounts is {@link ArrayList#ArrayList()}.
   *   <li>Then return vendorCounts size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareSummaryStatistics#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) VendorCounts is ArrayList(); then return vendorCounts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwareSummaryStatistics ImmutableSoftwareSummaryStatistics.fromJson(Json)"
  })
  void testFromJson_whenJsonVendorCountsIsArrayList_thenReturnVendorCountsSizeIsOne() {
    // Arrange
    ArrayList<Tally<String>> vendorCounts = new ArrayList<>();
    vendorCounts.add(mock(Tally.class));

    Json json = new Json();
    json.setVendorCounts(vendorCounts);
    json.setGroupCounts(null);
    json.setNameCounts(null);

    // Act
    ImmutableSoftwareSummaryStatistics actualFromJsonResult =
        ImmutableSoftwareSummaryStatistics.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.vendorCounts().size());
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return nameCounts is {@link Json} (default constructor) {@link Json#vendorCounts}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareSummaryStatistics#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return nameCounts is Json (default constructor) vendorCounts")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwareSummaryStatistics ImmutableSoftwareSummaryStatistics.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnNameCountsIsJsonVendorCounts() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableSoftwareSummaryStatistics actualFromJsonResult =
        ImmutableSoftwareSummaryStatistics.fromJson(json);

    // Assert
    List<Tally<String>> tallyList = json.vendorCounts;
    assertSame(tallyList, actualFromJsonResult.nameCounts());
    assertSame(tallyList, actualFromJsonResult.vendorCounts());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSoftwareSummaryStatistics#toString()}
   *   <li>{@link ImmutableSoftwareSummaryStatistics#groupCounts()}
   *   <li>{@link ImmutableSoftwareSummaryStatistics#nameCounts()}
   *   <li>{@link ImmutableSoftwareSummaryStatistics#vendorCounts()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ImmutableSoftwareSummaryStatistics.groupCounts()",
    "List ImmutableSoftwareSummaryStatistics.nameCounts()",
    "String ImmutableSoftwareSummaryStatistics.toString()",
    "List ImmutableSoftwareSummaryStatistics.vendorCounts()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSoftwareSummaryStatistics immutableSoftwareSummaryStatistics =
        ImmutableSoftwareSummaryStatistics.builder().build();

    // Act
    String actualToStringResult = immutableSoftwareSummaryStatistics.toString();
    List<Tally<String>> actualGroupCountsResult = immutableSoftwareSummaryStatistics.groupCounts();
    List<Tally<String>> actualNameCountsResult = immutableSoftwareSummaryStatistics.nameCounts();
    List<Tally<String>> actualVendorCountsResult =
        immutableSoftwareSummaryStatistics.vendorCounts();

    // Assert
    assertEquals(
        "SoftwareSummaryStatistics{vendorCounts=[], groupCounts=[], nameCounts=[]}",
        actualToStringResult);
    assertTrue(actualGroupCountsResult.isEmpty());
    assertSame(actualGroupCountsResult, actualNameCountsResult);
    assertSame(actualGroupCountsResult, actualVendorCountsResult);
  }

  /**
   * Test Json {@link Json#groupCounts()}.
   *
   * <p>Method under test: {@link Json#groupCounts()}
   */
  @Test
  @DisplayName("Test Json groupCounts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.groupCounts()"})
  void testJsonGroupCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().groupCounts());
  }

  /**
   * Test Json {@link Json#nameCounts()}.
   *
   * <p>Method under test: {@link Json#nameCounts()}
   */
  @Test
  @DisplayName("Test Json nameCounts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.nameCounts()"})
  void testJsonNameCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().nameCounts());
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
    assertTrue(actualJson.groupCounts.isEmpty());
    assertTrue(actualJson.nameCounts.isEmpty());
    assertTrue(actualJson.vendorCounts.isEmpty());
  }

  /**
   * Test Json {@link Json#vendorCounts()}.
   *
   * <p>Method under test: {@link Json#vendorCounts()}
   */
  @Test
  @DisplayName("Test Json vendorCounts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.vendorCounts()"})
  void testJsonVendorCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().vendorCounts());
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#withGroupCounts(Tally[])} with {@code Tally[]}.
   *
   * <p>Method under test: {@link ImmutableSoftwareSummaryStatistics#withGroupCounts(Tally[])}
   */
  @Test
  @DisplayName("Test withGroupCounts(Tally[]) with 'Tally[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwareSummaryStatistics ImmutableSoftwareSummaryStatistics.withGroupCounts(Tally[])"
  })
  void testWithGroupCountsWithTally() {
    // Arrange
    ImmutableSoftwareSummaryStatistics immutableSoftwareSummaryStatistics =
        ImmutableSoftwareSummaryStatistics.builder().build();

    ImmutableOrderedTally.Builder<String> builderResult = ImmutableOrderedTally.builder();

    // Act
    ImmutableSoftwareSummaryStatistics actualWithGroupCountsResult =
        immutableSoftwareSummaryStatistics.withGroupCounts(
            builderResult.count(10.0d).id("42").index(1).build());

    // Assert
    List<Tally<String>> groupCountsResult = actualWithGroupCountsResult.groupCounts();
    assertEquals(1, groupCountsResult.size());
    Tally<String> getResult = groupCountsResult.get(0);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    assertEquals("42", getResult.id());
    assertEquals(1, ((ImmutableOrderedTally<String>) getResult).index());
    assertEquals(10.0d, getResult.count());
    List<Tally<String>> nameCountsResult = actualWithGroupCountsResult.nameCounts();
    assertTrue(nameCountsResult.isEmpty());
    assertSame(nameCountsResult, actualWithGroupCountsResult.vendorCounts());
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#withNameCounts(Tally[])} with {@code Tally[]}.
   *
   * <p>Method under test: {@link ImmutableSoftwareSummaryStatistics#withNameCounts(Tally[])}
   */
  @Test
  @DisplayName("Test withNameCounts(Tally[]) with 'Tally[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwareSummaryStatistics ImmutableSoftwareSummaryStatistics.withNameCounts(Tally[])"
  })
  void testWithNameCountsWithTally() {
    // Arrange
    ImmutableSoftwareSummaryStatistics immutableSoftwareSummaryStatistics =
        ImmutableSoftwareSummaryStatistics.builder().build();

    ImmutableOrderedTally.Builder<String> builderResult = ImmutableOrderedTally.builder();

    // Act
    ImmutableSoftwareSummaryStatistics actualWithNameCountsResult =
        immutableSoftwareSummaryStatistics.withNameCounts(
            builderResult.count(10.0d).id("42").index(1).build());

    // Assert
    List<Tally<String>> nameCountsResult = actualWithNameCountsResult.nameCounts();
    assertEquals(1, nameCountsResult.size());
    Tally<String> getResult = nameCountsResult.get(0);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    assertEquals("42", getResult.id());
    assertEquals(1, ((ImmutableOrderedTally<String>) getResult).index());
    assertEquals(10.0d, getResult.count());
    List<Tally<String>> groupCountsResult = actualWithNameCountsResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertSame(groupCountsResult, actualWithNameCountsResult.vendorCounts());
  }

  /**
   * Test {@link ImmutableSoftwareSummaryStatistics#withVendorCounts(Tally[])} with {@code Tally[]}.
   *
   * <p>Method under test: {@link ImmutableSoftwareSummaryStatistics#withVendorCounts(Tally[])}
   */
  @Test
  @DisplayName("Test withVendorCounts(Tally[]) with 'Tally[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwareSummaryStatistics ImmutableSoftwareSummaryStatistics.withVendorCounts(Tally[])"
  })
  void testWithVendorCountsWithTally() {
    // Arrange
    ImmutableSoftwareSummaryStatistics immutableSoftwareSummaryStatistics =
        ImmutableSoftwareSummaryStatistics.builder().build();

    ImmutableOrderedTally.Builder<String> builderResult = ImmutableOrderedTally.builder();

    // Act
    ImmutableSoftwareSummaryStatistics actualWithVendorCountsResult =
        immutableSoftwareSummaryStatistics.withVendorCounts(
            builderResult.count(10.0d).id("42").index(1).build());

    // Assert
    List<Tally<String>> vendorCountsResult = actualWithVendorCountsResult.vendorCounts();
    assertEquals(1, vendorCountsResult.size());
    Tally<String> getResult = vendorCountsResult.get(0);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    assertEquals("42", getResult.id());
    assertEquals(1, ((ImmutableOrderedTally<String>) getResult).index());
    assertEquals(10.0d, getResult.count());
    List<Tally<String>> groupCountsResult = actualWithVendorCountsResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertSame(groupCountsResult, actualWithVendorCountsResult.nameCounts());
  }
}
