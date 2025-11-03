package org.finos.waltz.jobs.harness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.harness.ImmutablePhysicalFlowKey.Builder;
import org.finos.waltz.jobs.harness.PhysicalFlowHarness.PhysicalFlowKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowKeyDiffblueTest {
  /**
   * Test {@link ImmutablePhysicalFlowKey#builder()}.
   * <p>
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
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutablePhysicalFlowKey Builder.build()", "Builder Builder.flowDescription(String)",
      "Builder Builder.flowExtId(String)", "Builder Builder.flowName(String)",
      "Builder Builder.specDescription(String)", "Builder Builder.specExtId(String)",
      "Builder Builder.specName(String)", "Builder Builder.transport(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualSpecNameResult = ImmutablePhysicalFlowKey.builder()
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
   * Test Builder {@link Builder#from(PhysicalFlowKey)}.
   * <ul>
   *   <li>Given {@code Flow Description}.</li>
   *   <li>Then builder build flowExtId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowKey)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowKey); given 'Flow Description'; then builder build flowExtId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowKey)"})
  void testBuilderFrom_givenFlowDescription_thenBuilderBuildFlowExtIdIs42() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowKey.builder();
    PhysicalFlowKey instance = mock(PhysicalFlowKey.class);
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
    builderResult.from(instance);

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
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowKey)}.
   * <ul>
   *   <li>Then builder build flowDescription is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowKey)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowKey); then builder build flowDescription is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowKey)"})
  void testBuilderFrom_thenBuilderBuildFlowDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowKey.builder();
    PhysicalFlowKey instance = mock(PhysicalFlowKey.class);
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
    builderResult.from(instance);

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
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowKey)}.
   * <ul>
   *   <li>Then builder build flowExtId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowKey)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowKey); then builder build flowExtId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowKey)"})
  void testBuilderFrom_thenBuilderBuildFlowExtIdIsNull() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowKey.builder();
    PhysicalFlowKey instance = mock(PhysicalFlowKey.class);
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
    builderResult.from(instance);

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
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowKey)}.
   * <ul>
   *   <li>Then builder build flowName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowKey)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowKey); then builder build flowName is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowKey)"})
  void testBuilderFrom_thenBuilderBuildFlowNameIsNull() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowKey.builder();
    PhysicalFlowKey instance = mock(PhysicalFlowKey.class);
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
    builderResult.from(instance);

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
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowKey)}.
   * <ul>
   *   <li>Then builder build specDescription is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowKey)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowKey); then builder build specDescription is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowKey)"})
  void testBuilderFrom_thenBuilderBuildSpecDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowKey.builder();
    PhysicalFlowKey instance = mock(PhysicalFlowKey.class);
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
    builderResult.from(instance);

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
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowKey)}.
   * <ul>
   *   <li>Then builder build specExtId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowKey)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowKey); then builder build specExtId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowKey)"})
  void testBuilderFrom_thenBuilderBuildSpecExtIdIsNull() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowKey.builder();
    PhysicalFlowKey instance = mock(PhysicalFlowKey.class);
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
    builderResult.from(instance);

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
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowKey)}.
   * <ul>
   *   <li>Then builder build specName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowKey)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowKey); then builder build specName is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowKey)"})
  void testBuilderFrom_thenBuilderBuildSpecNameIsNull() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowKey.builder();
    PhysicalFlowKey instance = mock(PhysicalFlowKey.class);
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
    builderResult.from(instance);

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
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowKey)}.
   * <ul>
   *   <li>Then builder build transport is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowKey)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowKey); then builder build transport is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowKey)"})
  void testBuilderFrom_thenBuilderBuildTransportIsNull() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowKey.builder();
    PhysicalFlowKey instance = mock(PhysicalFlowKey.class);
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
    builderResult.from(instance);

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
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowKey)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowKey)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowKey); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowKey)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowKey.builder();
    PhysicalFlowKey instance = mock(PhysicalFlowKey.class);
    when(instance.lfId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lfId();
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
    Builder builderResult = ImmutablePhysicalFlowKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lfId(1L));
  }

  /**
   * Test Builder {@link Builder#pfId(long)}.
   * <p>
   * Method under test: {@link Builder#pfId(long)}
   */
  @Test
  @DisplayName("Test Builder pfId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.pfId(long)"})
  void testBuilderPfId() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.pfId(1L));
  }
}
