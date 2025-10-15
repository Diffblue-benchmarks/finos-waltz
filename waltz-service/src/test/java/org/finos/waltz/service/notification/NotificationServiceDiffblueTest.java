package org.finos.waltz.service.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Optional;
import org.finos.waltz.data.notification.NotificationDao;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.notification.ImmutableNotificationResponse;
import org.finos.waltz.model.notification.ImmutableNotificationSummary;
import org.finos.waltz.model.notification.NotificationResponse;
import org.finos.waltz.model.notification.NotificationSummary;
import org.finos.waltz.model.settings.ImmutableSetting;
import org.finos.waltz.service.settings.SettingsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NotificationServiceDiffblueTest {
  @Mock private NotificationDao notificationDao;

  @InjectMocks private NotificationService notificationService;

  @Mock private SettingsService settingsService;

  /**
   * Test {@link NotificationService#getNotificationsByUserId(String)}.
   *
   * <ul>
   *   <li>Then calls {@link SettingsDao#getByName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationService#getNotificationsByUserId(String)}
   */
  @Test
  @DisplayName("Test getNotificationsByUserId(String); then calls getByName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationResponse NotificationService.getNotificationsByUserId(String)"})
  void testGetNotificationsByUserId_thenCallsGetByName() {
    // Arrange
    NotificationDao notificationDao = mock(NotificationDao.class);
    when(notificationDao.findNotificationsByUserId(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("42")
                .build());
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    NotificationService notificationService =
        new NotificationService(notificationDao, settingsService);

    // Act
    NotificationResponse actualNotificationsByUserId =
        notificationService.getNotificationsByUserId("42");

    // Assert
    verify(notificationDao).findNotificationsByUserId("42");
    verify(settingsDao).getByName("ui.banner.notification.text");
    assertTrue(actualNotificationsByUserId instanceof ImmutableNotificationResponse);
    assertTrue(actualNotificationsByUserId.summary().isEmpty());
  }

  /**
   * Test {@link NotificationService#getNotificationsByUserId(String)}.
   *
   * <ul>
   *   <li>Then return summary Empty.
   * </ul>
   *
   * <p>Method under test: {@link NotificationService#getNotificationsByUserId(String)}
   */
  @Test
  @DisplayName("Test getNotificationsByUserId(String); then return summary Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationResponse NotificationService.getNotificationsByUserId(String)"})
  void testGetNotificationsByUserId_thenReturnSummaryEmpty() {
    // Arrange
    when(notificationDao.findNotificationsByUserId(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    Optional<String> ofResult = Optional.of("foo");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);

    // Act
    NotificationResponse actualNotificationsByUserId =
        notificationService.getNotificationsByUserId("42");

    // Assert
    verify(notificationDao).findNotificationsByUserId("42");
    verify(settingsService).getValue("ui.banner.notification.text");
    assertTrue(actualNotificationsByUserId instanceof ImmutableNotificationResponse);
    assertTrue(actualNotificationsByUserId.summary().isEmpty());
  }

  /**
   * Test {@link NotificationService#getNotificationsByUserId(String)}.
   *
   * <ul>
   *   <li>Then return summary is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationService#getNotificationsByUserId(String)}
   */
  @Test
  @DisplayName("Test getNotificationsByUserId(String); then return summary is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationResponse NotificationService.getNotificationsByUserId(String)"})
  void testGetNotificationsByUserId_thenReturnSummaryIsArrayList() {
    // Arrange
    ArrayList<NotificationSummary> notificationSummaryList = new ArrayList<>();
    notificationSummaryList.add(
        ImmutableNotificationSummary.builder().count(3).kind(EntityKind.ALL).build());
    when(notificationDao.findNotificationsByUserId(Mockito.<String>any()))
        .thenReturn(notificationSummaryList);
    Optional<String> ofResult = Optional.of("foo");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);

    // Act
    NotificationResponse actualNotificationsByUserId =
        notificationService.getNotificationsByUserId("42");

    // Assert
    verify(notificationDao).findNotificationsByUserId("42");
    verify(settingsService).getValue("ui.banner.notification.text");
    assertTrue(actualNotificationsByUserId instanceof ImmutableNotificationResponse);
    assertEquals(notificationSummaryList, actualNotificationsByUserId.summary());
  }

  /**
   * Test {@link NotificationService#getNotificationsByUserId(String)}.
   *
   * <ul>
   *   <li>Then return summary is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationService#getNotificationsByUserId(String)}
   */
  @Test
  @DisplayName("Test getNotificationsByUserId(String); then return summary is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationResponse NotificationService.getNotificationsByUserId(String)"})
  void testGetNotificationsByUserId_thenReturnSummaryIsArrayList2() {
    // Arrange
    ArrayList<NotificationSummary> notificationSummaryList = new ArrayList<>();
    notificationSummaryList.add(
        ImmutableNotificationSummary.builder().count(3).kind(EntityKind.ALL).build());
    notificationSummaryList.add(
        ImmutableNotificationSummary.builder().count(3).kind(EntityKind.ALL).build());
    when(notificationDao.findNotificationsByUserId(Mockito.<String>any()))
        .thenReturn(notificationSummaryList);
    Optional<String> ofResult = Optional.of("foo");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);

    // Act
    NotificationResponse actualNotificationsByUserId =
        notificationService.getNotificationsByUserId("42");

    // Assert
    verify(notificationDao).findNotificationsByUserId("42");
    verify(settingsService).getValue("ui.banner.notification.text");
    assertTrue(actualNotificationsByUserId instanceof ImmutableNotificationResponse);
    assertEquals(notificationSummaryList, actualNotificationsByUserId.summary());
  }
}
