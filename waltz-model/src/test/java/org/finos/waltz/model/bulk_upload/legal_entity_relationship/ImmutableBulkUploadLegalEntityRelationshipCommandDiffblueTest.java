package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bulk_upload.BulkUpdateMode;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableBulkUploadLegalEntityRelationshipCommand.Builder;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableBulkUploadLegalEntityRelationshipCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkUploadLegalEntityRelationshipCommandDiffblueTest {
  /**
   * Test {@link ImmutableBulkUploadLegalEntityRelationshipCommand#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkUploadLegalEntityRelationshipCommand#builder()}
   *   <li>{@link ImmutableBulkUploadLegalEntityRelationshipCommand#updateMode(BulkUpdateMode)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkUploadLegalEntityRelationshipCommand Builder.build()",
      "Builder Builder.updateMode(BulkUpdateMode)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableBulkUploadLegalEntityRelationshipCommand.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.updateMode(BulkUpdateMode.ADD_ONLY));
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadLegalEntityRelationshipCommand)}.
   * <ul>
   *   <li>Given {@code ADD_ONLY}.</li>
   *   <li>Then builder build inputString is {@code Input String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkUploadLegalEntityRelationshipCommand)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadLegalEntityRelationshipCommand); given 'ADD_ONLY'; then builder build inputString is 'Input String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUploadLegalEntityRelationshipCommand)"})
  void testBuilderFrom_givenAddOnly_thenBuilderBuildInputStringIsInputString() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadLegalEntityRelationshipCommand.builder();
    BulkUploadLegalEntityRelationshipCommand instance = mock(BulkUploadLegalEntityRelationshipCommand.class);
    when(instance.updateMode()).thenReturn(BulkUpdateMode.ADD_ONLY);
    when(instance.inputString()).thenReturn("Input String");
    when(instance.legalEntityRelationshipKindId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).inputString();
    verify(instance).legalEntityRelationshipKindId();
    verify(instance).updateMode();
    ImmutableBulkUploadLegalEntityRelationshipCommand buildResult = builderResult.build();
    assertEquals("Input String", buildResult.inputString());
    assertEquals(1L, buildResult.legalEntityRelationshipKindId());
    assertEquals(BulkUpdateMode.ADD_ONLY, buildResult.updateMode());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadLegalEntityRelationshipCommand)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkUploadLegalEntityRelationshipCommand)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadLegalEntityRelationshipCommand); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUploadLegalEntityRelationshipCommand)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadLegalEntityRelationshipCommand.builder();
    BulkUploadLegalEntityRelationshipCommand instance = mock(BulkUploadLegalEntityRelationshipCommand.class);
    when(instance.updateMode()).thenThrow(new IllegalStateException("instance"));
    when(instance.inputString()).thenReturn("Input String");
    when(instance.legalEntityRelationshipKindId()).thenReturn(1L);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).inputString();
    verify(instance).legalEntityRelationshipKindId();
    verify(instance).updateMode();
  }

  /**
   * Test Builder {@link Builder#inputString(String)}.
   * <p>
   * Method under test: {@link Builder#inputString(String)}
   */
  @Test
  @DisplayName("Test Builder inputString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.inputString(String)"})
  void testBuilderInputString() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadLegalEntityRelationshipCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.inputString("Input String"));
  }

  /**
   * Test Builder {@link Builder#legalEntityRelationshipKindId(long)}.
   * <p>
   * Method under test: {@link Builder#legalEntityRelationshipKindId(long)}
   */
  @Test
  @DisplayName("Test Builder legalEntityRelationshipKindId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.legalEntityRelationshipKindId(long)"})
  void testBuilderLegalEntityRelationshipKindId() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadLegalEntityRelationshipCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.legalEntityRelationshipKindId(1L));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setInputString(String)}
   *   <li>{@link Json#setUpdateMode(BulkUpdateMode)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setInputString(String)",
      "void Json.setUpdateMode(BulkUpdateMode)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setInputString("Input String");
    actualJson.setUpdateMode(BulkUpdateMode.ADD_ONLY);

    // Assert
    assertEquals("Input String", actualJson.inputString);
    assertEquals(0L, actualJson.legalEntityRelationshipKindId);
    assertEquals(BulkUpdateMode.ADD_ONLY, actualJson.updateMode);
    assertFalse(actualJson.legalEntityRelationshipKindIdIsSet);
  }

  /**
   * Test Json {@link Json#inputString()}.
   * <p>
   * Method under test: {@link Json#inputString()}
   */
  @Test
  @DisplayName("Test Json inputString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.inputString()"})
  void testJsonInputString() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).inputString());
  }

  /**
   * Test Json {@link Json#legalEntityRelationshipKindId()}.
   * <p>
   * Method under test: {@link Json#legalEntityRelationshipKindId()}
   */
  @Test
  @DisplayName("Test Json legalEntityRelationshipKindId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.legalEntityRelationshipKindId()"})
  void testJsonLegalEntityRelationshipKindId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).legalEntityRelationshipKindId());
  }

  /**
   * Test Json {@link Json#setLegalEntityRelationshipKindId(long)}.
   * <p>
   * Method under test: {@link Json#setLegalEntityRelationshipKindId(long)}
   */
  @Test
  @DisplayName("Test Json setLegalEntityRelationshipKindId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setLegalEntityRelationshipKindId(long)"})
  void testJsonSetLegalEntityRelationshipKindId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setLegalEntityRelationshipKindId(1L);

    // Assert
    assertEquals(1L, json.legalEntityRelationshipKindId);
    assertTrue(json.legalEntityRelationshipKindIdIsSet);
  }

  /**
   * Test Json {@link Json#updateMode()}.
   * <p>
   * Method under test: {@link Json#updateMode()}
   */
  @Test
  @DisplayName("Test Json updateMode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkUpdateMode Json.updateMode()"})
  void testJsonUpdateMode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).updateMode());
  }
}
