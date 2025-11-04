package org.finos.waltz.jobs.clients.c1.sc1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.junit.jupiter.api.Test;

class ImmutableFlowRowDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFlowRow#builder()}
   *   <li>{@link ImmutableFlowRow#endDate(String)}
   *   <li>{@link ImmutableFlowRow#startDate(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableFlowRow.Builder actualEndDateResult = ImmutableFlowRow.builder().endDate("2020-03-01");

    // Assert
    assertSame(actualEndDateResult, actualEndDateResult.startDate("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableFlowRow.Builder#from(FlowRow)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableFlowRow.Builder builderResult = ImmutableFlowRow.builder();
    FlowRow instance = mock(FlowRow.class);
    when(instance.endDate()).thenReturn("2020-03-01");
    when(instance.startDate()).thenReturn("2020-03-01");
    when(instance.status()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.targetAppName()).thenReturn("Target App Name");
    when(instance.sourceAppName()).thenReturn("Source App Name");

    // Act
    ImmutableFlowRow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).endDate();
    verify(instance).sourceAppName();
    verify(instance).startDate();
    verify(instance).status();
    verify(instance).targetAppName();
    ImmutableFlowRow buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.endDate());
    assertEquals("2020-03-01", buildResult.startDate());
    assertEquals("Source App Name", buildResult.sourceAppName());
    assertEquals("Target App Name", buildResult.targetAppName());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableFlowRow.Builder#from(FlowRow)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableFlowRow.Builder builderResult = ImmutableFlowRow.builder();
    FlowRow instance = mock(FlowRow.class);
    when(instance.startDate()).thenThrow(new IllegalStateException("instance"));
    when(instance.status()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.targetAppName()).thenReturn("Target App Name");
    when(instance.sourceAppName()).thenReturn("Source App Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).sourceAppName();
    verify(instance).startDate();
    verify(instance).status();
    verify(instance).targetAppName();
  }

  /**
   * Method under test: {@link ImmutableFlowRow.Builder#from(FlowRow)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableFlowRow.Builder builderResult = ImmutableFlowRow.builder();
    FlowRow instance = mock(FlowRow.class);
    when(instance.endDate()).thenReturn(null);
    when(instance.startDate()).thenReturn("2020-03-01");
    when(instance.status()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.targetAppName()).thenReturn("Target App Name");
    when(instance.sourceAppName()).thenReturn("Source App Name");

    // Act
    ImmutableFlowRow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).endDate();
    verify(instance).sourceAppName();
    verify(instance).startDate();
    verify(instance).status();
    verify(instance).targetAppName();
    ImmutableFlowRow buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.startDate());
    assertEquals("Source App Name", buildResult.sourceAppName());
    assertEquals("Target App Name", buildResult.targetAppName());
    assertNull(buildResult.endDate());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableFlowRow.Builder#from(FlowRow)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableFlowRow.Builder builderResult = ImmutableFlowRow.builder();
    FlowRow instance = mock(FlowRow.class);
    when(instance.endDate()).thenReturn("2020-03-01");
    when(instance.startDate()).thenReturn(null);
    when(instance.status()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.targetAppName()).thenReturn("Target App Name");
    when(instance.sourceAppName()).thenReturn("Source App Name");

    // Act
    ImmutableFlowRow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).endDate();
    verify(instance).sourceAppName();
    verify(instance).startDate();
    verify(instance).status();
    verify(instance).targetAppName();
    ImmutableFlowRow buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.endDate());
    assertEquals("Source App Name", buildResult.sourceAppName());
    assertEquals("Target App Name", buildResult.targetAppName());
    assertNull(buildResult.startDate());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableFlowRow.Builder#sourceAppName(String)}
   */
  @Test
  void testBuilderSourceAppName() {
    // Arrange
    ImmutableFlowRow.Builder builderResult = ImmutableFlowRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.sourceAppName("Source App Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowRow.Builder#status(EntityLifecycleStatus)}
   */
  @Test
  void testBuilderStatus() {
    // Arrange
    ImmutableFlowRow.Builder builderResult = ImmutableFlowRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.status(EntityLifecycleStatus.ACTIVE));
  }

  /**
   * Method under test: {@link ImmutableFlowRow.Builder#targetAppName(String)}
   */
  @Test
  void testBuilderTargetAppName() {
    // Arrange
    ImmutableFlowRow.Builder builderResult = ImmutableFlowRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetAppName("Target App Name"));
  }

  /**
   * Method under test: {@link ImmutableFlowRow#copyOf(FlowRow)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    FlowRow instance = mock(FlowRow.class);
    when(instance.endDate()).thenReturn("2020-03-01");
    when(instance.startDate()).thenReturn("2020-03-01");
    when(instance.status()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.targetAppName()).thenReturn("Target App Name");
    when(instance.sourceAppName()).thenReturn("Source App Name");

    // Act
    ImmutableFlowRow actualCopyOfResult = ImmutableFlowRow.copyOf(instance);

    // Assert
    verify(instance).endDate();
    verify(instance).sourceAppName();
    verify(instance).startDate();
    verify(instance).status();
    verify(instance).targetAppName();
    assertEquals("2020-03-01", actualCopyOfResult.endDate());
    assertEquals("2020-03-01", actualCopyOfResult.startDate());
    assertEquals("Source App Name", actualCopyOfResult.sourceAppName());
    assertEquals("Target App Name", actualCopyOfResult.targetAppName());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.status());
  }
}
