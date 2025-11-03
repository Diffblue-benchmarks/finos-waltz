package org.finos.waltz.jobs.clients.c1.sc1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.clients.c1.sc1.model.ImmutableFlowRow.Builder;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowRowDiffblueTest {
  /**
   * Test {@link ImmutableFlowRow#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFlowRow#builder()}
   *   <li>{@link ImmutableFlowRow#endDate(String)}
   *   <li>{@link ImmutableFlowRow#startDate(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFlowRow Builder.build()", "Builder Builder.endDate(String)",
      "Builder Builder.startDate(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualEndDateResult = ImmutableFlowRow.builder().endDate("2020-03-01");

    // Assert
    assertSame(actualEndDateResult, actualEndDateResult.startDate("2020-03-01"));
  }

  /**
   * Test Builder {@link Builder#from(FlowRow)}.
   * <ul>
   *   <li>Then builder build endDate is {@code 2020-03-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowRow)}
   */
  @Test
  @DisplayName("Test Builder from(FlowRow); then builder build endDate is '2020-03-01'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowRow)"})
  void testBuilderFrom_thenBuilderBuildEndDateIs20200301() {
    // Arrange
    Builder builderResult = ImmutableFlowRow.builder();
    FlowRow instance = mock(FlowRow.class);
    when(instance.endDate()).thenReturn("2020-03-01");
    when(instance.startDate()).thenReturn("2020-03-01");
    when(instance.status()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.targetAppName()).thenReturn("Target App Name");
    when(instance.sourceAppName()).thenReturn("Source App Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(FlowRow)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowRow)}
   */
  @Test
  @DisplayName("Test Builder from(FlowRow); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowRow)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableFlowRow.builder();
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
   * Test Builder {@link Builder#from(FlowRow)}.
   * <ul>
   *   <li>When {@link FlowRow} {@link FlowRow#endDate()} return {@code null}.</li>
   *   <li>Then builder build endDate is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowRow)}
   */
  @Test
  @DisplayName("Test Builder from(FlowRow); when FlowRow endDate() return 'null'; then builder build endDate is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowRow)"})
  void testBuilderFrom_whenFlowRowEndDateReturnNull_thenBuilderBuildEndDateIsNull() {
    // Arrange
    Builder builderResult = ImmutableFlowRow.builder();
    FlowRow instance = mock(FlowRow.class);
    when(instance.endDate()).thenReturn(null);
    when(instance.startDate()).thenReturn("2020-03-01");
    when(instance.status()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.targetAppName()).thenReturn("Target App Name");
    when(instance.sourceAppName()).thenReturn("Source App Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(FlowRow)}.
   * <ul>
   *   <li>When {@link FlowRow} {@link FlowRow#startDate()} return {@code null}.</li>
   *   <li>Then builder build startDate is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowRow)}
   */
  @Test
  @DisplayName("Test Builder from(FlowRow); when FlowRow startDate() return 'null'; then builder build startDate is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowRow)"})
  void testBuilderFrom_whenFlowRowStartDateReturnNull_thenBuilderBuildStartDateIsNull() {
    // Arrange
    Builder builderResult = ImmutableFlowRow.builder();
    FlowRow instance = mock(FlowRow.class);
    when(instance.endDate()).thenReturn("2020-03-01");
    when(instance.startDate()).thenReturn(null);
    when(instance.status()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.targetAppName()).thenReturn("Target App Name");
    when(instance.sourceAppName()).thenReturn("Source App Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#sourceAppName(String)}.
   * <p>
   * Method under test: {@link Builder#sourceAppName(String)}
   */
  @Test
  @DisplayName("Test Builder sourceAppName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.sourceAppName(String)"})
  void testBuilderSourceAppName() {
    // Arrange
    Builder builderResult = ImmutableFlowRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.sourceAppName("Source App Name"));
  }

  /**
   * Test Builder {@link Builder#status(EntityLifecycleStatus)}.
   * <p>
   * Method under test: {@link Builder#status(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test Builder status(EntityLifecycleStatus)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.status(EntityLifecycleStatus)"})
  void testBuilderStatus() {
    // Arrange
    Builder builderResult = ImmutableFlowRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.status(EntityLifecycleStatus.ACTIVE));
  }

  /**
   * Test Builder {@link Builder#targetAppName(String)}.
   * <p>
   * Method under test: {@link Builder#targetAppName(String)}
   */
  @Test
  @DisplayName("Test Builder targetAppName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.targetAppName(String)"})
  void testBuilderTargetAppName() {
    // Arrange
    Builder builderResult = ImmutableFlowRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetAppName("Target App Name"));
  }
}
