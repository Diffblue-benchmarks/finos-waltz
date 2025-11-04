package org.finos.waltz.model.bulk_upload.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableBulkUploadRelationshipValidatedItemDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipValidatedItem#builder()}
   *   <li>{@link ImmutableBulkUploadRelationshipValidatedItem#description(String)}
   *   <li>
   * {@link ImmutableBulkUploadRelationshipValidatedItem#sourceEntityRef(EntityReference)}
   *   <li>
   * {@link ImmutableBulkUploadRelationshipValidatedItem#targetEntityRef(EntityReference)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableBulkUploadRelationshipValidatedItem.Builder actualDescriptionResult = ImmutableBulkUploadRelationshipValidatedItem
        .builder()
        .description("The characteristics of someone or something");
    ImmutableBulkUploadRelationshipValidatedItem.Builder actualSourceEntityRefResult = actualDescriptionResult
        .error(new ArrayList<>())
        .sourceEntityRef(null);

    // Assert
    assertSame(actualSourceEntityRefResult, actualSourceEntityRefResult.targetEntityRef(null));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Builder#addAllError(Iterable)}
   */
  @Test
  void testBuilderAddAllError() {
    // Arrange
    ImmutableBulkUploadRelationshipValidatedItem.Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllError(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Builder#addAllError(Iterable)}
   */
  @Test
  void testBuilderAddAllError2() {
    // Arrange
    ImmutableBulkUploadRelationshipValidatedItem.Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem
        .builder();
    builderResult.error(null);

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.SOURCE_INVALID);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllError(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Builder#addAllError(Iterable)}
   */
  @Test
  void testBuilderAddAllError3() {
    // Arrange
    ImmutableBulkUploadRelationshipValidatedItem.Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem
        .builder();
    builderResult.error(new ArrayList<>());

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.SOURCE_INVALID);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllError(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Builder#addAllError(Iterable)}
   */
  @Test
  void testBuilderAddAllError4() {
    // Arrange
    ImmutableBulkUploadRelationshipValidatedItem.Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem
        .builder();
    builderResult.sourceEntityRef(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAllError(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Builder#addError(ValidationError)}
   */
  @Test
  void testBuilderAddError() {
    // Arrange
    ImmutableBulkUploadRelationshipValidatedItem.Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addError(ValidationError.SOURCE_INVALID));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Builder#addError(ValidationError)}
   */
  @Test
  void testBuilderAddError2() {
    // Arrange
    ImmutableBulkUploadRelationshipValidatedItem.Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem
        .builder();
    builderResult.error(new ArrayList<>());

    // Act and Assert
    assertSame(builderResult, builderResult.addError(ValidationError.SOURCE_INVALID));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Builder#addError(ValidationError)}
   */
  @Test
  void testBuilderAddError3() {
    // Arrange
    ImmutableBulkUploadRelationshipValidatedItem.Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem
        .builder();
    builderResult.sourceEntityRef(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addError(ValidationError.SOURCE_INVALID));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Builder#addError(ValidationError[])}
   */
  @Test
  void testBuilderAddError4() {
    // Arrange
    ImmutableBulkUploadRelationshipValidatedItem.Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addError(ValidationError.SOURCE_INVALID));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Builder#addError(ValidationError[])}
   */
  @Test
  void testBuilderAddError5() {
    // Arrange
    ImmutableBulkUploadRelationshipValidatedItem.Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem
        .builder();
    builderResult.error(new ArrayList<>());

    // Act and Assert
    assertSame(builderResult, builderResult.addError(ValidationError.SOURCE_INVALID));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Builder#addError(ValidationError[])}
   */
  @Test
  void testBuilderAddError6() {
    // Arrange
    ImmutableBulkUploadRelationshipValidatedItem.Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem
        .builder();
    builderResult.sourceEntityRef(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addError(ValidationError.SOURCE_INVALID));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Builder#error(Iterable)}
   */
  @Test
  void testBuilderError() {
    // Arrange
    ImmutableBulkUploadRelationshipValidatedItem.Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.error(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Builder#error(Iterable)}
   */
  @Test
  void testBuilderError2() {
    // Arrange
    ImmutableBulkUploadRelationshipValidatedItem.Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem
        .builder();
    builderResult.error(null);

    // Act and Assert
    assertSame(builderResult, builderResult.error(null));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Builder#error(Iterable)}
   */
  @Test
  void testBuilderError3() {
    // Arrange
    ImmutableBulkUploadRelationshipValidatedItem.Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem
        .builder();
    builderResult.error(null);

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.SOURCE_INVALID);

    // Act and Assert
    assertSame(builderResult, builderResult.error(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Builder#error(Iterable)}
   */
  @Test
  void testBuilderError4() {
    // Arrange
    ImmutableBulkUploadRelationshipValidatedItem.Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem
        .builder();
    builderResult.sourceEntityRef(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.error(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Builder#from(BulkUploadRelationshipValidatedItem)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBulkUploadRelationshipValidatedItem.Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem
        .builder();
    BulkUploadRelationshipValidatedItem instance = mock(BulkUploadRelationshipValidatedItem.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.error()).thenReturn(new HashSet<>());
    when(instance.sourceEntityRef()).thenReturn(null);
    when(instance.targetEntityRef()).thenReturn(null);
    when(instance.uploadOperation()).thenReturn(UploadOperation.ADD);
    ImmutableBulkUploadRelationshipItem.Json json = new ImmutableBulkUploadRelationshipItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkUploadRelationshipValidatedItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).error();
    verify(instance).parsedItem();
    verify(instance).sourceEntityRef();
    verify(instance).targetEntityRef();
    verify(instance).uploadOperation();
    ImmutableBulkUploadRelationshipValidatedItem buildResult = builderResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.sourceEntityRef());
    assertNull(buildResult.targetEntityRef());
    assertEquals(UploadOperation.ADD, buildResult.uploadOperation());
    assertTrue(buildResult.error().isEmpty());
    assertSame(json, buildResult.parsedItem());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Builder#from(BulkUploadRelationshipValidatedItem)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableBulkUploadRelationshipValidatedItem.Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem
        .builder();
    BulkUploadRelationshipValidatedItem instance = mock(BulkUploadRelationshipValidatedItem.class);
    when(instance.sourceEntityRef()).thenThrow(new IllegalStateException("instance"));
    when(instance.parsedItem()).thenReturn(new ImmutableBulkUploadRelationshipItem.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).parsedItem();
    verify(instance).sourceEntityRef();
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Builder#from(BulkUploadRelationshipValidatedItem)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableBulkUploadRelationshipValidatedItem.Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem
        .builder();
    builderResult.addError(ValidationError.SOURCE_NOT_FOUND);
    BulkUploadRelationshipValidatedItem instance = mock(BulkUploadRelationshipValidatedItem.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.error()).thenReturn(new HashSet<>());
    when(instance.sourceEntityRef()).thenReturn(null);
    when(instance.targetEntityRef()).thenReturn(null);
    when(instance.uploadOperation()).thenReturn(UploadOperation.ADD);
    ImmutableBulkUploadRelationshipItem.Json json = new ImmutableBulkUploadRelationshipItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkUploadRelationshipValidatedItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).error();
    verify(instance).parsedItem();
    verify(instance).sourceEntityRef();
    verify(instance).targetEntityRef();
    verify(instance).uploadOperation();
    ImmutableBulkUploadRelationshipValidatedItem buildResult = builderResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.sourceEntityRef());
    assertNull(buildResult.targetEntityRef());
    Set<ValidationError> errorResult = buildResult.error();
    assertEquals(1, errorResult.size());
    assertEquals(UploadOperation.ADD, buildResult.uploadOperation());
    assertTrue(errorResult.contains(ValidationError.SOURCE_NOT_FOUND));
    assertSame(json, buildResult.parsedItem());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Builder#from(BulkUploadRelationshipValidatedItem)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableBulkUploadRelationshipValidatedItem.Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem
        .builder();
    BulkUploadRelationshipValidatedItem instance = mock(BulkUploadRelationshipValidatedItem.class);
    when(instance.description()).thenReturn(null);
    when(instance.error()).thenReturn(new HashSet<>());
    when(instance.sourceEntityRef()).thenReturn(null);
    when(instance.targetEntityRef()).thenReturn(null);
    when(instance.uploadOperation()).thenReturn(UploadOperation.ADD);
    ImmutableBulkUploadRelationshipItem.Json json = new ImmutableBulkUploadRelationshipItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkUploadRelationshipValidatedItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).error();
    verify(instance).parsedItem();
    verify(instance).sourceEntityRef();
    verify(instance).targetEntityRef();
    verify(instance).uploadOperation();
    ImmutableBulkUploadRelationshipValidatedItem buildResult = builderResult.build();
    assertNull(buildResult.description());
    assertNull(buildResult.sourceEntityRef());
    assertNull(buildResult.targetEntityRef());
    assertEquals(UploadOperation.ADD, buildResult.uploadOperation());
    assertTrue(buildResult.error().isEmpty());
    assertSame(json, buildResult.parsedItem());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Builder#from(BulkUploadRelationshipValidatedItem)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableBulkUploadRelationshipValidatedItem.Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem
        .builder();

    HashSet<ValidationError> validationErrorSet = new HashSet<>();
    validationErrorSet.add(ValidationError.SOURCE_INVALID);
    BulkUploadRelationshipValidatedItem instance = mock(BulkUploadRelationshipValidatedItem.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.error()).thenReturn(validationErrorSet);
    when(instance.sourceEntityRef()).thenReturn(null);
    when(instance.targetEntityRef()).thenReturn(null);
    when(instance.uploadOperation()).thenReturn(UploadOperation.ADD);
    ImmutableBulkUploadRelationshipItem.Json json = new ImmutableBulkUploadRelationshipItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkUploadRelationshipValidatedItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).error();
    verify(instance).parsedItem();
    verify(instance).sourceEntityRef();
    verify(instance).targetEntityRef();
    verify(instance).uploadOperation();
    ImmutableBulkUploadRelationshipValidatedItem buildResult = builderResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.sourceEntityRef());
    assertNull(buildResult.targetEntityRef());
    Set<ValidationError> errorResult = buildResult.error();
    assertEquals(1, errorResult.size());
    assertEquals(UploadOperation.ADD, buildResult.uploadOperation());
    assertTrue(errorResult.contains(ValidationError.SOURCE_INVALID));
    assertSame(json, buildResult.parsedItem());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Builder#from(BulkUploadRelationshipValidatedItem)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableBulkUploadRelationshipValidatedItem.Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem
        .builder();
    BulkUploadRelationshipValidatedItem instance = mock(BulkUploadRelationshipValidatedItem.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.error()).thenReturn(new HashSet<>());
    when(instance.sourceEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.targetEntityRef()).thenReturn(null);
    when(instance.uploadOperation()).thenReturn(UploadOperation.ADD);
    ImmutableBulkUploadRelationshipItem.Json json = new ImmutableBulkUploadRelationshipItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkUploadRelationshipValidatedItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).error();
    verify(instance).parsedItem();
    verify(instance).sourceEntityRef();
    verify(instance).targetEntityRef();
    verify(instance).uploadOperation();
    ImmutableBulkUploadRelationshipValidatedItem buildResult = builderResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.targetEntityRef());
    assertEquals(UploadOperation.ADD, buildResult.uploadOperation());
    assertTrue(buildResult.error().isEmpty());
    assertSame(json, buildResult.parsedItem());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Builder#from(BulkUploadRelationshipValidatedItem)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableBulkUploadRelationshipValidatedItem.Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem
        .builder();
    BulkUploadRelationshipValidatedItem instance = mock(BulkUploadRelationshipValidatedItem.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.error()).thenReturn(new HashSet<>());
    when(instance.sourceEntityRef()).thenReturn(null);
    when(instance.targetEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.uploadOperation()).thenReturn(UploadOperation.ADD);
    ImmutableBulkUploadRelationshipItem.Json json = new ImmutableBulkUploadRelationshipItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkUploadRelationshipValidatedItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).error();
    verify(instance).parsedItem();
    verify(instance).sourceEntityRef();
    verify(instance).targetEntityRef();
    verify(instance).uploadOperation();
    ImmutableBulkUploadRelationshipValidatedItem buildResult = builderResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.sourceEntityRef());
    assertEquals(UploadOperation.ADD, buildResult.uploadOperation());
    assertTrue(buildResult.error().isEmpty());
    assertSame(json, buildResult.parsedItem());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Builder#parsedItem(BulkUploadRelationshipItem)}
   */
  @Test
  void testBuilderParsedItem() {
    // Arrange
    ImmutableBulkUploadRelationshipValidatedItem.Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parsedItem(new ImmutableBulkUploadRelationshipItem.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Builder#parsedItem(BulkUploadRelationshipItem)}
   */
  @Test
  void testBuilderParsedItem2() {
    // Arrange
    ImmutableBulkUploadRelationshipValidatedItem.Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem
        .builder();
    builderResult.sourceEntityRef(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.parsedItem(new ImmutableBulkUploadRelationshipItem.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Builder#uploadOperation(UploadOperation)}
   */
  @Test
  void testBuilderUploadOperation() {
    // Arrange
    ImmutableBulkUploadRelationshipValidatedItem.Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.uploadOperation(UploadOperation.ADD));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Builder#uploadOperation(UploadOperation)}
   */
  @Test
  void testBuilderUploadOperation2() {
    // Arrange
    ImmutableBulkUploadRelationshipValidatedItem.Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem
        .builder();
    builderResult.sourceEntityRef(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.uploadOperation(UploadOperation.ADD));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem#copyOf(BulkUploadRelationshipValidatedItem)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BulkUploadRelationshipValidatedItem instance = mock(BulkUploadRelationshipValidatedItem.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.error()).thenReturn(new HashSet<>());
    when(instance.sourceEntityRef()).thenReturn(null);
    when(instance.targetEntityRef()).thenReturn(null);
    when(instance.uploadOperation()).thenReturn(UploadOperation.ADD);
    ImmutableBulkUploadRelationshipItem.Json json = new ImmutableBulkUploadRelationshipItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkUploadRelationshipValidatedItem actualCopyOfResult = ImmutableBulkUploadRelationshipValidatedItem
        .copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).error();
    verify(instance).parsedItem();
    verify(instance).sourceEntityRef();
    verify(instance).targetEntityRef();
    verify(instance).uploadOperation();
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.sourceEntityRef());
    assertNull(actualCopyOfResult.targetEntityRef());
    assertEquals(UploadOperation.ADD, actualCopyOfResult.uploadOperation());
    assertTrue(actualCopyOfResult.error().isEmpty());
    assertSame(json, actualCopyOfResult.parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem#copyOf(BulkUploadRelationshipValidatedItem)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<ValidationError> validationErrorSet = new HashSet<>();
    validationErrorSet.add(ValidationError.SOURCE_INVALID);
    BulkUploadRelationshipValidatedItem instance = mock(BulkUploadRelationshipValidatedItem.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.error()).thenReturn(validationErrorSet);
    when(instance.sourceEntityRef()).thenReturn(null);
    when(instance.targetEntityRef()).thenReturn(null);
    when(instance.uploadOperation()).thenReturn(UploadOperation.ADD);
    ImmutableBulkUploadRelationshipItem.Json json = new ImmutableBulkUploadRelationshipItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkUploadRelationshipValidatedItem actualCopyOfResult = ImmutableBulkUploadRelationshipValidatedItem
        .copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).error();
    verify(instance).parsedItem();
    verify(instance).sourceEntityRef();
    verify(instance).targetEntityRef();
    verify(instance).uploadOperation();
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.sourceEntityRef());
    assertNull(actualCopyOfResult.targetEntityRef());
    Set<ValidationError> errorResult = actualCopyOfResult.error();
    assertEquals(1, errorResult.size());
    assertEquals(UploadOperation.ADD, actualCopyOfResult.uploadOperation());
    assertTrue(errorResult.contains(ValidationError.SOURCE_INVALID));
    assertSame(json, actualCopyOfResult.parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem#copyOf(BulkUploadRelationshipValidatedItem)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    BulkUploadRelationshipValidatedItem instance = mock(BulkUploadRelationshipValidatedItem.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.error()).thenReturn(new HashSet<>());
    when(instance.sourceEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.targetEntityRef()).thenReturn(null);
    when(instance.uploadOperation()).thenReturn(UploadOperation.ADD);
    ImmutableBulkUploadRelationshipItem.Json json = new ImmutableBulkUploadRelationshipItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkUploadRelationshipValidatedItem actualCopyOfResult = ImmutableBulkUploadRelationshipValidatedItem
        .copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).error();
    verify(instance).parsedItem();
    verify(instance).sourceEntityRef();
    verify(instance).targetEntityRef();
    verify(instance).uploadOperation();
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.targetEntityRef());
    assertEquals(UploadOperation.ADD, actualCopyOfResult.uploadOperation());
    assertTrue(actualCopyOfResult.error().isEmpty());
    assertSame(json, actualCopyOfResult.parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem#copyOf(BulkUploadRelationshipValidatedItem)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    BulkUploadRelationshipValidatedItem instance = mock(BulkUploadRelationshipValidatedItem.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.error()).thenReturn(new HashSet<>());
    when(instance.sourceEntityRef()).thenReturn(null);
    when(instance.targetEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.uploadOperation()).thenReturn(UploadOperation.ADD);
    ImmutableBulkUploadRelationshipItem.Json json = new ImmutableBulkUploadRelationshipItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkUploadRelationshipValidatedItem actualCopyOfResult = ImmutableBulkUploadRelationshipValidatedItem
        .copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).error();
    verify(instance).parsedItem();
    verify(instance).sourceEntityRef();
    verify(instance).targetEntityRef();
    verify(instance).uploadOperation();
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.sourceEntityRef());
    assertEquals(UploadOperation.ADD, actualCopyOfResult.uploadOperation());
    assertTrue(actualCopyOfResult.error().isEmpty());
    assertSame(json, actualCopyOfResult.parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem#fromJson(ImmutableBulkUploadRelationshipValidatedItem.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableBulkUploadRelationshipValidatedItem.Json json = new ImmutableBulkUploadRelationshipValidatedItem.Json();
    ImmutableBulkUploadRelationshipItem.Json parsedItem = new ImmutableBulkUploadRelationshipItem.Json();
    json.setParsedItem(parsedItem);
    json.setSourceEntityRef(null);
    json.setTargetEntityRef(null);
    json.setDescription(null);
    json.setError(null);
    json.setUploadOperation(UploadOperation.ADD);

    // Act
    ImmutableBulkUploadRelationshipValidatedItem actualFromJsonResult = ImmutableBulkUploadRelationshipValidatedItem
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.description());
    assertNull(actualFromJsonResult.error());
    assertNull(actualFromJsonResult.sourceEntityRef());
    assertNull(actualFromJsonResult.targetEntityRef());
    assertEquals(UploadOperation.ADD, actualFromJsonResult.uploadOperation());
    assertSame(parsedItem, actualFromJsonResult.parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem#fromJson(ImmutableBulkUploadRelationshipValidatedItem.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableBulkUploadRelationshipValidatedItem.Json json = new ImmutableBulkUploadRelationshipValidatedItem.Json();
    ImmutableBulkUploadRelationshipItem.Json parsedItem = new ImmutableBulkUploadRelationshipItem.Json();
    json.setParsedItem(parsedItem);
    json.setSourceEntityRef(null);
    json.setTargetEntityRef(null);
    json.setDescription(null);
    json.setError(new HashSet<>());
    json.setUploadOperation(UploadOperation.ADD);

    // Act
    ImmutableBulkUploadRelationshipValidatedItem actualFromJsonResult = ImmutableBulkUploadRelationshipValidatedItem
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.description());
    assertNull(actualFromJsonResult.sourceEntityRef());
    assertNull(actualFromJsonResult.targetEntityRef());
    assertEquals(UploadOperation.ADD, actualFromJsonResult.uploadOperation());
    assertTrue(actualFromJsonResult.error().isEmpty());
    assertSame(parsedItem, actualFromJsonResult.parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUploadRelationshipValidatedItem.Json()).description());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Json#error()}
   */
  @Test
  void testJsonError() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUploadRelationshipValidatedItem.Json()).error());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Json}
   *   <li>
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Json#setDescription(String)}
   *   <li>{@link ImmutableBulkUploadRelationshipValidatedItem.Json#setError(Set)}
   *   <li>
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Json#setParsedItem(BulkUploadRelationshipItem)}
   *   <li>
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Json#setSourceEntityRef(EntityReference)}
   *   <li>
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Json#setTargetEntityRef(EntityReference)}
   *   <li>
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Json#setUploadOperation(UploadOperation)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableBulkUploadRelationshipValidatedItem.Json actualJson = new ImmutableBulkUploadRelationshipValidatedItem.Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setError(new HashSet<>());
    actualJson.setParsedItem(new ImmutableBulkUploadRelationshipItem.Json());
    actualJson.setSourceEntityRef(null);
    actualJson.setTargetEntityRef(null);
    actualJson.setUploadOperation(UploadOperation.ADD);

    // Assert
    assertTrue(actualJson.error.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Json#parsedItem()}
   */
  @Test
  void testJsonParsedItem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUploadRelationshipValidatedItem.Json()).parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Json#sourceEntityRef()}
   */
  @Test
  void testJsonSourceEntityRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUploadRelationshipValidatedItem.Json()).sourceEntityRef());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Json#targetEntityRef()}
   */
  @Test
  void testJsonTargetEntityRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUploadRelationshipValidatedItem.Json()).targetEntityRef());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidatedItem.Json#uploadOperation()}
   */
  @Test
  void testJsonUploadOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUploadRelationshipValidatedItem.Json()).uploadOperation());
  }
}
