package org.finos.waltz.model.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableBulkUploadCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableBulkUploadCommand.Builder#from(BulkUploadCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBulkUploadCommand.Builder builderResult = ImmutableBulkUploadCommand.builder();
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
   * Method under test:
   * {@link ImmutableBulkUploadCommand.Builder#from(BulkUploadCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableBulkUploadCommand.Builder builderResult = ImmutableBulkUploadCommand.builder();
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
   * Method under test:
   * {@link ImmutableBulkUploadCommand.Builder#from(BulkUploadCommand)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableBulkUploadCommand.Builder builderResult = ImmutableBulkUploadCommand.builder();
    BulkUploadCommand instance = mock(BulkUploadCommand.class);
    Optional<EntityReference> ofResult = Optional.of(mock(EntityReference.class));
    when(instance.rowSubjectQualifier()).thenReturn(ofResult);
    when(instance.rowSubjectKind()).thenReturn(EntityKind.ALL);
    when(instance.targetDomain()).thenReturn(mock(EntityReference.class));
    when(instance.inputString()).thenReturn("Input String");
    when(instance.uploadMode()).thenReturn(BulkUploadMode.ADD_ONLY);

    // Act
    ImmutableBulkUploadCommand.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableBulkUploadCommand.Builder#from(BulkUploadCommand)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableBulkUploadCommand.Builder builderResult = ImmutableBulkUploadCommand.builder();
    BulkUploadCommand instance = mock(BulkUploadCommand.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(instance.rowSubjectQualifier()).thenReturn(emptyResult);
    when(instance.rowSubjectKind()).thenReturn(EntityKind.ALL);
    when(instance.targetDomain()).thenReturn(mock(EntityReference.class));
    when(instance.inputString()).thenReturn("Input String");
    when(instance.uploadMode()).thenReturn(BulkUploadMode.ADD_ONLY);

    // Act
    ImmutableBulkUploadCommand.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableBulkUploadCommand.Builder#inputString(String)}
   */
  @Test
  void testBuilderInputString() {
    // Arrange
    ImmutableBulkUploadCommand.Builder builderResult = ImmutableBulkUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.inputString("Input String"));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadCommand.Builder#inputString(String)}
   */
  @Test
  void testBuilderInputString2() {
    // Arrange
    ImmutableBulkUploadCommand.Builder builderResult = ImmutableBulkUploadCommand.builder();
    builderResult.rowSubjectQualifier(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.inputString("Input String"));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadCommand.Builder#rowSubjectKind(EntityKind)}
   */
  @Test
  void testBuilderRowSubjectKind() {
    // Arrange
    ImmutableBulkUploadCommand.Builder builderResult = ImmutableBulkUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rowSubjectKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadCommand.Builder#rowSubjectKind(EntityKind)}
   */
  @Test
  void testBuilderRowSubjectKind2() {
    // Arrange
    ImmutableBulkUploadCommand.Builder builderResult = ImmutableBulkUploadCommand.builder();
    builderResult.rowSubjectQualifier(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.rowSubjectKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadCommand.Builder#targetDomain(EntityReference)}
   */
  @Test
  void testBuilderTargetDomain() {
    // Arrange
    ImmutableBulkUploadCommand.Builder builderResult = ImmutableBulkUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetDomain(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadCommand.Builder#uploadMode(BulkUploadMode)}
   */
  @Test
  void testBuilderUploadMode() {
    // Arrange
    ImmutableBulkUploadCommand.Builder builderResult = ImmutableBulkUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.uploadMode(BulkUploadMode.ADD_ONLY));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadCommand.Builder#uploadMode(BulkUploadMode)}
   */
  @Test
  void testBuilderUploadMode2() {
    // Arrange
    ImmutableBulkUploadCommand.Builder builderResult = ImmutableBulkUploadCommand.builder();
    builderResult.rowSubjectQualifier(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.uploadMode(BulkUploadMode.ADD_ONLY));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadCommand#copyOf(BulkUploadCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BulkUploadCommand instance = mock(BulkUploadCommand.class);
    Optional<EntityReference> ofResult = Optional.of(mock(EntityReference.class));
    when(instance.rowSubjectQualifier()).thenReturn(ofResult);
    when(instance.rowSubjectKind()).thenReturn(EntityKind.ALL);
    when(instance.targetDomain()).thenReturn(mock(EntityReference.class));
    when(instance.inputString()).thenReturn("Input String");
    when(instance.uploadMode()).thenReturn(BulkUploadMode.ADD_ONLY);

    // Act
    ImmutableBulkUploadCommand actualCopyOfResult = ImmutableBulkUploadCommand.copyOf(instance);

    // Assert
    verify(instance).inputString();
    verify(instance).rowSubjectKind();
    verify(instance).rowSubjectQualifier();
    verify(instance).targetDomain();
    verify(instance).uploadMode();
    assertEquals("Input String", actualCopyOfResult.inputString());
    assertEquals(EntityKind.ALL, actualCopyOfResult.rowSubjectKind());
    assertEquals(BulkUploadMode.ADD_ONLY, actualCopyOfResult.uploadMode());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadCommand#copyOf(BulkUploadCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    BulkUploadCommand instance = mock(BulkUploadCommand.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(instance.rowSubjectQualifier()).thenReturn(emptyResult);
    when(instance.rowSubjectKind()).thenReturn(EntityKind.ALL);
    when(instance.targetDomain()).thenReturn(mock(EntityReference.class));
    when(instance.inputString()).thenReturn("Input String");
    when(instance.uploadMode()).thenReturn(BulkUploadMode.ADD_ONLY);

    // Act
    ImmutableBulkUploadCommand actualCopyOfResult = ImmutableBulkUploadCommand.copyOf(instance);

    // Assert
    verify(instance).inputString();
    verify(instance).rowSubjectKind();
    verify(instance).rowSubjectQualifier();
    verify(instance).targetDomain();
    verify(instance).uploadMode();
    assertEquals("Input String", actualCopyOfResult.inputString());
    assertEquals(EntityKind.ALL, actualCopyOfResult.rowSubjectKind());
    assertEquals(BulkUploadMode.ADD_ONLY, actualCopyOfResult.uploadMode());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadCommand#fromJson(ImmutableBulkUploadCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableBulkUploadCommand.Json json = new ImmutableBulkUploadCommand.Json();
    json.setUploadMode(BulkUploadMode.ADD_ONLY);
    json.setInputString("Json");
    json.setTargetDomain(mock(EntityReference.class));
    json.setRowSubjectKind(EntityKind.ALL);
    json.setRowSubjectQualifier(null);

    // Act
    ImmutableBulkUploadCommand actualFromJsonResult = ImmutableBulkUploadCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.inputString());
    assertEquals(EntityKind.ALL, actualFromJsonResult.rowSubjectKind());
    assertEquals(BulkUploadMode.ADD_ONLY, actualFromJsonResult.uploadMode());
    EntityReference expectedTargetDomainResult = json.targetDomain;
    assertSame(expectedTargetDomainResult, actualFromJsonResult.targetDomain());
  }

  /**
   * Method under test: {@link ImmutableBulkUploadCommand.Json#inputString()}
   */
  @Test
  void testJsonInputString() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBulkUploadCommand.Json()).inputString());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableBulkUploadCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableBulkUploadCommand.Json actualJson = new ImmutableBulkUploadCommand.Json();

    // Assert
    assertNull(actualJson.inputString);
    assertNull(actualJson.rowSubjectKind);
    assertNull(actualJson.targetDomain);
    assertNull(actualJson.uploadMode);
    assertFalse(actualJson.rowSubjectQualifier.isPresent());
  }

  /**
   * Method under test: {@link ImmutableBulkUploadCommand.Json#rowSubjectKind()}
   */
  @Test
  void testJsonRowSubjectKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBulkUploadCommand.Json()).rowSubjectKind());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadCommand.Json#rowSubjectQualifier()}
   */
  @Test
  void testJsonRowSubjectQualifier() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUploadCommand.Json()).rowSubjectQualifier());
  }

  /**
   * Method under test: {@link ImmutableBulkUploadCommand.Json#targetDomain()}
   */
  @Test
  void testJsonTargetDomain() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBulkUploadCommand.Json()).targetDomain());
  }

  /**
   * Method under test: {@link ImmutableBulkUploadCommand.Json#uploadMode()}
   */
  @Test
  void testJsonUploadMode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBulkUploadCommand.Json()).uploadMode());
  }
}
