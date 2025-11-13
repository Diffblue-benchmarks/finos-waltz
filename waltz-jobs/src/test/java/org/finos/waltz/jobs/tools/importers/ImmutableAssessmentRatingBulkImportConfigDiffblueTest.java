package org.finos.waltz.jobs.tools.importers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.tools.importers.ImmutableAssessmentRatingBulkImportConfig.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingBulkImportConfigDiffblueTest {
  /**
   * Test Builder {@link Builder#assessmentDefinitionId(Long)}.
   *
   * <p>Method under test: {@link Builder#assessmentDefinitionId(Long)}
   */
  @Test
  @DisplayName("Test Builder assessmentDefinitionId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.assessmentDefinitionId(Long)"})
  void testBuilderAssessmentDefinitionId() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingBulkImportConfig.builder();

    // Act
    Builder actualAssessmentDefinitionIdResult = builderResult.assessmentDefinitionId(1L);

    // Assert
    ImmutableAssessmentRatingBulkImportConfig immutableAssessmentRatingBulkImportConfig =
        builderResult.build();
    assertEquals(
        "assessment_rating_bulk_import", immutableAssessmentRatingBulkImportConfig.updateUser());
    assertEquals(0, immutableAssessmentRatingBulkImportConfig.sheetPosition().intValue());
    assertEquals(1, immutableAssessmentRatingBulkImportConfig.numberOfHeaderRows().intValue());
    assertEquals(
        1L, immutableAssessmentRatingBulkImportConfig.assessmentDefinitionId().longValue());
    assertEquals(SynchronisationMode.DELTA, immutableAssessmentRatingBulkImportConfig.mode());
    assertSame(builderResult, actualAssessmentDefinitionIdResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#mode(SynchronisationMode)}
   *   <li>{@link Builder#numberOfHeaderRows(Integer)}
   *   <li>{@link Builder#sheetPosition(Integer)}
   *   <li>{@link Builder#updateUser(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingBulkImportConfig Builder.build()",
    "Builder Builder.mode(SynchronisationMode)",
    "Builder Builder.numberOfHeaderRows(Integer)",
    "Builder Builder.sheetPosition(Integer)",
    "Builder Builder.updateUser(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableAssessmentRatingBulkImportConfig actualImmutableAssessmentRatingBulkImportConfig =
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutableAssessmentRatingBulkImportConfig.updateUser());
    assertEquals(1, actualImmutableAssessmentRatingBulkImportConfig.sheetPosition().intValue());
    assertEquals(
        10, actualImmutableAssessmentRatingBulkImportConfig.numberOfHeaderRows().intValue());
    assertEquals(
        1L, actualImmutableAssessmentRatingBulkImportConfig.assessmentDefinitionId().longValue());
    assertEquals(SynchronisationMode.DELTA, actualImmutableAssessmentRatingBulkImportConfig.mode());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingBulkImportConfig)}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingBulkImportConfig)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingBulkImportConfig)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingBulkImportConfig)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingBulkImportConfig.builder();
    ImmutableAssessmentRatingBulkImportConfig instance =
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentRatingBulkImportConfig actualImmutableAssessmentRatingBulkImportConfig =
        builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRatingBulkImportConfig);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link
   * ImmutableAssessmentRatingBulkImportConfig#copyOf(AssessmentRatingBulkImportConfig)}.
   *
   * <ul>
   *   <li>Then return updateUser is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingBulkImportConfig#copyOf(AssessmentRatingBulkImportConfig)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AssessmentRatingBulkImportConfig); then return updateUser is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingBulkImportConfig ImmutableAssessmentRatingBulkImportConfig.copyOf(AssessmentRatingBulkImportConfig)"
  })
  void testCopyOf_thenReturnUpdateUserIs20200301() {
    // Arrange
    ImmutableAssessmentRatingBulkImportConfig instance =
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build();

    // Act
    ImmutableAssessmentRatingBulkImportConfig actualCopyOfResult =
        ImmutableAssessmentRatingBulkImportConfig.copyOf(instance);

    // Assert
    assertEquals("2020-03-01", actualCopyOfResult.updateUser());
    assertEquals(1, actualCopyOfResult.sheetPosition().intValue());
    assertEquals(10, actualCopyOfResult.numberOfHeaderRows().intValue());
    assertEquals(1L, actualCopyOfResult.assessmentDefinitionId().longValue());
    assertEquals(SynchronisationMode.DELTA, actualCopyOfResult.mode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingBulkImportConfig#equals(Object)}, and {@link
   * ImmutableAssessmentRatingBulkImportConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingBulkImportConfig#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingBulkImportConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingBulkImportConfig.equals(Object)",
    "int ImmutableAssessmentRatingBulkImportConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentRatingBulkImportConfig immutableAssessmentRatingBulkImportConfig =
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build();
    ImmutableAssessmentRatingBulkImportConfig immutableAssessmentRatingBulkImportConfig2 =
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build();

    // Act and Assert
    assertEquals(
        immutableAssessmentRatingBulkImportConfig, immutableAssessmentRatingBulkImportConfig2);
    assertEquals(
        immutableAssessmentRatingBulkImportConfig.hashCode(),
        immutableAssessmentRatingBulkImportConfig2.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingBulkImportConfig#equals(Object)}, and {@link
   * ImmutableAssessmentRatingBulkImportConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingBulkImportConfig#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingBulkImportConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingBulkImportConfig.equals(Object)",
    "int ImmutableAssessmentRatingBulkImportConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentRatingBulkImportConfig immutableAssessmentRatingBulkImportConfig =
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build();

    // Act and Assert
    assertEquals(
        immutableAssessmentRatingBulkImportConfig, immutableAssessmentRatingBulkImportConfig);
    int expectedHashCodeResult = immutableAssessmentRatingBulkImportConfig.hashCode();
    assertEquals(expectedHashCodeResult, immutableAssessmentRatingBulkImportConfig.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingBulkImportConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingBulkImportConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingBulkImportConfig.equals(Object)",
    "int ImmutableAssessmentRatingBulkImportConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAssessmentRatingBulkImportConfig immutableAssessmentRatingBulkImportConfig =
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(2L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingBulkImportConfig,
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingBulkImportConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingBulkImportConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingBulkImportConfig.equals(Object)",
    "int ImmutableAssessmentRatingBulkImportConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAssessmentRatingBulkImportConfig immutableAssessmentRatingBulkImportConfig =
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.FULL)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingBulkImportConfig,
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingBulkImportConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingBulkImportConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingBulkImportConfig.equals(Object)",
    "int ImmutableAssessmentRatingBulkImportConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableAssessmentRatingBulkImportConfig immutableAssessmentRatingBulkImportConfig =
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(1)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingBulkImportConfig,
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingBulkImportConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingBulkImportConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingBulkImportConfig.equals(Object)",
    "int ImmutableAssessmentRatingBulkImportConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableAssessmentRatingBulkImportConfig immutableAssessmentRatingBulkImportConfig =
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(0)
            .updateUser("2020-03-01")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingBulkImportConfig,
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingBulkImportConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingBulkImportConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingBulkImportConfig.equals(Object)",
    "int ImmutableAssessmentRatingBulkImportConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableAssessmentRatingBulkImportConfig immutableAssessmentRatingBulkImportConfig =
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020/03/01")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingBulkImportConfig,
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingBulkImportConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingBulkImportConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingBulkImportConfig.equals(Object)",
    "int ImmutableAssessmentRatingBulkImportConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAssessmentRatingBulkImportConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingBulkImportConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingBulkImportConfig.equals(Object)",
    "int ImmutableAssessmentRatingBulkImportConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build(),
        "Different type to ImmutableAssessmentRatingBulkImportConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingBulkImportConfig#toString()}
   *   <li>{@link ImmutableAssessmentRatingBulkImportConfig#assessmentDefinitionId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ImmutableAssessmentRatingBulkImportConfig.assessmentDefinitionId()",
    "String ImmutableAssessmentRatingBulkImportConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAssessmentRatingBulkImportConfig immutableAssessmentRatingBulkImportConfig =
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build();

    // Act
    String actualToStringResult = immutableAssessmentRatingBulkImportConfig.toString();

    // Assert
    assertEquals(
        "AssessmentRatingBulkImportConfig{assessmentDefinitionId=1, numberOfHeaderRows=10, sheetPosition=1,"
            + " updateUser=2020-03-01, mode=DELTA}",
        actualToStringResult);
    assertEquals(
        1L, immutableAssessmentRatingBulkImportConfig.assessmentDefinitionId().longValue());
  }

  /**
   * Test {@link ImmutableAssessmentRatingBulkImportConfig#mode()}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingBulkImportConfig#mode()}
   */
  @Test
  @DisplayName("Test mode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SynchronisationMode ImmutableAssessmentRatingBulkImportConfig.mode()"})
  void testMode() {
    // Arrange, Act and Assert
    assertEquals(
        SynchronisationMode.DELTA,
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build()
            .mode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingBulkImportConfig#numberOfHeaderRows()}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingBulkImportConfig#numberOfHeaderRows()}
   */
  @Test
  @DisplayName("Test numberOfHeaderRows()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer ImmutableAssessmentRatingBulkImportConfig.numberOfHeaderRows()"})
  void testNumberOfHeaderRows() {
    // Arrange, Act and Assert
    assertEquals(
        10,
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build()
            .numberOfHeaderRows()
            .intValue());
  }

  /**
   * Test {@link ImmutableAssessmentRatingBulkImportConfig#sheetPosition()}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingBulkImportConfig#sheetPosition()}
   */
  @Test
  @DisplayName("Test sheetPosition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer ImmutableAssessmentRatingBulkImportConfig.sheetPosition()"})
  void testSheetPosition() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build()
            .sheetPosition()
            .intValue());
  }

  /**
   * Test {@link ImmutableAssessmentRatingBulkImportConfig#updateUser()}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingBulkImportConfig#updateUser()}
   */
  @Test
  @DisplayName("Test updateUser()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAssessmentRatingBulkImportConfig.updateUser()"})
  void testUpdateUser() {
    // Arrange, Act and Assert
    assertEquals(
        "2020-03-01",
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build()
            .updateUser());
  }

  /**
   * Test {@link ImmutableAssessmentRatingBulkImportConfig#withAssessmentDefinitionId(Long)}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingBulkImportConfig#withAssessmentDefinitionId(Long)}
   */
  @Test
  @DisplayName("Test withAssessmentDefinitionId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingBulkImportConfig ImmutableAssessmentRatingBulkImportConfig.withAssessmentDefinitionId(Long)"
  })
  void testWithAssessmentDefinitionId() {
    // Arrange
    ImmutableAssessmentRatingBulkImportConfig immutableAssessmentRatingBulkImportConfig =
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build();

    // Act
    ImmutableAssessmentRatingBulkImportConfig actualWithAssessmentDefinitionIdResult =
        immutableAssessmentRatingBulkImportConfig.withAssessmentDefinitionId(1L);

    // Assert
    assertSame(immutableAssessmentRatingBulkImportConfig, actualWithAssessmentDefinitionIdResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingBulkImportConfig#withAssessmentDefinitionId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return updateUser is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingBulkImportConfig#withAssessmentDefinitionId(Long)}
   */
  @Test
  @DisplayName(
      "Test withAssessmentDefinitionId(Long); when forty-two; then return updateUser is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingBulkImportConfig ImmutableAssessmentRatingBulkImportConfig.withAssessmentDefinitionId(Long)"
  })
  void testWithAssessmentDefinitionId_whenFortyTwo_thenReturnUpdateUserIs20200301() {
    // Arrange and Act
    ImmutableAssessmentRatingBulkImportConfig actualWithAssessmentDefinitionIdResult =
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build()
            .withAssessmentDefinitionId(42L);

    // Assert
    assertEquals("2020-03-01", actualWithAssessmentDefinitionIdResult.updateUser());
    assertEquals(1, actualWithAssessmentDefinitionIdResult.sheetPosition().intValue());
    assertEquals(10, actualWithAssessmentDefinitionIdResult.numberOfHeaderRows().intValue());
    assertEquals(42L, actualWithAssessmentDefinitionIdResult.assessmentDefinitionId().longValue());
    assertEquals(SynchronisationMode.DELTA, actualWithAssessmentDefinitionIdResult.mode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingBulkImportConfig#withMode(SynchronisationMode)}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingBulkImportConfig#withMode(SynchronisationMode)}
   */
  @Test
  @DisplayName("Test withMode(SynchronisationMode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingBulkImportConfig ImmutableAssessmentRatingBulkImportConfig.withMode(SynchronisationMode)"
  })
  void testWithMode() {
    // Arrange
    ImmutableAssessmentRatingBulkImportConfig immutableAssessmentRatingBulkImportConfig =
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build();

    // Act
    ImmutableAssessmentRatingBulkImportConfig actualWithModeResult =
        immutableAssessmentRatingBulkImportConfig.withMode(SynchronisationMode.DELTA);

    // Assert
    assertSame(immutableAssessmentRatingBulkImportConfig, actualWithModeResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingBulkImportConfig#withMode(SynchronisationMode)}.
   *
   * <ul>
   *   <li>Then return updateUser is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingBulkImportConfig#withMode(SynchronisationMode)}
   */
  @Test
  @DisplayName("Test withMode(SynchronisationMode); then return updateUser is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingBulkImportConfig ImmutableAssessmentRatingBulkImportConfig.withMode(SynchronisationMode)"
  })
  void testWithMode_thenReturnUpdateUserIs20200301() {
    // Arrange and Act
    ImmutableAssessmentRatingBulkImportConfig actualWithModeResult =
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.FULL)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build()
            .withMode(SynchronisationMode.DELTA);

    // Assert
    assertEquals("2020-03-01", actualWithModeResult.updateUser());
    assertEquals(1, actualWithModeResult.sheetPosition().intValue());
    assertEquals(10, actualWithModeResult.numberOfHeaderRows().intValue());
    assertEquals(1L, actualWithModeResult.assessmentDefinitionId().longValue());
    assertEquals(SynchronisationMode.DELTA, actualWithModeResult.mode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingBulkImportConfig#withNumberOfHeaderRows(Integer)}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingBulkImportConfig#withNumberOfHeaderRows(Integer)}
   */
  @Test
  @DisplayName("Test withNumberOfHeaderRows(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingBulkImportConfig ImmutableAssessmentRatingBulkImportConfig.withNumberOfHeaderRows(Integer)"
  })
  void testWithNumberOfHeaderRows() {
    // Arrange and Act
    ImmutableAssessmentRatingBulkImportConfig actualWithNumberOfHeaderRowsResult =
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build()
            .withNumberOfHeaderRows(42);

    // Assert
    assertEquals("2020-03-01", actualWithNumberOfHeaderRowsResult.updateUser());
    assertEquals(1, actualWithNumberOfHeaderRowsResult.sheetPosition().intValue());
    assertEquals(1L, actualWithNumberOfHeaderRowsResult.assessmentDefinitionId().longValue());
    assertEquals(42, actualWithNumberOfHeaderRowsResult.numberOfHeaderRows().intValue());
    assertEquals(SynchronisationMode.DELTA, actualWithNumberOfHeaderRowsResult.mode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingBulkImportConfig#withSheetPosition(Integer)}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingBulkImportConfig#withSheetPosition(Integer)}
   */
  @Test
  @DisplayName("Test withSheetPosition(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingBulkImportConfig ImmutableAssessmentRatingBulkImportConfig.withSheetPosition(Integer)"
  })
  void testWithSheetPosition() {
    // Arrange
    ImmutableAssessmentRatingBulkImportConfig immutableAssessmentRatingBulkImportConfig =
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build();

    // Act
    ImmutableAssessmentRatingBulkImportConfig actualWithSheetPositionResult =
        immutableAssessmentRatingBulkImportConfig.withSheetPosition(1);

    // Assert
    assertSame(immutableAssessmentRatingBulkImportConfig, actualWithSheetPositionResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingBulkImportConfig#withSheetPosition(Integer)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return updateUser is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingBulkImportConfig#withSheetPosition(Integer)}
   */
  @Test
  @DisplayName(
      "Test withSheetPosition(Integer); when forty-two; then return updateUser is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingBulkImportConfig ImmutableAssessmentRatingBulkImportConfig.withSheetPosition(Integer)"
  })
  void testWithSheetPosition_whenFortyTwo_thenReturnUpdateUserIs20200301() {
    // Arrange and Act
    ImmutableAssessmentRatingBulkImportConfig actualWithSheetPositionResult =
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build()
            .withSheetPosition(42);

    // Assert
    assertEquals("2020-03-01", actualWithSheetPositionResult.updateUser());
    assertEquals(10, actualWithSheetPositionResult.numberOfHeaderRows().intValue());
    assertEquals(1L, actualWithSheetPositionResult.assessmentDefinitionId().longValue());
    assertEquals(42, actualWithSheetPositionResult.sheetPosition().intValue());
    assertEquals(SynchronisationMode.DELTA, actualWithSheetPositionResult.mode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingBulkImportConfig#withUpdateUser(String)}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingBulkImportConfig#withUpdateUser(String)}
   */
  @Test
  @DisplayName("Test withUpdateUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingBulkImportConfig ImmutableAssessmentRatingBulkImportConfig.withUpdateUser(String)"
  })
  void testWithUpdateUser() {
    // Arrange
    ImmutableAssessmentRatingBulkImportConfig immutableAssessmentRatingBulkImportConfig =
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("42")
            .build();

    // Act
    ImmutableAssessmentRatingBulkImportConfig actualWithUpdateUserResult =
        immutableAssessmentRatingBulkImportConfig.withUpdateUser("42");

    // Assert
    assertSame(immutableAssessmentRatingBulkImportConfig, actualWithUpdateUserResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingBulkImportConfig#withUpdateUser(String)}.
   *
   * <ul>
   *   <li>Then return updateUser is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingBulkImportConfig#withUpdateUser(String)}
   */
  @Test
  @DisplayName("Test withUpdateUser(String); then return updateUser is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingBulkImportConfig ImmutableAssessmentRatingBulkImportConfig.withUpdateUser(String)"
  })
  void testWithUpdateUser_thenReturnUpdateUserIs42() {
    // Arrange and Act
    ImmutableAssessmentRatingBulkImportConfig actualWithUpdateUserResult =
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build()
            .withUpdateUser("42");

    // Assert
    assertEquals("42", actualWithUpdateUserResult.updateUser());
    assertEquals(1, actualWithUpdateUserResult.sheetPosition().intValue());
    assertEquals(10, actualWithUpdateUserResult.numberOfHeaderRows().intValue());
    assertEquals(1L, actualWithUpdateUserResult.assessmentDefinitionId().longValue());
    assertEquals(SynchronisationMode.DELTA, actualWithUpdateUserResult.mode());
  }
}
