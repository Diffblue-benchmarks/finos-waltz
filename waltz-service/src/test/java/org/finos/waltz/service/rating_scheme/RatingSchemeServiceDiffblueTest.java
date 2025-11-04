package org.finos.waltz.service.rating_scheme;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.data.rating_scheme.RatingSchemeDAO;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.rating.RatingScheme;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItemUsageCount;
import org.jooq.Condition;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RatingSchemeServiceDiffblueTest {
  /**
   * Method under test: {@link RatingSchemeService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ArrayList<RatingScheme> ratingSchemeList = new ArrayList<>();
    when(ratingSchemeDAO.findAll()).thenReturn(ratingSchemeList);

    // Act
    Collection<RatingScheme> actualFindAllResult = (new RatingSchemeService(ratingSchemeDAO)).findAll();

    // Assert
    verify(ratingSchemeDAO).findAll();
    assertTrue(actualFindAllResult instanceof List);
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(ratingSchemeList, actualFindAllResult);
  }

  /**
   * Method under test: {@link RatingSchemeService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.getById(anyLong())).thenReturn(null);

    // Act
    RatingScheme actualById = (new RatingSchemeService(ratingSchemeDAO)).getById(1L);

    // Assert
    verify(ratingSchemeDAO).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link RatingSchemeService#findAllRatingSchemeItems()}
   */
  @Test
  void testFindAllRatingSchemeItems() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    when(ratingSchemeDAO.fetchItems(Mockito.<Condition>any())).thenReturn(ratingSchemeItemList);

    // Act
    List<RatingSchemeItem> actualFindAllRatingSchemeItemsResult = (new RatingSchemeService(ratingSchemeDAO))
        .findAllRatingSchemeItems();

    // Assert
    verify(ratingSchemeDAO).fetchItems(isA(Condition.class));
    assertTrue(actualFindAllRatingSchemeItemsResult.isEmpty());
    assertSame(ratingSchemeItemList, actualFindAllRatingSchemeItemsResult);
  }

  /**
   * Method under test:
   * {@link RatingSchemeService#findRatingSchemeItemsByAssessmentDefinition(long)}
   */
  @Test
  void testFindRatingSchemeItemsByAssessmentDefinition() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenReturn(ratingSchemeItemList);

    // Act
    List<RatingSchemeItem> actualFindRatingSchemeItemsByAssessmentDefinitionResult = (new RatingSchemeService(
        ratingSchemeDAO)).findRatingSchemeItemsByAssessmentDefinition(1L);

    // Assert
    verify(ratingSchemeDAO).findRatingSchemeItemsForAssessmentDefinition(eq(1L));
    assertTrue(actualFindRatingSchemeItemsByAssessmentDefinitionResult.isEmpty());
    assertSame(ratingSchemeItemList, actualFindRatingSchemeItemsByAssessmentDefinitionResult);
  }

  /**
   * Method under test:
   * {@link RatingSchemeService#findRatingSchemeItemsForEntityAndCategory(EntityReference, long)}
   */
  @Test
  void testFindRatingSchemeItemsForEntityAndCategory() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    when(ratingSchemeDAO.findRatingSchemeItemsForEntityAndCategory(Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(ratingSchemeItemList);

    // Act
    List<RatingSchemeItem> actualFindRatingSchemeItemsForEntityAndCategoryResult = (new RatingSchemeService(
        ratingSchemeDAO)).findRatingSchemeItemsForEntityAndCategory(null, 1L);

    // Assert
    verify(ratingSchemeDAO).findRatingSchemeItemsForEntityAndCategory(isNull(), eq(1L));
    assertTrue(actualFindRatingSchemeItemsForEntityAndCategoryResult.isEmpty());
    assertSame(ratingSchemeItemList, actualFindRatingSchemeItemsForEntityAndCategoryResult);
  }

  /**
   * Method under test:
   * {@link RatingSchemeService#findRatingSchemeItemsByIds(Set)}
   */
  @Test
  void testFindRatingSchemeItemsByIds() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any())).thenReturn(ratingSchemeItemSet);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(ratingSchemeDAO);

    // Act
    Set<RatingSchemeItem> actualFindRatingSchemeItemsByIdsResult = ratingSchemeService
        .findRatingSchemeItemsByIds(new HashSet<>());

    // Assert
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualFindRatingSchemeItemsByIdsResult.isEmpty());
    assertSame(ratingSchemeItemSet, actualFindRatingSchemeItemsByIdsResult);
  }

  /**
   * Method under test:
   * {@link RatingSchemeService#findRatingSchemeItemsByIds(Set)}
   */
  @Test
  void testFindRatingSchemeItemsByIds2() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any())).thenReturn(ratingSchemeItemSet);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(ratingSchemeDAO);

    HashSet<Long> ids = new HashSet<>();
    ids.add(1L);

    // Act
    Set<RatingSchemeItem> actualFindRatingSchemeItemsByIdsResult = ratingSchemeService.findRatingSchemeItemsByIds(ids);

    // Assert
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualFindRatingSchemeItemsByIdsResult.isEmpty());
    assertSame(ratingSchemeItemSet, actualFindRatingSchemeItemsByIdsResult);
  }

  /**
   * Method under test:
   * {@link RatingSchemeService#findRatingSchemeItemsByIds(Set)}
   */
  @Test
  void testFindRatingSchemeItemsByIds3() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any())).thenReturn(ratingSchemeItemSet);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(ratingSchemeDAO);

    HashSet<Long> ids = new HashSet<>();
    ids.add(0L);
    ids.add(1L);

    // Act
    Set<RatingSchemeItem> actualFindRatingSchemeItemsByIdsResult = ratingSchemeService.findRatingSchemeItemsByIds(ids);

    // Assert
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualFindRatingSchemeItemsByIdsResult.isEmpty());
    assertSame(ratingSchemeItemSet, actualFindRatingSchemeItemsByIdsResult);
  }

  /**
   * Method under test: {@link RatingSchemeService#save(RatingScheme)}
   */
  @Test
  void testSave() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.save(Mockito.<RatingScheme>any())).thenReturn(true);

    // Act
    Boolean actualSaveResult = (new RatingSchemeService(ratingSchemeDAO)).save(null);

    // Assert
    verify(ratingSchemeDAO).save(isNull());
    assertTrue(actualSaveResult);
  }

  /**
   * Method under test: {@link RatingSchemeService#save(RatingScheme)}
   */
  @Test
  void testSave2() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.save(Mockito.<RatingScheme>any())).thenReturn(false);

    // Act
    Boolean actualSaveResult = (new RatingSchemeService(ratingSchemeDAO)).save(null);

    // Assert
    verify(ratingSchemeDAO).save(isNull());
    assertFalse(actualSaveResult);
  }

  /**
   * Method under test:
   * {@link RatingSchemeService#saveRatingItem(long, RatingSchemeItem)}
   */
  @Test
  void testSaveRatingItem() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.saveRatingItem(anyLong(), Mockito.<RatingSchemeItem>any())).thenReturn(1L);

    // Act
    Long actualSaveRatingItemResult = (new RatingSchemeService(ratingSchemeDAO)).saveRatingItem(1L, null);

    // Assert
    verify(ratingSchemeDAO).saveRatingItem(eq(1L), isNull());
    assertEquals(1L, actualSaveRatingItemResult.longValue());
  }

  /**
   * Method under test: {@link RatingSchemeService#removeRatingItem(long)}
   */
  @Test
  void testRemoveRatingItem() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.removeRatingItem(anyLong())).thenReturn(true);

    // Act
    Boolean actualRemoveRatingItemResult = (new RatingSchemeService(ratingSchemeDAO)).removeRatingItem(1L);

    // Assert
    verify(ratingSchemeDAO).removeRatingItem(eq(1L));
    assertTrue(actualRemoveRatingItemResult);
  }

  /**
   * Method under test: {@link RatingSchemeService#removeRatingItem(long)}
   */
  @Test
  void testRemoveRatingItem2() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.removeRatingItem(anyLong())).thenReturn(false);

    // Act
    Boolean actualRemoveRatingItemResult = (new RatingSchemeService(ratingSchemeDAO)).removeRatingItem(1L);

    // Assert
    verify(ratingSchemeDAO).removeRatingItem(eq(1L));
    assertFalse(actualRemoveRatingItemResult);
  }

  /**
   * Method under test: {@link RatingSchemeService#calcRatingUsageStats()}
   */
  @Test
  void testCalcRatingUsageStats() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ArrayList<RatingSchemeItemUsageCount> ratingSchemeItemUsageCountList = new ArrayList<>();
    when(ratingSchemeDAO.calcRatingUsageStats()).thenReturn(ratingSchemeItemUsageCountList);

    // Act
    List<RatingSchemeItemUsageCount> actualCalcRatingUsageStatsResult = (new RatingSchemeService(ratingSchemeDAO))
        .calcRatingUsageStats();

    // Assert
    verify(ratingSchemeDAO).calcRatingUsageStats();
    assertTrue(actualCalcRatingUsageStatsResult.isEmpty());
    assertSame(ratingSchemeItemUsageCountList, actualCalcRatingUsageStatsResult);
  }

  /**
   * Method under test: {@link RatingSchemeService#removeRatingScheme(long)}
   */
  @Test
  void testRemoveRatingScheme() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.removeRatingScheme(anyLong())).thenReturn(true);

    // Act
    Boolean actualRemoveRatingSchemeResult = (new RatingSchemeService(ratingSchemeDAO)).removeRatingScheme(1L);

    // Assert
    verify(ratingSchemeDAO).removeRatingScheme(eq(1L));
    assertTrue(actualRemoveRatingSchemeResult);
  }

  /**
   * Method under test: {@link RatingSchemeService#removeRatingScheme(long)}
   */
  @Test
  void testRemoveRatingScheme2() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.removeRatingScheme(anyLong())).thenReturn(false);

    // Act
    Boolean actualRemoveRatingSchemeResult = (new RatingSchemeService(ratingSchemeDAO)).removeRatingScheme(1L);

    // Assert
    verify(ratingSchemeDAO).removeRatingScheme(eq(1L));
    assertFalse(actualRemoveRatingSchemeResult);
  }

  /**
   * Method under test:
   * {@link RatingSchemeService#findRatingSchemeItemsBySchemeIds(Set)}
   */
  @Test
  void testFindRatingSchemeItemsBySchemeIds() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any())).thenReturn(ratingSchemeItemSet);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(ratingSchemeDAO);

    // Act
    Set<RatingSchemeItem> actualFindRatingSchemeItemsBySchemeIdsResult = ratingSchemeService
        .findRatingSchemeItemsBySchemeIds(new HashSet<>());

    // Assert
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    assertTrue(actualFindRatingSchemeItemsBySchemeIdsResult.isEmpty());
    assertSame(ratingSchemeItemSet, actualFindRatingSchemeItemsBySchemeIdsResult);
  }

  /**
   * Method under test:
   * {@link RatingSchemeService#findRatingSchemeItemsBySchemeIds(Set)}
   */
  @Test
  void testFindRatingSchemeItemsBySchemeIds2() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any())).thenReturn(ratingSchemeItemSet);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(ratingSchemeDAO);

    HashSet<Long> schemeIds = new HashSet<>();
    schemeIds.add(1L);

    // Act
    Set<RatingSchemeItem> actualFindRatingSchemeItemsBySchemeIdsResult = ratingSchemeService
        .findRatingSchemeItemsBySchemeIds(schemeIds);

    // Assert
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    assertTrue(actualFindRatingSchemeItemsBySchemeIdsResult.isEmpty());
    assertSame(ratingSchemeItemSet, actualFindRatingSchemeItemsBySchemeIdsResult);
  }

  /**
   * Method under test:
   * {@link RatingSchemeService#findRatingSchemeItemsBySchemeIds(Set)}
   */
  @Test
  void testFindRatingSchemeItemsBySchemeIds3() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any())).thenReturn(ratingSchemeItemSet);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(ratingSchemeDAO);

    HashSet<Long> schemeIds = new HashSet<>();
    schemeIds.add(0L);
    schemeIds.add(1L);

    // Act
    Set<RatingSchemeItem> actualFindRatingSchemeItemsBySchemeIdsResult = ratingSchemeService
        .findRatingSchemeItemsBySchemeIds(schemeIds);

    // Assert
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    assertTrue(actualFindRatingSchemeItemsBySchemeIdsResult.isEmpty());
    assertSame(ratingSchemeItemSet, actualFindRatingSchemeItemsBySchemeIdsResult);
  }
}
