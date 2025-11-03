package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableResolvedLegalEntityRelationship.Builder;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableResolvedLegalEntityRelationship.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableResolvedLegalEntityRelationshipDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllErrors(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllErrors(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllErrors(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllErrors(Iterable)"})
  void testBuilderAddAllErrors_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllErrors(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addErrors(LegalEntityRelationshipResolutionError)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableLegalEntityRelationshipResolutionError.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addErrors(LegalEntityRelationshipResolutionError)}
   */
  @Test
  @DisplayName("Test Builder addErrors(LegalEntityRelationshipResolutionError) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addErrors(LegalEntityRelationshipResolutionError)"})
  void testBuilderAddErrorsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(new ImmutableLegalEntityRelationshipResolutionError.Json()));
  }

  /**
   * Test Builder {@link Builder#addErrors(LegalEntityRelationshipResolutionError[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableLegalEntityRelationshipResolutionError.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addErrors(LegalEntityRelationshipResolutionError[])}
   */
  @Test
  @DisplayName("Test Builder addErrors(LegalEntityRelationshipResolutionError[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addErrors(LegalEntityRelationshipResolutionError[])"})
  void testBuilderAddErrorsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(new ImmutableLegalEntityRelationshipResolutionError.Json()));
  }

  /**
   * Test Builder {@link Builder#comment(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#comment(Optional)}
   */
  @Test
  @DisplayName("Test Builder comment(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.comment(Optional)"})
  void testBuilderCommentWithOptional() {
    // Arrange
    Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();
    Optional<String> comment = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.comment(comment));
  }

  /**
   * Test Builder {@link Builder#errors(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#errors(Iterable)}
   */
  @Test
  @DisplayName("Test Builder errors(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.errors(Iterable)"})
  void testBuilderErrors_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.errors(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#existingRelationshipReference(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#existingRelationshipReference(Optional)}
   */
  @Test
  @DisplayName("Test Builder existingRelationshipReference(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.existingRelationshipReference(Optional)"})
  void testBuilderExistingRelationshipReferenceWithOptional() {
    // Arrange
    Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();
    Optional<? extends EntityReference> existingRelationshipReference = Optional.of(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.existingRelationshipReference(existingRelationshipReference));
  }

  /**
   * Test Builder {@link Builder#from(ResolvedLegalEntityRelationship)}.
   * <p>
   * Method under test: {@link Builder#from(ResolvedLegalEntityRelationship)}
   */
  @Test
  @DisplayName("Test Builder from(ResolvedLegalEntityRelationship)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ResolvedLegalEntityRelationship)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();
    ResolvedLegalEntityRelationship instance = mock(ResolvedLegalEntityRelationship.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(instance.existingRelationshipReference()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult);
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.operation()).thenReturn(UploadOperation.ADD);
    ImmutableResolvedReference.Json json = new ImmutableResolvedReference.Json();
    when(instance.legalEntityReference()).thenReturn(json);
    ImmutableResolvedReference.Json json2 = new ImmutableResolvedReference.Json();
    when(instance.targetEntityReference()).thenReturn(json2);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).errors();
    verify(instance).existingRelationshipReference();
    verify(instance).legalEntityReference();
    verify(instance).operation();
    verify(instance).targetEntityReference();
    ImmutableResolvedLegalEntityRelationship buildResult = builderResult.build();
    assertEquals(UploadOperation.ADD, buildResult.operation());
    assertSame(json, buildResult.legalEntityReference());
    assertSame(json2, buildResult.targetEntityReference());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ResolvedLegalEntityRelationship)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link ResolvedLegalEntityRelationship} {@link ResolvedLegalEntityRelationship#comment()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ResolvedLegalEntityRelationship)}
   */
  @Test
  @DisplayName("Test Builder from(ResolvedLegalEntityRelationship); given empty; when ResolvedLegalEntityRelationship comment() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ResolvedLegalEntityRelationship)"})
  void testBuilderFrom_givenEmpty_whenResolvedLegalEntityRelationshipCommentReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();
    ResolvedLegalEntityRelationship instance = mock(ResolvedLegalEntityRelationship.class);
    when(instance.existingRelationshipReference()).thenThrow(new IllegalStateException("instance"));
    Optional<String> emptyResult = Optional.empty();
    when(instance.comment()).thenReturn(emptyResult);
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.operation()).thenReturn(UploadOperation.ADD);
    when(instance.legalEntityReference()).thenReturn(new ImmutableResolvedReference.Json());
    when(instance.targetEntityReference()).thenReturn(new ImmutableResolvedReference.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).comment();
    verify(instance).errors();
    verify(instance).existingRelationshipReference();
    verify(instance).legalEntityReference();
    verify(instance).operation();
    verify(instance).targetEntityReference();
  }

  /**
   * Test Builder {@link Builder#from(ResolvedLegalEntityRelationship)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableLegalEntityRelationshipResolutionError.Json} (default constructor).</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ResolvedLegalEntityRelationship)}
   */
  @Test
  @DisplayName("Test Builder from(ResolvedLegalEntityRelationship); given HashSet() add Json (default constructor); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ResolvedLegalEntityRelationship)"})
  void testBuilderFrom_givenHashSetAddJson_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();

    HashSet<LegalEntityRelationshipResolutionError> legalEntityRelationshipResolutionErrorSet = new HashSet<>();
    legalEntityRelationshipResolutionErrorSet.add(new ImmutableLegalEntityRelationshipResolutionError.Json());
    ResolvedLegalEntityRelationship instance = mock(ResolvedLegalEntityRelationship.class);
    when(instance.existingRelationshipReference()).thenThrow(new IllegalStateException("instance"));
    Optional<String> ofResult = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult);
    when(instance.errors()).thenReturn(legalEntityRelationshipResolutionErrorSet);
    when(instance.operation()).thenReturn(UploadOperation.ADD);
    when(instance.legalEntityReference()).thenReturn(new ImmutableResolvedReference.Json());
    when(instance.targetEntityReference()).thenReturn(new ImmutableResolvedReference.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).comment();
    verify(instance).errors();
    verify(instance).existingRelationshipReference();
    verify(instance).legalEntityReference();
    verify(instance).operation();
    verify(instance).targetEntityReference();
  }

  /**
   * Test Builder {@link Builder#from(ResolvedLegalEntityRelationship)}.
   * <ul>
   *   <li>Given {@link Optional} with {@link EntityReference}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ResolvedLegalEntityRelationship)}
   */
  @Test
  @DisplayName("Test Builder from(ResolvedLegalEntityRelationship); given Optional with EntityReference")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ResolvedLegalEntityRelationship)"})
  void testBuilderFrom_givenOptionalWithEntityReference() {
    // Arrange
    Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();
    ResolvedLegalEntityRelationship instance = mock(ResolvedLegalEntityRelationship.class);
    Optional<EntityReference> ofResult = Optional.of(mock(EntityReference.class));
    when(instance.existingRelationshipReference()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult2);
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.operation()).thenReturn(UploadOperation.ADD);
    ImmutableResolvedReference.Json json = new ImmutableResolvedReference.Json();
    when(instance.legalEntityReference()).thenReturn(json);
    ImmutableResolvedReference.Json json2 = new ImmutableResolvedReference.Json();
    when(instance.targetEntityReference()).thenReturn(json2);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).errors();
    verify(instance).existingRelationshipReference();
    verify(instance).legalEntityReference();
    verify(instance).operation();
    verify(instance).targetEntityReference();
    ImmutableResolvedLegalEntityRelationship buildResult = builderResult.build();
    assertEquals(UploadOperation.ADD, buildResult.operation());
    assertSame(json, buildResult.legalEntityReference());
    assertSame(json2, buildResult.targetEntityReference());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ResolvedLegalEntityRelationship)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ResolvedLegalEntityRelationship)}
   */
  @Test
  @DisplayName("Test Builder from(ResolvedLegalEntityRelationship); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ResolvedLegalEntityRelationship)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();
    ResolvedLegalEntityRelationship instance = mock(ResolvedLegalEntityRelationship.class);
    when(instance.existingRelationshipReference()).thenThrow(new IllegalStateException("instance"));
    Optional<String> ofResult = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult);
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.operation()).thenReturn(UploadOperation.ADD);
    when(instance.legalEntityReference()).thenReturn(new ImmutableResolvedReference.Json());
    when(instance.targetEntityReference()).thenReturn(new ImmutableResolvedReference.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).comment();
    verify(instance).errors();
    verify(instance).existingRelationshipReference();
    verify(instance).legalEntityReference();
    verify(instance).operation();
    verify(instance).targetEntityReference();
  }

  /**
   * Test Builder {@link Builder#legalEntityReference(ResolvedReference)}.
   * <ul>
   *   <li>When {@link ImmutableResolvedReference.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#legalEntityReference(ResolvedReference)}
   */
  @Test
  @DisplayName("Test Builder legalEntityReference(ResolvedReference); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.legalEntityReference(ResolvedReference)"})
  void testBuilderLegalEntityReference_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.legalEntityReference(new ImmutableResolvedReference.Json()));
  }

  /**
   * Test Builder {@link Builder#operation(UploadOperation)}.
   * <p>
   * Method under test: {@link Builder#operation(UploadOperation)}
   */
  @Test
  @DisplayName("Test Builder operation(UploadOperation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.operation(UploadOperation)"})
  void testBuilderOperation() {
    // Arrange
    Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operation(UploadOperation.ADD));
  }

  /**
   * Test Builder {@link Builder#targetEntityReference(ResolvedReference)}.
   * <ul>
   *   <li>When {@link ImmutableResolvedReference.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#targetEntityReference(ResolvedReference)}
   */
  @Test
  @DisplayName("Test Builder targetEntityReference(ResolvedReference); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.targetEntityReference(ResolvedReference)"})
  void testBuilderTargetEntityReference_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetEntityReference(new ImmutableResolvedReference.Json()));
  }

  /**
   * Test Json {@link Json#comment()}.
   * <p>
   * Method under test: {@link Json#comment()}
   */
  @Test
  @DisplayName("Test Json comment()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.comment()"})
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).comment());
  }

  /**
   * Test Json {@link Json#errors()}.
   * <p>
   * Method under test: {@link Json#errors()}
   */
  @Test
  @DisplayName("Test Json errors()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.errors()"})
  void testJsonErrors() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).errors());
  }

  /**
   * Test Json {@link Json#existingRelationshipReference()}.
   * <p>
   * Method under test: {@link Json#existingRelationshipReference()}
   */
  @Test
  @DisplayName("Test Json existingRelationshipReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.existingRelationshipReference()"})
  void testJsonExistingRelationshipReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).existingRelationshipReference());
  }

  /**
   * Test Json {@link Json#legalEntityReference()}.
   * <p>
   * Method under test: {@link Json#legalEntityReference()}
   */
  @Test
  @DisplayName("Test Json legalEntityReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResolvedReference Json.legalEntityReference()"})
  void testJsonLegalEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).legalEntityReference());
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
    assertNull(actualJson.legalEntityReference);
    assertNull(actualJson.targetEntityReference);
    assertNull(actualJson.operation);
    assertFalse(actualJson.comment.isPresent());
    assertFalse(actualJson.existingRelationshipReference.isPresent());
    assertTrue(actualJson.errors.isEmpty());
  }

  /**
   * Test Json {@link Json#operation()}.
   * <p>
   * Method under test: {@link Json#operation()}
   */
  @Test
  @DisplayName("Test Json operation()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UploadOperation Json.operation()"})
  void testJsonOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).operation());
  }

  /**
   * Test Json {@link Json#targetEntityReference()}.
   * <p>
   * Method under test: {@link Json#targetEntityReference()}
   */
  @Test
  @DisplayName("Test Json targetEntityReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResolvedReference Json.targetEntityReference()"})
  void testJsonTargetEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).targetEntityReference());
  }
}
