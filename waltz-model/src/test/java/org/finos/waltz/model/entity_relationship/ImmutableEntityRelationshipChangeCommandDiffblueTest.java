package org.finos.waltz.model.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.Operation;
import org.junit.jupiter.api.Test;

class ImmutableEntityRelationshipChangeCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableEntityRelationshipChangeCommand.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableEntityRelationshipChangeCommand.Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationshipChangeCommand.Builder#from(EntityRelationshipChangeCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntityRelationshipChangeCommand.Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();
    EntityRelationshipChangeCommand instance = mock(EntityRelationshipChangeCommand.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.operation()).thenReturn(Operation.ADD);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReference();
    verify(instance).operation();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationshipChangeCommand.Builder#from(EntityRelationshipChangeCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntityRelationshipChangeCommand.Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();
    EntityRelationshipChangeCommand instance = mock(EntityRelationshipChangeCommand.class);
    when(instance.relationship()).thenReturn(RelationshipKind.HAS);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.operation()).thenReturn(Operation.ADD);

    // Act
    ImmutableEntityRelationshipChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).operation();
    verify(instance).relationship();
    ImmutableEntityRelationshipChangeCommand buildResult = builderResult.build();
    assertEquals(Operation.ADD, buildResult.operation());
    assertEquals(RelationshipKind.HAS, buildResult.relationship());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationshipChangeCommand.Builder#from(EntityRelationshipChangeCommand)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableEntityRelationshipChangeCommand.Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();
    EntityRelationshipChangeCommand instance = mock(EntityRelationshipChangeCommand.class);
    when(instance.relationship()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.operation()).thenReturn(Operation.ADD);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReference();
    verify(instance).operation();
    verify(instance).relationship();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationshipChangeCommand.Builder#operation(Operation)}
   */
  @Test
  void testBuilderOperation() {
    // Arrange
    ImmutableEntityRelationshipChangeCommand.Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operation(Operation.ADD));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationshipChangeCommand.Builder#relationship(RelationshipKind)}
   */
  @Test
  void testBuilderRelationship() {
    // Arrange
    ImmutableEntityRelationshipChangeCommand.Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.relationship(RelationshipKind.HAS));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationshipChangeCommand#copyOf(EntityRelationshipChangeCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EntityRelationshipChangeCommand instance = mock(EntityRelationshipChangeCommand.class);
    when(instance.relationship()).thenReturn(RelationshipKind.HAS);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.operation()).thenReturn(Operation.ADD);

    // Act
    ImmutableEntityRelationshipChangeCommand actualCopyOfResult = ImmutableEntityRelationshipChangeCommand
        .copyOf(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).operation();
    verify(instance).relationship();
    assertEquals(Operation.ADD, actualCopyOfResult.operation());
    assertEquals(RelationshipKind.HAS, actualCopyOfResult.relationship());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationshipChangeCommand#fromJson(ImmutableEntityRelationshipChangeCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableEntityRelationshipChangeCommand.Json json = new ImmutableEntityRelationshipChangeCommand.Json();
    json.setRelationship(RelationshipKind.HAS);
    json.setOperation(Operation.ADD);
    json.setEntityReference(mock(EntityReference.class));

    // Act
    ImmutableEntityRelationshipChangeCommand actualFromJsonResult = ImmutableEntityRelationshipChangeCommand
        .fromJson(json);

    // Assert
    assertEquals(Operation.ADD, actualFromJsonResult.operation());
    assertEquals(RelationshipKind.HAS, actualFromJsonResult.relationship());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationshipChangeCommand.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityRelationshipChangeCommand.Json()).entityReference());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableEntityRelationshipChangeCommand.Json}
   *   <li>
   * {@link ImmutableEntityRelationshipChangeCommand.Json#setEntityReference(EntityReference)}
   *   <li>
   * {@link ImmutableEntityRelationshipChangeCommand.Json#setOperation(Operation)}
   *   <li>
   * {@link ImmutableEntityRelationshipChangeCommand.Json#setRelationship(RelationshipKind)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableEntityRelationshipChangeCommand.Json actualJson = new ImmutableEntityRelationshipChangeCommand.Json();
    actualJson.setEntityReference(null);
    actualJson.setOperation(Operation.ADD);
    actualJson.setRelationship(RelationshipKind.HAS);

    // Assert
    assertNull(actualJson.entityReference);
    assertEquals(Operation.ADD, actualJson.operation);
    assertEquals(RelationshipKind.HAS, actualJson.relationship);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationshipChangeCommand.Json#operation()}
   */
  @Test
  void testJsonOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityRelationshipChangeCommand.Json()).operation());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationshipChangeCommand.Json#relationship()}
   */
  @Test
  void testJsonRelationship() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityRelationshipChangeCommand.Json()).relationship());
  }
}
