package org.finos.waltz.service.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.either.Either;
import org.finos.waltz.model.report_grid.ImmutableReportGridDerivedColumnDefinition;
import org.finos.waltz.model.report_grid.ReportGridDerivedColumnDefinition;
import org.finos.waltz.service.report_grid.ImmutableCompiledCalculatedColumn.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCompiledCalculatedColumnDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#expression(Either)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCompiledCalculatedColumn Builder.build()",
    "Builder Builder.expression(Either)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableCompiledCalculatedColumn.builder();
    ImmutableReportGridDerivedColumnDefinition column =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();
    ImmutableCompiledCalculatedColumn actualImmutableCompiledCalculatedColumn =
        actualBuilderResult.column(column).expression(null).build();

    // Assert
    assertNull(actualImmutableCompiledCalculatedColumn.expression());
    assertSame(column, actualImmutableCompiledCalculatedColumn.column());
  }

  /**
   * Test Builder {@link Builder#column(ReportGridDerivedColumnDefinition)}.
   *
   * <ul>
   *   <li>Then builder build expression is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#column(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test Builder column(ReportGridDerivedColumnDefinition); then builder build expression is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.column(ReportGridDerivedColumnDefinition)"})
  void testBuilderColumn_thenBuilderBuildExpressionIsNull() {
    // Arrange
    Builder builderResult = ImmutableCompiledCalculatedColumn.builder();
    ReportGridDerivedColumnDefinition column = mock(ReportGridDerivedColumnDefinition.class);

    // Act
    Builder actualColumnResult = builderResult.column(column);

    // Assert
    ImmutableCompiledCalculatedColumn immutableCompiledCalculatedColumn = builderResult.build();
    assertNull(immutableCompiledCalculatedColumn.expression());
    assertSame(builderResult, actualColumnResult);
    assertSame(column, immutableCompiledCalculatedColumn.column());
  }

  /**
   * Test Builder {@link Builder#from(CompiledCalculatedColumn)}.
   *
   * <p>Method under test: {@link Builder#from(CompiledCalculatedColumn)}
   */
  @Test
  @DisplayName("Test Builder from(CompiledCalculatedColumn)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CompiledCalculatedColumn)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableCompiledCalculatedColumn.builder();

    Builder builderResult2 = ImmutableCompiledCalculatedColumn.builder();
    ImmutableCompiledCalculatedColumn instance =
        builderResult2
            .column(
                ImmutableReportGridDerivedColumnDefinition.builder()
                    .columnDescription("Column Description")
                    .derivationScript("Derivation Script")
                    .displayName("Display Name")
                    .externalId("42")
                    .gridColumnId(1L)
                    .id(1L)
                    .position(1)
                    .build())
            .expression(mock(Either.class))
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableCompiledCalculatedColumn actualImmutableCompiledCalculatedColumn =
        builderResult.build();
    assertEquals(instance, actualImmutableCompiledCalculatedColumn);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CompiledCalculatedColumn)}.
   *
   * <p>Method under test: {@link Builder#from(CompiledCalculatedColumn)}
   */
  @Test
  @DisplayName("Test Builder from(CompiledCalculatedColumn)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CompiledCalculatedColumn)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableCompiledCalculatedColumn.builder();

    Builder builderResult2 = ImmutableCompiledCalculatedColumn.builder();
    ImmutableCompiledCalculatedColumn instance =
        builderResult2
            .column(
                ImmutableReportGridDerivedColumnDefinition.builder()
                    .columnDescription("Column Description")
                    .derivationScript("Derivation Script")
                    .displayName("Display Name")
                    .externalId("42")
                    .gridColumnId(1L)
                    .id(1L)
                    .position(1)
                    .build())
            .expression(null)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableCompiledCalculatedColumn actualImmutableCompiledCalculatedColumn =
        builderResult.build();
    assertEquals(instance, actualImmutableCompiledCalculatedColumn);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableCompiledCalculatedColumn#copyOf(CompiledCalculatedColumn)}.
   *
   * <ul>
   *   <li>Then column return {@link ImmutableReportGridDerivedColumnDefinition}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableCompiledCalculatedColumn#copyOf(CompiledCalculatedColumn)}
   */
  @Test
  @DisplayName(
      "Test copyOf(CompiledCalculatedColumn); then column return ImmutableReportGridDerivedColumnDefinition")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCompiledCalculatedColumn ImmutableCompiledCalculatedColumn.copyOf(CompiledCalculatedColumn)"
  })
  void testCopyOf_thenColumnReturnImmutableReportGridDerivedColumnDefinition() {
    // Arrange
    Builder builderResult = ImmutableCompiledCalculatedColumn.builder();
    ImmutableCompiledCalculatedColumn instance =
        builderResult
            .column(
                ImmutableReportGridDerivedColumnDefinition.builder()
                    .columnDescription("Column Description")
                    .derivationScript("Derivation Script")
                    .displayName("Display Name")
                    .externalId("42")
                    .gridColumnId(1L)
                    .id(1L)
                    .position(1)
                    .build())
            .expression(mock(Either.class))
            .build();

    // Act and Assert
    ReportGridDerivedColumnDefinition columnResult =
        ImmutableCompiledCalculatedColumn.copyOf(instance).column();
    assertTrue(columnResult instanceof ImmutableReportGridDerivedColumnDefinition);
    assertEquals("Column Description", columnResult.columnDescription());
    assertEquals("Derivation Script", columnResult.derivationScript());
    assertEquals("Display Name", columnResult.displayName());
    assertEquals(1, columnResult.position());
    assertEquals(1L, columnResult.gridColumnId().longValue());
    assertEquals(1L, columnResult.id().longValue());
    assertEquals(EntityKind.REPORT_GRID_DERIVED_COLUMN_DEFINITION, columnResult.kind());
  }

  /**
   * Test {@link ImmutableCompiledCalculatedColumn#equals(Object)}, and {@link
   * ImmutableCompiledCalculatedColumn#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCompiledCalculatedColumn#equals(Object)}
   *   <li>{@link ImmutableCompiledCalculatedColumn#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCompiledCalculatedColumn.equals(Object)",
    "int ImmutableCompiledCalculatedColumn.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableCompiledCalculatedColumn.builder();
    ImmutableCompiledCalculatedColumn immutableCompiledCalculatedColumn =
        builderResult
            .column(
                ImmutableReportGridDerivedColumnDefinition.builder()
                    .columnDescription("Column Description")
                    .derivationScript("Derivation Script")
                    .displayName("Display Name")
                    .externalId("42")
                    .gridColumnId(1L)
                    .id(1L)
                    .position(1)
                    .build())
            .expression(null)
            .build();

    Builder builderResult2 = ImmutableCompiledCalculatedColumn.builder();
    ImmutableCompiledCalculatedColumn immutableCompiledCalculatedColumn2 =
        builderResult2
            .column(
                ImmutableReportGridDerivedColumnDefinition.builder()
                    .columnDescription("Column Description")
                    .derivationScript("Derivation Script")
                    .displayName("Display Name")
                    .externalId("42")
                    .gridColumnId(1L)
                    .id(1L)
                    .position(1)
                    .build())
            .expression(null)
            .build();

    // Act and Assert
    assertEquals(immutableCompiledCalculatedColumn, immutableCompiledCalculatedColumn2);
    assertEquals(
        immutableCompiledCalculatedColumn.hashCode(),
        immutableCompiledCalculatedColumn2.hashCode());
  }

  /**
   * Test {@link ImmutableCompiledCalculatedColumn#equals(Object)}, and {@link
   * ImmutableCompiledCalculatedColumn#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCompiledCalculatedColumn#equals(Object)}
   *   <li>{@link ImmutableCompiledCalculatedColumn#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCompiledCalculatedColumn.equals(Object)",
    "int ImmutableCompiledCalculatedColumn.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableCompiledCalculatedColumn.builder();
    ImmutableCompiledCalculatedColumn immutableCompiledCalculatedColumn =
        builderResult
            .column(
                ImmutableReportGridDerivedColumnDefinition.builder()
                    .columnDescription("Column Description")
                    .derivationScript("Derivation Script")
                    .displayName("Display Name")
                    .externalId("42")
                    .gridColumnId(1L)
                    .id(1L)
                    .position(1)
                    .build())
            .expression(null)
            .build();

    // Act and Assert
    assertEquals(immutableCompiledCalculatedColumn, immutableCompiledCalculatedColumn);
    int expectedHashCodeResult = immutableCompiledCalculatedColumn.hashCode();
    assertEquals(expectedHashCodeResult, immutableCompiledCalculatedColumn.hashCode());
  }

  /**
   * Test {@link ImmutableCompiledCalculatedColumn#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCompiledCalculatedColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCompiledCalculatedColumn.equals(Object)",
    "int ImmutableCompiledCalculatedColumn.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableCompiledCalculatedColumn.builder();
    ImmutableCompiledCalculatedColumn immutableCompiledCalculatedColumn =
        builderResult
            .column(
                ImmutableReportGridDerivedColumnDefinition.builder()
                    .columnDescription("Display Name")
                    .derivationScript("Derivation Script")
                    .displayName("Display Name")
                    .externalId("42")
                    .gridColumnId(1L)
                    .id(1L)
                    .position(1)
                    .build())
            .expression(null)
            .build();

    Builder builderResult2 = ImmutableCompiledCalculatedColumn.builder();

    // Act and Assert
    assertNotEquals(
        immutableCompiledCalculatedColumn,
        builderResult2
            .column(
                ImmutableReportGridDerivedColumnDefinition.builder()
                    .columnDescription("Column Description")
                    .derivationScript("Derivation Script")
                    .displayName("Display Name")
                    .externalId("42")
                    .gridColumnId(1L)
                    .id(1L)
                    .position(1)
                    .build())
            .expression(null)
            .build());
  }

  /**
   * Test {@link ImmutableCompiledCalculatedColumn#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCompiledCalculatedColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCompiledCalculatedColumn.equals(Object)",
    "int ImmutableCompiledCalculatedColumn.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableCompiledCalculatedColumn.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .column(
                ImmutableReportGridDerivedColumnDefinition.builder()
                    .columnDescription("Column Description")
                    .derivationScript("Derivation Script")
                    .displayName("Display Name")
                    .externalId("42")
                    .gridColumnId(1L)
                    .id(1L)
                    .position(1)
                    .build())
            .expression(null)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableCompiledCalculatedColumn#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCompiledCalculatedColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCompiledCalculatedColumn.equals(Object)",
    "int ImmutableCompiledCalculatedColumn.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableCompiledCalculatedColumn.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .column(
                ImmutableReportGridDerivedColumnDefinition.builder()
                    .columnDescription("Column Description")
                    .derivationScript("Derivation Script")
                    .displayName("Display Name")
                    .externalId("42")
                    .gridColumnId(1L)
                    .id(1L)
                    .position(1)
                    .build())
            .expression(null)
            .build(),
        "Different type to ImmutableCompiledCalculatedColumn");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCompiledCalculatedColumn#toString()}
   *   <li>{@link ImmutableCompiledCalculatedColumn#column()}
   *   <li>{@link ImmutableCompiledCalculatedColumn#expression()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridDerivedColumnDefinition ImmutableCompiledCalculatedColumn.column()",
    "Either ImmutableCompiledCalculatedColumn.expression()",
    "String ImmutableCompiledCalculatedColumn.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableCompiledCalculatedColumn.builder();
    ImmutableCompiledCalculatedColumn immutableCompiledCalculatedColumn =
        builderResult
            .column(
                ImmutableReportGridDerivedColumnDefinition.builder()
                    .columnDescription("Column Description")
                    .derivationScript("Derivation Script")
                    .displayName("Display Name")
                    .externalId("42")
                    .gridColumnId(1L)
                    .id(1L)
                    .position(1)
                    .build())
            .expression(null)
            .build();

    // Act
    String actualToStringResult = immutableCompiledCalculatedColumn.toString();
    ReportGridDerivedColumnDefinition actualColumnResult =
        immutableCompiledCalculatedColumn.column();

    // Assert
    assertTrue(actualColumnResult instanceof ImmutableReportGridDerivedColumnDefinition);
    assertEquals(
        "CompiledCalculatedColumn{column=ReportGridDerivedColumnDefinition{externalId=42, id=1, gridColumnId=1,"
            + " displayName=Display Name, columnDescription=Column Description, position=1, derivationScript=Derivation"
            + " Script}}",
        actualToStringResult);
    assertNull(immutableCompiledCalculatedColumn.expression());
  }

  /**
   * Test {@link ImmutableCompiledCalculatedColumn#withColumn(ReportGridDerivedColumnDefinition)}.
   *
   * <p>Method under test: {@link
   * ImmutableCompiledCalculatedColumn#withColumn(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName("Test withColumn(ReportGridDerivedColumnDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCompiledCalculatedColumn ImmutableCompiledCalculatedColumn.withColumn(ReportGridDerivedColumnDefinition)"
  })
  void testWithColumn() {
    // Arrange
    Builder builderResult = ImmutableCompiledCalculatedColumn.builder();
    ImmutableCompiledCalculatedColumn immutableCompiledCalculatedColumn =
        builderResult
            .column(
                ImmutableReportGridDerivedColumnDefinition.builder()
                    .columnDescription("Column Description")
                    .derivationScript("Derivation Script")
                    .displayName("Display Name")
                    .externalId("42")
                    .gridColumnId(1L)
                    .id(1L)
                    .position(1)
                    .build())
            .expression(mock(Either.class))
            .build();

    // Act
    ImmutableCompiledCalculatedColumn actualWithColumnResult =
        immutableCompiledCalculatedColumn.withColumn(
            ImmutableReportGridDerivedColumnDefinition.builder()
                .columnDescription("Column Description")
                .derivationScript("Derivation Script")
                .displayName("Display Name")
                .externalId("42")
                .gridColumnId(1L)
                .id(1L)
                .position(1)
                .build());

    // Assert
    assertEquals(immutableCompiledCalculatedColumn, actualWithColumnResult);
  }

  /**
   * Test {@link ImmutableCompiledCalculatedColumn#withExpression(Either)}.
   *
   * <p>Method under test: {@link ImmutableCompiledCalculatedColumn#withExpression(Either)}
   */
  @Test
  @DisplayName("Test withExpression(Either)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCompiledCalculatedColumn ImmutableCompiledCalculatedColumn.withExpression(Either)"
  })
  void testWithExpression() {
    // Arrange
    Builder builderResult = ImmutableCompiledCalculatedColumn.builder();
    ImmutableCompiledCalculatedColumn immutableCompiledCalculatedColumn =
        builderResult
            .column(
                ImmutableReportGridDerivedColumnDefinition.builder()
                    .columnDescription("Column Description")
                    .derivationScript("Derivation Script")
                    .displayName("Display Name")
                    .externalId("42")
                    .gridColumnId(1L)
                    .id(1L)
                    .position(1)
                    .build())
            .expression(mock(Either.class))
            .build();

    // Act
    ImmutableCompiledCalculatedColumn actualWithExpressionResult =
        immutableCompiledCalculatedColumn.withExpression(mock(Either.class));

    // Assert
    assertEquals(immutableCompiledCalculatedColumn, actualWithExpressionResult);
  }
}
