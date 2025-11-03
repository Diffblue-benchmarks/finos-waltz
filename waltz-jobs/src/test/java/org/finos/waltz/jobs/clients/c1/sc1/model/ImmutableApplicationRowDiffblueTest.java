package org.finos.waltz.jobs.clients.c1.sc1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.clients.c1.sc1.model.ImmutableApplicationRow.Builder;
import org.finos.waltz.model.application.LifecyclePhase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableApplicationRowDiffblueTest {
  /**
   * Test {@link ImmutableApplicationRow#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableApplicationRow#builder()}
   *   <li>{@link ImmutableApplicationRow#endDate(String)}
   *   <li>{@link ImmutableApplicationRow#startDate(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableApplicationRow Builder.build()", "Builder Builder.endDate(String)",
      "Builder Builder.startDate(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualEndDateResult = ImmutableApplicationRow.builder().endDate("2020-03-01");

    // Assert
    assertSame(actualEndDateResult, actualEndDateResult.startDate("2020-03-01"));
  }

  /**
   * Test Builder {@link Builder#businessCritical(boolean)}.
   * <p>
   * Method under test: {@link Builder#businessCritical(boolean)}
   */
  @Test
  @DisplayName("Test Builder businessCritical(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.businessCritical(boolean)"})
  void testBuilderBusinessCritical() {
    // Arrange
    Builder builderResult = ImmutableApplicationRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.businessCritical(true));
  }

  /**
   * Test Builder {@link Builder#externalId(String)}.
   * <p>
   * Method under test: {@link Builder#externalId(String)}
   */
  @Test
  @DisplayName("Test Builder externalId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.externalId(String)"})
  void testBuilderExternalId() {
    // Arrange
    Builder builderResult = ImmutableApplicationRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.externalId("42"));
  }

  /**
   * Test Builder {@link Builder#from(ApplicationRow)}.
   * <ul>
   *   <li>Then builder build endDate is {@code 2020-03-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApplicationRow)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationRow); then builder build endDate is '2020-03-01'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationRow)"})
  void testBuilderFrom_thenBuilderBuildEndDateIs20200301() {
    // Arrange
    Builder builderResult = ImmutableApplicationRow.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(ApplicationRow)}.
   * <ul>
   *   <li>Then builder build endDate is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApplicationRow)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationRow); then builder build endDate is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationRow)"})
  void testBuilderFrom_thenBuilderBuildEndDateIsNull() {
    // Arrange
    Builder builderResult = ImmutableApplicationRow.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(ApplicationRow)}.
   * <ul>
   *   <li>Then builder build startDate is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApplicationRow)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationRow); then builder build startDate is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationRow)"})
  void testBuilderFrom_thenBuilderBuildStartDateIsNull() {
    // Arrange
    Builder builderResult = ImmutableApplicationRow.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(ApplicationRow)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApplicationRow)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationRow); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationRow)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableApplicationRow.builder();
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
   * Test Builder {@link Builder#internalId(String)}.
   * <p>
   * Method under test: {@link Builder#internalId(String)}
   */
  @Test
  @DisplayName("Test Builder internalId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.internalId(String)"})
  void testBuilderInternalId() {
    // Arrange
    Builder builderResult = ImmutableApplicationRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.internalId("42"));
  }

  /**
   * Test Builder {@link Builder#lifecyclePhase(LifecyclePhase)}.
   * <p>
   * Method under test: {@link Builder#lifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test Builder lifecyclePhase(LifecyclePhase)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lifecyclePhase(LifecyclePhase)"})
  void testBuilderLifecyclePhase() {
    // Arrange
    Builder builderResult = ImmutableApplicationRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lifecyclePhase(LifecyclePhase.PRODUCTION));
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableApplicationRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#version(String)}.
   * <p>
   * Method under test: {@link Builder#version(String)}
   */
  @Test
  @DisplayName("Test Builder version(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.version(String)"})
  void testBuilderVersion() {
    // Arrange
    Builder builderResult = ImmutableApplicationRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.version("1.0.2"));
  }
}
