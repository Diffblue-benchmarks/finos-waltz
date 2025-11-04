package org.finos.waltz.model.assessment_rating.bulk_upload;

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
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingValidatedItemDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingValidatedItem#builder()}
   *   <li>
   * {@link ImmutableAssessmentRatingValidatedItem#entityKindReference(EntityReference)}
   *   <li>
   * {@link ImmutableAssessmentRatingValidatedItem#ratingSchemeItem(RatingSchemeItem)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableAssessmentRatingValidatedItem.Builder actualEntityKindReferenceResult = ImmutableAssessmentRatingValidatedItem
        .builder()
        .entityKindReference(null);

    // Assert
    assertSame(actualEntityKindReferenceResult, actualEntityKindReferenceResult.ratingSchemeItem(null));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#addAllChangedFields(Iterable)}
   */
  @Test
  void testBuilderAddAllChangedFields() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChangedFields(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#addAllChangedFields(Iterable)}
   */
  @Test
  void testBuilderAddAllChangedFields2() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    LinkedHashSet<ChangedFieldType> elements = new LinkedHashSet<>();
    elements.add(ChangedFieldType.ENTITY);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChangedFields(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#addAllChangedFields(Iterable)}
   */
  @Test
  void testBuilderAddAllChangedFields3() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();
    builderResult.ratingSchemeItem(mock(RatingSchemeItem.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChangedFields(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#addAllErrors(Iterable)}
   */
  @Test
  void testBuilderAddAllErrors() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllErrors(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#addAllErrors(Iterable)}
   */
  @Test
  void testBuilderAddAllErrors2() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.ENTITY_KIND_NOT_FOUND);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllErrors(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#addAllErrors(Iterable)}
   */
  @Test
  void testBuilderAddAllErrors3() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();
    builderResult.ratingSchemeItem(mock(RatingSchemeItem.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAllErrors(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#addChangedFields(ChangedFieldType)}
   */
  @Test
  void testBuilderAddChangedFields() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChangedFields(ChangedFieldType.ENTITY));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#addChangedFields(ChangedFieldType)}
   */
  @Test
  void testBuilderAddChangedFields2() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();
    builderResult.ratingSchemeItem(mock(RatingSchemeItem.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addChangedFields(ChangedFieldType.ENTITY));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#addChangedFields(ChangedFieldType[])}
   */
  @Test
  void testBuilderAddChangedFields3() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChangedFields(ChangedFieldType.ENTITY));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#addChangedFields(ChangedFieldType[])}
   */
  @Test
  void testBuilderAddChangedFields4() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();
    builderResult.ratingSchemeItem(mock(RatingSchemeItem.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addChangedFields(ChangedFieldType.ENTITY));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#addErrors(ValidationError)}
   */
  @Test
  void testBuilderAddErrors() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(ValidationError.ENTITY_KIND_NOT_FOUND));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#addErrors(ValidationError)}
   */
  @Test
  void testBuilderAddErrors2() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();
    builderResult.ratingSchemeItem(mock(RatingSchemeItem.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(ValidationError.ENTITY_KIND_NOT_FOUND));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#addErrors(ValidationError[])}
   */
  @Test
  void testBuilderAddErrors3() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(ValidationError.ENTITY_KIND_NOT_FOUND));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#addErrors(ValidationError[])}
   */
  @Test
  void testBuilderAddErrors4() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();
    builderResult.ratingSchemeItem(mock(RatingSchemeItem.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(ValidationError.ENTITY_KIND_NOT_FOUND));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#changeOperation(ChangeOperation)}
   */
  @Test
  void testBuilderChangeOperation() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changeOperation(ChangeOperation.ADD));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#changeOperation(ChangeOperation)}
   */
  @Test
  void testBuilderChangeOperation2() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();
    builderResult.ratingSchemeItem(mock(RatingSchemeItem.class));

    // Act and Assert
    assertSame(builderResult, builderResult.changeOperation(ChangeOperation.ADD));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#changedFields(Iterable)}
   */
  @Test
  void testBuilderChangedFields() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changedFields(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#changedFields(Iterable)}
   */
  @Test
  void testBuilderChangedFields2() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    LinkedHashSet<ChangedFieldType> elements = new LinkedHashSet<>();
    elements.add(ChangedFieldType.ENTITY);

    // Act and Assert
    assertSame(builderResult, builderResult.changedFields(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#changedFields(Iterable)}
   */
  @Test
  void testBuilderChangedFields3() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();
    builderResult.ratingSchemeItem(mock(RatingSchemeItem.class));

    // Act and Assert
    assertSame(builderResult, builderResult.changedFields(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#errors(Iterable)}
   */
  @Test
  void testBuilderErrors() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.errors(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#errors(Iterable)}
   */
  @Test
  void testBuilderErrors2() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.ENTITY_KIND_NOT_FOUND);

    // Act and Assert
    assertSame(builderResult, builderResult.errors(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#errors(Iterable)}
   */
  @Test
  void testBuilderErrors3() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();
    builderResult.ratingSchemeItem(mock(RatingSchemeItem.class));

    // Act and Assert
    assertSame(builderResult, builderResult.errors(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#from(AssessmentRatingValidatedItem)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();
    AssessmentRatingValidatedItem instance = mock(AssessmentRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.entityKindReference()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableAssessmentRatingParsedItem.Json json = new ImmutableAssessmentRatingParsedItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableAssessmentRatingValidatedItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).entityKindReference();
    verify(instance).errors();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    ImmutableAssessmentRatingValidatedItem buildResult = builderResult.build();
    assertNull(buildResult.entityKindReference());
    assertNull(buildResult.ratingSchemeItem());
    assertEquals(ChangeOperation.ADD, buildResult.changeOperation());
    assertTrue(buildResult.changedFields().isEmpty());
    assertTrue(buildResult.errors().isEmpty());
    assertSame(json, buildResult.parsedItem());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#from(AssessmentRatingValidatedItem)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();
    AssessmentRatingValidatedItem instance = mock(AssessmentRatingValidatedItem.class);
    when(instance.changedFields()).thenThrow(new IllegalStateException("instance"));
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    when(instance.parsedItem()).thenReturn(new ImmutableAssessmentRatingParsedItem.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).parsedItem();
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#from(AssessmentRatingValidatedItem)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    HashSet<ChangedFieldType> changedFieldTypeSet = new HashSet<>();
    changedFieldTypeSet.add(ChangedFieldType.ENTITY);
    AssessmentRatingValidatedItem instance = mock(AssessmentRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(changedFieldTypeSet);
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.entityKindReference()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableAssessmentRatingParsedItem.Json json = new ImmutableAssessmentRatingParsedItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableAssessmentRatingValidatedItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).entityKindReference();
    verify(instance).errors();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    ImmutableAssessmentRatingValidatedItem buildResult = builderResult.build();
    assertNull(buildResult.entityKindReference());
    assertNull(buildResult.ratingSchemeItem());
    Set<ChangedFieldType> changedFieldsResult = buildResult.changedFields();
    assertEquals(1, changedFieldsResult.size());
    assertEquals(ChangeOperation.ADD, buildResult.changeOperation());
    assertTrue(changedFieldsResult.contains(ChangedFieldType.ENTITY));
    assertTrue(buildResult.errors().isEmpty());
    assertSame(json, buildResult.parsedItem());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#from(AssessmentRatingValidatedItem)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    HashSet<ValidationError> validationErrorSet = new HashSet<>();
    validationErrorSet.add(ValidationError.ENTITY_KIND_NOT_FOUND);
    AssessmentRatingValidatedItem instance = mock(AssessmentRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(validationErrorSet);
    when(instance.entityKindReference()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableAssessmentRatingParsedItem.Json json = new ImmutableAssessmentRatingParsedItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableAssessmentRatingValidatedItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).entityKindReference();
    verify(instance).errors();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    ImmutableAssessmentRatingValidatedItem buildResult = builderResult.build();
    assertNull(buildResult.entityKindReference());
    assertNull(buildResult.ratingSchemeItem());
    Set<ValidationError> errorsResult = buildResult.errors();
    assertEquals(1, errorsResult.size());
    assertEquals(ChangeOperation.ADD, buildResult.changeOperation());
    assertTrue(errorsResult.contains(ValidationError.ENTITY_KIND_NOT_FOUND));
    assertTrue(buildResult.changedFields().isEmpty());
    assertSame(json, buildResult.parsedItem());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#from(AssessmentRatingValidatedItem)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();
    AssessmentRatingValidatedItem instance = mock(AssessmentRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.entityKindReference()).thenReturn(mock(EntityReference.class));
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableAssessmentRatingParsedItem.Json json = new ImmutableAssessmentRatingParsedItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableAssessmentRatingValidatedItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).entityKindReference();
    verify(instance).errors();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    ImmutableAssessmentRatingValidatedItem buildResult = builderResult.build();
    assertNull(buildResult.ratingSchemeItem());
    assertEquals(ChangeOperation.ADD, buildResult.changeOperation());
    assertTrue(buildResult.changedFields().isEmpty());
    assertTrue(buildResult.errors().isEmpty());
    assertSame(json, buildResult.parsedItem());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#from(AssessmentRatingValidatedItem)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();
    AssessmentRatingValidatedItem instance = mock(AssessmentRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.entityKindReference()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(mock(RatingSchemeItem.class));
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableAssessmentRatingParsedItem.Json json = new ImmutableAssessmentRatingParsedItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableAssessmentRatingValidatedItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).entityKindReference();
    verify(instance).errors();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    ImmutableAssessmentRatingValidatedItem buildResult = builderResult.build();
    assertNull(buildResult.entityKindReference());
    assertEquals(ChangeOperation.ADD, buildResult.changeOperation());
    assertTrue(buildResult.changedFields().isEmpty());
    assertTrue(buildResult.errors().isEmpty());
    assertSame(json, buildResult.parsedItem());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#parsedItem(AssessmentRatingParsedItem)}
   */
  @Test
  void testBuilderParsedItem() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parsedItem(new ImmutableAssessmentRatingParsedItem.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Builder#parsedItem(AssessmentRatingParsedItem)}
   */
  @Test
  void testBuilderParsedItem2() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();
    builderResult.ratingSchemeItem(mock(RatingSchemeItem.class));

    // Act and Assert
    assertSame(builderResult, builderResult.parsedItem(new ImmutableAssessmentRatingParsedItem.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem#copyOf(AssessmentRatingValidatedItem)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssessmentRatingValidatedItem instance = mock(AssessmentRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.entityKindReference()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableAssessmentRatingParsedItem.Json json = new ImmutableAssessmentRatingParsedItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableAssessmentRatingValidatedItem actualCopyOfResult = ImmutableAssessmentRatingValidatedItem.copyOf(instance);

    // Assert
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).entityKindReference();
    verify(instance).errors();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    assertNull(actualCopyOfResult.entityKindReference());
    assertNull(actualCopyOfResult.ratingSchemeItem());
    assertEquals(ChangeOperation.ADD, actualCopyOfResult.changeOperation());
    assertTrue(actualCopyOfResult.changedFields().isEmpty());
    assertTrue(actualCopyOfResult.errors().isEmpty());
    assertSame(json, actualCopyOfResult.parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem#copyOf(AssessmentRatingValidatedItem)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<ChangedFieldType> changedFieldTypeSet = new HashSet<>();
    changedFieldTypeSet.add(ChangedFieldType.ENTITY);
    AssessmentRatingValidatedItem instance = mock(AssessmentRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(changedFieldTypeSet);
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.entityKindReference()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableAssessmentRatingParsedItem.Json json = new ImmutableAssessmentRatingParsedItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableAssessmentRatingValidatedItem actualCopyOfResult = ImmutableAssessmentRatingValidatedItem.copyOf(instance);

    // Assert
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).entityKindReference();
    verify(instance).errors();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    assertNull(actualCopyOfResult.entityKindReference());
    assertNull(actualCopyOfResult.ratingSchemeItem());
    Set<ChangedFieldType> changedFieldsResult = actualCopyOfResult.changedFields();
    assertEquals(1, changedFieldsResult.size());
    assertEquals(ChangeOperation.ADD, actualCopyOfResult.changeOperation());
    assertTrue(changedFieldsResult.contains(ChangedFieldType.ENTITY));
    assertTrue(actualCopyOfResult.errors().isEmpty());
    assertSame(json, actualCopyOfResult.parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem#copyOf(AssessmentRatingValidatedItem)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<ValidationError> validationErrorSet = new HashSet<>();
    validationErrorSet.add(ValidationError.ENTITY_KIND_NOT_FOUND);
    AssessmentRatingValidatedItem instance = mock(AssessmentRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(validationErrorSet);
    when(instance.entityKindReference()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableAssessmentRatingParsedItem.Json json = new ImmutableAssessmentRatingParsedItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableAssessmentRatingValidatedItem actualCopyOfResult = ImmutableAssessmentRatingValidatedItem.copyOf(instance);

    // Assert
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).entityKindReference();
    verify(instance).errors();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    assertNull(actualCopyOfResult.entityKindReference());
    assertNull(actualCopyOfResult.ratingSchemeItem());
    Set<ValidationError> errorsResult = actualCopyOfResult.errors();
    assertEquals(1, errorsResult.size());
    assertEquals(ChangeOperation.ADD, actualCopyOfResult.changeOperation());
    assertTrue(errorsResult.contains(ValidationError.ENTITY_KIND_NOT_FOUND));
    assertTrue(actualCopyOfResult.changedFields().isEmpty());
    assertSame(json, actualCopyOfResult.parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem#copyOf(AssessmentRatingValidatedItem)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    AssessmentRatingValidatedItem instance = mock(AssessmentRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.entityKindReference()).thenReturn(mock(EntityReference.class));
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableAssessmentRatingParsedItem.Json json = new ImmutableAssessmentRatingParsedItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableAssessmentRatingValidatedItem actualCopyOfResult = ImmutableAssessmentRatingValidatedItem.copyOf(instance);

    // Assert
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).entityKindReference();
    verify(instance).errors();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    assertNull(actualCopyOfResult.ratingSchemeItem());
    assertEquals(ChangeOperation.ADD, actualCopyOfResult.changeOperation());
    assertTrue(actualCopyOfResult.changedFields().isEmpty());
    assertTrue(actualCopyOfResult.errors().isEmpty());
    assertSame(json, actualCopyOfResult.parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem#copyOf(AssessmentRatingValidatedItem)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    AssessmentRatingValidatedItem instance = mock(AssessmentRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.entityKindReference()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(mock(RatingSchemeItem.class));
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableAssessmentRatingParsedItem.Json json = new ImmutableAssessmentRatingParsedItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableAssessmentRatingValidatedItem actualCopyOfResult = ImmutableAssessmentRatingValidatedItem.copyOf(instance);

    // Assert
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).entityKindReference();
    verify(instance).errors();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    assertNull(actualCopyOfResult.entityKindReference());
    assertEquals(ChangeOperation.ADD, actualCopyOfResult.changeOperation());
    assertTrue(actualCopyOfResult.changedFields().isEmpty());
    assertTrue(actualCopyOfResult.errors().isEmpty());
    assertSame(json, actualCopyOfResult.parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem#fromJson(ImmutableAssessmentRatingValidatedItem.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAssessmentRatingValidatedItem.Json json = new ImmutableAssessmentRatingValidatedItem.Json();
    ImmutableAssessmentRatingParsedItem.Json parsedItem = new ImmutableAssessmentRatingParsedItem.Json();
    json.setParsedItem(parsedItem);
    json.setChangeOperation(ChangeOperation.ADD);
    json.setChangedFields(null);
    json.setErrors(null);
    json.setRatingSchemeItem(null);
    json.setEntityKindReference(null);

    // Act
    ImmutableAssessmentRatingValidatedItem actualFromJsonResult = ImmutableAssessmentRatingValidatedItem.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.entityKindReference());
    assertNull(actualFromJsonResult.ratingSchemeItem());
    assertEquals(ChangeOperation.ADD, actualFromJsonResult.changeOperation());
    assertTrue(actualFromJsonResult.changedFields().isEmpty());
    assertTrue(actualFromJsonResult.errors().isEmpty());
    assertSame(parsedItem, actualFromJsonResult.parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Json#changeOperation()}
   */
  @Test
  void testJsonChangeOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRatingValidatedItem.Json()).changeOperation());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Json#changedFields()}
   */
  @Test
  void testJsonChangedFields() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRatingValidatedItem.Json()).changedFields());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Json#entityKindReference()}
   */
  @Test
  void testJsonEntityKindReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRatingValidatedItem.Json()).entityKindReference());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Json#errors()}
   */
  @Test
  void testJsonErrors() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRatingValidatedItem.Json()).errors());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAssessmentRatingValidatedItem.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAssessmentRatingValidatedItem.Json actualJson = new ImmutableAssessmentRatingValidatedItem.Json();

    // Assert
    assertNull(actualJson.entityKindReference);
    assertNull(actualJson.parsedItem);
    assertNull(actualJson.changeOperation);
    assertNull(actualJson.ratingSchemeItem);
    assertTrue(actualJson.changedFields.isEmpty());
    assertTrue(actualJson.errors.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Json#parsedItem()}
   */
  @Test
  void testJsonParsedItem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRatingValidatedItem.Json()).parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidatedItem.Json#ratingSchemeItem()}
   */
  @Test
  void testJsonRatingSchemeItem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRatingValidatedItem.Json()).ratingSchemeItem());
  }
}
