package org.finos.waltz.service.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Optional;
import org.finos.waltz.data.notification.NotificationDao;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.model.notification.ImmutableNotificationResponse;
import org.finos.waltz.model.notification.NotificationResponse;
import org.finos.waltz.model.notification.NotificationSummary;
import org.finos.waltz.model.settings.Setting;
import org.finos.waltz.service.settings.SettingsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class NotificationServiceDiffblueTest {
  /**
   * Method under test:
   * {@link NotificationService#getNotificationsByUserId(String)}
   */
  @Test
  void testGetNotificationsByUserId() {
    // Arrange
    NotificationDao notificationDao = mock(NotificationDao.class);
    when(notificationDao.findNotificationsByUserId(Mockito.<String>any())).thenReturn(new ArrayList<>());
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any())).thenReturn(null);

    // Act
    NotificationResponse actualNotificationsByUserId = (new NotificationService(notificationDao,
        new SettingsService(settingsDao, new ArrayList<>()))).getNotificationsByUserId("42");

    // Assert
    verify(notificationDao).findNotificationsByUserId(eq("42"));
    verify(settingsDao).getByName(eq("ui.banner.notification.text"));
    assertTrue(actualNotificationsByUserId instanceof ImmutableNotificationResponse);
    assertTrue(actualNotificationsByUserId.summary().isEmpty());
  }

  /**
   * Method under test:
   * {@link NotificationService#getNotificationsByUserId(String)}
   */
  @Test
  void testGetNotificationsByUserId2() {
    // Arrange
    ArrayList<NotificationSummary> notificationSummaryList = new ArrayList<>();
    notificationSummaryList.add(mock(NotificationSummary.class));
    NotificationDao notificationDao = mock(NotificationDao.class);
    when(notificationDao.findNotificationsByUserId(Mockito.<String>any())).thenReturn(notificationSummaryList);
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any())).thenReturn(null);

    // Act
    NotificationResponse actualNotificationsByUserId = (new NotificationService(notificationDao,
        new SettingsService(settingsDao, new ArrayList<>()))).getNotificationsByUserId("42");

    // Assert
    verify(notificationDao).findNotificationsByUserId(eq("42"));
    verify(settingsDao).getByName(eq("ui.banner.notification.text"));
    assertTrue(actualNotificationsByUserId instanceof ImmutableNotificationResponse);
    assertEquals(1, actualNotificationsByUserId.summary().size());
  }

  /**
   * Method under test:
   * {@link NotificationService#getNotificationsByUserId(String)}
   */
  @Test
  void testGetNotificationsByUserId3() {
    // Arrange
    ArrayList<NotificationSummary> notificationSummaryList = new ArrayList<>();
    notificationSummaryList.add(mock(NotificationSummary.class));
    notificationSummaryList.add(mock(NotificationSummary.class));
    NotificationDao notificationDao = mock(NotificationDao.class);
    when(notificationDao.findNotificationsByUserId(Mockito.<String>any())).thenReturn(notificationSummaryList);
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any())).thenReturn(null);

    // Act
    NotificationResponse actualNotificationsByUserId = (new NotificationService(notificationDao,
        new SettingsService(settingsDao, new ArrayList<>()))).getNotificationsByUserId("42");

    // Assert
    verify(notificationDao).findNotificationsByUserId(eq("42"));
    verify(settingsDao).getByName(eq("ui.banner.notification.text"));
    assertTrue(actualNotificationsByUserId instanceof ImmutableNotificationResponse);
    assertEquals(notificationSummaryList, actualNotificationsByUserId.summary());
  }

  /**
   * Method under test:
   * {@link NotificationService#getNotificationsByUserId(String)}
   */
  @Test
  void testGetNotificationsByUserId4() {
    // Arrange
    NotificationDao notificationDao = mock(NotificationDao.class);
    when(notificationDao.findNotificationsByUserId(Mockito.<String>any())).thenReturn(new ArrayList<>());
    Setting setting = mock(Setting.class);
    Optional<String> ofResult = Optional.of("foo");
    when(setting.value()).thenReturn(ofResult);
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any())).thenReturn(setting);

    // Act
    NotificationResponse actualNotificationsByUserId = (new NotificationService(notificationDao,
        new SettingsService(settingsDao, new ArrayList<>()))).getNotificationsByUserId("42");

    // Assert
    verify(notificationDao).findNotificationsByUserId(eq("42"));
    verify(settingsDao).getByName(eq("ui.banner.notification.text"));
    verify(setting).value();
    assertTrue(actualNotificationsByUserId instanceof ImmutableNotificationResponse);
    assertTrue(actualNotificationsByUserId.summary().isEmpty());
  }

  /**
   * Method under test:
   * {@link NotificationService#getNotificationsByUserId(String)}
   */
  @Test
  void testGetNotificationsByUserId5() {
    // Arrange
    NotificationDao notificationDao = mock(NotificationDao.class);
    when(notificationDao.findNotificationsByUserId(Mockito.<String>any())).thenReturn(new ArrayList<>());
    SettingsService settingsService = mock(SettingsService.class);
    Optional<String> ofResult = Optional.of("foo");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);

    // Act
    NotificationResponse actualNotificationsByUserId = (new NotificationService(notificationDao, settingsService))
        .getNotificationsByUserId("42");

    // Assert
    verify(notificationDao).findNotificationsByUserId(eq("42"));
    verify(settingsService).getValue(eq("ui.banner.notification.text"));
    assertTrue(actualNotificationsByUserId instanceof ImmutableNotificationResponse);
    assertTrue(actualNotificationsByUserId.summary().isEmpty());
  }
}
