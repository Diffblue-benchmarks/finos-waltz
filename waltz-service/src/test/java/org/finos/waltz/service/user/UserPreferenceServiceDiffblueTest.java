package org.finos.waltz.service.user;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.user.UserPreferenceDao;
import org.finos.waltz.model.user.UserPreference;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UserPreferenceServiceDiffblueTest {
  /**
   * Method under test: {@link UserPreferenceService#getPreferences(String)}
   */
  @Test
  void testGetPreferences() {
    // Arrange
    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any())).thenReturn(userPreferenceList);

    // Act
    List<UserPreference> actualPreferences = (new UserPreferenceService(userPreferenceDao)).getPreferences("janedoe");

    // Assert
    verify(userPreferenceDao).getPreferencesForUser(eq("janedoe"));
    assertTrue(actualPreferences.isEmpty());
    assertSame(userPreferenceList, actualPreferences);
  }

  /**
   * Method under test:
   * {@link UserPreferenceService#savePreferences(String, List)}
   */
  @Test
  void testSavePreferences() {
    // Arrange
    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any())).thenReturn(userPreferenceList);
    UserPreferenceService userPreferenceService = new UserPreferenceService(userPreferenceDao);

    // Act
    List<UserPreference> actualSavePreferencesResult = userPreferenceService.savePreferences("janedoe",
        new ArrayList<>());

    // Assert
    verify(userPreferenceDao).getPreferencesForUser(eq("janedoe"));
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    assertTrue(actualSavePreferencesResult.isEmpty());
    assertSame(userPreferenceList, actualSavePreferencesResult);
  }

  /**
   * Method under test:
   * {@link UserPreferenceService#savePreferences(String, List)}
   */
  @Test
  void testSavePreferences2() {
    // Arrange
    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any())).thenReturn(userPreferenceList);
    UserPreferenceService userPreferenceService = new UserPreferenceService(userPreferenceDao);

    ArrayList<UserPreference> preferences = new ArrayList<>();
    preferences.add(mock(UserPreference.class));

    // Act
    List<UserPreference> actualSavePreferencesResult = userPreferenceService.savePreferences("janedoe", preferences);

    // Assert
    verify(userPreferenceDao).getPreferencesForUser(eq("janedoe"));
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    assertTrue(actualSavePreferencesResult.isEmpty());
    assertSame(userPreferenceList, actualSavePreferencesResult);
  }

  /**
   * Method under test:
   * {@link UserPreferenceService#savePreferences(String, List)}
   */
  @Test
  void testSavePreferences3() {
    // Arrange
    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any())).thenReturn(userPreferenceList);
    UserPreferenceService userPreferenceService = new UserPreferenceService(userPreferenceDao);

    ArrayList<UserPreference> preferences = new ArrayList<>();
    preferences.add(mock(UserPreference.class));
    preferences.add(mock(UserPreference.class));

    // Act
    List<UserPreference> actualSavePreferencesResult = userPreferenceService.savePreferences("janedoe", preferences);

    // Assert
    verify(userPreferenceDao).getPreferencesForUser(eq("janedoe"));
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    assertTrue(actualSavePreferencesResult.isEmpty());
    assertSame(userPreferenceList, actualSavePreferencesResult);
  }

  /**
   * Method under test:
   * {@link UserPreferenceService#savePreference(String, UserPreference)}
   */
  @Test
  void testSavePreference() {
    // Arrange
    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreference(Mockito.<String>any(), Mockito.<UserPreference>any())).thenReturn(1);
    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any())).thenReturn(userPreferenceList);

    // Act
    List<UserPreference> actualSavePreferenceResult = (new UserPreferenceService(userPreferenceDao))
        .savePreference("janedoe", mock(UserPreference.class));

    // Assert
    verify(userPreferenceDao).getPreferencesForUser(eq("janedoe"));
    verify(userPreferenceDao).savePreference(eq("janedoe"), isA(UserPreference.class));
    assertTrue(actualSavePreferenceResult.isEmpty());
    assertSame(userPreferenceList, actualSavePreferenceResult);
  }

  /**
   * Method under test: {@link UserPreferenceService#clearPreferences(String)}
   */
  @Test
  void testClearPreferences() {
    // Arrange
    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    doNothing().when(userPreferenceDao).clearPreferencesForUser(Mockito.<String>any());

    // Act
    boolean actualClearPreferencesResult = (new UserPreferenceService(userPreferenceDao)).clearPreferences("janedoe");

    // Assert
    verify(userPreferenceDao).clearPreferencesForUser(eq("janedoe"));
    assertTrue(actualClearPreferencesResult);
  }
}
