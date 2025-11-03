package org.finos.waltz.model.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.bulk_upload.ImmutableBulkUploadCommand.Builder;
import org.finos.waltz.model.bulk_upload.ImmutableBulkUploadCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkUploadCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#from(BulkUploadCommand)}.
   * <p>
   * Method under test: {@link Builder#from(BulkUploadCommand)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadCommand)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUploadCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadCommand.builder();
    BulkUploadCommand instance = mock(BulkUploadCommand.class);
    when(instance.targetDomain()).thenThrow(new IllegalStateException("instance"));
    when(instance.inputString()).thenReturn("Input String");
    when(instance.uploadMode()).thenReturn(BulkUploadMode.ADD_ONLY);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).inputString();
    verify(instance).targetDomain();
    verify(instance).uploadMode();
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadCommand)}.
   * <p>
   * Method under test: {@link Builder#from(BulkUploadCommand)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadCommand)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUploadCommand)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadCommand.builder();
    BulkUploadCommand instance = mock(BulkUploadCommand.class);
    when(instance.rowSubjectQualifier()).thenThrow(new IllegalStateException("instance"));
    when(instance.rowSubjectKind()).thenReturn(EntityKind.ALL);
    when(instance.targetDomain()).thenReturn(mock(EntityReference.class));
    when(instance.inputString()).thenReturn("Input String");
    when(instance.uploadMode()).thenReturn(BulkUploadMode.ADD_ONLY);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).inputString();
    verify(instance).rowSubjectKind();
    verify(instance).rowSubjectQualifier();
    verify(instance).targetDomain();
    verify(instance).uploadMode();
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadCommand)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link BulkUploadCommand} {@link BulkUploadCommand#rowSubjectQualifier()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkUploadCommand)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadCommand); given empty; when BulkUploadCommand rowSubjectQualifier() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUploadCommand)"})
  void testBuilderFrom_givenEmpty_whenBulkUploadCommandRowSubjectQualifierReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadCommand.builder();
    BulkUploadCommand instance = mock(BulkUploadCommand.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(instance.rowSubjectQualifier()).thenReturn(emptyResult);
    when(instance.rowSubjectKind()).thenReturn(EntityKind.ALL);
    when(instance.targetDomain()).thenReturn(mock(EntityReference.class));
    when(instance.inputString()).thenReturn("Input String");
    when(instance.uploadMode()).thenReturn(BulkUploadMode.ADD_ONLY);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).inputString();
    verify(instance).rowSubjectKind();
    verify(instance).rowSubjectQualifier();
    verify(instance).targetDomain();
    verify(instance).uploadMode();
    ImmutableBulkUploadCommand buildResult = builderResult.build();
    assertEquals("Input String", buildResult.inputString());
    assertEquals(EntityKind.ALL, buildResult.rowSubjectKind());
    assertEquals(BulkUploadMode.ADD_ONLY, buildResult.uploadMode());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadCommand)}.
   * <ul>
   *   <li>Given {@link Optional} with {@link EntityReference}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkUploadCommand)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadCommand); given Optional with EntityReference")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUploadCommand)"})
  void testBuilderFrom_givenOptionalWithEntityReference() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadCommand.builder();
    BulkUploadCommand instance = mock(BulkUploadCommand.class);
    Optional<EntityReference> ofResult = Optional.of(mock(EntityReference.class));
    when(instance.rowSubjectQualifier()).thenReturn(ofResult);
    when(instance.rowSubjectKind()).thenReturn(EntityKind.ALL);
    when(instance.targetDomain()).thenReturn(mock(EntityReference.class));
    when(instance.inputString()).thenReturn("Input String");
    when(instance.uploadMode()).thenReturn(BulkUploadMode.ADD_ONLY);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).inputString();
    verify(instance).rowSubjectKind();
    verify(instance).rowSubjectQualifier();
    verify(instance).targetDomain();
    verify(instance).uploadMode();
    ImmutableBulkUploadCommand buildResult = builderResult.build();
    assertEquals("Input String", buildResult.inputString());
    assertEquals(EntityKind.ALL, buildResult.rowSubjectKind());
    assertEquals(BulkUploadMode.ADD_ONLY, buildResult.uploadMode());
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableBulkUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.inputString("Input String"));
  }

  /**
   * Test Builder {@link Builder#rowSubjectKind(EntityKind)}.
   * <p>
   * Method under test: {@link Builder#rowSubjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder rowSubjectKind(EntityKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.rowSubjectKind(EntityKind)"})
  void testBuilderRowSubjectKind() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rowSubjectKind(EntityKind.ALL));
  }

  /**
   * Test Builder {@link Builder#rowSubjectQualifier(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#rowSubjectQualifier(Optional)}
   */
  @Test
  @DisplayName("Test Builder rowSubjectQualifier(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.rowSubjectQualifier(Optional)"})
  void testBuilderRowSubjectQualifierWithOptional() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadCommand.builder();
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.of(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.rowSubjectQualifier(rowSubjectQualifier));
  }

  /**
   * Test Builder {@link Builder#targetDomain(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#targetDomain(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder targetDomain(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.targetDomain(EntityReference)"})
  void testBuilderTargetDomain_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetDomain(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#uploadMode(BulkUploadMode)}.
   * <p>
   * Method under test: {@link Builder#uploadMode(BulkUploadMode)}
   */
  @Test
  @DisplayName("Test Builder uploadMode(BulkUploadMode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.uploadMode(BulkUploadMode)"})
  void testBuilderUploadMode() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.uploadMode(BulkUploadMode.ADD_ONLY));
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
    assertNull(actualJson.inputString);
    assertNull(actualJson.rowSubjectKind);
    assertNull(actualJson.targetDomain);
    assertNull(actualJson.uploadMode);
    assertFalse(actualJson.rowSubjectQualifier.isPresent());
  }

  /**
   * Test Json {@link Json#rowSubjectKind()}.
   * <p>
   * Method under test: {@link Json#rowSubjectKind()}
   */
  @Test
  @DisplayName("Test Json rowSubjectKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.rowSubjectKind()"})
  void testJsonRowSubjectKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).rowSubjectKind());
  }

  /**
   * Test Json {@link Json#rowSubjectQualifier()}.
   * <p>
   * Method under test: {@link Json#rowSubjectQualifier()}
   */
  @Test
  @DisplayName("Test Json rowSubjectQualifier()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.rowSubjectQualifier()"})
  void testJsonRowSubjectQualifier() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).rowSubjectQualifier());
  }

  /**
   * Test Json {@link Json#targetDomain()}.
   * <p>
   * Method under test: {@link Json#targetDomain()}
   */
  @Test
  @DisplayName("Test Json targetDomain()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.targetDomain()"})
  void testJsonTargetDomain() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).targetDomain());
  }

  /**
   * Test Json {@link Json#uploadMode()}.
   * <p>
   * Method under test: {@link Json#uploadMode()}
   */
  @Test
  @DisplayName("Test Json uploadMode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkUploadMode Json.uploadMode()"})
  void testJsonUploadMode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).uploadMode());
  }
}
