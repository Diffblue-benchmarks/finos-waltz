package org.finos.waltz.model.entity_enum;

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

class ImmutableEntityEnumValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableEntityEnumValue#builder()}
   *   <li>{@link ImmutableEntityEnumValue#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableEntityEnumValue#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableEntityEnumValue.Builder actualBuilderResult = ImmutableEntityEnumValue.builder();
    ImmutableEntityEnumValue.Builder actualLastUpdatedAtResult = actualBuilderResult
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumValue.Builder#definitionId(long)}
   */
  @Test
  void testBuilderDefinitionId() {
    // Arrange
    ImmutableEntityEnumValue.Builder builderResult = ImmutableEntityEnumValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.definitionId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumValue.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableEntityEnumValue.Builder builderResult = ImmutableEntityEnumValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumValue.Builder#enumValueKey(String)}
   */
  @Test
  void testBuilderEnumValueKey() {
    // Arrange
    ImmutableEntityEnumValue.Builder builderResult = ImmutableEntityEnumValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.enumValueKey("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumValue.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntityEnumValue.Builder builderResult = ImmutableEntityEnumValue.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableEntityEnumValue.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumValue.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntityEnumValue.Builder builderResult = ImmutableEntityEnumValue.builder();
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
   * {@link ImmutableEntityEnumValue.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableEntityEnumValue.Builder builderResult = ImmutableEntityEnumValue.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntityEnumValue.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumValue.Builder#from(EntityEnumValue)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableEntityEnumValue.Builder builderResult = ImmutableEntityEnumValue.builder();
    EntityEnumValue instance = mock(EntityEnumValue.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.enumValueKey()).thenReturn("42");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).enumValueKey();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumValue.Builder#from(EntityEnumValue)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableEntityEnumValue.Builder builderResult = ImmutableEntityEnumValue.builder();
    EntityEnumValue instance = mock(EntityEnumValue.class);
    when(instance.definitionId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.enumValueKey()).thenReturn("42");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntityEnumValue.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).definitionId();
    verify(instance).entityReference();
    verify(instance).enumValueKey();
    ImmutableEntityEnumValue buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("42", buildResult.enumValueKey());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1L, buildResult.definitionId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumValue.Builder#from(EntityEnumValue)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableEntityEnumValue.Builder builderResult = ImmutableEntityEnumValue.builder();
    EntityEnumValue instance = mock(EntityEnumValue.class);
    when(instance.definitionId()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.enumValueKey()).thenReturn("42");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).definitionId();
    verify(instance).entityReference();
    verify(instance).enumValueKey();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumValue.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableEntityEnumValue.Builder builderResult = ImmutableEntityEnumValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableEntityEnumValue#copyOf(EntityEnumValue)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EntityEnumValue instance = mock(EntityEnumValue.class);
    when(instance.definitionId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.enumValueKey()).thenReturn("42");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntityEnumValue actualCopyOfResult = ImmutableEntityEnumValue.copyOf(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).definitionId();
    verify(instance).entityReference();
    verify(instance).enumValueKey();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("42", actualCopyOfResult.enumValueKey());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.definitionId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableEntityEnumValue.Json#definitionId()}
   */
  @Test
  void testJsonDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityEnumValue.Json()).definitionId());
  }

  /**
   * Method under test: {@link ImmutableEntityEnumValue.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityEnumValue.Json()).entityReference());
  }

  /**
   * Method under test: {@link ImmutableEntityEnumValue.Json#enumValueKey()}
   */
  @Test
  void testJsonEnumValueKey() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityEnumValue.Json()).enumValueKey());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableEntityEnumValue.Json}
   *   <li>{@link ImmutableEntityEnumValue.Json#setEntityReference(EntityReference)}
   *   <li>{@link ImmutableEntityEnumValue.Json#setEnumValueKey(String)}
   *   <li>{@link ImmutableEntityEnumValue.Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableEntityEnumValue.Json#setLastUpdatedBy(String)}
   *   <li>{@link ImmutableEntityEnumValue.Json#setProvenance(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableEntityEnumValue.Json actualJson = new ImmutableEntityEnumValue.Json();
    actualJson.setEntityReference(null);
    actualJson.setEnumValueKey("42");
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult.atStartOfDay());
    actualJson.setLastUpdatedBy("2020-03-01");
    actualJson.setProvenance("Provenance");

    // Assert
    LocalDateTime localDateTime = actualJson.lastUpdatedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableEntityEnumValue.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityEnumValue.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableEntityEnumValue.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityEnumValue.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableEntityEnumValue.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityEnumValue.Json()).provenance());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumValue.Json#setDefinitionId(long)}
   */
  @Test
  void testJsonSetDefinitionId() {
    // Arrange
    ImmutableEntityEnumValue.Json json = new ImmutableEntityEnumValue.Json();

    // Act
    json.setDefinitionId(1L);

    // Assert
    assertEquals(1L, json.definitionId);
    assertTrue(json.definitionIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumValue.Json#setDefinitionId(long)}
   */
  @Test
  void testJsonSetDefinitionId2() {
    // Arrange
    ImmutableEntityEnumValue.Json json = new ImmutableEntityEnumValue.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setDefinitionId(1L);

    // Assert
    assertEquals(1L, json.definitionId);
    assertTrue(json.definitionIdIsSet);
  }
}
