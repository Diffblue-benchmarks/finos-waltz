package org.finos.waltz.jobs.clients.c1.sc1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.application.LifecyclePhase;
import org.junit.jupiter.api.Test;

class ImmutableApplicationRowDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableApplicationRow#builder()}
   *   <li>{@link ImmutableApplicationRow#endDate(String)}
   *   <li>{@link ImmutableApplicationRow#startDate(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableApplicationRow.Builder actualEndDateResult = ImmutableApplicationRow.builder().endDate("2020-03-01");

    // Assert
    assertSame(actualEndDateResult, actualEndDateResult.startDate("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationRow.Builder#businessCritical(boolean)}
   */
  @Test
  void testBuilderBusinessCritical() {
    // Arrange
    ImmutableApplicationRow.Builder builderResult = ImmutableApplicationRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.businessCritical(true));
  }

  /**
   * Method under test: {@link ImmutableApplicationRow.Builder#externalId(String)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableApplicationRow.Builder builderResult = ImmutableApplicationRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.externalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationRow.Builder#from(ApplicationRow)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableApplicationRow.Builder builderResult = ImmutableApplicationRow.builder();
    ApplicationRow instance = mock(ApplicationRow.class);
    when(instance.endDate()).thenReturn("2020-03-01");
    when(instance.startDate()).thenReturn("2020-03-01");
    when(instance.businessCritical()).thenReturn(true);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.version()).thenReturn("1.0.2");
    when(instance.name()).thenReturn("Name");
    when(instance.internalId()).thenReturn("42");
    when(instance.externalId()).thenReturn("42");

    // Act
    ImmutableApplicationRow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).businessCritical();
    verify(instance).endDate();
    verify(instance).externalId();
    verify(instance).internalId();
    verify(instance).lifecyclePhase();
    verify(instance).name();
    verify(instance).startDate();
    verify(instance).version();
    ImmutableApplicationRow buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
    assertEquals("2020-03-01", buildResult.endDate());
    assertEquals("2020-03-01", buildResult.startDate());
    assertEquals("42", buildResult.externalId());
    assertEquals("42", buildResult.internalId());
    assertEquals("Name", buildResult.name());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertTrue(buildResult.businessCritical());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationRow.Builder#from(ApplicationRow)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableApplicationRow.Builder builderResult = ImmutableApplicationRow.builder();
    ApplicationRow instance = mock(ApplicationRow.class);
    when(instance.startDate()).thenThrow(new IllegalStateException("instance"));
    when(instance.businessCritical()).thenReturn(true);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.version()).thenReturn("1.0.2");
    when(instance.name()).thenReturn("Name");
    when(instance.internalId()).thenReturn("42");
    when(instance.externalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).businessCritical();
    verify(instance).externalId();
    verify(instance).internalId();
    verify(instance).lifecyclePhase();
    verify(instance).name();
    verify(instance).startDate();
    verify(instance).version();
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationRow.Builder#from(ApplicationRow)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableApplicationRow.Builder builderResult = ImmutableApplicationRow.builder();
    ApplicationRow instance = mock(ApplicationRow.class);
    when(instance.endDate()).thenReturn(null);
    when(instance.startDate()).thenReturn("2020-03-01");
    when(instance.businessCritical()).thenReturn(true);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.version()).thenReturn("1.0.2");
    when(instance.name()).thenReturn("Name");
    when(instance.internalId()).thenReturn("42");
    when(instance.externalId()).thenReturn("42");

    // Act
    ImmutableApplicationRow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).businessCritical();
    verify(instance).endDate();
    verify(instance).externalId();
    verify(instance).internalId();
    verify(instance).lifecyclePhase();
    verify(instance).name();
    verify(instance).startDate();
    verify(instance).version();
    ImmutableApplicationRow buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
    assertEquals("2020-03-01", buildResult.startDate());
    assertEquals("42", buildResult.externalId());
    assertEquals("42", buildResult.internalId());
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.endDate());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertTrue(buildResult.businessCritical());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationRow.Builder#from(ApplicationRow)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableApplicationRow.Builder builderResult = ImmutableApplicationRow.builder();
    ApplicationRow instance = mock(ApplicationRow.class);
    when(instance.endDate()).thenReturn("2020-03-01");
    when(instance.startDate()).thenReturn(null);
    when(instance.businessCritical()).thenReturn(true);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.version()).thenReturn("1.0.2");
    when(instance.name()).thenReturn("Name");
    when(instance.internalId()).thenReturn("42");
    when(instance.externalId()).thenReturn("42");

    // Act
    ImmutableApplicationRow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).businessCritical();
    verify(instance).endDate();
    verify(instance).externalId();
    verify(instance).internalId();
    verify(instance).lifecyclePhase();
    verify(instance).name();
    verify(instance).startDate();
    verify(instance).version();
    ImmutableApplicationRow buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
    assertEquals("2020-03-01", buildResult.endDate());
    assertEquals("42", buildResult.externalId());
    assertEquals("42", buildResult.internalId());
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.startDate());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertTrue(buildResult.businessCritical());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableApplicationRow.Builder#internalId(String)}
   */
  @Test
  void testBuilderInternalId() {
    // Arrange
    ImmutableApplicationRow.Builder builderResult = ImmutableApplicationRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.internalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationRow.Builder#lifecyclePhase(LifecyclePhase)}
   */
  @Test
  void testBuilderLifecyclePhase() {
    // Arrange
    ImmutableApplicationRow.Builder builderResult = ImmutableApplicationRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lifecyclePhase(LifecyclePhase.PRODUCTION));
  }

  /**
   * Method under test: {@link ImmutableApplicationRow.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableApplicationRow.Builder builderResult = ImmutableApplicationRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableApplicationRow.Builder#version(String)}
   */
  @Test
  void testBuilderVersion() {
    // Arrange
    ImmutableApplicationRow.Builder builderResult = ImmutableApplicationRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.version("1.0.2"));
  }

  /**
   * Method under test: {@link ImmutableApplicationRow#copyOf(ApplicationRow)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ApplicationRow instance = mock(ApplicationRow.class);
    when(instance.endDate()).thenReturn("2020-03-01");
    when(instance.startDate()).thenReturn("2020-03-01");
    when(instance.businessCritical()).thenReturn(true);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.version()).thenReturn("1.0.2");
    when(instance.name()).thenReturn("Name");
    when(instance.internalId()).thenReturn("42");
    when(instance.externalId()).thenReturn("42");

    // Act
    ImmutableApplicationRow actualCopyOfResult = ImmutableApplicationRow.copyOf(instance);

    // Assert
    verify(instance).businessCritical();
    verify(instance).endDate();
    verify(instance).externalId();
    verify(instance).internalId();
    verify(instance).lifecyclePhase();
    verify(instance).name();
    verify(instance).startDate();
    verify(instance).version();
    assertEquals("1.0.2", actualCopyOfResult.version());
    assertEquals("2020-03-01", actualCopyOfResult.endDate());
    assertEquals("2020-03-01", actualCopyOfResult.startDate());
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("42", actualCopyOfResult.internalId());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertTrue(actualCopyOfResult.businessCritical());
  }
}
