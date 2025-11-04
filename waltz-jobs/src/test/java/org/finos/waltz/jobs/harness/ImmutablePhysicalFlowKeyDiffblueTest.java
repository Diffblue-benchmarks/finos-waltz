package org.finos.waltz.jobs.harness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowKeyDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowKey#builder()}
   *   <li>{@link ImmutablePhysicalFlowKey#flowDescription(String)}
   *   <li>{@link ImmutablePhysicalFlowKey#flowExtId(String)}
   *   <li>{@link ImmutablePhysicalFlowKey#flowName(String)}
   *   <li>{@link ImmutablePhysicalFlowKey#specDescription(String)}
   *   <li>{@link ImmutablePhysicalFlowKey#specExtId(String)}
   *   <li>{@link ImmutablePhysicalFlowKey#specName(String)}
   *   <li>{@link ImmutablePhysicalFlowKey#transport(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutablePhysicalFlowKey.Builder actualSpecNameResult = ImmutablePhysicalFlowKey.builder()
        .flowDescription("Flow Description")
        .flowExtId("42")
        .flowName("Flow Name")
        .specDescription("Spec Description")
        .specExtId("42")
        .specName("Spec Name");

    // Assert
    assertSame(actualSpecNameResult, actualSpecNameResult.transport("Transport"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowKey.Builder#from(PhysicalFlowHarness.PhysicalFlowKey)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePhysicalFlowKey.Builder builderResult = ImmutablePhysicalFlowKey.builder();
    PhysicalFlowHarness.PhysicalFlowKey instance = mock(PhysicalFlowHarness.PhysicalFlowKey.class);
    when(instance.flowDescription()).thenReturn("Flow Description");
    when(instance.flowExtId()).thenReturn("42");
    when(instance.flowName()).thenReturn("Flow Name");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExtId()).thenReturn("42");
    when(instance.specName()).thenReturn("Spec Name");
    when(instance.transport()).thenReturn("Transport");
    when(instance.lfId()).thenReturn(1L);
    when(instance.pfId()).thenReturn(1L);

    // Act
    ImmutablePhysicalFlowKey.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).flowDescription();
    verify(instance).flowExtId();
    verify(instance).flowName();
    verify(instance).lfId();
    verify(instance).pfId();
    verify(instance).specDescription();
    verify(instance).specExtId();
    verify(instance).specName();
    verify(instance).transport();
    ImmutablePhysicalFlowKey buildResult = builderResult.build();
    assertEquals("42", buildResult.flowExtId());
    assertEquals("42", buildResult.specExtId());
    assertEquals("Flow Description", buildResult.flowDescription());
    assertEquals("Flow Name", buildResult.flowName());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("Spec Name", buildResult.specName());
    assertEquals("Transport", buildResult.transport());
    assertEquals(1L, buildResult.lfId());
    assertEquals(1L, buildResult.pfId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowKey.Builder#from(PhysicalFlowHarness.PhysicalFlowKey)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutablePhysicalFlowKey.Builder builderResult = ImmutablePhysicalFlowKey.builder();
    PhysicalFlowHarness.PhysicalFlowKey instance = mock(PhysicalFlowHarness.PhysicalFlowKey.class);
    when(instance.flowDescription()).thenReturn(null);
    when(instance.flowExtId()).thenReturn("42");
    when(instance.flowName()).thenReturn("Flow Name");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExtId()).thenReturn("42");
    when(instance.specName()).thenReturn("Spec Name");
    when(instance.transport()).thenReturn("Transport");
    when(instance.lfId()).thenReturn(1L);
    when(instance.pfId()).thenReturn(1L);

    // Act
    ImmutablePhysicalFlowKey.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).flowDescription();
    verify(instance).flowExtId();
    verify(instance).flowName();
    verify(instance).lfId();
    verify(instance).pfId();
    verify(instance).specDescription();
    verify(instance).specExtId();
    verify(instance).specName();
    verify(instance).transport();
    ImmutablePhysicalFlowKey buildResult = builderResult.build();
    assertEquals("42", buildResult.flowExtId());
    assertEquals("42", buildResult.specExtId());
    assertEquals("Flow Name", buildResult.flowName());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("Spec Name", buildResult.specName());
    assertEquals("Transport", buildResult.transport());
    assertNull(buildResult.flowDescription());
    assertEquals(1L, buildResult.lfId());
    assertEquals(1L, buildResult.pfId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowKey.Builder#from(PhysicalFlowHarness.PhysicalFlowKey)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutablePhysicalFlowKey.Builder builderResult = ImmutablePhysicalFlowKey.builder();
    PhysicalFlowHarness.PhysicalFlowKey instance = mock(PhysicalFlowHarness.PhysicalFlowKey.class);
    when(instance.flowDescription()).thenReturn("Flow Description");
    when(instance.flowExtId()).thenReturn(null);
    when(instance.flowName()).thenReturn("Flow Name");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExtId()).thenReturn("42");
    when(instance.specName()).thenReturn("Spec Name");
    when(instance.transport()).thenReturn("Transport");
    when(instance.lfId()).thenReturn(1L);
    when(instance.pfId()).thenReturn(1L);

    // Act
    ImmutablePhysicalFlowKey.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).flowDescription();
    verify(instance).flowExtId();
    verify(instance).flowName();
    verify(instance).lfId();
    verify(instance).pfId();
    verify(instance).specDescription();
    verify(instance).specExtId();
    verify(instance).specName();
    verify(instance).transport();
    ImmutablePhysicalFlowKey buildResult = builderResult.build();
    assertEquals("42", buildResult.specExtId());
    assertEquals("Flow Description", buildResult.flowDescription());
    assertEquals("Flow Name", buildResult.flowName());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("Spec Name", buildResult.specName());
    assertEquals("Transport", buildResult.transport());
    assertNull(buildResult.flowExtId());
    assertEquals(1L, buildResult.lfId());
    assertEquals(1L, buildResult.pfId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowKey.Builder#from(PhysicalFlowHarness.PhysicalFlowKey)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutablePhysicalFlowKey.Builder builderResult = ImmutablePhysicalFlowKey.builder();
    PhysicalFlowHarness.PhysicalFlowKey instance = mock(PhysicalFlowHarness.PhysicalFlowKey.class);
    when(instance.flowDescription()).thenReturn("Flow Description");
    when(instance.flowExtId()).thenReturn("42");
    when(instance.flowName()).thenReturn(null);
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExtId()).thenReturn("42");
    when(instance.specName()).thenReturn("Spec Name");
    when(instance.transport()).thenReturn("Transport");
    when(instance.lfId()).thenReturn(1L);
    when(instance.pfId()).thenReturn(1L);

    // Act
    ImmutablePhysicalFlowKey.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).flowDescription();
    verify(instance).flowExtId();
    verify(instance).flowName();
    verify(instance).lfId();
    verify(instance).pfId();
    verify(instance).specDescription();
    verify(instance).specExtId();
    verify(instance).specName();
    verify(instance).transport();
    ImmutablePhysicalFlowKey buildResult = builderResult.build();
    assertEquals("42", buildResult.flowExtId());
    assertEquals("42", buildResult.specExtId());
    assertEquals("Flow Description", buildResult.flowDescription());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("Spec Name", buildResult.specName());
    assertEquals("Transport", buildResult.transport());
    assertNull(buildResult.flowName());
    assertEquals(1L, buildResult.lfId());
    assertEquals(1L, buildResult.pfId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowKey.Builder#from(PhysicalFlowHarness.PhysicalFlowKey)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutablePhysicalFlowKey.Builder builderResult = ImmutablePhysicalFlowKey.builder();
    PhysicalFlowHarness.PhysicalFlowKey instance = mock(PhysicalFlowHarness.PhysicalFlowKey.class);
    when(instance.flowDescription()).thenReturn("Flow Description");
    when(instance.flowExtId()).thenReturn("42");
    when(instance.flowName()).thenReturn("Flow Name");
    when(instance.specDescription()).thenReturn(null);
    when(instance.specExtId()).thenReturn("42");
    when(instance.specName()).thenReturn("Spec Name");
    when(instance.transport()).thenReturn("Transport");
    when(instance.lfId()).thenReturn(1L);
    when(instance.pfId()).thenReturn(1L);

    // Act
    ImmutablePhysicalFlowKey.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).flowDescription();
    verify(instance).flowExtId();
    verify(instance).flowName();
    verify(instance).lfId();
    verify(instance).pfId();
    verify(instance).specDescription();
    verify(instance).specExtId();
    verify(instance).specName();
    verify(instance).transport();
    ImmutablePhysicalFlowKey buildResult = builderResult.build();
    assertEquals("42", buildResult.flowExtId());
    assertEquals("42", buildResult.specExtId());
    assertEquals("Flow Description", buildResult.flowDescription());
    assertEquals("Flow Name", buildResult.flowName());
    assertEquals("Spec Name", buildResult.specName());
    assertEquals("Transport", buildResult.transport());
    assertNull(buildResult.specDescription());
    assertEquals(1L, buildResult.lfId());
    assertEquals(1L, buildResult.pfId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowKey.Builder#from(PhysicalFlowHarness.PhysicalFlowKey)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutablePhysicalFlowKey.Builder builderResult = ImmutablePhysicalFlowKey.builder();
    PhysicalFlowHarness.PhysicalFlowKey instance = mock(PhysicalFlowHarness.PhysicalFlowKey.class);
    when(instance.flowDescription()).thenReturn("Flow Description");
    when(instance.flowExtId()).thenReturn("42");
    when(instance.flowName()).thenReturn("Flow Name");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExtId()).thenReturn(null);
    when(instance.specName()).thenReturn("Spec Name");
    when(instance.transport()).thenReturn("Transport");
    when(instance.lfId()).thenReturn(1L);
    when(instance.pfId()).thenReturn(1L);

    // Act
    ImmutablePhysicalFlowKey.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).flowDescription();
    verify(instance).flowExtId();
    verify(instance).flowName();
    verify(instance).lfId();
    verify(instance).pfId();
    verify(instance).specDescription();
    verify(instance).specExtId();
    verify(instance).specName();
    verify(instance).transport();
    ImmutablePhysicalFlowKey buildResult = builderResult.build();
    assertEquals("42", buildResult.flowExtId());
    assertEquals("Flow Description", buildResult.flowDescription());
    assertEquals("Flow Name", buildResult.flowName());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("Spec Name", buildResult.specName());
    assertEquals("Transport", buildResult.transport());
    assertNull(buildResult.specExtId());
    assertEquals(1L, buildResult.lfId());
    assertEquals(1L, buildResult.pfId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowKey.Builder#from(PhysicalFlowHarness.PhysicalFlowKey)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutablePhysicalFlowKey.Builder builderResult = ImmutablePhysicalFlowKey.builder();
    PhysicalFlowHarness.PhysicalFlowKey instance = mock(PhysicalFlowHarness.PhysicalFlowKey.class);
    when(instance.flowDescription()).thenReturn("Flow Description");
    when(instance.flowExtId()).thenReturn("42");
    when(instance.flowName()).thenReturn("Flow Name");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExtId()).thenReturn("42");
    when(instance.specName()).thenReturn(null);
    when(instance.transport()).thenReturn("Transport");
    when(instance.lfId()).thenReturn(1L);
    when(instance.pfId()).thenReturn(1L);

    // Act
    ImmutablePhysicalFlowKey.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).flowDescription();
    verify(instance).flowExtId();
    verify(instance).flowName();
    verify(instance).lfId();
    verify(instance).pfId();
    verify(instance).specDescription();
    verify(instance).specExtId();
    verify(instance).specName();
    verify(instance).transport();
    ImmutablePhysicalFlowKey buildResult = builderResult.build();
    assertEquals("42", buildResult.flowExtId());
    assertEquals("42", buildResult.specExtId());
    assertEquals("Flow Description", buildResult.flowDescription());
    assertEquals("Flow Name", buildResult.flowName());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("Transport", buildResult.transport());
    assertNull(buildResult.specName());
    assertEquals(1L, buildResult.lfId());
    assertEquals(1L, buildResult.pfId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowKey.Builder#from(PhysicalFlowHarness.PhysicalFlowKey)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutablePhysicalFlowKey.Builder builderResult = ImmutablePhysicalFlowKey.builder();
    PhysicalFlowHarness.PhysicalFlowKey instance = mock(PhysicalFlowHarness.PhysicalFlowKey.class);
    when(instance.flowDescription()).thenReturn("Flow Description");
    when(instance.flowExtId()).thenReturn("42");
    when(instance.flowName()).thenReturn("Flow Name");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExtId()).thenReturn("42");
    when(instance.specName()).thenReturn("Spec Name");
    when(instance.transport()).thenReturn(null);
    when(instance.lfId()).thenReturn(1L);
    when(instance.pfId()).thenReturn(1L);

    // Act
    ImmutablePhysicalFlowKey.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).flowDescription();
    verify(instance).flowExtId();
    verify(instance).flowName();
    verify(instance).lfId();
    verify(instance).pfId();
    verify(instance).specDescription();
    verify(instance).specExtId();
    verify(instance).specName();
    verify(instance).transport();
    ImmutablePhysicalFlowKey buildResult = builderResult.build();
    assertEquals("42", buildResult.flowExtId());
    assertEquals("42", buildResult.specExtId());
    assertEquals("Flow Description", buildResult.flowDescription());
    assertEquals("Flow Name", buildResult.flowName());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("Spec Name", buildResult.specName());
    assertNull(buildResult.transport());
    assertEquals(1L, buildResult.lfId());
    assertEquals(1L, buildResult.pfId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowKey.Builder#from(PhysicalFlowHarness.PhysicalFlowKey)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutablePhysicalFlowKey.Builder builderResult = ImmutablePhysicalFlowKey.builder();
    PhysicalFlowHarness.PhysicalFlowKey instance = mock(PhysicalFlowHarness.PhysicalFlowKey.class);
    when(instance.lfId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lfId();
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowKey.Builder#lfId(long)}
   */
  @Test
  void testBuilderLfId() {
    // Arrange
    ImmutablePhysicalFlowKey.Builder builderResult = ImmutablePhysicalFlowKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lfId(1L));
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowKey.Builder#pfId(long)}
   */
  @Test
  void testBuilderPfId() {
    // Arrange
    ImmutablePhysicalFlowKey.Builder builderResult = ImmutablePhysicalFlowKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.pfId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowKey#copyOf(PhysicalFlowHarness.PhysicalFlowKey)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    PhysicalFlowHarness.PhysicalFlowKey instance = mock(PhysicalFlowHarness.PhysicalFlowKey.class);
    when(instance.flowDescription()).thenReturn("Flow Description");
    when(instance.flowExtId()).thenReturn("42");
    when(instance.flowName()).thenReturn("Flow Name");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExtId()).thenReturn("42");
    when(instance.specName()).thenReturn("Spec Name");
    when(instance.transport()).thenReturn("Transport");
    when(instance.lfId()).thenReturn(1L);
    when(instance.pfId()).thenReturn(1L);

    // Act
    ImmutablePhysicalFlowKey actualCopyOfResult = ImmutablePhysicalFlowKey.copyOf(instance);

    // Assert
    verify(instance).flowDescription();
    verify(instance).flowExtId();
    verify(instance).flowName();
    verify(instance).lfId();
    verify(instance).pfId();
    verify(instance).specDescription();
    verify(instance).specExtId();
    verify(instance).specName();
    verify(instance).transport();
    assertEquals("42", actualCopyOfResult.flowExtId());
    assertEquals("42", actualCopyOfResult.specExtId());
    assertEquals("Flow Description", actualCopyOfResult.flowDescription());
    assertEquals("Flow Name", actualCopyOfResult.flowName());
    assertEquals("Spec Description", actualCopyOfResult.specDescription());
    assertEquals("Spec Name", actualCopyOfResult.specName());
    assertEquals("Transport", actualCopyOfResult.transport());
    assertEquals(1L, actualCopyOfResult.lfId());
    assertEquals(1L, actualCopyOfResult.pfId());
  }
}
