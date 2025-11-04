package org.finos.waltz.model.measurable_rating;

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
import org.finos.waltz.model.UserTimestamp;
import org.junit.jupiter.api.Test;

class ImmutableRemoveMeasurableRatingCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableRemoveMeasurableRatingCommand.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableRemoveMeasurableRatingCommand.Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveMeasurableRatingCommand.Builder#from(MeasurableRatingCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableRemoveMeasurableRatingCommand.Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();
    MeasurableRatingCommand instance = mock(MeasurableRatingCommand.class);
    when(instance.lastUpdate()).thenThrow(new IllegalStateException("instance"));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReference();
    verify(instance).lastUpdate();
    verify(instance).measurableId();
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveMeasurableRatingCommand.Builder#from(MeasurableRatingCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableRemoveMeasurableRatingCommand.Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();
    MeasurableRatingCommand instance = mock(MeasurableRatingCommand.class);
    when(instance.lastUpdate()).thenReturn(mock(UserTimestamp.class));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableRemoveMeasurableRatingCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).lastUpdate();
    verify(instance).measurableId();
    assertEquals(1L, actualFromResult.build().measurableId());
    assertEquals(1L, builderResult.build().measurableId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveMeasurableRatingCommand.Builder#from(RemoveMeasurableRatingCommand)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableRemoveMeasurableRatingCommand.Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();
    RemoveMeasurableRatingCommand instance = mock(RemoveMeasurableRatingCommand.class);
    when(instance.lastUpdate()).thenThrow(new IllegalStateException("instance"));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReference();
    verify(instance).lastUpdate();
    verify(instance).measurableId();
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveMeasurableRatingCommand.Builder#from(RemoveMeasurableRatingCommand)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableRemoveMeasurableRatingCommand.Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();
    RemoveMeasurableRatingCommand instance = mock(RemoveMeasurableRatingCommand.class);
    when(instance.lastUpdate()).thenReturn(mock(UserTimestamp.class));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableRemoveMeasurableRatingCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).lastUpdate();
    verify(instance).measurableId();
    assertEquals(1L, actualFromResult.build().measurableId());
    assertEquals(1L, builderResult.build().measurableId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveMeasurableRatingCommand.Builder#lastUpdate(UserTimestamp)}
   */
  @Test
  void testBuilderLastUpdate() {
    // Arrange
    ImmutableRemoveMeasurableRatingCommand.Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdate(mock(UserTimestamp.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveMeasurableRatingCommand.Builder#measurableId(long)}
   */
  @Test
  void testBuilderMeasurableId() {
    // Arrange
    ImmutableRemoveMeasurableRatingCommand.Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveMeasurableRatingCommand#copyOf(RemoveMeasurableRatingCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    RemoveMeasurableRatingCommand instance = mock(RemoveMeasurableRatingCommand.class);
    when(instance.lastUpdate()).thenReturn(mock(UserTimestamp.class));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableRemoveMeasurableRatingCommand actualCopyOfResult = ImmutableRemoveMeasurableRatingCommand.copyOf(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).lastUpdate();
    verify(instance).measurableId();
    assertEquals(1L, actualCopyOfResult.measurableId());
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveMeasurableRatingCommand.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableRemoveMeasurableRatingCommand.Json()).entityReference());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableRemoveMeasurableRatingCommand.Json}
   *   <li>
   * {@link ImmutableRemoveMeasurableRatingCommand.Json#setEntityReference(EntityReference)}
   *   <li>
   * {@link ImmutableRemoveMeasurableRatingCommand.Json#setLastUpdate(UserTimestamp)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableRemoveMeasurableRatingCommand.Json actualJson = new ImmutableRemoveMeasurableRatingCommand.Json();
    actualJson.setEntityReference(null);
    actualJson.setLastUpdate(null);

    // Assert
    assertNull(actualJson.entityReference);
    assertNull(actualJson.lastUpdate);
    assertEquals(0L, actualJson.measurableId);
    assertFalse(actualJson.measurableIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveMeasurableRatingCommand.Json#lastUpdate()}
   */
  @Test
  void testJsonLastUpdate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableRemoveMeasurableRatingCommand.Json()).lastUpdate());
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveMeasurableRatingCommand.Json#measurableId()}
   */
  @Test
  void testJsonMeasurableId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableRemoveMeasurableRatingCommand.Json()).measurableId());
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveMeasurableRatingCommand.Json#setMeasurableId(long)}
   */
  @Test
  void testJsonSetMeasurableId() {
    // Arrange
    ImmutableRemoveMeasurableRatingCommand.Json json = new ImmutableRemoveMeasurableRatingCommand.Json();

    // Act
    json.setMeasurableId(1L);

    // Assert
    assertEquals(1L, json.measurableId);
    assertTrue(json.measurableIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveMeasurableRatingCommand.Json#setMeasurableId(long)}
   */
  @Test
  void testJsonSetMeasurableId2() {
    // Arrange
    ImmutableRemoveMeasurableRatingCommand.Json json = new ImmutableRemoveMeasurableRatingCommand.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setMeasurableId(1L);

    // Assert
    assertEquals(1L, json.measurableId);
    assertTrue(json.measurableIdIsSet);
  }
}
