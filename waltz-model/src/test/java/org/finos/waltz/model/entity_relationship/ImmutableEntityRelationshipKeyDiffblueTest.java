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
import org.finos.waltz.model.entity_relationship.ImmutableEntityRelationshipKey.Builder;
import org.finos.waltz.model.entity_relationship.ImmutableEntityRelationshipKey.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityRelationshipKeyDiffblueTest {
  /**
   * Test Builder {@link Builder#a(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#a(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder a(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.a(EntityReference)"})
  void testBuilderA_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.a(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#b(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#b(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder b(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.b(EntityReference)"})
  void testBuilderB_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.b(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(EntityRelationshipKey)}.
   * <p>
   * Method under test: {@link Builder#from(EntityRelationshipKey)}
   */
  @Test
  @DisplayName("Test Builder from(EntityRelationshipKey)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityRelationshipKey)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipKey.builder();
    EntityRelationshipKey instance = mock(EntityRelationshipKey.class);
    when(instance.relationshipKind()).thenThrow(new IllegalStateException("instance"));
    when(instance.b()).thenReturn(mock(EntityReference.class));
    when(instance.a()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).a();
    verify(instance).b();
    verify(instance).relationshipKind();
  }

  /**
   * Test Builder {@link Builder#from(EntityRelationshipKey)}.
   * <ul>
   *   <li>Then builder build relationshipKind is {@code Relationship Kind}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityRelationshipKey)}
   */
  @Test
  @DisplayName("Test Builder from(EntityRelationshipKey); then builder build relationshipKind is 'Relationship Kind'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityRelationshipKey)"})
  void testBuilderFrom_thenBuilderBuildRelationshipKindIsRelationshipKind() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipKey.builder();
    EntityRelationshipKey instance = mock(EntityRelationshipKey.class);
    when(instance.relationshipKind()).thenReturn("Relationship Kind");
    when(instance.b()).thenReturn(mock(EntityReference.class));
    when(instance.a()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).a();
    verify(instance).b();
    verify(instance).relationshipKind();
    assertEquals("Relationship Kind", builderResult.build().relationshipKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityRelationshipKey)}.
   * <ul>
   *   <li>When {@link EntityRelationshipKey} {@link EntityRelationshipKey#b()} throw {@link IllegalStateException#IllegalStateException(String)} with {@code instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityRelationshipKey)}
   */
  @Test
  @DisplayName("Test Builder from(EntityRelationshipKey); when EntityRelationshipKey b() throw IllegalStateException(String) with 'instance'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityRelationshipKey)"})
  void testBuilderFrom_whenEntityRelationshipKeyBThrowIllegalStateExceptionWithInstance() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipKey.builder();
    EntityRelationshipKey instance = mock(EntityRelationshipKey.class);
    when(instance.b()).thenThrow(new IllegalStateException("instance"));
    when(instance.a()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).a();
    verify(instance).b();
  }

  /**
   * Test Builder {@link Builder#relationshipKind(String)}.
   * <p>
   * Method under test: {@link Builder#relationshipKind(String)}
   */
  @Test
  @DisplayName("Test Builder relationshipKind(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.relationshipKind(String)"})
  void testBuilderRelationshipKind() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.relationshipKind("Relationship Kind"));
  }

  /**
   * Test Json {@link Json#a()}.
   * <p>
   * Method under test: {@link Json#a()}
   */
  @Test
  @DisplayName("Test Json a()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.a()"})
  void testJsonA() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).a());
  }

  /**
   * Test Json {@link Json#b()}.
   * <p>
   * Method under test: {@link Json#b()}
   */
  @Test
  @DisplayName("Test Json b()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.b()"})
  void testJsonB() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).b());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setA(EntityReference)}
   *   <li>{@link Json#setB(EntityReference)}
   *   <li>{@link Json#setRelationshipKind(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setA(EntityReference)", "void Json.setB(EntityReference)",
      "void Json.setRelationshipKind(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setA(null);
    actualJson.setB(null);
    actualJson.setRelationshipKind("Relationship Kind");

    // Assert
    assertEquals("Relationship Kind", actualJson.relationshipKind);
    assertNull(actualJson.a);
    assertNull(actualJson.b);
  }

  /**
   * Test Json {@link Json#relationshipKind()}.
   * <p>
   * Method under test: {@link Json#relationshipKind()}
   */
  @Test
  @DisplayName("Test Json relationshipKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.relationshipKind()"})
  void testJsonRelationshipKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).relationshipKind());
  }
}
