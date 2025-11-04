package org.finos.waltz.jobs.harness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableLogicalFlowKeyDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableLogicalFlowKey.Builder#from(PhysicalFlowHarness.LogicalFlowKey)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableLogicalFlowKey.Builder builderResult = ImmutableLogicalFlowKey.builder();
    PhysicalFlowHarness.LogicalFlowKey instance = mock(PhysicalFlowHarness.LogicalFlowKey.class);
    when(instance.lfId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lfId();
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowKey.Builder#from(PhysicalFlowHarness.LogicalFlowKey)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableLogicalFlowKey.Builder builderResult = ImmutableLogicalFlowKey.builder();
    PhysicalFlowHarness.LogicalFlowKey instance = mock(PhysicalFlowHarness.LogicalFlowKey.class);
    when(instance.trg()).thenThrow(new IllegalStateException("instance"));
    when(instance.lfId()).thenReturn(1L);
    when(instance.src()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lfId();
    verify(instance).src();
    verify(instance).trg();
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowKey.Builder#from(PhysicalFlowHarness.LogicalFlowKey)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableLogicalFlowKey.Builder builderResult = ImmutableLogicalFlowKey.builder();
    PhysicalFlowHarness.LogicalFlowKey instance = mock(PhysicalFlowHarness.LogicalFlowKey.class);
    when(instance.trg()).thenReturn(mock(EntityReference.class));
    when(instance.lfId()).thenReturn(1L);
    when(instance.src()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableLogicalFlowKey.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lfId();
    verify(instance).src();
    verify(instance).trg();
    assertEquals(1L, actualFromResult.build().lfId());
    assertEquals(1L, builderResult.build().lfId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLogicalFlowKey.Builder#lfId(long)}
   */
  @Test
  void testBuilderLfId() {
    // Arrange
    ImmutableLogicalFlowKey.Builder builderResult = ImmutableLogicalFlowKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lfId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowKey.Builder#src(EntityReference)}
   */
  @Test
  void testBuilderSrc() {
    // Arrange
    ImmutableLogicalFlowKey.Builder builderResult = ImmutableLogicalFlowKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.src(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowKey.Builder#trg(EntityReference)}
   */
  @Test
  void testBuilderTrg() {
    // Arrange
    ImmutableLogicalFlowKey.Builder builderResult = ImmutableLogicalFlowKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.trg(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowKey#copyOf(PhysicalFlowHarness.LogicalFlowKey)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    PhysicalFlowHarness.LogicalFlowKey instance = mock(PhysicalFlowHarness.LogicalFlowKey.class);
    when(instance.trg()).thenReturn(mock(EntityReference.class));
    when(instance.lfId()).thenReturn(1L);
    when(instance.src()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableLogicalFlowKey actualCopyOfResult = ImmutableLogicalFlowKey.copyOf(instance);

    // Assert
    verify(instance).lfId();
    verify(instance).src();
    verify(instance).trg();
    assertEquals(1L, actualCopyOfResult.lfId());
  }
}
