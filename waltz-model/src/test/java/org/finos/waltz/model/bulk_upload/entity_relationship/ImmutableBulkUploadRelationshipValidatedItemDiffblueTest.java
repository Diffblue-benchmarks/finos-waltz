package org.finos.waltz.model.bulk_upload.entity_relationship;

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
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipValidatedItem.Builder;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipValidatedItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkUploadRelationshipValidatedItemDiffblueTest {
  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipValidatedItem#builder()}
   *   <li>{@link ImmutableBulkUploadRelationshipValidatedItem#description(String)}
   *   <li>{@link ImmutableBulkUploadRelationshipValidatedItem#sourceEntityRef(EntityReference)}
   *   <li>{@link ImmutableBulkUploadRelationshipValidatedItem#targetEntityRef(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkUploadRelationshipValidatedItem Builder.build()",
      "Builder Builder.description(String)", "Builder Builder.sourceEntityRef(EntityReference)",
      "Builder Builder.targetEntityRef(EntityReference)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualDescriptionResult = ImmutableBulkUploadRelationshipValidatedItem.builder()
        .description("The characteristics of someone or something");
    Builder actualSourceEntityRefResult = actualDescriptionResult.error(new ArrayList<>()).sourceEntityRef(null);

    // Assert
    assertSame(actualSourceEntityRefResult, actualSourceEntityRefResult.targetEntityRef(null));
  }

  /**
   * Test Builder {@link Builder#addAllError(Iterable)}.
   * <ul>
   *   <li>Given builder error {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllError(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllError(Iterable); given builder error ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllError(Iterable)"})
  void testBuilderAddAllError_givenBuilderErrorArrayList() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();
    builderResult.error(new ArrayList<>());

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.SOURCE_INVALID);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllError(elements));
  }

  /**
   * Test Builder {@link Builder#addAllError(Iterable)}.
   * <ul>
   *   <li>Given builder error {@code null}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code SOURCE_INVALID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllError(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllError(Iterable); given builder error 'null'; when LinkedHashSet() add 'SOURCE_INVALID'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllError(Iterable)"})
  void testBuilderAddAllError_givenBuilderErrorNull_whenLinkedHashSetAddSourceInvalid() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();
    builderResult.error(null);

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.SOURCE_INVALID);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllError(elements));
  }

  /**
   * Test Builder {@link Builder#addAllError(Iterable)}.
   * <ul>
   *   <li>Given builder.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllError(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllError(Iterable); given builder; when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllError(Iterable)"})
  void testBuilderAddAllError_givenBuilder_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllError(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addError(ValidationError)} with {@code element}.
   * <ul>
   *   <li>Given builder error {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addError(ValidationError)}
   */
  @Test
  @DisplayName("Test Builder addError(ValidationError) with 'element'; given builder error ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addError(ValidationError)"})
  void testBuilderAddErrorWithElement_givenBuilderErrorArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();
    builderResult.error(new ArrayList<>());

    // Act and Assert
    assertSame(builderResult, builderResult.addError(ValidationError.SOURCE_INVALID));
  }

  /**
   * Test Builder {@link Builder#addError(ValidationError)} with {@code element}.
   * <ul>
   *   <li>Given builder.</li>
   *   <li>When {@code SOURCE_INVALID}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addError(ValidationError)}
   */
  @Test
  @DisplayName("Test Builder addError(ValidationError) with 'element'; given builder; when 'SOURCE_INVALID'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addError(ValidationError)"})
  void testBuilderAddErrorWithElement_givenBuilder_whenSourceInvalid_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addError(ValidationError.SOURCE_INVALID));
  }

  /**
   * Test Builder {@link Builder#addError(ValidationError[])} with {@code elements}.
   * <ul>
   *   <li>Given builder error {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addError(ValidationError[])}
   */
  @Test
  @DisplayName("Test Builder addError(ValidationError[]) with 'elements'; given builder error ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addError(ValidationError[])"})
  void testBuilderAddErrorWithElements_givenBuilderErrorArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();
    builderResult.error(new ArrayList<>());

    // Act and Assert
    assertSame(builderResult, builderResult.addError(ValidationError.SOURCE_INVALID));
  }

  /**
   * Test Builder {@link Builder#addError(ValidationError[])} with {@code elements}.
   * <ul>
   *   <li>Given builder.</li>
   *   <li>When {@code SOURCE_INVALID}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addError(ValidationError[])}
   */
  @Test
  @DisplayName("Test Builder addError(ValidationError[]) with 'elements'; given builder; when 'SOURCE_INVALID'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addError(ValidationError[])"})
  void testBuilderAddErrorWithElements_givenBuilder_whenSourceInvalid_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addError(ValidationError.SOURCE_INVALID));
  }

  /**
   * Test Builder {@link Builder#error(Iterable)}.
   * <ul>
   *   <li>Given builder error {@code null}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#error(Iterable)}
   */
  @Test
  @DisplayName("Test Builder error(Iterable); given builder error 'null'; when 'null'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.error(Iterable)"})
  void testBuilderError_givenBuilderErrorNull_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();
    builderResult.error(null);

    // Act and Assert
    assertSame(builderResult, builderResult.error(null));
  }

  /**
   * Test Builder {@link Builder#error(Iterable)}.
   * <ul>
   *   <li>Given builder.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#error(Iterable)}
   */
  @Test
  @DisplayName("Test Builder error(Iterable); given builder; when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.error(Iterable)"})
  void testBuilderError_givenBuilder_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.error(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#error(Iterable)}.
   * <ul>
   *   <li>Given {@code SOURCE_INVALID}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code SOURCE_INVALID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#error(Iterable)}
   */
  @Test
  @DisplayName("Test Builder error(Iterable); given 'SOURCE_INVALID'; when LinkedHashSet() add 'SOURCE_INVALID'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.error(Iterable)"})
  void testBuilderError_givenSourceInvalid_whenLinkedHashSetAddSourceInvalid() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();
    builderResult.error(null);

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.SOURCE_INVALID);

    // Act and Assert
    assertSame(builderResult, builderResult.error(elements));
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipValidatedItem)}.
   * <p>
   * Method under test: {@link Builder#from(BulkUploadRelationshipValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipValidatedItem)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipValidatedItem)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();
    BulkUploadRelationshipValidatedItem instance = mock(BulkUploadRelationshipValidatedItem.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.error()).thenReturn(new HashSet<>());
    when(instance.sourceEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.targetEntityRef()).thenReturn(null);
    when(instance.uploadOperation()).thenReturn(UploadOperation.ADD);
    when(instance.parsedItem()).thenReturn(new ImmutableBulkUploadRelationshipItem.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).error();
    verify(instance).parsedItem();
    verify(instance).sourceEntityRef();
    verify(instance).targetEntityRef();
    verify(instance).uploadOperation();
    ImmutableBulkUploadRelationshipValidatedItem buildResult = actualFromResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    ImmutableBulkUploadRelationshipValidatedItem buildResult2 = builderResult.build();
    assertEquals("The characteristics of someone or something", buildResult2.description());
    assertNull(buildResult.targetEntityRef());
    assertNull(buildResult2.targetEntityRef());
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipValidatedItem)}.
   * <p>
   * Method under test: {@link Builder#from(BulkUploadRelationshipValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipValidatedItem)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipValidatedItem)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();
    BulkUploadRelationshipValidatedItem instance = mock(BulkUploadRelationshipValidatedItem.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.error()).thenReturn(new HashSet<>());
    when(instance.sourceEntityRef()).thenReturn(null);
    when(instance.targetEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.uploadOperation()).thenReturn(UploadOperation.ADD);
    when(instance.parsedItem()).thenReturn(new ImmutableBulkUploadRelationshipItem.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).error();
    verify(instance).parsedItem();
    verify(instance).sourceEntityRef();
    verify(instance).targetEntityRef();
    verify(instance).uploadOperation();
    ImmutableBulkUploadRelationshipValidatedItem buildResult = actualFromResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    ImmutableBulkUploadRelationshipValidatedItem buildResult2 = builderResult.build();
    assertEquals("The characteristics of someone or something", buildResult2.description());
    assertNull(buildResult.sourceEntityRef());
    assertNull(buildResult2.sourceEntityRef());
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipValidatedItem)}.
   * <ul>
   *   <li>Then return build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkUploadRelationshipValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipValidatedItem); then return build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipValidatedItem)"})
  void testBuilderFrom_thenReturnBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();
    BulkUploadRelationshipValidatedItem instance = mock(BulkUploadRelationshipValidatedItem.class);
    when(instance.description()).thenReturn(null);
    when(instance.error()).thenReturn(new HashSet<>());
    when(instance.sourceEntityRef()).thenReturn(null);
    when(instance.targetEntityRef()).thenReturn(null);
    when(instance.uploadOperation()).thenReturn(UploadOperation.ADD);
    when(instance.parsedItem()).thenReturn(new ImmutableBulkUploadRelationshipItem.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).error();
    verify(instance).parsedItem();
    verify(instance).sourceEntityRef();
    verify(instance).targetEntityRef();
    verify(instance).uploadOperation();
    ImmutableBulkUploadRelationshipValidatedItem buildResult = actualFromResult.build();
    assertNull(buildResult.description());
    ImmutableBulkUploadRelationshipValidatedItem buildResult2 = builderResult.build();
    assertNull(buildResult2.description());
    assertTrue(buildResult.error().isEmpty());
    assertTrue(buildResult2.error().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipValidatedItem)}.
   * <ul>
   *   <li>Then return build error contains {@code SOURCE_INVALID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkUploadRelationshipValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipValidatedItem); then return build error contains 'SOURCE_INVALID'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipValidatedItem)"})
  void testBuilderFrom_thenReturnBuildErrorContainsSourceInvalid() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();

    HashSet<ValidationError> validationErrorSet = new HashSet<>();
    validationErrorSet.add(ValidationError.SOURCE_INVALID);
    BulkUploadRelationshipValidatedItem instance = mock(BulkUploadRelationshipValidatedItem.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.error()).thenReturn(validationErrorSet);
    when(instance.sourceEntityRef()).thenReturn(null);
    when(instance.targetEntityRef()).thenReturn(null);
    when(instance.uploadOperation()).thenReturn(UploadOperation.ADD);
    when(instance.parsedItem()).thenReturn(new ImmutableBulkUploadRelationshipItem.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).error();
    verify(instance).parsedItem();
    verify(instance).sourceEntityRef();
    verify(instance).targetEntityRef();
    verify(instance).uploadOperation();
    Set<ValidationError> errorResult = actualFromResult.build().error();
    assertEquals(1, errorResult.size());
    Set<ValidationError> errorResult2 = builderResult.build().error();
    assertEquals(1, errorResult2.size());
    assertTrue(errorResult.contains(ValidationError.SOURCE_INVALID));
    assertTrue(errorResult2.contains(ValidationError.SOURCE_INVALID));
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipValidatedItem)}.
   * <ul>
   *   <li>Then return build error contains {@code SOURCE_NOT_FOUND}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkUploadRelationshipValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipValidatedItem); then return build error contains 'SOURCE_NOT_FOUND'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipValidatedItem)"})
  void testBuilderFrom_thenReturnBuildErrorContainsSourceNotFound() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();
    builderResult.addError(ValidationError.SOURCE_NOT_FOUND);
    BulkUploadRelationshipValidatedItem instance = mock(BulkUploadRelationshipValidatedItem.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.error()).thenReturn(new HashSet<>());
    when(instance.sourceEntityRef()).thenReturn(null);
    when(instance.targetEntityRef()).thenReturn(null);
    when(instance.uploadOperation()).thenReturn(UploadOperation.ADD);
    when(instance.parsedItem()).thenReturn(new ImmutableBulkUploadRelationshipItem.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).error();
    verify(instance).parsedItem();
    verify(instance).sourceEntityRef();
    verify(instance).targetEntityRef();
    verify(instance).uploadOperation();
    Set<ValidationError> errorResult = actualFromResult.build().error();
    assertEquals(1, errorResult.size());
    Set<ValidationError> errorResult2 = builderResult.build().error();
    assertEquals(1, errorResult2.size());
    assertTrue(errorResult.contains(ValidationError.SOURCE_NOT_FOUND));
    assertTrue(errorResult2.contains(ValidationError.SOURCE_NOT_FOUND));
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipValidatedItem)}.
   * <ul>
   *   <li>Then return build sourceEntityRef is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkUploadRelationshipValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipValidatedItem); then return build sourceEntityRef is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipValidatedItem)"})
  void testBuilderFrom_thenReturnBuildSourceEntityRefIsNull() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();
    BulkUploadRelationshipValidatedItem instance = mock(BulkUploadRelationshipValidatedItem.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.error()).thenReturn(new HashSet<>());
    when(instance.sourceEntityRef()).thenReturn(null);
    when(instance.targetEntityRef()).thenReturn(null);
    when(instance.uploadOperation()).thenReturn(UploadOperation.ADD);
    when(instance.parsedItem()).thenReturn(new ImmutableBulkUploadRelationshipItem.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).error();
    verify(instance).parsedItem();
    verify(instance).sourceEntityRef();
    verify(instance).targetEntityRef();
    verify(instance).uploadOperation();
    ImmutableBulkUploadRelationshipValidatedItem buildResult = actualFromResult.build();
    assertNull(buildResult.sourceEntityRef());
    ImmutableBulkUploadRelationshipValidatedItem buildResult2 = builderResult.build();
    assertNull(buildResult2.sourceEntityRef());
    assertNull(buildResult.targetEntityRef());
    assertNull(buildResult2.targetEntityRef());
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipValidatedItem)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkUploadRelationshipValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipValidatedItem); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipValidatedItem)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();
    BulkUploadRelationshipValidatedItem instance = mock(BulkUploadRelationshipValidatedItem.class);
    when(instance.sourceEntityRef()).thenThrow(new IllegalStateException("instance"));
    when(instance.parsedItem()).thenReturn(new ImmutableBulkUploadRelationshipItem.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).parsedItem();
    verify(instance).sourceEntityRef();
  }

  /**
   * Test Builder {@link Builder#parsedItem(BulkUploadRelationshipItem)}.
   * <ul>
   *   <li>When {@link ImmutableBulkUploadRelationshipItem.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#parsedItem(BulkUploadRelationshipItem)}
   */
  @Test
  @DisplayName("Test Builder parsedItem(BulkUploadRelationshipItem); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parsedItem(BulkUploadRelationshipItem)"})
  void testBuilderParsedItem_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parsedItem(new ImmutableBulkUploadRelationshipItem.Json()));
  }

  /**
   * Test Builder {@link Builder#uploadOperation(UploadOperation)}.
   * <p>
   * Method under test: {@link Builder#uploadOperation(UploadOperation)}
   */
  @Test
  @DisplayName("Test Builder uploadOperation(UploadOperation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.uploadOperation(UploadOperation)"})
  void testBuilderUploadOperation() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.uploadOperation(UploadOperation.ADD));
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).description());
  }

  /**
   * Test Json {@link Json#error()}.
   * <p>
   * Method under test: {@link Json#error()}
   */
  @Test
  @DisplayName("Test Json error()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.error()"})
  void testJsonError() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).error());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setError(Set)}
   *   <li>{@link Json#setParsedItem(BulkUploadRelationshipItem)}
   *   <li>{@link Json#setSourceEntityRef(EntityReference)}
   *   <li>{@link Json#setTargetEntityRef(EntityReference)}
   *   <li>{@link Json#setUploadOperation(UploadOperation)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setDescription(String)", "void Json.setError(Set)",
      "void Json.setParsedItem(BulkUploadRelationshipItem)", "void Json.setSourceEntityRef(EntityReference)",
      "void Json.setTargetEntityRef(EntityReference)", "void Json.setUploadOperation(UploadOperation)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
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
   * Test Json {@link Json#parsedItem()}.
   * <p>
   * Method under test: {@link Json#parsedItem()}
   */
  @Test
  @DisplayName("Test Json parsedItem()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkUploadRelationshipItem Json.parsedItem()"})
  void testJsonParsedItem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).parsedItem());
  }

  /**
   * Test Json {@link Json#sourceEntityRef()}.
   * <p>
   * Method under test: {@link Json#sourceEntityRef()}
   */
  @Test
  @DisplayName("Test Json sourceEntityRef()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.sourceEntityRef()"})
  void testJsonSourceEntityRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).sourceEntityRef());
  }

  /**
   * Test Json {@link Json#targetEntityRef()}.
   * <p>
   * Method under test: {@link Json#targetEntityRef()}
   */
  @Test
  @DisplayName("Test Json targetEntityRef()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.targetEntityRef()"})
  void testJsonTargetEntityRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).targetEntityRef());
  }

  /**
   * Test Json {@link Json#uploadOperation()}.
   * <p>
   * Method under test: {@link Json#uploadOperation()}
   */
  @Test
  @DisplayName("Test Json uploadOperation()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UploadOperation Json.uploadOperation()"})
  void testJsonUploadOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).uploadOperation());
  }
}
