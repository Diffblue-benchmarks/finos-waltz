package org.finos.waltz.service.shared_preference;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.shared_preference.SharedPreferenceDao;
import org.finos.waltz.model.shared_preference.SharedPreference;
import org.finos.waltz.model.shared_preference.SharedPreferenceSaveCommand;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SharedPreferenceServiceDiffblueTest {
  /**
   * Method under test:
   * {@link SharedPreferenceService#getPreference(String, String)}
   */
  @Test
  void testGetPreference() {
    // Arrange
    SharedPreferenceDao sharedPreferenceDao = mock(SharedPreferenceDao.class);
    when(sharedPreferenceDao.getPreference(Mockito.<String>any(), Mockito.<String>any())).thenReturn(null);

    // Act
    SharedPreference actualPreference = (new SharedPreferenceService(sharedPreferenceDao)).getPreference("Key",
        "Category");

    // Assert
    verify(sharedPreferenceDao).getPreference(eq("Key"), eq("Category"));
    assertNull(actualPreference);
  }

  /**
   * Method under test:
   * {@link SharedPreferenceService#findPreferencesByCategory(String)}
   */
  @Test
  void testFindPreferencesByCategory() {
    // Arrange
    SharedPreferenceDao sharedPreferenceDao = mock(SharedPreferenceDao.class);
    ArrayList<SharedPreference> sharedPreferenceList = new ArrayList<>();
    when(sharedPreferenceDao.findPreferencesByCategory(Mockito.<String>any())).thenReturn(sharedPreferenceList);

    // Act
    List<SharedPreference> actualFindPreferencesByCategoryResult = (new SharedPreferenceService(sharedPreferenceDao))
        .findPreferencesByCategory("Category");

    // Assert
    verify(sharedPreferenceDao).findPreferencesByCategory(eq("Category"));
    assertTrue(actualFindPreferencesByCategoryResult.isEmpty());
    assertSame(sharedPreferenceList, actualFindPreferencesByCategoryResult);
  }

  /**
   * Method under test:
   * {@link SharedPreferenceService#savePreference(String, SharedPreferenceSaveCommand)}
   */
  @Test
  void testSavePreference() {
    // Arrange
    SharedPreferenceDao sharedPreferenceDao = mock(SharedPreferenceDao.class);
    when(sharedPreferenceDao.savePreference(Mockito.<SharedPreference>any())).thenReturn(true);
    SharedPreferenceService sharedPreferenceService = new SharedPreferenceService(sharedPreferenceDao);
    SharedPreferenceSaveCommand command = mock(SharedPreferenceSaveCommand.class);
    when(command.value()).thenReturn("42");
    when(command.category()).thenReturn("Category");
    when(command.key()).thenReturn("Key");

    // Act
    boolean actualSavePreferenceResult = sharedPreferenceService.savePreference("janedoe", command);

    // Assert
    verify(sharedPreferenceDao).savePreference(isA(SharedPreference.class));
    verify(command).category();
    verify(command).key();
    verify(command).value();
    assertTrue(actualSavePreferenceResult);
  }

  /**
   * Method under test:
   * {@link SharedPreferenceService#savePreference(String, SharedPreferenceSaveCommand)}
   */
  @Test
  void testSavePreference2() {
    // Arrange
    SharedPreferenceDao sharedPreferenceDao = mock(SharedPreferenceDao.class);
    when(sharedPreferenceDao.savePreference(Mockito.<SharedPreference>any())).thenReturn(false);
    SharedPreferenceService sharedPreferenceService = new SharedPreferenceService(sharedPreferenceDao);
    SharedPreferenceSaveCommand command = mock(SharedPreferenceSaveCommand.class);
    when(command.value()).thenReturn("42");
    when(command.category()).thenReturn("Category");
    when(command.key()).thenReturn("Key");

    // Act
    boolean actualSavePreferenceResult = sharedPreferenceService.savePreference("janedoe", command);

    // Assert
    verify(sharedPreferenceDao).savePreference(isA(SharedPreference.class));
    verify(command).category();
    verify(command).key();
    verify(command).value();
    assertFalse(actualSavePreferenceResult);
  }
}
