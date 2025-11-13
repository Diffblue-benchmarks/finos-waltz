package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.report_grid.ImmutableReportGridDerivedColumnDefinition.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridDerivedColumnDefinition.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridDerivedColumnDefinitionDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#columnDescription(String)}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#gridColumnId(Long)}
   *   <li>{@link Builder#id(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDerivedColumnDefinition Builder.build()",
    "Builder Builder.columnDescription(String)",
    "Builder Builder.externalId(String)",
    "Builder Builder.gridColumnId(Long)",
    "Builder Builder.id(Long)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42");
    Optional<String> externalId = Optional.of("42");
    ImmutableReportGridDerivedColumnDefinition actualImmutableReportGridDerivedColumnDefinition =
        actualExternalIdResult.externalId(externalId).gridColumnId(1L).id(1L).position(1).build();

    // Assert
    assertEquals(
        "Column Description", actualImmutableReportGridDerivedColumnDefinition.columnDescription());
    assertEquals(
        "Derivation Script", actualImmutableReportGridDerivedColumnDefinition.derivationScript());
    assertEquals("Display Name", actualImmutableReportGridDerivedColumnDefinition.displayName());
    assertEquals(1, actualImmutableReportGridDerivedColumnDefinition.position());
    assertEquals(1L, actualImmutableReportGridDerivedColumnDefinition.gridColumnId().longValue());
    assertEquals(1L, actualImmutableReportGridDerivedColumnDefinition.id().longValue());
    assertEquals(
        EntityKind.REPORT_GRID_DERIVED_COLUMN_DEFINITION,
        actualImmutableReportGridDerivedColumnDefinition.kind());
  }

  /**
   * Test Builder {@link Builder#derivationScript(String)}.
   *
   * <ul>
   *   <li>When {@code Derivation Script}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#derivationScript(String)}
   */
  @Test
  @DisplayName(
      "Test Builder derivationScript(String); when 'Derivation Script'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.derivationScript(String)"})
  void testBuilderDerivationScript_whenDerivationScript_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridDerivedColumnDefinition.builder();

    // Act
    Builder actualDerivationScriptResult = builderResult.derivationScript("Derivation Script");

    // Assert
    assertSame(builderResult, actualDerivationScriptResult);
  }

  /**
   * Test Builder {@link Builder#displayName(String)}.
   *
   * <ul>
   *   <li>When {@code Display Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#displayName(String)}
   */
  @Test
  @DisplayName("Test Builder displayName(String); when 'Display Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.displayName(String)"})
  void testBuilderDisplayName_whenDisplayName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridDerivedColumnDefinition.builder();

    // Act
    Builder actualDisplayNameResult = builderResult.displayName("Display Name");

    // Assert
    assertSame(builderResult, actualDisplayNameResult);
  }

  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableReportGridDerivedColumnDefinition.builder();
    Optional<String> externalId = Optional.of("42");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider() {
    // Arrange
    Builder builderResult = ImmutableReportGridDerivedColumnDefinition.builder();
    ImmutableReportGridDerivedColumnDefinition instance =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableReportGridDerivedColumnDefinition actualImmutableReportGridDerivedColumnDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutableReportGridDerivedColumnDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableReportGridDerivedColumnDefinition.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Given of {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given of '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenOf42() {
    // Arrange
    Builder builderResult = ImmutableReportGridDerivedColumnDefinition.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("42");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableReportGridDerivedColumnDefinition.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Test Builder {@link Builder#from(ReportGridDerivedColumnDefinition)} with {@code
   * ReportGridDerivedColumnDefinition}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ReportGridDerivedColumnDefinition) with 'ReportGridDerivedColumnDefinition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridDerivedColumnDefinition)"})
  void testBuilderFromWithReportGridDerivedColumnDefinition() {
    // Arrange
    Builder builderResult = ImmutableReportGridDerivedColumnDefinition.builder();
    ImmutableReportGridDerivedColumnDefinition instance =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableReportGridDerivedColumnDefinition actualImmutableReportGridDerivedColumnDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutableReportGridDerivedColumnDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridDerivedColumnDefinition)} with {@code
   * ReportGridDerivedColumnDefinition}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ReportGridDerivedColumnDefinition) with 'ReportGridDerivedColumnDefinition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridDerivedColumnDefinition)"})
  void testBuilderFromWithReportGridDerivedColumnDefinition2() {
    // Arrange
    Builder builderResult = ImmutableReportGridDerivedColumnDefinition.builder();
    ImmutableReportGridDerivedColumnDefinition instance =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription(null)
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableReportGridDerivedColumnDefinition actualImmutableReportGridDerivedColumnDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutableReportGridDerivedColumnDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridDerivedColumnDefinition)} with {@code
   * ReportGridDerivedColumnDefinition}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ReportGridDerivedColumnDefinition) with 'ReportGridDerivedColumnDefinition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridDerivedColumnDefinition)"})
  void testBuilderFromWithReportGridDerivedColumnDefinition3() {
    // Arrange
    Builder builderResult = ImmutableReportGridDerivedColumnDefinition.builder();
    ImmutableReportGridDerivedColumnDefinition instance =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(null)
            .id(1L)
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableReportGridDerivedColumnDefinition actualImmutableReportGridDerivedColumnDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutableReportGridDerivedColumnDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridDerivedColumnDefinition)} with {@code
   * ReportGridDerivedColumnDefinition}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ReportGridDerivedColumnDefinition) with 'ReportGridDerivedColumnDefinition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridDerivedColumnDefinition)"})
  void testBuilderFromWithReportGridDerivedColumnDefinition4() {
    // Arrange
    Builder builderResult = ImmutableReportGridDerivedColumnDefinition.builder();
    ImmutableReportGridDerivedColumnDefinition instance =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(null)
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableReportGridDerivedColumnDefinition actualImmutableReportGridDerivedColumnDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutableReportGridDerivedColumnDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#position(int)}.
   *
   * <p>Method under test: {@link Builder#position(int)}
   */
  @Test
  @DisplayName("Test Builder position(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.position(int)"})
  void testBuilderPosition() {
    // Arrange
    Builder builderResult = ImmutableReportGridDerivedColumnDefinition.builder();

    // Act
    Builder actualPositionResult = builderResult.position(1);

    // Assert
    assertSame(builderResult, actualPositionResult);
  }

  /**
   * Test {@link
   * ImmutableReportGridDerivedColumnDefinition#copyOf(ReportGridDerivedColumnDefinition)}.
   *
   * <ul>
   *   <li>Then return {@code Column Description}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableReportGridDerivedColumnDefinition#copyOf(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName("Test copyOf(ReportGridDerivedColumnDefinition); then return 'Column Description'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDerivedColumnDefinition ImmutableReportGridDerivedColumnDefinition.copyOf(ReportGridDerivedColumnDefinition)"
  })
  void testCopyOf_thenReturnColumnDescription() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition instance =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act
    ImmutableReportGridDerivedColumnDefinition actualCopyOfResult =
        ImmutableReportGridDerivedColumnDefinition.copyOf(instance);

    // Assert
    assertEquals("Column Description", actualCopyOfResult.columnDescription());
    assertEquals("Derivation Script", actualCopyOfResult.derivationScript());
    assertEquals("Display Name", actualCopyOfResult.displayName());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.gridColumnId().longValue());
    assertEquals(1L, actualCopyOfResult.id().longValue());
    assertEquals(EntityKind.REPORT_GRID_DERIVED_COLUMN_DEFINITION, actualCopyOfResult.kind());
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#equals(Object)}, and {@link
   * ImmutableReportGridDerivedColumnDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridDerivedColumnDefinition#equals(Object)}
   *   <li>{@link ImmutableReportGridDerivedColumnDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridDerivedColumnDefinition.equals(Object)",
    "int ImmutableReportGridDerivedColumnDefinition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition immutableReportGridDerivedColumnDefinition =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();
    ImmutableReportGridDerivedColumnDefinition immutableReportGridDerivedColumnDefinition2 =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act and Assert
    assertEquals(
        immutableReportGridDerivedColumnDefinition, immutableReportGridDerivedColumnDefinition2);
    assertEquals(
        immutableReportGridDerivedColumnDefinition.hashCode(),
        immutableReportGridDerivedColumnDefinition2.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#equals(Object)}, and {@link
   * ImmutableReportGridDerivedColumnDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridDerivedColumnDefinition#equals(Object)}
   *   <li>{@link ImmutableReportGridDerivedColumnDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridDerivedColumnDefinition.equals(Object)",
    "int ImmutableReportGridDerivedColumnDefinition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition immutableReportGridDerivedColumnDefinition =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act and Assert
    assertEquals(
        immutableReportGridDerivedColumnDefinition, immutableReportGridDerivedColumnDefinition);
    int expectedHashCodeResult = immutableReportGridDerivedColumnDefinition.hashCode();
    assertEquals(expectedHashCodeResult, immutableReportGridDerivedColumnDefinition.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDerivedColumnDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridDerivedColumnDefinition.equals(Object)",
    "int ImmutableReportGridDerivedColumnDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition immutableReportGridDerivedColumnDefinition =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Display Name")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridDerivedColumnDefinition,
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDerivedColumnDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridDerivedColumnDefinition.equals(Object)",
    "int ImmutableReportGridDerivedColumnDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition immutableReportGridDerivedColumnDefinition =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Display Name")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridDerivedColumnDefinition,
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDerivedColumnDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridDerivedColumnDefinition.equals(Object)",
    "int ImmutableReportGridDerivedColumnDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition immutableReportGridDerivedColumnDefinition =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Derivation Script")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridDerivedColumnDefinition,
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDerivedColumnDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridDerivedColumnDefinition.equals(Object)",
    "int ImmutableReportGridDerivedColumnDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition immutableReportGridDerivedColumnDefinition =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("Display Name")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridDerivedColumnDefinition,
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDerivedColumnDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridDerivedColumnDefinition.equals(Object)",
    "int ImmutableReportGridDerivedColumnDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition immutableReportGridDerivedColumnDefinition =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(2L)
            .id(1L)
            .position(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridDerivedColumnDefinition,
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDerivedColumnDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridDerivedColumnDefinition.equals(Object)",
    "int ImmutableReportGridDerivedColumnDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition immutableReportGridDerivedColumnDefinition =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(2L)
            .position(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridDerivedColumnDefinition,
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDerivedColumnDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridDerivedColumnDefinition.equals(Object)",
    "int ImmutableReportGridDerivedColumnDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition immutableReportGridDerivedColumnDefinition =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(0)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridDerivedColumnDefinition,
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDerivedColumnDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridDerivedColumnDefinition.equals(Object)",
    "int ImmutableReportGridDerivedColumnDefinition.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDerivedColumnDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridDerivedColumnDefinition.equals(Object)",
    "int ImmutableReportGridDerivedColumnDefinition.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build(),
        "Different type to ImmutableReportGridDerivedColumnDefinition");
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#externalId()}.
   *
   * <p>Method under test: {@link ImmutableReportGridDerivedColumnDefinition#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableReportGridDerivedColumnDefinition.externalId()"})
  void testExternalId() {
    // Arrange and Act
    Optional<String> actualExternalIdResult =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridDerivedColumnDefinition#columnDescription()}
   *   <li>{@link ImmutableReportGridDerivedColumnDefinition#derivationScript()}
   *   <li>{@link ImmutableReportGridDerivedColumnDefinition#displayName()}
   *   <li>{@link ImmutableReportGridDerivedColumnDefinition#gridColumnId()}
   *   <li>{@link ImmutableReportGridDerivedColumnDefinition#id()}
   *   <li>{@link ImmutableReportGridDerivedColumnDefinition#position()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableReportGridDerivedColumnDefinition.columnDescription()",
    "String ImmutableReportGridDerivedColumnDefinition.derivationScript()",
    "String ImmutableReportGridDerivedColumnDefinition.displayName()",
    "Long ImmutableReportGridDerivedColumnDefinition.gridColumnId()",
    "Long ImmutableReportGridDerivedColumnDefinition.id()",
    "int ImmutableReportGridDerivedColumnDefinition.position()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition immutableReportGridDerivedColumnDefinition =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act
    String actualColumnDescriptionResult =
        immutableReportGridDerivedColumnDefinition.columnDescription();
    String actualDerivationScriptResult =
        immutableReportGridDerivedColumnDefinition.derivationScript();
    String actualDisplayNameResult = immutableReportGridDerivedColumnDefinition.displayName();
    Long actualGridColumnIdResult = immutableReportGridDerivedColumnDefinition.gridColumnId();
    Long actualIdResult = immutableReportGridDerivedColumnDefinition.id();

    // Assert
    assertEquals("Column Description", actualColumnDescriptionResult);
    assertEquals("Derivation Script", actualDerivationScriptResult);
    assertEquals("Display Name", actualDisplayNameResult);
    assertEquals(1, immutableReportGridDerivedColumnDefinition.position());
    assertEquals(1L, actualGridColumnIdResult.longValue());
    assertEquals(1L, actualIdResult.longValue());
  }

  /**
   * Test Json {@link Json#columnDescription()}.
   *
   * <p>Method under test: {@link Json#columnDescription()}
   */
  @Test
  @DisplayName("Test Json columnDescription()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.columnDescription()"})
  void testJsonColumnDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().columnDescription());
  }

  /**
   * Test Json {@link Json#derivationScript()}.
   *
   * <p>Method under test: {@link Json#derivationScript()}
   */
  @Test
  @DisplayName("Test Json derivationScript()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.derivationScript()"})
  void testJsonDerivationScript() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().derivationScript());
  }

  /**
   * Test Json {@link Json#displayName()}.
   *
   * <p>Method under test: {@link Json#displayName()}
   */
  @Test
  @DisplayName("Test Json displayName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.displayName()"})
  void testJsonDisplayName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().displayName());
  }

  /**
   * Test Json {@link Json#externalId()}.
   *
   * <p>Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().externalId());
  }

  /**
   * Test Json {@link Json#gridColumnId()}.
   *
   * <p>Method under test: {@link Json#gridColumnId()}
   */
  @Test
  @DisplayName("Test Json gridColumnId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.gridColumnId()"})
  void testJsonGridColumnId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().gridColumnId());
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
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
    assertNull(actualJson.gridColumnId);
    assertNull(actualJson.id);
    assertNull(actualJson.columnDescription);
    assertNull(actualJson.derivationScript);
    assertNull(actualJson.displayName);
    assertEquals(0, actualJson.position);
    assertEquals(EntityKind.REPORT_GRID_DERIVED_COLUMN_DEFINITION, actualJson.kind());
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.positionIsSet);
  }

  /**
   * Test Json {@link Json#position()}.
   *
   * <p>Method under test: {@link Json#position()}
   */
  @Test
  @DisplayName("Test Json position()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.position()"})
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().position());
  }

  /**
   * Test Json {@link Json#setPosition(int)}.
   *
   * <p>Method under test: {@link Json#setPosition(int)}
   */
  @Test
  @DisplayName("Test Json setPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setPosition(int)"})
  void testJsonSetPosition() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#toString()}.
   *
   * <p>Method under test: {@link ImmutableReportGridDerivedColumnDefinition#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableReportGridDerivedColumnDefinition.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "ReportGridDerivedColumnDefinition{externalId=42, id=1, gridColumnId=1, displayName=Display Name,"
            + " columnDescription=Column Description, position=1, derivationScript=Derivation Script}",
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#toString()}.
   *
   * <p>Method under test: {@link ImmutableReportGridDerivedColumnDefinition#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableReportGridDerivedColumnDefinition.toString()"})
  void testToString2() {
    // Arrange, Act and Assert
    assertEquals(
        "ReportGridDerivedColumnDefinition{externalId=42, id=1, gridColumnId=1, displayName=Display Name,"
            + " position=1, derivationScript=Derivation Script}",
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription(null)
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#toString()}.
   *
   * <p>Method under test: {@link ImmutableReportGridDerivedColumnDefinition#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableReportGridDerivedColumnDefinition.toString()"})
  void testToString3() {
    // Arrange, Act and Assert
    assertEquals(
        "ReportGridDerivedColumnDefinition{externalId=42, id=1, displayName=Display Name, columnDescription=Column"
            + " Description, position=1, derivationScript=Derivation Script}",
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(null)
            .id(1L)
            .position(1)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#toString()}.
   *
   * <p>Method under test: {@link ImmutableReportGridDerivedColumnDefinition#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableReportGridDerivedColumnDefinition.toString()"})
  void testToString4() {
    // Arrange, Act and Assert
    assertEquals(
        "ReportGridDerivedColumnDefinition{externalId=42, gridColumnId=1, displayName=Display Name, columnDescription"
            + "=Column Description, position=1, derivationScript=Derivation Script}",
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(null)
            .position(1)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#withColumnDescription(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableReportGridDerivedColumnDefinition#withColumnDescription(String)}
   */
  @Test
  @DisplayName("Test withColumnDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDerivedColumnDefinition ImmutableReportGridDerivedColumnDefinition.withColumnDescription(String)"
  })
  void testWithColumnDescription() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition immutableReportGridDerivedColumnDefinition =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("42")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act
    ImmutableReportGridDerivedColumnDefinition actualWithColumnDescriptionResult =
        immutableReportGridDerivedColumnDefinition.withColumnDescription("42");

    // Assert
    assertSame(immutableReportGridDerivedColumnDefinition, actualWithColumnDescriptionResult);
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#withColumnDescription(String)}.
   *
   * <ul>
   *   <li>Then return columnDescription is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableReportGridDerivedColumnDefinition#withColumnDescription(String)}
   */
  @Test
  @DisplayName("Test withColumnDescription(String); then return columnDescription is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDerivedColumnDefinition ImmutableReportGridDerivedColumnDefinition.withColumnDescription(String)"
  })
  void testWithColumnDescription_thenReturnColumnDescriptionIs42() {
    // Arrange and Act
    ImmutableReportGridDerivedColumnDefinition actualWithColumnDescriptionResult =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .withColumnDescription("42");

    // Assert
    assertEquals("42", actualWithColumnDescriptionResult.columnDescription());
    assertEquals("Derivation Script", actualWithColumnDescriptionResult.derivationScript());
    assertEquals("Display Name", actualWithColumnDescriptionResult.displayName());
    assertEquals(1, actualWithColumnDescriptionResult.position());
    assertEquals(1L, actualWithColumnDescriptionResult.gridColumnId().longValue());
    assertEquals(1L, actualWithColumnDescriptionResult.id().longValue());
    assertEquals(
        EntityKind.REPORT_GRID_DERIVED_COLUMN_DEFINITION, actualWithColumnDescriptionResult.kind());
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#withDerivationScript(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableReportGridDerivedColumnDefinition#withDerivationScript(String)}
   */
  @Test
  @DisplayName("Test withDerivationScript(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDerivedColumnDefinition ImmutableReportGridDerivedColumnDefinition.withDerivationScript(String)"
  })
  void testWithDerivationScript() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition immutableReportGridDerivedColumnDefinition =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("42")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act
    ImmutableReportGridDerivedColumnDefinition actualWithDerivationScriptResult =
        immutableReportGridDerivedColumnDefinition.withDerivationScript("42");

    // Assert
    assertSame(immutableReportGridDerivedColumnDefinition, actualWithDerivationScriptResult);
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#withDerivationScript(String)}.
   *
   * <ul>
   *   <li>Then return derivationScript is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableReportGridDerivedColumnDefinition#withDerivationScript(String)}
   */
  @Test
  @DisplayName("Test withDerivationScript(String); then return derivationScript is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDerivedColumnDefinition ImmutableReportGridDerivedColumnDefinition.withDerivationScript(String)"
  })
  void testWithDerivationScript_thenReturnDerivationScriptIs42() {
    // Arrange and Act
    ImmutableReportGridDerivedColumnDefinition actualWithDerivationScriptResult =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .withDerivationScript("42");

    // Assert
    assertEquals("42", actualWithDerivationScriptResult.derivationScript());
    assertEquals("Column Description", actualWithDerivationScriptResult.columnDescription());
    assertEquals("Display Name", actualWithDerivationScriptResult.displayName());
    assertEquals(1, actualWithDerivationScriptResult.position());
    assertEquals(1L, actualWithDerivationScriptResult.gridColumnId().longValue());
    assertEquals(1L, actualWithDerivationScriptResult.id().longValue());
    assertEquals(
        EntityKind.REPORT_GRID_DERIVED_COLUMN_DEFINITION, actualWithDerivationScriptResult.kind());
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#withDisplayName(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableReportGridDerivedColumnDefinition#withDisplayName(String)}
   */
  @Test
  @DisplayName("Test withDisplayName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDerivedColumnDefinition ImmutableReportGridDerivedColumnDefinition.withDisplayName(String)"
  })
  void testWithDisplayName() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition immutableReportGridDerivedColumnDefinition =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("42")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act
    ImmutableReportGridDerivedColumnDefinition actualWithDisplayNameResult =
        immutableReportGridDerivedColumnDefinition.withDisplayName("42");

    // Assert
    assertSame(immutableReportGridDerivedColumnDefinition, actualWithDisplayNameResult);
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#withDisplayName(String)}.
   *
   * <ul>
   *   <li>Then return displayName is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableReportGridDerivedColumnDefinition#withDisplayName(String)}
   */
  @Test
  @DisplayName("Test withDisplayName(String); then return displayName is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDerivedColumnDefinition ImmutableReportGridDerivedColumnDefinition.withDisplayName(String)"
  })
  void testWithDisplayName_thenReturnDisplayNameIs42() {
    // Arrange and Act
    ImmutableReportGridDerivedColumnDefinition actualWithDisplayNameResult =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .withDisplayName("42");

    // Assert
    assertEquals("42", actualWithDisplayNameResult.displayName());
    assertEquals("Column Description", actualWithDisplayNameResult.columnDescription());
    assertEquals("Derivation Script", actualWithDisplayNameResult.derivationScript());
    assertEquals(1, actualWithDisplayNameResult.position());
    assertEquals(1L, actualWithDisplayNameResult.gridColumnId().longValue());
    assertEquals(1L, actualWithDisplayNameResult.id().longValue());
    assertEquals(
        EntityKind.REPORT_GRID_DERIVED_COLUMN_DEFINITION, actualWithDisplayNameResult.kind());
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#withExternalId(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link
   * ImmutableReportGridDerivedColumnDefinition#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDerivedColumnDefinition ImmutableReportGridDerivedColumnDefinition.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition immutableReportGridDerivedColumnDefinition =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableReportGridDerivedColumnDefinition actualWithExternalIdResult =
        immutableReportGridDerivedColumnDefinition.withExternalId(optional);

    // Assert
    assertSame(immutableReportGridDerivedColumnDefinition, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#withExternalId(Optional)} with {@code
   * optional}.
   *
   * <ul>
   *   <li>Then return {@code Column Description}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableReportGridDerivedColumnDefinition#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'; then return 'Column Description'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDerivedColumnDefinition ImmutableReportGridDerivedColumnDefinition.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional_thenReturnColumnDescription() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition immutableReportGridDerivedColumnDefinition =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("External Id")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableReportGridDerivedColumnDefinition actualWithExternalIdResult =
        immutableReportGridDerivedColumnDefinition.withExternalId(optional);

    // Assert
    assertEquals("Column Description", actualWithExternalIdResult.columnDescription());
    assertEquals("Derivation Script", actualWithExternalIdResult.derivationScript());
    assertEquals("Display Name", actualWithExternalIdResult.displayName());
    assertEquals(1, actualWithExternalIdResult.position());
    assertEquals(1L, actualWithExternalIdResult.gridColumnId().longValue());
    assertEquals(1L, actualWithExternalIdResult.id().longValue());
    assertEquals(
        EntityKind.REPORT_GRID_DERIVED_COLUMN_DEFINITION, actualWithExternalIdResult.kind());
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#withExternalId(String)} with {@code
   * value}.
   *
   * <p>Method under test: {@link ImmutableReportGridDerivedColumnDefinition#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDerivedColumnDefinition ImmutableReportGridDerivedColumnDefinition.withExternalId(String)"
  })
  void testWithExternalIdWithValue() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition immutableReportGridDerivedColumnDefinition =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act
    ImmutableReportGridDerivedColumnDefinition actualWithExternalIdResult =
        immutableReportGridDerivedColumnDefinition.withExternalId("42");

    // Assert
    assertSame(immutableReportGridDerivedColumnDefinition, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#withExternalId(String)} with {@code
   * value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@code Column Description}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDerivedColumnDefinition#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; when '0123456789ABCDEF'; then return 'Column Description'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDerivedColumnDefinition ImmutableReportGridDerivedColumnDefinition.withExternalId(String)"
  })
  void testWithExternalIdWithValue_when0123456789abcdef_thenReturnColumnDescription() {
    // Arrange and Act
    ImmutableReportGridDerivedColumnDefinition actualWithExternalIdResult =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("Column Description", actualWithExternalIdResult.columnDescription());
    assertEquals("Derivation Script", actualWithExternalIdResult.derivationScript());
    assertEquals("Display Name", actualWithExternalIdResult.displayName());
    assertEquals(1, actualWithExternalIdResult.position());
    assertEquals(1L, actualWithExternalIdResult.gridColumnId().longValue());
    assertEquals(1L, actualWithExternalIdResult.id().longValue());
    assertEquals(
        EntityKind.REPORT_GRID_DERIVED_COLUMN_DEFINITION, actualWithExternalIdResult.kind());
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#withGridColumnId(Long)}.
   *
   * <p>Method under test: {@link ImmutableReportGridDerivedColumnDefinition#withGridColumnId(Long)}
   */
  @Test
  @DisplayName("Test withGridColumnId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDerivedColumnDefinition ImmutableReportGridDerivedColumnDefinition.withGridColumnId(Long)"
  })
  void testWithGridColumnId() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition immutableReportGridDerivedColumnDefinition =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act
    ImmutableReportGridDerivedColumnDefinition actualWithGridColumnIdResult =
        immutableReportGridDerivedColumnDefinition.withGridColumnId(1L);

    // Assert
    assertSame(immutableReportGridDerivedColumnDefinition, actualWithGridColumnIdResult);
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#withGridColumnId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Column Description}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDerivedColumnDefinition#withGridColumnId(Long)}
   */
  @Test
  @DisplayName("Test withGridColumnId(Long); when forty-two; then return 'Column Description'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDerivedColumnDefinition ImmutableReportGridDerivedColumnDefinition.withGridColumnId(Long)"
  })
  void testWithGridColumnId_whenFortyTwo_thenReturnColumnDescription() {
    // Arrange and Act
    ImmutableReportGridDerivedColumnDefinition actualWithGridColumnIdResult =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .withGridColumnId(42L);

    // Assert
    assertEquals("Column Description", actualWithGridColumnIdResult.columnDescription());
    assertEquals("Derivation Script", actualWithGridColumnIdResult.derivationScript());
    assertEquals("Display Name", actualWithGridColumnIdResult.displayName());
    assertEquals(1, actualWithGridColumnIdResult.position());
    assertEquals(1L, actualWithGridColumnIdResult.id().longValue());
    assertEquals(42L, actualWithGridColumnIdResult.gridColumnId().longValue());
    assertEquals(
        EntityKind.REPORT_GRID_DERIVED_COLUMN_DEFINITION, actualWithGridColumnIdResult.kind());
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#withId(Long)}.
   *
   * <p>Method under test: {@link ImmutableReportGridDerivedColumnDefinition#withId(Long)}
   */
  @Test
  @DisplayName("Test withId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDerivedColumnDefinition ImmutableReportGridDerivedColumnDefinition.withId(Long)"
  })
  void testWithId() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition immutableReportGridDerivedColumnDefinition =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act
    ImmutableReportGridDerivedColumnDefinition actualWithIdResult =
        immutableReportGridDerivedColumnDefinition.withId(1L);

    // Assert
    assertSame(immutableReportGridDerivedColumnDefinition, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#withId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Column Description}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDerivedColumnDefinition#withId(Long)}
   */
  @Test
  @DisplayName("Test withId(Long); when forty-two; then return 'Column Description'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDerivedColumnDefinition ImmutableReportGridDerivedColumnDefinition.withId(Long)"
  })
  void testWithId_whenFortyTwo_thenReturnColumnDescription() {
    // Arrange and Act
    ImmutableReportGridDerivedColumnDefinition actualWithIdResult =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .withId(42L);

    // Assert
    assertEquals("Column Description", actualWithIdResult.columnDescription());
    assertEquals("Derivation Script", actualWithIdResult.derivationScript());
    assertEquals("Display Name", actualWithIdResult.displayName());
    assertEquals(1, actualWithIdResult.position());
    assertEquals(1L, actualWithIdResult.gridColumnId().longValue());
    assertEquals(42L, actualWithIdResult.id().longValue());
    assertEquals(EntityKind.REPORT_GRID_DERIVED_COLUMN_DEFINITION, actualWithIdResult.kind());
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#withPosition(int)}.
   *
   * <p>Method under test: {@link ImmutableReportGridDerivedColumnDefinition#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDerivedColumnDefinition ImmutableReportGridDerivedColumnDefinition.withPosition(int)"
  })
  void testWithPosition() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition immutableReportGridDerivedColumnDefinition =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(42)
            .build();

    // Act
    ImmutableReportGridDerivedColumnDefinition actualWithPositionResult =
        immutableReportGridDerivedColumnDefinition.withPosition(42);

    // Assert
    assertSame(immutableReportGridDerivedColumnDefinition, actualWithPositionResult);
  }

  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#withPosition(int)}.
   *
   * <ul>
   *   <li>Then return {@code Column Description}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDerivedColumnDefinition#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int); then return 'Column Description'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDerivedColumnDefinition ImmutableReportGridDerivedColumnDefinition.withPosition(int)"
  })
  void testWithPosition_thenReturnColumnDescription() {
    // Arrange and Act
    ImmutableReportGridDerivedColumnDefinition actualWithPositionResult =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .withPosition(42);

    // Assert
    assertEquals("Column Description", actualWithPositionResult.columnDescription());
    assertEquals("Derivation Script", actualWithPositionResult.derivationScript());
    assertEquals("Display Name", actualWithPositionResult.displayName());
    assertEquals(1L, actualWithPositionResult.gridColumnId().longValue());
    assertEquals(1L, actualWithPositionResult.id().longValue());
    assertEquals(42, actualWithPositionResult.position());
    assertEquals(EntityKind.REPORT_GRID_DERIVED_COLUMN_DEFINITION, actualWithPositionResult.kind());
  }
}
