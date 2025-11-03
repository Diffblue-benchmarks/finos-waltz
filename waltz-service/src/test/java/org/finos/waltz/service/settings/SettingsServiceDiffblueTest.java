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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.settings.Setting;
import org.finos.waltz.model.settings.UpdateSettingsCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SettingsServiceDiffblueTest {
  /**
   * Test {@link SettingsService#findAll()}.
   * <ul>
   *   <li>Given {@link Setting} {@link NameProvider#name()} return {@code Name}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SettingsService#findAll()}
   */
  @Test
  @DisplayName("Test findAll(); given Setting name() return 'Name'; then return ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection SettingsService.findAll()"})
  void testFindAll_givenSettingNameReturnName_thenReturnArrayList() {
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
   * Test {@link SettingsService#findAll()}.
   * <ul>
   *   <li>Given {@link Setting} {@link NameProvider#name()} return {@code Name}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SettingsService#findAll()}
   */
  @Test
  @DisplayName("Test findAll(); given Setting name() return 'Name'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection SettingsService.findAll()"})
  void testFindAll_givenSettingNameReturnName_thenReturnSizeIsOne() {
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
   * Test {@link SettingsService#findAll()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SettingsService#findAll()}
   */
  @Test
  @DisplayName("Test findAll(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection SettingsService.findAll()"})
  void testFindAll_thenReturnEmpty() {
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
   * Test {@link SettingsService#getByName(String)}.
   * <p>
   * Method under test: {@link SettingsService#getByName(String)}
   */
  @Test
  @DisplayName("Test getByName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Setting SettingsService.getByName(String)"})
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
   * Test {@link SettingsService#getValue(String)}.
   * <ul>
   *   <li>Given {@link Setting} {@link Setting#value()} return {@link Optional} with {@code foo}.</li>
   *   <li>Then return {@link Optional} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SettingsService#getValue(String)}
   */
  @Test
  @DisplayName("Test getValue(String); given Setting value() return Optional with 'foo'; then return Optional with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SettingsService.getValue(String)"})
  void testGetValue_givenSettingValueReturnOptionalWithFoo_thenReturnOptionalWithFoo() {
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
   * Test {@link SettingsService#getValue(String)}.
   * <ul>
   *   <li>Given {@link SettingsDao} {@link SettingsDao#getByName(String)} return {@code null}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link SettingsService#getValue(String)}
   */
  @Test
  @DisplayName("Test getValue(String); given SettingsDao getByName(String) return 'null'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SettingsService.getValue(String)"})
  void testGetValue_givenSettingsDaoGetByNameReturnNull_thenReturnNotPresent() {
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
   * Test {@link SettingsService#indexByPrefix(String)}.
   * <p>
   * Method under test: {@link SettingsService#indexByPrefix(String)}
   */
  @Test
  @DisplayName("Test indexByPrefix(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map SettingsService.indexByPrefix(String)"})
  void testIndexByPrefix() {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());

    // Act
    Map<String, String> actualIndexByPrefixResult = (new SettingsService(settingsDao, new ArrayList<>()))
        .indexByPrefix("Prefix");

    // Assert
    verify(settingsDao).indexByPrefix(eq("Prefix"));
    assertTrue(actualIndexByPrefixResult.isEmpty());
  }

  /**
   * Test {@link SettingsService#update(UpdateSettingsCommand)}.
   * <p>
   * Method under test: {@link SettingsService#update(UpdateSettingsCommand)}
   */
  @Test
  @DisplayName("Test update(UpdateSettingsCommand)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int SettingsService.update(UpdateSettingsCommand)"})
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
   * Test {@link SettingsService#create(Setting)}.
   * <p>
   * Method under test: {@link SettingsService#create(Setting)}
   */
  @Test
  @DisplayName("Test create(Setting)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer SettingsService.create(Setting)"})
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
