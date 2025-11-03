package org.finos.waltz.model.bulk_upload.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipItem.Builder;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkUploadRelationshipItemDiffblueTest {
  /**
   * Test {@link ImmutableBulkUploadRelationshipItem#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipItem#builder()}
   *   <li>{@link ImmutableBulkUploadRelationshipItem#description(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkUploadRelationshipItem Builder.build()", "Builder Builder.description(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableBulkUploadRelationshipItem.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.description("The characteristics of someone or something"));
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipItem)}.
   * <p>
   * Method under test: {@link Builder#from(BulkUploadRelationshipItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipItem)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipItem)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipItem.builder();
    BulkUploadRelationshipItem instance = mock(BulkUploadRelationshipItem.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.targetExternalId()).thenReturn("42");
    when(instance.sourceExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).sourceExternalId();
    verify(instance).targetExternalId();
    ImmutableBulkUploadRelationshipItem buildResult = builderResult.build();
    assertEquals("42", buildResult.sourceExternalId());
    assertEquals("42", buildResult.targetExternalId());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipItem)}.
   * <ul>
   *   <li>Then builder build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkUploadRelationshipItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipItem); then builder build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipItem)"})
  void testBuilderFrom_thenBuilderBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipItem.builder();
    BulkUploadRelationshipItem instance = mock(BulkUploadRelationshipItem.class);
    when(instance.description()).thenReturn(null);
    when(instance.targetExternalId()).thenReturn("42");
    when(instance.sourceExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).sourceExternalId();
    verify(instance).targetExternalId();
    ImmutableBulkUploadRelationshipItem buildResult = builderResult.build();
    assertEquals("42", buildResult.sourceExternalId());
    assertEquals("42", buildResult.targetExternalId());
    assertNull(buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipItem)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkUploadRelationshipItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipItem); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipItem)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipItem.builder();
    BulkUploadRelationshipItem instance = mock(BulkUploadRelationshipItem.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.targetExternalId()).thenReturn("42");
    when(instance.sourceExternalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).sourceExternalId();
    verify(instance).targetExternalId();
  }

  /**
   * Test Builder {@link Builder#sourceExternalId(String)}.
   * <p>
   * Method under test: {@link Builder#sourceExternalId(String)}
   */
  @Test
  @DisplayName("Test Builder sourceExternalId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.sourceExternalId(String)"})
  void testBuilderSourceExternalId() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.sourceExternalId("42"));
  }

  /**
   * Test Builder {@link Builder#targetExternalId(String)}.
   * <p>
   * Method under test: {@link Builder#targetExternalId(String)}
   */
  @Test
  @DisplayName("Test Builder targetExternalId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.targetExternalId(String)"})
  void testBuilderTargetExternalId() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetExternalId("42"));
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
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setSourceExternalId(String)}
   *   <li>{@link Json#setTargetExternalId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setDescription(String)", "void Json.setSourceExternalId(String)",
      "void Json.setTargetExternalId(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setSourceExternalId("42");
    actualJson.setTargetExternalId("42");

    // Assert
    assertEquals("42", actualJson.sourceExternalId);
    assertEquals("42", actualJson.targetExternalId);
    assertEquals("The characteristics of someone or something", actualJson.description);
  }

  /**
   * Test Json {@link Json#sourceExternalId()}.
   * <p>
   * Method under test: {@link Json#sourceExternalId()}
   */
  @Test
  @DisplayName("Test Json sourceExternalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.sourceExternalId()"})
  void testJsonSourceExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).sourceExternalId());
  }

  /**
   * Test Json {@link Json#targetExternalId()}.
   * <p>
   * Method under test: {@link Json#targetExternalId()}
   */
  @Test
  @DisplayName("Test Json targetExternalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.targetExternalId()"})
  void testJsonTargetExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).targetExternalId());
  }
}
