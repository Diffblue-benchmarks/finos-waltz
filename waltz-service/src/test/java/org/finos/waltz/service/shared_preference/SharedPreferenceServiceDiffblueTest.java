package org.finos.waltz.service.shared_preference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.shared_preference.SharedPreferenceDao;
import org.finos.waltz.model.shared_preference.ImmutableSharedPreference;
import org.finos.waltz.model.shared_preference.ImmutableSharedPreferenceSaveCommand;
import org.finos.waltz.model.shared_preference.SharedPreference;
import org.finos.waltz.model.shared_preference.SharedPreferenceSaveCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SharedPreferenceServiceDiffblueTest {
  /**
   * Test {@link SharedPreferenceService#getPreference(String, String)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableSharedPreference}.
   * </ul>
   *
   * <p>Method under test: {@link SharedPreferenceService#getPreference(String, String)}
   */
  @Test
  @DisplayName("Test getPreference(String, String); then return ImmutableSharedPreference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SharedPreference SharedPreferenceService.getPreference(String, String)"})
  void testGetPreference_thenReturnImmutableSharedPreference() {
    // Arrange
    SharedPreferenceDao sharedPreferenceDao = mock(SharedPreferenceDao.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(sharedPreferenceDao.getPreference(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(
            ImmutableSharedPreference.builder()
                .category("Category")
                .key("Key")
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .value("42")
                .build());

    // Act
    SharedPreference actualPreference =
        new SharedPreferenceService(sharedPreferenceDao).getPreference("Key", "Category");

    // Assert
    verify(sharedPreferenceDao).getPreference("Key", "Category");
    assertTrue(actualPreference instanceof ImmutableSharedPreference);
    LocalDateTime lastUpdatedAtResult = actualPreference.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualPreference.lastUpdatedBy());
    assertEquals("42", actualPreference.value());
    assertEquals("Category", actualPreference.category());
    assertEquals("Key", actualPreference.key());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link SharedPreferenceService#findPreferencesByCategory(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SharedPreferenceService#findPreferencesByCategory(String)}
   */
  @Test
  @DisplayName("Test findPreferencesByCategory(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SharedPreferenceService.findPreferencesByCategory(String)"})
  void testFindPreferencesByCategory_thenReturnEmpty() {
    // Arrange
    SharedPreferenceDao sharedPreferenceDao = mock(SharedPreferenceDao.class);
    when(sharedPreferenceDao.findPreferencesByCategory(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<SharedPreference> actualFindPreferencesByCategoryResult =
        new SharedPreferenceService(sharedPreferenceDao).findPreferencesByCategory("Category");

    // Assert
    verify(sharedPreferenceDao).findPreferencesByCategory("Category");
    assertTrue(actualFindPreferencesByCategoryResult.isEmpty());
  }

  /**
   * Test {@link SharedPreferenceService#savePreference(String, SharedPreferenceSaveCommand)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SharedPreferenceService#savePreference(String,
   * SharedPreferenceSaveCommand)}
   */
  @Test
  @DisplayName("Test savePreference(String, SharedPreferenceSaveCommand); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SharedPreferenceService.savePreference(String, SharedPreferenceSaveCommand)"
  })
  void testSavePreference_thenReturnFalse() {
    // Arrange
    SharedPreferenceDao sharedPreferenceDao = mock(SharedPreferenceDao.class);
    when(sharedPreferenceDao.savePreference(Mockito.<SharedPreference>any())).thenReturn(false);
    SharedPreferenceService sharedPreferenceService =
        new SharedPreferenceService(sharedPreferenceDao);

    // Act
    boolean actualSavePreferenceResult =
        sharedPreferenceService.savePreference(
            "janedoe",
            ImmutableSharedPreferenceSaveCommand.builder()
                .category("Category")
                .key("Key")
                .value("42")
                .build());

    // Assert
    verify(sharedPreferenceDao).savePreference(isA(SharedPreference.class));
    assertFalse(actualSavePreferenceResult);
  }

  /**
   * Test {@link SharedPreferenceService#savePreference(String, SharedPreferenceSaveCommand)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SharedPreferenceService#savePreference(String,
   * SharedPreferenceSaveCommand)}
   */
  @Test
  @DisplayName("Test savePreference(String, SharedPreferenceSaveCommand); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SharedPreferenceService.savePreference(String, SharedPreferenceSaveCommand)"
  })
  void testSavePreference_thenReturnTrue() {
    // Arrange
    SharedPreferenceDao sharedPreferenceDao = mock(SharedPreferenceDao.class);
    when(sharedPreferenceDao.savePreference(Mockito.<SharedPreference>any())).thenReturn(true);
    SharedPreferenceService sharedPreferenceService =
        new SharedPreferenceService(sharedPreferenceDao);

    // Act
    boolean actualSavePreferenceResult =
        sharedPreferenceService.savePreference(
            "janedoe",
            ImmutableSharedPreferenceSaveCommand.builder()
                .category("Category")
                .key("Key")
                .value("42")
                .build());

    // Assert
    verify(sharedPreferenceDao).savePreference(isA(SharedPreference.class));
    assertTrue(actualSavePreferenceResult);
  }
}
