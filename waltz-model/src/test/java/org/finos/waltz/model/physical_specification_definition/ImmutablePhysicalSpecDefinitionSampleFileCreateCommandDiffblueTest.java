package org.finos.waltz.model.physical_specification_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.Builder;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalSpecDefinitionSampleFileCreateCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#fileData(String)}.
   * <p>
   * Method under test: {@link Builder#fileData(String)}
   */
  @Test
  @DisplayName("Test Builder fileData(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.fileData(String)"})
  void testBuilderFileData() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.fileData("File Data"));
  }

  /**
   * Test Builder {@link Builder#from(PhysicalSpecDefinitionSampleFileCreateCommand)}.
   * <ul>
   *   <li>Given {@code File Data}.</li>
   *   <li>Then builder build fileData is {@code File Data}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalSpecDefinitionSampleFileCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalSpecDefinitionSampleFileCreateCommand); given 'File Data'; then builder build fileData is 'File Data'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalSpecDefinitionSampleFileCreateCommand)"})
  void testBuilderFrom_givenFileData_thenBuilderBuildFileDataIsFileData() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.builder();
    PhysicalSpecDefinitionSampleFileCreateCommand instance = mock(PhysicalSpecDefinitionSampleFileCreateCommand.class);
    when(instance.fileData()).thenReturn("File Data");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).fileData();
    verify(instance).name();
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand buildResult = builderResult.build();
    assertEquals("File Data", buildResult.fileData());
    assertEquals("Name", buildResult.name());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalSpecDefinitionSampleFileCreateCommand)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalSpecDefinitionSampleFileCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalSpecDefinitionSampleFileCreateCommand); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalSpecDefinitionSampleFileCreateCommand)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.builder();
    PhysicalSpecDefinitionSampleFileCreateCommand instance = mock(PhysicalSpecDefinitionSampleFileCreateCommand.class);
    when(instance.fileData()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).fileData();
    verify(instance).name();
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Json {@link Json#fileData()}.
   * <p>
   * Method under test: {@link Json#fileData()}
   */
  @Test
  @DisplayName("Test Json fileData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.fileData()"})
  void testJsonFileData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).fileData());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setFileData(String)}
   *   <li>{@link Json#setName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setFileData(String)", "void Json.setName(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setFileData("File Data");
    actualJson.setName("Name");

    // Assert
    assertEquals("File Data", actualJson.fileData);
    assertEquals("Name", actualJson.name);
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
  }
}
