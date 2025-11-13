package org.finos.waltz.service.static_panel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.static_panel.StaticPanelDao;
import org.finos.waltz.model.staticpanel.ContentKind;
import org.finos.waltz.model.staticpanel.ImmutableStaticPanel;
import org.finos.waltz.model.staticpanel.StaticPanel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StaticPanelServiceDiffblueTest {
  /**
   * Test {@link StaticPanelService#findByGroups(String[])}.
   *
   * <ul>
   *   <li>Then calls {@link StaticPanelDao#findByGroups(String[])}.
   * </ul>
   *
   * <p>Method under test: {@link StaticPanelService#findByGroups(String[])}
   */
  @Test
  @DisplayName("Test findByGroups(String[]); then calls findByGroups(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List StaticPanelService.findByGroups(String[])"})
  void testFindByGroups_thenCallsFindByGroups() {
    // Arrange
    StaticPanelDao staticPanelDao = mock(StaticPanelDao.class);
    when(staticPanelDao.findByGroups((String[]) Mockito.any())).thenReturn(new ArrayList<>());

    // Act
    List<StaticPanel> actualFindByGroupsResult =
        new StaticPanelService(staticPanelDao).findByGroups(new String[] {"Groups"});

    // Assert
    verify(staticPanelDao).findByGroups((String[]) Mockito.any());
    assertTrue(actualFindByGroupsResult.isEmpty());
  }

  /**
   * Test {@link StaticPanelService#findByGroups(String[])}.
   *
   * <ul>
   *   <li>When empty array of {@link String}.
   * </ul>
   *
   * <p>Method under test: {@link StaticPanelService#findByGroups(String[])}
   */
  @Test
  @DisplayName("Test findByGroups(String[]); when empty array of String")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List StaticPanelService.findByGroups(String[])"})
  void testFindByGroups_whenEmptyArrayOfString() {
    // Arrange, Act and Assert
    assertTrue(
        new StaticPanelService(mock(StaticPanelDao.class)).findByGroups(new String[] {}).isEmpty());
  }

  /**
   * Test {@link StaticPanelService#findByGroups(String[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StaticPanelService#findByGroups(String[])}
   */
  @Test
  @DisplayName("Test findByGroups(String[]); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List StaticPanelService.findByGroups(String[])"})
  void testFindByGroups_whenNull() {
    // Arrange, Act and Assert
    assertTrue(new StaticPanelService(mock(StaticPanelDao.class)).findByGroups(null).isEmpty());
  }

  /**
   * Test {@link StaticPanelService#findAll()}.
   *
   * <p>Method under test: {@link StaticPanelService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List StaticPanelService.findAll()"})
  void testFindAll() {
    // Arrange
    StaticPanelDao staticPanelDao = mock(StaticPanelDao.class);
    when(staticPanelDao.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<StaticPanel> actualFindAllResult = new StaticPanelService(staticPanelDao).findAll();

    // Assert
    verify(staticPanelDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link StaticPanelService#save(StaticPanel)}.
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>When {@link StaticPanel} {@link StaticPanel#id()} return of forty-two.
   *   <li>Then calls {@link StaticPanel#id()}.
   * </ul>
   *
   * <p>Method under test: {@link StaticPanelService#save(StaticPanel)}
   */
  @Test
  @DisplayName(
      "Test save(StaticPanel); given of forty-two; when StaticPanel id() return of forty-two; then calls id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StaticPanelService.save(StaticPanel)"})
  void testSave_givenOfFortyTwo_whenStaticPanelIdReturnOfFortyTwo_thenCallsId() {
    // Arrange
    StaticPanelDao staticPanelDao = mock(StaticPanelDao.class);
    when(staticPanelDao.update(Mockito.<StaticPanel>any())).thenReturn(true);
    StaticPanelService staticPanelService = new StaticPanelService(staticPanelDao);

    StaticPanel panel = mock(StaticPanel.class);
    Optional<Long> ofResult = Optional.of(42L);
    when(panel.id()).thenReturn(ofResult);

    // Act
    boolean actualSaveResult = staticPanelService.save(panel);

    // Assert
    verify(staticPanelDao).update(isA(StaticPanel.class));
    verify(panel).id();
    assertTrue(actualSaveResult);
  }

  /**
   * Test {@link StaticPanelService#save(StaticPanel)}.
   *
   * <ul>
   *   <li>Given {@link StaticPanelDao} {@link StaticPanelDao#create(StaticPanel)} return {@code
   *       true}.
   *   <li>Then calls {@link StaticPanelDao#create(StaticPanel)}.
   * </ul>
   *
   * <p>Method under test: {@link StaticPanelService#save(StaticPanel)}
   */
  @Test
  @DisplayName(
      "Test save(StaticPanel); given StaticPanelDao create(StaticPanel) return 'true'; then calls create(StaticPanel)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StaticPanelService.save(StaticPanel)"})
  void testSave_givenStaticPanelDaoCreateReturnTrue_thenCallsCreate() {
    // Arrange
    StaticPanelDao staticPanelDao = mock(StaticPanelDao.class);
    when(staticPanelDao.create(Mockito.<StaticPanel>any())).thenReturn(true);
    StaticPanelService staticPanelService = new StaticPanelService(staticPanelDao);

    StaticPanel panel = mock(StaticPanel.class);
    Optional<Long> emptyResult = Optional.empty();
    when(panel.id()).thenReturn(emptyResult);

    // Act
    boolean actualSaveResult = staticPanelService.save(panel);

    // Assert
    verify(staticPanelDao).create(isA(StaticPanel.class));
    verify(panel).id();
    assertTrue(actualSaveResult);
  }

  /**
   * Test {@link StaticPanelService#save(StaticPanel)}.
   *
   * <ul>
   *   <li>Given {@link StaticPanelDao} {@link StaticPanelDao#update(StaticPanel)} return {@code
   *       false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StaticPanelService#save(StaticPanel)}
   */
  @Test
  @DisplayName(
      "Test save(StaticPanel); given StaticPanelDao update(StaticPanel) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StaticPanelService.save(StaticPanel)"})
  void testSave_givenStaticPanelDaoUpdateReturnFalse_thenReturnFalse() {
    // Arrange
    StaticPanelDao staticPanelDao = mock(StaticPanelDao.class);
    when(staticPanelDao.update(Mockito.<StaticPanel>any())).thenReturn(false);
    StaticPanelService staticPanelService = new StaticPanelService(staticPanelDao);

    // Act
    boolean actualSaveResult =
        staticPanelService.save(
            ImmutableStaticPanel.builder()
                .content("Not all who wander are lost")
                .encoding(ContentKind.HTML)
                .group("Group")
                .icon("Icon")
                .id(1L)
                .priority(1)
                .title("Dr")
                .build());

    // Assert
    verify(staticPanelDao).update(isA(StaticPanel.class));
    assertFalse(actualSaveResult);
  }

  /**
   * Test {@link StaticPanelService#save(StaticPanel)}.
   *
   * <ul>
   *   <li>Given {@link StaticPanelDao} {@link StaticPanelDao#update(StaticPanel)} return {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link StaticPanelService#save(StaticPanel)}
   */
  @Test
  @DisplayName("Test save(StaticPanel); given StaticPanelDao update(StaticPanel) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StaticPanelService.save(StaticPanel)"})
  void testSave_givenStaticPanelDaoUpdateReturnTrue() {
    // Arrange
    StaticPanelDao staticPanelDao = mock(StaticPanelDao.class);
    when(staticPanelDao.update(Mockito.<StaticPanel>any())).thenReturn(true);
    StaticPanelService staticPanelService = new StaticPanelService(staticPanelDao);

    // Act
    boolean actualSaveResult =
        staticPanelService.save(
            ImmutableStaticPanel.builder()
                .content("Not all who wander are lost")
                .encoding(ContentKind.HTML)
                .group("Group")
                .icon("Icon")
                .id(1L)
                .priority(1)
                .title("Dr")
                .build());

    // Assert
    verify(staticPanelDao).update(isA(StaticPanel.class));
    assertTrue(actualSaveResult);
  }
}
