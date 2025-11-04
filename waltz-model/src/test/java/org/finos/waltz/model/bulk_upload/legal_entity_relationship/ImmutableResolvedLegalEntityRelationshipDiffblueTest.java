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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableResolvedLegalEntityRelationshipDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship.Builder#addAllErrors(Iterable)}
   */
  @Test
  void testBuilderAddAllErrors() {
    // Arrange
    ImmutableResolvedLegalEntityRelationship.Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllErrors(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship.Builder#addAllErrors(Iterable)}
   */
  @Test
  void testBuilderAddAllErrors2() {
    // Arrange
    ImmutableResolvedLegalEntityRelationship.Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();
    builderResult.existingRelationshipReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAllErrors(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship.Builder#addErrors(LegalEntityRelationshipResolutionError)}
   */
  @Test
  void testBuilderAddErrors() {
    // Arrange
    ImmutableResolvedLegalEntityRelationship.Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(new ImmutableLegalEntityRelationshipResolutionError.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship.Builder#addErrors(LegalEntityRelationshipResolutionError)}
   */
  @Test
  void testBuilderAddErrors2() {
    // Arrange
    ImmutableResolvedLegalEntityRelationship.Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();
    builderResult.existingRelationshipReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(new ImmutableLegalEntityRelationshipResolutionError.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship.Builder#addErrors(LegalEntityRelationshipResolutionError[])}
   */
  @Test
  void testBuilderAddErrors3() {
    // Arrange
    ImmutableResolvedLegalEntityRelationship.Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(new ImmutableLegalEntityRelationshipResolutionError.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship.Builder#addErrors(LegalEntityRelationshipResolutionError[])}
   */
  @Test
  void testBuilderAddErrors4() {
    // Arrange
    ImmutableResolvedLegalEntityRelationship.Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();
    builderResult.existingRelationshipReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(new ImmutableLegalEntityRelationshipResolutionError.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship.Builder#comment(Optional)}
   */
  @Test
  void testBuilderComment() {
    // Arrange
    ImmutableResolvedLegalEntityRelationship.Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();
    Optional<String> comment = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.comment(comment));
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship.Builder#comment(Optional)}
   */
  @Test
  void testBuilderComment2() {
    // Arrange
    ImmutableResolvedLegalEntityRelationship.Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();
    builderResult.existingRelationshipReference(mock(EntityReference.class));
    Optional<String> comment = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.comment(comment));
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship.Builder#errors(Iterable)}
   */
  @Test
  void testBuilderErrors() {
    // Arrange
    ImmutableResolvedLegalEntityRelationship.Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.errors(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship.Builder#errors(Iterable)}
   */
  @Test
  void testBuilderErrors2() {
    // Arrange
    ImmutableResolvedLegalEntityRelationship.Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();
    builderResult.existingRelationshipReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.errors(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship.Builder#from(ResolvedLegalEntityRelationship)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableResolvedLegalEntityRelationship.Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();
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
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship.Builder#from(ResolvedLegalEntityRelationship)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableResolvedLegalEntityRelationship.Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();
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
    ImmutableResolvedLegalEntityRelationship.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship.Builder#from(ResolvedLegalEntityRelationship)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableResolvedLegalEntityRelationship.Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();
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
    ImmutableResolvedLegalEntityRelationship.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship.Builder#from(ResolvedLegalEntityRelationship)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableResolvedLegalEntityRelationship.Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();
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
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship.Builder#from(ResolvedLegalEntityRelationship)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableResolvedLegalEntityRelationship.Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();

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
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship.Builder#legalEntityReference(ResolvedReference)}
   */
  @Test
  void testBuilderLegalEntityReference() {
    // Arrange
    ImmutableResolvedLegalEntityRelationship.Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.legalEntityReference(new ImmutableResolvedReference.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship.Builder#legalEntityReference(ResolvedReference)}
   */
  @Test
  void testBuilderLegalEntityReference2() {
    // Arrange
    ImmutableResolvedLegalEntityRelationship.Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();
    builderResult.existingRelationshipReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.legalEntityReference(new ImmutableResolvedReference.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship.Builder#operation(UploadOperation)}
   */
  @Test
  void testBuilderOperation() {
    // Arrange
    ImmutableResolvedLegalEntityRelationship.Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operation(UploadOperation.ADD));
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship.Builder#operation(UploadOperation)}
   */
  @Test
  void testBuilderOperation2() {
    // Arrange
    ImmutableResolvedLegalEntityRelationship.Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();
    builderResult.existingRelationshipReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.operation(UploadOperation.ADD));
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship.Builder#targetEntityReference(ResolvedReference)}
   */
  @Test
  void testBuilderTargetEntityReference() {
    // Arrange
    ImmutableResolvedLegalEntityRelationship.Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetEntityReference(new ImmutableResolvedReference.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship.Builder#targetEntityReference(ResolvedReference)}
   */
  @Test
  void testBuilderTargetEntityReference2() {
    // Arrange
    ImmutableResolvedLegalEntityRelationship.Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();
    builderResult.existingRelationshipReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.targetEntityReference(new ImmutableResolvedReference.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship#copyOf(ResolvedLegalEntityRelationship)}
   */
  @Test
  void testCopyOf() {
    // Arrange
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
    ImmutableResolvedLegalEntityRelationship actualCopyOfResult = ImmutableResolvedLegalEntityRelationship
        .copyOf(instance);

    // Assert
    verify(instance).comment();
    verify(instance).errors();
    verify(instance).existingRelationshipReference();
    verify(instance).legalEntityReference();
    verify(instance).operation();
    verify(instance).targetEntityReference();
    assertEquals(UploadOperation.ADD, actualCopyOfResult.operation());
    assertTrue(actualCopyOfResult.errors().isEmpty());
    assertSame(json, actualCopyOfResult.legalEntityReference());
    assertSame(json2, actualCopyOfResult.targetEntityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship#copyOf(ResolvedLegalEntityRelationship)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
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
    ImmutableResolvedLegalEntityRelationship actualCopyOfResult = ImmutableResolvedLegalEntityRelationship
        .copyOf(instance);

    // Assert
    verify(instance).comment();
    verify(instance).errors();
    verify(instance).existingRelationshipReference();
    verify(instance).legalEntityReference();
    verify(instance).operation();
    verify(instance).targetEntityReference();
    assertEquals(UploadOperation.ADD, actualCopyOfResult.operation());
    assertTrue(actualCopyOfResult.errors().isEmpty());
    assertSame(json, actualCopyOfResult.legalEntityReference());
    assertSame(json2, actualCopyOfResult.targetEntityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship#copyOf(ResolvedLegalEntityRelationship)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ResolvedLegalEntityRelationship instance = mock(ResolvedLegalEntityRelationship.class);
    Optional<EntityReference> ofResult = Optional.of(mock(EntityReference.class));
    when(instance.existingRelationshipReference()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.comment()).thenReturn(emptyResult);
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.operation()).thenReturn(UploadOperation.ADD);
    ImmutableResolvedReference.Json json = new ImmutableResolvedReference.Json();
    when(instance.legalEntityReference()).thenReturn(json);
    ImmutableResolvedReference.Json json2 = new ImmutableResolvedReference.Json();
    when(instance.targetEntityReference()).thenReturn(json2);

    // Act
    ImmutableResolvedLegalEntityRelationship actualCopyOfResult = ImmutableResolvedLegalEntityRelationship
        .copyOf(instance);

    // Assert
    verify(instance).comment();
    verify(instance).errors();
    verify(instance).existingRelationshipReference();
    verify(instance).legalEntityReference();
    verify(instance).operation();
    verify(instance).targetEntityReference();
    assertEquals(UploadOperation.ADD, actualCopyOfResult.operation());
    assertTrue(actualCopyOfResult.errors().isEmpty());
    assertSame(json, actualCopyOfResult.legalEntityReference());
    assertSame(json2, actualCopyOfResult.targetEntityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship#copyOf(ResolvedLegalEntityRelationship)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<LegalEntityRelationshipResolutionError> legalEntityRelationshipResolutionErrorSet = new HashSet<>();
    legalEntityRelationshipResolutionErrorSet.add(new ImmutableLegalEntityRelationshipResolutionError.Json());
    ResolvedLegalEntityRelationship instance = mock(ResolvedLegalEntityRelationship.class);
    Optional<EntityReference> ofResult = Optional.of(mock(EntityReference.class));
    when(instance.existingRelationshipReference()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult2);
    when(instance.errors()).thenReturn(legalEntityRelationshipResolutionErrorSet);
    when(instance.operation()).thenReturn(UploadOperation.ADD);
    ImmutableResolvedReference.Json json = new ImmutableResolvedReference.Json();
    when(instance.legalEntityReference()).thenReturn(json);
    ImmutableResolvedReference.Json json2 = new ImmutableResolvedReference.Json();
    when(instance.targetEntityReference()).thenReturn(json2);

    // Act
    ImmutableResolvedLegalEntityRelationship actualCopyOfResult = ImmutableResolvedLegalEntityRelationship
        .copyOf(instance);

    // Assert
    verify(instance).comment();
    verify(instance).errors();
    verify(instance).existingRelationshipReference();
    verify(instance).legalEntityReference();
    verify(instance).operation();
    verify(instance).targetEntityReference();
    assertEquals(1, actualCopyOfResult.errors().size());
    assertEquals(UploadOperation.ADD, actualCopyOfResult.operation());
    assertSame(json, actualCopyOfResult.legalEntityReference());
    assertSame(json2, actualCopyOfResult.targetEntityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship#copyOf(ResolvedLegalEntityRelationship)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    HashSet<LegalEntityRelationshipResolutionError> legalEntityRelationshipResolutionErrorSet = new HashSet<>();
    legalEntityRelationshipResolutionErrorSet.add(new ImmutableLegalEntityRelationshipResolutionError.Json());
    legalEntityRelationshipResolutionErrorSet.add(new ImmutableLegalEntityRelationshipResolutionError.Json());
    ResolvedLegalEntityRelationship instance = mock(ResolvedLegalEntityRelationship.class);
    Optional<EntityReference> ofResult = Optional.of(mock(EntityReference.class));
    when(instance.existingRelationshipReference()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult2);
    when(instance.errors()).thenReturn(legalEntityRelationshipResolutionErrorSet);
    when(instance.operation()).thenReturn(UploadOperation.ADD);
    ImmutableResolvedReference.Json json = new ImmutableResolvedReference.Json();
    when(instance.legalEntityReference()).thenReturn(json);
    ImmutableResolvedReference.Json json2 = new ImmutableResolvedReference.Json();
    when(instance.targetEntityReference()).thenReturn(json2);

    // Act
    ImmutableResolvedLegalEntityRelationship actualCopyOfResult = ImmutableResolvedLegalEntityRelationship
        .copyOf(instance);

    // Assert
    verify(instance).comment();
    verify(instance).errors();
    verify(instance).existingRelationshipReference();
    verify(instance).legalEntityReference();
    verify(instance).operation();
    verify(instance).targetEntityReference();
    assertEquals(UploadOperation.ADD, actualCopyOfResult.operation());
    assertEquals(legalEntityRelationshipResolutionErrorSet, actualCopyOfResult.errors());
    assertSame(json, actualCopyOfResult.legalEntityReference());
    assertSame(json2, actualCopyOfResult.targetEntityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship#fromJson(ImmutableResolvedLegalEntityRelationship.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableResolvedLegalEntityRelationship.Json json = new ImmutableResolvedLegalEntityRelationship.Json();
    ImmutableResolvedReference.Json targetEntityReference = new ImmutableResolvedReference.Json();
    json.setTargetEntityReference(targetEntityReference);
    ImmutableResolvedReference.Json legalEntityReference = new ImmutableResolvedReference.Json();
    json.setLegalEntityReference(legalEntityReference);
    json.setComment(null);
    json.setErrors(null);
    json.setOperation(UploadOperation.ADD);
    json.setExistingRelationshipReference(null);

    // Act
    ImmutableResolvedLegalEntityRelationship actualFromJsonResult = ImmutableResolvedLegalEntityRelationship
        .fromJson(json);

    // Assert
    assertEquals(UploadOperation.ADD, actualFromJsonResult.operation());
    assertTrue(actualFromJsonResult.errors().isEmpty());
    assertSame(legalEntityReference, actualFromJsonResult.legalEntityReference());
    assertSame(targetEntityReference, actualFromJsonResult.targetEntityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship.Json#comment()}
   */
  @Test
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableResolvedLegalEntityRelationship.Json()).comment());
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship.Json#errors()}
   */
  @Test
  void testJsonErrors() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableResolvedLegalEntityRelationship.Json()).errors());
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship.Json#existingRelationshipReference()}
   */
  @Test
  void testJsonExistingRelationshipReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableResolvedLegalEntityRelationship.Json()).existingRelationshipReference());
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship.Json#legalEntityReference()}
   */
  @Test
  void testJsonLegalEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableResolvedLegalEntityRelationship.Json()).legalEntityReference());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableResolvedLegalEntityRelationship.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableResolvedLegalEntityRelationship.Json actualJson = new ImmutableResolvedLegalEntityRelationship.Json();

    // Assert
    assertNull(actualJson.legalEntityReference);
    assertNull(actualJson.targetEntityReference);
    assertNull(actualJson.operation);
    assertFalse(actualJson.comment.isPresent());
    assertFalse(actualJson.existingRelationshipReference.isPresent());
    assertTrue(actualJson.errors.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship.Json#operation()}
   */
  @Test
  void testJsonOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableResolvedLegalEntityRelationship.Json()).operation());
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedLegalEntityRelationship.Json#targetEntityReference()}
   */
  @Test
  void testJsonTargetEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableResolvedLegalEntityRelationship.Json()).targetEntityReference());
  }
}
