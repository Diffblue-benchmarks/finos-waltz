package org.finos.waltz.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.finos.waltz.model.settings.Setting;
import org.finos.waltz.service.person_hierarchy.PersonHierarchyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.jndi.JndiPropertySource;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@ExtendWith(MockitoExtension.class)
class DIConfigurationDiffblueTest {
  @InjectMocks private DIConfiguration dIConfiguration;

  @Mock private PersonHierarchyService personHierarchyService;

  /**
   * Test {@link DIConfiguration#settingOverrides()}.
   *
   * <p>Method under test: {@link DIConfiguration#settingOverrides()}
   */
  @Test
  @DisplayName("Test settingOverrides()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection DIConfiguration.settingOverrides()"})
  void testSettingOverrides() {
    // Arrange and Act
    Collection<Setting> actualSettingOverridesResult = dIConfiguration.settingOverrides();

    // Assert
    assertTrue(actualSettingOverridesResult instanceof List);
    assertTrue(actualSettingOverridesResult.isEmpty());
  }

  /**
   * Test {@link DIConfiguration#propertySourcesPlaceholderConfigurer(ConfigurableEnvironment)}.
   *
   * <ul>
   *   <li>Then return Order is {@link Integer#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DIConfiguration#propertySourcesPlaceholderConfigurer(ConfigurableEnvironment)}
   */
  @Test
  @DisplayName(
      "Test propertySourcesPlaceholderConfigurer(ConfigurableEnvironment); then return Order is MAX_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertySourcesPlaceholderConfigurer DIConfiguration.propertySourcesPlaceholderConfigurer(ConfigurableEnvironment)"
  })
  void testPropertySourcesPlaceholderConfigurer_thenReturnOrderIsMax_value() {
    // Arrange
    StandardEnvironment env = new StandardEnvironment();

    // Act
    PropertySourcesPlaceholderConfigurer actualPropertySourcesPlaceholderConfigurerResult =
        DIConfiguration.propertySourcesPlaceholderConfigurer(env);

    // Assert
    assertEquals(Integer.MAX_VALUE, actualPropertySourcesPlaceholderConfigurerResult.getOrder());
    MutablePropertySources propertySources = env.getPropertySources();
    Iterator<PropertySource<?>> iteratorResult = propertySources.iterator();
    PropertySource<?> nextResult = iteratorResult.next();
    PropertySource<?> nextResult2 = iteratorResult.next();
    PropertySource<?> nextResult3 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult instanceof JndiPropertySource);
    assertTrue(nextResult2 instanceof PropertiesPropertySource);
    assertTrue(nextResult3 instanceof SystemEnvironmentPropertySource);
    assertEquals(3, propertySources.size());
    assertEquals(3L, propertySources.spliterator().getExactSizeIfKnown());
    Stream<PropertySource<?>> streamResult = propertySources.stream();
    List<PropertySource<?>> collectResult = streamResult.limit(5).collect(Collectors.toList());
    assertEquals(3, collectResult.size());
    assertSame(nextResult3, collectResult.get(2));
  }

  /**
   * Test {@link DIConfiguration#personMaintenance(PersonHierarchyService)}.
   *
   * <p>Method under test: {@link DIConfiguration#personMaintenance(PersonHierarchyService)}
   */
  @Test
  @DisplayName("Test personMaintenance(PersonHierarchyService)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.service.jmx.PersonMaintenance DIConfiguration.personMaintenance(PersonHierarchyService)"
  })
  void testPersonMaintenance() {
    // Arrange, Act and Assert
    assertEquals("Person", dIConfiguration.personMaintenance(personHierarchyService).getName());
  }

  /**
   * Test {@link DIConfiguration#taskScheduler()}.
   *
   * <p>Method under test: {@link DIConfiguration#taskScheduler()}
   */
  @Test
  @DisplayName("Test taskScheduler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TaskScheduler DIConfiguration.taskScheduler()"})
  void testTaskScheduler() {
    // Arrange and Act
    TaskScheduler actualTaskSchedulerResult = dIConfiguration.taskScheduler();

    // Assert
    assertTrue(actualTaskSchedulerResult instanceof ThreadPoolTaskScheduler);
    assertEquals(
        "ThreadPoolTaskScheduler-",
        ((ThreadPoolTaskScheduler) actualTaskSchedulerResult).getThreadNamePrefix());
    assertNull(((ThreadPoolTaskScheduler) actualTaskSchedulerResult).getThreadGroup());
    assertEquals(0, ((ThreadPoolTaskScheduler) actualTaskSchedulerResult).getActiveCount());
    assertEquals(1, ((ThreadPoolTaskScheduler) actualTaskSchedulerResult).getPoolSize());
    assertEquals(5, ((ThreadPoolTaskScheduler) actualTaskSchedulerResult).getThreadPriority());
    assertFalse(((ThreadPoolTaskScheduler) actualTaskSchedulerResult).isRemoveOnCancelPolicy());
    assertTrue(((ThreadPoolTaskScheduler) actualTaskSchedulerResult).isDaemon());
  }

  /**
   * Test {@link DIConfiguration#configureTasks(ScheduledTaskRegistrar)}.
   *
   * <ul>
   *   <li>Then {@link ScheduledTaskRegistrar} (default constructor) Scheduler {@link
   *       ThreadPoolTaskScheduler}.
   * </ul>
   *
   * <p>Method under test: {@link DIConfiguration#configureTasks(ScheduledTaskRegistrar)}
   */
  @Test
  @DisplayName(
      "Test configureTasks(ScheduledTaskRegistrar); then ScheduledTaskRegistrar (default constructor) Scheduler ThreadPoolTaskScheduler")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DIConfiguration.configureTasks(ScheduledTaskRegistrar)"})
  void testConfigureTasks_thenScheduledTaskRegistrarSchedulerThreadPoolTaskScheduler() {
    // Arrange
    ScheduledTaskRegistrar scheduledTaskRegistrar = new ScheduledTaskRegistrar();

    // Act
    dIConfiguration.configureTasks(scheduledTaskRegistrar);

    // Assert
    TaskScheduler scheduler = scheduledTaskRegistrar.getScheduler();
    assertTrue(scheduler instanceof ThreadPoolTaskScheduler);
    assertEquals(
        "ThreadPoolTaskScheduler-", ((ThreadPoolTaskScheduler) scheduler).getThreadNamePrefix());
    assertNull(((ThreadPoolTaskScheduler) scheduler).getThreadGroup());
    assertEquals(0, ((ThreadPoolTaskScheduler) scheduler).getActiveCount());
    assertEquals(1, ((ThreadPoolTaskScheduler) scheduler).getPoolSize());
    assertEquals(5, ((ThreadPoolTaskScheduler) scheduler).getThreadPriority());
    assertFalse(((ThreadPoolTaskScheduler) scheduler).isRemoveOnCancelPolicy());
    assertTrue(((ThreadPoolTaskScheduler) scheduler).isDaemon());
  }
}
