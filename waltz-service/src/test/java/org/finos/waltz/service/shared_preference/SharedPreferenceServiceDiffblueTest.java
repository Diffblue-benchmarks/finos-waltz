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
import org.finos.waltz.model.shared_preference.SharedPreference;
import org.finos.waltz.model.shared_preference.SharedPreferenceSaveCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SharedPreferenceServiceDiffblueTest {
  @Mock private SharedPreferenceDao sharedPreferenceDao;

  @InjectMocks private SharedPreferenceService sharedPreferenceService;

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
    SharedPreference actualPreference = sharedPreferenceService.getPreference("Key", "Category");

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
   *   <li>When {@code Category}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SharedPreferenceService#findPreferencesByCategory(String)}
   */
  @Test
  @DisplayName("Test findPreferencesByCategory(String); when 'Category'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SharedPreferenceService.findPreferencesByCategory(String)"})
  void testFindPreferencesByCategory_whenCategory_thenReturnEmpty() {
    // Arrange
    when(sharedPreferenceDao.findPreferencesByCategory(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<SharedPreference> actualFindPreferencesByCategoryResult =
        sharedPreferenceService.findPreferencesByCategory("Category");

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
    when(sharedPreferenceDao.savePreference(Mockito.<SharedPreference>any())).thenReturn(false);

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
    when(sharedPreferenceDao.savePreference(Mockito.<SharedPreference>any())).thenReturn(true);

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
}
