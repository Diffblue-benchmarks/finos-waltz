package org.finos.waltz.model.physical_specification_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalSpecDefinitionSampleFileDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionSampleFile.Builder#fileData(String)}
   */
  @Test
  void testBuilderFileData() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFile.Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.fileData("File Data"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionSampleFile.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFile.Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile
        .builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutablePhysicalSpecDefinitionSampleFile.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionSampleFile.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFile.Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile
        .builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutablePhysicalSpecDefinitionSampleFile.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionSampleFile.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFile.Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile
        .builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionSampleFile.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFile.Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile
        .builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecDefinitionSampleFile.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionSampleFile.Builder#from(PhysicalSpecDefinitionSampleFile)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFile.Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile
        .builder();
    PhysicalSpecDefinitionSampleFile instance = mock(PhysicalSpecDefinitionSampleFile.class);
    when(instance.fileData()).thenReturn("File Data");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.specDefinitionId()).thenReturn(1L);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecDefinitionSampleFile.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).name();
    verify(instance).fileData();
    verify(instance).specDefinitionId();
    ImmutablePhysicalSpecDefinitionSampleFile buildResult = builderResult.build();
    assertEquals("File Data", buildResult.fileData());
    assertEquals("Name", buildResult.name());
    assertEquals(1L, buildResult.specDefinitionId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionSampleFile.Builder#from(PhysicalSpecDefinitionSampleFile)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFile.Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile
        .builder();
    PhysicalSpecDefinitionSampleFile instance = mock(PhysicalSpecDefinitionSampleFile.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).name();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionSampleFile.Builder#from(PhysicalSpecDefinitionSampleFile)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFile.Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile
        .builder();
    PhysicalSpecDefinitionSampleFile instance = mock(PhysicalSpecDefinitionSampleFile.class);
    when(instance.fileData()).thenReturn("File Data");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.specDefinitionId()).thenReturn(1L);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecDefinitionSampleFile.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).name();
    verify(instance).fileData();
    verify(instance).specDefinitionId();
    ImmutablePhysicalSpecDefinitionSampleFile buildResult = builderResult.build();
    assertEquals("File Data", buildResult.fileData());
    assertEquals("Name", buildResult.name());
    assertEquals(1L, buildResult.specDefinitionId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionSampleFile.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFile.Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionSampleFile.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFile.Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile
        .builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionSampleFile.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFile.Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionSampleFile.Builder#specDefinitionId(long)}
   */
  @Test
  void testBuilderSpecDefinitionId() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFile.Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.specDefinitionId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionSampleFile#copyOf(PhysicalSpecDefinitionSampleFile)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    PhysicalSpecDefinitionSampleFile instance = mock(PhysicalSpecDefinitionSampleFile.class);
    when(instance.fileData()).thenReturn("File Data");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.specDefinitionId()).thenReturn(1L);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecDefinitionSampleFile actualCopyOfResult = ImmutablePhysicalSpecDefinitionSampleFile
        .copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).name();
    verify(instance).fileData();
    verify(instance).specDefinitionId();
    assertEquals("File Data", actualCopyOfResult.fileData());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals(1L, actualCopyOfResult.specDefinitionId());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionSampleFile#copyOf(PhysicalSpecDefinitionSampleFile)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    PhysicalSpecDefinitionSampleFile instance = mock(PhysicalSpecDefinitionSampleFile.class);
    when(instance.fileData()).thenReturn("File Data");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.specDefinitionId()).thenReturn(1L);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecDefinitionSampleFile actualCopyOfResult = ImmutablePhysicalSpecDefinitionSampleFile
        .copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).name();
    verify(instance).fileData();
    verify(instance).specDefinitionId();
    assertEquals("File Data", actualCopyOfResult.fileData());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals(1L, actualCopyOfResult.specDefinitionId());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionSampleFile.Json#fileData()}
   */
  @Test
  void testJsonFileData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecDefinitionSampleFile.Json()).fileData());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionSampleFile.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecDefinitionSampleFile.Json()).id());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionSampleFile.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecDefinitionSampleFile.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutablePhysicalSpecDefinitionSampleFile.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinitionSampleFile.Json actualJson = new ImmutablePhysicalSpecDefinitionSampleFile.Json();

    // Assert
    assertNull(actualJson.fileData);
    assertNull(actualJson.name);
    assertEquals(0L, actualJson.specDefinitionId);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.specDefinitionIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionSampleFile.Json#setSpecDefinitionId(long)}
   */
  @Test
  void testJsonSetSpecDefinitionId() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFile.Json json = new ImmutablePhysicalSpecDefinitionSampleFile.Json();

    // Act
    json.setSpecDefinitionId(1L);

    // Assert
    assertEquals(1L, json.specDefinitionId);
    assertTrue(json.specDefinitionIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionSampleFile.Json#specDefinitionId()}
   */
  @Test
  void testJsonSpecDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecDefinitionSampleFile.Json()).specDefinitionId());
  }
}
