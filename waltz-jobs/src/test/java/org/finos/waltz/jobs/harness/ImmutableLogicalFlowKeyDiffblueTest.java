package org.finos.waltz.jobs.harness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.harness.ImmutableLogicalFlowKey.Builder;
import org.finos.waltz.jobs.harness.PhysicalFlowHarness.LogicalFlowKey;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLogicalFlowKeyDiffblueTest {
  /**
   * Test Builder {@link Builder#from(LogicalFlowKey)}.
   * <ul>
   *   <li>Then builder build lfId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LogicalFlowKey)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowKey); then builder build lfId is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowKey)"})
  void testBuilderFrom_thenBuilderBuildLfIdIsOne() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowKey.builder();
    LogicalFlowKey instance = mock(LogicalFlowKey.class);
    when(instance.trg()).thenReturn(mock(EntityReference.class));
    when(instance.lfId()).thenReturn(1L);
    when(instance.src()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lfId();
    verify(instance).src();
    verify(instance).trg();
    assertEquals(1L, builderResult.build().lfId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowKey)}.
   * <ul>
   *   <li>When {@link LogicalFlowKey} {@link LogicalFlowKey#lfId()} throw {@link IllegalStateException#IllegalStateException(String)} with {@code instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LogicalFlowKey)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowKey); when LogicalFlowKey lfId() throw IllegalStateException(String) with 'instance'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowKey)"})
  void testBuilderFrom_whenLogicalFlowKeyLfIdThrowIllegalStateExceptionWithInstance() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowKey.builder();
    LogicalFlowKey instance = mock(LogicalFlowKey.class);
    when(instance.lfId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lfId();
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowKey)}.
   * <ul>
   *   <li>When {@link LogicalFlowKey} {@link LogicalFlowKey#trg()} throw {@link IllegalStateException#IllegalStateException(String)} with {@code instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LogicalFlowKey)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowKey); when LogicalFlowKey trg() throw IllegalStateException(String) with 'instance'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowKey)"})
  void testBuilderFrom_whenLogicalFlowKeyTrgThrowIllegalStateExceptionWithInstance() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowKey.builder();
    LogicalFlowKey instance = mock(LogicalFlowKey.class);
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
   * Test Builder {@link Builder#lfId(long)}.
   * <p>
   * Method under test: {@link Builder#lfId(long)}
   */
  @Test
  @DisplayName("Test Builder lfId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lfId(long)"})
  void testBuilderLfId() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lfId(1L));
  }

  /**
   * Test Builder {@link Builder#src(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#src(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder src(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.src(EntityReference)"})
  void testBuilderSrc_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.src(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#trg(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#trg(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder trg(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.trg(EntityReference)"})
  void testBuilderTrg_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.trg(mock(EntityReference.class)));
  }
}
