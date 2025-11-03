package org.finos.waltz.model.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.entity_relationship.ImmutableEntityRelationshipChangeCommand.Builder;
import org.finos.waltz.model.entity_relationship.ImmutableEntityRelationshipChangeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityRelationshipChangeCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(EntityRelationshipChangeCommand)}.
   * <p>
   * Method under test: {@link Builder#from(EntityRelationshipChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(EntityRelationshipChangeCommand)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityRelationshipChangeCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();
    EntityRelationshipChangeCommand instance = mock(EntityRelationshipChangeCommand.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.operation()).thenReturn(Operation.ADD);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReference();
    verify(instance).operation();
  }

  /**
   * Test Builder {@link Builder#from(EntityRelationshipChangeCommand)}.
   * <p>
   * Method under test: {@link Builder#from(EntityRelationshipChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(EntityRelationshipChangeCommand)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityRelationshipChangeCommand)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();
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
   * Test Builder {@link Builder#from(EntityRelationshipChangeCommand)}.
   * <ul>
   *   <li>Given {@code HAS}.</li>
   *   <li>Then builder build operation is {@code ADD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityRelationshipChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(EntityRelationshipChangeCommand); given 'HAS'; then builder build operation is 'ADD'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityRelationshipChangeCommand)"})
  void testBuilderFrom_givenHas_thenBuilderBuildOperationIsAdd() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();
    EntityRelationshipChangeCommand instance = mock(EntityRelationshipChangeCommand.class);
    when(instance.relationship()).thenReturn(RelationshipKind.HAS);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.operation()).thenReturn(Operation.ADD);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#operation(Operation)}.
   * <p>
   * Method under test: {@link Builder#operation(Operation)}
   */
  @Test
  @DisplayName("Test Builder operation(Operation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.operation(Operation)"})
  void testBuilderOperation() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operation(Operation.ADD));
  }

  /**
   * Test Builder {@link Builder#relationship(RelationshipKind)}.
   * <p>
   * Method under test: {@link Builder#relationship(RelationshipKind)}
   */
  @Test
  @DisplayName("Test Builder relationship(RelationshipKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.relationship(RelationshipKind)"})
  void testBuilderRelationship() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.relationship(RelationshipKind.HAS));
  }

  /**
   * Test Json {@link Json#entityReference()}.
   * <p>
   * Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityReference());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setEntityReference(EntityReference)}
   *   <li>{@link Json#setOperation(Operation)}
   *   <li>{@link Json#setRelationship(RelationshipKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setEntityReference(EntityReference)",
      "void Json.setOperation(Operation)", "void Json.setRelationship(RelationshipKind)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setEntityReference(null);
    actualJson.setOperation(Operation.ADD);
    actualJson.setRelationship(RelationshipKind.HAS);

    // Assert
    assertNull(actualJson.entityReference);
    assertEquals(Operation.ADD, actualJson.operation);
    assertEquals(RelationshipKind.HAS, actualJson.relationship);
  }

  /**
   * Test Json {@link Json#operation()}.
   * <p>
   * Method under test: {@link Json#operation()}
   */
  @Test
  @DisplayName("Test Json operation()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Operation Json.operation()"})
  void testJsonOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).operation());
  }

  /**
   * Test Json {@link Json#relationship()}.
   * <p>
   * Method under test: {@link Json#relationship()}
   */
  @Test
  @DisplayName("Test Json relationship()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RelationshipKind Json.relationship()"})
  void testJsonRelationship() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).relationship());
  }
}
