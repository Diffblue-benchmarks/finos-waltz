package org.finos.waltz.model.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableBackingEntityDiffblueTest {
  /**
   * Method under test: {@link ImmutableBackingEntity.Builder#cellId(String)}
   */
  @Test
  void testBuilderCellId() {
    // Arrange
    ImmutableBackingEntity.Builder builderResult = ImmutableBackingEntity.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.cellId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntity.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableBackingEntity.Builder builderResult = ImmutableBackingEntity.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test: {@link ImmutableBackingEntity.Builder#from(BackingEntity)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBackingEntity.Builder builderResult = ImmutableBackingEntity.builder();
    BackingEntity instance = mock(BackingEntity.class);
    when(instance.cellId()).thenReturn("42");
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableBackingEntity.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellId();
    verify(instance).entityReference();
    assertEquals("42", actualFromResult.build().cellId());
    assertEquals("42", builderResult.build().cellId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableBackingEntity.Builder#from(BackingEntity)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableBackingEntity.Builder builderResult = ImmutableBackingEntity.builder();
    BackingEntity instance = mock(BackingEntity.class);
    when(instance.cellId()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).cellId();
    verify(instance).entityReference();
  }

  /**
   * Method under test: {@link ImmutableBackingEntity#copyOf(BackingEntity)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BackingEntity instance = mock(BackingEntity.class);
    when(instance.cellId()).thenReturn("42");
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableBackingEntity actualCopyOfResult = ImmutableBackingEntity.copyOf(instance);

    // Assert
    verify(instance).cellId();
    verify(instance).entityReference();
    assertEquals("42", actualCopyOfResult.cellId());
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntity#fromJson(ImmutableBackingEntity.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableBackingEntity.Json json = new ImmutableBackingEntity.Json();
    json.setEntityReference(mock(EntityReference.class));
    json.setCellId("Json");

    // Act
    ImmutableBackingEntity actualFromJsonResult = ImmutableBackingEntity.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellId());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Method under test: {@link ImmutableBackingEntity.Json#cellId()}
   */
  @Test
  void testJsonCellId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBackingEntity.Json()).cellId());
  }

  /**
   * Method under test: {@link ImmutableBackingEntity.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBackingEntity.Json()).entityReference());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableBackingEntity.Json}
   *   <li>{@link ImmutableBackingEntity.Json#setCellId(String)}
   *   <li>{@link ImmutableBackingEntity.Json#setEntityReference(EntityReference)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableBackingEntity.Json actualJson = new ImmutableBackingEntity.Json();
    actualJson.setCellId("42");
    actualJson.setEntityReference(null);

    // Assert
    assertEquals("42", actualJson.cellId);
    assertNull(actualJson.entityReference);
  }
}
