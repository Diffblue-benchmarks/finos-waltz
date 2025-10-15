package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.ImmutableSetAttributeCommand.Builder;
import org.finos.waltz.model.ImmutableSetAttributeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSetAttributeCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSetAttributeCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableSetAttributeCommand.builder();
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableSetAttributeCommand actualImmutableSetAttributeCommand =
        actualBuilderResult.entityReference(entityReference).name("Name").value("42").build();

    // Assert
    assertEquals("42", actualImmutableSetAttributeCommand.value());
    assertEquals("Name", actualImmutableSetAttributeCommand.name());
    assertSame(entityReference, actualImmutableSetAttributeCommand.entityReference());
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link ImmutableEntityReference.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder entityReference(EntityReference); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSetAttributeCommand.builder();

    // Act
    Builder actualEntityReferenceResult =
        builderResult.entityReference(new ImmutableEntityReference.Json());

    // Assert
    assertSame(builderResult, actualEntityReferenceResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider() {
    // Arrange
    Builder builderResult = ImmutableSetAttributeCommand.builder();

    Builder builderResult2 = ImmutableSetAttributeCommand.builder();
    ImmutableSetAttributeCommand instance =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("42")
            .build();

    // Act and Assert
    ImmutableSetAttributeCommand actualImmutableSetAttributeCommand =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableSetAttributeCommand);
    ImmutableSetAttributeCommand actualImmutableSetAttributeCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableSetAttributeCommand2);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSetAttributeCommand.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SetAttributeCommand)} with {@code SetAttributeCommand}.
   *
   * <p>Method under test: {@link Builder#from(SetAttributeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SetAttributeCommand) with 'SetAttributeCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SetAttributeCommand)"})
  void testBuilderFromWithSetAttributeCommand() {
    // Arrange
    Builder builderResult = ImmutableSetAttributeCommand.builder();

    Builder builderResult2 = ImmutableSetAttributeCommand.builder();
    ImmutableSetAttributeCommand instance =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSetAttributeCommand actualImmutableSetAttributeCommand = builderResult.build();
    assertEquals(instance, actualImmutableSetAttributeCommand);
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
    Builder builderResult = ImmutableSetAttributeCommand.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#value(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#value(String)}
   */
  @Test
  @DisplayName("Test Builder value(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.value(String)"})
  void testBuilderValue_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSetAttributeCommand.builder();

    // Act
    Builder actualValueResult = builderResult.value("42");

    // Assert
    assertSame(builderResult, actualValueResult);
  }

  /**
   * Test {@link ImmutableSetAttributeCommand#copyOf(SetAttributeCommand)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSetAttributeCommand#copyOf(SetAttributeCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SetAttributeCommand); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSetAttributeCommand ImmutableSetAttributeCommand.copyOf(SetAttributeCommand)"
  })
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableSetAttributeCommand.builder();
    ImmutableSetAttributeCommand instance =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("42")
            .build();

    // Act
    ImmutableSetAttributeCommand actualCopyOfResult = ImmutableSetAttributeCommand.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualCopyOfResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableSetAttributeCommand#equals(Object)}, and {@link
   * ImmutableSetAttributeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSetAttributeCommand#equals(Object)}
   *   <li>{@link ImmutableSetAttributeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSetAttributeCommand.equals(Object)",
    "int ImmutableSetAttributeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableSetAttributeCommand.builder();
    ImmutableSetAttributeCommand immutableSetAttributeCommand =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("42")
            .build();

    Builder builderResult2 = ImmutableSetAttributeCommand.builder();
    ImmutableSetAttributeCommand immutableSetAttributeCommand2 =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("42")
            .build();

    // Act and Assert
    assertEquals(immutableSetAttributeCommand, immutableSetAttributeCommand2);
    assertEquals(immutableSetAttributeCommand.hashCode(), immutableSetAttributeCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableSetAttributeCommand#equals(Object)}, and {@link
   * ImmutableSetAttributeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSetAttributeCommand#equals(Object)}
   *   <li>{@link ImmutableSetAttributeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSetAttributeCommand.equals(Object)",
    "int ImmutableSetAttributeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableSetAttributeCommand.builder();
    ImmutableSetAttributeCommand immutableSetAttributeCommand =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("42")
            .build();

    // Act and Assert
    assertEquals(immutableSetAttributeCommand, immutableSetAttributeCommand);
    int expectedHashCodeResult = immutableSetAttributeCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableSetAttributeCommand.hashCode());
  }

  /**
   * Test {@link ImmutableSetAttributeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSetAttributeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSetAttributeCommand.equals(Object)",
    "int ImmutableSetAttributeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSetAttributeCommand.builder();
    ImmutableSetAttributeCommand immutableSetAttributeCommand =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("42")
            .build();

    Builder builderResult2 = ImmutableSetAttributeCommand.builder();

    // Act and Assert
    assertNotEquals(
        immutableSetAttributeCommand,
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableSetAttributeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSetAttributeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSetAttributeCommand.equals(Object)",
    "int ImmutableSetAttributeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableSetAttributeCommand.builder();
    ImmutableSetAttributeCommand immutableSetAttributeCommand =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("42")
            .value("42")
            .build();

    Builder builderResult2 = ImmutableSetAttributeCommand.builder();

    // Act and Assert
    assertNotEquals(
        immutableSetAttributeCommand,
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableSetAttributeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSetAttributeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSetAttributeCommand.equals(Object)",
    "int ImmutableSetAttributeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableSetAttributeCommand.builder();
    ImmutableSetAttributeCommand immutableSetAttributeCommand =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("Name")
            .build();

    Builder builderResult2 = ImmutableSetAttributeCommand.builder();

    // Act and Assert
    assertNotEquals(
        immutableSetAttributeCommand,
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableSetAttributeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSetAttributeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSetAttributeCommand.equals(Object)",
    "int ImmutableSetAttributeCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSetAttributeCommand.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("42")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSetAttributeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSetAttributeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSetAttributeCommand.equals(Object)",
    "int ImmutableSetAttributeCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSetAttributeCommand.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("42")
            .build(),
        "Different type to ImmutableSetAttributeCommand");
  }

  /**
   * Test {@link ImmutableSetAttributeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ImmutableEntityReference.Json} (default constructor).
   *   <li>When {@link Json} (default constructor) Name is {@code Json}.
   *   <li>Then return name is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSetAttributeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given Json (default constructor); when Json (default constructor) Name is 'Json'; then return name is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSetAttributeCommand ImmutableSetAttributeCommand.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonNameIsJson_thenReturnNameIsJson() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    ImmutableEntityReference.Json entityReference = new ImmutableEntityReference.Json();
    json.setEntityReference(entityReference);
    json.setValue("Json");

    // Act
    ImmutableSetAttributeCommand actualFromJsonResult = ImmutableSetAttributeCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.value());
    assertSame(entityReference, actualFromJsonResult.entityReference());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSetAttributeCommand#toString()}
   *   <li>{@link ImmutableSetAttributeCommand#entityReference()}
   *   <li>{@link ImmutableSetAttributeCommand#name()}
   *   <li>{@link ImmutableSetAttributeCommand#value()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutableSetAttributeCommand.entityReference()",
    "String ImmutableSetAttributeCommand.name()",
    "String ImmutableSetAttributeCommand.toString()",
    "String ImmutableSetAttributeCommand.value()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableSetAttributeCommand.builder();
    ImmutableSetAttributeCommand immutableSetAttributeCommand =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("42")
            .build();

    // Act
    String actualToStringResult = immutableSetAttributeCommand.toString();
    EntityReference actualEntityReferenceResult = immutableSetAttributeCommand.entityReference();
    String actualNameResult = immutableSetAttributeCommand.name();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", immutableSetAttributeCommand.value());
    assertEquals("Name", actualNameResult);
    assertEquals(
        "SetAttributeCommand{name=Name, entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " value=42}",
        actualToStringResult);
  }

  /**
   * Test Json {@link Json#entityReference()}.
   *
   * <p>Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityReference());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setEntityReference(EntityReference)}
   *   <li>{@link Json#setName(String)}
   *   <li>{@link Json#setValue(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setEntityReference(EntityReference)",
    "void Json.setName(String)",
    "void Json.setValue(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setName("Name");
    actualJson.setValue("42");

    // Assert
    EntityReference entityReference = actualJson.entityReference;
    assertTrue(entityReference instanceof ImmutableEntityReference);
    assertEquals("42", actualJson.value);
    assertEquals("Name", actualJson.name);
    assertEquals("The characteristics of someone or something", entityReference.description());
    assertEquals(1L, entityReference.id());
    assertEquals(EntityKind.ALL, entityReference.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReference.entityLifecycleStatus());
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
   * Test Json {@link Json#value()}.
   *
   * <p>Method under test: {@link Json#value()}
   */
  @Test
  @DisplayName("Test Json value()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.value()"})
  void testJsonValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().value());
  }

  /**
   * Test {@link ImmutableSetAttributeCommand#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableSetAttributeCommand#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSetAttributeCommand ImmutableSetAttributeCommand.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder builderResult = ImmutableSetAttributeCommand.builder();
    ImmutableSetAttributeCommand immutableSetAttributeCommand =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("42")
            .build();

    // Act
    ImmutableSetAttributeCommand actualWithEntityReferenceResult =
        immutableSetAttributeCommand.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableSetAttributeCommand, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableSetAttributeCommand#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableSetAttributeCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSetAttributeCommand ImmutableSetAttributeCommand.withName(String)"})
  void testWithName() {
    // Arrange
    Builder builderResult = ImmutableSetAttributeCommand.builder();
    ImmutableSetAttributeCommand immutableSetAttributeCommand =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("42")
            .value("42")
            .build();

    // Act
    ImmutableSetAttributeCommand actualWithNameResult = immutableSetAttributeCommand.withName("42");

    // Assert
    assertSame(immutableSetAttributeCommand, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableSetAttributeCommand#withName(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSetAttributeCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSetAttributeCommand ImmutableSetAttributeCommand.withName(String)"})
  void testWithName_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableSetAttributeCommand.builder();

    // Act
    ImmutableSetAttributeCommand actualWithNameResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("42")
            .build()
            .withName("42");

    // Assert
    EntityReference entityReferenceResult = actualWithNameResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithNameResult.name());
    assertEquals("42", actualWithNameResult.value());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableSetAttributeCommand#withValue(String)}.
   *
   * <p>Method under test: {@link ImmutableSetAttributeCommand#withValue(String)}
   */
  @Test
  @DisplayName("Test withValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSetAttributeCommand ImmutableSetAttributeCommand.withValue(String)"})
  void testWithValue() {
    // Arrange
    Builder builderResult = ImmutableSetAttributeCommand.builder();
    ImmutableSetAttributeCommand immutableSetAttributeCommand =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("42")
            .build();

    // Act
    ImmutableSetAttributeCommand actualWithValueResult =
        immutableSetAttributeCommand.withValue("42");

    // Assert
    assertSame(immutableSetAttributeCommand, actualWithValueResult);
  }

  /**
   * Test {@link ImmutableSetAttributeCommand#withValue(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSetAttributeCommand#withValue(String)}
   */
  @Test
  @DisplayName("Test withValue(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSetAttributeCommand ImmutableSetAttributeCommand.withValue(String)"})
  void testWithValue_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableSetAttributeCommand.builder();

    // Act
    ImmutableSetAttributeCommand actualWithValueResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("value")
            .build()
            .withValue("42");

    // Assert
    EntityReference entityReferenceResult = actualWithValueResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithValueResult.value());
    assertEquals("Name", actualWithValueResult.name());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }
}
