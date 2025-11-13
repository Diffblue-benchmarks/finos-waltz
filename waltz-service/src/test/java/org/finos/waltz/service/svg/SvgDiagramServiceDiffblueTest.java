package org.finos.waltz.service.svg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.finos.waltz.data.svg.SvgDiagramDao;
import org.finos.waltz.model.svg.ImmutableSvgDiagram;
import org.finos.waltz.model.svg.SvgDiagram;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SvgDiagramServiceDiffblueTest {
  /**
   * Test {@link SvgDiagramService#getById(long)}.
   *
   * <p>Method under test: {@link SvgDiagramService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SvgDiagram SvgDiagramService.getById(long)"})
  void testGetById() {
    // Arrange
    SvgDiagramDao svgDiagramDao = mock(SvgDiagramDao.class);
    when(svgDiagramDao.getById(anyLong()))
        .thenReturn(
            ImmutableSvgDiagram.builder()
                .description("The characteristics of someone or something")
                .displayHeightPercent(1)
                .displayWidthPercent(1)
                .group("Group")
                .id(1L)
                .keyProperty("Key Property")
                .name("Name")
                .priority(1)
                .product("Product")
                .svg("Svg")
                .build());

    // Act
    SvgDiagram actualById = new SvgDiagramService(svgDiagramDao).getById(1L);

    // Assert
    verify(svgDiagramDao).getById(1L);
    assertTrue(actualById instanceof ImmutableSvgDiagram);
    assertEquals("Group", actualById.group());
    assertEquals("Key Property", actualById.keyProperty());
    assertEquals("Name", actualById.name());
    assertEquals("Product", actualById.product());
    assertEquals("Svg", actualById.svg());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(1, actualById.displayHeightPercent().intValue());
    assertEquals(1, actualById.displayWidthPercent().intValue());
    assertEquals(1, actualById.priority());
  }

  /**
   * Test {@link SvgDiagramService#findByGroups(String[])}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SvgDiagramService#findByGroups(String[])}
   */
  @Test
  @DisplayName("Test findByGroups(String[]); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection SvgDiagramService.findByGroups(String[])"})
  void testFindByGroups_thenReturnEmpty() {
    // Arrange
    SvgDiagramDao svgDiagramDao = mock(SvgDiagramDao.class);
    when(svgDiagramDao.findByGroups(Mockito.<String[]>any())).thenReturn(new ArrayList<>());

    // Act
    Collection<SvgDiagram> actualFindByGroupsResult =
        new SvgDiagramService(svgDiagramDao).findByGroups("Groups");

    // Assert
    verify(svgDiagramDao).findByGroups(isA(String[].class));
    assertTrue(actualFindByGroupsResult instanceof List);
    assertTrue(actualFindByGroupsResult.isEmpty());
  }

  /**
   * Test {@link SvgDiagramService#findByGroups(String[])}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link SvgDiagramService#findByGroups(String[])}
   */
  @Test
  @DisplayName("Test findByGroups(String[]); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection SvgDiagramService.findByGroups(String[])"})
  void testFindByGroups_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<SvgDiagram> svgDiagramList = new ArrayList<>();
    svgDiagramList.add(
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build());

    SvgDiagramDao svgDiagramDao = mock(SvgDiagramDao.class);
    when(svgDiagramDao.findByGroups(Mockito.<String[]>any())).thenReturn(svgDiagramList);

    // Act
    Collection<SvgDiagram> actualFindByGroupsResult =
        new SvgDiagramService(svgDiagramDao).findByGroups("Groups");

    // Assert
    verify(svgDiagramDao).findByGroups(isA(String[].class));
    assertTrue(actualFindByGroupsResult instanceof List);
    assertEquals(1, actualFindByGroupsResult.size());
    SvgDiagram getResult = ((List<SvgDiagram>) actualFindByGroupsResult).get(0);
    assertTrue(getResult instanceof ImmutableSvgDiagram);
    assertEquals("Group", getResult.group());
    assertEquals("Key Property", getResult.keyProperty());
    assertEquals("Name", getResult.name());
    assertEquals("Product", getResult.product());
    assertEquals("Svg", getResult.svg());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(1, getResult.displayHeightPercent().intValue());
    assertEquals(1, getResult.displayWidthPercent().intValue());
    assertEquals(1, getResult.priority());
  }

  /**
   * Test {@link SvgDiagramService#findByGroups(String[])}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link SvgDiagramService#findByGroups(String[])}
   */
  @Test
  @DisplayName("Test findByGroups(String[]); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection SvgDiagramService.findByGroups(String[])"})
  void testFindByGroups_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<SvgDiagram> svgDiagramList = new ArrayList<>();
    svgDiagramList.add(
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build());
    svgDiagramList.add(
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build());

    SvgDiagramDao svgDiagramDao = mock(SvgDiagramDao.class);
    when(svgDiagramDao.findByGroups(Mockito.<String[]>any())).thenReturn(svgDiagramList);

    // Act
    Collection<SvgDiagram> actualFindByGroupsResult =
        new SvgDiagramService(svgDiagramDao).findByGroups("Groups");

    // Assert
    verify(svgDiagramDao).findByGroups(isA(String[].class));
    assertTrue(actualFindByGroupsResult instanceof List);
    assertEquals(2, actualFindByGroupsResult.size());
    SvgDiagram getResult = ((List<SvgDiagram>) actualFindByGroupsResult).get(0);
    assertTrue(getResult instanceof ImmutableSvgDiagram);
    SvgDiagram getResult2 = ((List<SvgDiagram>) actualFindByGroupsResult).get(1);
    assertTrue(getResult2 instanceof ImmutableSvgDiagram);
    assertEquals("Group", getResult.group());
    assertEquals("Key Property", getResult.keyProperty());
    assertEquals("Name", getResult.name());
    assertEquals("Product", getResult.product());
    assertEquals("Svg", getResult.svg());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(1, getResult.displayHeightPercent().intValue());
    assertEquals(1, getResult.displayWidthPercent().intValue());
    assertEquals(1, getResult.priority());
    assertEquals(getResult, getResult2);
  }

  /**
   * Test {@link SvgDiagramService#findAll()}.
   *
   * <p>Method under test: {@link SvgDiagramService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SvgDiagramService.findAll()"})
  void testFindAll() {
    // Arrange
    SvgDiagramDao svgDiagramDao = mock(SvgDiagramDao.class);
    when(svgDiagramDao.findAll()).thenReturn(new HashSet<>());

    // Act
    Set<SvgDiagram> actualFindAllResult = new SvgDiagramService(svgDiagramDao).findAll();

    // Assert
    verify(svgDiagramDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link SvgDiagramService#remove(long)}.
   *
   * <ul>
   *   <li>Given {@link SvgDiagramDao} {@link SvgDiagramDao#remove(long)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SvgDiagramService#remove(long)}
   */
  @Test
  @DisplayName(
      "Test remove(long); given SvgDiagramDao remove(long) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean SvgDiagramService.remove(long)"})
  void testRemove_givenSvgDiagramDaoRemoveReturnFalse_thenReturnFalse() {
    // Arrange
    SvgDiagramDao svgDiagramDao = mock(SvgDiagramDao.class);
    when(svgDiagramDao.remove(anyLong())).thenReturn(false);

    // Act
    Boolean actualRemoveResult = new SvgDiagramService(svgDiagramDao).remove(1L);

    // Assert
    verify(svgDiagramDao).remove(1L);
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link SvgDiagramService#remove(long)}.
   *
   * <ul>
   *   <li>Given {@link SvgDiagramDao} {@link SvgDiagramDao#remove(long)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SvgDiagramService#remove(long)}
   */
  @Test
  @DisplayName(
      "Test remove(long); given SvgDiagramDao remove(long) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean SvgDiagramService.remove(long)"})
  void testRemove_givenSvgDiagramDaoRemoveReturnTrue_thenReturnTrue() {
    // Arrange
    SvgDiagramDao svgDiagramDao = mock(SvgDiagramDao.class);
    when(svgDiagramDao.remove(anyLong())).thenReturn(true);

    // Act
    Boolean actualRemoveResult = new SvgDiagramService(svgDiagramDao).remove(1L);

    // Assert
    verify(svgDiagramDao).remove(1L);
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link SvgDiagramService#save(SvgDiagram)}.
   *
   * <ul>
   *   <li>Given {@link SvgDiagramDao} {@link SvgDiagramDao#save(SvgDiagram)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SvgDiagramService#save(SvgDiagram)}
   */
  @Test
  @DisplayName(
      "Test save(SvgDiagram); given SvgDiagramDao save(SvgDiagram) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean SvgDiagramService.save(SvgDiagram)"})
  void testSave_givenSvgDiagramDaoSaveReturnFalse_thenReturnFalse() {
    // Arrange
    SvgDiagramDao svgDiagramDao = mock(SvgDiagramDao.class);
    when(svgDiagramDao.save(Mockito.<SvgDiagram>any())).thenReturn(false);

    // Act
    Boolean actualSaveResult = new SvgDiagramService(svgDiagramDao).save(null);

    // Assert
    verify(svgDiagramDao).save(isNull());
    assertFalse(actualSaveResult);
  }

  /**
   * Test {@link SvgDiagramService#save(SvgDiagram)}.
   *
   * <ul>
   *   <li>Given {@link SvgDiagramDao} {@link SvgDiagramDao#save(SvgDiagram)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SvgDiagramService#save(SvgDiagram)}
   */
  @Test
  @DisplayName(
      "Test save(SvgDiagram); given SvgDiagramDao save(SvgDiagram) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean SvgDiagramService.save(SvgDiagram)"})
  void testSave_givenSvgDiagramDaoSaveReturnTrue_thenReturnTrue() {
    // Arrange
    SvgDiagramDao svgDiagramDao = mock(SvgDiagramDao.class);
    when(svgDiagramDao.save(Mockito.<SvgDiagram>any())).thenReturn(true);

    // Act
    Boolean actualSaveResult = new SvgDiagramService(svgDiagramDao).save(null);

    // Assert
    verify(svgDiagramDao).save(isNull());
    assertTrue(actualSaveResult);
  }
}
