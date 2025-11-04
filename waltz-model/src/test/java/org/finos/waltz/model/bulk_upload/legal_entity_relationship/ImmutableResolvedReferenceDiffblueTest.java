package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableResolvedReferenceDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableResolvedReference.Builder#from(ResolvedReference)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableResolvedReference.Builder builderResult = ImmutableResolvedReference.builder();
    ResolvedReference instance = mock(ResolvedReference.class);
    when(instance.resolvedEntityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.inputString()).thenReturn("Input String");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).inputString();
    verify(instance).resolvedEntityReference();
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedReference.Builder#from(ResolvedReference)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableResolvedReference.Builder builderResult = ImmutableResolvedReference.builder();
    ResolvedReference instance = mock(ResolvedReference.class);
    Optional<EntityReference> ofResult = Optional.of(mock(EntityReference.class));
    when(instance.resolvedEntityReference()).thenReturn(ofResult);
    when(instance.inputString()).thenReturn("Input String");

    // Act
    ImmutableResolvedReference.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).inputString();
    verify(instance).resolvedEntityReference();
    assertEquals("Input String", actualFromResult.build().inputString());
    assertEquals("Input String", builderResult.build().inputString());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedReference.Builder#from(ResolvedReference)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableResolvedReference.Builder builderResult = ImmutableResolvedReference.builder();
    ResolvedReference instance = mock(ResolvedReference.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(instance.resolvedEntityReference()).thenReturn(emptyResult);
    when(instance.inputString()).thenReturn("Input String");

    // Act
    ImmutableResolvedReference.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).inputString();
    verify(instance).resolvedEntityReference();
    assertEquals("Input String", actualFromResult.build().inputString());
    assertEquals("Input String", builderResult.build().inputString());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedReference.Builder#inputString(String)}
   */
  @Test
  void testBuilderInputString() {
    // Arrange
    ImmutableResolvedReference.Builder builderResult = ImmutableResolvedReference.builder();

    // Act
    ImmutableResolvedReference.Builder actualInputStringResult = builderResult.inputString("Input String");

    // Assert
    assertEquals("Input String", actualInputStringResult.build().inputString());
    assertEquals("Input String", builderResult.build().inputString());
    assertSame(builderResult, actualInputStringResult);
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedReference.Builder#inputString(String)}
   */
  @Test
  void testBuilderInputString2() {
    // Arrange
    ImmutableResolvedReference.Builder builderResult = ImmutableResolvedReference.builder();
    builderResult.resolvedEntityReference(mock(EntityReference.class));

    // Act
    ImmutableResolvedReference.Builder actualInputStringResult = builderResult.inputString("Input String");

    // Assert
    assertEquals("Input String", actualInputStringResult.build().inputString());
    assertEquals("Input String", builderResult.build().inputString());
    assertSame(builderResult, actualInputStringResult);
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedReference#copyOf(ResolvedReference)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ResolvedReference instance = mock(ResolvedReference.class);
    Optional<EntityReference> ofResult = Optional.of(mock(EntityReference.class));
    when(instance.resolvedEntityReference()).thenReturn(ofResult);
    when(instance.inputString()).thenReturn("Input String");

    // Act
    ImmutableResolvedReference actualCopyOfResult = ImmutableResolvedReference.copyOf(instance);

    // Assert
    verify(instance).inputString();
    verify(instance).resolvedEntityReference();
    assertEquals("Input String", actualCopyOfResult.inputString());
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedReference#copyOf(ResolvedReference)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ResolvedReference instance = mock(ResolvedReference.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(instance.resolvedEntityReference()).thenReturn(emptyResult);
    when(instance.inputString()).thenReturn("Input String");

    // Act
    ImmutableResolvedReference actualCopyOfResult = ImmutableResolvedReference.copyOf(instance);

    // Assert
    verify(instance).inputString();
    verify(instance).resolvedEntityReference();
    assertEquals("Input String", actualCopyOfResult.inputString());
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedReference#fromJson(ImmutableResolvedReference.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableResolvedReference.Json json = new ImmutableResolvedReference.Json();
    json.setInputString("Json");
    json.setResolvedEntityReference(null);

    // Act and Assert
    assertEquals("Json", ImmutableResolvedReference.fromJson(json).inputString());
  }

  /**
   * Method under test: {@link ImmutableResolvedReference.Json#inputString()}
   */
  @Test
  void testJsonInputString() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableResolvedReference.Json()).inputString());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableResolvedReference.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableResolvedReference.Json actualJson = new ImmutableResolvedReference.Json();

    // Assert
    assertNull(actualJson.inputString);
    assertFalse(actualJson.resolvedEntityReference.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedReference.Json#resolvedEntityReference()}
   */
  @Test
  void testJsonResolvedEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableResolvedReference.Json()).resolvedEntityReference());
  }
}
