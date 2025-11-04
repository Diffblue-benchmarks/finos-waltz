package org.finos.waltz.service.static_panel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.static_panel.StaticPanelDao;
import org.finos.waltz.model.staticpanel.StaticPanel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StaticPanelServiceDiffblueTest {
  /**
   * Method under test: {@link StaticPanelService#findByGroups(String[])}
   */
  @Test
  void testFindByGroups() {
    // Arrange
    StaticPanelDao staticPanelDao = mock(StaticPanelDao.class);
    ArrayList<StaticPanel> staticPanelList = new ArrayList<>();
    when(staticPanelDao.findByGroups((String[]) any())).thenReturn(staticPanelList);

    // Act
    List<StaticPanel> actualFindByGroupsResult = (new StaticPanelService(staticPanelDao))
        .findByGroups(new String[]{"Groups"});

    // Assert
    verify(staticPanelDao).findByGroups((String[]) any());
    assertTrue(actualFindByGroupsResult.isEmpty());
    assertSame(staticPanelList, actualFindByGroupsResult);
  }

  /**
   * Method under test: {@link StaticPanelService#findByGroups(String[])}
   */
  @Test
  void testFindByGroups2() {
    // Arrange, Act and Assert
    assertTrue((new StaticPanelService(mock(StaticPanelDao.class))).findByGroups(new String[]{}).isEmpty());
  }

  /**
   * Method under test: {@link StaticPanelService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    StaticPanelDao staticPanelDao = mock(StaticPanelDao.class);
    ArrayList<StaticPanel> staticPanelList = new ArrayList<>();
    when(staticPanelDao.findAll()).thenReturn(staticPanelList);

    // Act
    List<StaticPanel> actualFindAllResult = (new StaticPanelService(staticPanelDao)).findAll();

    // Assert
    verify(staticPanelDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(staticPanelList, actualFindAllResult);
  }

  /**
   * Method under test: {@link StaticPanelService#save(StaticPanel)}
   */
  @Test
  void testSave() {
    // Arrange
    StaticPanelDao staticPanelDao = mock(StaticPanelDao.class);
    when(staticPanelDao.update(Mockito.<StaticPanel>any())).thenReturn(true);
    StaticPanelService staticPanelService = new StaticPanelService(staticPanelDao);
    StaticPanel panel = mock(StaticPanel.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(panel.id()).thenReturn(ofResult);

    // Act
    boolean actualSaveResult = staticPanelService.save(panel);

    // Assert
    verify(staticPanelDao).update(isA(StaticPanel.class));
    verify(panel).id();
    assertTrue(actualSaveResult);
  }

  /**
   * Method under test: {@link StaticPanelService#save(StaticPanel)}
   */
  @Test
  void testSave2() {
    // Arrange
    StaticPanelDao staticPanelDao = mock(StaticPanelDao.class);
    when(staticPanelDao.update(Mockito.<StaticPanel>any())).thenReturn(false);
    StaticPanelService staticPanelService = new StaticPanelService(staticPanelDao);
    StaticPanel panel = mock(StaticPanel.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(panel.id()).thenReturn(ofResult);

    // Act
    boolean actualSaveResult = staticPanelService.save(panel);

    // Assert
    verify(staticPanelDao).update(isA(StaticPanel.class));
    verify(panel).id();
    assertFalse(actualSaveResult);
  }

  /**
   * Method under test: {@link StaticPanelService#save(StaticPanel)}
   */
  @Test
  void testSave3() {
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
}
