package org.finos.waltz.model.logical_data_element;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.logical_data_element.ImmutableLogicalDataElementChangeCommand.Builder;
import org.finos.waltz.model.logical_data_element.ImmutableLogicalDataElementChangeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLogicalDataElementChangeCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#from(LogicalDataElementChangeCommand)}.
   *
   * <p>Method under test: {@link Builder#from(LogicalDataElementChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalDataElementChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LogicalDataElementChangeCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();

    Builder builderResult2 = ImmutableLogicalDataElementChangeCommand.builder();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> newLogicalDataElement =
        Optional.of(immutableEntityReference);
    ImmutableLogicalDataElementChangeCommand instance =
        builderResult2.newLogicalDataElement(newLogicalDataElement).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLogicalDataElementChangeCommand actualImmutableLogicalDataElementChangeCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableLogicalDataElementChangeCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LogicalDataElementChangeCommand)}.
   *
   * <ul>
   *   <li>Then builder build is builder newLogicalDataElement empty build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(LogicalDataElementChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LogicalDataElementChangeCommand); then builder build is builder newLogicalDataElement empty build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LogicalDataElementChangeCommand)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderNewLogicalDataElementEmptyBuild() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();

    Builder builderResult2 = ImmutableLogicalDataElementChangeCommand.builder();
    Optional<? extends EntityReference> newLogicalDataElement = Optional.empty();
    ImmutableLogicalDataElementChangeCommand instance =
        builderResult2.newLogicalDataElement(newLogicalDataElement).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLogicalDataElementChangeCommand actualImmutableLogicalDataElementChangeCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableLogicalDataElementChangeCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#newLogicalDataElement(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#newLogicalDataElement(Optional)}
   */
  @Test
  @DisplayName("Test Builder newLogicalDataElement(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.newLogicalDataElement(Optional)"})
  void testBuilderNewLogicalDataElementWithOptional() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> newLogicalDataElement =
        Optional.of(immutableEntityReference);

    // Act
    Builder actualNewLogicalDataElementResult =
        builderResult.newLogicalDataElement(newLogicalDataElement);

    // Assert
    assertSame(builderResult, actualNewLogicalDataElementResult);
  }

  /**
   * Test {@link ImmutableLogicalDataElementChangeCommand#copyOf(LogicalDataElementChangeCommand)}.
   *
   * <p>Method under test: {@link
   * ImmutableLogicalDataElementChangeCommand#copyOf(LogicalDataElementChangeCommand)}
   */
  @Test
  @DisplayName("Test copyOf(LogicalDataElementChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalDataElementChangeCommand ImmutableLogicalDataElementChangeCommand.copyOf(LogicalDataElementChangeCommand)"
  })
  void testCopyOf() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> newLogicalDataElement =
        Optional.of(immutableEntityReference);
    ImmutableLogicalDataElementChangeCommand instance =
        builderResult.newLogicalDataElement(newLogicalDataElement).build();

    // Act and Assert
    assertEquals(
        newLogicalDataElement,
        ImmutableLogicalDataElementChangeCommand.copyOf(instance).newLogicalDataElement());
  }

  /**
   * Test {@link ImmutableLogicalDataElementChangeCommand#equals(Object)}, and {@link
   * ImmutableLogicalDataElementChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLogicalDataElementChangeCommand#equals(Object)}
   *   <li>{@link ImmutableLogicalDataElementChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalDataElementChangeCommand.equals(Object)",
    "int ImmutableLogicalDataElementChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> newLogicalDataElement =
        Optional.of(immutableEntityReference);
    ImmutableLogicalDataElementChangeCommand immutableLogicalDataElementChangeCommand =
        builderResult.newLogicalDataElement(newLogicalDataElement).build();

    Builder builderResult2 = ImmutableLogicalDataElementChangeCommand.builder();
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> newLogicalDataElement2 =
        Optional.of(immutableEntityReference2);
    ImmutableLogicalDataElementChangeCommand immutableLogicalDataElementChangeCommand2 =
        builderResult2.newLogicalDataElement(newLogicalDataElement2).build();

    // Act and Assert
    assertEquals(
        immutableLogicalDataElementChangeCommand, immutableLogicalDataElementChangeCommand2);
    assertEquals(
        immutableLogicalDataElementChangeCommand.hashCode(),
        immutableLogicalDataElementChangeCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableLogicalDataElementChangeCommand#equals(Object)}, and {@link
   * ImmutableLogicalDataElementChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLogicalDataElementChangeCommand#equals(Object)}
   *   <li>{@link ImmutableLogicalDataElementChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalDataElementChangeCommand.equals(Object)",
    "int ImmutableLogicalDataElementChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> newLogicalDataElement =
        Optional.of(immutableEntityReference);
    ImmutableLogicalDataElementChangeCommand immutableLogicalDataElementChangeCommand =
        builderResult.newLogicalDataElement(newLogicalDataElement).build();

    // Act and Assert
    assertEquals(
        immutableLogicalDataElementChangeCommand, immutableLogicalDataElementChangeCommand);
    int expectedHashCodeResult = immutableLogicalDataElementChangeCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableLogicalDataElementChangeCommand.hashCode());
  }

  /**
   * Test {@link ImmutableLogicalDataElementChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalDataElementChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalDataElementChangeCommand.equals(Object)",
    "int ImmutableLogicalDataElementChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> newLogicalDataElement =
        Optional.of(immutableEntityReference);
    ImmutableLogicalDataElementChangeCommand immutableLogicalDataElementChangeCommand =
        builderResult.newLogicalDataElement(newLogicalDataElement).build();

    Builder builderResult2 = ImmutableLogicalDataElementChangeCommand.builder();
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> newLogicalDataElement2 =
        Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableLogicalDataElementChangeCommand,
        builderResult2.newLogicalDataElement(newLogicalDataElement2).build());
  }

  /**
   * Test {@link ImmutableLogicalDataElementChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalDataElementChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalDataElementChangeCommand.equals(Object)",
    "int ImmutableLogicalDataElementChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> newLogicalDataElement =
        Optional.of(immutableEntityReference);

    // Act and Assert
    assertNotEquals(builderResult.newLogicalDataElement(newLogicalDataElement).build(), null);
  }

  /**
   * Test {@link ImmutableLogicalDataElementChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalDataElementChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalDataElementChangeCommand.equals(Object)",
    "int ImmutableLogicalDataElementChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> newLogicalDataElement =
        Optional.of(immutableEntityReference);

    // Act and Assert
    assertNotEquals(
        builderResult.newLogicalDataElement(newLogicalDataElement).build(),
        "Different type to ImmutableLogicalDataElementChangeCommand");
  }

  /**
   * Test {@link ImmutableLogicalDataElementChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) NewLogicalDataElement is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalDataElementChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) NewLogicalDataElement is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalDataElementChangeCommand ImmutableLogicalDataElementChangeCommand.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonNewLogicalDataElementIsNull() {
    // Arrange
    Json json = new Json();
    json.setNewLogicalDataElement(null);

    // Act
    ImmutableLogicalDataElementChangeCommand actualFromJsonResult =
        ImmutableLogicalDataElementChangeCommand.fromJson(json);

    // Assert
    assertFalse(actualFromJsonResult.newLogicalDataElement().isPresent());
  }

  /**
   * Test {@link ImmutableLogicalDataElementChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return not newLogicalDataElement Present.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalDataElementChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return not newLogicalDataElement Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalDataElementChangeCommand ImmutableLogicalDataElementChangeCommand.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnNotNewLogicalDataElementPresent() {
    // Arrange and Act
    ImmutableLogicalDataElementChangeCommand actualFromJsonResult =
        ImmutableLogicalDataElementChangeCommand.fromJson(new Json());

    // Assert
    assertFalse(actualFromJsonResult.newLogicalDataElement().isPresent());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange, Act and Assert
    assertFalse(new Json().newLogicalDataElement.isPresent());
  }

  /**
   * Test Json {@link Json#newLogicalDataElement()}.
   *
   * <p>Method under test: {@link Json#newLogicalDataElement()}
   */
  @Test
  @DisplayName("Test Json newLogicalDataElement()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.newLogicalDataElement()"})
  void testJsonNewLogicalDataElement() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().newLogicalDataElement());
  }

  /**
   * Test {@link ImmutableLogicalDataElementChangeCommand#newLogicalDataElement()}.
   *
   * <p>Method under test: {@link ImmutableLogicalDataElementChangeCommand#newLogicalDataElement()}
   */
  @Test
  @DisplayName("Test newLogicalDataElement()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableLogicalDataElementChangeCommand.newLogicalDataElement()"})
  void testNewLogicalDataElement() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> newLogicalDataElement =
        Optional.of(immutableEntityReference);

    // Act and Assert
    assertEquals(
        newLogicalDataElement,
        builderResult.newLogicalDataElement(newLogicalDataElement).build().newLogicalDataElement());
  }

  /**
   * Test {@link ImmutableLogicalDataElementChangeCommand#toString()}.
   *
   * <ul>
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalDataElementChangeCommand#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutableLogicalDataElementChangeCommand.toString()"})
  void testToString_thenReturnAString() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> newLogicalDataElement =
        Optional.of(immutableEntityReference);

    // Act and Assert
    assertEquals(
        "LogicalDataElementChangeCommand{newLogicalDataElement=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}}",
        builderResult.newLogicalDataElement(newLogicalDataElement).build().toString());
  }

  /**
   * Test {@link ImmutableLogicalDataElementChangeCommand#toString()}.
   *
   * <ul>
   *   <li>Then return {@code LogicalDataElementChangeCommand{}}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalDataElementChangeCommand#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'LogicalDataElementChangeCommand{}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutableLogicalDataElementChangeCommand.toString()"})
  void testToString_thenReturnLogicalDataElementChangeCommand() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();
    Optional<? extends EntityReference> newLogicalDataElement = Optional.empty();

    // Act and Assert
    assertEquals(
        "LogicalDataElementChangeCommand{}",
        builderResult.newLogicalDataElement(newLogicalDataElement).build().toString());
  }

  /**
   * Test {@link ImmutableLogicalDataElementChangeCommand#withNewLogicalDataElement(Optional)} with
   * {@code optional}.
   *
   * <p>Method under test: {@link
   * ImmutableLogicalDataElementChangeCommand#withNewLogicalDataElement(Optional)}
   */
  @Test
  @DisplayName("Test withNewLogicalDataElement(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalDataElementChangeCommand ImmutableLogicalDataElementChangeCommand.withNewLogicalDataElement(Optional)"
  })
  void testWithNewLogicalDataElementWithOptional() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> newLogicalDataElement =
        Optional.of(immutableEntityReference);
    ImmutableLogicalDataElementChangeCommand immutableLogicalDataElementChangeCommand =
        builderResult.newLogicalDataElement(newLogicalDataElement).build();
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> optional = Optional.of(immutableEntityReference2);

    // Act
    ImmutableLogicalDataElementChangeCommand actualWithNewLogicalDataElementResult =
        immutableLogicalDataElementChangeCommand.withNewLogicalDataElement(optional);

    // Assert
    assertEquals(immutableLogicalDataElementChangeCommand, actualWithNewLogicalDataElementResult);
  }

  /**
   * Test {@link
   * ImmutableLogicalDataElementChangeCommand#withNewLogicalDataElement(EntityReference)} with
   * {@code value}.
   *
   * <p>Method under test: {@link
   * ImmutableLogicalDataElementChangeCommand#withNewLogicalDataElement(EntityReference)}
   */
  @Test
  @DisplayName("Test withNewLogicalDataElement(EntityReference) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalDataElementChangeCommand ImmutableLogicalDataElementChangeCommand.withNewLogicalDataElement(EntityReference)"
  })
  void testWithNewLogicalDataElementWithValue() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> newLogicalDataElement =
        Optional.of(immutableEntityReference);
    ImmutableLogicalDataElementChangeCommand immutableLogicalDataElementChangeCommand =
        builderResult.newLogicalDataElement(newLogicalDataElement).build();

    // Act
    ImmutableLogicalDataElementChangeCommand actualWithNewLogicalDataElementResult =
        immutableLogicalDataElementChangeCommand.withNewLogicalDataElement(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableLogicalDataElementChangeCommand, actualWithNewLogicalDataElementResult);
  }
}
