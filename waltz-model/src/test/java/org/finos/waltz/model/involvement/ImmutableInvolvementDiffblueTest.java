package org.finos.waltz.model.involvement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableInvolvementDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableInvolvement#builder()}
   *   <li>{@link ImmutableInvolvement#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableInvolvement.Builder actualBuilderResult = ImmutableInvolvement.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.provenance("Provenance"));
  }

  /**
   * Method under test: {@link ImmutableInvolvement.Builder#employeeId(String)}
   */
  @Test
  void testBuilderEmployeeId() {
    // Arrange
    ImmutableInvolvement.Builder builderResult = ImmutableInvolvement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.employeeId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvement.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableInvolvement.Builder builderResult = ImmutableInvolvement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvement.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableInvolvement.Builder builderResult = ImmutableInvolvement.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableInvolvement.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableInvolvement.Builder#from(Involvement)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableInvolvement.Builder builderResult = ImmutableInvolvement.builder();
    Involvement instance = mock(Involvement.class);
    when(instance.kindId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.employeeId()).thenReturn("42");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableInvolvement.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).employeeId();
    verify(instance).entityReference();
    verify(instance).isReadOnly();
    verify(instance).kindId();
    verify(instance).provenance();
    ImmutableInvolvement buildResult = builderResult.build();
    assertEquals("42", buildResult.employeeId());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1L, buildResult.kindId());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableInvolvement.Builder#from(Involvement)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableInvolvement.Builder builderResult = ImmutableInvolvement.builder();
    Involvement instance = mock(Involvement.class);
    when(instance.kindId()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.employeeId()).thenReturn("42");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).employeeId();
    verify(instance).entityReference();
    verify(instance).isReadOnly();
    verify(instance).kindId();
    verify(instance).provenance();
  }

  /**
   * Method under test: {@link ImmutableInvolvement.Builder#isReadOnly(boolean)}
   */
  @Test
  void testBuilderIsReadOnly() {
    // Arrange
    ImmutableInvolvement.Builder builderResult = ImmutableInvolvement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isReadOnly(true));
  }

  /**
   * Method under test: {@link ImmutableInvolvement.Builder#kindId(long)}
   */
  @Test
  void testBuilderKindId() {
    // Arrange
    ImmutableInvolvement.Builder builderResult = ImmutableInvolvement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.kindId(1L));
  }

  /**
   * Method under test: {@link ImmutableInvolvement#copyOf(Involvement)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    Involvement instance = mock(Involvement.class);
    when(instance.kindId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.employeeId()).thenReturn("42");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableInvolvement actualCopyOfResult = ImmutableInvolvement.copyOf(instance);

    // Assert
    verify(instance).employeeId();
    verify(instance).entityReference();
    verify(instance).isReadOnly();
    verify(instance).kindId();
    verify(instance).provenance();
    assertEquals("42", actualCopyOfResult.employeeId());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.kindId());
    assertTrue(actualCopyOfResult.isReadOnly());
  }

  /**
   * Method under test: {@link ImmutableInvolvement#copyOf(Involvement)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    Involvement instance = mock(Involvement.class);
    when(instance.kindId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.isReadOnly()).thenReturn(false);
    when(instance.employeeId()).thenReturn("42");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableInvolvement actualCopyOfResult = ImmutableInvolvement.copyOf(instance);

    // Assert
    verify(instance).employeeId();
    verify(instance).entityReference();
    verify(instance).isReadOnly();
    verify(instance).kindId();
    verify(instance).provenance();
    assertEquals("42", actualCopyOfResult.employeeId());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.kindId());
    assertFalse(actualCopyOfResult.isReadOnly());
  }

  /**
   * Method under test: {@link ImmutableInvolvement.Json#employeeId()}
   */
  @Test
  void testJsonEmployeeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvement.Json()).employeeId());
  }

  /**
   * Method under test: {@link ImmutableInvolvement.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvement.Json()).entityReference());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImmutableInvolvement.Json}
   *   <li>{@link ImmutableInvolvement.Json#setEmployeeId(String)}
   *   <li>{@link ImmutableInvolvement.Json#setEntityReference(EntityReference)}
   *   <li>{@link ImmutableInvolvement.Json#setProvenance(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableInvolvement.Json actualJson = new ImmutableInvolvement.Json();
    actualJson.setEmployeeId("42");
    actualJson.setEntityReference(null);
    actualJson.setProvenance("Provenance");

    // Assert
    assertEquals("42", actualJson.employeeId);
    assertEquals("Provenance", actualJson.provenance);
    assertNull(actualJson.entityReference);
    assertEquals(0L, actualJson.kindId);
    assertFalse(actualJson.isReadOnly);
    assertFalse(actualJson.isReadOnlyIsSet);
    assertFalse(actualJson.kindIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableInvolvement.Json#isReadOnly()}
   */
  @Test
  void testJsonIsReadOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvement.Json()).isReadOnly());
  }

  /**
   * Method under test: {@link ImmutableInvolvement.Json#kindId()}
   */
  @Test
  void testJsonKindId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvement.Json()).kindId());
  }

  /**
   * Method under test: {@link ImmutableInvolvement.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvement.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableInvolvement.Json#setIsReadOnly(boolean)}
   */
  @Test
  void testJsonSetIsReadOnly() {
    // Arrange
    ImmutableInvolvement.Json json = new ImmutableInvolvement.Json();

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }

  /**
   * Method under test: {@link ImmutableInvolvement.Json#setIsReadOnly(boolean)}
   */
  @Test
  void testJsonSetIsReadOnly2() {
    // Arrange
    ImmutableInvolvement.Json json = new ImmutableInvolvement.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }

  /**
   * Method under test: {@link ImmutableInvolvement.Json#setKindId(long)}
   */
  @Test
  void testJsonSetKindId() {
    // Arrange
    ImmutableInvolvement.Json json = new ImmutableInvolvement.Json();

    // Act
    json.setKindId(1L);

    // Assert
    assertEquals(1L, json.kindId);
    assertTrue(json.kindIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableInvolvement.Json#setKindId(long)}
   */
  @Test
  void testJsonSetKindId2() {
    // Arrange
    ImmutableInvolvement.Json json = new ImmutableInvolvement.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setKindId(1L);

    // Assert
    assertEquals(1L, json.kindId);
    assertTrue(json.kindIdIsSet);
  }
}
