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
import org.finos.waltz.model.Operation;
import org.junit.jupiter.api.Test;

class ImmutableEntityInvolvementChangeCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableEntityInvolvementChangeCommand.Builder#from(EntityInvolvementChangeCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntityInvolvementChangeCommand.Builder builderResult = ImmutableEntityInvolvementChangeCommand.builder();
    EntityInvolvementChangeCommand instance = mock(EntityInvolvementChangeCommand.class);
    when(instance.personEntityRef()).thenThrow(new IllegalStateException("instance"));
    when(instance.operation()).thenReturn(Operation.ADD);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).operation();
    verify(instance).personEntityRef();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityInvolvementChangeCommand.Builder#from(EntityInvolvementChangeCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntityInvolvementChangeCommand.Builder builderResult = ImmutableEntityInvolvementChangeCommand.builder();
    EntityInvolvementChangeCommand instance = mock(EntityInvolvementChangeCommand.class);
    when(instance.involvementKindId()).thenReturn(1);
    when(instance.personEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.operation()).thenReturn(Operation.ADD);

    // Act
    ImmutableEntityInvolvementChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).involvementKindId();
    verify(instance).operation();
    verify(instance).personEntityRef();
    ImmutableEntityInvolvementChangeCommand buildResult = builderResult.build();
    assertEquals(1, buildResult.involvementKindId());
    assertEquals(Operation.ADD, buildResult.operation());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityInvolvementChangeCommand.Builder#from(EntityInvolvementChangeCommand)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableEntityInvolvementChangeCommand.Builder builderResult = ImmutableEntityInvolvementChangeCommand.builder();
    EntityInvolvementChangeCommand instance = mock(EntityInvolvementChangeCommand.class);
    when(instance.involvementKindId()).thenThrow(new IllegalStateException("instance"));
    when(instance.personEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.operation()).thenReturn(Operation.ADD);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).involvementKindId();
    verify(instance).operation();
    verify(instance).personEntityRef();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityInvolvementChangeCommand.Builder#involvementKindId(int)}
   */
  @Test
  void testBuilderInvolvementKindId() {
    // Arrange
    ImmutableEntityInvolvementChangeCommand.Builder builderResult = ImmutableEntityInvolvementChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.involvementKindId(1));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityInvolvementChangeCommand.Builder#operation(Operation)}
   */
  @Test
  void testBuilderOperation() {
    // Arrange
    ImmutableEntityInvolvementChangeCommand.Builder builderResult = ImmutableEntityInvolvementChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operation(Operation.ADD));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityInvolvementChangeCommand.Builder#personEntityRef(EntityReference)}
   */
  @Test
  void testBuilderPersonEntityRef() {
    // Arrange
    ImmutableEntityInvolvementChangeCommand.Builder builderResult = ImmutableEntityInvolvementChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.personEntityRef(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityInvolvementChangeCommand#copyOf(EntityInvolvementChangeCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EntityInvolvementChangeCommand instance = mock(EntityInvolvementChangeCommand.class);
    when(instance.involvementKindId()).thenReturn(1);
    when(instance.personEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.operation()).thenReturn(Operation.ADD);

    // Act
    ImmutableEntityInvolvementChangeCommand actualCopyOfResult = ImmutableEntityInvolvementChangeCommand
        .copyOf(instance);

    // Assert
    verify(instance).involvementKindId();
    verify(instance).operation();
    verify(instance).personEntityRef();
    assertEquals(1, actualCopyOfResult.involvementKindId());
    assertEquals(Operation.ADD, actualCopyOfResult.operation());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableEntityInvolvementChangeCommand.Json}
   *   <li>
   * {@link ImmutableEntityInvolvementChangeCommand.Json#setOperation(Operation)}
   *   <li>
   * {@link ImmutableEntityInvolvementChangeCommand.Json#setPersonEntityRef(EntityReference)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableEntityInvolvementChangeCommand.Json actualJson = new ImmutableEntityInvolvementChangeCommand.Json();
    actualJson.setOperation(Operation.ADD);
    actualJson.setPersonEntityRef(null);

    // Assert
    assertNull(actualJson.personEntityRef);
    assertEquals(0, actualJson.involvementKindId);
    assertEquals(Operation.ADD, actualJson.operation);
    assertFalse(actualJson.involvementKindIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityInvolvementChangeCommand.Json#involvementKindId()}
   */
  @Test
  void testJsonInvolvementKindId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityInvolvementChangeCommand.Json()).involvementKindId());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityInvolvementChangeCommand.Json#operation()}
   */
  @Test
  void testJsonOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityInvolvementChangeCommand.Json()).operation());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityInvolvementChangeCommand.Json#personEntityRef()}
   */
  @Test
  void testJsonPersonEntityRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityInvolvementChangeCommand.Json()).personEntityRef());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityInvolvementChangeCommand.Json#setInvolvementKindId(int)}
   */
  @Test
  void testJsonSetInvolvementKindId() {
    // Arrange
    ImmutableEntityInvolvementChangeCommand.Json json = new ImmutableEntityInvolvementChangeCommand.Json();

    // Act
    json.setInvolvementKindId(1);

    // Assert
    assertEquals(1, json.involvementKindId);
    assertTrue(json.involvementKindIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityInvolvementChangeCommand.Json#setInvolvementKindId(int)}
   */
  @Test
  void testJsonSetInvolvementKindId2() {
    // Arrange
    ImmutableEntityInvolvementChangeCommand.Json json = new ImmutableEntityInvolvementChangeCommand.Json();
    json.setPersonEntityRef(mock(EntityReference.class));

    // Act
    json.setInvolvementKindId(1);

    // Assert
    assertEquals(1, json.involvementKindId);
    assertTrue(json.involvementKindIdIsSet);
  }
}
