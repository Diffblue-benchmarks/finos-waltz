package org.finos.waltz.model.physical_specification_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.Builder;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalSpecDefinitionSampleFileCreateCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalSpecDefinitionSampleFileCreateCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand
        actualImmutablePhysicalSpecDefinitionSampleFileCreateCommand =
            ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.builder()
                .fileData("File Data")
                .name("Name")
                .build();

    // Assert
    assertEquals(
        "File Data", actualImmutablePhysicalSpecDefinitionSampleFileCreateCommand.fileData());
    assertEquals("Name", actualImmutablePhysicalSpecDefinitionSampleFileCreateCommand.name());
  }

  /**
   * Test Builder {@link Builder#fileData(String)}.
   *
   * <ul>
   *   <li>When {@code File Data}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#fileData(String)}
   */
  @Test
  @DisplayName("Test Builder fileData(String); when 'File Data'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.fileData(String)"})
  void testBuilderFileData_whenFileData_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.builder();

    // Act
    Builder actualFileDataResult = builderResult.fileData("File Data");

    // Assert
    assertSame(builderResult, actualFileDataResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalSpecDefinitionSampleFileCreateCommand)}.
   *
   * <ul>
   *   <li>Then builder build is builder fileData {@code File Data} name {@code Name} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(PhysicalSpecDefinitionSampleFileCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(PhysicalSpecDefinitionSampleFileCreateCommand); then builder build is builder fileData 'File Data' name 'Name' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalSpecDefinitionSampleFileCreateCommand)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderFileDataFileDataNameNameBuild() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.builder();
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand instance =
        ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.builder()
            .fileData("File Data")
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand
        actualImmutablePhysicalSpecDefinitionSampleFileCreateCommand = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinitionSampleFileCreateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test {@link
   * ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#copyOf(PhysicalSpecDefinitionSampleFileCreateCommand)}.
   *
   * <ul>
   *   <li>When builder fileData {@code File Data} name {@code Name} build.
   *   <li>Then return {@code File Data}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#copyOf(PhysicalSpecDefinitionSampleFileCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(PhysicalSpecDefinitionSampleFileCreateCommand); when builder fileData 'File Data' name 'Name' build; then return 'File Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionSampleFileCreateCommand ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.copyOf(PhysicalSpecDefinitionSampleFileCreateCommand)"
  })
  void testCopyOf_whenBuilderFileDataFileDataNameNameBuild_thenReturnFileData() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand instance =
        ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.builder()
            .fileData("File Data")
            .name("Name")
            .build();

    // Act
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand actualCopyOfResult =
        ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.copyOf(instance);

    // Assert
    assertEquals("File Data", actualCopyOfResult.fileData());
    assertEquals("Name", actualCopyOfResult.name());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#equals(Object)}, and {@link
   * ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#equals(Object)}
   *   <li>{@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand
        immutablePhysicalSpecDefinitionSampleFileCreateCommand =
            ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.builder()
                .fileData("File Data")
                .name("Name")
                .build();
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand
        immutablePhysicalSpecDefinitionSampleFileCreateCommand2 =
            ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.builder()
                .fileData("File Data")
                .name("Name")
                .build();

    // Act and Assert
    assertEquals(
        immutablePhysicalSpecDefinitionSampleFileCreateCommand,
        immutablePhysicalSpecDefinitionSampleFileCreateCommand2);
    assertEquals(
        immutablePhysicalSpecDefinitionSampleFileCreateCommand.hashCode(),
        immutablePhysicalSpecDefinitionSampleFileCreateCommand2.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#equals(Object)}, and {@link
   * ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#equals(Object)}
   *   <li>{@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand
        immutablePhysicalSpecDefinitionSampleFileCreateCommand =
            ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.builder()
                .fileData("File Data")
                .name("Name")
                .build();

    // Act and Assert
    assertEquals(
        immutablePhysicalSpecDefinitionSampleFileCreateCommand,
        immutablePhysicalSpecDefinitionSampleFileCreateCommand);
    int expectedHashCodeResult = immutablePhysicalSpecDefinitionSampleFileCreateCommand.hashCode();
    assertEquals(
        expectedHashCodeResult, immutablePhysicalSpecDefinitionSampleFileCreateCommand.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand
        immutablePhysicalSpecDefinitionSampleFileCreateCommand =
            ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.builder()
                .fileData("Name")
                .name("Name")
                .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinitionSampleFileCreateCommand,
        ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.builder()
            .fileData("File Data")
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand
        immutablePhysicalSpecDefinitionSampleFileCreateCommand =
            ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.builder()
                .fileData("File Data")
                .name("File Data")
                .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinitionSampleFileCreateCommand,
        ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.builder()
            .fileData("File Data")
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.builder()
            .fileData("File Data")
            .name("Name")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.builder()
            .fileData("File Data")
            .name("Name")
            .build(),
        "Different type to ImmutablePhysicalSpecDefinitionSampleFileCreateCommand");
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Name is {@code Json}.
   *   <li>Then return fileData is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Name is 'Json'; then return fileData is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionSampleFileCreateCommand ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonNameIsJson_thenReturnFileDataIsJson() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setFileData("Json");

    // Act
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand actualFromJsonResult =
        ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.fileData());
    assertEquals("Json", actualFromJsonResult.name());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#toString()}
   *   <li>{@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#fileData()}
   *   <li>{@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#name()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.fileData()",
    "String ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.name()",
    "String ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand
        immutablePhysicalSpecDefinitionSampleFileCreateCommand =
            ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.builder()
                .fileData("File Data")
                .name("Name")
                .build();

    // Act
    String actualToStringResult = immutablePhysicalSpecDefinitionSampleFileCreateCommand.toString();
    String actualFileDataResult = immutablePhysicalSpecDefinitionSampleFileCreateCommand.fileData();

    // Assert
    assertEquals("File Data", actualFileDataResult);
    assertEquals("Name", immutablePhysicalSpecDefinitionSampleFileCreateCommand.name());
    assertEquals(
        "PhysicalSpecDefinitionSampleFileCreateCommand{name=Name, fileData=File Data}",
        actualToStringResult);
  }

  /**
   * Test Json {@link Json#fileData()}.
   *
   * <p>Method under test: {@link Json#fileData()}
   */
  @Test
  @DisplayName("Test Json fileData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.fileData()"})
  void testJsonFileData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().fileData());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setFileData(String)}
   *   <li>{@link Json#setName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setFileData(String)",
    "void Json.setName(String)"
  })
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
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#withFileData(String)}.
   *
   * <ul>
   *   <li>Then return builder fileData {@code 42} name {@code Name} build.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#withFileData(String)}
   */
  @Test
  @DisplayName("Test withFileData(String); then return builder fileData '42' name 'Name' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionSampleFileCreateCommand ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.withFileData(String)"
  })
  void testWithFileData_thenReturnBuilderFileData42NameNameBuild() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand
        immutablePhysicalSpecDefinitionSampleFileCreateCommand =
            ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.builder()
                .fileData("42")
                .name("Name")
                .build();

    // Act
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand actualWithFileDataResult =
        immutablePhysicalSpecDefinitionSampleFileCreateCommand.withFileData("42");

    // Assert
    assertSame(immutablePhysicalSpecDefinitionSampleFileCreateCommand, actualWithFileDataResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#withFileData(String)}.
   *
   * <ul>
   *   <li>Then return fileData is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#withFileData(String)}
   */
  @Test
  @DisplayName("Test withFileData(String); then return fileData is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionSampleFileCreateCommand ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.withFileData(String)"
  })
  void testWithFileData_thenReturnFileDataIs42() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand actualWithFileDataResult =
        ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.builder()
            .fileData("File Data")
            .name("Name")
            .build()
            .withFileData("42");

    // Assert
    assertEquals("42", actualWithFileDataResult.fileData());
    assertEquals("Name", actualWithFileDataResult.name());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#withName(String)}.
   *
   * <ul>
   *   <li>Given builder fileData {@code File Data} name {@code Name} build.
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#withName(String)}
   */
  @Test
  @DisplayName(
      "Test withName(String); given builder fileData 'File Data' name 'Name' build; then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionSampleFileCreateCommand ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.withName(String)"
  })
  void testWithName_givenBuilderFileDataFileDataNameNameBuild_thenReturnNameIs42() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand actualWithNameResult =
        ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.builder()
            .fileData("File Data")
            .name("Name")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("File Data", actualWithNameResult.fileData());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#withName(String)}.
   *
   * <ul>
   *   <li>Then return builder fileData {@code File Data} name {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionSampleFileCreateCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return builder fileData 'File Data' name '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionSampleFileCreateCommand ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.withName(String)"
  })
  void testWithName_thenReturnBuilderFileDataFileDataName42Build() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand
        immutablePhysicalSpecDefinitionSampleFileCreateCommand =
            ImmutablePhysicalSpecDefinitionSampleFileCreateCommand.builder()
                .fileData("File Data")
                .name("42")
                .build();

    // Act
    ImmutablePhysicalSpecDefinitionSampleFileCreateCommand actualWithNameResult =
        immutablePhysicalSpecDefinitionSampleFileCreateCommand.withName("42");

    // Assert
    assertSame(immutablePhysicalSpecDefinitionSampleFileCreateCommand, actualWithNameResult);
  }
}
