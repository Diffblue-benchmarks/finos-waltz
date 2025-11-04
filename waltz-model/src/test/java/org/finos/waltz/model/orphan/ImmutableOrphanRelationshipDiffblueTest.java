package org.finos.waltz.model.orphan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableOrphanRelationshipDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableOrphanRelationship.Builder#entityA(EntityReference)}
   */
  @Test
  void testBuilderEntityA() {
    // Arrange
    ImmutableOrphanRelationship.Builder builderResult = ImmutableOrphanRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityA(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableOrphanRelationship.Builder#entityB(EntityReference)}
   */
  @Test
  void testBuilderEntityB() {
    // Arrange
    ImmutableOrphanRelationship.Builder builderResult = ImmutableOrphanRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityB(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableOrphanRelationship.Builder#from(OrphanRelationship)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableOrphanRelationship.Builder builderResult = ImmutableOrphanRelationship.builder();
    OrphanRelationship instance = mock(OrphanRelationship.class);
    when(instance.entityB()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityA()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityA();
    verify(instance).entityB();
  }

  /**
   * Method under test:
   * {@link ImmutableOrphanRelationship.Builder#from(OrphanRelationship)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableOrphanRelationship.Builder builderResult = ImmutableOrphanRelationship.builder();
    OrphanRelationship instance = mock(OrphanRelationship.class);
    when(instance.orphanSide()).thenReturn(OrphanSide.A);
    when(instance.entityB()).thenReturn(mock(EntityReference.class));
    when(instance.entityA()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableOrphanRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityA();
    verify(instance).entityB();
    verify(instance).orphanSide();
    assertEquals(OrphanSide.A, actualFromResult.build().orphanSide());
    assertEquals(OrphanSide.A, builderResult.build().orphanSide());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOrphanRelationship.Builder#from(OrphanRelationship)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableOrphanRelationship.Builder builderResult = ImmutableOrphanRelationship.builder();
    OrphanRelationship instance = mock(OrphanRelationship.class);
    when(instance.orphanSide()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityB()).thenReturn(mock(EntityReference.class));
    when(instance.entityA()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityA();
    verify(instance).entityB();
    verify(instance).orphanSide();
  }

  /**
   * Method under test:
   * {@link ImmutableOrphanRelationship.Builder#orphanSide(OrphanSide)}
   */
  @Test
  void testBuilderOrphanSide() {
    // Arrange
    ImmutableOrphanRelationship.Builder builderResult = ImmutableOrphanRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.orphanSide(OrphanSide.A));
  }

  /**
   * Method under test:
   * {@link ImmutableOrphanRelationship#copyOf(OrphanRelationship)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    OrphanRelationship instance = mock(OrphanRelationship.class);
    when(instance.orphanSide()).thenReturn(OrphanSide.A);
    when(instance.entityB()).thenReturn(mock(EntityReference.class));
    when(instance.entityA()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableOrphanRelationship actualCopyOfResult = ImmutableOrphanRelationship.copyOf(instance);

    // Assert
    verify(instance).entityA();
    verify(instance).entityB();
    verify(instance).orphanSide();
    assertEquals(OrphanSide.A, actualCopyOfResult.orphanSide());
  }

  /**
   * Method under test:
   * {@link ImmutableOrphanRelationship#fromJson(ImmutableOrphanRelationship.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableOrphanRelationship.Json json = new ImmutableOrphanRelationship.Json();
    json.setOrphanSide(OrphanSide.A);
    json.setEntityB(mock(EntityReference.class));
    json.setEntityA(mock(EntityReference.class));

    // Act
    ImmutableOrphanRelationship actualFromJsonResult = ImmutableOrphanRelationship.fromJson(json);

    // Assert
    assertEquals(OrphanSide.A, actualFromJsonResult.orphanSide());
    EntityReference expectedEntityAResult = json.entityA;
    assertSame(expectedEntityAResult, actualFromJsonResult.entityA());
    EntityReference expectedEntityBResult = json.entityB;
    assertSame(expectedEntityBResult, actualFromJsonResult.entityB());
  }

  /**
   * Method under test: {@link ImmutableOrphanRelationship.Json#entityA()}
   */
  @Test
  void testJsonEntityA() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableOrphanRelationship.Json()).entityA());
  }

  /**
   * Method under test: {@link ImmutableOrphanRelationship.Json#entityB()}
   */
  @Test
  void testJsonEntityB() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableOrphanRelationship.Json()).entityB());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableOrphanRelationship.Json}
   *   <li>{@link ImmutableOrphanRelationship.Json#setEntityA(EntityReference)}
   *   <li>{@link ImmutableOrphanRelationship.Json#setEntityB(EntityReference)}
   *   <li>{@link ImmutableOrphanRelationship.Json#setOrphanSide(OrphanSide)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableOrphanRelationship.Json actualJson = new ImmutableOrphanRelationship.Json();
    actualJson.setEntityA(null);
    actualJson.setEntityB(null);
    actualJson.setOrphanSide(OrphanSide.A);

    // Assert
    assertNull(actualJson.entityA);
    assertNull(actualJson.entityB);
    assertEquals(OrphanSide.A, actualJson.orphanSide);
  }

  /**
   * Method under test: {@link ImmutableOrphanRelationship.Json#orphanSide()}
   */
  @Test
  void testJsonOrphanSide() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableOrphanRelationship.Json()).orphanSide());
  }
}
