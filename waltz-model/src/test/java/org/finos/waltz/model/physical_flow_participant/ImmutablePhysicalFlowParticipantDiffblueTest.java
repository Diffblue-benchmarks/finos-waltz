package org.finos.waltz.model.physical_flow_participant;

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

class ImmutablePhysicalFlowParticipantDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowParticipant#builder()}
   *   <li>{@link ImmutablePhysicalFlowParticipant#description(String)}
   *   <li>{@link ImmutablePhysicalFlowParticipant#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutablePhysicalFlowParticipant#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutablePhysicalFlowParticipant.Builder actualDescriptionResult = ImmutablePhysicalFlowParticipant.builder()
        .description("The characteristics of someone or something");
    ImmutablePhysicalFlowParticipant.Builder actualLastUpdatedAtResult = actualDescriptionResult
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParticipant.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePhysicalFlowParticipant.Builder builderResult = ImmutablePhysicalFlowParticipant.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutablePhysicalFlowParticipant.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParticipant.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutablePhysicalFlowParticipant.Builder builderResult = ImmutablePhysicalFlowParticipant.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutablePhysicalFlowParticipant.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParticipant.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutablePhysicalFlowParticipant.Builder builderResult = ImmutablePhysicalFlowParticipant.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutablePhysicalFlowParticipant.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParticipant.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutablePhysicalFlowParticipant.Builder builderResult = ImmutablePhysicalFlowParticipant.builder();
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
   * {@link ImmutablePhysicalFlowParticipant.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutablePhysicalFlowParticipant.Builder builderResult = ImmutablePhysicalFlowParticipant.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalFlowParticipant.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParticipant.Builder#from(PhysicalFlowParticipant)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutablePhysicalFlowParticipant.Builder builderResult = ImmutablePhysicalFlowParticipant.builder();
    PhysicalFlowParticipant instance = mock(PhysicalFlowParticipant.class);
    when(instance.physicalFlowId()).thenThrow(new IllegalStateException("instance"));
    when(instance.kind()).thenReturn(ParticipationKind.SOURCE);
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
    verify(instance).kind();
    verify(instance).physicalFlowId();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParticipant.Builder#from(PhysicalFlowParticipant)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutablePhysicalFlowParticipant.Builder builderResult = ImmutablePhysicalFlowParticipant.builder();
    PhysicalFlowParticipant instance = mock(PhysicalFlowParticipant.class);
    when(instance.physicalFlowId()).thenThrow(new IllegalStateException("instance"));
    when(instance.kind()).thenReturn(ParticipationKind.SOURCE);
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
    verify(instance).kind();
    verify(instance).physicalFlowId();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParticipant.Builder#from(PhysicalFlowParticipant)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutablePhysicalFlowParticipant.Builder builderResult = ImmutablePhysicalFlowParticipant.builder();
    PhysicalFlowParticipant instance = mock(PhysicalFlowParticipant.class);
    when(instance.physicalFlowId()).thenReturn(1L);
    when(instance.participant()).thenReturn(mock(EntityReference.class));
    when(instance.kind()).thenReturn(ParticipationKind.SOURCE);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalFlowParticipant.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).participant();
    verify(instance).physicalFlowId();
    ImmutablePhysicalFlowParticipant buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.physicalFlowId());
    assertEquals(ParticipationKind.SOURCE, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParticipant.Builder#kind(ParticipationKind)}
   */
  @Test
  void testBuilderKind() {
    // Arrange
    ImmutablePhysicalFlowParticipant.Builder builderResult = ImmutablePhysicalFlowParticipant.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.kind(ParticipationKind.SOURCE));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParticipant.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutablePhysicalFlowParticipant.Builder builderResult = ImmutablePhysicalFlowParticipant.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParticipant.Builder#participant(EntityReference)}
   */
  @Test
  void testBuilderParticipant() {
    // Arrange
    ImmutablePhysicalFlowParticipant.Builder builderResult = ImmutablePhysicalFlowParticipant.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.participant(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParticipant.Builder#physicalFlowId(long)}
   */
  @Test
  void testBuilderPhysicalFlowId() {
    // Arrange
    ImmutablePhysicalFlowParticipant.Builder builderResult = ImmutablePhysicalFlowParticipant.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.physicalFlowId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParticipant#copyOf(PhysicalFlowParticipant)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    PhysicalFlowParticipant instance = mock(PhysicalFlowParticipant.class);
    when(instance.physicalFlowId()).thenReturn(1L);
    when(instance.participant()).thenReturn(mock(EntityReference.class));
    when(instance.kind()).thenReturn(ParticipationKind.SOURCE);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalFlowParticipant actualCopyOfResult = ImmutablePhysicalFlowParticipant.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).participant();
    verify(instance).physicalFlowId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.physicalFlowId());
    assertEquals(ParticipationKind.SOURCE, actualCopyOfResult.kind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParticipant#copyOf(PhysicalFlowParticipant)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    PhysicalFlowParticipant instance = mock(PhysicalFlowParticipant.class);
    when(instance.physicalFlowId()).thenReturn(1L);
    when(instance.participant()).thenReturn(mock(EntityReference.class));
    when(instance.kind()).thenReturn(ParticipationKind.SOURCE);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalFlowParticipant actualCopyOfResult = ImmutablePhysicalFlowParticipant.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).participant();
    verify(instance).physicalFlowId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.physicalFlowId());
    assertEquals(ParticipationKind.SOURCE, actualCopyOfResult.kind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParticipant.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowParticipant.Json()).description());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutablePhysicalFlowParticipant.Json}
   *   <li>{@link ImmutablePhysicalFlowParticipant.Json#setDescription(String)}
   *   <li>{@link ImmutablePhysicalFlowParticipant.Json#setKind(ParticipationKind)}
   *   <li>
   * {@link ImmutablePhysicalFlowParticipant.Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutablePhysicalFlowParticipant.Json#setLastUpdatedBy(String)}
   *   <li>
   * {@link ImmutablePhysicalFlowParticipant.Json#setParticipant(EntityReference)}
   *   <li>{@link ImmutablePhysicalFlowParticipant.Json#setProvenance(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutablePhysicalFlowParticipant.Json actualJson = new ImmutablePhysicalFlowParticipant.Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setKind(ParticipationKind.SOURCE);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult.atStartOfDay());
    actualJson.setLastUpdatedBy("2020-03-01");
    actualJson.setParticipant(null);
    actualJson.setProvenance("Provenance");

    // Assert
    LocalDateTime localDateTime = actualJson.lastUpdatedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowParticipant.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowParticipant.Json()).kind());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParticipant.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowParticipant.Json()).lastUpdatedAt());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParticipant.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowParticipant.Json()).lastUpdatedBy());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParticipant.Json#participant()}
   */
  @Test
  void testJsonParticipant() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowParticipant.Json()).participant());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParticipant.Json#physicalFlowId()}
   */
  @Test
  void testJsonPhysicalFlowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowParticipant.Json()).physicalFlowId());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowParticipant.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowParticipant.Json()).provenance());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParticipant.Json#setPhysicalFlowId(long)}
   */
  @Test
  void testJsonSetPhysicalFlowId() {
    // Arrange
    ImmutablePhysicalFlowParticipant.Json json = new ImmutablePhysicalFlowParticipant.Json();

    // Act
    json.setPhysicalFlowId(1L);

    // Assert
    assertEquals(1L, json.physicalFlowId);
    assertTrue(json.physicalFlowIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParticipant.Json#setPhysicalFlowId(long)}
   */
  @Test
  void testJsonSetPhysicalFlowId2() {
    // Arrange
    ImmutablePhysicalFlowParticipant.Json json = new ImmutablePhysicalFlowParticipant.Json();
    json.setParticipant(mock(EntityReference.class));

    // Act
    json.setPhysicalFlowId(1L);

    // Assert
    assertEquals(1L, json.physicalFlowId);
    assertTrue(json.physicalFlowIdIsSet);
  }
}
