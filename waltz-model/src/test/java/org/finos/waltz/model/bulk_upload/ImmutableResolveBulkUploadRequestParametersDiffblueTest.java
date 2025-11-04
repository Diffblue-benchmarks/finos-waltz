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

class ImmutableResolveBulkUploadRequestParametersDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadRequestParameters.Builder#from(ResolveBulkUploadRequestParameters)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableResolveBulkUploadRequestParameters.Builder builderResult = ImmutableResolveBulkUploadRequestParameters
        .builder();
    ResolveBulkUploadRequestParameters instance = mock(ResolveBulkUploadRequestParameters.class);
    when(instance.targetDomain()).thenThrow(new IllegalStateException("instance"));
    when(instance.inputString()).thenReturn("Input String");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).inputString();
    verify(instance).targetDomain();
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadRequestParameters.Builder#from(ResolveBulkUploadRequestParameters)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableResolveBulkUploadRequestParameters.Builder builderResult = ImmutableResolveBulkUploadRequestParameters
        .builder();
    ResolveBulkUploadRequestParameters instance = mock(ResolveBulkUploadRequestParameters.class);
    when(instance.rowSubjectQualifier()).thenThrow(new IllegalStateException("instance"));
    when(instance.rowSubjectKind()).thenReturn(EntityKind.ALL);
    when(instance.targetDomain()).thenReturn(mock(EntityReference.class));
    when(instance.inputString()).thenReturn("Input String");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).inputString();
    verify(instance).rowSubjectKind();
    verify(instance).rowSubjectQualifier();
    verify(instance).targetDomain();
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadRequestParameters.Builder#from(ResolveBulkUploadRequestParameters)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableResolveBulkUploadRequestParameters.Builder builderResult = ImmutableResolveBulkUploadRequestParameters
        .builder();
    ResolveBulkUploadRequestParameters instance = mock(ResolveBulkUploadRequestParameters.class);
    Optional<EntityReference> ofResult = Optional.of(mock(EntityReference.class));
    when(instance.rowSubjectQualifier()).thenReturn(ofResult);
    when(instance.rowSubjectKind()).thenReturn(EntityKind.ALL);
    when(instance.targetDomain()).thenReturn(mock(EntityReference.class));
    when(instance.inputString()).thenReturn("Input String");

    // Act
    ImmutableResolveBulkUploadRequestParameters.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).inputString();
    verify(instance).rowSubjectKind();
    verify(instance).rowSubjectQualifier();
    verify(instance).targetDomain();
    ImmutableResolveBulkUploadRequestParameters buildResult = builderResult.build();
    assertEquals("Input String", buildResult.inputString());
    assertEquals(EntityKind.ALL, buildResult.rowSubjectKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadRequestParameters.Builder#from(ResolveBulkUploadRequestParameters)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableResolveBulkUploadRequestParameters.Builder builderResult = ImmutableResolveBulkUploadRequestParameters
        .builder();
    ResolveBulkUploadRequestParameters instance = mock(ResolveBulkUploadRequestParameters.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(instance.rowSubjectQualifier()).thenReturn(emptyResult);
    when(instance.rowSubjectKind()).thenReturn(EntityKind.ALL);
    when(instance.targetDomain()).thenReturn(mock(EntityReference.class));
    when(instance.inputString()).thenReturn("Input String");

    // Act
    ImmutableResolveBulkUploadRequestParameters.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).inputString();
    verify(instance).rowSubjectKind();
    verify(instance).rowSubjectQualifier();
    verify(instance).targetDomain();
    ImmutableResolveBulkUploadRequestParameters buildResult = builderResult.build();
    assertEquals("Input String", buildResult.inputString());
    assertEquals(EntityKind.ALL, buildResult.rowSubjectKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadRequestParameters.Builder#inputString(String)}
   */
  @Test
  void testBuilderInputString() {
    // Arrange
    ImmutableResolveBulkUploadRequestParameters.Builder builderResult = ImmutableResolveBulkUploadRequestParameters
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.inputString("Input String"));
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadRequestParameters.Builder#inputString(String)}
   */
  @Test
  void testBuilderInputString2() {
    // Arrange
    ImmutableResolveBulkUploadRequestParameters.Builder builderResult = ImmutableResolveBulkUploadRequestParameters
        .builder();
    builderResult.rowSubjectQualifier(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.inputString("Input String"));
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadRequestParameters.Builder#rowSubjectKind(EntityKind)}
   */
  @Test
  void testBuilderRowSubjectKind() {
    // Arrange
    ImmutableResolveBulkUploadRequestParameters.Builder builderResult = ImmutableResolveBulkUploadRequestParameters
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rowSubjectKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadRequestParameters.Builder#rowSubjectKind(EntityKind)}
   */
  @Test
  void testBuilderRowSubjectKind2() {
    // Arrange
    ImmutableResolveBulkUploadRequestParameters.Builder builderResult = ImmutableResolveBulkUploadRequestParameters
        .builder();
    builderResult.rowSubjectQualifier(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.rowSubjectKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadRequestParameters.Builder#targetDomain(EntityReference)}
   */
  @Test
  void testBuilderTargetDomain() {
    // Arrange
    ImmutableResolveBulkUploadRequestParameters.Builder builderResult = ImmutableResolveBulkUploadRequestParameters
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetDomain(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadRequestParameters#copyOf(ResolveBulkUploadRequestParameters)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ResolveBulkUploadRequestParameters instance = mock(ResolveBulkUploadRequestParameters.class);
    Optional<EntityReference> ofResult = Optional.of(mock(EntityReference.class));
    when(instance.rowSubjectQualifier()).thenReturn(ofResult);
    when(instance.rowSubjectKind()).thenReturn(EntityKind.ALL);
    when(instance.targetDomain()).thenReturn(mock(EntityReference.class));
    when(instance.inputString()).thenReturn("Input String");

    // Act
    ImmutableResolveBulkUploadRequestParameters actualCopyOfResult = ImmutableResolveBulkUploadRequestParameters
        .copyOf(instance);

    // Assert
    verify(instance).inputString();
    verify(instance).rowSubjectKind();
    verify(instance).rowSubjectQualifier();
    verify(instance).targetDomain();
    assertEquals("Input String", actualCopyOfResult.inputString());
    assertEquals(EntityKind.ALL, actualCopyOfResult.rowSubjectKind());
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadRequestParameters#copyOf(ResolveBulkUploadRequestParameters)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ResolveBulkUploadRequestParameters instance = mock(ResolveBulkUploadRequestParameters.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(instance.rowSubjectQualifier()).thenReturn(emptyResult);
    when(instance.rowSubjectKind()).thenReturn(EntityKind.ALL);
    when(instance.targetDomain()).thenReturn(mock(EntityReference.class));
    when(instance.inputString()).thenReturn("Input String");

    // Act
    ImmutableResolveBulkUploadRequestParameters actualCopyOfResult = ImmutableResolveBulkUploadRequestParameters
        .copyOf(instance);

    // Assert
    verify(instance).inputString();
    verify(instance).rowSubjectKind();
    verify(instance).rowSubjectQualifier();
    verify(instance).targetDomain();
    assertEquals("Input String", actualCopyOfResult.inputString());
    assertEquals(EntityKind.ALL, actualCopyOfResult.rowSubjectKind());
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadRequestParameters#fromJson(ImmutableResolveBulkUploadRequestParameters.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableResolveBulkUploadRequestParameters.Json json = new ImmutableResolveBulkUploadRequestParameters.Json();
    json.setRowSubjectKind(EntityKind.ALL);
    json.setInputString("targetDomain");
    json.setTargetDomain(mock(EntityReference.class));

    // Act
    ImmutableResolveBulkUploadRequestParameters actualFromJsonResult = ImmutableResolveBulkUploadRequestParameters
        .fromJson(json);

    // Assert
    assertEquals("targetDomain", actualFromJsonResult.inputString());
    assertEquals(EntityKind.ALL, actualFromJsonResult.rowSubjectKind());
    EntityReference expectedTargetDomainResult = json.targetDomain;
    assertSame(expectedTargetDomainResult, actualFromJsonResult.targetDomain());
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadRequestParameters.Json#inputString()}
   */
  @Test
  void testJsonInputString() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableResolveBulkUploadRequestParameters.Json()).inputString());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableResolveBulkUploadRequestParameters.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableResolveBulkUploadRequestParameters.Json actualJson = new ImmutableResolveBulkUploadRequestParameters.Json();

    // Assert
    assertNull(actualJson.inputString);
    assertNull(actualJson.rowSubjectKind);
    assertNull(actualJson.targetDomain);
    assertFalse(actualJson.rowSubjectQualifier.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadRequestParameters.Json#rowSubjectKind()}
   */
  @Test
  void testJsonRowSubjectKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableResolveBulkUploadRequestParameters.Json()).rowSubjectKind());
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadRequestParameters.Json#rowSubjectQualifier()}
   */
  @Test
  void testJsonRowSubjectQualifier() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableResolveBulkUploadRequestParameters.Json()).rowSubjectQualifier());
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadRequestParameters.Json#targetDomain()}
   */
  @Test
  void testJsonTargetDomain() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableResolveBulkUploadRequestParameters.Json()).targetDomain());
  }
}
