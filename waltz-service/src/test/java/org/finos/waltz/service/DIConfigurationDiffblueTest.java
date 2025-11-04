package org.finos.waltz.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.model.settings.Setting;
import org.finos.waltz.service.person_hierarchy.PersonHierarchyService;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

class DIConfigurationDiffblueTest {
  /**
   * Method under test: {@link DIConfiguration#settingOverrides()}
   */
  @Test
  void testSettingOverrides() {
    // Arrange
    DIConfiguration diConfiguration = new DIConfiguration();
    diConfiguration.personMaintenance(mock(PersonHierarchyService.class));

    // Act
    Collection<Setting> actualSettingOverridesResult = diConfiguration.settingOverrides();

    // Assert
    assertTrue(actualSettingOverridesResult instanceof List);
    assertTrue(actualSettingOverridesResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link DIConfiguration#propertySourcesPlaceholderConfigurer(ConfigurableEnvironment)}
   */
  @Test
  void testPropertySourcesPlaceholderConfigurer() {
    // Arrange
    StandardEnvironment env = mock(StandardEnvironment.class);
    when(env.getPropertySources()).thenReturn(new MutablePropertySources());

    // Act
    PropertySourcesPlaceholderConfigurer actualPropertySourcesPlaceholderConfigurerResult = DIConfiguration
        .propertySourcesPlaceholderConfigurer(env);

    // Assert
    verify(env).getPropertySources();
    assertEquals(Integer.MAX_VALUE, actualPropertySourcesPlaceholderConfigurerResult.getOrder());
  }

  /**
   * Method under test:
   * {@link DIConfiguration#personMaintenance(PersonHierarchyService)}
   */
  @Test
  void testPersonMaintenance() {
    // Arrange
    DIConfiguration diConfiguration = new DIConfiguration();
    diConfiguration.personMaintenance(mock(PersonHierarchyService.class));
    PersonDao personDao = mock(PersonDao.class);

    // Act and Assert
    assertEquals("Person",
        diConfiguration
            .personMaintenance(new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)))
            .getName());
  }

  /**
   * Method under test: {@link DIConfiguration#taskScheduler()}
   */
  @Test
  void testTaskScheduler() {
    // Arrange
    DIConfiguration diConfiguration = new DIConfiguration();
    diConfiguration.personMaintenance(mock(PersonHierarchyService.class));

    // Act
    TaskScheduler actualTaskSchedulerResult = diConfiguration.taskScheduler();

    // Assert
    assertTrue(actualTaskSchedulerResult instanceof ThreadPoolTaskScheduler);
    assertEquals("ThreadPoolTaskScheduler-",
        ((ThreadPoolTaskScheduler) actualTaskSchedulerResult).getThreadNamePrefix());
    assertNull(((ThreadPoolTaskScheduler) actualTaskSchedulerResult).getThreadGroup());
    assertEquals(0, ((ThreadPoolTaskScheduler) actualTaskSchedulerResult).getActiveCount());
    assertEquals(1, ((ThreadPoolTaskScheduler) actualTaskSchedulerResult).getPoolSize());
    assertEquals(5, ((ThreadPoolTaskScheduler) actualTaskSchedulerResult).getThreadPriority());
    assertFalse(((ThreadPoolTaskScheduler) actualTaskSchedulerResult).isRemoveOnCancelPolicy());
    assertTrue(((ThreadPoolTaskScheduler) actualTaskSchedulerResult).isDaemon());
  }

  /**
   * Method under test:
   * {@link DIConfiguration#configureTasks(ScheduledTaskRegistrar)}
   */
  @Test
  void testConfigureTasks() {
    // Arrange
    DIConfiguration diConfiguration = new DIConfiguration();
    diConfiguration.personMaintenance(mock(PersonHierarchyService.class));
    ScheduledTaskRegistrar scheduledTaskRegistrar = new ScheduledTaskRegistrar();

    // Act
    diConfiguration.configureTasks(scheduledTaskRegistrar);

    // Assert
    TaskScheduler scheduler = scheduledTaskRegistrar.getScheduler();
    assertTrue(scheduler instanceof ThreadPoolTaskScheduler);
    assertEquals("ThreadPoolTaskScheduler-", ((ThreadPoolTaskScheduler) scheduler).getThreadNamePrefix());
    assertNull(((ThreadPoolTaskScheduler) scheduler).getThreadGroup());
    assertEquals(0, ((ThreadPoolTaskScheduler) scheduler).getActiveCount());
    assertEquals(1, ((ThreadPoolTaskScheduler) scheduler).getPoolSize());
    assertEquals(5, ((ThreadPoolTaskScheduler) scheduler).getThreadPriority());
    assertFalse(((ThreadPoolTaskScheduler) scheduler).isRemoveOnCancelPolicy());
    assertTrue(((ThreadPoolTaskScheduler) scheduler).isDaemon());
  }
}
