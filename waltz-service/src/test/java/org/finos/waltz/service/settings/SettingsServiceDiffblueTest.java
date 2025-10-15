package org.finos.waltz.service.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.model.settings.ImmutableSetting;
import org.finos.waltz.model.settings.Setting;
import org.finos.waltz.model.settings.UpdateSettingsCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SettingsServiceDiffblueTest {
  /**
   * Test {@link SettingsService#findAll()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SettingsService#findAll()}
   */
  @Test
  @DisplayName("Test findAll(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection SettingsService.findAll()"})
  void testFindAll_thenReturnEmpty() {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.findAll()).thenReturn(new ArrayList<>());
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    // Act
    Collection<Setting> actualFindAllResult = settingsService.findAll();

    // Assert
    verify(settingsDao).findAll();
    assertTrue(actualFindAllResult instanceof List);
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link SettingsService#findAll()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link SettingsService#findAll()}
   */
  @Test
  @DisplayName("Test findAll(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection SettingsService.findAll()"})
  void testFindAll_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Setting> settingList = new ArrayList<>();
    settingList.add(
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build());

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.findAll()).thenReturn(settingList);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    // Act
    Collection<Setting> actualFindAllResult = settingsService.findAll();

    // Assert
    verify(settingsDao).findAll();
    assertTrue(actualFindAllResult instanceof List);
    assertEquals(1, actualFindAllResult.size());
    Setting getResult = ((List<Setting>) actualFindAllResult).get(0);
    assertTrue(getResult instanceof ImmutableSetting);
    assertEquals("Name", getResult.name());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertFalse(getResult.restricted());
  }

  /**
   * Test {@link SettingsService#findAll()}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link SettingsService#findAll()}
   */
  @Test
  @DisplayName("Test findAll(); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection SettingsService.findAll()"})
  void testFindAll_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Setting> settingList = new ArrayList<>();
    settingList.add(
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build());
    settingList.add(
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build());

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.findAll()).thenReturn(settingList);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    // Act
    Collection<Setting> actualFindAllResult = settingsService.findAll();

    // Assert
    verify(settingsDao).findAll();
    assertTrue(actualFindAllResult instanceof List);
    assertEquals(2, actualFindAllResult.size());
    Setting getResult = ((List<Setting>) actualFindAllResult).get(0);
    assertTrue(getResult instanceof ImmutableSetting);
    Setting getResult2 = ((List<Setting>) actualFindAllResult).get(1);
    assertTrue(getResult2 instanceof ImmutableSetting);
    assertEquals("Name", getResult.name());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertFalse(getResult.restricted());
    assertEquals(getResult, getResult2);
  }

  /**
   * Test {@link SettingsService#getByName(String)}.
   *
   * <p>Method under test: {@link SettingsService#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Setting SettingsService.getByName(String)"})
  void testGetByName() {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("42")
                .build());
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    // Act
    Setting actualByName = settingsService.getByName("Name");

    // Assert
    verify(settingsDao).getByName("Name");
    assertTrue(actualByName instanceof ImmutableSetting);
    assertEquals("Name", actualByName.name());
    assertEquals("The characteristics of someone or something", actualByName.description());
    assertFalse(actualByName.restricted());
  }

  /**
   * Test {@link SettingsService#getValue(String)}.
   *
   * <p>Method under test: {@link SettingsService#getValue(String)}
   */
  @Test
  @DisplayName("Test getValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional SettingsService.getValue(String)"})
  void testGetValue() {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("42")
                .build());
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    // Act
    Optional<String> actualValue = settingsService.getValue("Name");

    // Assert
    verify(settingsDao).getByName("Name");
    assertEquals("42", actualValue.get());
    assertTrue(actualValue.isPresent());
  }

  /**
   * Test {@link SettingsService#indexByPrefix(String)}.
   *
   * <p>Method under test: {@link SettingsService#indexByPrefix(String)}
   */
  @Test
  @DisplayName("Test indexByPrefix(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SettingsService.indexByPrefix(String)"})
  void testIndexByPrefix() {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    // Act
    Map<String, String> actualIndexByPrefixResult = settingsService.indexByPrefix("Prefix");

    // Assert
    verify(settingsDao).indexByPrefix("Prefix");
    assertTrue(actualIndexByPrefixResult.isEmpty());
  }

  /**
   * Test {@link SettingsService#update(UpdateSettingsCommand)}.
   *
   * <p>Method under test: {@link SettingsService#update(UpdateSettingsCommand)}
   */
  @Test
  @DisplayName("Test update(UpdateSettingsCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SettingsService.update(UpdateSettingsCommand)"})
  void testUpdate() {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.update(Mockito.<UpdateSettingsCommand>any())).thenReturn(1);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    // Act
    int actualUpdateResult = settingsService.update(null);

    // Assert
    verify(settingsDao).update(isNull());
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Test {@link SettingsService#create(Setting)}.
   *
   * <p>Method under test: {@link SettingsService#create(Setting)}
   */
  @Test
  @DisplayName("Test create(Setting)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SettingsService.create(Setting)"})
  void testCreate() {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.create(Mockito.<Setting>any())).thenReturn(1);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    // Act
    Integer actualCreateResult = settingsService.create(null);

    // Assert
    verify(settingsDao).create(isNull());
    assertEquals(1, actualCreateResult.intValue());
  }
}
