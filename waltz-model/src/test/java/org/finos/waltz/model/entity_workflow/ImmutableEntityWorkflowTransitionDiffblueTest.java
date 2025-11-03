package org.finos.waltz.model.entity_workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.entity_workflow.ImmutableEntityWorkflowTransition.Builder;
import org.finos.waltz.model.entity_workflow.ImmutableEntityWorkflowTransition.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityWorkflowTransitionDiffblueTest {
  /**
   * Test {@link ImmutableEntityWorkflowTransition#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableEntityWorkflowTransition#builder()}
   *   <li>{@link ImmutableEntityWorkflowTransition#fromState(String)}
   *   <li>{@link ImmutableEntityWorkflowTransition#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableEntityWorkflowTransition#provenance(String)}
   *   <li>{@link ImmutableEntityWorkflowTransition#reason(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableEntityWorkflowTransition Builder.build()", "Builder Builder.fromState(String)",
      "Builder Builder.lastUpdatedAt(LocalDateTime)", "Builder Builder.provenance(String)",
      "Builder Builder.reason(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualFromStateResult = ImmutableEntityWorkflowTransition.builder().fromState("jane.doe@example.org");
    Builder actualProvenanceResult = actualFromStateResult.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
        .provenance("Provenance");

    // Assert
    assertSame(actualProvenanceResult, actualProvenanceResult.reason("Just cause"));
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(EntityWorkflowTransition)} with {@code EntityWorkflowTransition}.
   * <p>
   * Method under test: {@link Builder#from(EntityWorkflowTransition)}
   */
  @Test
  @DisplayName("Test Builder from(EntityWorkflowTransition) with 'EntityWorkflowTransition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityWorkflowTransition)"})
  void testBuilderFromWithEntityWorkflowTransition() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    EntityWorkflowTransition instance = mock(EntityWorkflowTransition.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.fromState()).thenReturn(null);
    when(instance.reason()).thenReturn("Just cause");
    when(instance.toState()).thenReturn("MD");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).fromState();
    verify(instance).reason();
    verify(instance).toState();
  }

  /**
   * Test Builder {@link Builder#from(EntityWorkflowTransition)} with {@code EntityWorkflowTransition}.
   * <p>
   * Method under test: {@link Builder#from(EntityWorkflowTransition)}
   */
  @Test
  @DisplayName("Test Builder from(EntityWorkflowTransition) with 'EntityWorkflowTransition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityWorkflowTransition)"})
  void testBuilderFromWithEntityWorkflowTransition2() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    EntityWorkflowTransition instance = mock(EntityWorkflowTransition.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.fromState()).thenReturn("jane.doe@example.org");
    when(instance.reason()).thenReturn(null);
    when(instance.toState()).thenReturn("MD");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).fromState();
    verify(instance).reason();
    verify(instance).toState();
  }

  /**
   * Test Builder {@link Builder#from(EntityWorkflowTransition)} with {@code EntityWorkflowTransition}.
   * <p>
   * Method under test: {@link Builder#from(EntityWorkflowTransition)}
   */
  @Test
  @DisplayName("Test Builder from(EntityWorkflowTransition) with 'EntityWorkflowTransition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityWorkflowTransition)"})
  void testBuilderFromWithEntityWorkflowTransition3() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    EntityWorkflowTransition instance = mock(EntityWorkflowTransition.class);
    when(instance.workflowId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.fromState()).thenReturn("jane.doe@example.org");
    when(instance.reason()).thenReturn("Just cause");
    when(instance.toState()).thenReturn("MD");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).fromState();
    verify(instance).reason();
    verify(instance).toState();
    verify(instance).workflowId();
    ImmutableEntityWorkflowTransition buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Just cause", buildResult.reason());
    assertEquals("MD", buildResult.toState());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("jane.doe@example.org", buildResult.fromState());
    assertEquals(1L, buildResult.workflowId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityWorkflowTransition)} with {@code EntityWorkflowTransition}.
   * <p>
   * Method under test: {@link Builder#from(EntityWorkflowTransition)}
   */
  @Test
  @DisplayName("Test Builder from(EntityWorkflowTransition) with 'EntityWorkflowTransition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityWorkflowTransition)"})
  void testBuilderFromWithEntityWorkflowTransition4() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    EntityWorkflowTransition instance = mock(EntityWorkflowTransition.class);
    when(instance.workflowId()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.fromState()).thenReturn("jane.doe@example.org");
    when(instance.reason()).thenReturn("Just cause");
    when(instance.toState()).thenReturn("MD");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).fromState();
    verify(instance).reason();
    verify(instance).toState();
    verify(instance).workflowId();
  }

  /**
   * Test Builder {@link Builder#from(EntityWorkflowTransition)} with {@code EntityWorkflowTransition}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityWorkflowTransition)}
   */
  @Test
  @DisplayName("Test Builder from(EntityWorkflowTransition) with 'EntityWorkflowTransition'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityWorkflowTransition)"})
  void testBuilderFromWithEntityWorkflowTransition_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    EntityWorkflowTransition instance = mock(EntityWorkflowTransition.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.fromState()).thenReturn("jane.doe@example.org");
    when(instance.reason()).thenReturn("Just cause");
    when(instance.toState()).thenReturn("MD");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).fromState();
    verify(instance).reason();
    verify(instance).toState();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   * <ul>
   *   <li>Given {@code Provenance}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'; given 'Provenance'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider_givenProvenance_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#lastUpdatedBy(String)}.
   * <p>
   * Method under test: {@link Builder#lastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test Builder lastUpdatedBy(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lastUpdatedBy(String)"})
  void testBuilderLastUpdatedBy() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Test Builder {@link Builder#toState(String)}.
   * <p>
   * Method under test: {@link Builder#toState(String)}
   */
  @Test
  @DisplayName("Test Builder toState(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.toState(String)"})
  void testBuilderToState() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.toState("To State"));
  }

  /**
   * Test Builder {@link Builder#workflowId(long)}.
   * <p>
   * Method under test: {@link Builder#workflowId(long)}
   */
  @Test
  @DisplayName("Test Builder workflowId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.workflowId(long)"})
  void testBuilderWorkflowId() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.workflowId(1L));
  }

  /**
   * Test Json {@link Json#entityReference()}.
   * <p>
   * Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityReference());
  }

  /**
   * Test Json {@link Json#fromState()}.
   * <p>
   * Method under test: {@link Json#fromState()}
   */
  @Test
  @DisplayName("Test Json fromState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.fromState()"})
  void testJsonFromState() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).fromState());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setEntityReference(EntityReference)}
   *   <li>{@link Json#setFromState(String)}
   *   <li>{@link Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>{@link Json#setLastUpdatedBy(String)}
   *   <li>{@link Json#setProvenance(String)}
   *   <li>{@link Json#setReason(String)}
   *   <li>{@link Json#setToState(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setEntityReference(EntityReference)",
      "void Json.setFromState(String)", "void Json.setLastUpdatedAt(LocalDateTime)",
      "void Json.setLastUpdatedBy(String)", "void Json.setProvenance(String)", "void Json.setReason(String)",
      "void Json.setToState(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setEntityReference(null);
    actualJson.setFromState("jane.doe@example.org");
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult.atStartOfDay());
    actualJson.setLastUpdatedBy("2020-03-01");
    actualJson.setProvenance("Provenance");
    actualJson.setReason("Just cause");
    actualJson.setToState("To State");

    // Assert
    LocalDateTime localDateTime = actualJson.lastUpdatedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test Json {@link Json#lastUpdatedAt()}.
   * <p>
   * Method under test: {@link Json#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedAt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime Json.lastUpdatedAt()"})
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastUpdatedAt());
  }

  /**
   * Test Json {@link Json#lastUpdatedBy()}.
   * <p>
   * Method under test: {@link Json#lastUpdatedBy()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedBy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.lastUpdatedBy()"})
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastUpdatedBy());
  }

  /**
   * Test Json {@link Json#provenance()}.
   * <p>
   * Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).provenance());
  }

  /**
   * Test Json {@link Json#reason()}.
   * <p>
   * Method under test: {@link Json#reason()}
   */
  @Test
  @DisplayName("Test Json reason()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.reason()"})
  void testJsonReason() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).reason());
  }

  /**
   * Test Json {@link Json#setWorkflowId(long)}.
   * <p>
   * Method under test: {@link Json#setWorkflowId(long)}
   */
  @Test
  @DisplayName("Test Json setWorkflowId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setWorkflowId(long)"})
  void testJsonSetWorkflowId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setWorkflowId(1L);

    // Assert
    assertEquals(1L, json.workflowId);
    assertTrue(json.workflowIdIsSet);
  }

  /**
   * Test Json {@link Json#toState()}.
   * <p>
   * Method under test: {@link Json#toState()}
   */
  @Test
  @DisplayName("Test Json toState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.toState()"})
  void testJsonToState() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).toState());
  }

  /**
   * Test Json {@link Json#workflowId()}.
   * <p>
   * Method under test: {@link Json#workflowId()}
   */
  @Test
  @DisplayName("Test Json workflowId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.workflowId()"})
  void testJsonWorkflowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).workflowId());
  }
}
