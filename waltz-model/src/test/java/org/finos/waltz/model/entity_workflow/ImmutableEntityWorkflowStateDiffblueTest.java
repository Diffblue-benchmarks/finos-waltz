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
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableEntityWorkflowStateDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableEntityWorkflowState#builder()}
   *   <li>{@link ImmutableEntityWorkflowState#description(String)}
   *   <li>{@link ImmutableEntityWorkflowState#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableEntityWorkflowState#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableEntityWorkflowState.Builder actualDescriptionResult = ImmutableEntityWorkflowState.builder()
        .description("The characteristics of someone or something");
    ImmutableEntityWorkflowState.Builder actualLastUpdatedAtResult = actualDescriptionResult
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowState.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableEntityWorkflowState.Builder builderResult = ImmutableEntityWorkflowState.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowState.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntityWorkflowState.Builder builderResult = ImmutableEntityWorkflowState.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableEntityWorkflowState.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowState.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntityWorkflowState.Builder builderResult = ImmutableEntityWorkflowState.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableEntityWorkflowState.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowState.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableEntityWorkflowState.Builder builderResult = ImmutableEntityWorkflowState.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableEntityWorkflowState.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowState.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableEntityWorkflowState.Builder builderResult = ImmutableEntityWorkflowState.builder();
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
   * {@link ImmutableEntityWorkflowState.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableEntityWorkflowState.Builder builderResult = ImmutableEntityWorkflowState.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntityWorkflowState.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowState.Builder#from(EntityWorkflowState)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableEntityWorkflowState.Builder builderResult = ImmutableEntityWorkflowState.builder();
    EntityWorkflowState instance = mock(EntityWorkflowState.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowState.Builder#from(EntityWorkflowState)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableEntityWorkflowState.Builder builderResult = ImmutableEntityWorkflowState.builder();
    EntityWorkflowState instance = mock(EntityWorkflowState.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowState.Builder#from(EntityWorkflowState)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableEntityWorkflowState.Builder builderResult = ImmutableEntityWorkflowState.builder();
    EntityWorkflowState instance = mock(EntityWorkflowState.class);
    when(instance.workflowId()).thenReturn(1L);
    when(instance.state()).thenReturn("MD");
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntityWorkflowState.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).state();
    verify(instance).workflowId();
    ImmutableEntityWorkflowState buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("MD", buildResult.state());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.workflowId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowState.Builder#from(EntityWorkflowState)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableEntityWorkflowState.Builder builderResult = ImmutableEntityWorkflowState.builder();
    EntityWorkflowState instance = mock(EntityWorkflowState.class);
    when(instance.workflowId()).thenThrow(new IllegalStateException("instance"));
    when(instance.state()).thenReturn("MD");
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).state();
    verify(instance).workflowId();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowState.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableEntityWorkflowState.Builder builderResult = ImmutableEntityWorkflowState.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableEntityWorkflowState.Builder#state(String)}
   */
  @Test
  void testBuilderState() {
    // Arrange
    ImmutableEntityWorkflowState.Builder builderResult = ImmutableEntityWorkflowState.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.state("MD"));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowState.Builder#workflowId(long)}
   */
  @Test
  void testBuilderWorkflowId() {
    // Arrange
    ImmutableEntityWorkflowState.Builder builderResult = ImmutableEntityWorkflowState.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.workflowId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowState#copyOf(EntityWorkflowState)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EntityWorkflowState instance = mock(EntityWorkflowState.class);
    when(instance.workflowId()).thenReturn(1L);
    when(instance.state()).thenReturn("MD");
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntityWorkflowState actualCopyOfResult = ImmutableEntityWorkflowState.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).state();
    verify(instance).workflowId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("MD", actualCopyOfResult.state());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.workflowId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowState#copyOf(EntityWorkflowState)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    EntityWorkflowState instance = mock(EntityWorkflowState.class);
    when(instance.workflowId()).thenReturn(1L);
    when(instance.state()).thenReturn("MD");
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntityWorkflowState actualCopyOfResult = ImmutableEntityWorkflowState.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).state();
    verify(instance).workflowId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("MD", actualCopyOfResult.state());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.workflowId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableEntityWorkflowState.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityWorkflowState.Json()).description());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowState.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityWorkflowState.Json()).entityReference());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableEntityWorkflowState.Json}
   *   <li>{@link ImmutableEntityWorkflowState.Json#setDescription(String)}
   *   <li>
   * {@link ImmutableEntityWorkflowState.Json#setEntityReference(EntityReference)}
   *   <li>{@link ImmutableEntityWorkflowState.Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableEntityWorkflowState.Json#setLastUpdatedBy(String)}
   *   <li>{@link ImmutableEntityWorkflowState.Json#setProvenance(String)}
   *   <li>{@link ImmutableEntityWorkflowState.Json#setState(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableEntityWorkflowState.Json actualJson = new ImmutableEntityWorkflowState.Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setEntityReference(null);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult.atStartOfDay());
    actualJson.setLastUpdatedBy("2020-03-01");
    actualJson.setProvenance("Provenance");
    actualJson.setState("MD");

    // Assert
    LocalDateTime localDateTime = actualJson.lastUpdatedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableEntityWorkflowState.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityWorkflowState.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableEntityWorkflowState.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityWorkflowState.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableEntityWorkflowState.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityWorkflowState.Json()).provenance());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowState.Json#setWorkflowId(long)}
   */
  @Test
  void testJsonSetWorkflowId() {
    // Arrange
    ImmutableEntityWorkflowState.Json json = new ImmutableEntityWorkflowState.Json();

    // Act
    json.setWorkflowId(1L);

    // Assert
    assertEquals(1L, json.workflowId);
    assertTrue(json.workflowIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowState.Json#setWorkflowId(long)}
   */
  @Test
  void testJsonSetWorkflowId2() {
    // Arrange
    ImmutableEntityWorkflowState.Json json = new ImmutableEntityWorkflowState.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setWorkflowId(1L);

    // Assert
    assertEquals(1L, json.workflowId);
    assertTrue(json.workflowIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableEntityWorkflowState.Json#state()}
   */
  @Test
  void testJsonState() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityWorkflowState.Json()).state());
  }

  /**
   * Method under test: {@link ImmutableEntityWorkflowState.Json#workflowId()}
   */
  @Test
  void testJsonWorkflowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityWorkflowState.Json()).workflowId());
  }
}
