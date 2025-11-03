package org.finos.waltz.model.assessment_rating.bulk_upload;

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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmentRatingValidatedItem.Builder;
import org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmentRatingValidatedItem.Json;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingValidatedItemDiffblueTest {
  /**
   * Test {@link ImmutableAssessmentRatingValidatedItem#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingValidatedItem#builder()}
   *   <li>{@link ImmutableAssessmentRatingValidatedItem#entityKindReference(EntityReference)}
   *   <li>{@link ImmutableAssessmentRatingValidatedItem#ratingSchemeItem(RatingSchemeItem)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAssessmentRatingValidatedItem Builder.build()",
      "Builder Builder.entityKindReference(EntityReference)", "Builder Builder.ratingSchemeItem(RatingSchemeItem)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualEntityKindReferenceResult = ImmutableAssessmentRatingValidatedItem.builder()
        .entityKindReference(null);

    // Assert
    assertSame(actualEntityKindReferenceResult, actualEntityKindReferenceResult.ratingSchemeItem(null));
  }

  /**
   * Test Builder {@link Builder#addAllChangedFields(Iterable)}.
   * <ul>
   *   <li>Given {@code ENTITY}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code ENTITY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllChangedFields(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllChangedFields(Iterable); given 'ENTITY'; when LinkedHashSet() add 'ENTITY'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllChangedFields(Iterable)"})
  void testBuilderAddAllChangedFields_givenEntity_whenLinkedHashSetAddEntity() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    LinkedHashSet<ChangedFieldType> elements = new LinkedHashSet<>();
    elements.add(ChangedFieldType.ENTITY);

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
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChangedFields(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllErrors(Iterable)}.
   * <ul>
   *   <li>Given {@code ENTITY_KIND_NOT_FOUND}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllErrors(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllErrors(Iterable); given 'ENTITY_KIND_NOT_FOUND'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllErrors(Iterable)"})
  void testBuilderAddAllErrors_givenEntityKindNotFound() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.ENTITY_KIND_NOT_FOUND);

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
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

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
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChangedFields(ChangedFieldType.ENTITY));
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
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChangedFields(ChangedFieldType.ENTITY));
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
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(ValidationError.ENTITY_KIND_NOT_FOUND));
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
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(ValidationError.ENTITY_KIND_NOT_FOUND));
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
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changeOperation(ChangeOperation.ADD));
  }

  /**
   * Test Builder {@link Builder#changedFields(Iterable)}.
   * <ul>
   *   <li>Given {@code ENTITY}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code ENTITY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#changedFields(Iterable)}
   */
  @Test
  @DisplayName("Test Builder changedFields(Iterable); given 'ENTITY'; when LinkedHashSet() add 'ENTITY'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.changedFields(Iterable)"})
  void testBuilderChangedFields_givenEntity_whenLinkedHashSetAddEntity() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    LinkedHashSet<ChangedFieldType> elements = new LinkedHashSet<>();
    elements.add(ChangedFieldType.ENTITY);

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
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changedFields(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#errors(Iterable)}.
   * <ul>
   *   <li>Given {@code ENTITY_KIND_NOT_FOUND}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code ENTITY_KIND_NOT_FOUND}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#errors(Iterable)}
   */
  @Test
  @DisplayName("Test Builder errors(Iterable); given 'ENTITY_KIND_NOT_FOUND'; when LinkedHashSet() add 'ENTITY_KIND_NOT_FOUND'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.errors(Iterable)"})
  void testBuilderErrors_givenEntityKindNotFound_whenLinkedHashSetAddEntityKindNotFound() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.ENTITY_KIND_NOT_FOUND);

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
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.errors(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingValidatedItem)}.
   * <ul>
   *   <li>Given {@link EntityReference}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingValidatedItem); given EntityReference")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingValidatedItem)"})
  void testBuilderFrom_givenEntityReference() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();
    AssessmentRatingValidatedItem instance = mock(AssessmentRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.entityKindReference()).thenReturn(mock(EntityReference.class));
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    when(instance.parsedItem()).thenReturn(new ImmutableAssessmentRatingParsedItem.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).entityKindReference();
    verify(instance).errors();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    ImmutableAssessmentRatingValidatedItem buildResult = actualFromResult.build();
    assertNull(buildResult.ratingSchemeItem());
    ImmutableAssessmentRatingValidatedItem buildResult2 = builderResult.build();
    assertNull(buildResult2.ratingSchemeItem());
    assertTrue(buildResult.changedFields().isEmpty());
    assertTrue(buildResult2.changedFields().isEmpty());
    assertTrue(buildResult.errors().isEmpty());
    assertTrue(buildResult2.errors().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingValidatedItem)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ENTITY_KIND_NOT_FOUND}.</li>
   *   <li>Then return build errors size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingValidatedItem); given HashSet() add 'ENTITY_KIND_NOT_FOUND'; then return build errors size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingValidatedItem)"})
  void testBuilderFrom_givenHashSetAddEntityKindNotFound_thenReturnBuildErrorsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    HashSet<ValidationError> validationErrorSet = new HashSet<>();
    validationErrorSet.add(ValidationError.ENTITY_KIND_NOT_FOUND);
    AssessmentRatingValidatedItem instance = mock(AssessmentRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(validationErrorSet);
    when(instance.entityKindReference()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    when(instance.parsedItem()).thenReturn(new ImmutableAssessmentRatingParsedItem.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).entityKindReference();
    verify(instance).errors();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    Set<ValidationError> errorsResult = actualFromResult.build().errors();
    assertEquals(1, errorsResult.size());
    Set<ValidationError> errorsResult2 = builderResult.build().errors();
    assertEquals(1, errorsResult2.size());
    assertTrue(errorsResult.contains(ValidationError.ENTITY_KIND_NOT_FOUND));
    assertTrue(errorsResult2.contains(ValidationError.ENTITY_KIND_NOT_FOUND));
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingValidatedItem)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ENTITY}.</li>
   *   <li>Then return build changedFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingValidatedItem); given HashSet() add 'ENTITY'; then return build changedFields size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingValidatedItem)"})
  void testBuilderFrom_givenHashSetAddEntity_thenReturnBuildChangedFieldsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    HashSet<ChangedFieldType> changedFieldTypeSet = new HashSet<>();
    changedFieldTypeSet.add(ChangedFieldType.ENTITY);
    AssessmentRatingValidatedItem instance = mock(AssessmentRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(changedFieldTypeSet);
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.entityKindReference()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    when(instance.parsedItem()).thenReturn(new ImmutableAssessmentRatingParsedItem.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).entityKindReference();
    verify(instance).errors();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    Set<ChangedFieldType> changedFieldsResult = actualFromResult.build().changedFields();
    assertEquals(1, changedFieldsResult.size());
    Set<ChangedFieldType> changedFieldsResult2 = builderResult.build().changedFields();
    assertEquals(1, changedFieldsResult2.size());
    assertTrue(changedFieldsResult.contains(ChangedFieldType.ENTITY));
    assertTrue(changedFieldsResult2.contains(ChangedFieldType.ENTITY));
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingValidatedItem)}.
   * <ul>
   *   <li>Given {@link RatingSchemeItem}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingValidatedItem); given RatingSchemeItem")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingValidatedItem)"})
  void testBuilderFrom_givenRatingSchemeItem() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();
    AssessmentRatingValidatedItem instance = mock(AssessmentRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.entityKindReference()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(mock(RatingSchemeItem.class));
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    when(instance.parsedItem()).thenReturn(new ImmutableAssessmentRatingParsedItem.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).entityKindReference();
    verify(instance).errors();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    ImmutableAssessmentRatingValidatedItem buildResult = actualFromResult.build();
    assertNull(buildResult.entityKindReference());
    ImmutableAssessmentRatingValidatedItem buildResult2 = builderResult.build();
    assertNull(buildResult2.entityKindReference());
    assertTrue(buildResult.changedFields().isEmpty());
    assertTrue(buildResult2.changedFields().isEmpty());
    assertTrue(buildResult.errors().isEmpty());
    assertTrue(buildResult2.errors().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingValidatedItem)}.
   * <ul>
   *   <li>Then return build entityKindReference is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingValidatedItem); then return build entityKindReference is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingValidatedItem)"})
  void testBuilderFrom_thenReturnBuildEntityKindReferenceIsNull() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();
    AssessmentRatingValidatedItem instance = mock(AssessmentRatingValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.entityKindReference()).thenReturn(null);
    when(instance.ratingSchemeItem()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    when(instance.parsedItem()).thenReturn(new ImmutableAssessmentRatingParsedItem.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).entityKindReference();
    verify(instance).errors();
    verify(instance).parsedItem();
    verify(instance).ratingSchemeItem();
    ImmutableAssessmentRatingValidatedItem buildResult = actualFromResult.build();
    assertNull(buildResult.entityKindReference());
    ImmutableAssessmentRatingValidatedItem buildResult2 = builderResult.build();
    assertNull(buildResult2.entityKindReference());
    assertNull(buildResult.ratingSchemeItem());
    assertNull(buildResult2.ratingSchemeItem());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingValidatedItem)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingValidatedItem); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingValidatedItem)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();
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
   * Test Builder {@link Builder#parsedItem(AssessmentRatingParsedItem)}.
   * <ul>
   *   <li>When {@link ImmutableAssessmentRatingParsedItem.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#parsedItem(AssessmentRatingParsedItem)}
   */
  @Test
  @DisplayName("Test Builder parsedItem(AssessmentRatingParsedItem); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parsedItem(AssessmentRatingParsedItem)"})
  void testBuilderParsedItem_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parsedItem(new ImmutableAssessmentRatingParsedItem.Json()));
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
   * Test Json {@link Json#entityKindReference()}.
   * <p>
   * Method under test: {@link Json#entityKindReference()}
   */
  @Test
  @DisplayName("Test Json entityKindReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.entityKindReference()"})
  void testJsonEntityKindReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityKindReference());
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
    assertNull(actualJson.entityKindReference);
    assertNull(actualJson.parsedItem);
    assertNull(actualJson.changeOperation);
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
  @MethodsUnderTest({"AssessmentRatingParsedItem Json.parsedItem()"})
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
