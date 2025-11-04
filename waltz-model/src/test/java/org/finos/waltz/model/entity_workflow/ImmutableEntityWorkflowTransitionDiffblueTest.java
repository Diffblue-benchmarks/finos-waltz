package org.finos.waltz.model.entity_workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableEntityWorkflowTransitionDiffblueTest {
  /**
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
  void testBuilder() {
    // Arrange and Act
    ImmutableEntityWorkflowTransition.Builder actualFromStateResult = ImmutableEntityWorkflowTransition.builder()
        .fromState("jane.doe@example.org");
    ImmutableEntityWorkflowTransition.Builder actualProvenanceResult = actualFromStateResult
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
        .provenance("Provenance");

    // Assert
    assertSame(actualProvenanceResult, actualProvenanceResult.reason("Just cause"));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowTransition.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableEntityWorkflowTransition.Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowTransition.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntityWorkflowTransition.Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableEntityWorkflowTransition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowTransition.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntityWorkflowTransition.Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowTransition.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableEntityWorkflowTransition.Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntityWorkflowTransition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowTransition.Builder#from(EntityWorkflowTransition)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableEntityWorkflowTransition.Builder builderResult = ImmutableEntityWorkflowTransition.builder();
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
   * Method under test:
   * {@link ImmutableEntityWorkflowTransition.Builder#from(EntityWorkflowTransition)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableEntityWorkflowTransition.Builder builderResult = ImmutableEntityWorkflowTransition.builder();
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
   * Method under test:
   * {@link ImmutableEntityWorkflowTransition.Builder#from(EntityWorkflowTransition)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableEntityWorkflowTransition.Builder builderResult = ImmutableEntityWorkflowTransition.builder();
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
   * Method under test:
   * {@link ImmutableEntityWorkflowTransition.Builder#from(EntityWorkflowTransition)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableEntityWorkflowTransition.Builder builderResult = ImmutableEntityWorkflowTransition.builder();
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
    ImmutableEntityWorkflowTransition.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableEntityWorkflowTransition.Builder#from(EntityWorkflowTransition)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableEntityWorkflowTransition.Builder builderResult = ImmutableEntityWorkflowTransition.builder();
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
   * Method under test:
   * {@link ImmutableEntityWorkflowTransition.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableEntityWorkflowTransition.Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowTransition.Builder#toState(String)}
   */
  @Test
  void testBuilderToState() {
    // Arrange
    ImmutableEntityWorkflowTransition.Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.toState("To State"));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowTransition.Builder#workflowId(long)}
   */
  @Test
  void testBuilderWorkflowId() {
    // Arrange
    ImmutableEntityWorkflowTransition.Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.workflowId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowTransition#copyOf(EntityWorkflowTransition)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EntityWorkflowTransition instance = mock(EntityWorkflowTransition.class);
    when(instance.workflowId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.fromState()).thenReturn("jane.doe@example.org");
    when(instance.reason()).thenReturn("Just cause");
    when(instance.toState()).thenReturn("MD");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntityWorkflowTransition actualCopyOfResult = ImmutableEntityWorkflowTransition.copyOf(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).fromState();
    verify(instance).reason();
    verify(instance).toState();
    verify(instance).workflowId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Just cause", actualCopyOfResult.reason());
    assertEquals("MD", actualCopyOfResult.toState());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("jane.doe@example.org", actualCopyOfResult.fromState());
    assertEquals(1L, actualCopyOfResult.workflowId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowTransition#copyOf(EntityWorkflowTransition)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    EntityWorkflowTransition instance = mock(EntityWorkflowTransition.class);
    when(instance.workflowId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.fromState()).thenReturn(null);
    when(instance.reason()).thenReturn("Just cause");
    when(instance.toState()).thenReturn("MD");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntityWorkflowTransition actualCopyOfResult = ImmutableEntityWorkflowTransition.copyOf(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).fromState();
    verify(instance).reason();
    verify(instance).toState();
    verify(instance).workflowId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Just cause", actualCopyOfResult.reason());
    assertEquals("MD", actualCopyOfResult.toState());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.fromState());
    assertEquals(1L, actualCopyOfResult.workflowId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowTransition#copyOf(EntityWorkflowTransition)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    EntityWorkflowTransition instance = mock(EntityWorkflowTransition.class);
    when(instance.workflowId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.fromState()).thenReturn("jane.doe@example.org");
    when(instance.reason()).thenReturn(null);
    when(instance.toState()).thenReturn("MD");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntityWorkflowTransition actualCopyOfResult = ImmutableEntityWorkflowTransition.copyOf(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).fromState();
    verify(instance).reason();
    verify(instance).toState();
    verify(instance).workflowId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("MD", actualCopyOfResult.toState());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("jane.doe@example.org", actualCopyOfResult.fromState());
    assertNull(actualCopyOfResult.reason());
    assertEquals(1L, actualCopyOfResult.workflowId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowTransition.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityWorkflowTransition.Json()).entityReference());
  }

  /**
   * Method under test: {@link ImmutableEntityWorkflowTransition.Json#fromState()}
   */
  @Test
  void testJsonFromState() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityWorkflowTransition.Json()).fromState());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableEntityWorkflowTransition.Json}
   *   <li>
   * {@link ImmutableEntityWorkflowTransition.Json#setEntityReference(EntityReference)}
   *   <li>{@link ImmutableEntityWorkflowTransition.Json#setFromState(String)}
   *   <li>
   * {@link ImmutableEntityWorkflowTransition.Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableEntityWorkflowTransition.Json#setLastUpdatedBy(String)}
   *   <li>{@link ImmutableEntityWorkflowTransition.Json#setProvenance(String)}
   *   <li>{@link ImmutableEntityWorkflowTransition.Json#setReason(String)}
   *   <li>{@link ImmutableEntityWorkflowTransition.Json#setToState(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableEntityWorkflowTransition.Json actualJson = new ImmutableEntityWorkflowTransition.Json();
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
   * Method under test:
   * {@link ImmutableEntityWorkflowTransition.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityWorkflowTransition.Json()).lastUpdatedAt());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowTransition.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityWorkflowTransition.Json()).lastUpdatedBy());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowTransition.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityWorkflowTransition.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableEntityWorkflowTransition.Json#reason()}
   */
  @Test
  void testJsonReason() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityWorkflowTransition.Json()).reason());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowTransition.Json#setWorkflowId(long)}
   */
  @Test
  void testJsonSetWorkflowId() {
    // Arrange
    ImmutableEntityWorkflowTransition.Json json = new ImmutableEntityWorkflowTransition.Json();

    // Act
    json.setWorkflowId(1L);

    // Assert
    assertEquals(1L, json.workflowId);
    assertTrue(json.workflowIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowTransition.Json#setWorkflowId(long)}
   */
  @Test
  void testJsonSetWorkflowId2() {
    // Arrange
    ImmutableEntityWorkflowTransition.Json json = new ImmutableEntityWorkflowTransition.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setWorkflowId(1L);

    // Assert
    assertEquals(1L, json.workflowId);
    assertTrue(json.workflowIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableEntityWorkflowTransition.Json#toState()}
   */
  @Test
  void testJsonToState() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityWorkflowTransition.Json()).toState());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowTransition.Json#workflowId()}
   */
  @Test
  void testJsonWorkflowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityWorkflowTransition.Json()).workflowId());
  }
}
