package org.finos.waltz.model.cost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.cost.ImmutableEntityCostsSummary.Builder;
import org.finos.waltz.model.cost.ImmutableEntityCostsSummary.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityCostsSummaryDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllTopCosts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllTopCosts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllTopCosts(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllTopCosts(Iterable)"})
  void testBuilderAddAllTopCosts_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    // Act
    Builder actualAddAllTopCostsResult = builderResult.addAllTopCosts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllTopCostsResult);
  }

  /**
   * Test Builder {@link Builder#addTopCosts(EntityCost)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableEntityCost.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addTopCosts(EntityCost)}
   */
  @Test
  @DisplayName(
      "Test Builder addTopCosts(EntityCost) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addTopCosts(EntityCost)"})
  void testBuilderAddTopCostsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    // Act
    Builder actualAddTopCostsResult = builderResult.addTopCosts(new ImmutableEntityCost.Json());

    // Assert
    assertSame(builderResult, actualAddTopCostsResult);
  }

  /**
   * Test Builder {@link Builder#addTopCosts(EntityCost[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableEntityCost.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addTopCosts(EntityCost[])}
   */
  @Test
  @DisplayName(
      "Test Builder addTopCosts(EntityCost[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addTopCosts(EntityCost[])"})
  void testBuilderAddTopCostsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    // Act
    Builder actualAddTopCostsResult = builderResult.addTopCosts(new ImmutableEntityCost.Json());

    // Assert
    assertSame(builderResult, actualAddTopCostsResult);
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
  @MethodsUnderTest({"ImmutableEntityCostsSummary Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableEntityCostsSummary.builder();
    ImmutableEntityCostKind costKind =
        ImmutableEntityCostKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();
    Builder actualMissingCountResult =
        actualBuilderResult.costKind(costKind).mappedCount(3).missingCount(3);
    BigDecimal total = new BigDecimal("2.3");
    ImmutableEntityCostsSummary actualImmutableEntityCostsSummary =
        actualMissingCountResult.total(total).year(1).build();

    // Assert
    assertEquals(1, actualImmutableEntityCostsSummary.year());
    assertEquals(3, actualImmutableEntityCostsSummary.mappedCount());
    assertEquals(3, actualImmutableEntityCostsSummary.missingCount());
    assertTrue(actualImmutableEntityCostsSummary.topCosts().isEmpty());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    BigDecimal totalResult = actualImmutableEntityCostsSummary.total();
    assertEquals(expectedTotalResult, totalResult);
    assertSame(total, totalResult);
    assertSame(costKind, actualImmutableEntityCostsSummary.costKind());
  }

  /**
   * Test Builder {@link Builder#costKind(EntityCostKind)}.
   *
   * <ul>
   *   <li>When {@link ImmutableEntityCostKind.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#costKind(EntityCostKind)}
   */
  @Test
  @DisplayName(
      "Test Builder costKind(EntityCostKind); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.costKind(EntityCostKind)"})
  void testBuilderCostKind_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    // Act
    Builder actualCostKindResult = builderResult.costKind(new ImmutableEntityCostKind.Json());

    // Assert
    assertSame(builderResult, actualCostKindResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityCostsSummary)}.
   *
   * <p>Method under test: {@link Builder#from(EntityCostsSummary)}
   */
  @Test
  @DisplayName("Test Builder from(EntityCostsSummary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityCostsSummary)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    Builder builderResult2 = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult =
        builderResult2
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(3);
    ImmutableEntityCostsSummary instance =
        missingCountResult.total(new BigDecimal("2.3")).year(1).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityCostsSummary actualImmutableEntityCostsSummary = builderResult.build();
    assertEquals(instance, actualImmutableEntityCostsSummary);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityCostsSummary)}.
   *
   * <ul>
   *   <li>Then return build topCosts size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityCostsSummary)}
   */
  @Test
  @DisplayName("Test Builder from(EntityCostsSummary); then return build topCosts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityCostsSummary)"})
  void testBuilderFrom_thenReturnBuildTopCostsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    Builder builderResult2 = ImmutableEntityCostsSummary.builder();

    ImmutableEntityCost.Builder builderResult3 = ImmutableEntityCost.builder();

    ImmutableEntityCost.Builder costKindIdResult =
        builderResult3.amount(new BigDecimal("2.3")).costKindId(1L);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    builderResult2.addTopCosts(
        costKindIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .year(1)
            .build());

    Builder missingCountResult =
        builderResult2
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(3);

    // Act and Assert
    List<EntityCost> topCostsResult =
        builderResult
            .from(missingCountResult.total(new BigDecimal("2.3")).year(1).build())
            .build()
            .topCosts();
    assertEquals(1, topCostsResult.size());
    EntityCost getResult = topCostsResult.get(0);
    EntityReference entityReferenceResult = getResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(getResult instanceof ImmutableEntityCost);
    assertEquals("2020-03-01", getResult.lastUpdatedBy());
    assertEquals("Provenance", getResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1, getResult.year());
    assertEquals(1L, getResult.costKindId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityKind.ALL, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    BigDecimal expectedAmountResult = new BigDecimal("2.3");
    assertEquals(expectedAmountResult, getResult.amount());
    assertSame(ofResult, getResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test Builder {@link Builder#mappedCount(int)}.
   *
   * <p>Method under test: {@link Builder#mappedCount(int)}
   */
  @Test
  @DisplayName("Test Builder mappedCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.mappedCount(int)"})
  void testBuilderMappedCount() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    // Act
    Builder actualMappedCountResult = builderResult.mappedCount(3);

    // Assert
    assertSame(builderResult, actualMappedCountResult);
  }

  /**
   * Test Builder {@link Builder#missingCount(int)}.
   *
   * <p>Method under test: {@link Builder#missingCount(int)}
   */
  @Test
  @DisplayName("Test Builder missingCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.missingCount(int)"})
  void testBuilderMissingCount() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    // Act
    Builder actualMissingCountResult = builderResult.missingCount(3);

    // Assert
    assertSame(builderResult, actualMissingCountResult);
  }

  /**
   * Test Builder {@link Builder#topCosts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#topCosts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder topCosts(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.topCosts(Iterable)"})
  void testBuilderTopCosts_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    // Act
    Builder actualTopCostsResult = builderResult.topCosts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualTopCostsResult);
  }

  /**
   * Test Builder {@link Builder#total(BigDecimal)}.
   *
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#total(BigDecimal)}
   */
  @Test
  @DisplayName(
      "Test Builder total(BigDecimal); when BigDecimal(String) with '2.3'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.total(BigDecimal)"})
  void testBuilderTotal_whenBigDecimalWith23_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    // Act
    Builder actualTotalResult = builderResult.total(new BigDecimal("2.3"));

    // Assert
    assertSame(builderResult, actualTotalResult);
  }

  /**
   * Test Builder {@link Builder#year(int)}.
   *
   * <p>Method under test: {@link Builder#year(int)}
   */
  @Test
  @DisplayName("Test Builder year(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.year(int)"})
  void testBuilderYear() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    // Act
    Builder actualYearResult = builderResult.year(1);

    // Assert
    assertSame(builderResult, actualYearResult);
  }

  /**
   * Test {@link ImmutableEntityCostsSummary#copyOf(EntityCostsSummary)}.
   *
   * <ul>
   *   <li>Then costKind return {@link ImmutableEntityCostKind}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityCostsSummary#copyOf(EntityCostsSummary)}
   */
  @Test
  @DisplayName("Test copyOf(EntityCostsSummary); then costKind return ImmutableEntityCostKind")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityCostsSummary ImmutableEntityCostsSummary.copyOf(EntityCostsSummary)"
  })
  void testCopyOf_thenCostKindReturnImmutableEntityCostKind() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(3);
    ImmutableEntityCostsSummary instance =
        missingCountResult.total(new BigDecimal("2.3")).year(1).build();

    // Act
    ImmutableEntityCostsSummary actualCopyOfResult = ImmutableEntityCostsSummary.copyOf(instance);

    // Assert
    EntityCostKind costKindResult = actualCopyOfResult.costKind();
    assertTrue(costKindResult instanceof ImmutableEntityCostKind);
    assertEquals("Name", costKindResult.name());
    assertEquals("The characteristics of someone or something", costKindResult.description());
    assertEquals(1, actualCopyOfResult.year());
    assertEquals(3, actualCopyOfResult.mappedCount());
    assertEquals(3, actualCopyOfResult.missingCount());
    assertEquals(EntityKind.ALL, costKindResult.kind());
    assertEquals(EntityKind.ALL, costKindResult.subjectKind());
    assertTrue(actualCopyOfResult.topCosts().isEmpty());
    assertTrue(costKindResult.isDefault());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    assertEquals(expectedTotalResult, actualCopyOfResult.total());
  }

  /**
   * Test {@link ImmutableEntityCostsSummary#equals(Object)}, and {@link
   * ImmutableEntityCostsSummary#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityCostsSummary#equals(Object)}
   *   <li>{@link ImmutableEntityCostsSummary#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityCostsSummary.equals(Object)",
    "int ImmutableEntityCostsSummary.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(3);
    ImmutableEntityCostsSummary immutableEntityCostsSummary =
        missingCountResult.total(new BigDecimal("2.3")).year(1).build();

    Builder builderResult2 = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult2 =
        builderResult2
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(3);
    ImmutableEntityCostsSummary immutableEntityCostsSummary2 =
        missingCountResult2.total(new BigDecimal("2.3")).year(1).build();

    // Act and Assert
    assertEquals(immutableEntityCostsSummary, immutableEntityCostsSummary2);
    assertEquals(immutableEntityCostsSummary.hashCode(), immutableEntityCostsSummary2.hashCode());
  }

  /**
   * Test {@link ImmutableEntityCostsSummary#equals(Object)}, and {@link
   * ImmutableEntityCostsSummary#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityCostsSummary#equals(Object)}
   *   <li>{@link ImmutableEntityCostsSummary#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityCostsSummary.equals(Object)",
    "int ImmutableEntityCostsSummary.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(3);
    ImmutableEntityCostsSummary immutableEntityCostsSummary =
        missingCountResult.total(new BigDecimal("2.3")).year(1).build();

    // Act and Assert
    assertEquals(immutableEntityCostsSummary, immutableEntityCostsSummary);
    int expectedHashCodeResult = immutableEntityCostsSummary.hashCode();
    assertEquals(expectedHashCodeResult, immutableEntityCostsSummary.hashCode());
  }

  /**
   * Test {@link ImmutableEntityCostsSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityCostsSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityCostsSummary.equals(Object)",
    "int ImmutableEntityCostsSummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    ImmutableEntityCost.Builder builderResult2 = ImmutableEntityCost.builder();

    ImmutableEntityCost.Builder costKindIdResult =
        builderResult2.amount(new BigDecimal("2.3")).costKindId(1L);
    builderResult.addTopCosts(
        costKindIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .year(1)
            .build());

    Builder missingCountResult =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(3);
    ImmutableEntityCostsSummary immutableEntityCostsSummary =
        missingCountResult.total(new BigDecimal("2.3")).year(1).build();

    Builder builderResult3 = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult2 =
        builderResult3
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(3);

    // Act and Assert
    assertNotEquals(
        immutableEntityCostsSummary,
        missingCountResult2.total(new BigDecimal("2.3")).year(1).build());
  }

  /**
   * Test {@link ImmutableEntityCostsSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityCostsSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityCostsSummary.equals(Object)",
    "int ImmutableEntityCostsSummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("Name")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(3);
    ImmutableEntityCostsSummary immutableEntityCostsSummary =
        missingCountResult.total(new BigDecimal("2.3")).year(1).build();

    Builder builderResult2 = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult2 =
        builderResult2
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(3);

    // Act and Assert
    assertNotEquals(
        immutableEntityCostsSummary,
        missingCountResult2.total(new BigDecimal("2.3")).year(1).build());
  }

  /**
   * Test {@link ImmutableEntityCostsSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityCostsSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityCostsSummary.equals(Object)",
    "int ImmutableEntityCostsSummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(1)
            .missingCount(3);
    ImmutableEntityCostsSummary immutableEntityCostsSummary =
        missingCountResult.total(new BigDecimal("2.3")).year(1).build();

    Builder builderResult2 = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult2 =
        builderResult2
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(3);

    // Act and Assert
    assertNotEquals(
        immutableEntityCostsSummary,
        missingCountResult2.total(new BigDecimal("2.3")).year(1).build());
  }

  /**
   * Test {@link ImmutableEntityCostsSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityCostsSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityCostsSummary.equals(Object)",
    "int ImmutableEntityCostsSummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(1);
    ImmutableEntityCostsSummary immutableEntityCostsSummary =
        missingCountResult.total(new BigDecimal("2.3")).year(1).build();

    Builder builderResult2 = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult2 =
        builderResult2
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(3);

    // Act and Assert
    assertNotEquals(
        immutableEntityCostsSummary,
        missingCountResult2.total(new BigDecimal("2.3")).year(1).build());
  }

  /**
   * Test {@link ImmutableEntityCostsSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityCostsSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityCostsSummary.equals(Object)",
    "int ImmutableEntityCostsSummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(3);
    ImmutableEntityCostsSummary immutableEntityCostsSummary =
        missingCountResult.total(new BigDecimal("4.5")).year(1).build();

    Builder builderResult2 = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult2 =
        builderResult2
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(3);

    // Act and Assert
    assertNotEquals(
        immutableEntityCostsSummary,
        missingCountResult2.total(new BigDecimal("2.3")).year(1).build());
  }

  /**
   * Test {@link ImmutableEntityCostsSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityCostsSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityCostsSummary.equals(Object)",
    "int ImmutableEntityCostsSummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(3);
    ImmutableEntityCostsSummary immutableEntityCostsSummary =
        missingCountResult.total(new BigDecimal("2.3")).year(3).build();

    Builder builderResult2 = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult2 =
        builderResult2
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(3);

    // Act and Assert
    assertNotEquals(
        immutableEntityCostsSummary,
        missingCountResult2.total(new BigDecimal("2.3")).year(1).build());
  }

  /**
   * Test {@link ImmutableEntityCostsSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityCostsSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityCostsSummary.equals(Object)",
    "int ImmutableEntityCostsSummary.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(3);

    // Act and Assert
    assertNotEquals(missingCountResult.total(new BigDecimal("2.3")).year(1).build(), null);
  }

  /**
   * Test {@link ImmutableEntityCostsSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityCostsSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityCostsSummary.equals(Object)",
    "int ImmutableEntityCostsSummary.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(3);

    // Act and Assert
    assertNotEquals(
        missingCountResult.total(new BigDecimal("2.3")).year(1).build(),
        "Different type to ImmutableEntityCostsSummary");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityCostsSummary#toString()}
   *   <li>{@link ImmutableEntityCostsSummary#costKind()}
   *   <li>{@link ImmutableEntityCostsSummary#mappedCount()}
   *   <li>{@link ImmutableEntityCostsSummary#missingCount()}
   *   <li>{@link ImmutableEntityCostsSummary#topCosts()}
   *   <li>{@link ImmutableEntityCostsSummary#total()}
   *   <li>{@link ImmutableEntityCostsSummary#year()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityCostKind ImmutableEntityCostsSummary.costKind()",
    "int ImmutableEntityCostsSummary.mappedCount()",
    "int ImmutableEntityCostsSummary.missingCount()",
    "String ImmutableEntityCostsSummary.toString()",
    "List ImmutableEntityCostsSummary.topCosts()",
    "BigDecimal ImmutableEntityCostsSummary.total()",
    "int ImmutableEntityCostsSummary.year()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(3);
    BigDecimal total = new BigDecimal("2.3");
    ImmutableEntityCostsSummary immutableEntityCostsSummary =
        missingCountResult.total(total).year(1).build();

    // Act
    String actualToStringResult = immutableEntityCostsSummary.toString();
    EntityCostKind actualCostKindResult = immutableEntityCostsSummary.costKind();
    int actualMappedCountResult = immutableEntityCostsSummary.mappedCount();
    int actualMissingCountResult = immutableEntityCostsSummary.missingCount();
    List<EntityCost> actualTopCostsResult = immutableEntityCostsSummary.topCosts();
    BigDecimal actualTotalResult = immutableEntityCostsSummary.total();

    // Assert
    assertTrue(actualCostKindResult instanceof ImmutableEntityCostKind);
    assertEquals(
        "EntityCostsSummary{year=1, mappedCount=3, missingCount=3, total=2.3, topCosts=[], costKind=EntityCostKind"
            + "{id=1, name=Name, externalId=42, isDefault=true, subjectKind=ALL, kind=ALL}}",
        actualToStringResult);
    assertEquals(1, immutableEntityCostsSummary.year());
    assertEquals(3, actualMappedCountResult);
    assertEquals(3, actualMissingCountResult);
    assertTrue(actualTopCostsResult.isEmpty());
    assertEquals(new BigDecimal("2.3"), actualTotalResult);
    assertSame(total, actualTotalResult);
  }

  /**
   * Test Json {@link Json#costKind()}.
   *
   * <p>Method under test: {@link Json#costKind()}
   */
  @Test
  @DisplayName("Test Json costKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityCostKind Json.costKind()"})
  void testJsonCostKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().costKind());
  }

  /**
   * Test Json {@link Json#mappedCount()}.
   *
   * <p>Method under test: {@link Json#mappedCount()}
   */
  @Test
  @DisplayName("Test Json mappedCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.mappedCount()"})
  void testJsonMappedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().mappedCount());
  }

  /**
   * Test Json {@link Json#missingCount()}.
   *
   * <p>Method under test: {@link Json#missingCount()}
   */
  @Test
  @DisplayName("Test Json missingCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.missingCount()"})
  void testJsonMissingCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().missingCount());
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
    assertNull(actualJson.total);
    assertNull(actualJson.costKind);
    assertEquals(0, actualJson.mappedCount);
    assertEquals(0, actualJson.missingCount);
    assertEquals(0, actualJson.year);
    assertFalse(actualJson.mappedCountIsSet);
    assertFalse(actualJson.missingCountIsSet);
    assertFalse(actualJson.yearIsSet);
    assertTrue(actualJson.topCosts.isEmpty());
  }

  /**
   * Test Json {@link Json#setMappedCount(int)}.
   *
   * <p>Method under test: {@link Json#setMappedCount(int)}
   */
  @Test
  @DisplayName("Test Json setMappedCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setMappedCount(int)"})
  void testJsonSetMappedCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setMappedCount(3);

    // Assert
    assertEquals(3, json.mappedCount);
    assertTrue(json.mappedCountIsSet);
  }

  /**
   * Test Json {@link Json#setMissingCount(int)}.
   *
   * <p>Method under test: {@link Json#setMissingCount(int)}
   */
  @Test
  @DisplayName("Test Json setMissingCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setMissingCount(int)"})
  void testJsonSetMissingCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setMissingCount(3);

    // Assert
    assertEquals(3, json.missingCount);
    assertTrue(json.missingCountIsSet);
  }

  /**
   * Test Json {@link Json#setYear(int)}.
   *
   * <p>Method under test: {@link Json#setYear(int)}
   */
  @Test
  @DisplayName("Test Json setYear(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setYear(int)"})
  void testJsonSetYear() {
    // Arrange
    Json json = new Json();

    // Act
    json.setYear(1);

    // Assert
    assertEquals(1, json.year);
    assertTrue(json.yearIsSet);
  }

  /**
   * Test Json {@link Json#topCosts()}.
   *
   * <p>Method under test: {@link Json#topCosts()}
   */
  @Test
  @DisplayName("Test Json topCosts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.topCosts()"})
  void testJsonTopCosts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().topCosts());
  }

  /**
   * Test Json {@link Json#total()}.
   *
   * <p>Method under test: {@link Json#total()}
   */
  @Test
  @DisplayName("Test Json total()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal Json.total()"})
  void testJsonTotal() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().total());
  }

  /**
   * Test Json {@link Json#year()}.
   *
   * <p>Method under test: {@link Json#year()}
   */
  @Test
  @DisplayName("Test Json year()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.year()"})
  void testJsonYear() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().year());
  }

  /**
   * Test {@link ImmutableEntityCostsSummary#withCostKind(EntityCostKind)}.
   *
   * <p>Method under test: {@link ImmutableEntityCostsSummary#withCostKind(EntityCostKind)}
   */
  @Test
  @DisplayName("Test withCostKind(EntityCostKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityCostsSummary ImmutableEntityCostsSummary.withCostKind(EntityCostKind)"
  })
  void testWithCostKind() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(3);
    ImmutableEntityCostsSummary immutableEntityCostsSummary =
        missingCountResult.total(new BigDecimal("2.3")).year(1).build();

    // Act
    ImmutableEntityCostsSummary actualWithCostKindResult =
        immutableEntityCostsSummary.withCostKind(
            ImmutableEntityCostKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .subjectKind(EntityKind.ALL)
                .build());

    // Assert
    assertEquals(immutableEntityCostsSummary, actualWithCostKindResult);
  }

  /**
   * Test {@link ImmutableEntityCostsSummary#withMappedCount(int)}.
   *
   * <p>Method under test: {@link ImmutableEntityCostsSummary#withMappedCount(int)}
   */
  @Test
  @DisplayName("Test withMappedCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityCostsSummary ImmutableEntityCostsSummary.withMappedCount(int)"
  })
  void testWithMappedCount() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(42)
            .missingCount(3);
    ImmutableEntityCostsSummary immutableEntityCostsSummary =
        missingCountResult.total(new BigDecimal("2.3")).year(1).build();

    // Act
    ImmutableEntityCostsSummary actualWithMappedCountResult =
        immutableEntityCostsSummary.withMappedCount(42);

    // Assert
    assertSame(immutableEntityCostsSummary, actualWithMappedCountResult);
  }

  /**
   * Test {@link ImmutableEntityCostsSummary#withMappedCount(int)}.
   *
   * <ul>
   *   <li>Then costKind return {@link ImmutableEntityCostKind}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityCostsSummary#withMappedCount(int)}
   */
  @Test
  @DisplayName("Test withMappedCount(int); then costKind return ImmutableEntityCostKind")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityCostsSummary ImmutableEntityCostsSummary.withMappedCount(int)"
  })
  void testWithMappedCount_thenCostKindReturnImmutableEntityCostKind() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(3);

    // Act
    ImmutableEntityCostsSummary actualWithMappedCountResult =
        missingCountResult.total(new BigDecimal("2.3")).year(1).build().withMappedCount(42);

    // Assert
    EntityCostKind costKindResult = actualWithMappedCountResult.costKind();
    assertTrue(costKindResult instanceof ImmutableEntityCostKind);
    assertEquals("Name", costKindResult.name());
    assertEquals("The characteristics of someone or something", costKindResult.description());
    assertEquals(1, actualWithMappedCountResult.year());
    assertEquals(3, actualWithMappedCountResult.missingCount());
    assertEquals(42, actualWithMappedCountResult.mappedCount());
    assertEquals(EntityKind.ALL, costKindResult.kind());
    assertEquals(EntityKind.ALL, costKindResult.subjectKind());
    assertTrue(actualWithMappedCountResult.topCosts().isEmpty());
    assertTrue(costKindResult.isDefault());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    assertEquals(expectedTotalResult, actualWithMappedCountResult.total());
  }

  /**
   * Test {@link ImmutableEntityCostsSummary#withMissingCount(int)}.
   *
   * <p>Method under test: {@link ImmutableEntityCostsSummary#withMissingCount(int)}
   */
  @Test
  @DisplayName("Test withMissingCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityCostsSummary ImmutableEntityCostsSummary.withMissingCount(int)"
  })
  void testWithMissingCount() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(42);
    ImmutableEntityCostsSummary immutableEntityCostsSummary =
        missingCountResult.total(new BigDecimal("2.3")).year(1).build();

    // Act
    ImmutableEntityCostsSummary actualWithMissingCountResult =
        immutableEntityCostsSummary.withMissingCount(42);

    // Assert
    assertSame(immutableEntityCostsSummary, actualWithMissingCountResult);
  }

  /**
   * Test {@link ImmutableEntityCostsSummary#withMissingCount(int)}.
   *
   * <ul>
   *   <li>Then costKind return {@link ImmutableEntityCostKind}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityCostsSummary#withMissingCount(int)}
   */
  @Test
  @DisplayName("Test withMissingCount(int); then costKind return ImmutableEntityCostKind")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityCostsSummary ImmutableEntityCostsSummary.withMissingCount(int)"
  })
  void testWithMissingCount_thenCostKindReturnImmutableEntityCostKind() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(3);

    // Act
    ImmutableEntityCostsSummary actualWithMissingCountResult =
        missingCountResult.total(new BigDecimal("2.3")).year(1).build().withMissingCount(42);

    // Assert
    EntityCostKind costKindResult = actualWithMissingCountResult.costKind();
    assertTrue(costKindResult instanceof ImmutableEntityCostKind);
    assertEquals("Name", costKindResult.name());
    assertEquals("The characteristics of someone or something", costKindResult.description());
    assertEquals(1, actualWithMissingCountResult.year());
    assertEquals(3, actualWithMissingCountResult.mappedCount());
    assertEquals(42, actualWithMissingCountResult.missingCount());
    assertEquals(EntityKind.ALL, costKindResult.kind());
    assertEquals(EntityKind.ALL, costKindResult.subjectKind());
    assertTrue(actualWithMissingCountResult.topCosts().isEmpty());
    assertTrue(costKindResult.isDefault());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    assertEquals(expectedTotalResult, actualWithMissingCountResult.total());
  }

  /**
   * Test {@link ImmutableEntityCostsSummary#withTopCosts(EntityCost[])} with {@code EntityCost[]}.
   *
   * <p>Method under test: {@link ImmutableEntityCostsSummary#withTopCosts(EntityCost[])}
   */
  @Test
  @DisplayName("Test withTopCosts(EntityCost[]) with 'EntityCost[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityCostsSummary ImmutableEntityCostsSummary.withTopCosts(EntityCost[])"
  })
  void testWithTopCostsWithEntityCost() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(3);
    ImmutableEntityCostsSummary immutableEntityCostsSummary =
        missingCountResult.total(new BigDecimal("2.3")).year(1).build();

    ImmutableEntityCost.Builder builderResult2 = ImmutableEntityCost.builder();

    ImmutableEntityCost.Builder costKindIdResult =
        builderResult2.amount(new BigDecimal("2.3")).costKindId(1L);

    // Act
    ImmutableEntityCostsSummary actualWithTopCostsResult =
        immutableEntityCostsSummary.withTopCosts(
            costKindIdResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .year(1)
                .build());

    // Assert
    List<EntityCost> topCostsResult = actualWithTopCostsResult.topCosts();
    assertEquals(1, topCostsResult.size());
    assertTrue(topCostsResult.get(0) instanceof ImmutableEntityCost);
    EntityCostKind costKindResult = actualWithTopCostsResult.costKind();
    assertTrue(costKindResult instanceof ImmutableEntityCostKind);
    assertEquals("Name", costKindResult.name());
    assertEquals("The characteristics of someone or something", costKindResult.description());
    assertEquals(1, actualWithTopCostsResult.year());
    assertEquals(3, actualWithTopCostsResult.mappedCount());
    assertEquals(3, actualWithTopCostsResult.missingCount());
    assertEquals(EntityKind.ALL, costKindResult.kind());
    assertEquals(EntityKind.ALL, costKindResult.subjectKind());
    assertTrue(costKindResult.isDefault());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    assertEquals(expectedTotalResult, actualWithTopCostsResult.total());
  }

  /**
   * Test {@link ImmutableEntityCostsSummary#withTotal(BigDecimal)}.
   *
   * <p>Method under test: {@link ImmutableEntityCostsSummary#withTotal(BigDecimal)}
   */
  @Test
  @DisplayName("Test withTotal(BigDecimal)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityCostsSummary ImmutableEntityCostsSummary.withTotal(BigDecimal)"
  })
  void testWithTotal() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(3);
    ImmutableEntityCostsSummary immutableEntityCostsSummary =
        missingCountResult.total(new BigDecimal("2.3")).year(1).build();

    // Act
    ImmutableEntityCostsSummary actualWithTotalResult =
        immutableEntityCostsSummary.withTotal(new BigDecimal("2.3"));

    // Assert
    assertSame(immutableEntityCostsSummary, actualWithTotalResult);
  }

  /**
   * Test {@link ImmutableEntityCostsSummary#withTotal(BigDecimal)}.
   *
   * <ul>
   *   <li>Then costKind return {@link ImmutableEntityCostKind}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityCostsSummary#withTotal(BigDecimal)}
   */
  @Test
  @DisplayName("Test withTotal(BigDecimal); then costKind return ImmutableEntityCostKind")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityCostsSummary ImmutableEntityCostsSummary.withTotal(BigDecimal)"
  })
  void testWithTotal_thenCostKindReturnImmutableEntityCostKind() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(3);
    ImmutableEntityCostsSummary immutableEntityCostsSummary =
        missingCountResult.total(new BigDecimal("4.5")).year(1).build();

    // Act
    ImmutableEntityCostsSummary actualWithTotalResult =
        immutableEntityCostsSummary.withTotal(new BigDecimal("2.3"));

    // Assert
    EntityCostKind costKindResult = actualWithTotalResult.costKind();
    assertTrue(costKindResult instanceof ImmutableEntityCostKind);
    assertEquals("Name", costKindResult.name());
    assertEquals("The characteristics of someone or something", costKindResult.description());
    assertEquals(1, actualWithTotalResult.year());
    assertEquals(3, actualWithTotalResult.mappedCount());
    assertEquals(3, actualWithTotalResult.missingCount());
    assertEquals(EntityKind.ALL, costKindResult.kind());
    assertEquals(EntityKind.ALL, costKindResult.subjectKind());
    assertTrue(actualWithTotalResult.topCosts().isEmpty());
    assertTrue(costKindResult.isDefault());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    assertEquals(expectedTotalResult, actualWithTotalResult.total());
  }

  /**
   * Test {@link ImmutableEntityCostsSummary#withYear(int)}.
   *
   * <p>Method under test: {@link ImmutableEntityCostsSummary#withYear(int)}
   */
  @Test
  @DisplayName("Test withYear(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityCostsSummary ImmutableEntityCostsSummary.withYear(int)"})
  void testWithYear() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(3);
    ImmutableEntityCostsSummary immutableEntityCostsSummary =
        missingCountResult.total(new BigDecimal("2.3")).year(42).build();

    // Act
    ImmutableEntityCostsSummary actualWithYearResult = immutableEntityCostsSummary.withYear(42);

    // Assert
    assertSame(immutableEntityCostsSummary, actualWithYearResult);
  }

  /**
   * Test {@link ImmutableEntityCostsSummary#withYear(int)}.
   *
   * <ul>
   *   <li>Then costKind return {@link ImmutableEntityCostKind}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityCostsSummary#withYear(int)}
   */
  @Test
  @DisplayName("Test withYear(int); then costKind return ImmutableEntityCostKind")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityCostsSummary ImmutableEntityCostsSummary.withYear(int)"})
  void testWithYear_thenCostKindReturnImmutableEntityCostKind() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    Builder missingCountResult =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .mappedCount(3)
            .missingCount(3);

    // Act
    ImmutableEntityCostsSummary actualWithYearResult =
        missingCountResult.total(new BigDecimal("2.3")).year(1).build().withYear(42);

    // Assert
    EntityCostKind costKindResult = actualWithYearResult.costKind();
    assertTrue(costKindResult instanceof ImmutableEntityCostKind);
    assertEquals("Name", costKindResult.name());
    assertEquals("The characteristics of someone or something", costKindResult.description());
    assertEquals(3, actualWithYearResult.mappedCount());
    assertEquals(3, actualWithYearResult.missingCount());
    assertEquals(42, actualWithYearResult.year());
    assertEquals(EntityKind.ALL, costKindResult.kind());
    assertEquals(EntityKind.ALL, costKindResult.subjectKind());
    assertTrue(actualWithYearResult.topCosts().isEmpty());
    assertTrue(costKindResult.isDefault());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    assertEquals(expectedTotalResult, actualWithYearResult.total());
  }
}
