package org.finos.waltz.model.bulk_upload.measurable_rating;

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
import org.finos.waltz.model.allocation_scheme.AllocationScheme;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.measurable.Measurable;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.Test;

class ImmutableBulkMeasurableRatingValidatedItemDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkMeasurableRatingValidatedItem#builder()}
   *   <li>
   * {@link ImmutableBulkMeasurableRatingValidatedItem#allocationScheme(AllocationScheme)}
   *   <li>
   * {@link ImmutableBulkMeasurableRatingValidatedItem#application(Application)}
   *   <li>{@link ImmutableBulkMeasurableRatingValidatedItem#measurable(Measurable)}
   *   <li>
   * {@link ImmutableBulkMeasurableRatingValidatedItem#ratingSchemeItem(RatingSchemeItem)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableBulkMeasurableRatingValidatedItem.Builder actualMeasurableResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder()
        .allocationScheme(null)
        .application(null)
        .measurable(null);

    // Assert
    assertSame(actualMeasurableResult, actualMeasurableResult.ratingSchemeItem(null));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#addAllChangedFields(Iterable)}
   */
  @Test
  void testBuilderAddAllChangedFields() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChangedFields(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#addAllChangedFields(Iterable)}
   */
  @Test
  void testBuilderAddAllChangedFields2() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();

    LinkedHashSet<ChangedFieldType> elements = new LinkedHashSet<>();
    elements.add(ChangedFieldType.RATING);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChangedFields(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#addAllChangedFields(Iterable)}
   */
  @Test
  void testBuilderAddAllChangedFields3() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();
    builderResult.application(mock(Application.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChangedFields(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#addAllErrors(Iterable)}
   */
  @Test
  void testBuilderAddAllErrors() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllErrors(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#addAllErrors(Iterable)}
   */
  @Test
  void testBuilderAddAllErrors2() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.MEASURABLE_NOT_FOUND);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllErrors(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#addAllErrors(Iterable)}
   */
  @Test
  void testBuilderAddAllErrors3() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();
    builderResult.application(mock(Application.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAllErrors(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#addChangedFields(ChangedFieldType)}
   */
  @Test
  void testBuilderAddChangedFields() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChangedFields(ChangedFieldType.RATING));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#addChangedFields(ChangedFieldType)}
   */
  @Test
  void testBuilderAddChangedFields2() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();
    builderResult.application(mock(Application.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addChangedFields(ChangedFieldType.RATING));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#addChangedFields(ChangedFieldType[])}
   */
  @Test
  void testBuilderAddChangedFields3() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChangedFields(ChangedFieldType.RATING));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#addChangedFields(ChangedFieldType[])}
   */
  @Test
  void testBuilderAddChangedFields4() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();
    builderResult.application(mock(Application.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addChangedFields(ChangedFieldType.RATING));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#addErrors(ValidationError)}
   */
  @Test
  void testBuilderAddErrors() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(ValidationError.MEASURABLE_NOT_FOUND));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#addErrors(ValidationError)}
   */
  @Test
  void testBuilderAddErrors2() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();
    builderResult.application(mock(Application.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(ValidationError.MEASURABLE_NOT_FOUND));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#addErrors(ValidationError[])}
   */
  @Test
  void testBuilderAddErrors3() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(ValidationError.MEASURABLE_NOT_FOUND));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#addErrors(ValidationError[])}
   */
  @Test
  void testBuilderAddErrors4() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();
    builderResult.application(mock(Application.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(ValidationError.MEASURABLE_NOT_FOUND));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#changeOperation(ChangeOperation)}
   */
  @Test
  void testBuilderChangeOperation() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changeOperation(ChangeOperation.ADD));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#changeOperation(ChangeOperation)}
   */
  @Test
  void testBuilderChangeOperation2() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();
    builderResult.application(mock(Application.class));

    // Act and Assert
    assertSame(builderResult, builderResult.changeOperation(ChangeOperation.ADD));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#changedFields(Iterable)}
   */
  @Test
  void testBuilderChangedFields() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changedFields(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#changedFields(Iterable)}
   */
  @Test
  void testBuilderChangedFields2() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();

    LinkedHashSet<ChangedFieldType> elements = new LinkedHashSet<>();
    elements.add(ChangedFieldType.RATING);

    // Act and Assert
    assertSame(builderResult, builderResult.changedFields(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#changedFields(Iterable)}
   */
  @Test
  void testBuilderChangedFields3() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();
    builderResult.application(mock(Application.class));

    // Act and Assert
    assertSame(builderResult, builderResult.changedFields(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#errors(Iterable)}
   */
  @Test
  void testBuilderErrors() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.errors(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#errors(Iterable)}
   */
  @Test
  void testBuilderErrors2() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.MEASURABLE_NOT_FOUND);

    // Act and Assert
    assertSame(builderResult, builderResult.errors(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#errors(Iterable)}
   */
  @Test
  void testBuilderErrors3() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();
    builderResult.application(mock(Application.class));

    // Act and Assert
    assertSame(builderResult, builderResult.errors(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#from(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();
    BulkMeasurableRatingValidatedItem instance = mock(BulkMeasurableRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.allocationScheme()).thenReturn(null);
    when(instance.application()).thenReturn(null);
    when(instance.measurable()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableBulkMeasurableRatingItem.Json json = new ImmutableBulkMeasurableRatingItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkMeasurableRatingValidatedItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationScheme();
    verify(instance).application();
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).measurable();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    ImmutableBulkMeasurableRatingValidatedItem buildResult = builderResult.build();
    assertNull(buildResult.allocationScheme());
    assertNull(buildResult.application());
    assertNull(buildResult.measurable());
    assertNull(buildResult.ratingSchemeItem());
    assertEquals(ChangeOperation.ADD, buildResult.changeOperation());
    assertTrue(buildResult.changedFields().isEmpty());
    assertTrue(buildResult.errors().isEmpty());
    assertSame(json, buildResult.parsedItem());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#from(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();
    BulkMeasurableRatingValidatedItem instance = mock(BulkMeasurableRatingValidatedItem.class);
    when(instance.changedFields()).thenThrow(new IllegalStateException("instance"));
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    when(instance.parsedItem()).thenReturn(new ImmutableBulkMeasurableRatingItem.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).parsedItem();
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#from(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();

    HashSet<ChangedFieldType> changedFieldTypeSet = new HashSet<>();
    changedFieldTypeSet.add(ChangedFieldType.RATING);
    BulkMeasurableRatingValidatedItem instance = mock(BulkMeasurableRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(changedFieldTypeSet);
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.allocationScheme()).thenReturn(null);
    when(instance.application()).thenReturn(null);
    when(instance.measurable()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableBulkMeasurableRatingItem.Json json = new ImmutableBulkMeasurableRatingItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkMeasurableRatingValidatedItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationScheme();
    verify(instance).application();
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).measurable();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    ImmutableBulkMeasurableRatingValidatedItem buildResult = builderResult.build();
    assertNull(buildResult.allocationScheme());
    assertNull(buildResult.application());
    assertNull(buildResult.measurable());
    assertNull(buildResult.ratingSchemeItem());
    Set<ChangedFieldType> changedFieldsResult = buildResult.changedFields();
    assertEquals(1, changedFieldsResult.size());
    assertEquals(ChangeOperation.ADD, buildResult.changeOperation());
    assertTrue(changedFieldsResult.contains(ChangedFieldType.RATING));
    assertTrue(buildResult.errors().isEmpty());
    assertSame(json, buildResult.parsedItem());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#from(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();

    HashSet<ValidationError> validationErrorSet = new HashSet<>();
    validationErrorSet.add(ValidationError.MEASURABLE_NOT_FOUND);
    BulkMeasurableRatingValidatedItem instance = mock(BulkMeasurableRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(validationErrorSet);
    when(instance.allocationScheme()).thenReturn(null);
    when(instance.application()).thenReturn(null);
    when(instance.measurable()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableBulkMeasurableRatingItem.Json json = new ImmutableBulkMeasurableRatingItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkMeasurableRatingValidatedItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationScheme();
    verify(instance).application();
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).measurable();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    ImmutableBulkMeasurableRatingValidatedItem buildResult = builderResult.build();
    assertNull(buildResult.allocationScheme());
    assertNull(buildResult.application());
    assertNull(buildResult.measurable());
    assertNull(buildResult.ratingSchemeItem());
    Set<ValidationError> errorsResult = buildResult.errors();
    assertEquals(1, errorsResult.size());
    assertEquals(ChangeOperation.ADD, buildResult.changeOperation());
    assertTrue(errorsResult.contains(ValidationError.MEASURABLE_NOT_FOUND));
    assertTrue(buildResult.changedFields().isEmpty());
    assertSame(json, buildResult.parsedItem());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#from(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();
    BulkMeasurableRatingValidatedItem instance = mock(BulkMeasurableRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.allocationScheme()).thenReturn(mock(AllocationScheme.class));
    when(instance.application()).thenReturn(null);
    when(instance.measurable()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableBulkMeasurableRatingItem.Json json = new ImmutableBulkMeasurableRatingItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkMeasurableRatingValidatedItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationScheme();
    verify(instance).application();
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).measurable();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    ImmutableBulkMeasurableRatingValidatedItem buildResult = builderResult.build();
    assertNull(buildResult.application());
    assertNull(buildResult.measurable());
    assertNull(buildResult.ratingSchemeItem());
    assertEquals(ChangeOperation.ADD, buildResult.changeOperation());
    assertTrue(buildResult.changedFields().isEmpty());
    assertTrue(buildResult.errors().isEmpty());
    assertSame(json, buildResult.parsedItem());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#from(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();
    BulkMeasurableRatingValidatedItem instance = mock(BulkMeasurableRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.allocationScheme()).thenReturn(null);
    when(instance.application()).thenReturn(mock(Application.class));
    when(instance.measurable()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableBulkMeasurableRatingItem.Json json = new ImmutableBulkMeasurableRatingItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkMeasurableRatingValidatedItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationScheme();
    verify(instance).application();
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).measurable();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    ImmutableBulkMeasurableRatingValidatedItem buildResult = builderResult.build();
    assertNull(buildResult.allocationScheme());
    assertNull(buildResult.measurable());
    assertNull(buildResult.ratingSchemeItem());
    assertEquals(ChangeOperation.ADD, buildResult.changeOperation());
    assertTrue(buildResult.changedFields().isEmpty());
    assertTrue(buildResult.errors().isEmpty());
    assertSame(json, buildResult.parsedItem());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#from(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();
    BulkMeasurableRatingValidatedItem instance = mock(BulkMeasurableRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.allocationScheme()).thenReturn(null);
    when(instance.application()).thenReturn(null);
    when(instance.measurable()).thenReturn(mock(Measurable.class));
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableBulkMeasurableRatingItem.Json json = new ImmutableBulkMeasurableRatingItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkMeasurableRatingValidatedItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationScheme();
    verify(instance).application();
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).measurable();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    ImmutableBulkMeasurableRatingValidatedItem buildResult = builderResult.build();
    assertNull(buildResult.allocationScheme());
    assertNull(buildResult.application());
    assertNull(buildResult.ratingSchemeItem());
    assertEquals(ChangeOperation.ADD, buildResult.changeOperation());
    assertTrue(buildResult.changedFields().isEmpty());
    assertTrue(buildResult.errors().isEmpty());
    assertSame(json, buildResult.parsedItem());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#from(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();
    BulkMeasurableRatingValidatedItem instance = mock(BulkMeasurableRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.allocationScheme()).thenReturn(null);
    when(instance.application()).thenReturn(null);
    when(instance.measurable()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(mock(RatingSchemeItem.class));
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableBulkMeasurableRatingItem.Json json = new ImmutableBulkMeasurableRatingItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkMeasurableRatingValidatedItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationScheme();
    verify(instance).application();
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).measurable();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    ImmutableBulkMeasurableRatingValidatedItem buildResult = builderResult.build();
    assertNull(buildResult.allocationScheme());
    assertNull(buildResult.application());
    assertNull(buildResult.measurable());
    assertEquals(ChangeOperation.ADD, buildResult.changeOperation());
    assertTrue(buildResult.changedFields().isEmpty());
    assertTrue(buildResult.errors().isEmpty());
    assertSame(json, buildResult.parsedItem());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#parsedItem(BulkMeasurableRatingItem)}
   */
  @Test
  void testBuilderParsedItem() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parsedItem(new ImmutableBulkMeasurableRatingItem.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Builder#parsedItem(BulkMeasurableRatingItem)}
   */
  @Test
  void testBuilderParsedItem2() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem
        .builder();
    builderResult.application(mock(Application.class));

    // Act and Assert
    assertSame(builderResult, builderResult.parsedItem(new ImmutableBulkMeasurableRatingItem.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem#copyOf(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BulkMeasurableRatingValidatedItem instance = mock(BulkMeasurableRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.allocationScheme()).thenReturn(null);
    when(instance.application()).thenReturn(null);
    when(instance.measurable()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableBulkMeasurableRatingItem.Json json = new ImmutableBulkMeasurableRatingItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkMeasurableRatingValidatedItem actualCopyOfResult = ImmutableBulkMeasurableRatingValidatedItem
        .copyOf(instance);

    // Assert
    verify(instance).allocationScheme();
    verify(instance).application();
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).measurable();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    assertNull(actualCopyOfResult.allocationScheme());
    assertNull(actualCopyOfResult.application());
    assertNull(actualCopyOfResult.measurable());
    assertNull(actualCopyOfResult.ratingSchemeItem());
    assertEquals(ChangeOperation.ADD, actualCopyOfResult.changeOperation());
    assertTrue(actualCopyOfResult.changedFields().isEmpty());
    assertTrue(actualCopyOfResult.errors().isEmpty());
    assertSame(json, actualCopyOfResult.parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem#copyOf(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<ChangedFieldType> changedFieldTypeSet = new HashSet<>();
    changedFieldTypeSet.add(ChangedFieldType.RATING);
    BulkMeasurableRatingValidatedItem instance = mock(BulkMeasurableRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(changedFieldTypeSet);
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.allocationScheme()).thenReturn(null);
    when(instance.application()).thenReturn(null);
    when(instance.measurable()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableBulkMeasurableRatingItem.Json json = new ImmutableBulkMeasurableRatingItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkMeasurableRatingValidatedItem actualCopyOfResult = ImmutableBulkMeasurableRatingValidatedItem
        .copyOf(instance);

    // Assert
    verify(instance).allocationScheme();
    verify(instance).application();
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).measurable();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    assertNull(actualCopyOfResult.allocationScheme());
    assertNull(actualCopyOfResult.application());
    assertNull(actualCopyOfResult.measurable());
    assertNull(actualCopyOfResult.ratingSchemeItem());
    Set<ChangedFieldType> changedFieldsResult = actualCopyOfResult.changedFields();
    assertEquals(1, changedFieldsResult.size());
    assertEquals(ChangeOperation.ADD, actualCopyOfResult.changeOperation());
    assertTrue(changedFieldsResult.contains(ChangedFieldType.RATING));
    assertTrue(actualCopyOfResult.errors().isEmpty());
    assertSame(json, actualCopyOfResult.parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem#copyOf(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<ValidationError> validationErrorSet = new HashSet<>();
    validationErrorSet.add(ValidationError.MEASURABLE_NOT_FOUND);
    BulkMeasurableRatingValidatedItem instance = mock(BulkMeasurableRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(validationErrorSet);
    when(instance.allocationScheme()).thenReturn(null);
    when(instance.application()).thenReturn(null);
    when(instance.measurable()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableBulkMeasurableRatingItem.Json json = new ImmutableBulkMeasurableRatingItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkMeasurableRatingValidatedItem actualCopyOfResult = ImmutableBulkMeasurableRatingValidatedItem
        .copyOf(instance);

    // Assert
    verify(instance).allocationScheme();
    verify(instance).application();
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).measurable();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    assertNull(actualCopyOfResult.allocationScheme());
    assertNull(actualCopyOfResult.application());
    assertNull(actualCopyOfResult.measurable());
    assertNull(actualCopyOfResult.ratingSchemeItem());
    Set<ValidationError> errorsResult = actualCopyOfResult.errors();
    assertEquals(1, errorsResult.size());
    assertEquals(ChangeOperation.ADD, actualCopyOfResult.changeOperation());
    assertTrue(errorsResult.contains(ValidationError.MEASURABLE_NOT_FOUND));
    assertTrue(actualCopyOfResult.changedFields().isEmpty());
    assertSame(json, actualCopyOfResult.parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem#copyOf(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    BulkMeasurableRatingValidatedItem instance = mock(BulkMeasurableRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.allocationScheme()).thenReturn(mock(AllocationScheme.class));
    when(instance.application()).thenReturn(null);
    when(instance.measurable()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableBulkMeasurableRatingItem.Json json = new ImmutableBulkMeasurableRatingItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkMeasurableRatingValidatedItem actualCopyOfResult = ImmutableBulkMeasurableRatingValidatedItem
        .copyOf(instance);

    // Assert
    verify(instance).allocationScheme();
    verify(instance).application();
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).measurable();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    assertNull(actualCopyOfResult.application());
    assertNull(actualCopyOfResult.measurable());
    assertNull(actualCopyOfResult.ratingSchemeItem());
    assertEquals(ChangeOperation.ADD, actualCopyOfResult.changeOperation());
    assertTrue(actualCopyOfResult.changedFields().isEmpty());
    assertTrue(actualCopyOfResult.errors().isEmpty());
    assertSame(json, actualCopyOfResult.parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem#copyOf(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    BulkMeasurableRatingValidatedItem instance = mock(BulkMeasurableRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.allocationScheme()).thenReturn(null);
    when(instance.application()).thenReturn(mock(Application.class));
    when(instance.measurable()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableBulkMeasurableRatingItem.Json json = new ImmutableBulkMeasurableRatingItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkMeasurableRatingValidatedItem actualCopyOfResult = ImmutableBulkMeasurableRatingValidatedItem
        .copyOf(instance);

    // Assert
    verify(instance).allocationScheme();
    verify(instance).application();
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).measurable();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    assertNull(actualCopyOfResult.allocationScheme());
    assertNull(actualCopyOfResult.measurable());
    assertNull(actualCopyOfResult.ratingSchemeItem());
    assertEquals(ChangeOperation.ADD, actualCopyOfResult.changeOperation());
    assertTrue(actualCopyOfResult.changedFields().isEmpty());
    assertTrue(actualCopyOfResult.errors().isEmpty());
    assertSame(json, actualCopyOfResult.parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem#copyOf(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    BulkMeasurableRatingValidatedItem instance = mock(BulkMeasurableRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.allocationScheme()).thenReturn(null);
    when(instance.application()).thenReturn(null);
    when(instance.measurable()).thenReturn(mock(Measurable.class));
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableBulkMeasurableRatingItem.Json json = new ImmutableBulkMeasurableRatingItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkMeasurableRatingValidatedItem actualCopyOfResult = ImmutableBulkMeasurableRatingValidatedItem
        .copyOf(instance);

    // Assert
    verify(instance).allocationScheme();
    verify(instance).application();
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).measurable();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    assertNull(actualCopyOfResult.allocationScheme());
    assertNull(actualCopyOfResult.application());
    assertNull(actualCopyOfResult.ratingSchemeItem());
    assertEquals(ChangeOperation.ADD, actualCopyOfResult.changeOperation());
    assertTrue(actualCopyOfResult.changedFields().isEmpty());
    assertTrue(actualCopyOfResult.errors().isEmpty());
    assertSame(json, actualCopyOfResult.parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem#copyOf(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  void testCopyOf7() {
    // Arrange
    BulkMeasurableRatingValidatedItem instance = mock(BulkMeasurableRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.allocationScheme()).thenReturn(null);
    when(instance.application()).thenReturn(null);
    when(instance.measurable()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(mock(RatingSchemeItem.class));
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    ImmutableBulkMeasurableRatingItem.Json json = new ImmutableBulkMeasurableRatingItem.Json();
    when(instance.parsedItem()).thenReturn(json);

    // Act
    ImmutableBulkMeasurableRatingValidatedItem actualCopyOfResult = ImmutableBulkMeasurableRatingValidatedItem
        .copyOf(instance);

    // Assert
    verify(instance).allocationScheme();
    verify(instance).application();
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).measurable();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    assertNull(actualCopyOfResult.allocationScheme());
    assertNull(actualCopyOfResult.application());
    assertNull(actualCopyOfResult.measurable());
    assertEquals(ChangeOperation.ADD, actualCopyOfResult.changeOperation());
    assertTrue(actualCopyOfResult.changedFields().isEmpty());
    assertTrue(actualCopyOfResult.errors().isEmpty());
    assertSame(json, actualCopyOfResult.parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem#fromJson(ImmutableBulkMeasurableRatingValidatedItem.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableBulkMeasurableRatingValidatedItem.Json json = new ImmutableBulkMeasurableRatingValidatedItem.Json();
    json.setChangeOperation(ChangeOperation.ADD);
    ImmutableBulkMeasurableRatingItem.Json parsedItem = new ImmutableBulkMeasurableRatingItem.Json();
    json.setParsedItem(parsedItem);

    // Act
    ImmutableBulkMeasurableRatingValidatedItem actualFromJsonResult = ImmutableBulkMeasurableRatingValidatedItem
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.allocationScheme());
    assertNull(actualFromJsonResult.application());
    assertNull(actualFromJsonResult.measurable());
    assertNull(actualFromJsonResult.ratingSchemeItem());
    assertEquals(ChangeOperation.ADD, actualFromJsonResult.changeOperation());
    assertTrue(actualFromJsonResult.changedFields().isEmpty());
    assertTrue(actualFromJsonResult.errors().isEmpty());
    assertSame(parsedItem, actualFromJsonResult.parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Json#allocationScheme()}
   */
  @Test
  void testJsonAllocationScheme() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingValidatedItem.Json()).allocationScheme());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Json#application()}
   */
  @Test
  void testJsonApplication() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingValidatedItem.Json()).application());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Json#changeOperation()}
   */
  @Test
  void testJsonChangeOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingValidatedItem.Json()).changeOperation());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Json#changedFields()}
   */
  @Test
  void testJsonChangedFields() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingValidatedItem.Json()).changedFields());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Json#errors()}
   */
  @Test
  void testJsonErrors() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingValidatedItem.Json()).errors());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Json#measurable()}
   */
  @Test
  void testJsonMeasurable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingValidatedItem.Json()).measurable());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableBulkMeasurableRatingValidatedItem.Json actualJson = new ImmutableBulkMeasurableRatingValidatedItem.Json();

    // Assert
    assertNull(actualJson.allocationScheme);
    assertNull(actualJson.application);
    assertNull(actualJson.parsedItem);
    assertNull(actualJson.changeOperation);
    assertNull(actualJson.measurable);
    assertNull(actualJson.ratingSchemeItem);
    assertTrue(actualJson.changedFields.isEmpty());
    assertTrue(actualJson.errors.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Json#parsedItem()}
   */
  @Test
  void testJsonParsedItem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingValidatedItem.Json()).parsedItem());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidatedItem.Json#ratingSchemeItem()}
   */
  @Test
  void testJsonRatingSchemeItem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingValidatedItem.Json()).ratingSchemeItem());
  }
}
