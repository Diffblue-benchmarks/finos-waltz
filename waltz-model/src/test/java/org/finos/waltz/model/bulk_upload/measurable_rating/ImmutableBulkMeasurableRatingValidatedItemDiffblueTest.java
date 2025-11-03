package org.finos.waltz.model.bulk_upload.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.allocation_scheme.AllocationScheme;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingValidatedItem.Builder;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingValidatedItem.Json;
import org.finos.waltz.model.measurable.Measurable;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkMeasurableRatingValidatedItemDiffblueTest {
  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkMeasurableRatingValidatedItem#builder()}
   *   <li>{@link ImmutableBulkMeasurableRatingValidatedItem#allocationScheme(AllocationScheme)}
   *   <li>{@link ImmutableBulkMeasurableRatingValidatedItem#application(Application)}
   *   <li>{@link ImmutableBulkMeasurableRatingValidatedItem#measurable(Measurable)}
   *   <li>{@link ImmutableBulkMeasurableRatingValidatedItem#ratingSchemeItem(RatingSchemeItem)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.allocationScheme(AllocationScheme)", "Builder Builder.application(Application)",
      "ImmutableBulkMeasurableRatingValidatedItem Builder.build()", "Builder Builder.measurable(Measurable)",
      "Builder Builder.ratingSchemeItem(RatingSchemeItem)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualMeasurableResult = ImmutableBulkMeasurableRatingValidatedItem.builder()
        .allocationScheme(null)
        .application(null)
        .measurable(null);

    // Assert
    assertSame(actualMeasurableResult, actualMeasurableResult.ratingSchemeItem(null));
  }

  /**
   * Test Builder {@link Builder#addAllChangedFields(Iterable)}.
   * <ul>
   *   <li>Given {@code RATING}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code RATING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllChangedFields(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllChangedFields(Iterable); given 'RATING'; when LinkedHashSet() add 'RATING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllChangedFields(Iterable)"})
  void testBuilderAddAllChangedFields_givenRating_whenLinkedHashSetAddRating() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    LinkedHashSet<ChangedFieldType> elements = new LinkedHashSet<>();
    elements.add(ChangedFieldType.RATING);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChangedFields(elements));
  }

  /**
   * Test Builder {@link Builder#addAllChangedFields(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllChangedFields(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllChangedFields(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllChangedFields(Iterable)"})
  void testBuilderAddAllChangedFields_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChangedFields(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllErrors(Iterable)}.
   * <ul>
   *   <li>Given {@code MEASURABLE_NOT_FOUND}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllErrors(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllErrors(Iterable); given 'MEASURABLE_NOT_FOUND'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllErrors(Iterable)"})
  void testBuilderAddAllErrors_givenMeasurableNotFound() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.MEASURABLE_NOT_FOUND);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllErrors(elements));
  }

  /**
   * Test Builder {@link Builder#addAllErrors(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllErrors(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllErrors(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllErrors(Iterable)"})
  void testBuilderAddAllErrors_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllErrors(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addChangedFields(ChangedFieldType)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addChangedFields(ChangedFieldType)}
   */
  @Test
  @DisplayName("Test Builder addChangedFields(ChangedFieldType) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addChangedFields(ChangedFieldType)"})
  void testBuilderAddChangedFieldsWithElement() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChangedFields(ChangedFieldType.RATING));
  }

  /**
   * Test Builder {@link Builder#addChangedFields(ChangedFieldType[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addChangedFields(ChangedFieldType[])}
   */
  @Test
  @DisplayName("Test Builder addChangedFields(ChangedFieldType[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addChangedFields(ChangedFieldType[])"})
  void testBuilderAddChangedFieldsWithElements() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChangedFields(ChangedFieldType.RATING));
  }

  /**
   * Test Builder {@link Builder#addErrors(ValidationError)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addErrors(ValidationError)}
   */
  @Test
  @DisplayName("Test Builder addErrors(ValidationError) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addErrors(ValidationError)"})
  void testBuilderAddErrorsWithElement() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(ValidationError.MEASURABLE_NOT_FOUND));
  }

  /**
   * Test Builder {@link Builder#addErrors(ValidationError[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addErrors(ValidationError[])}
   */
  @Test
  @DisplayName("Test Builder addErrors(ValidationError[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addErrors(ValidationError[])"})
  void testBuilderAddErrorsWithElements() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(ValidationError.MEASURABLE_NOT_FOUND));
  }

  /**
   * Test Builder {@link Builder#changeOperation(ChangeOperation)}.
   * <p>
   * Method under test: {@link Builder#changeOperation(ChangeOperation)}
   */
  @Test
  @DisplayName("Test Builder changeOperation(ChangeOperation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.changeOperation(ChangeOperation)"})
  void testBuilderChangeOperation() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changeOperation(ChangeOperation.ADD));
  }

  /**
   * Test Builder {@link Builder#changedFields(Iterable)}.
   * <ul>
   *   <li>Given {@code RATING}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code RATING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#changedFields(Iterable)}
   */
  @Test
  @DisplayName("Test Builder changedFields(Iterable); given 'RATING'; when LinkedHashSet() add 'RATING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.changedFields(Iterable)"})
  void testBuilderChangedFields_givenRating_whenLinkedHashSetAddRating() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    LinkedHashSet<ChangedFieldType> elements = new LinkedHashSet<>();
    elements.add(ChangedFieldType.RATING);

    // Act and Assert
    assertSame(builderResult, builderResult.changedFields(elements));
  }

  /**
   * Test Builder {@link Builder#changedFields(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#changedFields(Iterable)}
   */
  @Test
  @DisplayName("Test Builder changedFields(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.changedFields(Iterable)"})
  void testBuilderChangedFields_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changedFields(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#errors(Iterable)}.
   * <ul>
   *   <li>Given {@code MEASURABLE_NOT_FOUND}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code MEASURABLE_NOT_FOUND}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#errors(Iterable)}
   */
  @Test
  @DisplayName("Test Builder errors(Iterable); given 'MEASURABLE_NOT_FOUND'; when LinkedHashSet() add 'MEASURABLE_NOT_FOUND'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.errors(Iterable)"})
  void testBuilderErrors_givenMeasurableNotFound_whenLinkedHashSetAddMeasurableNotFound() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.MEASURABLE_NOT_FOUND);

    // Act and Assert
    assertSame(builderResult, builderResult.errors(elements));
  }

  /**
   * Test Builder {@link Builder#errors(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#errors(Iterable)}
   */
  @Test
  @DisplayName("Test Builder errors(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.errors(Iterable)"})
  void testBuilderErrors_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.errors(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingValidatedItem)}.
   * <ul>
   *   <li>Given {@link AllocationScheme}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingValidatedItem); given AllocationScheme")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingValidatedItem)"})
  void testBuilderFrom_givenAllocationScheme() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();
    BulkMeasurableRatingValidatedItem instance = mock(BulkMeasurableRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.allocationScheme()).thenReturn(mock(AllocationScheme.class));
    when(instance.application()).thenReturn(null);
    when(instance.measurable()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    when(instance.parsedItem()).thenReturn(new ImmutableBulkMeasurableRatingItem.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationScheme();
    verify(instance).application();
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).measurable();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    ImmutableBulkMeasurableRatingValidatedItem buildResult = actualFromResult.build();
    assertNull(buildResult.application());
    ImmutableBulkMeasurableRatingValidatedItem buildResult2 = builderResult.build();
    assertNull(buildResult2.application());
    assertNull(buildResult.measurable());
    assertNull(buildResult2.measurable());
    assertNull(buildResult.ratingSchemeItem());
    assertNull(buildResult2.ratingSchemeItem());
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingValidatedItem)}.
   * <ul>
   *   <li>Given {@link Application}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingValidatedItem); given Application")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingValidatedItem)"})
  void testBuilderFrom_givenApplication() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();
    BulkMeasurableRatingValidatedItem instance = mock(BulkMeasurableRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.allocationScheme()).thenReturn(null);
    when(instance.application()).thenReturn(mock(Application.class));
    when(instance.measurable()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    when(instance.parsedItem()).thenReturn(new ImmutableBulkMeasurableRatingItem.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationScheme();
    verify(instance).application();
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).measurable();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    ImmutableBulkMeasurableRatingValidatedItem buildResult = actualFromResult.build();
    assertNull(buildResult.allocationScheme());
    ImmutableBulkMeasurableRatingValidatedItem buildResult2 = builderResult.build();
    assertNull(buildResult2.allocationScheme());
    assertNull(buildResult.measurable());
    assertNull(buildResult2.measurable());
    assertNull(buildResult.ratingSchemeItem());
    assertNull(buildResult2.ratingSchemeItem());
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingValidatedItem)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code MEASURABLE_NOT_FOUND}.</li>
   *   <li>Then return build errors size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingValidatedItem); given HashSet() add 'MEASURABLE_NOT_FOUND'; then return build errors size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingValidatedItem)"})
  void testBuilderFrom_givenHashSetAddMeasurableNotFound_thenReturnBuildErrorsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

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
    when(instance.parsedItem()).thenReturn(new ImmutableBulkMeasurableRatingItem.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationScheme();
    verify(instance).application();
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).measurable();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    Set<ValidationError> errorsResult = actualFromResult.build().errors();
    assertEquals(1, errorsResult.size());
    Set<ValidationError> errorsResult2 = builderResult.build().errors();
    assertEquals(1, errorsResult2.size());
    assertTrue(errorsResult.contains(ValidationError.MEASURABLE_NOT_FOUND));
    assertTrue(errorsResult2.contains(ValidationError.MEASURABLE_NOT_FOUND));
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingValidatedItem)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code RATING}.</li>
   *   <li>Then return build changedFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingValidatedItem); given HashSet() add 'RATING'; then return build changedFields size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingValidatedItem)"})
  void testBuilderFrom_givenHashSetAddRating_thenReturnBuildChangedFieldsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

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
    when(instance.parsedItem()).thenReturn(new ImmutableBulkMeasurableRatingItem.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationScheme();
    verify(instance).application();
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).measurable();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    Set<ChangedFieldType> changedFieldsResult = actualFromResult.build().changedFields();
    assertEquals(1, changedFieldsResult.size());
    Set<ChangedFieldType> changedFieldsResult2 = builderResult.build().changedFields();
    assertEquals(1, changedFieldsResult2.size());
    assertTrue(changedFieldsResult.contains(ChangedFieldType.RATING));
    assertTrue(changedFieldsResult2.contains(ChangedFieldType.RATING));
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingValidatedItem)}.
   * <ul>
   *   <li>Given {@link Measurable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingValidatedItem); given Measurable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingValidatedItem)"})
  void testBuilderFrom_givenMeasurable() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();
    BulkMeasurableRatingValidatedItem instance = mock(BulkMeasurableRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.allocationScheme()).thenReturn(null);
    when(instance.application()).thenReturn(null);
    when(instance.measurable()).thenReturn(mock(Measurable.class));
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    when(instance.parsedItem()).thenReturn(new ImmutableBulkMeasurableRatingItem.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationScheme();
    verify(instance).application();
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).measurable();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    ImmutableBulkMeasurableRatingValidatedItem buildResult = actualFromResult.build();
    assertNull(buildResult.allocationScheme());
    ImmutableBulkMeasurableRatingValidatedItem buildResult2 = builderResult.build();
    assertNull(buildResult2.allocationScheme());
    assertNull(buildResult.application());
    assertNull(buildResult2.application());
    assertNull(buildResult.ratingSchemeItem());
    assertNull(buildResult2.ratingSchemeItem());
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingValidatedItem)}.
   * <ul>
   *   <li>Given {@link RatingSchemeItem}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingValidatedItem); given RatingSchemeItem")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingValidatedItem)"})
  void testBuilderFrom_givenRatingSchemeItem() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();
    BulkMeasurableRatingValidatedItem instance = mock(BulkMeasurableRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.allocationScheme()).thenReturn(null);
    when(instance.application()).thenReturn(null);
    when(instance.measurable()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(mock(RatingSchemeItem.class));
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    when(instance.parsedItem()).thenReturn(new ImmutableBulkMeasurableRatingItem.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationScheme();
    verify(instance).application();
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).measurable();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    ImmutableBulkMeasurableRatingValidatedItem buildResult = actualFromResult.build();
    assertNull(buildResult.allocationScheme());
    ImmutableBulkMeasurableRatingValidatedItem buildResult2 = builderResult.build();
    assertNull(buildResult2.allocationScheme());
    assertNull(buildResult.application());
    assertNull(buildResult2.application());
    assertNull(buildResult.measurable());
    assertNull(buildResult2.measurable());
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingValidatedItem)}.
   * <ul>
   *   <li>Then return build allocationScheme is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingValidatedItem); then return build allocationScheme is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingValidatedItem)"})
  void testBuilderFrom_thenReturnBuildAllocationSchemeIsNull() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();
    BulkMeasurableRatingValidatedItem instance = mock(BulkMeasurableRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.allocationScheme()).thenReturn(null);
    when(instance.application()).thenReturn(null);
    when(instance.measurable()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    when(instance.parsedItem()).thenReturn(new ImmutableBulkMeasurableRatingItem.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationScheme();
    verify(instance).application();
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).measurable();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    ImmutableBulkMeasurableRatingValidatedItem buildResult = actualFromResult.build();
    assertNull(buildResult.allocationScheme());
    ImmutableBulkMeasurableRatingValidatedItem buildResult2 = builderResult.build();
    assertNull(buildResult2.allocationScheme());
    assertNull(buildResult.application());
    assertNull(buildResult2.application());
    assertNull(buildResult.measurable());
    assertNull(buildResult2.measurable());
    assertNull(buildResult.ratingSchemeItem());
    assertNull(buildResult2.ratingSchemeItem());
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingValidatedItem)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingValidatedItem); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingValidatedItem)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();
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
   * Test Builder {@link Builder#parsedItem(BulkMeasurableRatingItem)}.
   * <ul>
   *   <li>When {@link ImmutableBulkMeasurableRatingItem.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#parsedItem(BulkMeasurableRatingItem)}
   */
  @Test
  @DisplayName("Test Builder parsedItem(BulkMeasurableRatingItem); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parsedItem(BulkMeasurableRatingItem)"})
  void testBuilderParsedItem_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parsedItem(new ImmutableBulkMeasurableRatingItem.Json()));
  }

  /**
   * Test Json {@link Json#allocationScheme()}.
   * <p>
   * Method under test: {@link Json#allocationScheme()}
   */
  @Test
  @DisplayName("Test Json allocationScheme()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AllocationScheme Json.allocationScheme()"})
  void testJsonAllocationScheme() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).allocationScheme());
  }

  /**
   * Test Json {@link Json#application()}.
   * <p>
   * Method under test: {@link Json#application()}
   */
  @Test
  @DisplayName("Test Json application()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Application Json.application()"})
  void testJsonApplication() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).application());
  }

  /**
   * Test Json {@link Json#changeOperation()}.
   * <p>
   * Method under test: {@link Json#changeOperation()}
   */
  @Test
  @DisplayName("Test Json changeOperation()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ChangeOperation Json.changeOperation()"})
  void testJsonChangeOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).changeOperation());
  }

  /**
   * Test Json {@link Json#changedFields()}.
   * <p>
   * Method under test: {@link Json#changedFields()}
   */
  @Test
  @DisplayName("Test Json changedFields()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.changedFields()"})
  void testJsonChangedFields() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).changedFields());
  }

  /**
   * Test Json {@link Json#errors()}.
   * <p>
   * Method under test: {@link Json#errors()}
   */
  @Test
  @DisplayName("Test Json errors()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.errors()"})
  void testJsonErrors() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).errors());
  }

  /**
   * Test Json {@link Json#measurable()}.
   * <p>
   * Method under test: {@link Json#measurable()}
   */
  @Test
  @DisplayName("Test Json measurable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Measurable Json.measurable()"})
  void testJsonMeasurable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).measurable());
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
   * Test Json {@link Json#parsedItem()}.
   * <p>
   * Method under test: {@link Json#parsedItem()}
   */
  @Test
  @DisplayName("Test Json parsedItem()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkMeasurableRatingItem Json.parsedItem()"})
  void testJsonParsedItem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).parsedItem());
  }

  /**
   * Test Json {@link Json#ratingSchemeItem()}.
   * <p>
   * Method under test: {@link Json#ratingSchemeItem()}
   */
  @Test
  @DisplayName("Test Json ratingSchemeItem()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RatingSchemeItem Json.ratingSchemeItem()"})
  void testJsonRatingSchemeItem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratingSchemeItem());
  }
}
