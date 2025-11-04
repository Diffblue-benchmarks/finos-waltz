package org.finos.waltz.model.roadmap;

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
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableRoadmapCreateCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableRoadmapCreateCommand.Builder#columnType(EntityReference)}
   */
  @Test
  void testBuilderColumnType() {
    // Arrange
    ImmutableRoadmapCreateCommand.Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.columnType(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableRoadmapCreateCommand.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableRoadmapCreateCommand.Builder builderResult = ImmutableRoadmapCreateCommand.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRoadmapCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRoadmapCreateCommand.Builder#from(RoadmapCreateCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableRoadmapCreateCommand.Builder builderResult = ImmutableRoadmapCreateCommand.builder();
    RoadmapCreateCommand instance = mock(RoadmapCreateCommand.class);
    when(instance.rowType()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
    verify(instance).rowType();
  }

  /**
   * Method under test:
   * {@link ImmutableRoadmapCreateCommand.Builder#from(RoadmapCreateCommand)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableRoadmapCreateCommand.Builder builderResult = ImmutableRoadmapCreateCommand.builder();
    RoadmapCreateCommand instance = mock(RoadmapCreateCommand.class);
    when(instance.columnType()).thenThrow(new IllegalStateException("instance"));
    when(instance.rowType()).thenReturn(mock(EntityReference.class));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
    verify(instance).columnType();
    verify(instance).rowType();
  }

  /**
   * Method under test:
   * {@link ImmutableRoadmapCreateCommand.Builder#from(RoadmapCreateCommand)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableRoadmapCreateCommand.Builder builderResult = ImmutableRoadmapCreateCommand.builder();
    RoadmapCreateCommand instance = mock(RoadmapCreateCommand.class);
    when(instance.ratingSchemeId()).thenThrow(new IllegalStateException("instance"));
    when(instance.columnType()).thenReturn(mock(EntityReference.class));
    when(instance.rowType()).thenReturn(mock(EntityReference.class));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
    verify(instance).columnType();
    verify(instance).ratingSchemeId();
    verify(instance).rowType();
  }

  /**
   * Method under test:
   * {@link ImmutableRoadmapCreateCommand.Builder#from(RoadmapCreateCommand)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableRoadmapCreateCommand.Builder builderResult = ImmutableRoadmapCreateCommand.builder();
    RoadmapCreateCommand instance = mock(RoadmapCreateCommand.class);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.linkedEntity()).thenReturn(mock(EntityReference.class));
    when(instance.columnType()).thenReturn(mock(EntityReference.class));
    when(instance.rowType()).thenReturn(mock(EntityReference.class));
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRoadmapCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    verify(instance).columnType();
    verify(instance).linkedEntity();
    verify(instance).ratingSchemeId();
    verify(instance).rowType();
    ImmutableRoadmapCreateCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals(1L, buildResult.ratingSchemeId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRoadmapCreateCommand.Builder#linkedEntity(EntityReference)}
   */
  @Test
  void testBuilderLinkedEntity() {
    // Arrange
    ImmutableRoadmapCreateCommand.Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.linkedEntity(mock(EntityReference.class)));
  }

  /**
   * Method under test: {@link ImmutableRoadmapCreateCommand.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableRoadmapCreateCommand.Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableRoadmapCreateCommand.Builder#ratingSchemeId(long)}
   */
  @Test
  void testBuilderRatingSchemeId() {
    // Arrange
    ImmutableRoadmapCreateCommand.Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingSchemeId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableRoadmapCreateCommand.Builder#rowType(EntityReference)}
   */
  @Test
  void testBuilderRowType() {
    // Arrange
    ImmutableRoadmapCreateCommand.Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rowType(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableRoadmapCreateCommand#copyOf(RoadmapCreateCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    RoadmapCreateCommand instance = mock(RoadmapCreateCommand.class);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.linkedEntity()).thenReturn(mock(EntityReference.class));
    when(instance.columnType()).thenReturn(mock(EntityReference.class));
    when(instance.rowType()).thenReturn(mock(EntityReference.class));
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRoadmapCreateCommand actualCopyOfResult = ImmutableRoadmapCreateCommand.copyOf(instance);

    // Assert
    verify(instance).name();
    verify(instance).columnType();
    verify(instance).linkedEntity();
    verify(instance).ratingSchemeId();
    verify(instance).rowType();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId());
  }

  /**
   * Method under test: {@link ImmutableRoadmapCreateCommand.Json#columnType()}
   */
  @Test
  void testJsonColumnType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRoadmapCreateCommand.Json()).columnType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableRoadmapCreateCommand.Json}
   *   <li>{@link ImmutableRoadmapCreateCommand.Json#setColumnType(EntityReference)}
   *   <li>
   * {@link ImmutableRoadmapCreateCommand.Json#setLinkedEntity(EntityReference)}
   *   <li>{@link ImmutableRoadmapCreateCommand.Json#setName(String)}
   *   <li>{@link ImmutableRoadmapCreateCommand.Json#setRowType(EntityReference)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableRoadmapCreateCommand.Json actualJson = new ImmutableRoadmapCreateCommand.Json();
    actualJson.setColumnType(null);
    actualJson.setLinkedEntity(null);
    actualJson.setName("Name");
    actualJson.setRowType(null);

    // Assert
    assertEquals("Name", actualJson.name);
    assertNull(actualJson.columnType);
    assertNull(actualJson.linkedEntity);
    assertNull(actualJson.rowType);
    assertEquals(0L, actualJson.ratingSchemeId);
    assertFalse(actualJson.ratingSchemeIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableRoadmapCreateCommand.Json#linkedEntity()}
   */
  @Test
  void testJsonLinkedEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRoadmapCreateCommand.Json()).linkedEntity());
  }

  /**
   * Method under test: {@link ImmutableRoadmapCreateCommand.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRoadmapCreateCommand.Json()).name());
  }

  /**
   * Method under test:
   * {@link ImmutableRoadmapCreateCommand.Json#ratingSchemeId()}
   */
  @Test
  void testJsonRatingSchemeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableRoadmapCreateCommand.Json()).ratingSchemeId());
  }

  /**
   * Method under test: {@link ImmutableRoadmapCreateCommand.Json#rowType()}
   */
  @Test
  void testJsonRowType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRoadmapCreateCommand.Json()).rowType());
  }

  /**
   * Method under test:
   * {@link ImmutableRoadmapCreateCommand.Json#setRatingSchemeId(long)}
   */
  @Test
  void testJsonSetRatingSchemeId() {
    // Arrange
    ImmutableRoadmapCreateCommand.Json json = new ImmutableRoadmapCreateCommand.Json();

    // Act
    json.setRatingSchemeId(1L);

    // Assert
    assertEquals(1L, json.ratingSchemeId);
    assertTrue(json.ratingSchemeIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableRoadmapCreateCommand.Json#setRatingSchemeId(long)}
   */
  @Test
  void testJsonSetRatingSchemeId2() {
    // Arrange
    ImmutableRoadmapCreateCommand.Json json = new ImmutableRoadmapCreateCommand.Json();
    json.setRowType(mock(EntityReference.class));

    // Act
    json.setRatingSchemeId(1L);

    // Assert
    assertEquals(1L, json.ratingSchemeId);
    assertTrue(json.ratingSchemeIdIsSet);
  }
}
