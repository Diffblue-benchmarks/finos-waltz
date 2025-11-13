package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.report_grid.ImmutableReportGridCreateCommand.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridCreateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridCreateCommandDiffblueTest {
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
    "ImmutableReportGridCreateCommand Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.kind(ReportGridKind)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableReportGridCreateCommand actualImmutableReportGridCreateCommand =
        ImmutableReportGridCreateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Assert
    assertEquals("Name", actualImmutableReportGridCreateCommand.name());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableReportGridCreateCommand.description());
    assertEquals(EntityKind.ALL, actualImmutableReportGridCreateCommand.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualImmutableReportGridCreateCommand.kind());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridCreateCommand)}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridCreateCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableReportGridCreateCommand.builder();
    ImmutableReportGridCreateCommand instance =
        ImmutableReportGridCreateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableReportGridCreateCommand actualImmutableReportGridCreateCommand = builderResult.build();
    assertEquals(instance, actualImmutableReportGridCreateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridCreateCommand)}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridCreateCommand)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableReportGridCreateCommand.builder();
    ImmutableReportGridCreateCommand instance =
        ImmutableReportGridCreateCommand.builder()
            .description(null)
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableReportGridCreateCommand actualImmutableReportGridCreateCommand = builderResult.build();
    assertEquals(instance, actualImmutableReportGridCreateCommand);
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
    Builder builderResult = ImmutableReportGridCreateCommand.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#subjectKind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#subjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder subjectKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.subjectKind(EntityKind)"})
  void testBuilderSubjectKind() {
    // Arrange
    Builder builderResult = ImmutableReportGridCreateCommand.builder();

    // Act
    Builder actualSubjectKindResult = builderResult.subjectKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualSubjectKindResult);
  }

  /**
   * Test {@link ImmutableReportGridCreateCommand#copyOf(ReportGridCreateCommand)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCreateCommand#copyOf(ReportGridCreateCommand)}
   */
  @Test
  @DisplayName("Test copyOf(ReportGridCreateCommand); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridCreateCommand ImmutableReportGridCreateCommand.copyOf(ReportGridCreateCommand)"
  })
  void testCopyOf_thenReturnName() {
    // Arrange
    ImmutableReportGridCreateCommand instance =
        ImmutableReportGridCreateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableReportGridCreateCommand actualCopyOfResult =
        ImmutableReportGridCreateCommand.copyOf(instance);

    // Assert
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualCopyOfResult.kind());
  }

  /**
   * Test {@link ImmutableReportGridCreateCommand#equals(Object)}, and {@link
   * ImmutableReportGridCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridCreateCommand#equals(Object)}
   *   <li>{@link ImmutableReportGridCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridCreateCommand.equals(Object)",
    "int ImmutableReportGridCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableReportGridCreateCommand immutableReportGridCreateCommand =
        ImmutableReportGridCreateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();
    ImmutableReportGridCreateCommand immutableReportGridCreateCommand2 =
        ImmutableReportGridCreateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableReportGridCreateCommand, immutableReportGridCreateCommand2);
    assertEquals(
        immutableReportGridCreateCommand.hashCode(), immutableReportGridCreateCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridCreateCommand#equals(Object)}, and {@link
   * ImmutableReportGridCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridCreateCommand#equals(Object)}
   *   <li>{@link ImmutableReportGridCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridCreateCommand.equals(Object)",
    "int ImmutableReportGridCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableReportGridCreateCommand immutableReportGridCreateCommand =
        ImmutableReportGridCreateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableReportGridCreateCommand, immutableReportGridCreateCommand);
    int expectedHashCodeResult = immutableReportGridCreateCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableReportGridCreateCommand.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridCreateCommand.equals(Object)",
    "int ImmutableReportGridCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableReportGridCreateCommand immutableReportGridCreateCommand =
        ImmutableReportGridCreateCommand.builder()
            .description("Name")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridCreateCommand,
        ImmutableReportGridCreateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridCreateCommand.equals(Object)",
    "int ImmutableReportGridCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableReportGridCreateCommand immutableReportGridCreateCommand =
        ImmutableReportGridCreateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PRIVATE)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridCreateCommand,
        ImmutableReportGridCreateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridCreateCommand.equals(Object)",
    "int ImmutableReportGridCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableReportGridCreateCommand immutableReportGridCreateCommand =
        ImmutableReportGridCreateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("java.lang.String")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridCreateCommand,
        ImmutableReportGridCreateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridCreateCommand.equals(Object)",
    "int ImmutableReportGridCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableReportGridCreateCommand immutableReportGridCreateCommand =
        ImmutableReportGridCreateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .subjectKind(EntityKind.ACTOR)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridCreateCommand,
        ImmutableReportGridCreateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridCreateCommand.equals(Object)",
    "int ImmutableReportGridCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableReportGridCreateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableReportGridCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridCreateCommand.equals(Object)",
    "int ImmutableReportGridCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableReportGridCreateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build(),
        "Different type to ImmutableReportGridCreateCommand");
  }

  /**
   * Test {@link ImmutableReportGridCreateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>When {@link Json} (default constructor) Description is {@code null}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCreateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'ALL'; when Json (default constructor) Description is 'null'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridCreateCommand ImmutableReportGridCreateCommand.fromJson(Json)"
  })
  void testFromJson_givenAll_whenJsonDescriptionIsNull_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setSubjectKind(EntityKind.ALL);
    json.setDescription(null);
    json.setKind(ReportGridKind.PUBLIC);

    // Act
    ImmutableReportGridCreateCommand actualFromJsonResult =
        ImmutableReportGridCreateCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ALL, actualFromJsonResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualFromJsonResult.kind());
  }

  /**
   * Test {@link ImmutableReportGridCreateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>When {@link Json} (default constructor) Kind is {@code null}.
   *   <li>Then return kind is {@code PRIVATE}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCreateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'ALL'; when Json (default constructor) Kind is 'null'; then return kind is 'PRIVATE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridCreateCommand ImmutableReportGridCreateCommand.fromJson(Json)"
  })
  void testFromJson_givenAll_whenJsonKindIsNull_thenReturnKindIsPrivate() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setSubjectKind(EntityKind.ALL);
    json.setDescription("Json");
    json.setKind(null);

    // Act
    ImmutableReportGridCreateCommand actualFromJsonResult =
        ImmutableReportGridCreateCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals(EntityKind.ALL, actualFromJsonResult.subjectKind());
    assertEquals(ReportGridKind.PRIVATE, actualFromJsonResult.kind());
  }

  /**
   * Test {@link ImmutableReportGridCreateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>When {@link Json} (default constructor) Name is {@code Json}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCreateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'ALL'; when Json (default constructor) Name is 'Json'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridCreateCommand ImmutableReportGridCreateCommand.fromJson(Json)"
  })
  void testFromJson_givenAll_whenJsonNameIsJson_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setSubjectKind(EntityKind.ALL);
    json.setDescription("Json");
    json.setKind(ReportGridKind.PUBLIC);

    // Act
    ImmutableReportGridCreateCommand actualFromJsonResult =
        ImmutableReportGridCreateCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals(EntityKind.ALL, actualFromJsonResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualFromJsonResult.kind());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridCreateCommand#toString()}
   *   <li>{@link ImmutableReportGridCreateCommand#description()}
   *   <li>{@link ImmutableReportGridCreateCommand#kind()}
   *   <li>{@link ImmutableReportGridCreateCommand#name()}
   *   <li>{@link ImmutableReportGridCreateCommand#subjectKind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableReportGridCreateCommand.description()",
    "ReportGridKind ImmutableReportGridCreateCommand.kind()",
    "String ImmutableReportGridCreateCommand.name()",
    "EntityKind ImmutableReportGridCreateCommand.subjectKind()",
    "String ImmutableReportGridCreateCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableReportGridCreateCommand immutableReportGridCreateCommand =
        ImmutableReportGridCreateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    String actualToStringResult = immutableReportGridCreateCommand.toString();
    String actualDescriptionResult = immutableReportGridCreateCommand.description();
    ReportGridKind actualKindResult = immutableReportGridCreateCommand.kind();
    String actualNameResult = immutableReportGridCreateCommand.name();

    // Assert
    assertEquals("Name", actualNameResult);
    assertEquals(
        "ReportGridCreateCommand{name=Name, subjectKind=ALL, description=The characteristics of someone or"
            + " something, kind=PUBLIC}",
        actualToStringResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(EntityKind.ALL, immutableReportGridCreateCommand.subjectKind());
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
   *   <li>{@link Json#setSubjectKind(EntityKind)}
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
    "void Json.setName(String)",
    "void Json.setSubjectKind(EntityKind)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setKind(ReportGridKind.PUBLIC);
    actualJson.setName("Name");
    actualJson.setSubjectKind(EntityKind.ALL);

    // Assert
    assertEquals("Name", actualJson.name);
    assertEquals("The characteristics of someone or something", actualJson.description);
    assertEquals(EntityKind.ALL, actualJson.subjectKind);
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
   * Test Json {@link Json#subjectKind()}.
   *
   * <p>Method under test: {@link Json#subjectKind()}
   */
  @Test
  @DisplayName("Test Json subjectKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.subjectKind()"})
  void testJsonSubjectKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().subjectKind());
  }

  /**
   * Test {@link ImmutableReportGridCreateCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableReportGridCreateCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridCreateCommand ImmutableReportGridCreateCommand.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableReportGridCreateCommand immutableReportGridCreateCommand =
        ImmutableReportGridCreateCommand.builder()
            .description("42")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableReportGridCreateCommand actualWithDescriptionResult =
        immutableReportGridCreateCommand.withDescription("42");

    // Assert
    assertSame(immutableReportGridCreateCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableReportGridCreateCommand#withDescription(String)}.
   *
   * <ul>
   *   <li>Then return description is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCreateCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String); then return description is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridCreateCommand ImmutableReportGridCreateCommand.withDescription(String)"
  })
  void testWithDescription_thenReturnDescriptionIs42() {
    // Arrange and Act
    ImmutableReportGridCreateCommand actualWithDescriptionResult =
        ImmutableReportGridCreateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build()
            .withDescription("42");

    // Assert
    assertEquals("42", actualWithDescriptionResult.description());
    assertEquals("Name", actualWithDescriptionResult.name());
    assertEquals(EntityKind.ALL, actualWithDescriptionResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualWithDescriptionResult.kind());
  }

  /**
   * Test {@link ImmutableReportGridCreateCommand#withKind(ReportGridKind)}.
   *
   * <p>Method under test: {@link ImmutableReportGridCreateCommand#withKind(ReportGridKind)}
   */
  @Test
  @DisplayName("Test withKind(ReportGridKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridCreateCommand ImmutableReportGridCreateCommand.withKind(ReportGridKind)"
  })
  void testWithKind() {
    // Arrange
    ImmutableReportGridCreateCommand immutableReportGridCreateCommand =
        ImmutableReportGridCreateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableReportGridCreateCommand actualWithKindResult =
        immutableReportGridCreateCommand.withKind(ReportGridKind.PUBLIC);

    // Assert
    assertSame(immutableReportGridCreateCommand, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableReportGridCreateCommand#withKind(ReportGridKind)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCreateCommand#withKind(ReportGridKind)}
   */
  @Test
  @DisplayName("Test withKind(ReportGridKind); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridCreateCommand ImmutableReportGridCreateCommand.withKind(ReportGridKind)"
  })
  void testWithKind_thenReturnName() {
    // Arrange and Act
    ImmutableReportGridCreateCommand actualWithKindResult =
        ImmutableReportGridCreateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PRIVATE)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build()
            .withKind(ReportGridKind.PUBLIC);

    // Assert
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(EntityKind.ALL, actualWithKindResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualWithKindResult.kind());
  }

  /**
   * Test {@link ImmutableReportGridCreateCommand#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableReportGridCreateCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridCreateCommand ImmutableReportGridCreateCommand.withName(String)"
  })
  void testWithName() {
    // Arrange
    ImmutableReportGridCreateCommand immutableReportGridCreateCommand =
        ImmutableReportGridCreateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("42")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableReportGridCreateCommand actualWithNameResult =
        immutableReportGridCreateCommand.withName("42");

    // Assert
    assertSame(immutableReportGridCreateCommand, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableReportGridCreateCommand#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCreateCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridCreateCommand ImmutableReportGridCreateCommand.withName(String)"
  })
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableReportGridCreateCommand actualWithNameResult =
        ImmutableReportGridCreateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(EntityKind.ALL, actualWithNameResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualWithNameResult.kind());
  }

  /**
   * Test {@link ImmutableReportGridCreateCommand#withSubjectKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableReportGridCreateCommand#withSubjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withSubjectKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridCreateCommand ImmutableReportGridCreateCommand.withSubjectKind(EntityKind)"
  })
  void testWithSubjectKind() {
    // Arrange
    ImmutableReportGridCreateCommand immutableReportGridCreateCommand =
        ImmutableReportGridCreateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableReportGridCreateCommand actualWithSubjectKindResult =
        immutableReportGridCreateCommand.withSubjectKind(EntityKind.ALL);

    // Assert
    assertSame(immutableReportGridCreateCommand, actualWithSubjectKindResult);
  }

  /**
   * Test {@link ImmutableReportGridCreateCommand#withSubjectKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCreateCommand#withSubjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withSubjectKind(EntityKind); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridCreateCommand ImmutableReportGridCreateCommand.withSubjectKind(EntityKind)"
  })
  void testWithSubjectKind_thenReturnName() {
    // Arrange and Act
    ImmutableReportGridCreateCommand actualWithSubjectKindResult =
        ImmutableReportGridCreateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .subjectKind(EntityKind.ACTOR)
            .build()
            .withSubjectKind(EntityKind.ALL);

    // Assert
    assertEquals("Name", actualWithSubjectKindResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithSubjectKindResult.description());
    assertEquals(EntityKind.ALL, actualWithSubjectKindResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualWithSubjectKindResult.kind());
  }
}
