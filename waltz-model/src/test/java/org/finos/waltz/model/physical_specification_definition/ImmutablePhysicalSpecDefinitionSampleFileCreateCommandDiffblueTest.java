package org.finos.waltz.model.physical_specification_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalSpecDefinitionSampleFileCreateCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.Builder#fileData(String)}
   */
  @Test
  void testBuilderFileData() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFileCreateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.fileData("File Data"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.Builder#from(PhysicalSpecDefinitionSampleFileCreateCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFileCreateCommand
        .builder();
    PhysicalSpecDefinitionSampleFileCreateCommand instance = mock(PhysicalSpecDefinitionSampleFileCreateCommand.class);
    when(instance.fileData()).thenReturn("File Data");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).fileData();
    verify(instance).name();
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand buildResult = builderResult.build();
    assertEquals("File Data", buildResult.fileData());
    assertEquals("Name", buildResult.name());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.Builder#from(PhysicalSpecDefinitionSampleFileCreateCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFileCreateCommand
        .builder();
    PhysicalSpecDefinitionSampleFileCreateCommand instance = mock(PhysicalSpecDefinitionSampleFileCreateCommand.class);
    when(instance.fileData()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).fileData();
    verify(instance).name();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFileCreateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#copyOf(PhysicalSpecDefinitionSampleFileCreateCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    PhysicalSpecDefinitionSampleFileCreateCommand instance = mock(PhysicalSpecDefinitionSampleFileCreateCommand.class);
    when(instance.fileData()).thenReturn("File Data");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand actualCopyOfResult = ImmutablePhysicalSpecDefinitionSampleFileCreateCommand
        .copyOf(instance);

    // Assert
    verify(instance).fileData();
    verify(instance).name();
    assertEquals("File Data", actualCopyOfResult.fileData());
    assertEquals("Name", actualCopyOfResult.name());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#fromJson(ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.Json json = new ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.Json();
    json.setName("Json");
    json.setFileData("Json");

    // Act
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand actualFromJsonResult = ImmutablePhysicalSpecDefinitionSampleFileCreateCommand
        .fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.fileData());
    assertEquals("Json", actualFromJsonResult.name());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.Json#fileData()}
   */
  @Test
  void testJsonFileData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.Json()).fileData());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.Json}
   *   <li>
   * {@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.Json#setFileData(String)}
   *   <li>
   * {@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.Json#setName(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.Json actualJson = new ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.Json();
    actualJson.setFileData("File Data");
    actualJson.setName("Name");

    // Assert
    assertEquals("File Data", actualJson.fileData);
    assertEquals("Name", actualJson.name);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.Json()).name());
  }
}
