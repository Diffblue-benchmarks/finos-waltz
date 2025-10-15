package org.finos.waltz.service.user;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.user.UserPreferenceDao;
import org.finos.waltz.model.user.ImmutableUserPreference;
import org.finos.waltz.model.user.UserPreference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserPreferenceServiceDiffblueTest {
  @Mock private UserPreferenceDao userPreferenceDao;

  @InjectMocks private UserPreferenceService userPreferenceService;

  /**
   * Test {@link UserPreferenceService#getPreferences(String)}.
   *
   * <ul>
   *   <li>When {@code janedoe}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link UserPreferenceService#getPreferences(String)}
   */
  @Test
  @DisplayName("Test getPreferences(String); when 'janedoe'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserPreferenceService.getPreferences(String)"})
  void testGetPreferences_whenJanedoe_thenReturnEmpty() {
    // Arrange
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<UserPreference> actualPreferences = userPreferenceService.getPreferences("janedoe");

    // Assert
    verify(userPreferenceDao).getPreferencesForUser("janedoe");
    assertTrue(actualPreferences.isEmpty());
  }

  /**
   * Test {@link UserPreferenceService#savePreferences(String, List)}.
   *
   * <ul>
   *   <li>Given builder key {@code Key} value {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link UserPreferenceService#savePreferences(String, List)}
   */
  @Test
  @DisplayName("Test savePreferences(String, List); given builder key 'Key' value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserPreferenceService.savePreferences(String, List)"})
  void testSavePreferences_givenBuilderKeyKeyValue42Build() {
    // Arrange
    when(userPreferenceDao.savePreferencesForUser(
            Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<UserPreference> preferences = new ArrayList<>();
    preferences.add(ImmutableUserPreference.builder().key("Key").value("42").build());

    // Act
    List<UserPreference> actualSavePreferencesResult =
        userPreferenceService.savePreferences("janedoe", preferences);

    // Assert
    verify(userPreferenceDao).getPreferencesForUser("janedoe");
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    assertTrue(actualSavePreferencesResult.isEmpty());
  }

  /**
   * Test {@link UserPreferenceService#savePreferences(String, List)}.
   *
   * <ul>
   *   <li>Given builder key {@code Key} value {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link UserPreferenceService#savePreferences(String, List)}
   */
  @Test
  @DisplayName("Test savePreferences(String, List); given builder key 'Key' value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserPreferenceService.savePreferences(String, List)"})
  void testSavePreferences_givenBuilderKeyKeyValue42Build2() {
    // Arrange
    when(userPreferenceDao.savePreferencesForUser(
            Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<UserPreference> preferences = new ArrayList<>();
    preferences.add(ImmutableUserPreference.builder().key("Key").value("42").build());
    preferences.add(ImmutableUserPreference.builder().key("Key").value("42").build());

    // Act
    List<UserPreference> actualSavePreferencesResult =
        userPreferenceService.savePreferences("janedoe", preferences);

    // Assert
    verify(userPreferenceDao).getPreferencesForUser("janedoe");
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    assertTrue(actualSavePreferencesResult.isEmpty());
  }

  /**
   * Test {@link UserPreferenceService#savePreferences(String, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link UserPreferenceService#savePreferences(String, List)}
   */
  @Test
  @DisplayName("Test savePreferences(String, List); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserPreferenceService.savePreferences(String, List)"})
  void testSavePreferences_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(userPreferenceDao.savePreferencesForUser(
            Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<UserPreference> actualSavePreferencesResult =
        userPreferenceService.savePreferences("janedoe", new ArrayList<>());

    // Assert
    verify(userPreferenceDao).getPreferencesForUser("janedoe");
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    assertTrue(actualSavePreferencesResult.isEmpty());
  }

  /**
   * Test {@link UserPreferenceService#savePreference(String, UserPreference)}.
   *
   * <ul>
   *   <li>Given {@link UserPreferenceDao} {@link UserPreferenceDao#savePreference(String,
   *       UserPreference)} return one.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link UserPreferenceService#savePreference(String, UserPreference)}
   */
  @Test
  @DisplayName(
      "Test savePreference(String, UserPreference); given UserPreferenceDao savePreference(String, UserPreference) return one; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserPreferenceService.savePreference(String, UserPreference)"})
  void testSavePreference_givenUserPreferenceDaoSavePreferenceReturnOne_thenReturnEmpty() {
    // Arrange
    when(userPreferenceDao.savePreference(Mockito.<String>any(), Mockito.<UserPreference>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<UserPreference> actualSavePreferenceResult =
        userPreferenceService.savePreference(
            "janedoe", ImmutableUserPreference.builder().key("Key").value("42").build());

    // Assert
    verify(userPreferenceDao).getPreferencesForUser("janedoe");
    verify(userPreferenceDao).savePreference(eq("janedoe"), isA(UserPreference.class));
    assertTrue(actualSavePreferenceResult.isEmpty());
  }

  /**
   * Test {@link UserPreferenceService#clearPreferences(String)}.
   *
   * <ul>
   *   <li>When {@code janedoe}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UserPreferenceService#clearPreferences(String)}
   */
  @Test
  @DisplayName("Test clearPreferences(String); when 'janedoe'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserPreferenceService.clearPreferences(String)"})
  void testClearPreferences_whenJanedoe_thenReturnTrue() {
    // Arrange
    doNothing().when(userPreferenceDao).clearPreferencesForUser(Mockito.<String>any());

    // Act
    boolean actualClearPreferencesResult = userPreferenceService.clearPreferences("janedoe");

    // Assert
    verify(userPreferenceDao).clearPreferencesForUser("janedoe");
    assertTrue(actualClearPreferencesResult);
  }
}
