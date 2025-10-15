package org.finos.waltz.model.database_information;

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
import org.finos.waltz.model.database_information.ImmutableDatabaseSummaryStatistics.Builder;
import org.finos.waltz.model.database_information.ImmutableDatabaseSummaryStatistics.Json;
import org.finos.waltz.model.tally.ImmutableOrderedTally;
import org.finos.waltz.model.tally.Tally;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDatabaseSummaryStatisticsDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllEndOfLifeStatusCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllEndOfLifeStatusCounts(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllEndOfLifeStatusCounts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllEndOfLifeStatusCounts(Iterable)"})
  void testBuilderAddAllEndOfLifeStatusCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();

    // Act
    Builder actualAddAllEndOfLifeStatusCountsResult =
        builderResult.addAllEndOfLifeStatusCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllEndOfLifeStatusCountsResult);
  }

  /**
   * Test Builder {@link Builder#addAllEnvironmentCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllEnvironmentCounts(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllEnvironmentCounts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllEnvironmentCounts(Iterable)"})
  void testBuilderAddAllEnvironmentCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();

    // Act
    Builder actualAddAllEnvironmentCountsResult =
        builderResult.addAllEnvironmentCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllEnvironmentCountsResult);
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
    Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();

    // Act
    Builder actualAddAllVendorCountsResult = builderResult.addAllVendorCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllVendorCountsResult);
  }

  /**
   * Test Builder {@link Builder#addEndOfLifeStatusCounts(Tally)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addEndOfLifeStatusCounts(Tally)}
   */
  @Test
  @DisplayName("Test Builder addEndOfLifeStatusCounts(Tally) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addEndOfLifeStatusCounts(Tally)"})
  void testBuilderAddEndOfLifeStatusCountsWithElement() {
    // Arrange
    Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();
    Tally<String> element = mock(Tally.class);

    // Act
    Builder actualAddEndOfLifeStatusCountsResult = builderResult.addEndOfLifeStatusCounts(element);

    // Assert
    List<Tally<String>> endOfLifeStatusCountsResult = builderResult.build().endOfLifeStatusCounts();
    assertEquals(1, endOfLifeStatusCountsResult.size());
    assertSame(builderResult, actualAddEndOfLifeStatusCountsResult);
    assertSame(element, endOfLifeStatusCountsResult.get(0));
  }

  /**
   * Test Builder {@link Builder#addEndOfLifeStatusCounts(Tally[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addEndOfLifeStatusCounts(Tally[])}
   */
  @Test
  @DisplayName("Test Builder addEndOfLifeStatusCounts(Tally[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addEndOfLifeStatusCounts(Tally[])"})
  void testBuilderAddEndOfLifeStatusCountsWithElements() {
    // Arrange
    Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();

    // Act
    Builder actualAddEndOfLifeStatusCountsResult =
        builderResult.addEndOfLifeStatusCounts(mock(Tally.class));

    // Assert
    assertEquals(1, builderResult.build().endOfLifeStatusCounts().size());
    assertSame(builderResult, actualAddEndOfLifeStatusCountsResult);
  }

  /**
   * Test Builder {@link Builder#addEnvironmentCounts(Tally)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addEnvironmentCounts(Tally)}
   */
  @Test
  @DisplayName("Test Builder addEnvironmentCounts(Tally) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addEnvironmentCounts(Tally)"})
  void testBuilderAddEnvironmentCountsWithElement() {
    // Arrange
    Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();
    Tally<String> element = mock(Tally.class);

    // Act
    Builder actualAddEnvironmentCountsResult = builderResult.addEnvironmentCounts(element);

    // Assert
    List<Tally<String>> environmentCountsResult = builderResult.build().environmentCounts();
    assertEquals(1, environmentCountsResult.size());
    assertSame(builderResult, actualAddEnvironmentCountsResult);
    assertSame(element, environmentCountsResult.get(0));
  }

  /**
   * Test Builder {@link Builder#addEnvironmentCounts(Tally[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addEnvironmentCounts(Tally[])}
   */
  @Test
  @DisplayName("Test Builder addEnvironmentCounts(Tally[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addEnvironmentCounts(Tally[])"})
  void testBuilderAddEnvironmentCountsWithElements() {
    // Arrange
    Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();

    // Act
    Builder actualAddEnvironmentCountsResult =
        builderResult.addEnvironmentCounts(mock(Tally.class));

    // Assert
    assertEquals(1, builderResult.build().environmentCounts().size());
    assertSame(builderResult, actualAddEnvironmentCountsResult);
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
    Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();
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
    Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();

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
  @MethodsUnderTest({"ImmutableDatabaseSummaryStatistics Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableDatabaseSummaryStatistics.builder().build().endOfLifeStatusCounts().isEmpty());
  }

  /**
   * Test Builder {@link Builder#endOfLifeStatusCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#endOfLifeStatusCounts(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder endOfLifeStatusCounts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.endOfLifeStatusCounts(Iterable)"})
  void testBuilderEndOfLifeStatusCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();

    // Act
    Builder actualEndOfLifeStatusCountsResult =
        builderResult.endOfLifeStatusCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualEndOfLifeStatusCountsResult);
  }

  /**
   * Test Builder {@link Builder#environmentCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#environmentCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder environmentCounts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.environmentCounts(Iterable)"})
  void testBuilderEnvironmentCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();

    // Act
    Builder actualEnvironmentCountsResult = builderResult.environmentCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualEnvironmentCountsResult);
  }

  /**
   * Test Builder {@link Builder#from(DatabaseSummaryStatistics)}.
   *
   * <ul>
   *   <li>Then return build endOfLifeStatusCounts size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DatabaseSummaryStatistics)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DatabaseSummaryStatistics); then return build endOfLifeStatusCounts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DatabaseSummaryStatistics)"})
  void testBuilderFrom_thenReturnBuildEndOfLifeStatusCountsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();

    Builder builderResult2 = ImmutableDatabaseSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult3 = ImmutableOrderedTally.builder();
    builderResult2.addEndOfLifeStatusCounts(builderResult3.count(10.0d).id("42").index(1).build());

    ImmutableOrderedTally.Builder<String> builderResult4 = ImmutableOrderedTally.builder();
    builderResult2.addEnvironmentCounts(builderResult4.count(10.0d).id("42").index(1).build());

    // Act and Assert
    ImmutableDatabaseSummaryStatistics immutableDatabaseSummaryStatistics =
        builderResult.from(builderResult2.build()).build();
    List<Tally<String>> endOfLifeStatusCountsResult =
        immutableDatabaseSummaryStatistics.endOfLifeStatusCounts();
    assertEquals(1, endOfLifeStatusCountsResult.size());
    Tally<String> getResult = endOfLifeStatusCountsResult.get(0);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    assertEquals("42", getResult.id());
    assertEquals(1, ((ImmutableOrderedTally<String>) getResult).index());
    assertEquals(10.0d, getResult.count());
    assertTrue(immutableDatabaseSummaryStatistics.vendorCounts().isEmpty());
    assertEquals(
        endOfLifeStatusCountsResult, immutableDatabaseSummaryStatistics.environmentCounts());
  }

  /**
   * Test Builder {@link Builder#from(DatabaseSummaryStatistics)}.
   *
   * <ul>
   *   <li>Then return build environmentCounts size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DatabaseSummaryStatistics)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DatabaseSummaryStatistics); then return build environmentCounts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DatabaseSummaryStatistics)"})
  void testBuilderFrom_thenReturnBuildEnvironmentCountsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();

    Builder builderResult2 = ImmutableDatabaseSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult3 = ImmutableOrderedTally.builder();
    builderResult2.addEnvironmentCounts(builderResult3.count(10.0d).id("42").index(1).build());

    // Act and Assert
    List<Tally<String>> environmentCountsResult =
        builderResult.from(builderResult2.build()).build().environmentCounts();
    assertEquals(1, environmentCountsResult.size());
    Tally<String> getResult = environmentCountsResult.get(0);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    assertEquals("42", getResult.id());
    assertEquals(1, ((ImmutableOrderedTally<String>) getResult).index());
    assertEquals(10.0d, getResult.count());
  }

  /**
   * Test Builder {@link Builder#from(DatabaseSummaryStatistics)}.
   *
   * <ul>
   *   <li>Then return build vendorCounts size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DatabaseSummaryStatistics)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DatabaseSummaryStatistics); then return build vendorCounts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DatabaseSummaryStatistics)"})
  void testBuilderFrom_thenReturnBuildVendorCountsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();

    Builder builderResult2 = ImmutableDatabaseSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult3 = ImmutableOrderedTally.builder();
    builderResult2.addVendorCounts(builderResult3.count(10.0d).id("42").index(1).build());

    ImmutableOrderedTally.Builder<String> builderResult4 = ImmutableOrderedTally.builder();
    builderResult2.addEnvironmentCounts(builderResult4.count(10.0d).id("42").index(1).build());

    // Act and Assert
    ImmutableDatabaseSummaryStatistics immutableDatabaseSummaryStatistics =
        builderResult.from(builderResult2.build()).build();
    List<Tally<String>> environmentCountsResult =
        immutableDatabaseSummaryStatistics.environmentCounts();
    assertEquals(1, environmentCountsResult.size());
    Tally<String> getResult = environmentCountsResult.get(0);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    List<Tally<String>> vendorCountsResult = immutableDatabaseSummaryStatistics.vendorCounts();
    assertEquals(1, vendorCountsResult.size());
    assertTrue(vendorCountsResult.get(0) instanceof ImmutableOrderedTally);
    assertEquals("42", getResult.id());
    assertEquals(1, ((ImmutableOrderedTally<String>) getResult).index());
    assertEquals(10.0d, getResult.count());
  }

  /**
   * Test Builder {@link Builder#from(DatabaseSummaryStatistics)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return build endOfLifeStatusCounts Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DatabaseSummaryStatistics)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DatabaseSummaryStatistics); when builder build; then return build endOfLifeStatusCounts Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DatabaseSummaryStatistics)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuildEndOfLifeStatusCountsEmpty() {
    // Arrange, Act and Assert
    ImmutableDatabaseSummaryStatistics immutableDatabaseSummaryStatistics =
        ImmutableDatabaseSummaryStatistics.builder()
            .from(ImmutableDatabaseSummaryStatistics.builder().build())
            .build();
    List<Tally<String>> endOfLifeStatusCountsResult =
        immutableDatabaseSummaryStatistics.endOfLifeStatusCounts();
    assertTrue(endOfLifeStatusCountsResult.isEmpty());
    assertSame(endOfLifeStatusCountsResult, immutableDatabaseSummaryStatistics.environmentCounts());
    assertSame(endOfLifeStatusCountsResult, immutableDatabaseSummaryStatistics.vendorCounts());
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
    Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();

    // Act
    Builder actualVendorCountsResult = builderResult.vendorCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualVendorCountsResult);
  }

  /**
   * Test {@link ImmutableDatabaseSummaryStatistics#copyOf(DatabaseSummaryStatistics)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return endOfLifeStatusCounts Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableDatabaseSummaryStatistics#copyOf(DatabaseSummaryStatistics)}
   */
  @Test
  @DisplayName(
      "Test copyOf(DatabaseSummaryStatistics); when builder build; then return endOfLifeStatusCounts Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseSummaryStatistics ImmutableDatabaseSummaryStatistics.copyOf(DatabaseSummaryStatistics)"
  })
  void testCopyOf_whenBuilderBuild_thenReturnEndOfLifeStatusCountsEmpty() {
    // Arrange
    ImmutableDatabaseSummaryStatistics instance =
        ImmutableDatabaseSummaryStatistics.builder().build();

    // Act
    ImmutableDatabaseSummaryStatistics actualCopyOfResult =
        ImmutableDatabaseSummaryStatistics.copyOf(instance);

    // Assert
    List<Tally<String>> endOfLifeStatusCountsResult = actualCopyOfResult.endOfLifeStatusCounts();
    assertTrue(endOfLifeStatusCountsResult.isEmpty());
    assertSame(endOfLifeStatusCountsResult, actualCopyOfResult.environmentCounts());
    assertSame(endOfLifeStatusCountsResult, actualCopyOfResult.vendorCounts());
  }

  /**
   * Test {@link ImmutableDatabaseSummaryStatistics#equals(Object)}, and {@link
   * ImmutableDatabaseSummaryStatistics#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDatabaseSummaryStatistics#equals(Object)}
   *   <li>{@link ImmutableDatabaseSummaryStatistics#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDatabaseSummaryStatistics.equals(Object)",
    "int ImmutableDatabaseSummaryStatistics.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableDatabaseSummaryStatistics immutableDatabaseSummaryStatistics =
        ImmutableDatabaseSummaryStatistics.builder().build();
    ImmutableDatabaseSummaryStatistics immutableDatabaseSummaryStatistics2 =
        ImmutableDatabaseSummaryStatistics.builder().build();

    // Act and Assert
    assertEquals(immutableDatabaseSummaryStatistics, immutableDatabaseSummaryStatistics2);
    assertEquals(
        immutableDatabaseSummaryStatistics.hashCode(),
        immutableDatabaseSummaryStatistics2.hashCode());
  }

  /**
   * Test {@link ImmutableDatabaseSummaryStatistics#equals(Object)}, and {@link
   * ImmutableDatabaseSummaryStatistics#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDatabaseSummaryStatistics#equals(Object)}
   *   <li>{@link ImmutableDatabaseSummaryStatistics#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDatabaseSummaryStatistics.equals(Object)",
    "int ImmutableDatabaseSummaryStatistics.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableDatabaseSummaryStatistics immutableDatabaseSummaryStatistics =
        ImmutableDatabaseSummaryStatistics.builder().build();

    // Act and Assert
    assertEquals(immutableDatabaseSummaryStatistics, immutableDatabaseSummaryStatistics);
    int expectedHashCodeResult = immutableDatabaseSummaryStatistics.hashCode();
    assertEquals(expectedHashCodeResult, immutableDatabaseSummaryStatistics.hashCode());
  }

  /**
   * Test {@link ImmutableDatabaseSummaryStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseSummaryStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDatabaseSummaryStatistics.equals(Object)",
    "int ImmutableDatabaseSummaryStatistics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult2 = ImmutableOrderedTally.builder();
    builderResult.addEnvironmentCounts(builderResult2.count(10.0d).id("42").index(1).build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableDatabaseSummaryStatistics.builder().build());
  }

  /**
   * Test {@link ImmutableDatabaseSummaryStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseSummaryStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDatabaseSummaryStatistics.equals(Object)",
    "int ImmutableDatabaseSummaryStatistics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult2 = ImmutableOrderedTally.builder();
    builderResult.addVendorCounts(builderResult2.count(10.0d).id("42").index(1).build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableDatabaseSummaryStatistics.builder().build());
  }

  /**
   * Test {@link ImmutableDatabaseSummaryStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseSummaryStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDatabaseSummaryStatistics.equals(Object)",
    "int ImmutableDatabaseSummaryStatistics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult2 = ImmutableOrderedTally.builder();
    builderResult.addEndOfLifeStatusCounts(builderResult2.count(10.0d).id("42").index(1).build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableDatabaseSummaryStatistics.builder().build());
  }

  /**
   * Test {@link ImmutableDatabaseSummaryStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseSummaryStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDatabaseSummaryStatistics.equals(Object)",
    "int ImmutableDatabaseSummaryStatistics.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableDatabaseSummaryStatistics.builder().build(), null);
  }

  /**
   * Test {@link ImmutableDatabaseSummaryStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseSummaryStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDatabaseSummaryStatistics.equals(Object)",
    "int ImmutableDatabaseSummaryStatistics.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableDatabaseSummaryStatistics.builder().build(),
        "Different type to ImmutableDatabaseSummaryStatistics");
  }

  /**
   * Test {@link ImmutableDatabaseSummaryStatistics#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return endOfLifeStatusCounts Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseSummaryStatistics#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return endOfLifeStatusCounts Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseSummaryStatistics ImmutableDatabaseSummaryStatistics.fromJson(Json)"
  })
  void testFromJson_thenReturnEndOfLifeStatusCountsEmpty() {
    // Arrange
    Json json = new Json();
    json.setEnvironmentCounts(null);
    json.setVendorCounts(null);
    json.setEndOfLifeStatusCounts(null);

    // Act
    ImmutableDatabaseSummaryStatistics actualFromJsonResult =
        ImmutableDatabaseSummaryStatistics.fromJson(json);

    // Assert
    List<Tally<String>> endOfLifeStatusCountsResult = actualFromJsonResult.endOfLifeStatusCounts();
    assertTrue(endOfLifeStatusCountsResult.isEmpty());
    assertSame(endOfLifeStatusCountsResult, actualFromJsonResult.environmentCounts());
    assertSame(endOfLifeStatusCountsResult, actualFromJsonResult.vendorCounts());
  }

  /**
   * Test {@link ImmutableDatabaseSummaryStatistics#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return endOfLifeStatusCounts size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseSummaryStatistics#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return endOfLifeStatusCounts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseSummaryStatistics ImmutableDatabaseSummaryStatistics.fromJson(Json)"
  })
  void testFromJson_thenReturnEndOfLifeStatusCountsSizeIsOne() {
    // Arrange
    ArrayList<Tally<String>> endOfLifeStatusCounts = new ArrayList<>();
    endOfLifeStatusCounts.add(mock(Tally.class));

    Json json = new Json();
    json.setEnvironmentCounts(null);
    json.setVendorCounts(null);
    json.setEndOfLifeStatusCounts(endOfLifeStatusCounts);

    // Act
    ImmutableDatabaseSummaryStatistics actualFromJsonResult =
        ImmutableDatabaseSummaryStatistics.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.endOfLifeStatusCounts().size());
    List<Tally<String>> environmentCountsResult = actualFromJsonResult.environmentCounts();
    assertTrue(environmentCountsResult.isEmpty());
    assertSame(environmentCountsResult, actualFromJsonResult.vendorCounts());
  }

  /**
   * Test {@link ImmutableDatabaseSummaryStatistics#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return endOfLifeStatusCounts size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseSummaryStatistics#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return endOfLifeStatusCounts size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseSummaryStatistics ImmutableDatabaseSummaryStatistics.fromJson(Json)"
  })
  void testFromJson_thenReturnEndOfLifeStatusCountsSizeIsTwo() {
    // Arrange
    ArrayList<Tally<String>> endOfLifeStatusCounts = new ArrayList<>();

    ImmutableOrderedTally.Builder<String> builderResult = ImmutableOrderedTally.builder();
    endOfLifeStatusCounts.add(builderResult.count(10.0d).id("42").index(1).build());
    endOfLifeStatusCounts.add(mock(Tally.class));

    Json json = new Json();
    json.setEnvironmentCounts(null);
    json.setVendorCounts(null);
    json.setEndOfLifeStatusCounts(endOfLifeStatusCounts);

    // Act
    ImmutableDatabaseSummaryStatistics actualFromJsonResult =
        ImmutableDatabaseSummaryStatistics.fromJson(json);

    // Assert
    List<Tally<String>> endOfLifeStatusCountsResult = actualFromJsonResult.endOfLifeStatusCounts();
    assertEquals(2, endOfLifeStatusCountsResult.size());
    Tally<String> getResult = endOfLifeStatusCountsResult.get(0);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    assertEquals("42", getResult.id());
    assertEquals(1, ((ImmutableOrderedTally<String>) getResult).index());
    assertEquals(10.0d, getResult.count());
  }

  /**
   * Test {@link ImmutableDatabaseSummaryStatistics#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return environmentCounts size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseSummaryStatistics#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return environmentCounts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseSummaryStatistics ImmutableDatabaseSummaryStatistics.fromJson(Json)"
  })
  void testFromJson_thenReturnEnvironmentCountsSizeIsOne() {
    // Arrange
    ArrayList<Tally<String>> environmentCounts = new ArrayList<>();
    environmentCounts.add(mock(Tally.class));

    Json json = new Json();
    json.setEnvironmentCounts(environmentCounts);
    json.setVendorCounts(null);
    json.setEndOfLifeStatusCounts(null);

    // Act
    ImmutableDatabaseSummaryStatistics actualFromJsonResult =
        ImmutableDatabaseSummaryStatistics.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.environmentCounts().size());
  }

  /**
   * Test {@link ImmutableDatabaseSummaryStatistics#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) VendorCounts is {@link ArrayList#ArrayList()}.
   *   <li>Then return vendorCounts size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseSummaryStatistics#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) VendorCounts is ArrayList(); then return vendorCounts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseSummaryStatistics ImmutableDatabaseSummaryStatistics.fromJson(Json)"
  })
  void testFromJson_whenJsonVendorCountsIsArrayList_thenReturnVendorCountsSizeIsOne() {
    // Arrange
    ArrayList<Tally<String>> vendorCounts = new ArrayList<>();
    vendorCounts.add(mock(Tally.class));

    Json json = new Json();
    json.setEnvironmentCounts(null);
    json.setVendorCounts(vendorCounts);
    json.setEndOfLifeStatusCounts(null);

    // Act
    ImmutableDatabaseSummaryStatistics actualFromJsonResult =
        ImmutableDatabaseSummaryStatistics.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.vendorCounts().size());
  }

  /**
   * Test {@link ImmutableDatabaseSummaryStatistics#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return environmentCounts is {@link Json} (default constructor) {@link
   *       Json#vendorCounts}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDatabaseSummaryStatistics#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return environmentCounts is Json (default constructor) vendorCounts")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseSummaryStatistics ImmutableDatabaseSummaryStatistics.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnEnvironmentCountsIsJsonVendorCounts() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableDatabaseSummaryStatistics actualFromJsonResult =
        ImmutableDatabaseSummaryStatistics.fromJson(json);

    // Assert
    List<Tally<String>> tallyList = json.vendorCounts;
    assertSame(tallyList, actualFromJsonResult.environmentCounts());
    assertSame(tallyList, actualFromJsonResult.vendorCounts());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDatabaseSummaryStatistics#toString()}
   *   <li>{@link ImmutableDatabaseSummaryStatistics#endOfLifeStatusCounts()}
   *   <li>{@link ImmutableDatabaseSummaryStatistics#environmentCounts()}
   *   <li>{@link ImmutableDatabaseSummaryStatistics#vendorCounts()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ImmutableDatabaseSummaryStatistics.endOfLifeStatusCounts()",
    "List ImmutableDatabaseSummaryStatistics.environmentCounts()",
    "String ImmutableDatabaseSummaryStatistics.toString()",
    "List ImmutableDatabaseSummaryStatistics.vendorCounts()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableDatabaseSummaryStatistics immutableDatabaseSummaryStatistics =
        ImmutableDatabaseSummaryStatistics.builder().build();

    // Act
    String actualToStringResult = immutableDatabaseSummaryStatistics.toString();
    List<Tally<String>> actualEndOfLifeStatusCountsResult =
        immutableDatabaseSummaryStatistics.endOfLifeStatusCounts();
    List<Tally<String>> actualEnvironmentCountsResult =
        immutableDatabaseSummaryStatistics.environmentCounts();
    List<Tally<String>> actualVendorCountsResult =
        immutableDatabaseSummaryStatistics.vendorCounts();

    // Assert
    assertEquals(
        "DatabaseSummaryStatistics{environmentCounts=[], vendorCounts=[], endOfLifeStatusCounts=[]}",
        actualToStringResult);
    assertTrue(actualEndOfLifeStatusCountsResult.isEmpty());
    assertSame(actualEndOfLifeStatusCountsResult, actualEnvironmentCountsResult);
    assertSame(actualEndOfLifeStatusCountsResult, actualVendorCountsResult);
  }

  /**
   * Test Json {@link Json#endOfLifeStatusCounts()}.
   *
   * <p>Method under test: {@link Json#endOfLifeStatusCounts()}
   */
  @Test
  @DisplayName("Test Json endOfLifeStatusCounts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.endOfLifeStatusCounts()"})
  void testJsonEndOfLifeStatusCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().endOfLifeStatusCounts());
  }

  /**
   * Test Json {@link Json#environmentCounts()}.
   *
   * <p>Method under test: {@link Json#environmentCounts()}
   */
  @Test
  @DisplayName("Test Json environmentCounts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.environmentCounts()"})
  void testJsonEnvironmentCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().environmentCounts());
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
    assertTrue(actualJson.endOfLifeStatusCounts.isEmpty());
    assertTrue(actualJson.environmentCounts.isEmpty());
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
   * Test {@link ImmutableDatabaseSummaryStatistics#withEndOfLifeStatusCounts(Tally[])} with {@code
   * Tally[]}.
   *
   * <p>Method under test: {@link
   * ImmutableDatabaseSummaryStatistics#withEndOfLifeStatusCounts(Tally[])}
   */
  @Test
  @DisplayName("Test withEndOfLifeStatusCounts(Tally[]) with 'Tally[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseSummaryStatistics ImmutableDatabaseSummaryStatistics.withEndOfLifeStatusCounts(Tally[])"
  })
  void testWithEndOfLifeStatusCountsWithTally() {
    // Arrange
    ImmutableDatabaseSummaryStatistics immutableDatabaseSummaryStatistics =
        ImmutableDatabaseSummaryStatistics.builder().build();

    ImmutableOrderedTally.Builder<String> builderResult = ImmutableOrderedTally.builder();

    // Act
    ImmutableDatabaseSummaryStatistics actualWithEndOfLifeStatusCountsResult =
        immutableDatabaseSummaryStatistics.withEndOfLifeStatusCounts(
            builderResult.count(10.0d).id("42").index(1).build());

    // Assert
    List<Tally<String>> endOfLifeStatusCountsResult =
        actualWithEndOfLifeStatusCountsResult.endOfLifeStatusCounts();
    assertEquals(1, endOfLifeStatusCountsResult.size());
    Tally<String> getResult = endOfLifeStatusCountsResult.get(0);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    assertEquals("42", getResult.id());
    assertEquals(1, ((ImmutableOrderedTally<String>) getResult).index());
    assertEquals(10.0d, getResult.count());
    List<Tally<String>> environmentCountsResult =
        actualWithEndOfLifeStatusCountsResult.environmentCounts();
    assertTrue(environmentCountsResult.isEmpty());
    assertSame(environmentCountsResult, actualWithEndOfLifeStatusCountsResult.vendorCounts());
  }

  /**
   * Test {@link ImmutableDatabaseSummaryStatistics#withEnvironmentCounts(Tally[])} with {@code
   * Tally[]}.
   *
   * <p>Method under test: {@link ImmutableDatabaseSummaryStatistics#withEnvironmentCounts(Tally[])}
   */
  @Test
  @DisplayName("Test withEnvironmentCounts(Tally[]) with 'Tally[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseSummaryStatistics ImmutableDatabaseSummaryStatistics.withEnvironmentCounts(Tally[])"
  })
  void testWithEnvironmentCountsWithTally() {
    // Arrange
    ImmutableDatabaseSummaryStatistics immutableDatabaseSummaryStatistics =
        ImmutableDatabaseSummaryStatistics.builder().build();

    ImmutableOrderedTally.Builder<String> builderResult = ImmutableOrderedTally.builder();

    // Act
    ImmutableDatabaseSummaryStatistics actualWithEnvironmentCountsResult =
        immutableDatabaseSummaryStatistics.withEnvironmentCounts(
            builderResult.count(10.0d).id("42").index(1).build());

    // Assert
    List<Tally<String>> environmentCountsResult =
        actualWithEnvironmentCountsResult.environmentCounts();
    assertEquals(1, environmentCountsResult.size());
    Tally<String> getResult = environmentCountsResult.get(0);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    assertEquals("42", getResult.id());
    assertEquals(1, ((ImmutableOrderedTally<String>) getResult).index());
    assertEquals(10.0d, getResult.count());
    List<Tally<String>> endOfLifeStatusCountsResult =
        actualWithEnvironmentCountsResult.endOfLifeStatusCounts();
    assertTrue(endOfLifeStatusCountsResult.isEmpty());
    assertSame(endOfLifeStatusCountsResult, actualWithEnvironmentCountsResult.vendorCounts());
  }

  /**
   * Test {@link ImmutableDatabaseSummaryStatistics#withVendorCounts(Tally[])} with {@code Tally[]}.
   *
   * <p>Method under test: {@link ImmutableDatabaseSummaryStatistics#withVendorCounts(Tally[])}
   */
  @Test
  @DisplayName("Test withVendorCounts(Tally[]) with 'Tally[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDatabaseSummaryStatistics ImmutableDatabaseSummaryStatistics.withVendorCounts(Tally[])"
  })
  void testWithVendorCountsWithTally() {
    // Arrange
    ImmutableDatabaseSummaryStatistics immutableDatabaseSummaryStatistics =
        ImmutableDatabaseSummaryStatistics.builder().build();

    ImmutableOrderedTally.Builder<String> builderResult = ImmutableOrderedTally.builder();

    // Act
    ImmutableDatabaseSummaryStatistics actualWithVendorCountsResult =
        immutableDatabaseSummaryStatistics.withVendorCounts(
            builderResult.count(10.0d).id("42").index(1).build());

    // Assert
    List<Tally<String>> vendorCountsResult = actualWithVendorCountsResult.vendorCounts();
    assertEquals(1, vendorCountsResult.size());
    Tally<String> getResult = vendorCountsResult.get(0);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    assertEquals("42", getResult.id());
    assertEquals(1, ((ImmutableOrderedTally<String>) getResult).index());
    assertEquals(10.0d, getResult.count());
    List<Tally<String>> endOfLifeStatusCountsResult =
        actualWithVendorCountsResult.endOfLifeStatusCounts();
    assertTrue(endOfLifeStatusCountsResult.isEmpty());
    assertSame(endOfLifeStatusCountsResult, actualWithVendorCountsResult.environmentCounts());
  }
}
