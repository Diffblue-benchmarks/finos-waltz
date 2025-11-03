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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.involvement.ImmutableEntityInvolvementChangeCommand.Builder;
import org.finos.waltz.model.involvement.ImmutableEntityInvolvementChangeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityInvolvementChangeCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#from(EntityInvolvementChangeCommand)}.
   * <p>
   * Method under test: {@link Builder#from(EntityInvolvementChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(EntityInvolvementChangeCommand)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityInvolvementChangeCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableEntityInvolvementChangeCommand.builder();
    EntityInvolvementChangeCommand instance = mock(EntityInvolvementChangeCommand.class);
    when(instance.personEntityRef()).thenThrow(new IllegalStateException("instance"));
    when(instance.operation()).thenReturn(Operation.ADD);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).operation();
    verify(instance).personEntityRef();
  }

  /**
   * Test Builder {@link Builder#from(EntityInvolvementChangeCommand)}.
   * <p>
   * Method under test: {@link Builder#from(EntityInvolvementChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(EntityInvolvementChangeCommand)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityInvolvementChangeCommand)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableEntityInvolvementChangeCommand.builder();
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
   * Test Builder {@link Builder#from(EntityInvolvementChangeCommand)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then builder build involvementKindId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityInvolvementChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(EntityInvolvementChangeCommand); given one; then builder build involvementKindId is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityInvolvementChangeCommand)"})
  void testBuilderFrom_givenOne_thenBuilderBuildInvolvementKindIdIsOne() {
    // Arrange
    Builder builderResult = ImmutableEntityInvolvementChangeCommand.builder();
    EntityInvolvementChangeCommand instance = mock(EntityInvolvementChangeCommand.class);
    when(instance.involvementKindId()).thenReturn(1);
    when(instance.personEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.operation()).thenReturn(Operation.ADD);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#involvementKindId(int)}.
   * <p>
   * Method under test: {@link Builder#involvementKindId(int)}
   */
  @Test
  @DisplayName("Test Builder involvementKindId(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.involvementKindId(int)"})
  void testBuilderInvolvementKindId() {
    // Arrange
    Builder builderResult = ImmutableEntityInvolvementChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.involvementKindId(1));
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
    Builder builderResult = ImmutableEntityInvolvementChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operation(Operation.ADD));
  }

  /**
   * Test Builder {@link Builder#personEntityRef(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#personEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder personEntityRef(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.personEntityRef(EntityReference)"})
  void testBuilderPersonEntityRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityInvolvementChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.personEntityRef(mock(EntityReference.class)));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setOperation(Operation)}
   *   <li>{@link Json#setPersonEntityRef(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setOperation(Operation)",
      "void Json.setPersonEntityRef(EntityReference)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setOperation(Operation.ADD);
    actualJson.setPersonEntityRef(null);

    // Assert
    assertNull(actualJson.personEntityRef);
    assertEquals(0, actualJson.involvementKindId);
    assertEquals(Operation.ADD, actualJson.operation);
    assertFalse(actualJson.involvementKindIdIsSet);
  }

  /**
   * Test Json {@link Json#involvementKindId()}.
   * <p>
   * Method under test: {@link Json#involvementKindId()}
   */
  @Test
  @DisplayName("Test Json involvementKindId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.involvementKindId()"})
  void testJsonInvolvementKindId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).involvementKindId());
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
   * Test Json {@link Json#personEntityRef()}.
   * <p>
   * Method under test: {@link Json#personEntityRef()}
   */
  @Test
  @DisplayName("Test Json personEntityRef()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.personEntityRef()"})
  void testJsonPersonEntityRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).personEntityRef());
  }

  /**
   * Test Json {@link Json#setInvolvementKindId(int)}.
   * <p>
   * Method under test: {@link Json#setInvolvementKindId(int)}
   */
  @Test
  @DisplayName("Test Json setInvolvementKindId(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setInvolvementKindId(int)"})
  void testJsonSetInvolvementKindId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setInvolvementKindId(1);

    // Assert
    assertEquals(1, json.involvementKindId);
    assertTrue(json.involvementKindIdIsSet);
  }
}
