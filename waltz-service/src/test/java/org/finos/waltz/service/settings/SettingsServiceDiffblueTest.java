package org.finos.waltz.service.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.model.settings.Setting;
import org.finos.waltz.model.settings.UpdateSettingsCommand;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SettingsServiceDiffblueTest {
  /**
   * Method under test: {@link SettingsService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.findAll()).thenReturn(new ArrayList<>());

    // Act
    Collection<Setting> actualFindAllResult = (new SettingsService(settingsDao, new ArrayList<>())).findAll();

    // Assert
    verify(settingsDao).findAll();
    assertTrue(actualFindAllResult instanceof List);
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Method under test: {@link SettingsService#findAll()}
   */
  @Test
  void testFindAll2() {
    // Arrange
    Setting setting = mock(Setting.class);
    when(setting.name()).thenReturn("Name");

    ArrayList<Setting> settingList = new ArrayList<>();
    settingList.add(setting);
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.findAll()).thenReturn(settingList);

    // Act
    Collection<Setting> actualFindAllResult = (new SettingsService(settingsDao, new ArrayList<>())).findAll();

    // Assert
    verify(settingsDao).findAll();
    verify(setting).name();
    assertTrue(actualFindAllResult instanceof List);
    assertEquals(1, actualFindAllResult.size());
  }

  /**
   * Method under test: {@link SettingsService#findAll()}
   */
  @Test
  void testFindAll3() {
    // Arrange
    Setting setting = mock(Setting.class);
    when(setting.name()).thenReturn("Name");
    Setting setting2 = mock(Setting.class);
    when(setting2.name()).thenReturn("Name");

    ArrayList<Setting> settingList = new ArrayList<>();
    settingList.add(setting2);
    settingList.add(setting);
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.findAll()).thenReturn(settingList);

    // Act
    Collection<Setting> actualFindAllResult = (new SettingsService(settingsDao, new ArrayList<>())).findAll();

    // Assert
    verify(settingsDao).findAll();
    verify(setting2).name();
    verify(setting).name();
    assertEquals(settingList, actualFindAllResult);
  }

  /**
   * Method under test: {@link SettingsService#getByName(String)}
   */
  @Test
  void testGetByName() {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any())).thenReturn(null);

    // Act
    Setting actualByName = (new SettingsService(settingsDao, new ArrayList<>())).getByName("Name");

    // Assert
    verify(settingsDao).getByName(eq("Name"));
    assertNull(actualByName);
  }

  /**
   * Method under test: {@link SettingsService#getValue(String)}
   */
  @Test
  void testGetValue() {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any())).thenReturn(null);

    // Act
    Optional<String> actualValue = (new SettingsService(settingsDao, new ArrayList<>())).getValue("Name");

    // Assert
    verify(settingsDao).getByName(eq("Name"));
    assertFalse(actualValue.isPresent());
  }

  /**
   * Method under test: {@link SettingsService#getValue(String)}
   */
  @Test
  void testGetValue2() {
    // Arrange
    Setting setting = mock(Setting.class);
    Optional<String> ofResult = Optional.of("foo");
    when(setting.value()).thenReturn(ofResult);
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any())).thenReturn(setting);

    // Act
    Optional<String> actualValue = (new SettingsService(settingsDao, new ArrayList<>())).getValue("Name");

    // Assert
    verify(settingsDao).getByName(eq("Name"));
    verify(setting).value();
    assertSame(ofResult, actualValue);
  }

  /**
   * Method under test: {@link SettingsService#indexByPrefix(String)}
   */
  @Test
  void testIndexByPrefix() {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);
    HashMap<String, String> stringStringMap = new HashMap<>();
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);

    // Act
    Map<String, String> actualIndexByPrefixResult = (new SettingsService(settingsDao, new ArrayList<>()))
        .indexByPrefix("Prefix");

    // Assert
    verify(settingsDao).indexByPrefix(eq("Prefix"));
    assertTrue(actualIndexByPrefixResult.isEmpty());
    assertSame(stringStringMap, actualIndexByPrefixResult);
  }

  /**
   * Method under test: {@link SettingsService#update(UpdateSettingsCommand)}
   */
  @Test
  void testUpdate() {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.update(Mockito.<UpdateSettingsCommand>any())).thenReturn(1);

    // Act
    int actualUpdateResult = (new SettingsService(settingsDao, new ArrayList<>())).update(null);

    // Assert
    verify(settingsDao).update(isNull());
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Method under test: {@link SettingsService#create(Setting)}
   */
  @Test
  void testCreate() {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.create(Mockito.<Setting>any())).thenReturn(1);

    // Act
    Integer actualCreateResult = (new SettingsService(settingsDao, new ArrayList<>())).create(null);

    // Assert
    verify(settingsDao).create(isNull());
    assertEquals(1, actualCreateResult.intValue());
  }
}
