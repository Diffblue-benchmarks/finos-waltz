package org.finos.waltz.model.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableEntityRelationshipKeyDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableEntityRelationshipKey.Builder#a(EntityReference)}
   */
  @Test
  void testBuilderA() {
    // Arrange
    ImmutableEntityRelationshipKey.Builder builderResult = ImmutableEntityRelationshipKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.a(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationshipKey.Builder#b(EntityReference)}
   */
  @Test
  void testBuilderB() {
    // Arrange
    ImmutableEntityRelationshipKey.Builder builderResult = ImmutableEntityRelationshipKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.b(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationshipKey.Builder#from(EntityRelationshipKey)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntityRelationshipKey.Builder builderResult = ImmutableEntityRelationshipKey.builder();
    EntityRelationshipKey instance = mock(EntityRelationshipKey.class);
    when(instance.b()).thenThrow(new IllegalStateException("instance"));
    when(instance.a()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).a();
    verify(instance).b();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationshipKey.Builder#from(EntityRelationshipKey)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntityRelationshipKey.Builder builderResult = ImmutableEntityRelationshipKey.builder();
    EntityRelationshipKey instance = mock(EntityRelationshipKey.class);
    when(instance.relationshipKind()).thenReturn("Relationship Kind");
    when(instance.b()).thenReturn(mock(EntityReference.class));
    when(instance.a()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableEntityRelationshipKey.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).a();
    verify(instance).b();
    verify(instance).relationshipKind();
    assertEquals("Relationship Kind", actualFromResult.build().relationshipKind());
    assertEquals("Relationship Kind", builderResult.build().relationshipKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationshipKey.Builder#from(EntityRelationshipKey)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableEntityRelationshipKey.Builder builderResult = ImmutableEntityRelationshipKey.builder();
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
   * Method under test:
   * {@link ImmutableEntityRelationshipKey.Builder#relationshipKind(String)}
   */
  @Test
  void testBuilderRelationshipKind() {
    // Arrange
    ImmutableEntityRelationshipKey.Builder builderResult = ImmutableEntityRelationshipKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.relationshipKind("Relationship Kind"));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationshipKey#copyOf(EntityRelationshipKey)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EntityRelationshipKey instance = mock(EntityRelationshipKey.class);
    when(instance.relationshipKind()).thenReturn("Relationship Kind");
    when(instance.b()).thenReturn(mock(EntityReference.class));
    when(instance.a()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableEntityRelationshipKey actualCopyOfResult = ImmutableEntityRelationshipKey.copyOf(instance);

    // Assert
    verify(instance).a();
    verify(instance).b();
    verify(instance).relationshipKind();
    assertEquals("Relationship Kind", actualCopyOfResult.relationshipKind());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationshipKey#fromJson(ImmutableEntityRelationshipKey.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableEntityRelationshipKey.Json json = new ImmutableEntityRelationshipKey.Json();
    json.setRelationshipKind("Relationship Kind");
    json.setB(mock(EntityReference.class));
    json.setA(mock(EntityReference.class));

    // Act
    ImmutableEntityRelationshipKey actualFromJsonResult = ImmutableEntityRelationshipKey.fromJson(json);

    // Assert
    assertEquals("Relationship Kind", actualFromJsonResult.relationshipKind());
    EntityReference expectedAResult = json.a;
    assertSame(expectedAResult, actualFromJsonResult.a());
    EntityReference expectedBResult = json.b;
    assertSame(expectedBResult, actualFromJsonResult.b());
  }

  /**
   * Method under test: {@link ImmutableEntityRelationshipKey.Json#a()}
   */
  @Test
  void testJsonA() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityRelationshipKey.Json()).a());
  }

  /**
   * Method under test: {@link ImmutableEntityRelationshipKey.Json#b()}
   */
  @Test
  void testJsonB() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityRelationshipKey.Json()).b());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableEntityRelationshipKey.Json}
   *   <li>{@link ImmutableEntityRelationshipKey.Json#setA(EntityReference)}
   *   <li>{@link ImmutableEntityRelationshipKey.Json#setB(EntityReference)}
   *   <li>{@link ImmutableEntityRelationshipKey.Json#setRelationshipKind(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableEntityRelationshipKey.Json actualJson = new ImmutableEntityRelationshipKey.Json();
    actualJson.setA(null);
    actualJson.setB(null);
    actualJson.setRelationshipKind("Relationship Kind");

    // Assert
    assertEquals("Relationship Kind", actualJson.relationshipKind);
    assertNull(actualJson.a);
    assertNull(actualJson.b);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationshipKey.Json#relationshipKind()}
   */
  @Test
  void testJsonRelationshipKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityRelationshipKey.Json()).relationshipKind());
  }
}
