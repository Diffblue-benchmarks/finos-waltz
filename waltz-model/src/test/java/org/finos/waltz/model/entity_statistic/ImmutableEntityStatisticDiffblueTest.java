package org.finos.waltz.model.entity_statistic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.entity_statistic.ImmutableEntityStatistic.Builder;
import org.finos.waltz.model.entity_statistic.ImmutableEntityStatistic.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityStatisticDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityStatistic Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableEntityStatistic.builder();
    ImmutableEntityStatisticDefinition definition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();
    Builder actualDefinitionResult = actualBuilderResult.definition(definition);
    ImmutableEntityStatisticValue.Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue value =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();
    ImmutableEntityStatistic actualImmutableEntityStatistic =
        actualDefinitionResult.value(value).build();

    // Assert
    assertSame(definition, actualImmutableEntityStatistic.definition());
    assertSame(value, actualImmutableEntityStatistic.value());
  }

  /**
   * Test Builder {@link Builder#definition(EntityStatisticDefinition)}.
   *
   * <ul>
   *   <li>When {@link ImmutableEntityStatisticDefinition.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#definition(EntityStatisticDefinition)}
   */
  @Test
  @DisplayName(
      "Test Builder definition(EntityStatisticDefinition); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.definition(EntityStatisticDefinition)"})
  void testBuilderDefinition_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityStatistic.builder();

    // Act
    Builder actualDefinitionResult =
        builderResult.definition(new ImmutableEntityStatisticDefinition.Json());

    // Assert
    assertSame(builderResult, actualDefinitionResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityStatistic)}.
   *
   * <p>Method under test: {@link Builder#from(EntityStatistic)}
   */
  @Test
  @DisplayName("Test Builder from(EntityStatistic)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityStatistic)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableEntityStatistic.builder();

    Builder builderResult2 = ImmutableEntityStatistic.builder();

    Builder definitionResult =
        builderResult2.definition(
            ImmutableEntityStatisticDefinition.builder()
                .active(true)
                .category(StatisticCategory.COMPLIANCE)
                .description("The characteristics of someone or something")
                .entityVisibility(true)
                .historicRenderer("Historic Renderer")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .provenance("Provenance")
                .renderer("Renderer")
                .rollupKind(RollupKind.COUNT_BY_ENTITY)
                .rollupVisibility(true)
                .type(StatisticType.BOOLEAN)
                .build());

    ImmutableEntityStatisticValue.Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatistic instance =
        definitionResult
            .value(
                currentResult
                    .entity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .outcome("Outcome")
                    .provenance("Provenance")
                    .reason("Just cause")
                    .state(StatisticValueState.EXEMPT)
                    .statisticId(1L)
                    .value("42")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityStatistic actualImmutableEntityStatistic = builderResult.build();
    assertEquals(instance, actualImmutableEntityStatistic);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#value(EntityStatisticValue)}.
   *
   * <ul>
   *   <li>When {@link ImmutableEntityStatisticValue.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#value(EntityStatisticValue)}
   */
  @Test
  @DisplayName(
      "Test Builder value(EntityStatisticValue); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.value(EntityStatisticValue)"})
  void testBuilderValue_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityStatistic.builder();

    // Act
    Builder actualValueResult = builderResult.value(new ImmutableEntityStatisticValue.Json());

    // Assert
    assertSame(builderResult, actualValueResult);
  }

  /**
   * Test {@link ImmutableEntityStatistic#copyOf(EntityStatistic)}.
   *
   * <ul>
   *   <li>Then definition return {@link ImmutableEntityStatisticDefinition}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatistic#copyOf(EntityStatistic)}
   */
  @Test
  @DisplayName(
      "Test copyOf(EntityStatistic); then definition return ImmutableEntityStatisticDefinition")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityStatistic ImmutableEntityStatistic.copyOf(EntityStatistic)"})
  void testCopyOf_thenDefinitionReturnImmutableEntityStatisticDefinition() {
    // Arrange
    Builder builderResult = ImmutableEntityStatistic.builder();

    Builder definitionResult =
        builderResult.definition(
            ImmutableEntityStatisticDefinition.builder()
                .active(true)
                .category(StatisticCategory.COMPLIANCE)
                .description("The characteristics of someone or something")
                .entityVisibility(true)
                .historicRenderer("Historic Renderer")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .provenance("Provenance")
                .renderer("Renderer")
                .rollupKind(RollupKind.COUNT_BY_ENTITY)
                .rollupVisibility(true)
                .type(StatisticType.BOOLEAN)
                .build());

    ImmutableEntityStatisticValue.Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatistic instance =
        definitionResult
            .value(
                currentResult
                    .entity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .outcome("Outcome")
                    .provenance("Provenance")
                    .reason("Just cause")
                    .state(StatisticValueState.EXEMPT)
                    .statisticId(1L)
                    .value("42")
                    .build())
            .build();

    // Act
    ImmutableEntityStatistic actualCopyOfResult = ImmutableEntityStatistic.copyOf(instance);

    // Assert
    assertTrue(actualCopyOfResult.definition() instanceof ImmutableEntityStatisticDefinition);
    assertTrue(actualCopyOfResult.value() instanceof ImmutableEntityStatisticValue);
  }

  /**
   * Test {@link ImmutableEntityStatistic#equals(Object)}, and {@link
   * ImmutableEntityStatistic#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityStatistic#equals(Object)}
   *   <li>{@link ImmutableEntityStatistic#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatistic.equals(Object)",
    "int ImmutableEntityStatistic.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityStatistic.builder();

    Builder definitionResult =
        builderResult.definition(
            ImmutableEntityStatisticDefinition.builder()
                .active(true)
                .category(StatisticCategory.COMPLIANCE)
                .description("The characteristics of someone or something")
                .entityVisibility(true)
                .historicRenderer("Historic Renderer")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .provenance("Provenance")
                .renderer("Renderer")
                .rollupKind(RollupKind.COUNT_BY_ENTITY)
                .rollupVisibility(true)
                .type(StatisticType.BOOLEAN)
                .build());

    ImmutableEntityStatisticValue.Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatistic immutableEntityStatistic =
        definitionResult
            .value(
                currentResult
                    .entity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .outcome("Outcome")
                    .provenance("Provenance")
                    .reason("Just cause")
                    .state(StatisticValueState.EXEMPT)
                    .statisticId(1L)
                    .value("42")
                    .build())
            .build();

    Builder builderResult2 = ImmutableEntityStatistic.builder();

    Builder definitionResult2 =
        builderResult2.definition(
            ImmutableEntityStatisticDefinition.builder()
                .active(true)
                .category(StatisticCategory.COMPLIANCE)
                .description("The characteristics of someone or something")
                .entityVisibility(true)
                .historicRenderer("Historic Renderer")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .provenance("Provenance")
                .renderer("Renderer")
                .rollupKind(RollupKind.COUNT_BY_ENTITY)
                .rollupVisibility(true)
                .type(StatisticType.BOOLEAN)
                .build());

    ImmutableEntityStatisticValue.Builder currentResult2 =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatistic immutableEntityStatistic2 =
        definitionResult2
            .value(
                currentResult2
                    .entity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .outcome("Outcome")
                    .provenance("Provenance")
                    .reason("Just cause")
                    .state(StatisticValueState.EXEMPT)
                    .statisticId(1L)
                    .value("42")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableEntityStatistic, immutableEntityStatistic2);
    assertEquals(immutableEntityStatistic.hashCode(), immutableEntityStatistic2.hashCode());
  }

  /**
   * Test {@link ImmutableEntityStatistic#equals(Object)}, and {@link
   * ImmutableEntityStatistic#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityStatistic#equals(Object)}
   *   <li>{@link ImmutableEntityStatistic#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatistic.equals(Object)",
    "int ImmutableEntityStatistic.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityStatistic.builder();

    Builder definitionResult =
        builderResult.definition(
            ImmutableEntityStatisticDefinition.builder()
                .active(true)
                .category(StatisticCategory.COMPLIANCE)
                .description("The characteristics of someone or something")
                .entityVisibility(true)
                .historicRenderer("Historic Renderer")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .provenance("Provenance")
                .renderer("Renderer")
                .rollupKind(RollupKind.COUNT_BY_ENTITY)
                .rollupVisibility(true)
                .type(StatisticType.BOOLEAN)
                .build());

    ImmutableEntityStatisticValue.Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatistic immutableEntityStatistic =
        definitionResult
            .value(
                currentResult
                    .entity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .outcome("Outcome")
                    .provenance("Provenance")
                    .reason("Just cause")
                    .state(StatisticValueState.EXEMPT)
                    .statisticId(1L)
                    .value("42")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableEntityStatistic, immutableEntityStatistic);
    int expectedHashCodeResult = immutableEntityStatistic.hashCode();
    assertEquals(expectedHashCodeResult, immutableEntityStatistic.hashCode());
  }

  /**
   * Test {@link ImmutableEntityStatistic#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatistic#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatistic.equals(Object)",
    "int ImmutableEntityStatistic.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityStatistic.builder();

    Builder definitionResult =
        builderResult.definition(
            ImmutableEntityStatisticDefinition.builder()
                .active(false)
                .category(StatisticCategory.COMPLIANCE)
                .description("The characteristics of someone or something")
                .entityVisibility(true)
                .historicRenderer("Historic Renderer")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .provenance("Provenance")
                .renderer("Renderer")
                .rollupKind(RollupKind.COUNT_BY_ENTITY)
                .rollupVisibility(true)
                .type(StatisticType.BOOLEAN)
                .build());

    ImmutableEntityStatisticValue.Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatistic immutableEntityStatistic =
        definitionResult
            .value(
                currentResult
                    .entity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .outcome("Outcome")
                    .provenance("Provenance")
                    .reason("Just cause")
                    .state(StatisticValueState.EXEMPT)
                    .statisticId(1L)
                    .value("42")
                    .build())
            .build();

    Builder builderResult2 = ImmutableEntityStatistic.builder();

    Builder definitionResult2 =
        builderResult2.definition(
            ImmutableEntityStatisticDefinition.builder()
                .active(true)
                .category(StatisticCategory.COMPLIANCE)
                .description("The characteristics of someone or something")
                .entityVisibility(true)
                .historicRenderer("Historic Renderer")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .provenance("Provenance")
                .renderer("Renderer")
                .rollupKind(RollupKind.COUNT_BY_ENTITY)
                .rollupVisibility(true)
                .type(StatisticType.BOOLEAN)
                .build());

    ImmutableEntityStatisticValue.Builder currentResult2 =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);

    // Act and Assert
    assertNotEquals(
        immutableEntityStatistic,
        definitionResult2
            .value(
                currentResult2
                    .entity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .outcome("Outcome")
                    .provenance("Provenance")
                    .reason("Just cause")
                    .state(StatisticValueState.EXEMPT)
                    .statisticId(1L)
                    .value("42")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableEntityStatistic#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatistic#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatistic.equals(Object)",
    "int ImmutableEntityStatistic.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableEntityStatistic.builder();

    Builder definitionResult =
        builderResult.definition(
            ImmutableEntityStatisticDefinition.builder()
                .active(true)
                .category(StatisticCategory.COMPLIANCE)
                .description("The characteristics of someone or something")
                .entityVisibility(true)
                .historicRenderer("Historic Renderer")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .provenance("Provenance")
                .renderer("Renderer")
                .rollupKind(RollupKind.COUNT_BY_ENTITY)
                .rollupVisibility(true)
                .type(StatisticType.BOOLEAN)
                .build());

    ImmutableEntityStatisticValue.Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.now().atStartOfDay())
            .current(true);
    ImmutableEntityStatistic immutableEntityStatistic =
        definitionResult
            .value(
                currentResult
                    .entity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .outcome("Outcome")
                    .provenance("Provenance")
                    .reason("Just cause")
                    .state(StatisticValueState.EXEMPT)
                    .statisticId(1L)
                    .value("42")
                    .build())
            .build();

    Builder builderResult2 = ImmutableEntityStatistic.builder();

    Builder definitionResult2 =
        builderResult2.definition(
            ImmutableEntityStatisticDefinition.builder()
                .active(true)
                .category(StatisticCategory.COMPLIANCE)
                .description("The characteristics of someone or something")
                .entityVisibility(true)
                .historicRenderer("Historic Renderer")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .provenance("Provenance")
                .renderer("Renderer")
                .rollupKind(RollupKind.COUNT_BY_ENTITY)
                .rollupVisibility(true)
                .type(StatisticType.BOOLEAN)
                .build());

    ImmutableEntityStatisticValue.Builder currentResult2 =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);

    // Act and Assert
    assertNotEquals(
        immutableEntityStatistic,
        definitionResult2
            .value(
                currentResult2
                    .entity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .outcome("Outcome")
                    .provenance("Provenance")
                    .reason("Just cause")
                    .state(StatisticValueState.EXEMPT)
                    .statisticId(1L)
                    .value("42")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableEntityStatistic#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatistic#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatistic.equals(Object)",
    "int ImmutableEntityStatistic.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityStatistic.builder();

    Builder definitionResult =
        builderResult.definition(
            ImmutableEntityStatisticDefinition.builder()
                .active(true)
                .category(StatisticCategory.COMPLIANCE)
                .description("The characteristics of someone or something")
                .entityVisibility(true)
                .historicRenderer("Historic Renderer")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .provenance("Provenance")
                .renderer("Renderer")
                .rollupKind(RollupKind.COUNT_BY_ENTITY)
                .rollupVisibility(true)
                .type(StatisticType.BOOLEAN)
                .build());

    ImmutableEntityStatisticValue.Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);

    // Act and Assert
    assertNotEquals(
        definitionResult
            .value(
                currentResult
                    .entity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .outcome("Outcome")
                    .provenance("Provenance")
                    .reason("Just cause")
                    .state(StatisticValueState.EXEMPT)
                    .statisticId(1L)
                    .value("42")
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableEntityStatistic#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatistic#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatistic.equals(Object)",
    "int ImmutableEntityStatistic.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityStatistic.builder();

    Builder definitionResult =
        builderResult.definition(
            ImmutableEntityStatisticDefinition.builder()
                .active(true)
                .category(StatisticCategory.COMPLIANCE)
                .description("The characteristics of someone or something")
                .entityVisibility(true)
                .historicRenderer("Historic Renderer")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .provenance("Provenance")
                .renderer("Renderer")
                .rollupKind(RollupKind.COUNT_BY_ENTITY)
                .rollupVisibility(true)
                .type(StatisticType.BOOLEAN)
                .build());

    ImmutableEntityStatisticValue.Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);

    // Act and Assert
    assertNotEquals(
        definitionResult
            .value(
                currentResult
                    .entity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .outcome("Outcome")
                    .provenance("Provenance")
                    .reason("Just cause")
                    .state(StatisticValueState.EXEMPT)
                    .statisticId(1L)
                    .value("42")
                    .build())
            .build(),
        "Different type to ImmutableEntityStatistic");
  }

  /**
   * Test {@link ImmutableEntityStatistic#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ImmutableEntityStatisticDefinition.Json} (default constructor).
   *   <li>When {@link Json} (default constructor) Definition is {@link
   *       ImmutableEntityStatisticDefinition.Json} (default constructor).
   *   <li>Then definition return {@link ImmutableEntityStatisticDefinition.Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatistic#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given Json (default constructor); when Json (default constructor) Definition is Json (default constructor); then definition return Json")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityStatistic ImmutableEntityStatistic.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonDefinitionIsJson_thenDefinitionReturnJson() {
    // Arrange
    Json json = new Json();
    ImmutableEntityStatisticDefinition.Json definition =
        new ImmutableEntityStatisticDefinition.Json();
    json.setDefinition(definition);
    ImmutableEntityStatisticValue.Json value = new ImmutableEntityStatisticValue.Json();
    json.setValue(value);

    // Act
    ImmutableEntityStatistic actualFromJsonResult = ImmutableEntityStatistic.fromJson(json);

    // Assert
    EntityStatisticDefinition definitionResult = actualFromJsonResult.definition();
    assertTrue(definitionResult instanceof ImmutableEntityStatisticDefinition.Json);
    EntityStatisticValue valueResult = actualFromJsonResult.value();
    assertTrue(valueResult instanceof ImmutableEntityStatisticValue.Json);
    assertSame(definition, definitionResult);
    assertSame(value, valueResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityStatistic#toString()}
   *   <li>{@link ImmutableEntityStatistic#definition()}
   *   <li>{@link ImmutableEntityStatistic#value()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityStatisticDefinition ImmutableEntityStatistic.definition()",
    "String ImmutableEntityStatistic.toString()",
    "EntityStatisticValue ImmutableEntityStatistic.value()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableEntityStatistic.builder();

    Builder definitionResult =
        builderResult.definition(
            ImmutableEntityStatisticDefinition.builder()
                .active(true)
                .category(StatisticCategory.COMPLIANCE)
                .description("The characteristics of someone or something")
                .entityVisibility(true)
                .historicRenderer("Historic Renderer")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .provenance("Provenance")
                .renderer("Renderer")
                .rollupKind(RollupKind.COUNT_BY_ENTITY)
                .rollupVisibility(true)
                .type(StatisticType.BOOLEAN)
                .build());

    ImmutableEntityStatisticValue.Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatistic immutableEntityStatistic =
        definitionResult
            .value(
                currentResult
                    .entity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .outcome("Outcome")
                    .provenance("Provenance")
                    .reason("Just cause")
                    .state(StatisticValueState.EXEMPT)
                    .statisticId(1L)
                    .value("42")
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableEntityStatistic.toString();
    EntityStatisticDefinition actualDefinitionResult = immutableEntityStatistic.definition();

    // Assert
    assertTrue(actualDefinitionResult instanceof ImmutableEntityStatisticDefinition);
    assertTrue(immutableEntityStatistic.value() instanceof ImmutableEntityStatisticValue);
    assertEquals(
        "EntityStatistic{definition=EntityStatisticDefinition{id=1, name=Name, provenance=Provenance, parentId=1,"
            + " type=BOOLEAN, category=COMPLIANCE, active=true, rollupKind=COUNT_BY_ENTITY, renderer=Renderer,"
            + " historicRenderer=Historic Renderer, entityVisibility=true, rollupVisibility=true, kind=ALL},"
            + " value=EntityStatisticValue{id=1, provenance=Provenance, statisticId=1, entity=EntityReference{kind=ALL,"
            + " id=1, entityLifecycleStatus=ACTIVE}, value=42, outcome=Outcome, state=EXEMPT, reason=Just cause,"
            + " createdAt=1970-01-01T00:00, current=true}}",
        actualToStringResult);
  }

  /**
   * Test Json {@link Json#definition()}.
   *
   * <p>Method under test: {@link Json#definition()}
   */
  @Test
  @DisplayName("Test Json definition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityStatisticDefinition Json.definition()"})
  void testJsonDefinition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().definition());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDefinition(EntityStatisticDefinition)}
   *   <li>{@link Json#setValue(EntityStatisticValue)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setDefinition(EntityStatisticDefinition)",
    "void Json.setValue(EntityStatisticValue)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDefinition(
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build());
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableEntityStatisticValue.Builder currentResult =
        ImmutableEntityStatisticValue.builder().createdAt(ofResult.atStartOfDay()).current(true);
    actualJson.setValue(
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build());

    // Assert
    EntityStatisticValue entityStatisticValue = actualJson.value;
    EntityReference entityResult = entityStatisticValue.entity();
    assertTrue(entityResult instanceof ImmutableEntityReference);
    EntityStatisticDefinition entityStatisticDefinition = actualJson.definition;
    assertTrue(entityStatisticDefinition instanceof ImmutableEntityStatisticDefinition);
    assertTrue(entityStatisticValue instanceof ImmutableEntityStatisticValue);
    LocalDateTime createdAtResult = entityStatisticValue.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", entityStatisticValue.value());
    assertEquals("Historic Renderer", entityStatisticDefinition.historicRenderer());
    assertEquals("Just cause", entityStatisticValue.reason());
    assertEquals("Name", entityStatisticDefinition.name());
    assertEquals("Outcome", entityStatisticValue.outcome());
    assertEquals("Provenance", entityStatisticDefinition.provenance());
    assertEquals("Provenance", entityStatisticValue.provenance());
    assertEquals("Renderer", entityStatisticDefinition.renderer());
    assertEquals("The characteristics of someone or something", entityResult.description());
    assertEquals(
        "The characteristics of someone or something", entityStatisticDefinition.description());
    assertEquals(1L, entityResult.id());
    assertEquals(1L, entityStatisticValue.statisticId());
    assertEquals(EntityKind.ALL, entityResult.kind());
    assertEquals(EntityKind.ALL, entityStatisticDefinition.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityResult.entityLifecycleStatus());
    assertEquals(RollupKind.COUNT_BY_ENTITY, entityStatisticDefinition.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, entityStatisticDefinition.category());
    assertEquals(StatisticType.BOOLEAN, entityStatisticDefinition.type());
    assertEquals(StatisticValueState.EXEMPT, entityStatisticValue.state());
    assertTrue(entityStatisticDefinition.active());
    assertTrue(entityStatisticDefinition.entityVisibility());
    assertTrue(entityStatisticDefinition.rollupVisibility());
    assertTrue(entityStatisticValue.current());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test Json {@link Json#value()}.
   *
   * <p>Method under test: {@link Json#value()}
   */
  @Test
  @DisplayName("Test Json value()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityStatisticValue Json.value()"})
  void testJsonValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().value());
  }

  /**
   * Test {@link ImmutableEntityStatistic#withDefinition(EntityStatisticDefinition)}.
   *
   * <p>Method under test: {@link
   * ImmutableEntityStatistic#withDefinition(EntityStatisticDefinition)}
   */
  @Test
  @DisplayName("Test withDefinition(EntityStatisticDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatistic ImmutableEntityStatistic.withDefinition(EntityStatisticDefinition)"
  })
  void testWithDefinition() {
    // Arrange
    Builder builderResult = ImmutableEntityStatistic.builder();

    Builder definitionResult =
        builderResult.definition(
            ImmutableEntityStatisticDefinition.builder()
                .active(true)
                .category(StatisticCategory.COMPLIANCE)
                .description("The characteristics of someone or something")
                .entityVisibility(true)
                .historicRenderer("Historic Renderer")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .provenance("Provenance")
                .renderer("Renderer")
                .rollupKind(RollupKind.COUNT_BY_ENTITY)
                .rollupVisibility(true)
                .type(StatisticType.BOOLEAN)
                .build());

    ImmutableEntityStatisticValue.Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatistic immutableEntityStatistic =
        definitionResult
            .value(
                currentResult
                    .entity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .outcome("Outcome")
                    .provenance("Provenance")
                    .reason("Just cause")
                    .state(StatisticValueState.EXEMPT)
                    .statisticId(1L)
                    .value("42")
                    .build())
            .build();

    // Act
    ImmutableEntityStatistic actualWithDefinitionResult =
        immutableEntityStatistic.withDefinition(
            ImmutableEntityStatisticDefinition.builder()
                .active(true)
                .category(StatisticCategory.COMPLIANCE)
                .description("The characteristics of someone or something")
                .entityVisibility(true)
                .historicRenderer("Historic Renderer")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .provenance("Provenance")
                .renderer("Renderer")
                .rollupKind(RollupKind.COUNT_BY_ENTITY)
                .rollupVisibility(true)
                .type(StatisticType.BOOLEAN)
                .build());

    // Assert
    assertEquals(immutableEntityStatistic, actualWithDefinitionResult);
  }

  /**
   * Test {@link ImmutableEntityStatistic#withValue(EntityStatisticValue)}.
   *
   * <p>Method under test: {@link ImmutableEntityStatistic#withValue(EntityStatisticValue)}
   */
  @Test
  @DisplayName("Test withValue(EntityStatisticValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatistic ImmutableEntityStatistic.withValue(EntityStatisticValue)"
  })
  void testWithValue() {
    // Arrange
    Builder builderResult = ImmutableEntityStatistic.builder();

    Builder definitionResult =
        builderResult.definition(
            ImmutableEntityStatisticDefinition.builder()
                .active(true)
                .category(StatisticCategory.COMPLIANCE)
                .description("The characteristics of someone or something")
                .entityVisibility(true)
                .historicRenderer("Historic Renderer")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .provenance("Provenance")
                .renderer("Renderer")
                .rollupKind(RollupKind.COUNT_BY_ENTITY)
                .rollupVisibility(true)
                .type(StatisticType.BOOLEAN)
                .build());

    ImmutableEntityStatisticValue.Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatistic immutableEntityStatistic =
        definitionResult
            .value(
                currentResult
                    .entity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .outcome("Outcome")
                    .provenance("Provenance")
                    .reason("Just cause")
                    .state(StatisticValueState.EXEMPT)
                    .statisticId(1L)
                    .value("42")
                    .build())
            .build();

    ImmutableEntityStatisticValue.Builder currentResult2 =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);

    // Act
    ImmutableEntityStatistic actualWithValueResult =
        immutableEntityStatistic.withValue(
            currentResult2
                .entity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .outcome("Outcome")
                .provenance("Provenance")
                .reason("Just cause")
                .state(StatisticValueState.EXEMPT)
                .statisticId(1L)
                .value("42")
                .build());

    // Assert
    assertEquals(immutableEntityStatistic, actualWithValueResult);
  }
}
