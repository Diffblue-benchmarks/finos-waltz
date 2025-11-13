package org.finos.waltz.data.entity_statistic;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import org.finos.waltz.data.DBExecutorPoolInterface;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityStatisticSummaryDaoDiffblueTest {
  /**
   * Test {@link EntityStatisticSummaryDao#generateWithAvgByValue(Collection, Select)} with {@code
   * statisticIds}, {@code appIdSelector}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticSummaryDao#generateWithAvgByValue(Collection,
   * Select)}
   */
  @Test
  @DisplayName(
      "Test generateWithAvgByValue(Collection, Select) with 'statisticIds', 'appIdSelector'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List EntityStatisticSummaryDao.generateWithAvgByValue(Collection, Select)"
  })
  void testGenerateWithAvgByValueWithStatisticIdsAppIdSelector_thenReturnEmpty() {
    // Arrange
    EntityStatisticSummaryDao entityStatisticSummaryDao =
        new EntityStatisticSummaryDao(
            new DefaultDSLContext(SQLDialect.SQL99), mock(DBExecutorPoolInterface.class));

    // Act and Assert
    assertTrue(
        entityStatisticSummaryDao
            .generateWithAvgByValue(new ArrayList<>(), mock(Select.class))
            .isEmpty());
  }

  /**
   * Test {@link EntityStatisticSummaryDao#generateWithSumByValue(Collection, Select)} with {@code
   * statisticIds}, {@code appIdSelector}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticSummaryDao#generateWithSumByValue(Collection,
   * Select)}
   */
  @Test
  @DisplayName(
      "Test generateWithSumByValue(Collection, Select) with 'statisticIds', 'appIdSelector'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List EntityStatisticSummaryDao.generateWithSumByValue(Collection, Select)"
  })
  void testGenerateWithSumByValueWithStatisticIdsAppIdSelector_thenReturnEmpty() {
    // Arrange
    EntityStatisticSummaryDao entityStatisticSummaryDao =
        new EntityStatisticSummaryDao(
            new DefaultDSLContext(SQLDialect.SQL99), mock(DBExecutorPoolInterface.class));

    // Act and Assert
    assertTrue(
        entityStatisticSummaryDao
            .generateWithSumByValue(new ArrayList<>(), mock(Select.class))
            .isEmpty());
  }

  /**
   * Test {@link EntityStatisticSummaryDao#generateWithCountByEntity(Collection, Select)} with
   * {@code statisticIds}, {@code appIdSelector}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticSummaryDao#generateWithCountByEntity(Collection,
   * Select)}
   */
  @Test
  @DisplayName(
      "Test generateWithCountByEntity(Collection, Select) with 'statisticIds', 'appIdSelector'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List EntityStatisticSummaryDao.generateWithCountByEntity(Collection, Select)"
  })
  void testGenerateWithCountByEntityWithStatisticIdsAppIdSelector_thenReturnEmpty() {
    // Arrange
    EntityStatisticSummaryDao entityStatisticSummaryDao =
        new EntityStatisticSummaryDao(
            new DefaultDSLContext(SQLDialect.SQL99), mock(DBExecutorPoolInterface.class));

    // Act and Assert
    assertTrue(
        entityStatisticSummaryDao
            .generateWithCountByEntity(new ArrayList<>(), mock(Select.class))
            .isEmpty());
  }

  /**
   * Test {@link EntityStatisticSummaryDao#generateWithNoRollup(Collection, EntityReference)} with
   * {@code statisticIds}, {@code entityReference}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticSummaryDao#generateWithNoRollup(Collection,
   * EntityReference)}
   */
  @Test
  @DisplayName(
      "Test generateWithNoRollup(Collection, EntityReference) with 'statisticIds', 'entityReference'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List EntityStatisticSummaryDao.generateWithNoRollup(Collection, EntityReference)"
  })
  void testGenerateWithNoRollupWithStatisticIdsEntityReference_thenReturnEmpty() {
    // Arrange
    EntityStatisticSummaryDao entityStatisticSummaryDao =
        new EntityStatisticSummaryDao(
            new DefaultDSLContext(SQLDialect.SQL99), mock(DBExecutorPoolInterface.class));
    ArrayList<Long> statisticIds = new ArrayList<>();

    // Act and Assert
    assertTrue(
        entityStatisticSummaryDao
            .generateWithNoRollup(
                statisticIds,
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isEmpty());
  }
}
