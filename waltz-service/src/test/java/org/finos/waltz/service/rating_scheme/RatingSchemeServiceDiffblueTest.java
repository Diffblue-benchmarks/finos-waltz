package org.finos.waltz.service.rating_scheme;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.data.rating_scheme.RatingSchemeDAO;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.rating.ImmutableRatingScheme;
import org.finos.waltz.model.rating.ImmutableRatingScheme.Builder;
import org.finos.waltz.model.rating.RatingScheme;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItemUsageCount;
import org.jooq.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RatingSchemeServiceDiffblueTest {
  /**
   * Test {@link RatingSchemeService#findAll()}.
   *
   * <p>Method under test: {@link RatingSchemeService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection RatingSchemeService.findAll()"})
  void testFindAll() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ArrayList<RatingScheme> ratingSchemeList = new ArrayList<>();
    when(ratingSchemeDAO.findAll()).thenReturn(ratingSchemeList);

    // Act
    Collection<RatingScheme> actualFindAllResult =
        new RatingSchemeService(ratingSchemeDAO).findAll();

    // Assert
    verify(ratingSchemeDAO).findAll();
    assertTrue(actualFindAllResult instanceof List);
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(ratingSchemeList, actualFindAllResult);
  }

  /**
   * Test {@link RatingSchemeService#getById(long)}.
   *
   * <p>Method under test: {@link RatingSchemeService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RatingScheme RatingSchemeService.getById(long)"})
  void testGetById() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);

    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");
    when(ratingSchemeDAO.getById(anyLong()))
        .thenReturn(nameResult.addAllRatings(new ArrayList<>()).build());

    // Act
    RatingScheme actualById = new RatingSchemeService(ratingSchemeDAO).getById(1L);

    // Assert
    verify(ratingSchemeDAO).getById(1L);
    assertTrue(actualById instanceof ImmutableRatingScheme);
    assertEquals("Name", actualById.name());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertTrue(actualById.ratings().isEmpty());
  }

  /**
   * Test {@link RatingSchemeService#findAllRatingSchemeItems()}.
   *
   * <p>Method under test: {@link RatingSchemeService#findAllRatingSchemeItems()}
   */
  @Test
  @DisplayName("Test findAllRatingSchemeItems()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RatingSchemeService.findAllRatingSchemeItems()"})
  void testFindAllRatingSchemeItems() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.fetchItems(Mockito.<Condition>any())).thenReturn(new ArrayList<>());

    // Act
    List<RatingSchemeItem> actualFindAllRatingSchemeItemsResult =
        new RatingSchemeService(ratingSchemeDAO).findAllRatingSchemeItems();

    // Assert
    verify(ratingSchemeDAO).fetchItems(isA(Condition.class));
    assertTrue(actualFindAllRatingSchemeItemsResult.isEmpty());
  }

  /**
   * Test {@link RatingSchemeService#findRatingSchemeItemsByAssessmentDefinition(long)}.
   *
   * <p>Method under test: {@link
   * RatingSchemeService#findRatingSchemeItemsByAssessmentDefinition(long)}
   */
  @Test
  @DisplayName("Test findRatingSchemeItemsByAssessmentDefinition(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RatingSchemeService.findRatingSchemeItemsByAssessmentDefinition(long)"})
  void testFindRatingSchemeItemsByAssessmentDefinition() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<RatingSchemeItem> actualFindRatingSchemeItemsByAssessmentDefinitionResult =
        new RatingSchemeService(ratingSchemeDAO).findRatingSchemeItemsByAssessmentDefinition(1L);

    // Assert
    verify(ratingSchemeDAO).findRatingSchemeItemsForAssessmentDefinition(1L);
    assertTrue(actualFindRatingSchemeItemsByAssessmentDefinitionResult.isEmpty());
  }

  /**
   * Test {@link RatingSchemeService#findRatingSchemeItemsForEntityAndCategory(EntityReference,
   * long)}.
   *
   * <p>Method under test: {@link
   * RatingSchemeService#findRatingSchemeItemsForEntityAndCategory(EntityReference, long)}
   */
  @Test
  @DisplayName("Test findRatingSchemeItemsForEntityAndCategory(EntityReference, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RatingSchemeService.findRatingSchemeItemsForEntityAndCategory(EntityReference, long)"
  })
  void testFindRatingSchemeItemsForEntityAndCategory() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForEntityAndCategory(
            Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(new ArrayList<>());

    // Act
    List<RatingSchemeItem> actualFindRatingSchemeItemsForEntityAndCategoryResult =
        new RatingSchemeService(ratingSchemeDAO)
            .findRatingSchemeItemsForEntityAndCategory(null, 1L);

    // Assert
    verify(ratingSchemeDAO).findRatingSchemeItemsForEntityAndCategory(isNull(), eq(1L));
    assertTrue(actualFindRatingSchemeItemsForEntityAndCategoryResult.isEmpty());
  }

  /**
   * Test {@link RatingSchemeService#findRatingSchemeItemsByIds(Set)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link HashSet#HashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeService#findRatingSchemeItemsByIds(Set)}
   */
  @Test
  @DisplayName("Test findRatingSchemeItemsByIds(Set); given one; when HashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set RatingSchemeService.findRatingSchemeItemsByIds(Set)"})
  void testFindRatingSchemeItemsByIds_givenOne_whenHashSetAddOne() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    RatingSchemeService ratingSchemeService = new RatingSchemeService(ratingSchemeDAO);

    HashSet<Long> ids = new HashSet<>();
    ids.add(1L);

    // Act
    Set<RatingSchemeItem> actualFindRatingSchemeItemsByIdsResult =
        ratingSchemeService.findRatingSchemeItemsByIds(ids);

    // Assert
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualFindRatingSchemeItemsByIdsResult.isEmpty());
  }

  /**
   * Test {@link RatingSchemeService#findRatingSchemeItemsByIds(Set)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link HashSet#HashSet()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeService#findRatingSchemeItemsByIds(Set)}
   */
  @Test
  @DisplayName("Test findRatingSchemeItemsByIds(Set); given zero; when HashSet() add zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set RatingSchemeService.findRatingSchemeItemsByIds(Set)"})
  void testFindRatingSchemeItemsByIds_givenZero_whenHashSetAddZero() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    RatingSchemeService ratingSchemeService = new RatingSchemeService(ratingSchemeDAO);

    HashSet<Long> ids = new HashSet<>();
    ids.add(0L);
    ids.add(1L);

    // Act
    Set<RatingSchemeItem> actualFindRatingSchemeItemsByIdsResult =
        ratingSchemeService.findRatingSchemeItemsByIds(ids);

    // Assert
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualFindRatingSchemeItemsByIdsResult.isEmpty());
  }

  /**
   * Test {@link RatingSchemeService#findRatingSchemeItemsByIds(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeService#findRatingSchemeItemsByIds(Set)}
   */
  @Test
  @DisplayName("Test findRatingSchemeItemsByIds(Set); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set RatingSchemeService.findRatingSchemeItemsByIds(Set)"})
  void testFindRatingSchemeItemsByIds_whenHashSet() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    RatingSchemeService ratingSchemeService = new RatingSchemeService(ratingSchemeDAO);

    // Act
    Set<RatingSchemeItem> actualFindRatingSchemeItemsByIdsResult =
        ratingSchemeService.findRatingSchemeItemsByIds(new HashSet<>());

    // Assert
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualFindRatingSchemeItemsByIdsResult.isEmpty());
  }

  /**
   * Test {@link RatingSchemeService#save(RatingScheme)}.
   *
   * <ul>
   *   <li>Given {@link RatingSchemeDAO} {@link RatingSchemeDAO#save(RatingScheme)} return {@code
   *       false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeService#save(RatingScheme)}
   */
  @Test
  @DisplayName(
      "Test save(RatingScheme); given RatingSchemeDAO save(RatingScheme) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RatingSchemeService.save(RatingScheme)"})
  void testSave_givenRatingSchemeDAOSaveReturnFalse_thenReturnFalse() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.save(Mockito.<RatingScheme>any())).thenReturn(false);

    // Act
    Boolean actualSaveResult = new RatingSchemeService(ratingSchemeDAO).save(null);

    // Assert
    verify(ratingSchemeDAO).save(isNull());
    assertFalse(actualSaveResult);
  }

  /**
   * Test {@link RatingSchemeService#save(RatingScheme)}.
   *
   * <ul>
   *   <li>Given {@link RatingSchemeDAO} {@link RatingSchemeDAO#save(RatingScheme)} return {@code
   *       true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeService#save(RatingScheme)}
   */
  @Test
  @DisplayName(
      "Test save(RatingScheme); given RatingSchemeDAO save(RatingScheme) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RatingSchemeService.save(RatingScheme)"})
  void testSave_givenRatingSchemeDAOSaveReturnTrue_thenReturnTrue() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.save(Mockito.<RatingScheme>any())).thenReturn(true);

    // Act
    Boolean actualSaveResult = new RatingSchemeService(ratingSchemeDAO).save(null);

    // Assert
    verify(ratingSchemeDAO).save(isNull());
    assertTrue(actualSaveResult);
  }

  /**
   * Test {@link RatingSchemeService#saveRatingItem(long, RatingSchemeItem)}.
   *
   * <p>Method under test: {@link RatingSchemeService#saveRatingItem(long, RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test saveRatingItem(long, RatingSchemeItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long RatingSchemeService.saveRatingItem(long, RatingSchemeItem)"})
  void testSaveRatingItem() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.saveRatingItem(anyLong(), Mockito.<RatingSchemeItem>any())).thenReturn(1L);

    // Act
    Long actualSaveRatingItemResult =
        new RatingSchemeService(ratingSchemeDAO).saveRatingItem(1L, null);

    // Assert
    verify(ratingSchemeDAO).saveRatingItem(eq(1L), isNull());
    assertEquals(1L, actualSaveRatingItemResult.longValue());
  }

  /**
   * Test {@link RatingSchemeService#removeRatingItem(long)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeService#removeRatingItem(long)}
   */
  @Test
  @DisplayName("Test removeRatingItem(long); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RatingSchemeService.removeRatingItem(long)"})
  void testRemoveRatingItem_thenReturnFalse() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.removeRatingItem(anyLong())).thenReturn(false);

    // Act
    Boolean actualRemoveRatingItemResult =
        new RatingSchemeService(ratingSchemeDAO).removeRatingItem(1L);

    // Assert
    verify(ratingSchemeDAO).removeRatingItem(1L);
    assertFalse(actualRemoveRatingItemResult);
  }

  /**
   * Test {@link RatingSchemeService#removeRatingItem(long)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeService#removeRatingItem(long)}
   */
  @Test
  @DisplayName("Test removeRatingItem(long); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RatingSchemeService.removeRatingItem(long)"})
  void testRemoveRatingItem_thenReturnTrue() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.removeRatingItem(anyLong())).thenReturn(true);

    // Act
    Boolean actualRemoveRatingItemResult =
        new RatingSchemeService(ratingSchemeDAO).removeRatingItem(1L);

    // Assert
    verify(ratingSchemeDAO).removeRatingItem(1L);
    assertTrue(actualRemoveRatingItemResult);
  }

  /**
   * Test {@link RatingSchemeService#calcRatingUsageStats()}.
   *
   * <p>Method under test: {@link RatingSchemeService#calcRatingUsageStats()}
   */
  @Test
  @DisplayName("Test calcRatingUsageStats()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RatingSchemeService.calcRatingUsageStats()"})
  void testCalcRatingUsageStats() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.calcRatingUsageStats()).thenReturn(new ArrayList<>());

    // Act
    List<RatingSchemeItemUsageCount> actualCalcRatingUsageStatsResult =
        new RatingSchemeService(ratingSchemeDAO).calcRatingUsageStats();

    // Assert
    verify(ratingSchemeDAO).calcRatingUsageStats();
    assertTrue(actualCalcRatingUsageStatsResult.isEmpty());
  }

  /**
   * Test {@link RatingSchemeService#removeRatingScheme(long)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeService#removeRatingScheme(long)}
   */
  @Test
  @DisplayName("Test removeRatingScheme(long); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RatingSchemeService.removeRatingScheme(long)"})
  void testRemoveRatingScheme_thenReturnFalse() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.removeRatingScheme(anyLong())).thenReturn(false);

    // Act
    Boolean actualRemoveRatingSchemeResult =
        new RatingSchemeService(ratingSchemeDAO).removeRatingScheme(1L);

    // Assert
    verify(ratingSchemeDAO).removeRatingScheme(1L);
    assertFalse(actualRemoveRatingSchemeResult);
  }

  /**
   * Test {@link RatingSchemeService#removeRatingScheme(long)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeService#removeRatingScheme(long)}
   */
  @Test
  @DisplayName("Test removeRatingScheme(long); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RatingSchemeService.removeRatingScheme(long)"})
  void testRemoveRatingScheme_thenReturnTrue() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.removeRatingScheme(anyLong())).thenReturn(true);

    // Act
    Boolean actualRemoveRatingSchemeResult =
        new RatingSchemeService(ratingSchemeDAO).removeRatingScheme(1L);

    // Assert
    verify(ratingSchemeDAO).removeRatingScheme(1L);
    assertTrue(actualRemoveRatingSchemeResult);
  }

  /**
   * Test {@link RatingSchemeService#findRatingSchemeItemsBySchemeIds(Set)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link HashSet#HashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeService#findRatingSchemeItemsBySchemeIds(Set)}
   */
  @Test
  @DisplayName("Test findRatingSchemeItemsBySchemeIds(Set); given one; when HashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set RatingSchemeService.findRatingSchemeItemsBySchemeIds(Set)"})
  void testFindRatingSchemeItemsBySchemeIds_givenOne_whenHashSetAddOne() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    RatingSchemeService ratingSchemeService = new RatingSchemeService(ratingSchemeDAO);

    HashSet<Long> schemeIds = new HashSet<>();
    schemeIds.add(1L);

    // Act
    Set<RatingSchemeItem> actualFindRatingSchemeItemsBySchemeIdsResult =
        ratingSchemeService.findRatingSchemeItemsBySchemeIds(schemeIds);

    // Assert
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    assertTrue(actualFindRatingSchemeItemsBySchemeIdsResult.isEmpty());
  }

  /**
   * Test {@link RatingSchemeService#findRatingSchemeItemsBySchemeIds(Set)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link HashSet#HashSet()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeService#findRatingSchemeItemsBySchemeIds(Set)}
   */
  @Test
  @DisplayName("Test findRatingSchemeItemsBySchemeIds(Set); given zero; when HashSet() add zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set RatingSchemeService.findRatingSchemeItemsBySchemeIds(Set)"})
  void testFindRatingSchemeItemsBySchemeIds_givenZero_whenHashSetAddZero() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    RatingSchemeService ratingSchemeService = new RatingSchemeService(ratingSchemeDAO);

    HashSet<Long> schemeIds = new HashSet<>();
    schemeIds.add(0L);
    schemeIds.add(1L);

    // Act
    Set<RatingSchemeItem> actualFindRatingSchemeItemsBySchemeIdsResult =
        ratingSchemeService.findRatingSchemeItemsBySchemeIds(schemeIds);

    // Assert
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    assertTrue(actualFindRatingSchemeItemsBySchemeIdsResult.isEmpty());
  }

  /**
   * Test {@link RatingSchemeService#findRatingSchemeItemsBySchemeIds(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeService#findRatingSchemeItemsBySchemeIds(Set)}
   */
  @Test
  @DisplayName("Test findRatingSchemeItemsBySchemeIds(Set); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set RatingSchemeService.findRatingSchemeItemsBySchemeIds(Set)"})
  void testFindRatingSchemeItemsBySchemeIds_whenHashSet() {
    // Arrange
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    RatingSchemeService ratingSchemeService = new RatingSchemeService(ratingSchemeDAO);

    // Act
    Set<RatingSchemeItem> actualFindRatingSchemeItemsBySchemeIdsResult =
        ratingSchemeService.findRatingSchemeItemsBySchemeIds(new HashSet<>());

    // Assert
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    assertTrue(actualFindRatingSchemeItemsBySchemeIdsResult.isEmpty());
  }
}
