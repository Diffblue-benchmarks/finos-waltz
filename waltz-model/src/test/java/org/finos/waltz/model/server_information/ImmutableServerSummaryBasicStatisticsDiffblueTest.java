package org.finos.waltz.model.server_information;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.server_information.ImmutableServerSummaryBasicStatistics.Builder;
import org.finos.waltz.model.server_information.ImmutableServerSummaryBasicStatistics.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableServerSummaryBasicStatisticsDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerSummaryBasicStatistics Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableServerSummaryBasicStatistics actualImmutableServerSummaryBasicStatistics =
        ImmutableServerSummaryBasicStatistics.builder().physicalCount(3L).virtualCount(3L).build();

    // Assert
    assertEquals(3L, actualImmutableServerSummaryBasicStatistics.physicalCount());
    assertEquals(3L, actualImmutableServerSummaryBasicStatistics.virtualCount());
    assertEquals(6L, actualImmutableServerSummaryBasicStatistics.totalCount());
  }

  /**
   * Test Builder {@link Builder#from(ServerSummaryBasicStatistics)}.
   *
   * <p>Method under test: {@link Builder#from(ServerSummaryBasicStatistics)}
   */
  @Test
  @DisplayName("Test Builder from(ServerSummaryBasicStatistics)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ServerSummaryBasicStatistics)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryBasicStatistics.builder();
    ImmutableServerSummaryBasicStatistics instance =
        ImmutableServerSummaryBasicStatistics.builder().physicalCount(3L).virtualCount(3L).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableServerSummaryBasicStatistics actualImmutableServerSummaryBasicStatistics =
        builderResult.build();
    assertEquals(instance, actualImmutableServerSummaryBasicStatistics);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ServerSummaryBasicStatistics)}.
   *
   * <ul>
   *   <li>Then builder build physicalCount is three.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ServerSummaryBasicStatistics)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ServerSummaryBasicStatistics); then builder build physicalCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ServerSummaryBasicStatistics)"})
  void testBuilderFrom_thenBuilderBuildPhysicalCountIsThree() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryBasicStatistics.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build());

    // Assert
    ImmutableServerSummaryBasicStatistics immutableServerSummaryBasicStatistics =
        builderResult.build();
    assertEquals(3L, immutableServerSummaryBasicStatistics.physicalCount());
    assertEquals(3L, immutableServerSummaryBasicStatistics.virtualCount());
    assertEquals(6L, immutableServerSummaryBasicStatistics.totalCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#physicalCount(long)}.
   *
   * <p>Method under test: {@link Builder#physicalCount(long)}
   */
  @Test
  @DisplayName("Test Builder physicalCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.physicalCount(long)"})
  void testBuilderPhysicalCount() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryBasicStatistics.builder();

    // Act
    Builder actualPhysicalCountResult = builderResult.physicalCount(3L);

    // Assert
    assertSame(builderResult, actualPhysicalCountResult);
  }

  /**
   * Test Builder {@link Builder#totalCount(long)}.
   *
   * <p>Method under test: {@link Builder#totalCount(long)}
   */
  @Test
  @DisplayName("Test Builder totalCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.totalCount(long)"})
  void testBuilderTotalCount() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryBasicStatistics.builder();

    // Act
    Builder actualTotalCountResult = builderResult.totalCount(3L);

    // Assert
    assertSame(builderResult, actualTotalCountResult);
  }

  /**
   * Test Builder {@link Builder#virtualCount(long)}.
   *
   * <p>Method under test: {@link Builder#virtualCount(long)}
   */
  @Test
  @DisplayName("Test Builder virtualCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.virtualCount(long)"})
  void testBuilderVirtualCount() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryBasicStatistics.builder();

    // Act
    Builder actualVirtualCountResult = builderResult.virtualCount(3L);

    // Assert
    assertSame(builderResult, actualVirtualCountResult);
  }

  /**
   * Test {@link ImmutableServerSummaryBasicStatistics#copyOf(ServerSummaryBasicStatistics)}.
   *
   * <ul>
   *   <li>Then return physicalCount is three.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableServerSummaryBasicStatistics#copyOf(ServerSummaryBasicStatistics)}
   */
  @Test
  @DisplayName("Test copyOf(ServerSummaryBasicStatistics); then return physicalCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerSummaryBasicStatistics ImmutableServerSummaryBasicStatistics.copyOf(ServerSummaryBasicStatistics)"
  })
  void testCopyOf_thenReturnPhysicalCountIsThree() {
    // Arrange
    ImmutableServerSummaryBasicStatistics instance =
        ImmutableServerSummaryBasicStatistics.builder().physicalCount(3L).virtualCount(3L).build();

    // Act
    ImmutableServerSummaryBasicStatistics actualCopyOfResult =
        ImmutableServerSummaryBasicStatistics.copyOf(instance);

    // Assert
    assertEquals(3L, actualCopyOfResult.physicalCount());
    assertEquals(3L, actualCopyOfResult.virtualCount());
    assertEquals(6L, actualCopyOfResult.totalCount());
  }

  /**
   * Test {@link ImmutableServerSummaryBasicStatistics#copyOf(ServerSummaryBasicStatistics)}.
   *
   * <ul>
   *   <li>Then return physicalCount is three.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableServerSummaryBasicStatistics#copyOf(ServerSummaryBasicStatistics)}
   */
  @Test
  @DisplayName("Test copyOf(ServerSummaryBasicStatistics); then return physicalCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerSummaryBasicStatistics ImmutableServerSummaryBasicStatistics.copyOf(ServerSummaryBasicStatistics)"
  })
  void testCopyOf_thenReturnPhysicalCountIsThree2() {
    // Arrange
    ImmutableServerSummaryStatistics instance =
        ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build();

    // Act
    ImmutableServerSummaryBasicStatistics actualCopyOfResult =
        ImmutableServerSummaryBasicStatistics.copyOf(instance);

    // Assert
    assertEquals(3L, actualCopyOfResult.physicalCount());
    assertEquals(3L, actualCopyOfResult.virtualCount());
    assertEquals(6L, actualCopyOfResult.totalCount());
  }

  /**
   * Test {@link ImmutableServerSummaryBasicStatistics#equals(Object)}, and {@link
   * ImmutableServerSummaryBasicStatistics#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableServerSummaryBasicStatistics#equals(Object)}
   *   <li>{@link ImmutableServerSummaryBasicStatistics#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerSummaryBasicStatistics.equals(Object)",
    "int ImmutableServerSummaryBasicStatistics.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableServerSummaryBasicStatistics immutableServerSummaryBasicStatistics =
        ImmutableServerSummaryBasicStatistics.builder().physicalCount(3L).virtualCount(3L).build();
    ImmutableServerSummaryBasicStatistics immutableServerSummaryBasicStatistics2 =
        ImmutableServerSummaryBasicStatistics.builder().physicalCount(3L).virtualCount(3L).build();

    // Act and Assert
    assertEquals(immutableServerSummaryBasicStatistics, immutableServerSummaryBasicStatistics2);
    assertEquals(
        immutableServerSummaryBasicStatistics.hashCode(),
        immutableServerSummaryBasicStatistics2.hashCode());
  }

  /**
   * Test {@link ImmutableServerSummaryBasicStatistics#equals(Object)}, and {@link
   * ImmutableServerSummaryBasicStatistics#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableServerSummaryBasicStatistics#equals(Object)}
   *   <li>{@link ImmutableServerSummaryBasicStatistics#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerSummaryBasicStatistics.equals(Object)",
    "int ImmutableServerSummaryBasicStatistics.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableServerSummaryBasicStatistics immutableServerSummaryBasicStatistics =
        ImmutableServerSummaryBasicStatistics.builder().physicalCount(3L).virtualCount(3L).build();

    // Act and Assert
    assertEquals(immutableServerSummaryBasicStatistics, immutableServerSummaryBasicStatistics);
    int expectedHashCodeResult = immutableServerSummaryBasicStatistics.hashCode();
    assertEquals(expectedHashCodeResult, immutableServerSummaryBasicStatistics.hashCode());
  }

  /**
   * Test {@link ImmutableServerSummaryBasicStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerSummaryBasicStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerSummaryBasicStatistics.equals(Object)",
    "int ImmutableServerSummaryBasicStatistics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableServerSummaryBasicStatistics immutableServerSummaryBasicStatistics =
        ImmutableServerSummaryBasicStatistics.builder().physicalCount(1L).virtualCount(3L).build();

    // Act and Assert
    assertNotEquals(
        immutableServerSummaryBasicStatistics,
        ImmutableServerSummaryBasicStatistics.builder().physicalCount(3L).virtualCount(3L).build());
  }

  /**
   * Test {@link ImmutableServerSummaryBasicStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerSummaryBasicStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerSummaryBasicStatistics.equals(Object)",
    "int ImmutableServerSummaryBasicStatistics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableServerSummaryBasicStatistics immutableServerSummaryBasicStatistics =
        ImmutableServerSummaryBasicStatistics.builder().physicalCount(3L).virtualCount(1L).build();

    // Act and Assert
    assertNotEquals(
        immutableServerSummaryBasicStatistics,
        ImmutableServerSummaryBasicStatistics.builder().physicalCount(3L).virtualCount(3L).build());
  }

  /**
   * Test {@link ImmutableServerSummaryBasicStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerSummaryBasicStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerSummaryBasicStatistics.equals(Object)",
    "int ImmutableServerSummaryBasicStatistics.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableServerSummaryBasicStatistics.builder().physicalCount(3L).virtualCount(3L).build(),
        null);
  }

  /**
   * Test {@link ImmutableServerSummaryBasicStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerSummaryBasicStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerSummaryBasicStatistics.equals(Object)",
    "int ImmutableServerSummaryBasicStatistics.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableServerSummaryBasicStatistics.builder().physicalCount(3L).virtualCount(3L).build(),
        "Different type to ImmutableServerSummaryBasicStatistics");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableServerSummaryBasicStatistics#toString()}
   *   <li>{@link ImmutableServerSummaryBasicStatistics#physicalCount()}
   *   <li>{@link ImmutableServerSummaryBasicStatistics#totalCount()}
   *   <li>{@link ImmutableServerSummaryBasicStatistics#virtualCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableServerSummaryBasicStatistics.physicalCount()",
    "String ImmutableServerSummaryBasicStatistics.toString()",
    "long ImmutableServerSummaryBasicStatistics.totalCount()",
    "long ImmutableServerSummaryBasicStatistics.virtualCount()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableServerSummaryBasicStatistics immutableServerSummaryBasicStatistics =
        ImmutableServerSummaryBasicStatistics.builder().physicalCount(3L).virtualCount(3L).build();

    // Act
    String actualToStringResult = immutableServerSummaryBasicStatistics.toString();
    long actualPhysicalCountResult = immutableServerSummaryBasicStatistics.physicalCount();
    long actualTotalCountResult = immutableServerSummaryBasicStatistics.totalCount();

    // Assert
    assertEquals(
        "ServerSummaryBasicStatistics{virtualCount=3, physicalCount=3, totalCount=6}",
        actualToStringResult);
    assertEquals(3L, actualPhysicalCountResult);
    assertEquals(3L, immutableServerSummaryBasicStatistics.virtualCount());
    assertEquals(6L, actualTotalCountResult);
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
    assertEquals(0L, actualJson.physicalCount);
    assertEquals(0L, actualJson.totalCount);
    assertEquals(0L, actualJson.virtualCount);
    assertFalse(actualJson.physicalCountIsSet);
    assertFalse(actualJson.totalCountIsSet);
    assertFalse(actualJson.virtualCountIsSet);
  }

  /**
   * Test Json {@link Json#physicalCount()}.
   *
   * <p>Method under test: {@link Json#physicalCount()}
   */
  @Test
  @DisplayName("Test Json physicalCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.physicalCount()"})
  void testJsonPhysicalCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().physicalCount());
  }

  /**
   * Test Json {@link Json#setPhysicalCount(long)}.
   *
   * <p>Method under test: {@link Json#setPhysicalCount(long)}
   */
  @Test
  @DisplayName("Test Json setPhysicalCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setPhysicalCount(long)"})
  void testJsonSetPhysicalCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPhysicalCount(3L);

    // Assert
    assertEquals(3L, json.physicalCount);
    assertTrue(json.physicalCountIsSet);
  }

  /**
   * Test Json {@link Json#setTotalCount(long)}.
   *
   * <p>Method under test: {@link Json#setTotalCount(long)}
   */
  @Test
  @DisplayName("Test Json setTotalCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setTotalCount(long)"})
  void testJsonSetTotalCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setTotalCount(3L);

    // Assert
    assertEquals(3L, json.totalCount);
    assertTrue(json.totalCountIsSet);
  }

  /**
   * Test Json {@link Json#setVirtualCount(long)}.
   *
   * <p>Method under test: {@link Json#setVirtualCount(long)}
   */
  @Test
  @DisplayName("Test Json setVirtualCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setVirtualCount(long)"})
  void testJsonSetVirtualCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setVirtualCount(3L);

    // Assert
    assertEquals(3L, json.virtualCount);
    assertTrue(json.virtualCountIsSet);
  }

  /**
   * Test Json {@link Json#totalCount()}.
   *
   * <p>Method under test: {@link Json#totalCount()}
   */
  @Test
  @DisplayName("Test Json totalCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.totalCount()"})
  void testJsonTotalCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().totalCount());
  }

  /**
   * Test Json {@link Json#virtualCount()}.
   *
   * <p>Method under test: {@link Json#virtualCount()}
   */
  @Test
  @DisplayName("Test Json virtualCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.virtualCount()"})
  void testJsonVirtualCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().virtualCount());
  }

  /**
   * Test {@link ImmutableServerSummaryBasicStatistics#withPhysicalCount(long)}.
   *
   * <p>Method under test: {@link ImmutableServerSummaryBasicStatistics#withPhysicalCount(long)}
   */
  @Test
  @DisplayName("Test withPhysicalCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerSummaryBasicStatistics ImmutableServerSummaryBasicStatistics.withPhysicalCount(long)"
  })
  void testWithPhysicalCount() {
    // Arrange
    ImmutableServerSummaryBasicStatistics immutableServerSummaryBasicStatistics =
        ImmutableServerSummaryBasicStatistics.builder().physicalCount(42L).virtualCount(3L).build();

    // Act
    ImmutableServerSummaryBasicStatistics actualWithPhysicalCountResult =
        immutableServerSummaryBasicStatistics.withPhysicalCount(42L);

    // Assert
    assertSame(immutableServerSummaryBasicStatistics, actualWithPhysicalCountResult);
  }

  /**
   * Test {@link ImmutableServerSummaryBasicStatistics#withPhysicalCount(long)}.
   *
   * <ul>
   *   <li>Then return virtualCount is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerSummaryBasicStatistics#withPhysicalCount(long)}
   */
  @Test
  @DisplayName("Test withPhysicalCount(long); then return virtualCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerSummaryBasicStatistics ImmutableServerSummaryBasicStatistics.withPhysicalCount(long)"
  })
  void testWithPhysicalCount_thenReturnVirtualCountIsThree() {
    // Arrange and Act
    ImmutableServerSummaryBasicStatistics actualWithPhysicalCountResult =
        ImmutableServerSummaryBasicStatistics.builder()
            .physicalCount(3L)
            .virtualCount(3L)
            .build()
            .withPhysicalCount(42L);

    // Assert
    assertEquals(3L, actualWithPhysicalCountResult.virtualCount());
    assertEquals(42L, actualWithPhysicalCountResult.physicalCount());
    assertEquals(6L, actualWithPhysicalCountResult.totalCount());
  }

  /**
   * Test {@link ImmutableServerSummaryBasicStatistics#withTotalCount(long)}.
   *
   * <ul>
   *   <li>Then return builder physicalCount three virtualCount three build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerSummaryBasicStatistics#withTotalCount(long)}
   */
  @Test
  @DisplayName(
      "Test withTotalCount(long); then return builder physicalCount three virtualCount three build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerSummaryBasicStatistics ImmutableServerSummaryBasicStatistics.withTotalCount(long)"
  })
  void testWithTotalCount_thenReturnBuilderPhysicalCountThreeVirtualCountThreeBuild() {
    // Arrange
    ImmutableServerSummaryBasicStatistics immutableServerSummaryBasicStatistics =
        ImmutableServerSummaryBasicStatistics.builder().physicalCount(3L).virtualCount(3L).build();

    // Act
    ImmutableServerSummaryBasicStatistics actualWithTotalCountResult =
        immutableServerSummaryBasicStatistics.withTotalCount(6L);

    // Assert
    assertSame(immutableServerSummaryBasicStatistics, actualWithTotalCountResult);
  }

  /**
   * Test {@link ImmutableServerSummaryBasicStatistics#withTotalCount(long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return physicalCount is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerSummaryBasicStatistics#withTotalCount(long)}
   */
  @Test
  @DisplayName("Test withTotalCount(long); when forty-two; then return physicalCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerSummaryBasicStatistics ImmutableServerSummaryBasicStatistics.withTotalCount(long)"
  })
  void testWithTotalCount_whenFortyTwo_thenReturnPhysicalCountIsThree() {
    // Arrange and Act
    ImmutableServerSummaryBasicStatistics actualWithTotalCountResult =
        ImmutableServerSummaryBasicStatistics.builder()
            .physicalCount(3L)
            .virtualCount(3L)
            .build()
            .withTotalCount(42L);

    // Assert
    assertEquals(3L, actualWithTotalCountResult.physicalCount());
    assertEquals(3L, actualWithTotalCountResult.virtualCount());
    assertEquals(42L, actualWithTotalCountResult.totalCount());
  }

  /**
   * Test {@link ImmutableServerSummaryBasicStatistics#withVirtualCount(long)}.
   *
   * <p>Method under test: {@link ImmutableServerSummaryBasicStatistics#withVirtualCount(long)}
   */
  @Test
  @DisplayName("Test withVirtualCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerSummaryBasicStatistics ImmutableServerSummaryBasicStatistics.withVirtualCount(long)"
  })
  void testWithVirtualCount() {
    // Arrange
    ImmutableServerSummaryBasicStatistics immutableServerSummaryBasicStatistics =
        ImmutableServerSummaryBasicStatistics.builder().physicalCount(3L).virtualCount(42L).build();

    // Act
    ImmutableServerSummaryBasicStatistics actualWithVirtualCountResult =
        immutableServerSummaryBasicStatistics.withVirtualCount(42L);

    // Assert
    assertSame(immutableServerSummaryBasicStatistics, actualWithVirtualCountResult);
  }

  /**
   * Test {@link ImmutableServerSummaryBasicStatistics#withVirtualCount(long)}.
   *
   * <ul>
   *   <li>Then return physicalCount is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerSummaryBasicStatistics#withVirtualCount(long)}
   */
  @Test
  @DisplayName("Test withVirtualCount(long); then return physicalCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerSummaryBasicStatistics ImmutableServerSummaryBasicStatistics.withVirtualCount(long)"
  })
  void testWithVirtualCount_thenReturnPhysicalCountIsThree() {
    // Arrange and Act
    ImmutableServerSummaryBasicStatistics actualWithVirtualCountResult =
        ImmutableServerSummaryBasicStatistics.builder()
            .physicalCount(3L)
            .virtualCount(3L)
            .build()
            .withVirtualCount(42L);

    // Assert
    assertEquals(3L, actualWithVirtualCountResult.physicalCount());
    assertEquals(42L, actualWithVirtualCountResult.virtualCount());
    assertEquals(6L, actualWithVirtualCountResult.totalCount());
  }
}
