package org.finos.waltz.jobs.clients.c1.sc1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.clients.c1.sc1.model.ImmutableFlowRow.Builder;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowRowDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#endDate(String)}
   *   <li>{@link Builder#startDate(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowRow Builder.build()",
    "Builder Builder.endDate(String)",
    "Builder Builder.startDate(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableFlowRow actualImmutableFlowRow =
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("Source App Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Target App Name")
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutableFlowRow.endDate());
    assertEquals("2020-03-01", actualImmutableFlowRow.startDate());
    assertEquals("Source App Name", actualImmutableFlowRow.sourceAppName());
    assertEquals("Target App Name", actualImmutableFlowRow.targetAppName());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualImmutableFlowRow.status());
  }

  /**
   * Test Builder {@link Builder#from(FlowRow)}.
   *
   * <p>Method under test: {@link Builder#from(FlowRow)}
   */
  @Test
  @DisplayName("Test Builder from(FlowRow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowRow)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableFlowRow.builder();
    ImmutableFlowRow instance =
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("Source App Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Target App Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableFlowRow actualImmutableFlowRow = builderResult.build();
    assertEquals(instance, actualImmutableFlowRow);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FlowRow)}.
   *
   * <p>Method under test: {@link Builder#from(FlowRow)}
   */
  @Test
  @DisplayName("Test Builder from(FlowRow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowRow)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableFlowRow.builder();
    ImmutableFlowRow instance =
        ImmutableFlowRow.builder()
            .endDate(null)
            .sourceAppName("Source App Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Target App Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableFlowRow actualImmutableFlowRow = builderResult.build();
    assertEquals(instance, actualImmutableFlowRow);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FlowRow)}.
   *
   * <p>Method under test: {@link Builder#from(FlowRow)}
   */
  @Test
  @DisplayName("Test Builder from(FlowRow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowRow)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableFlowRow.builder();
    ImmutableFlowRow instance =
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("Source App Name")
            .startDate(null)
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Target App Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableFlowRow actualImmutableFlowRow = builderResult.build();
    assertEquals(instance, actualImmutableFlowRow);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#sourceAppName(String)}.
   *
   * <ul>
   *   <li>When {@code Source App Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#sourceAppName(String)}
   */
  @Test
  @DisplayName("Test Builder sourceAppName(String); when 'Source App Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.sourceAppName(String)"})
  void testBuilderSourceAppName_whenSourceAppName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowRow.builder();

    // Act
    Builder actualSourceAppNameResult = builderResult.sourceAppName("Source App Name");

    // Assert
    assertSame(builderResult, actualSourceAppNameResult);
  }

  /**
   * Test Builder {@link Builder#status(EntityLifecycleStatus)}.
   *
   * <p>Method under test: {@link Builder#status(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test Builder status(EntityLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.status(EntityLifecycleStatus)"})
  void testBuilderStatus() {
    // Arrange
    Builder builderResult = ImmutableFlowRow.builder();

    // Act
    Builder actualStatusResult = builderResult.status(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertSame(builderResult, actualStatusResult);
  }

  /**
   * Test Builder {@link Builder#targetAppName(String)}.
   *
   * <ul>
   *   <li>When {@code Target App Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#targetAppName(String)}
   */
  @Test
  @DisplayName("Test Builder targetAppName(String); when 'Target App Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.targetAppName(String)"})
  void testBuilderTargetAppName_whenTargetAppName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowRow.builder();

    // Act
    Builder actualTargetAppNameResult = builderResult.targetAppName("Target App Name");

    // Assert
    assertSame(builderResult, actualTargetAppNameResult);
  }

  /**
   * Test {@link ImmutableFlowRow#copyOf(FlowRow)}.
   *
   * <ul>
   *   <li>Then return endDate is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowRow#copyOf(FlowRow)}
   */
  @Test
  @DisplayName("Test copyOf(FlowRow); then return endDate is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowRow ImmutableFlowRow.copyOf(FlowRow)"})
  void testCopyOf_thenReturnEndDateIs20200301() {
    // Arrange
    ImmutableFlowRow instance =
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("Source App Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Target App Name")
            .build();

    // Act
    ImmutableFlowRow actualCopyOfResult = ImmutableFlowRow.copyOf(instance);

    // Assert
    assertEquals("2020-03-01", actualCopyOfResult.endDate());
    assertEquals("2020-03-01", actualCopyOfResult.startDate());
    assertEquals("Source App Name", actualCopyOfResult.sourceAppName());
    assertEquals("Target App Name", actualCopyOfResult.targetAppName());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.status());
  }

  /**
   * Test {@link ImmutableFlowRow#equals(Object)}, and {@link ImmutableFlowRow#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowRow#equals(Object)}
   *   <li>{@link ImmutableFlowRow#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableFlowRow.equals(Object)", "int ImmutableFlowRow.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableFlowRow immutableFlowRow =
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("Source App Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Target App Name")
            .build();
    ImmutableFlowRow immutableFlowRow2 =
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("Source App Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Target App Name")
            .build();

    // Act and Assert
    assertEquals(immutableFlowRow, immutableFlowRow2);
    assertEquals(immutableFlowRow.hashCode(), immutableFlowRow2.hashCode());
  }

  /**
   * Test {@link ImmutableFlowRow#equals(Object)}, and {@link ImmutableFlowRow#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowRow#equals(Object)}
   *   <li>{@link ImmutableFlowRow#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableFlowRow.equals(Object)", "int ImmutableFlowRow.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableFlowRow immutableFlowRow =
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("Source App Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Target App Name")
            .build();

    // Act and Assert
    assertEquals(immutableFlowRow, immutableFlowRow);
    int expectedHashCodeResult = immutableFlowRow.hashCode();
    assertEquals(expectedHashCodeResult, immutableFlowRow.hashCode());
  }

  /**
   * Test {@link ImmutableFlowRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableFlowRow.equals(Object)", "int ImmutableFlowRow.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableFlowRow immutableFlowRow =
        ImmutableFlowRow.builder()
            .endDate("2020/03/01")
            .sourceAppName("Source App Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Target App Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowRow,
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("Source App Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Target App Name")
            .build());
  }

  /**
   * Test {@link ImmutableFlowRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableFlowRow.equals(Object)", "int ImmutableFlowRow.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableFlowRow immutableFlowRow =
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("Target App Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Target App Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowRow,
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("Source App Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Target App Name")
            .build());
  }

  /**
   * Test {@link ImmutableFlowRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableFlowRow.equals(Object)", "int ImmutableFlowRow.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableFlowRow immutableFlowRow =
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("Source App Name")
            .startDate("2020/03/01")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Target App Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowRow,
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("Source App Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Target App Name")
            .build());
  }

  /**
   * Test {@link ImmutableFlowRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableFlowRow.equals(Object)", "int ImmutableFlowRow.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableFlowRow immutableFlowRow =
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("Source App Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.PENDING)
            .targetAppName("Target App Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowRow,
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("Source App Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Target App Name")
            .build());
  }

  /**
   * Test {@link ImmutableFlowRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableFlowRow.equals(Object)", "int ImmutableFlowRow.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableFlowRow immutableFlowRow =
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("Source App Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Source App Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowRow,
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("Source App Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Target App Name")
            .build());
  }

  /**
   * Test {@link ImmutableFlowRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableFlowRow.equals(Object)", "int ImmutableFlowRow.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("Source App Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Target App Name")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableFlowRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableFlowRow.equals(Object)", "int ImmutableFlowRow.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("Source App Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Target App Name")
            .build(),
        "Different type to ImmutableFlowRow");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowRow#toString()}
   *   <li>{@link ImmutableFlowRow#endDate()}
   *   <li>{@link ImmutableFlowRow#sourceAppName()}
   *   <li>{@link ImmutableFlowRow#startDate()}
   *   <li>{@link ImmutableFlowRow#status()}
   *   <li>{@link ImmutableFlowRow#targetAppName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableFlowRow.endDate()",
    "String ImmutableFlowRow.sourceAppName()",
    "String ImmutableFlowRow.startDate()",
    "EntityLifecycleStatus ImmutableFlowRow.status()",
    "String ImmutableFlowRow.targetAppName()",
    "String ImmutableFlowRow.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableFlowRow immutableFlowRow =
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("Source App Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Target App Name")
            .build();

    // Act
    String actualToStringResult = immutableFlowRow.toString();
    String actualEndDateResult = immutableFlowRow.endDate();
    String actualSourceAppNameResult = immutableFlowRow.sourceAppName();
    String actualStartDateResult = immutableFlowRow.startDate();
    EntityLifecycleStatus actualStatusResult = immutableFlowRow.status();

    // Assert
    assertEquals("2020-03-01", actualEndDateResult);
    assertEquals("2020-03-01", actualStartDateResult);
    assertEquals(
        "FlowRow{sourceAppName=Source App Name, targetAppName=Target App Name, status=ACTIVE, startDate=2020-03-01,"
            + " endDate=2020-03-01}",
        actualToStringResult);
    assertEquals("Source App Name", actualSourceAppNameResult);
    assertEquals("Target App Name", immutableFlowRow.targetAppName());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualStatusResult);
  }

  /**
   * Test {@link ImmutableFlowRow#withEndDate(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowRow#withEndDate(String)}
   */
  @Test
  @DisplayName("Test withEndDate(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowRow ImmutableFlowRow.withEndDate(String)"})
  void testWithEndDate() {
    // Arrange
    ImmutableFlowRow immutableFlowRow =
        ImmutableFlowRow.builder()
            .endDate("42")
            .sourceAppName("Source App Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Target App Name")
            .build();

    // Act
    ImmutableFlowRow actualWithEndDateResult = immutableFlowRow.withEndDate("42");

    // Assert
    assertSame(immutableFlowRow, actualWithEndDateResult);
  }

  /**
   * Test {@link ImmutableFlowRow#withEndDate(String)}.
   *
   * <ul>
   *   <li>Then return startDate is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowRow#withEndDate(String)}
   */
  @Test
  @DisplayName("Test withEndDate(String); then return startDate is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowRow ImmutableFlowRow.withEndDate(String)"})
  void testWithEndDate_thenReturnStartDateIs20200301() {
    // Arrange and Act
    ImmutableFlowRow actualWithEndDateResult =
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("Source App Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Target App Name")
            .build()
            .withEndDate("42");

    // Assert
    assertEquals("2020-03-01", actualWithEndDateResult.startDate());
    assertEquals("42", actualWithEndDateResult.endDate());
    assertEquals("Source App Name", actualWithEndDateResult.sourceAppName());
    assertEquals("Target App Name", actualWithEndDateResult.targetAppName());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithEndDateResult.status());
  }

  /**
   * Test {@link ImmutableFlowRow#withSourceAppName(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowRow#withSourceAppName(String)}
   */
  @Test
  @DisplayName("Test withSourceAppName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowRow ImmutableFlowRow.withSourceAppName(String)"})
  void testWithSourceAppName() {
    // Arrange
    ImmutableFlowRow immutableFlowRow =
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("42")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Target App Name")
            .build();

    // Act
    ImmutableFlowRow actualWithSourceAppNameResult = immutableFlowRow.withSourceAppName("42");

    // Assert
    assertSame(immutableFlowRow, actualWithSourceAppNameResult);
  }

  /**
   * Test {@link ImmutableFlowRow#withSourceAppName(String)}.
   *
   * <ul>
   *   <li>Then return endDate is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowRow#withSourceAppName(String)}
   */
  @Test
  @DisplayName("Test withSourceAppName(String); then return endDate is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowRow ImmutableFlowRow.withSourceAppName(String)"})
  void testWithSourceAppName_thenReturnEndDateIs20200301() {
    // Arrange and Act
    ImmutableFlowRow actualWithSourceAppNameResult =
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("Source App Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Target App Name")
            .build()
            .withSourceAppName("42");

    // Assert
    assertEquals("2020-03-01", actualWithSourceAppNameResult.endDate());
    assertEquals("2020-03-01", actualWithSourceAppNameResult.startDate());
    assertEquals("42", actualWithSourceAppNameResult.sourceAppName());
    assertEquals("Target App Name", actualWithSourceAppNameResult.targetAppName());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithSourceAppNameResult.status());
  }

  /**
   * Test {@link ImmutableFlowRow#withStartDate(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowRow#withStartDate(String)}
   */
  @Test
  @DisplayName("Test withStartDate(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowRow ImmutableFlowRow.withStartDate(String)"})
  void testWithStartDate() {
    // Arrange
    ImmutableFlowRow immutableFlowRow =
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("Source App Name")
            .startDate("42")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Target App Name")
            .build();

    // Act
    ImmutableFlowRow actualWithStartDateResult = immutableFlowRow.withStartDate("42");

    // Assert
    assertSame(immutableFlowRow, actualWithStartDateResult);
  }

  /**
   * Test {@link ImmutableFlowRow#withStartDate(String)}.
   *
   * <ul>
   *   <li>Then return endDate is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowRow#withStartDate(String)}
   */
  @Test
  @DisplayName("Test withStartDate(String); then return endDate is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowRow ImmutableFlowRow.withStartDate(String)"})
  void testWithStartDate_thenReturnEndDateIs20200301() {
    // Arrange and Act
    ImmutableFlowRow actualWithStartDateResult =
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("Source App Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Target App Name")
            .build()
            .withStartDate("42");

    // Assert
    assertEquals("2020-03-01", actualWithStartDateResult.endDate());
    assertEquals("42", actualWithStartDateResult.startDate());
    assertEquals("Source App Name", actualWithStartDateResult.sourceAppName());
    assertEquals("Target App Name", actualWithStartDateResult.targetAppName());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithStartDateResult.status());
  }

  /**
   * Test {@link ImmutableFlowRow#withStatus(EntityLifecycleStatus)}.
   *
   * <p>Method under test: {@link ImmutableFlowRow#withStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test withStatus(EntityLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowRow ImmutableFlowRow.withStatus(EntityLifecycleStatus)"})
  void testWithStatus() {
    // Arrange
    ImmutableFlowRow immutableFlowRow =
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("Source App Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Target App Name")
            .build();

    // Act
    ImmutableFlowRow actualWithStatusResult =
        immutableFlowRow.withStatus(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertSame(immutableFlowRow, actualWithStatusResult);
  }

  /**
   * Test {@link ImmutableFlowRow#withStatus(EntityLifecycleStatus)}.
   *
   * <ul>
   *   <li>Then return endDate is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowRow#withStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test withStatus(EntityLifecycleStatus); then return endDate is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowRow ImmutableFlowRow.withStatus(EntityLifecycleStatus)"})
  void testWithStatus_thenReturnEndDateIs20200301() {
    // Arrange and Act
    ImmutableFlowRow actualWithStatusResult =
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("Source App Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.PENDING)
            .targetAppName("Target App Name")
            .build()
            .withStatus(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertEquals("2020-03-01", actualWithStatusResult.endDate());
    assertEquals("2020-03-01", actualWithStatusResult.startDate());
    assertEquals("Source App Name", actualWithStatusResult.sourceAppName());
    assertEquals("Target App Name", actualWithStatusResult.targetAppName());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithStatusResult.status());
  }

  /**
   * Test {@link ImmutableFlowRow#withTargetAppName(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowRow#withTargetAppName(String)}
   */
  @Test
  @DisplayName("Test withTargetAppName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowRow ImmutableFlowRow.withTargetAppName(String)"})
  void testWithTargetAppName() {
    // Arrange
    ImmutableFlowRow immutableFlowRow =
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("Source App Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("42")
            .build();

    // Act
    ImmutableFlowRow actualWithTargetAppNameResult = immutableFlowRow.withTargetAppName("42");

    // Assert
    assertSame(immutableFlowRow, actualWithTargetAppNameResult);
  }

  /**
   * Test {@link ImmutableFlowRow#withTargetAppName(String)}.
   *
   * <ul>
   *   <li>Then return endDate is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowRow#withTargetAppName(String)}
   */
  @Test
  @DisplayName("Test withTargetAppName(String); then return endDate is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowRow ImmutableFlowRow.withTargetAppName(String)"})
  void testWithTargetAppName_thenReturnEndDateIs20200301() {
    // Arrange and Act
    ImmutableFlowRow actualWithTargetAppNameResult =
        ImmutableFlowRow.builder()
            .endDate("2020-03-01")
            .sourceAppName("Source App Name")
            .startDate("2020-03-01")
            .status(EntityLifecycleStatus.ACTIVE)
            .targetAppName("Target App Name")
            .build()
            .withTargetAppName("42");

    // Assert
    assertEquals("2020-03-01", actualWithTargetAppNameResult.endDate());
    assertEquals("2020-03-01", actualWithTargetAppNameResult.startDate());
    assertEquals("42", actualWithTargetAppNameResult.targetAppName());
    assertEquals("Source App Name", actualWithTargetAppNameResult.sourceAppName());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithTargetAppNameResult.status());
  }
}
