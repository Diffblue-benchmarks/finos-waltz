package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.report_grid.ImmutableReportGridUpdateCommand.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridUpdateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridUpdateCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#kind(ReportGridKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridUpdateCommand Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.kind(ReportGridKind)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableReportGridUpdateCommand actualImmutableReportGridUpdateCommand =
        ImmutableReportGridUpdateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .build();

    // Assert
    assertEquals("Name", actualImmutableReportGridUpdateCommand.name());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableReportGridUpdateCommand.description());
    assertEquals(ReportGridKind.PUBLIC, actualImmutableReportGridUpdateCommand.kind());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridUpdateCommand)}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridUpdateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridUpdateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridUpdateCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableReportGridUpdateCommand.builder();
    ImmutableReportGridUpdateCommand instance =
        ImmutableReportGridUpdateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableReportGridUpdateCommand actualImmutableReportGridUpdateCommand = builderResult.build();
    assertEquals(instance, actualImmutableReportGridUpdateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridUpdateCommand)}.
   *
   * <ul>
   *   <li>Then builder build is builder description {@code null} kind {@code PUBLIC} name {@code
   *       Name} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ReportGridUpdateCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ReportGridUpdateCommand); then builder build is builder description 'null' kind 'PUBLIC' name 'Name' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridUpdateCommand)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderDescriptionNullKindPublicNameNameBuild() {
    // Arrange
    Builder builderResult = ImmutableReportGridUpdateCommand.builder();
    ImmutableReportGridUpdateCommand instance =
        ImmutableReportGridUpdateCommand.builder()
            .description(null)
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableReportGridUpdateCommand actualImmutableReportGridUpdateCommand = builderResult.build();
    assertEquals(instance, actualImmutableReportGridUpdateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then builder build name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then builder build name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenBuilderBuildNameIsName() {
    // Arrange
    Builder builderResult = ImmutableReportGridUpdateCommand.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    ImmutableReportGridUpdateCommand immutableReportGridUpdateCommand = builderResult.build();
    assertEquals("Name", immutableReportGridUpdateCommand.name());
    assertNull(immutableReportGridUpdateCommand.description());
    assertEquals(ReportGridKind.PUBLIC, immutableReportGridUpdateCommand.kind());
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test {@link ImmutableReportGridUpdateCommand#copyOf(ReportGridUpdateCommand)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridUpdateCommand#copyOf(ReportGridUpdateCommand)}
   */
  @Test
  @DisplayName("Test copyOf(ReportGridUpdateCommand); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridUpdateCommand ImmutableReportGridUpdateCommand.copyOf(ReportGridUpdateCommand)"
  })
  void testCopyOf_thenReturnName() {
    // Arrange
    ImmutableReportGridUpdateCommand instance =
        ImmutableReportGridUpdateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .build();

    // Act
    ImmutableReportGridUpdateCommand actualCopyOfResult =
        ImmutableReportGridUpdateCommand.copyOf(instance);

    // Assert
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(ReportGridKind.PUBLIC, actualCopyOfResult.kind());
  }

  /**
   * Test {@link ImmutableReportGridUpdateCommand#equals(Object)}, and {@link
   * ImmutableReportGridUpdateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridUpdateCommand#equals(Object)}
   *   <li>{@link ImmutableReportGridUpdateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridUpdateCommand.equals(Object)",
    "int ImmutableReportGridUpdateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableReportGridUpdateCommand immutableReportGridUpdateCommand =
        ImmutableReportGridUpdateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .build();
    ImmutableReportGridUpdateCommand immutableReportGridUpdateCommand2 =
        ImmutableReportGridUpdateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableReportGridUpdateCommand, immutableReportGridUpdateCommand2);
    assertEquals(
        immutableReportGridUpdateCommand.hashCode(), immutableReportGridUpdateCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridUpdateCommand#equals(Object)}, and {@link
   * ImmutableReportGridUpdateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridUpdateCommand#equals(Object)}
   *   <li>{@link ImmutableReportGridUpdateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridUpdateCommand.equals(Object)",
    "int ImmutableReportGridUpdateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableReportGridUpdateCommand immutableReportGridUpdateCommand =
        ImmutableReportGridUpdateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableReportGridUpdateCommand, immutableReportGridUpdateCommand);
    int expectedHashCodeResult = immutableReportGridUpdateCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableReportGridUpdateCommand.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridUpdateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridUpdateCommand.equals(Object)",
    "int ImmutableReportGridUpdateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableReportGridUpdateCommand immutableReportGridUpdateCommand =
        ImmutableReportGridUpdateCommand.builder()
            .description("Name")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridUpdateCommand,
        ImmutableReportGridUpdateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableReportGridUpdateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridUpdateCommand.equals(Object)",
    "int ImmutableReportGridUpdateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableReportGridUpdateCommand immutableReportGridUpdateCommand =
        ImmutableReportGridUpdateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PRIVATE)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridUpdateCommand,
        ImmutableReportGridUpdateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableReportGridUpdateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridUpdateCommand.equals(Object)",
    "int ImmutableReportGridUpdateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableReportGridUpdateCommand immutableReportGridUpdateCommand =
        ImmutableReportGridUpdateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("java.lang.String")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridUpdateCommand,
        ImmutableReportGridUpdateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableReportGridUpdateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridUpdateCommand.equals(Object)",
    "int ImmutableReportGridUpdateCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableReportGridUpdateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableReportGridUpdateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridUpdateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridUpdateCommand.equals(Object)",
    "int ImmutableReportGridUpdateCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableReportGridUpdateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .build(),
        "Different type to ImmutableReportGridUpdateCommand");
  }

  /**
   * Test {@link ImmutableReportGridUpdateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Description is {@code null}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridUpdateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Description is 'null'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridUpdateCommand ImmutableReportGridUpdateCommand.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonDescriptionIsNull_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setDescription(null);
    json.setKind(ReportGridKind.PUBLIC);

    // Act
    ImmutableReportGridUpdateCommand actualFromJsonResult =
        ImmutableReportGridUpdateCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(ReportGridKind.PUBLIC, actualFromJsonResult.kind());
  }

  /**
   * Test {@link ImmutableReportGridUpdateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Kind is {@code null}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridUpdateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Kind is 'null'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridUpdateCommand ImmutableReportGridUpdateCommand.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonKindIsNull_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setDescription("Json");
    json.setKind(null);

    // Act
    ImmutableReportGridUpdateCommand actualFromJsonResult =
        ImmutableReportGridUpdateCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals(ReportGridKind.PUBLIC, actualFromJsonResult.kind());
  }

  /**
   * Test {@link ImmutableReportGridUpdateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code PUBLIC}.
   *   <li>When {@link Json} (default constructor) Description is {@code Json}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridUpdateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'PUBLIC'; when Json (default constructor) Description is 'Json'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridUpdateCommand ImmutableReportGridUpdateCommand.fromJson(Json)"
  })
  void testFromJson_givenPublic_whenJsonDescriptionIsJson_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setDescription("Json");
    json.setKind(ReportGridKind.PUBLIC);

    // Act
    ImmutableReportGridUpdateCommand actualFromJsonResult =
        ImmutableReportGridUpdateCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals(ReportGridKind.PUBLIC, actualFromJsonResult.kind());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridUpdateCommand#toString()}
   *   <li>{@link ImmutableReportGridUpdateCommand#description()}
   *   <li>{@link ImmutableReportGridUpdateCommand#kind()}
   *   <li>{@link ImmutableReportGridUpdateCommand#name()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableReportGridUpdateCommand.description()",
    "ReportGridKind ImmutableReportGridUpdateCommand.kind()",
    "String ImmutableReportGridUpdateCommand.name()",
    "String ImmutableReportGridUpdateCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableReportGridUpdateCommand immutableReportGridUpdateCommand =
        ImmutableReportGridUpdateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .build();

    // Act
    String actualToStringResult = immutableReportGridUpdateCommand.toString();
    String actualDescriptionResult = immutableReportGridUpdateCommand.description();
    ReportGridKind actualKindResult = immutableReportGridUpdateCommand.kind();

    // Assert
    assertEquals("Name", immutableReportGridUpdateCommand.name());
    assertEquals(
        "ReportGridUpdateCommand{name=Name, description=The characteristics of someone or something,"
            + " kind=PUBLIC}",
        actualToStringResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(ReportGridKind.PUBLIC, actualKindResult);
  }

  /**
   * Test Json {@link Json#description()}.
   *
   * <p>Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setKind(ReportGridKind)}
   *   <li>{@link Json#setName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setDescription(String)",
    "void Json.setKind(ReportGridKind)",
    "void Json.setName(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setKind(ReportGridKind.PUBLIC);
    actualJson.setName("Name");

    // Assert
    assertEquals("Name", actualJson.name);
    assertEquals("The characteristics of someone or something", actualJson.description);
    assertEquals(ReportGridKind.PUBLIC, actualJson.kind);
  }

  /**
   * Test Json {@link Json#kind()}.
   *
   * <p>Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().kind());
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
   * Test {@link ImmutableReportGridUpdateCommand#withDescription(String)}.
   *
   * <ul>
   *   <li>Then return builder description {@code 42} kind {@code PUBLIC} name {@code Name} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridUpdateCommand#withDescription(String)}
   */
  @Test
  @DisplayName(
      "Test withDescription(String); then return builder description '42' kind 'PUBLIC' name 'Name' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridUpdateCommand ImmutableReportGridUpdateCommand.withDescription(String)"
  })
  void testWithDescription_thenReturnBuilderDescription42KindPublicNameNameBuild() {
    // Arrange
    ImmutableReportGridUpdateCommand immutableReportGridUpdateCommand =
        ImmutableReportGridUpdateCommand.builder()
            .description("42")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .build();

    // Act
    ImmutableReportGridUpdateCommand actualWithDescriptionResult =
        immutableReportGridUpdateCommand.withDescription("42");

    // Assert
    assertSame(immutableReportGridUpdateCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableReportGridUpdateCommand#withDescription(String)}.
   *
   * <ul>
   *   <li>Then return description is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridUpdateCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String); then return description is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridUpdateCommand ImmutableReportGridUpdateCommand.withDescription(String)"
  })
  void testWithDescription_thenReturnDescriptionIs42() {
    // Arrange and Act
    ImmutableReportGridUpdateCommand actualWithDescriptionResult =
        ImmutableReportGridUpdateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .build()
            .withDescription("42");

    // Assert
    assertEquals("42", actualWithDescriptionResult.description());
    assertEquals("Name", actualWithDescriptionResult.name());
    assertEquals(ReportGridKind.PUBLIC, actualWithDescriptionResult.kind());
  }

  /**
   * Test {@link ImmutableReportGridUpdateCommand#withKind(ReportGridKind)}.
   *
   * <p>Method under test: {@link ImmutableReportGridUpdateCommand#withKind(ReportGridKind)}
   */
  @Test
  @DisplayName("Test withKind(ReportGridKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridUpdateCommand ImmutableReportGridUpdateCommand.withKind(ReportGridKind)"
  })
  void testWithKind() {
    // Arrange
    ImmutableReportGridUpdateCommand immutableReportGridUpdateCommand =
        ImmutableReportGridUpdateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .build();

    // Act
    ImmutableReportGridUpdateCommand actualWithKindResult =
        immutableReportGridUpdateCommand.withKind(ReportGridKind.PUBLIC);

    // Assert
    assertSame(immutableReportGridUpdateCommand, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableReportGridUpdateCommand#withKind(ReportGridKind)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridUpdateCommand#withKind(ReportGridKind)}
   */
  @Test
  @DisplayName("Test withKind(ReportGridKind); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridUpdateCommand ImmutableReportGridUpdateCommand.withKind(ReportGridKind)"
  })
  void testWithKind_thenReturnName() {
    // Arrange and Act
    ImmutableReportGridUpdateCommand actualWithKindResult =
        ImmutableReportGridUpdateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PRIVATE)
            .name("Name")
            .build()
            .withKind(ReportGridKind.PUBLIC);

    // Assert
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(ReportGridKind.PUBLIC, actualWithKindResult.kind());
  }

  /**
   * Test {@link ImmutableReportGridUpdateCommand#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableReportGridUpdateCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridUpdateCommand ImmutableReportGridUpdateCommand.withName(String)"
  })
  void testWithName() {
    // Arrange
    ImmutableReportGridUpdateCommand immutableReportGridUpdateCommand =
        ImmutableReportGridUpdateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("42")
            .build();

    // Act
    ImmutableReportGridUpdateCommand actualWithNameResult =
        immutableReportGridUpdateCommand.withName("42");

    // Assert
    assertSame(immutableReportGridUpdateCommand, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableReportGridUpdateCommand#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridUpdateCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridUpdateCommand ImmutableReportGridUpdateCommand.withName(String)"
  })
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableReportGridUpdateCommand actualWithNameResult =
        ImmutableReportGridUpdateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(ReportGridKind.PUBLIC, actualWithNameResult.kind());
  }
}
