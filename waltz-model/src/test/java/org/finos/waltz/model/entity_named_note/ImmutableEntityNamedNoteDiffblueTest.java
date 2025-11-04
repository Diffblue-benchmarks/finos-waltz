package org.finos.waltz.model.entity_named_note;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

class ImmutableEntityNamedNoteDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableEntityNamedNote#builder()}
   *   <li>{@link ImmutableEntityNamedNote#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableEntityNamedNote#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableEntityNamedNote.Builder actualBuilderResult = ImmutableEntityNamedNote.builder();
    ImmutableEntityNamedNote.Builder actualLastUpdatedAtResult = actualBuilderResult
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNote.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableEntityNamedNote.Builder builderResult = ImmutableEntityNamedNote.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNote.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntityNamedNote.Builder builderResult = ImmutableEntityNamedNote.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableEntityNamedNote.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNote.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntityNamedNote.Builder builderResult = ImmutableEntityNamedNote.builder();
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
   * {@link ImmutableEntityNamedNote.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableEntityNamedNote.Builder builderResult = ImmutableEntityNamedNote.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntityNamedNote.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNote.Builder#from(EntityNamedNote)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableEntityNamedNote.Builder builderResult = ImmutableEntityNamedNote.builder();
    EntityNamedNote instance = mock(EntityNamedNote.class);
    when(instance.namedNoteTypeId()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.noteText()).thenReturn("Note Text");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).namedNoteTypeId();
    verify(instance).noteText();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNote.Builder#from(EntityNamedNote)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableEntityNamedNote.Builder builderResult = ImmutableEntityNamedNote.builder();
    EntityNamedNote instance = mock(EntityNamedNote.class);
    when(instance.namedNoteTypeId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.noteText()).thenReturn("Note Text");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntityNamedNote.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).namedNoteTypeId();
    verify(instance).noteText();
    ImmutableEntityNamedNote buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Note Text", buildResult.noteText());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1L, buildResult.namedNoteTypeId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNote.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableEntityNamedNote.Builder builderResult = ImmutableEntityNamedNote.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNote.Builder#namedNoteTypeId(long)}
   */
  @Test
  void testBuilderNamedNoteTypeId() {
    // Arrange
    ImmutableEntityNamedNote.Builder builderResult = ImmutableEntityNamedNote.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.namedNoteTypeId(1L));
  }

  /**
   * Method under test: {@link ImmutableEntityNamedNote.Builder#noteText(String)}
   */
  @Test
  void testBuilderNoteText() {
    // Arrange
    ImmutableEntityNamedNote.Builder builderResult = ImmutableEntityNamedNote.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.noteText("Note Text"));
  }

  /**
   * Method under test: {@link ImmutableEntityNamedNote#copyOf(EntityNamedNote)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EntityNamedNote instance = mock(EntityNamedNote.class);
    when(instance.namedNoteTypeId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.noteText()).thenReturn("Note Text");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntityNamedNote actualCopyOfResult = ImmutableEntityNamedNote.copyOf(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).namedNoteTypeId();
    verify(instance).noteText();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Note Text", actualCopyOfResult.noteText());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.namedNoteTypeId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableEntityNamedNote.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityNamedNote.Json()).entityReference());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableEntityNamedNote.Json}
   *   <li>{@link ImmutableEntityNamedNote.Json#setEntityReference(EntityReference)}
   *   <li>{@link ImmutableEntityNamedNote.Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableEntityNamedNote.Json#setLastUpdatedBy(String)}
   *   <li>{@link ImmutableEntityNamedNote.Json#setNoteText(String)}
   *   <li>{@link ImmutableEntityNamedNote.Json#setProvenance(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableEntityNamedNote.Json actualJson = new ImmutableEntityNamedNote.Json();
    actualJson.setEntityReference(null);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult.atStartOfDay());
    actualJson.setLastUpdatedBy("2020-03-01");
    actualJson.setNoteText("Note Text");
    actualJson.setProvenance("Provenance");

    // Assert
    LocalDateTime localDateTime = actualJson.lastUpdatedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableEntityNamedNote.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityNamedNote.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableEntityNamedNote.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityNamedNote.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableEntityNamedNote.Json#namedNoteTypeId()}
   */
  @Test
  void testJsonNamedNoteTypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityNamedNote.Json()).namedNoteTypeId());
  }

  /**
   * Method under test: {@link ImmutableEntityNamedNote.Json#noteText()}
   */
  @Test
  void testJsonNoteText() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityNamedNote.Json()).noteText());
  }

  /**
   * Method under test: {@link ImmutableEntityNamedNote.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityNamedNote.Json()).provenance());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNote.Json#setNamedNoteTypeId(long)}
   */
  @Test
  void testJsonSetNamedNoteTypeId() {
    // Arrange
    ImmutableEntityNamedNote.Json json = new ImmutableEntityNamedNote.Json();

    // Act
    json.setNamedNoteTypeId(1L);

    // Assert
    assertEquals(1L, json.namedNoteTypeId);
    assertTrue(json.namedNoteTypeIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNote.Json#setNamedNoteTypeId(long)}
   */
  @Test
  void testJsonSetNamedNoteTypeId2() {
    // Arrange
    ImmutableEntityNamedNote.Json json = new ImmutableEntityNamedNote.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setNamedNoteTypeId(1L);

    // Assert
    assertEquals(1L, json.namedNoteTypeId);
    assertTrue(json.namedNoteTypeIdIsSet);
  }
}
