package org.finos.waltz.model.bulk_upload.taxonomy;

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
import org.finos.waltz.model.bulk_upload.ChangeOperation;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyValidatedItem.Builder;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyValidatedItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkTaxonomyValidatedItemDiffblueTest {
  /**
   * Test {@link ImmutableBulkTaxonomyValidatedItem#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyValidatedItem#builder()}
   *   <li>{@link ImmutableBulkTaxonomyValidatedItem#existingItemReference(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkTaxonomyValidatedItem Builder.build()",
      "Builder Builder.existingItemReference(EntityReference)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.existingItemReference(null));
  }

  /**
   * Test Builder {@link Builder#addAllChangedFields(Iterable)}.
   * <ul>
   *   <li>Given {@code NAME}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code NAME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllChangedFields(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllChangedFields(Iterable); given 'NAME'; when LinkedHashSet() add 'NAME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllChangedFields(Iterable)"})
  void testBuilderAddAllChangedFields_givenName_whenLinkedHashSetAddName() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    LinkedHashSet<ChangedFieldType> elements = new LinkedHashSet<>();
    elements.add(ChangedFieldType.NAME);

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
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChangedFields(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllErrors(Iterable)}.
   * <ul>
   *   <li>Given {@code PARENT_NOT_FOUND}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code PARENT_NOT_FOUND}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllErrors(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllErrors(Iterable); given 'PARENT_NOT_FOUND'; when LinkedHashSet() add 'PARENT_NOT_FOUND'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllErrors(Iterable)"})
  void testBuilderAddAllErrors_givenParentNotFound_whenLinkedHashSetAddParentNotFound() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.PARENT_NOT_FOUND);

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
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

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
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChangedFields(ChangedFieldType.NAME));
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
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChangedFields(ChangedFieldType.NAME));
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
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(ValidationError.PARENT_NOT_FOUND));
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
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(ValidationError.PARENT_NOT_FOUND));
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
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changeOperation(ChangeOperation.ADD));
  }

  /**
   * Test Builder {@link Builder#changedFields(Iterable)}.
   * <ul>
   *   <li>Given {@code NAME}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code NAME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#changedFields(Iterable)}
   */
  @Test
  @DisplayName("Test Builder changedFields(Iterable); given 'NAME'; when LinkedHashSet() add 'NAME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.changedFields(Iterable)"})
  void testBuilderChangedFields_givenName_whenLinkedHashSetAddName() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    LinkedHashSet<ChangedFieldType> elements = new LinkedHashSet<>();
    elements.add(ChangedFieldType.NAME);

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
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changedFields(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#errors(Iterable)}.
   * <ul>
   *   <li>Given {@code PARENT_NOT_FOUND}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code PARENT_NOT_FOUND}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#errors(Iterable)}
   */
  @Test
  @DisplayName("Test Builder errors(Iterable); given 'PARENT_NOT_FOUND'; when LinkedHashSet() add 'PARENT_NOT_FOUND'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.errors(Iterable)"})
  void testBuilderErrors_givenParentNotFound_whenLinkedHashSetAddParentNotFound() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.PARENT_NOT_FOUND);

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
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.errors(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyValidatedItem)}.
   * <ul>
   *   <li>Given {@link EntityReference}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkTaxonomyValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyValidatedItem); given EntityReference")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyValidatedItem)"})
  void testBuilderFrom_givenEntityReference() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();
    BulkTaxonomyValidatedItem instance = mock(BulkTaxonomyValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.existingItemReference()).thenReturn(mock(EntityReference.class));
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    when(instance.parsedItem()).thenReturn(new ImmutableBulkTaxonomyItem.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).existingItemReference();
    verify(instance).parsedItem();
    ImmutableBulkTaxonomyValidatedItem buildResult = actualFromResult.build();
    assertTrue(buildResult.changedFields().isEmpty());
    ImmutableBulkTaxonomyValidatedItem buildResult2 = builderResult.build();
    assertTrue(buildResult2.changedFields().isEmpty());
    assertTrue(buildResult.errors().isEmpty());
    assertTrue(buildResult2.errors().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyValidatedItem)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code NAME}.</li>
   *   <li>Then return build changedFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkTaxonomyValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyValidatedItem); given HashSet() add 'NAME'; then return build changedFields size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyValidatedItem)"})
  void testBuilderFrom_givenHashSetAddName_thenReturnBuildChangedFieldsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    HashSet<ChangedFieldType> changedFieldTypeSet = new HashSet<>();
    changedFieldTypeSet.add(ChangedFieldType.NAME);
    BulkTaxonomyValidatedItem instance = mock(BulkTaxonomyValidatedItem.class);
    when(instance.changedFields()).thenReturn(changedFieldTypeSet);
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.existingItemReference()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    when(instance.parsedItem()).thenReturn(new ImmutableBulkTaxonomyItem.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).existingItemReference();
    verify(instance).parsedItem();
    Set<ChangedFieldType> changedFieldsResult = actualFromResult.build().changedFields();
    assertEquals(1, changedFieldsResult.size());
    Set<ChangedFieldType> changedFieldsResult2 = builderResult.build().changedFields();
    assertEquals(1, changedFieldsResult2.size());
    assertTrue(changedFieldsResult.contains(ChangedFieldType.NAME));
    assertTrue(changedFieldsResult2.contains(ChangedFieldType.NAME));
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyValidatedItem)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PARENT_NOT_FOUND}.</li>
   *   <li>Then return build errors size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkTaxonomyValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyValidatedItem); given HashSet() add 'PARENT_NOT_FOUND'; then return build errors size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyValidatedItem)"})
  void testBuilderFrom_givenHashSetAddParentNotFound_thenReturnBuildErrorsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    HashSet<ValidationError> validationErrorSet = new HashSet<>();
    validationErrorSet.add(ValidationError.PARENT_NOT_FOUND);
    BulkTaxonomyValidatedItem instance = mock(BulkTaxonomyValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(validationErrorSet);
    when(instance.existingItemReference()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    when(instance.parsedItem()).thenReturn(new ImmutableBulkTaxonomyItem.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).existingItemReference();
    verify(instance).parsedItem();
    Set<ValidationError> errorsResult = actualFromResult.build().errors();
    assertEquals(1, errorsResult.size());
    Set<ValidationError> errorsResult2 = builderResult.build().errors();
    assertEquals(1, errorsResult2.size());
    assertTrue(errorsResult.contains(ValidationError.PARENT_NOT_FOUND));
    assertTrue(errorsResult2.contains(ValidationError.PARENT_NOT_FOUND));
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyValidatedItem)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return build existingItemReference is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkTaxonomyValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyValidatedItem); given 'null'; then return build existingItemReference is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyValidatedItem)"})
  void testBuilderFrom_givenNull_thenReturnBuildExistingItemReferenceIsNull() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();
    BulkTaxonomyValidatedItem instance = mock(BulkTaxonomyValidatedItem.class);
    when(instance.changedFields()).thenReturn(new HashSet<>());
    when(instance.errors()).thenReturn(new HashSet<>());
    when(instance.existingItemReference()).thenReturn(null);
    when(instance.changeOperation()).thenReturn(ChangeOperation.ADD);
    when(instance.parsedItem()).thenReturn(new ImmutableBulkTaxonomyItem.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).changeOperation();
    verify(instance).changedFields();
    verify(instance).errors();
    verify(instance).existingItemReference();
    verify(instance).parsedItem();
    ImmutableBulkTaxonomyValidatedItem buildResult = actualFromResult.build();
    assertNull(buildResult.existingItemReference());
    ImmutableBulkTaxonomyValidatedItem buildResult2 = builderResult.build();
    assertNull(buildResult2.existingItemReference());
    assertTrue(buildResult.changedFields().isEmpty());
    assertTrue(buildResult2.changedFields().isEmpty());
    assertTrue(buildResult.errors().isEmpty());
    assertTrue(buildResult2.errors().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyValidatedItem)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkTaxonomyValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyValidatedItem); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyValidatedItem)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();
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
   * Test Builder {@link Builder#parsedItem(BulkTaxonomyItem)}.
   * <ul>
   *   <li>When {@link ImmutableBulkTaxonomyItem.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#parsedItem(BulkTaxonomyItem)}
   */
  @Test
  @DisplayName("Test Builder parsedItem(BulkTaxonomyItem); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parsedItem(BulkTaxonomyItem)"})
  void testBuilderParsedItem_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parsedItem(new ImmutableBulkTaxonomyItem.Json()));
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
   * Test Json {@link Json#existingItemReference()}.
   * <p>
   * Method under test: {@link Json#existingItemReference()}
   */
  @Test
  @DisplayName("Test Json existingItemReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.existingItemReference()"})
  void testJsonExistingItemReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).existingItemReference());
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
    assertNull(actualJson.existingItemReference);
    assertNull(actualJson.changeOperation);
    assertNull(actualJson.parsedItem);
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
  @MethodsUnderTest({"BulkTaxonomyItem Json.parsedItem()"})
  void testJsonParsedItem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).parsedItem());
  }
}
