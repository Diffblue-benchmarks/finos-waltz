package org.finos.waltz.model.entity_statistic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityStatisticDefinitionDiffblueTest {
  /**
   * Test {@link EntityStatisticDefinition#rollupKind()}.
   *
   * <ul>
   *   <li>Then return {@code COUNT_BY_ENTITY}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticDefinition#rollupKind()}
   */
  @Test
  @DisplayName("Test rollupKind(); then return 'COUNT_BY_ENTITY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RollupKind EntityStatisticDefinition.rollupKind()"})
  void testRollupKind_thenReturnCountByEntity() {
    // Arrange, Act and Assert
    assertEquals(
        RollupKind.COUNT_BY_ENTITY,
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
            .build()
            .rollupKind());
  }

  /**
   * Test {@link EntityStatisticDefinition#kind()}.
   *
   * <ul>
   *   <li>Then return {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticDefinition#kind()}
   */
  @Test
  @DisplayName("Test kind(); then return 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind EntityStatisticDefinition.kind()"})
  void testKind_thenReturnAll() {
    // Arrange, Act and Assert
    assertEquals(
        EntityKind.ALL,
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
            .build()
            .kind());
  }
}
