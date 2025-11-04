package org.finos.waltz.model.bulk_upload.taxonomy;

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
import org.finos.waltz.model.bulk_upload.ChangeOperation;
import org.junit.jupiter.api.Test;

class ImmutableBulkTaxonomyValidatedItemDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyValidatedItem#builder()}
   *   <li>
   * {@link ImmutableBulkTaxonomyValidatedItem#existingItemReference(EntityReference)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableBulkTaxonomyValidatedItem.Builder actualBuilderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.existingItemReference(null));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#addAllChangedFields(Iterable)}
   */
  @Test
  void testBuilderAddAllChangedFields() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChangedFields(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#addAllChangedFields(Iterable)}
   */
  @Test
  void testBuilderAddAllChangedFields2() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    LinkedHashSet<ChangedFieldType> elements = new LinkedHashSet<>();
    elements.add(ChangedFieldType.NAME);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChangedFields(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#addAllChangedFields(Iterable)}
   */
  @Test
  void testBuilderAddAllChangedFields3() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();
    builderResult.existingItemReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChangedFields(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#addAllErrors(Iterable)}
   */
  @Test
  void testBuilderAddAllErrors() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllErrors(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#addAllErrors(Iterable)}
   */
  @Test
  void testBuilderAddAllErrors2() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.PARENT_NOT_FOUND);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllErrors(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#addAllErrors(Iterable)}
   */
  @Test
  void testBuilderAddAllErrors3() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();
    builderResult.existingItemReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAllErrors(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#addChangedFields(ChangedFieldType)}
   */
  @Test
  void testBuilderAddChangedFields() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChangedFields(ChangedFieldType.NAME));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#addChangedFields(ChangedFieldType)}
   */
  @Test
  void testBuilderAddChangedFields2() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();
    builderResult.existingItemReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addChangedFields(ChangedFieldType.NAME));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#addChangedFields(ChangedFieldType[])}
   */
  @Test
  void testBuilderAddChangedFields3() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChangedFields(ChangedFieldType.NAME));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#addChangedFields(ChangedFieldType[])}
   */
  @Test
  void testBuilderAddChangedFields4() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();
    builderResult.existingItemReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addChangedFields(ChangedFieldType.NAME));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#addErrors(ValidationError)}
   */
  @Test
  void testBuilderAddErrors() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(ValidationError.PARENT_NOT_FOUND));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#addErrors(ValidationError)}
   */
  @Test
  void testBuilderAddErrors2() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();
    builderResult.existingItemReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(ValidationError.PARENT_NOT_FOUND));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#addErrors(ValidationError[])}
   */
  @Test
  void testBuilderAddErrors3() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(ValidationError.PARENT_NOT_FOUND));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#addErrors(ValidationError[])}
   */
  @Test
  void testBuilderAddErrors4() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();
    builderResult.existingItemReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(ValidationError.PARENT_NOT_FOUND));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#changeOperation(ChangeOperation)}
   */
  @Test
  void testBuilderChangeOperation() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changeOperation(ChangeOperation.ADD));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#changeOperation(ChangeOperation)}
   */
  @Test
  void testBuilderChangeOperation2() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();
    builderResult.existingItemReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.changeOperation(ChangeOperation.ADD));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#changedFields(Iterable)}
   */
  @Test
  void testBuilderChangedFields() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changedFields(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#changedFields(Iterable)}
   */
  @Test
  void testBuilderChangedFields2() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    LinkedHashSet<ChangedFieldType> elements = new LinkedHashSet<>();
    elements.add(ChangedFieldType.NAME);

    // Act and Assert
    assertSame(builderResult, builderResult.changedFields(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#changedFields(Iterable)}
   */
  @Test
  void testBuilderChangedFields3() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();
    builderResult.existingItemReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.changedFields(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#errors(Iterable)}
   */
  @Test
  void testBuilderErrors() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.errors(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#errors(Iterable)}
   */
  @Test
  void testBuilderErrors2() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.PARENT_NOT_FOUND);

    // Act and Assert
    assertSame(builderResult, builderResult.errors(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#errors(Iterable)}
   */
  @Test
  void testBuilderErrors3() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();
    builderResult.existingItemReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.errors(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#from(BulkTaxonomyValidatedItem)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();
    BulkTaxonomyValidatedItem instance = mock(BulkTaxonomyValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.existingItemReference()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableBulkTaxonomyItem.Json json = new ImmutableBulkTaxonomyItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkTaxonomyValidatedItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).existingItemReference();
    verify(instance).parsedItem();
    ImmutableBulkTaxonomyValidatedItem buildResult = builderResult.build();
    assertNull(buildResult.existingItemReference());
    assertEquals(ChangeOperation.ADD, buildResult.changeOperation());
    assertTrue(buildResult.changedFields().isEmpty());
    assertTrue(buildResult.errors().isEmpty());
    assertSame(json, buildResult.parsedItem());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#from(BulkTaxonomyValidatedItem)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();
    BulkTaxonomyValidatedItem instance = mock(BulkTaxonomyValidatedItem.class);
    when(instance.changedFields()).thenThrow(new IllegalStateException("instance"));
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    when(instance.parsedItem()).thenReturn(new ImmutableBulkTaxonomyItem.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).parsedItem();
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#from(BulkTaxonomyValidatedItem)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    HashSet<ChangedFieldType> changedFieldTypeSet = new HashSet<>();
    changedFieldTypeSet.add(ChangedFieldType.NAME);
    BulkTaxonomyValidatedItem instance = mock(BulkTaxonomyValidatedItem.class);
    when(instance.changedFields()).thenReturn(changedFieldTypeSet);
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.existingItemReference()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableBulkTaxonomyItem.Json json = new ImmutableBulkTaxonomyItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkTaxonomyValidatedItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).existingItemReference();
    verify(instance).parsedItem();
    ImmutableBulkTaxonomyValidatedItem buildResult = builderResult.build();
    assertNull(buildResult.existingItemReference());
    Set<ChangedFieldType> changedFieldsResult = buildResult.changedFields();
    assertEquals(1, changedFieldsResult.size());
    assertEquals(ChangeOperation.ADD, buildResult.changeOperation());
    assertTrue(changedFieldsResult.contains(ChangedFieldType.NAME));
    assertTrue(buildResult.errors().isEmpty());
    assertSame(json, buildResult.parsedItem());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#from(BulkTaxonomyValidatedItem)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    HashSet<ValidationError> validationErrorSet = new HashSet<>();
    validationErrorSet.add(ValidationError.PARENT_NOT_FOUND);
    BulkTaxonomyValidatedItem instance = mock(BulkTaxonomyValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(validationErrorSet);
    when(instance.existingItemReference()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableBulkTaxonomyItem.Json json = new ImmutableBulkTaxonomyItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkTaxonomyValidatedItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).existingItemReference();
    verify(instance).parsedItem();
    ImmutableBulkTaxonomyValidatedItem buildResult = builderResult.build();
    assertNull(buildResult.existingItemReference());
    Set<ValidationError> errorsResult = buildResult.errors();
    assertEquals(1, errorsResult.size());
    assertEquals(ChangeOperation.ADD, buildResult.changeOperation());
    assertTrue(errorsResult.contains(ValidationError.PARENT_NOT_FOUND));
    assertTrue(buildResult.changedFields().isEmpty());
    assertSame(json, buildResult.parsedItem());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#from(BulkTaxonomyValidatedItem)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();
    BulkTaxonomyValidatedItem instance = mock(BulkTaxonomyValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.existingItemReference()).thenReturn(mock(EntityReference.class));
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableBulkTaxonomyItem.Json json = new ImmutableBulkTaxonomyItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkTaxonomyValidatedItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).existingItemReference();
    verify(instance).parsedItem();
    ImmutableBulkTaxonomyValidatedItem buildResult = builderResult.build();
    assertEquals(ChangeOperation.ADD, buildResult.changeOperation());
    assertTrue(buildResult.changedFields().isEmpty());
    assertTrue(buildResult.errors().isEmpty());
    assertSame(json, buildResult.parsedItem());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#parsedItem(BulkTaxonomyItem)}
   */
  @Test
  void testBuilderParsedItem() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parsedItem(new ImmutableBulkTaxonomyItem.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Builder#parsedItem(BulkTaxonomyItem)}
   */
  @Test
  void testBuilderParsedItem2() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();
    builderResult.existingItemReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.parsedItem(new ImmutableBulkTaxonomyItem.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem#copyOf(BulkTaxonomyValidatedItem)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BulkTaxonomyValidatedItem instance = mock(BulkTaxonomyValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.existingItemReference()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableBulkTaxonomyItem.Json json = new ImmutableBulkTaxonomyItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkTaxonomyValidatedItem actualCopyOfResult = ImmutableBulkTaxonomyValidatedItem.copyOf(instance);

    // Assert
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).existingItemReference();
    verify(instance).parsedItem();
    assertNull(actualCopyOfResult.existingItemReference());
    assertEquals(ChangeOperation.ADD, actualCopyOfResult.changeOperation());
    assertTrue(actualCopyOfResult.changedFields().isEmpty());
    assertTrue(actualCopyOfResult.errors().isEmpty());
    assertSame(json, actualCopyOfResult.parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem#copyOf(BulkTaxonomyValidatedItem)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<ChangedFieldType> changedFieldTypeSet = new HashSet<>();
    changedFieldTypeSet.add(ChangedFieldType.NAME);
    BulkTaxonomyValidatedItem instance = mock(BulkTaxonomyValidatedItem.class);
    when(instance.changedFields()).thenReturn(changedFieldTypeSet);
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.existingItemReference()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableBulkTaxonomyItem.Json json = new ImmutableBulkTaxonomyItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkTaxonomyValidatedItem actualCopyOfResult = ImmutableBulkTaxonomyValidatedItem.copyOf(instance);

    // Assert
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).existingItemReference();
    verify(instance).parsedItem();
    assertNull(actualCopyOfResult.existingItemReference());
    Set<ChangedFieldType> changedFieldsResult = actualCopyOfResult.changedFields();
    assertEquals(1, changedFieldsResult.size());
    assertEquals(ChangeOperation.ADD, actualCopyOfResult.changeOperation());
    assertTrue(changedFieldsResult.contains(ChangedFieldType.NAME));
    assertTrue(actualCopyOfResult.errors().isEmpty());
    assertSame(json, actualCopyOfResult.parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem#copyOf(BulkTaxonomyValidatedItem)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<ValidationError> validationErrorSet = new HashSet<>();
    validationErrorSet.add(ValidationError.PARENT_NOT_FOUND);
    BulkTaxonomyValidatedItem instance = mock(BulkTaxonomyValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(validationErrorSet);
    when(instance.existingItemReference()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableBulkTaxonomyItem.Json json = new ImmutableBulkTaxonomyItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkTaxonomyValidatedItem actualCopyOfResult = ImmutableBulkTaxonomyValidatedItem.copyOf(instance);

    // Assert
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).existingItemReference();
    verify(instance).parsedItem();
    assertNull(actualCopyOfResult.existingItemReference());
    Set<ValidationError> errorsResult = actualCopyOfResult.errors();
    assertEquals(1, errorsResult.size());
    assertEquals(ChangeOperation.ADD, actualCopyOfResult.changeOperation());
    assertTrue(errorsResult.contains(ValidationError.PARENT_NOT_FOUND));
    assertTrue(actualCopyOfResult.changedFields().isEmpty());
    assertSame(json, actualCopyOfResult.parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem#copyOf(BulkTaxonomyValidatedItem)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    BulkTaxonomyValidatedItem instance = mock(BulkTaxonomyValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.existingItemReference()).thenReturn(mock(EntityReference.class));
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableBulkTaxonomyItem.Json json = new ImmutableBulkTaxonomyItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkTaxonomyValidatedItem actualCopyOfResult = ImmutableBulkTaxonomyValidatedItem.copyOf(instance);

    // Assert
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).existingItemReference();
    verify(instance).parsedItem();
    assertEquals(ChangeOperation.ADD, actualCopyOfResult.changeOperation());
    assertTrue(actualCopyOfResult.changedFields().isEmpty());
    assertTrue(actualCopyOfResult.errors().isEmpty());
    assertSame(json, actualCopyOfResult.parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem#fromJson(ImmutableBulkTaxonomyValidatedItem.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableBulkTaxonomyValidatedItem.Json json = new ImmutableBulkTaxonomyValidatedItem.Json();
    ImmutableBulkTaxonomyItem.Json parsedItem = new ImmutableBulkTaxonomyItem.Json();
    json.setParsedItem(parsedItem);
    json.setChangeOperation(ChangeOperation.ADD);
    json.setChangedFields(null);
    json.setErrors(null);
    json.setExistingItemReference(null);

    // Act
    ImmutableBulkTaxonomyValidatedItem actualFromJsonResult = ImmutableBulkTaxonomyValidatedItem.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.existingItemReference());
    assertEquals(ChangeOperation.ADD, actualFromJsonResult.changeOperation());
    assertTrue(actualFromJsonResult.changedFields().isEmpty());
    assertTrue(actualFromJsonResult.errors().isEmpty());
    assertSame(parsedItem, actualFromJsonResult.parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Json#changeOperation()}
   */
  @Test
  void testJsonChangeOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkTaxonomyValidatedItem.Json()).changeOperation());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Json#changedFields()}
   */
  @Test
  void testJsonChangedFields() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkTaxonomyValidatedItem.Json()).changedFields());
  }

  /**
   * Method under test: {@link ImmutableBulkTaxonomyValidatedItem.Json#errors()}
   */
  @Test
  void testJsonErrors() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBulkTaxonomyValidatedItem.Json()).errors());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Json#existingItemReference()}
   */
  @Test
  void testJsonExistingItemReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkTaxonomyValidatedItem.Json()).existingItemReference());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableBulkTaxonomyValidatedItem.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableBulkTaxonomyValidatedItem.Json actualJson = new ImmutableBulkTaxonomyValidatedItem.Json();

    // Assert
    assertNull(actualJson.existingItemReference);
    assertNull(actualJson.changeOperation);
    assertNull(actualJson.parsedItem);
    assertTrue(actualJson.changedFields.isEmpty());
    assertTrue(actualJson.errors.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidatedItem.Json#parsedItem()}
   */
  @Test
  void testJsonParsedItem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkTaxonomyValidatedItem.Json()).parsedItem());
  }
}
