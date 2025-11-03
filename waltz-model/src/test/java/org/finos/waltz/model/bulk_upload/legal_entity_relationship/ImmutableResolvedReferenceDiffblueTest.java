package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableResolvedReference.Builder;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableResolvedReference.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableResolvedReferenceDiffblueTest {
  /**
   * Test Builder {@link Builder#from(ResolvedReference)}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ResolvedReference)}
   */
  @Test
  @DisplayName("Test Builder from(ResolvedReference); given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ResolvedReference)"})
  void testBuilderFrom_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableResolvedReference.builder();
    ResolvedReference instance = mock(ResolvedReference.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(instance.resolvedEntityReference()).thenReturn(emptyResult);
    when(instance.inputString()).thenReturn("Input String");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).inputString();
    verify(instance).resolvedEntityReference();
    assertEquals("Input String", builderResult.build().inputString());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ResolvedReference)}.
   * <ul>
   *   <li>Given {@link Optional} with {@link EntityReference}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ResolvedReference)}
   */
  @Test
  @DisplayName("Test Builder from(ResolvedReference); given Optional with EntityReference")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ResolvedReference)"})
  void testBuilderFrom_givenOptionalWithEntityReference() {
    // Arrange
    Builder builderResult = ImmutableResolvedReference.builder();
    ResolvedReference instance = mock(ResolvedReference.class);
    Optional<EntityReference> ofResult = Optional.of(mock(EntityReference.class));
    when(instance.resolvedEntityReference()).thenReturn(ofResult);
    when(instance.inputString()).thenReturn("Input String");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).inputString();
    verify(instance).resolvedEntityReference();
    assertEquals("Input String", builderResult.build().inputString());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ResolvedReference)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ResolvedReference)}
   */
  @Test
  @DisplayName("Test Builder from(ResolvedReference); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ResolvedReference)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableResolvedReference.builder();
    ResolvedReference instance = mock(ResolvedReference.class);
    when(instance.resolvedEntityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.inputString()).thenReturn("Input String");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).inputString();
    verify(instance).resolvedEntityReference();
  }

  /**
   * Test Builder {@link Builder#inputString(String)}.
   * <p>
   * Method under test: {@link Builder#inputString(String)}
   */
  @Test
  @DisplayName("Test Builder inputString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.inputString(String)"})
  void testBuilderInputString() {
    // Arrange
    Builder builderResult = ImmutableResolvedReference.builder();

    // Act
    Builder actualInputStringResult = builderResult.inputString("Input String");

    // Assert
    assertEquals("Input String", builderResult.build().inputString());
    assertSame(builderResult, actualInputStringResult);
  }

  /**
   * Test Builder {@link Builder#resolvedEntityReference(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#resolvedEntityReference(Optional)}
   */
  @Test
  @DisplayName("Test Builder resolvedEntityReference(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.resolvedEntityReference(Optional)"})
  void testBuilderResolvedEntityReferenceWithOptional() {
    // Arrange
    Builder builderResult = ImmutableResolvedReference.builder();
    Optional<? extends EntityReference> resolvedEntityReference = Optional.of(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.resolvedEntityReference(resolvedEntityReference));
  }

  /**
   * Test Json {@link Json#inputString()}.
   * <p>
   * Method under test: {@link Json#inputString()}
   */
  @Test
  @DisplayName("Test Json inputString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.inputString()"})
  void testJsonInputString() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).inputString());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.inputString);
    assertFalse(actualJson.resolvedEntityReference.isPresent());
  }

  /**
   * Test Json {@link Json#resolvedEntityReference()}.
   * <p>
   * Method under test: {@link Json#resolvedEntityReference()}
   */
  @Test
  @DisplayName("Test Json resolvedEntityReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.resolvedEntityReference()"})
  void testJsonResolvedEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).resolvedEntityReference());
  }
}
