package org.finos.waltz.jobs.clients.c1.sc1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.clients.c1.sc1.model.ImmutableComponentRow.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableComponentRowDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComponentRow Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableComponentRow actualImmutableComponentRow =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build();

    // Assert
    assertEquals("1.0.2", actualImmutableComponentRow.version());
    assertEquals("2020-03-01", actualImmutableComponentRow.endDate());
    assertEquals("2020-03-01", actualImmutableComponentRow.reviewDate());
    assertEquals("42", actualImmutableComponentRow.internalId());
    assertEquals("Category", actualImmutableComponentRow.category());
    assertEquals("Layer", actualImmutableComponentRow.layer());
    assertEquals("Name", actualImmutableComponentRow.name());
    assertEquals("Owner", actualImmutableComponentRow.owner());
    assertEquals("Tier", actualImmutableComponentRow.tier());
    assertEquals(MaintenanceStatus.EXTENDED, actualImmutableComponentRow.maintenanceStatus());
  }

  /**
   * Test Builder {@link Builder#category(String)}.
   *
   * <ul>
   *   <li>When {@code Category}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#category(String)}
   */
  @Test
  @DisplayName("Test Builder category(String); when 'Category'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.category(String)"})
  void testBuilderCategory_whenCategory_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComponentRow.builder();

    // Act
    Builder actualCategoryResult = builderResult.category("Category");

    // Assert
    assertSame(builderResult, actualCategoryResult);
  }

  /**
   * Test Builder {@link Builder#endDate(String)}.
   *
   * <ul>
   *   <li>When {@code 2020-03-01}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#endDate(String)}
   */
  @Test
  @DisplayName("Test Builder endDate(String); when '2020-03-01'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.endDate(String)"})
  void testBuilderEndDate_when20200301_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComponentRow.builder();

    // Act
    Builder actualEndDateResult = builderResult.endDate("2020-03-01");

    // Assert
    assertSame(builderResult, actualEndDateResult);
  }

  /**
   * Test Builder {@link Builder#from(ComponentRow)}.
   *
   * <p>Method under test: {@link Builder#from(ComponentRow)}
   */
  @Test
  @DisplayName("Test Builder from(ComponentRow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ComponentRow)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableComponentRow.builder();
    ImmutableComponentRow instance =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableComponentRow actualImmutableComponentRow = builderResult.build();
    assertEquals(instance, actualImmutableComponentRow);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#internalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#internalId(String)}
   */
  @Test
  @DisplayName("Test Builder internalId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.internalId(String)"})
  void testBuilderInternalId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComponentRow.builder();

    // Act
    Builder actualInternalIdResult = builderResult.internalId("42");

    // Assert
    assertSame(builderResult, actualInternalIdResult);
  }

  /**
   * Test Builder {@link Builder#layer(String)}.
   *
   * <ul>
   *   <li>When {@code Layer}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#layer(String)}
   */
  @Test
  @DisplayName("Test Builder layer(String); when 'Layer'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.layer(String)"})
  void testBuilderLayer_whenLayer_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComponentRow.builder();

    // Act
    Builder actualLayerResult = builderResult.layer("Layer");

    // Assert
    assertSame(builderResult, actualLayerResult);
  }

  /**
   * Test Builder {@link Builder#maintenanceStatus(MaintenanceStatus)}.
   *
   * <p>Method under test: {@link Builder#maintenanceStatus(MaintenanceStatus)}
   */
  @Test
  @DisplayName("Test Builder maintenanceStatus(MaintenanceStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.maintenanceStatus(MaintenanceStatus)"})
  void testBuilderMaintenanceStatus() {
    // Arrange
    Builder builderResult = ImmutableComponentRow.builder();

    // Act
    Builder actualMaintenanceStatusResult =
        builderResult.maintenanceStatus(MaintenanceStatus.EXTENDED);

    // Assert
    assertSame(builderResult, actualMaintenanceStatusResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComponentRow.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#owner(String)}.
   *
   * <ul>
   *   <li>When {@code Owner}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#owner(String)}
   */
  @Test
  @DisplayName("Test Builder owner(String); when 'Owner'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.owner(String)"})
  void testBuilderOwner_whenOwner_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComponentRow.builder();

    // Act
    Builder actualOwnerResult = builderResult.owner("Owner");

    // Assert
    assertSame(builderResult, actualOwnerResult);
  }

  /**
   * Test Builder {@link Builder#reviewDate(String)}.
   *
   * <ul>
   *   <li>When {@code 2020-03-01}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#reviewDate(String)}
   */
  @Test
  @DisplayName("Test Builder reviewDate(String); when '2020-03-01'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.reviewDate(String)"})
  void testBuilderReviewDate_when20200301_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComponentRow.builder();

    // Act
    Builder actualReviewDateResult = builderResult.reviewDate("2020-03-01");

    // Assert
    assertSame(builderResult, actualReviewDateResult);
  }

  /**
   * Test Builder {@link Builder#tier(String)}.
   *
   * <ul>
   *   <li>When {@code Tier}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#tier(String)}
   */
  @Test
  @DisplayName("Test Builder tier(String); when 'Tier'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.tier(String)"})
  void testBuilderTier_whenTier_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComponentRow.builder();

    // Act
    Builder actualTierResult = builderResult.tier("Tier");

    // Assert
    assertSame(builderResult, actualTierResult);
  }

  /**
   * Test Builder {@link Builder#version(String)}.
   *
   * <ul>
   *   <li>When {@code 1.0.2}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#version(String)}
   */
  @Test
  @DisplayName("Test Builder version(String); when '1.0.2'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.version(String)"})
  void testBuilderVersion_when102_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComponentRow.builder();

    // Act
    Builder actualVersionResult = builderResult.version("1.0.2");

    // Assert
    assertSame(builderResult, actualVersionResult);
  }

  /**
   * Test {@link ImmutableComponentRow#copyOf(ComponentRow)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComponentRow#copyOf(ComponentRow)}
   */
  @Test
  @DisplayName("Test copyOf(ComponentRow); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComponentRow ImmutableComponentRow.copyOf(ComponentRow)"})
  void testCopyOf_thenReturnVersionIs102() {
    // Arrange
    ImmutableComponentRow instance =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build();

    // Act
    ImmutableComponentRow actualCopyOfResult = ImmutableComponentRow.copyOf(instance);

    // Assert
    assertEquals("1.0.2", actualCopyOfResult.version());
    assertEquals("2020-03-01", actualCopyOfResult.endDate());
    assertEquals("2020-03-01", actualCopyOfResult.reviewDate());
    assertEquals("42", actualCopyOfResult.internalId());
    assertEquals("Category", actualCopyOfResult.category());
    assertEquals("Layer", actualCopyOfResult.layer());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Owner", actualCopyOfResult.owner());
    assertEquals("Tier", actualCopyOfResult.tier());
    assertEquals(MaintenanceStatus.EXTENDED, actualCopyOfResult.maintenanceStatus());
  }

  /**
   * Test {@link ImmutableComponentRow#equals(Object)}, and {@link
   * ImmutableComponentRow#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableComponentRow#equals(Object)}
   *   <li>{@link ImmutableComponentRow#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComponentRow.equals(Object)",
    "int ImmutableComponentRow.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableComponentRow immutableComponentRow =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build();
    ImmutableComponentRow immutableComponentRow2 =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build();

    // Act and Assert
    assertEquals(immutableComponentRow, immutableComponentRow2);
    assertEquals(immutableComponentRow.hashCode(), immutableComponentRow2.hashCode());
  }

  /**
   * Test {@link ImmutableComponentRow#equals(Object)}, and {@link
   * ImmutableComponentRow#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableComponentRow#equals(Object)}
   *   <li>{@link ImmutableComponentRow#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComponentRow.equals(Object)",
    "int ImmutableComponentRow.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableComponentRow immutableComponentRow =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build();

    // Act and Assert
    assertEquals(immutableComponentRow, immutableComponentRow);
    int expectedHashCodeResult = immutableComponentRow.hashCode();
    assertEquals(expectedHashCodeResult, immutableComponentRow.hashCode());
  }

  /**
   * Test {@link ImmutableComponentRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComponentRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComponentRow.equals(Object)",
    "int ImmutableComponentRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableComponentRow immutableComponentRow =
        ImmutableComponentRow.builder()
            .category("Tier")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableComponentRow,
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableComponentRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComponentRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComponentRow.equals(Object)",
    "int ImmutableComponentRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableComponentRow immutableComponentRow =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020/03/01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableComponentRow,
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableComponentRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComponentRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComponentRow.equals(Object)",
    "int ImmutableComponentRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableComponentRow immutableComponentRow =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("Tier")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableComponentRow,
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableComponentRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComponentRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComponentRow.equals(Object)",
    "int ImmutableComponentRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableComponentRow immutableComponentRow =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Tier")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableComponentRow,
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableComponentRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComponentRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComponentRow.equals(Object)",
    "int ImmutableComponentRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableComponentRow immutableComponentRow =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.NONE)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableComponentRow,
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableComponentRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComponentRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComponentRow.equals(Object)",
    "int ImmutableComponentRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableComponentRow immutableComponentRow =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Tier")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableComponentRow,
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableComponentRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComponentRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComponentRow.equals(Object)",
    "int ImmutableComponentRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableComponentRow immutableComponentRow =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Tier")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableComponentRow,
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableComponentRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComponentRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComponentRow.equals(Object)",
    "int ImmutableComponentRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutableComponentRow immutableComponentRow =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020/03/01")
            .tier("Tier")
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableComponentRow,
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableComponentRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComponentRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComponentRow.equals(Object)",
    "int ImmutableComponentRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ImmutableComponentRow immutableComponentRow =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Layer")
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableComponentRow,
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableComponentRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComponentRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComponentRow.equals(Object)",
    "int ImmutableComponentRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ImmutableComponentRow immutableComponentRow =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("Tier")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableComponentRow,
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableComponentRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComponentRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComponentRow.equals(Object)",
    "int ImmutableComponentRow.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableComponentRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComponentRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComponentRow.equals(Object)",
    "int ImmutableComponentRow.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build(),
        "Different type to ImmutableComponentRow");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableComponentRow#toString()}
   *   <li>{@link ImmutableComponentRow#category()}
   *   <li>{@link ImmutableComponentRow#endDate()}
   *   <li>{@link ImmutableComponentRow#internalId()}
   *   <li>{@link ImmutableComponentRow#layer()}
   *   <li>{@link ImmutableComponentRow#maintenanceStatus()}
   *   <li>{@link ImmutableComponentRow#name()}
   *   <li>{@link ImmutableComponentRow#owner()}
   *   <li>{@link ImmutableComponentRow#reviewDate()}
   *   <li>{@link ImmutableComponentRow#tier()}
   *   <li>{@link ImmutableComponentRow#version()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableComponentRow.category()",
    "String ImmutableComponentRow.endDate()",
    "String ImmutableComponentRow.internalId()",
    "String ImmutableComponentRow.layer()",
    "MaintenanceStatus ImmutableComponentRow.maintenanceStatus()",
    "String ImmutableComponentRow.name()",
    "String ImmutableComponentRow.owner()",
    "String ImmutableComponentRow.reviewDate()",
    "String ImmutableComponentRow.tier()",
    "String ImmutableComponentRow.toString()",
    "String ImmutableComponentRow.version()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableComponentRow immutableComponentRow =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build();

    // Act
    String actualToStringResult = immutableComponentRow.toString();
    String actualCategoryResult = immutableComponentRow.category();
    String actualEndDateResult = immutableComponentRow.endDate();
    String actualInternalIdResult = immutableComponentRow.internalId();
    String actualLayerResult = immutableComponentRow.layer();
    MaintenanceStatus actualMaintenanceStatusResult = immutableComponentRow.maintenanceStatus();
    String actualNameResult = immutableComponentRow.name();
    String actualOwnerResult = immutableComponentRow.owner();
    String actualReviewDateResult = immutableComponentRow.reviewDate();
    String actualTierResult = immutableComponentRow.tier();

    // Assert
    assertEquals("1.0.2", immutableComponentRow.version());
    assertEquals("2020-03-01", actualEndDateResult);
    assertEquals("2020-03-01", actualReviewDateResult);
    assertEquals("42", actualInternalIdResult);
    assertEquals("Category", actualCategoryResult);
    assertEquals(
        "ComponentRow{tier=Tier, layer=Layer, internalId=42, name=Name, version=1.0.2, category=Category,"
            + " owner=Owner, maintenanceStatus=EXTENDED, endDate=2020-03-01, reviewDate=2020-03-01}",
        actualToStringResult);
    assertEquals("Layer", actualLayerResult);
    assertEquals("Name", actualNameResult);
    assertEquals("Owner", actualOwnerResult);
    assertEquals("Tier", actualTierResult);
    assertEquals(MaintenanceStatus.EXTENDED, actualMaintenanceStatusResult);
  }

  /**
   * Test {@link ImmutableComponentRow#withCategory(String)}.
   *
   * <p>Method under test: {@link ImmutableComponentRow#withCategory(String)}
   */
  @Test
  @DisplayName("Test withCategory(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComponentRow ImmutableComponentRow.withCategory(String)"})
  void testWithCategory() {
    // Arrange
    ImmutableComponentRow immutableComponentRow =
        ImmutableComponentRow.builder()
            .category("42")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build();

    // Act
    ImmutableComponentRow actualWithCategoryResult = immutableComponentRow.withCategory("42");

    // Assert
    assertSame(immutableComponentRow, actualWithCategoryResult);
  }

  /**
   * Test {@link ImmutableComponentRow#withCategory(String)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComponentRow#withCategory(String)}
   */
  @Test
  @DisplayName("Test withCategory(String); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComponentRow ImmutableComponentRow.withCategory(String)"})
  void testWithCategory_thenReturnVersionIs102() {
    // Arrange and Act
    ImmutableComponentRow actualWithCategoryResult =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build()
            .withCategory("42");

    // Assert
    assertEquals("1.0.2", actualWithCategoryResult.version());
    assertEquals("2020-03-01", actualWithCategoryResult.endDate());
    assertEquals("2020-03-01", actualWithCategoryResult.reviewDate());
    assertEquals("42", actualWithCategoryResult.category());
    assertEquals("42", actualWithCategoryResult.internalId());
    assertEquals("Layer", actualWithCategoryResult.layer());
    assertEquals("Name", actualWithCategoryResult.name());
    assertEquals("Owner", actualWithCategoryResult.owner());
    assertEquals("Tier", actualWithCategoryResult.tier());
    assertEquals(MaintenanceStatus.EXTENDED, actualWithCategoryResult.maintenanceStatus());
  }

  /**
   * Test {@link ImmutableComponentRow#withEndDate(String)}.
   *
   * <p>Method under test: {@link ImmutableComponentRow#withEndDate(String)}
   */
  @Test
  @DisplayName("Test withEndDate(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComponentRow ImmutableComponentRow.withEndDate(String)"})
  void testWithEndDate() {
    // Arrange
    ImmutableComponentRow immutableComponentRow =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("42")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build();

    // Act
    ImmutableComponentRow actualWithEndDateResult = immutableComponentRow.withEndDate("42");

    // Assert
    assertSame(immutableComponentRow, actualWithEndDateResult);
  }

  /**
   * Test {@link ImmutableComponentRow#withEndDate(String)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComponentRow#withEndDate(String)}
   */
  @Test
  @DisplayName("Test withEndDate(String); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComponentRow ImmutableComponentRow.withEndDate(String)"})
  void testWithEndDate_thenReturnVersionIs102() {
    // Arrange and Act
    ImmutableComponentRow actualWithEndDateResult =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build()
            .withEndDate("42");

    // Assert
    assertEquals("1.0.2", actualWithEndDateResult.version());
    assertEquals("2020-03-01", actualWithEndDateResult.reviewDate());
    assertEquals("42", actualWithEndDateResult.endDate());
    assertEquals("42", actualWithEndDateResult.internalId());
    assertEquals("Category", actualWithEndDateResult.category());
    assertEquals("Layer", actualWithEndDateResult.layer());
    assertEquals("Name", actualWithEndDateResult.name());
    assertEquals("Owner", actualWithEndDateResult.owner());
    assertEquals("Tier", actualWithEndDateResult.tier());
    assertEquals(MaintenanceStatus.EXTENDED, actualWithEndDateResult.maintenanceStatus());
  }

  /**
   * Test {@link ImmutableComponentRow#withInternalId(String)}.
   *
   * <p>Method under test: {@link ImmutableComponentRow#withInternalId(String)}
   */
  @Test
  @DisplayName("Test withInternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComponentRow ImmutableComponentRow.withInternalId(String)"})
  void testWithInternalId() {
    // Arrange
    ImmutableComponentRow immutableComponentRow =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build();

    // Act
    ImmutableComponentRow actualWithInternalIdResult = immutableComponentRow.withInternalId("42");

    // Assert
    assertSame(immutableComponentRow, actualWithInternalIdResult);
  }

  /**
   * Test {@link ImmutableComponentRow#withInternalId(String)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComponentRow#withInternalId(String)}
   */
  @Test
  @DisplayName("Test withInternalId(String); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComponentRow ImmutableComponentRow.withInternalId(String)"})
  void testWithInternalId_thenReturnVersionIs102() {
    // Arrange and Act
    ImmutableComponentRow actualWithInternalIdResult =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("internalId")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build()
            .withInternalId("42");

    // Assert
    assertEquals("1.0.2", actualWithInternalIdResult.version());
    assertEquals("2020-03-01", actualWithInternalIdResult.endDate());
    assertEquals("2020-03-01", actualWithInternalIdResult.reviewDate());
    assertEquals("42", actualWithInternalIdResult.internalId());
    assertEquals("Category", actualWithInternalIdResult.category());
    assertEquals("Layer", actualWithInternalIdResult.layer());
    assertEquals("Name", actualWithInternalIdResult.name());
    assertEquals("Owner", actualWithInternalIdResult.owner());
    assertEquals("Tier", actualWithInternalIdResult.tier());
    assertEquals(MaintenanceStatus.EXTENDED, actualWithInternalIdResult.maintenanceStatus());
  }

  /**
   * Test {@link ImmutableComponentRow#withLayer(String)}.
   *
   * <p>Method under test: {@link ImmutableComponentRow#withLayer(String)}
   */
  @Test
  @DisplayName("Test withLayer(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComponentRow ImmutableComponentRow.withLayer(String)"})
  void testWithLayer() {
    // Arrange
    ImmutableComponentRow immutableComponentRow =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("42")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build();

    // Act
    ImmutableComponentRow actualWithLayerResult = immutableComponentRow.withLayer("42");

    // Assert
    assertSame(immutableComponentRow, actualWithLayerResult);
  }

  /**
   * Test {@link ImmutableComponentRow#withLayer(String)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComponentRow#withLayer(String)}
   */
  @Test
  @DisplayName("Test withLayer(String); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComponentRow ImmutableComponentRow.withLayer(String)"})
  void testWithLayer_thenReturnVersionIs102() {
    // Arrange and Act
    ImmutableComponentRow actualWithLayerResult =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build()
            .withLayer("42");

    // Assert
    assertEquals("1.0.2", actualWithLayerResult.version());
    assertEquals("2020-03-01", actualWithLayerResult.endDate());
    assertEquals("2020-03-01", actualWithLayerResult.reviewDate());
    assertEquals("42", actualWithLayerResult.internalId());
    assertEquals("42", actualWithLayerResult.layer());
    assertEquals("Category", actualWithLayerResult.category());
    assertEquals("Name", actualWithLayerResult.name());
    assertEquals("Owner", actualWithLayerResult.owner());
    assertEquals("Tier", actualWithLayerResult.tier());
    assertEquals(MaintenanceStatus.EXTENDED, actualWithLayerResult.maintenanceStatus());
  }

  /**
   * Test {@link ImmutableComponentRow#withMaintenanceStatus(MaintenanceStatus)}.
   *
   * <p>Method under test: {@link ImmutableComponentRow#withMaintenanceStatus(MaintenanceStatus)}
   */
  @Test
  @DisplayName("Test withMaintenanceStatus(MaintenanceStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComponentRow ImmutableComponentRow.withMaintenanceStatus(MaintenanceStatus)"
  })
  void testWithMaintenanceStatus() {
    // Arrange
    ImmutableComponentRow immutableComponentRow =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build();

    // Act
    ImmutableComponentRow actualWithMaintenanceStatusResult =
        immutableComponentRow.withMaintenanceStatus(MaintenanceStatus.EXTENDED);

    // Assert
    assertSame(immutableComponentRow, actualWithMaintenanceStatusResult);
  }

  /**
   * Test {@link ImmutableComponentRow#withMaintenanceStatus(MaintenanceStatus)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComponentRow#withMaintenanceStatus(MaintenanceStatus)}
   */
  @Test
  @DisplayName("Test withMaintenanceStatus(MaintenanceStatus); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComponentRow ImmutableComponentRow.withMaintenanceStatus(MaintenanceStatus)"
  })
  void testWithMaintenanceStatus_thenReturnVersionIs102() {
    // Arrange and Act
    ImmutableComponentRow actualWithMaintenanceStatusResult =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.NONE)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build()
            .withMaintenanceStatus(MaintenanceStatus.EXTENDED);

    // Assert
    assertEquals("1.0.2", actualWithMaintenanceStatusResult.version());
    assertEquals("2020-03-01", actualWithMaintenanceStatusResult.endDate());
    assertEquals("2020-03-01", actualWithMaintenanceStatusResult.reviewDate());
    assertEquals("42", actualWithMaintenanceStatusResult.internalId());
    assertEquals("Category", actualWithMaintenanceStatusResult.category());
    assertEquals("Layer", actualWithMaintenanceStatusResult.layer());
    assertEquals("Name", actualWithMaintenanceStatusResult.name());
    assertEquals("Owner", actualWithMaintenanceStatusResult.owner());
    assertEquals("Tier", actualWithMaintenanceStatusResult.tier());
    assertEquals(MaintenanceStatus.EXTENDED, actualWithMaintenanceStatusResult.maintenanceStatus());
  }

  /**
   * Test {@link ImmutableComponentRow#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableComponentRow#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComponentRow ImmutableComponentRow.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableComponentRow immutableComponentRow =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("42")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build();

    // Act
    ImmutableComponentRow actualWithNameResult = immutableComponentRow.withName("42");

    // Assert
    assertSame(immutableComponentRow, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableComponentRow#withName(String)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComponentRow#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComponentRow ImmutableComponentRow.withName(String)"})
  void testWithName_thenReturnVersionIs102() {
    // Arrange and Act
    ImmutableComponentRow actualWithNameResult =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build()
            .withName("42");

    // Assert
    assertEquals("1.0.2", actualWithNameResult.version());
    assertEquals("2020-03-01", actualWithNameResult.endDate());
    assertEquals("2020-03-01", actualWithNameResult.reviewDate());
    assertEquals("42", actualWithNameResult.internalId());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Category", actualWithNameResult.category());
    assertEquals("Layer", actualWithNameResult.layer());
    assertEquals("Owner", actualWithNameResult.owner());
    assertEquals("Tier", actualWithNameResult.tier());
    assertEquals(MaintenanceStatus.EXTENDED, actualWithNameResult.maintenanceStatus());
  }

  /**
   * Test {@link ImmutableComponentRow#withOwner(String)}.
   *
   * <p>Method under test: {@link ImmutableComponentRow#withOwner(String)}
   */
  @Test
  @DisplayName("Test withOwner(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComponentRow ImmutableComponentRow.withOwner(String)"})
  void testWithOwner() {
    // Arrange
    ImmutableComponentRow immutableComponentRow =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("42")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build();

    // Act
    ImmutableComponentRow actualWithOwnerResult = immutableComponentRow.withOwner("42");

    // Assert
    assertSame(immutableComponentRow, actualWithOwnerResult);
  }

  /**
   * Test {@link ImmutableComponentRow#withOwner(String)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComponentRow#withOwner(String)}
   */
  @Test
  @DisplayName("Test withOwner(String); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComponentRow ImmutableComponentRow.withOwner(String)"})
  void testWithOwner_thenReturnVersionIs102() {
    // Arrange and Act
    ImmutableComponentRow actualWithOwnerResult =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build()
            .withOwner("42");

    // Assert
    assertEquals("1.0.2", actualWithOwnerResult.version());
    assertEquals("2020-03-01", actualWithOwnerResult.endDate());
    assertEquals("2020-03-01", actualWithOwnerResult.reviewDate());
    assertEquals("42", actualWithOwnerResult.internalId());
    assertEquals("42", actualWithOwnerResult.owner());
    assertEquals("Category", actualWithOwnerResult.category());
    assertEquals("Layer", actualWithOwnerResult.layer());
    assertEquals("Name", actualWithOwnerResult.name());
    assertEquals("Tier", actualWithOwnerResult.tier());
    assertEquals(MaintenanceStatus.EXTENDED, actualWithOwnerResult.maintenanceStatus());
  }

  /**
   * Test {@link ImmutableComponentRow#withReviewDate(String)}.
   *
   * <p>Method under test: {@link ImmutableComponentRow#withReviewDate(String)}
   */
  @Test
  @DisplayName("Test withReviewDate(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComponentRow ImmutableComponentRow.withReviewDate(String)"})
  void testWithReviewDate() {
    // Arrange
    ImmutableComponentRow immutableComponentRow =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("42")
            .tier("Tier")
            .version("1.0.2")
            .build();

    // Act
    ImmutableComponentRow actualWithReviewDateResult = immutableComponentRow.withReviewDate("42");

    // Assert
    assertSame(immutableComponentRow, actualWithReviewDateResult);
  }

  /**
   * Test {@link ImmutableComponentRow#withReviewDate(String)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComponentRow#withReviewDate(String)}
   */
  @Test
  @DisplayName("Test withReviewDate(String); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComponentRow ImmutableComponentRow.withReviewDate(String)"})
  void testWithReviewDate_thenReturnVersionIs102() {
    // Arrange and Act
    ImmutableComponentRow actualWithReviewDateResult =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build()
            .withReviewDate("42");

    // Assert
    assertEquals("1.0.2", actualWithReviewDateResult.version());
    assertEquals("2020-03-01", actualWithReviewDateResult.endDate());
    assertEquals("42", actualWithReviewDateResult.internalId());
    assertEquals("42", actualWithReviewDateResult.reviewDate());
    assertEquals("Category", actualWithReviewDateResult.category());
    assertEquals("Layer", actualWithReviewDateResult.layer());
    assertEquals("Name", actualWithReviewDateResult.name());
    assertEquals("Owner", actualWithReviewDateResult.owner());
    assertEquals("Tier", actualWithReviewDateResult.tier());
    assertEquals(MaintenanceStatus.EXTENDED, actualWithReviewDateResult.maintenanceStatus());
  }

  /**
   * Test {@link ImmutableComponentRow#withTier(String)}.
   *
   * <p>Method under test: {@link ImmutableComponentRow#withTier(String)}
   */
  @Test
  @DisplayName("Test withTier(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComponentRow ImmutableComponentRow.withTier(String)"})
  void testWithTier() {
    // Arrange
    ImmutableComponentRow immutableComponentRow =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("42")
            .version("1.0.2")
            .build();

    // Act
    ImmutableComponentRow actualWithTierResult = immutableComponentRow.withTier("42");

    // Assert
    assertSame(immutableComponentRow, actualWithTierResult);
  }

  /**
   * Test {@link ImmutableComponentRow#withTier(String)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComponentRow#withTier(String)}
   */
  @Test
  @DisplayName("Test withTier(String); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComponentRow ImmutableComponentRow.withTier(String)"})
  void testWithTier_thenReturnVersionIs102() {
    // Arrange and Act
    ImmutableComponentRow actualWithTierResult =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build()
            .withTier("42");

    // Assert
    assertEquals("1.0.2", actualWithTierResult.version());
    assertEquals("2020-03-01", actualWithTierResult.endDate());
    assertEquals("2020-03-01", actualWithTierResult.reviewDate());
    assertEquals("42", actualWithTierResult.internalId());
    assertEquals("42", actualWithTierResult.tier());
    assertEquals("Category", actualWithTierResult.category());
    assertEquals("Layer", actualWithTierResult.layer());
    assertEquals("Name", actualWithTierResult.name());
    assertEquals("Owner", actualWithTierResult.owner());
    assertEquals(MaintenanceStatus.EXTENDED, actualWithTierResult.maintenanceStatus());
  }

  /**
   * Test {@link ImmutableComponentRow#withVersion(String)}.
   *
   * <p>Method under test: {@link ImmutableComponentRow#withVersion(String)}
   */
  @Test
  @DisplayName("Test withVersion(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComponentRow ImmutableComponentRow.withVersion(String)"})
  void testWithVersion() {
    // Arrange
    ImmutableComponentRow immutableComponentRow =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("42")
            .build();

    // Act
    ImmutableComponentRow actualWithVersionResult = immutableComponentRow.withVersion("42");

    // Assert
    assertSame(immutableComponentRow, actualWithVersionResult);
  }

  /**
   * Test {@link ImmutableComponentRow#withVersion(String)}.
   *
   * <ul>
   *   <li>Then return endDate is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComponentRow#withVersion(String)}
   */
  @Test
  @DisplayName("Test withVersion(String); then return endDate is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComponentRow ImmutableComponentRow.withVersion(String)"})
  void testWithVersion_thenReturnEndDateIs20200301() {
    // Arrange and Act
    ImmutableComponentRow actualWithVersionResult =
        ImmutableComponentRow.builder()
            .category("Category")
            .endDate("2020-03-01")
            .internalId("42")
            .layer("Layer")
            .maintenanceStatus(MaintenanceStatus.EXTENDED)
            .name("Name")
            .owner("Owner")
            .reviewDate("2020-03-01")
            .tier("Tier")
            .version("1.0.2")
            .build()
            .withVersion("42");

    // Assert
    assertEquals("2020-03-01", actualWithVersionResult.endDate());
    assertEquals("2020-03-01", actualWithVersionResult.reviewDate());
    assertEquals("42", actualWithVersionResult.internalId());
    assertEquals("42", actualWithVersionResult.version());
    assertEquals("Category", actualWithVersionResult.category());
    assertEquals("Layer", actualWithVersionResult.layer());
    assertEquals("Name", actualWithVersionResult.name());
    assertEquals("Owner", actualWithVersionResult.owner());
    assertEquals("Tier", actualWithVersionResult.tier());
    assertEquals(MaintenanceStatus.EXTENDED, actualWithVersionResult.maintenanceStatus());
  }
}
