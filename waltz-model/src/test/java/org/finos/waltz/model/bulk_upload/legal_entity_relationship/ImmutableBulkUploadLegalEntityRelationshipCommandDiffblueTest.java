package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bulk_upload.BulkUpdateMode;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableBulkUploadLegalEntityRelationshipCommand.Builder;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableBulkUploadLegalEntityRelationshipCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkUploadLegalEntityRelationshipCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#updateMode(BulkUpdateMode)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadLegalEntityRelationshipCommand Builder.build()",
    "Builder Builder.updateMode(BulkUpdateMode)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableBulkUploadLegalEntityRelationshipCommand
        actualImmutableBulkUploadLegalEntityRelationshipCommand =
            ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
                .inputString("Input String")
                .legalEntityRelationshipKindId(1L)
                .updateMode(BulkUpdateMode.ADD_ONLY)
                .build();

    // Assert
    assertEquals(
        "Input String", actualImmutableBulkUploadLegalEntityRelationshipCommand.inputString());
    assertEquals(
        1L,
        actualImmutableBulkUploadLegalEntityRelationshipCommand.legalEntityRelationshipKindId());
    assertEquals(
        BulkUpdateMode.ADD_ONLY,
        actualImmutableBulkUploadLegalEntityRelationshipCommand.updateMode());
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadLegalEntityRelationshipCommand)}.
   *
   * <p>Method under test: {@link Builder#from(BulkUploadLegalEntityRelationshipCommand)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadLegalEntityRelationshipCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkUploadLegalEntityRelationshipCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadLegalEntityRelationshipCommand.builder();
    ImmutableBulkUploadLegalEntityRelationshipCommand instance =
        ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
            .inputString("Input String")
            .legalEntityRelationshipKindId(1L)
            .updateMode(BulkUpdateMode.ADD_ONLY)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkUploadLegalEntityRelationshipCommand
        actualImmutableBulkUploadLegalEntityRelationshipCommand = builderResult.build();
    assertEquals(instance, actualImmutableBulkUploadLegalEntityRelationshipCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#inputString(String)}.
   *
   * <ul>
   *   <li>When {@code Input String}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#inputString(String)}
   */
  @Test
  @DisplayName("Test Builder inputString(String); when 'Input String'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.inputString(String)"})
  void testBuilderInputString_whenInputString_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadLegalEntityRelationshipCommand.builder();

    // Act
    Builder actualInputStringResult = builderResult.inputString("Input String");

    // Assert
    assertSame(builderResult, actualInputStringResult);
  }

  /**
   * Test Builder {@link Builder#legalEntityRelationshipKindId(long)}.
   *
   * <p>Method under test: {@link Builder#legalEntityRelationshipKindId(long)}
   */
  @Test
  @DisplayName("Test Builder legalEntityRelationshipKindId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.legalEntityRelationshipKindId(long)"})
  void testBuilderLegalEntityRelationshipKindId() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadLegalEntityRelationshipCommand.builder();

    // Act
    Builder actualLegalEntityRelationshipKindIdResult =
        builderResult.legalEntityRelationshipKindId(1L);

    // Assert
    assertSame(builderResult, actualLegalEntityRelationshipKindIdResult);
  }

  /**
   * Test {@link
   * ImmutableBulkUploadLegalEntityRelationshipCommand#copyOf(BulkUploadLegalEntityRelationshipCommand)}.
   *
   * <ul>
   *   <li>Then return {@code Input String}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadLegalEntityRelationshipCommand#copyOf(BulkUploadLegalEntityRelationshipCommand)}
   */
  @Test
  @DisplayName("Test copyOf(BulkUploadLegalEntityRelationshipCommand); then return 'Input String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadLegalEntityRelationshipCommand ImmutableBulkUploadLegalEntityRelationshipCommand.copyOf(BulkUploadLegalEntityRelationshipCommand)"
  })
  void testCopyOf_thenReturnInputString() {
    // Arrange
    ImmutableBulkUploadLegalEntityRelationshipCommand instance =
        ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
            .inputString("Input String")
            .legalEntityRelationshipKindId(1L)
            .updateMode(BulkUpdateMode.ADD_ONLY)
            .build();

    // Act
    ImmutableBulkUploadLegalEntityRelationshipCommand actualCopyOfResult =
        ImmutableBulkUploadLegalEntityRelationshipCommand.copyOf(instance);

    // Assert
    assertEquals("Input String", actualCopyOfResult.inputString());
    assertEquals(1L, actualCopyOfResult.legalEntityRelationshipKindId());
    assertEquals(BulkUpdateMode.ADD_ONLY, actualCopyOfResult.updateMode());
  }

  /**
   * Test {@link ImmutableBulkUploadLegalEntityRelationshipCommand#equals(Object)}, and {@link
   * ImmutableBulkUploadLegalEntityRelationshipCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkUploadLegalEntityRelationshipCommand#equals(Object)}
   *   <li>{@link ImmutableBulkUploadLegalEntityRelationshipCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadLegalEntityRelationshipCommand.equals(Object)",
    "int ImmutableBulkUploadLegalEntityRelationshipCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableBulkUploadLegalEntityRelationshipCommand
        immutableBulkUploadLegalEntityRelationshipCommand =
            ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
                .inputString("Input String")
                .legalEntityRelationshipKindId(1L)
                .updateMode(BulkUpdateMode.ADD_ONLY)
                .build();
    ImmutableBulkUploadLegalEntityRelationshipCommand
        immutableBulkUploadLegalEntityRelationshipCommand2 =
            ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
                .inputString("Input String")
                .legalEntityRelationshipKindId(1L)
                .updateMode(BulkUpdateMode.ADD_ONLY)
                .build();

    // Act and Assert
    assertEquals(
        immutableBulkUploadLegalEntityRelationshipCommand,
        immutableBulkUploadLegalEntityRelationshipCommand2);
    assertEquals(
        immutableBulkUploadLegalEntityRelationshipCommand.hashCode(),
        immutableBulkUploadLegalEntityRelationshipCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableBulkUploadLegalEntityRelationshipCommand#equals(Object)}, and {@link
   * ImmutableBulkUploadLegalEntityRelationshipCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkUploadLegalEntityRelationshipCommand#equals(Object)}
   *   <li>{@link ImmutableBulkUploadLegalEntityRelationshipCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadLegalEntityRelationshipCommand.equals(Object)",
    "int ImmutableBulkUploadLegalEntityRelationshipCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableBulkUploadLegalEntityRelationshipCommand
        immutableBulkUploadLegalEntityRelationshipCommand =
            ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
                .inputString("Input String")
                .legalEntityRelationshipKindId(1L)
                .updateMode(BulkUpdateMode.ADD_ONLY)
                .build();

    // Act and Assert
    assertEquals(
        immutableBulkUploadLegalEntityRelationshipCommand,
        immutableBulkUploadLegalEntityRelationshipCommand);
    int expectedHashCodeResult = immutableBulkUploadLegalEntityRelationshipCommand.hashCode();
    assertEquals(
        expectedHashCodeResult, immutableBulkUploadLegalEntityRelationshipCommand.hashCode());
  }

  /**
   * Test {@link ImmutableBulkUploadLegalEntityRelationshipCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadLegalEntityRelationshipCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadLegalEntityRelationshipCommand.equals(Object)",
    "int ImmutableBulkUploadLegalEntityRelationshipCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableBulkUploadLegalEntityRelationshipCommand
        immutableBulkUploadLegalEntityRelationshipCommand =
            ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
                .inputString("inputString")
                .legalEntityRelationshipKindId(1L)
                .updateMode(BulkUpdateMode.ADD_ONLY)
                .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkUploadLegalEntityRelationshipCommand,
        ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
            .inputString("Input String")
            .legalEntityRelationshipKindId(1L)
            .updateMode(BulkUpdateMode.ADD_ONLY)
            .build());
  }

  /**
   * Test {@link ImmutableBulkUploadLegalEntityRelationshipCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadLegalEntityRelationshipCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadLegalEntityRelationshipCommand.equals(Object)",
    "int ImmutableBulkUploadLegalEntityRelationshipCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableBulkUploadLegalEntityRelationshipCommand
        immutableBulkUploadLegalEntityRelationshipCommand =
            ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
                .inputString("Input String")
                .legalEntityRelationshipKindId(2L)
                .updateMode(BulkUpdateMode.ADD_ONLY)
                .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkUploadLegalEntityRelationshipCommand,
        ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
            .inputString("Input String")
            .legalEntityRelationshipKindId(1L)
            .updateMode(BulkUpdateMode.ADD_ONLY)
            .build());
  }

  /**
   * Test {@link ImmutableBulkUploadLegalEntityRelationshipCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadLegalEntityRelationshipCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadLegalEntityRelationshipCommand.equals(Object)",
    "int ImmutableBulkUploadLegalEntityRelationshipCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableBulkUploadLegalEntityRelationshipCommand
        immutableBulkUploadLegalEntityRelationshipCommand =
            ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
                .inputString("Input String")
                .legalEntityRelationshipKindId(1L)
                .updateMode(BulkUpdateMode.REPLACE)
                .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkUploadLegalEntityRelationshipCommand,
        ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
            .inputString("Input String")
            .legalEntityRelationshipKindId(1L)
            .updateMode(BulkUpdateMode.ADD_ONLY)
            .build());
  }

  /**
   * Test {@link ImmutableBulkUploadLegalEntityRelationshipCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadLegalEntityRelationshipCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadLegalEntityRelationshipCommand.equals(Object)",
    "int ImmutableBulkUploadLegalEntityRelationshipCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
            .inputString("Input String")
            .legalEntityRelationshipKindId(1L)
            .updateMode(BulkUpdateMode.ADD_ONLY)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableBulkUploadLegalEntityRelationshipCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadLegalEntityRelationshipCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadLegalEntityRelationshipCommand.equals(Object)",
    "int ImmutableBulkUploadLegalEntityRelationshipCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
            .inputString("Input String")
            .legalEntityRelationshipKindId(1L)
            .updateMode(BulkUpdateMode.ADD_ONLY)
            .build(),
        "Different type to ImmutableBulkUploadLegalEntityRelationshipCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkUploadLegalEntityRelationshipCommand#toString()}
   *   <li>{@link ImmutableBulkUploadLegalEntityRelationshipCommand#inputString()}
   *   <li>{@link ImmutableBulkUploadLegalEntityRelationshipCommand#legalEntityRelationshipKindId()}
   *   <li>{@link ImmutableBulkUploadLegalEntityRelationshipCommand#updateMode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableBulkUploadLegalEntityRelationshipCommand.inputString()",
    "long ImmutableBulkUploadLegalEntityRelationshipCommand.legalEntityRelationshipKindId()",
    "String ImmutableBulkUploadLegalEntityRelationshipCommand.toString()",
    "BulkUpdateMode ImmutableBulkUploadLegalEntityRelationshipCommand.updateMode()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableBulkUploadLegalEntityRelationshipCommand
        immutableBulkUploadLegalEntityRelationshipCommand =
            ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
                .inputString("Input String")
                .legalEntityRelationshipKindId(1L)
                .updateMode(BulkUpdateMode.ADD_ONLY)
                .build();

    // Act
    String actualToStringResult = immutableBulkUploadLegalEntityRelationshipCommand.toString();
    String actualInputStringResult =
        immutableBulkUploadLegalEntityRelationshipCommand.inputString();
    long actualLegalEntityRelationshipKindIdResult =
        immutableBulkUploadLegalEntityRelationshipCommand.legalEntityRelationshipKindId();

    // Assert
    assertEquals(
        "BulkUploadLegalEntityRelationshipCommand{legalEntityRelationshipKindId=1, updateMode=ADD_ONLY}",
        actualToStringResult);
    assertEquals("Input String", actualInputStringResult);
    assertEquals(1L, actualLegalEntityRelationshipKindIdResult);
    assertEquals(
        BulkUpdateMode.ADD_ONLY, immutableBulkUploadLegalEntityRelationshipCommand.updateMode());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setInputString(String)}
   *   <li>{@link Json#setUpdateMode(BulkUpdateMode)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setInputString(String)",
    "void Json.setUpdateMode(BulkUpdateMode)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setInputString("Input String");
    actualJson.setUpdateMode(BulkUpdateMode.ADD_ONLY);

    // Assert
    assertEquals("Input String", actualJson.inputString);
    assertEquals(0L, actualJson.legalEntityRelationshipKindId);
    assertEquals(BulkUpdateMode.ADD_ONLY, actualJson.updateMode);
    assertFalse(actualJson.legalEntityRelationshipKindIdIsSet);
  }

  /**
   * Test Json {@link Json#inputString()}.
   *
   * <p>Method under test: {@link Json#inputString()}
   */
  @Test
  @DisplayName("Test Json inputString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.inputString()"})
  void testJsonInputString() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().inputString());
  }

  /**
   * Test Json {@link Json#legalEntityRelationshipKindId()}.
   *
   * <p>Method under test: {@link Json#legalEntityRelationshipKindId()}
   */
  @Test
  @DisplayName("Test Json legalEntityRelationshipKindId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.legalEntityRelationshipKindId()"})
  void testJsonLegalEntityRelationshipKindId() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> new Json().legalEntityRelationshipKindId());
  }

  /**
   * Test Json {@link Json#setLegalEntityRelationshipKindId(long)}.
   *
   * <p>Method under test: {@link Json#setLegalEntityRelationshipKindId(long)}
   */
  @Test
  @DisplayName("Test Json setLegalEntityRelationshipKindId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setLegalEntityRelationshipKindId(long)"})
  void testJsonSetLegalEntityRelationshipKindId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setLegalEntityRelationshipKindId(1L);

    // Assert
    assertEquals(1L, json.legalEntityRelationshipKindId);
    assertTrue(json.legalEntityRelationshipKindIdIsSet);
  }

  /**
   * Test Json {@link Json#updateMode()}.
   *
   * <p>Method under test: {@link Json#updateMode()}
   */
  @Test
  @DisplayName("Test Json updateMode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BulkUpdateMode Json.updateMode()"})
  void testJsonUpdateMode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().updateMode());
  }

  /**
   * Test {@link ImmutableBulkUploadLegalEntityRelationshipCommand#withInputString(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadLegalEntityRelationshipCommand#withInputString(String)}
   */
  @Test
  @DisplayName("Test withInputString(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadLegalEntityRelationshipCommand ImmutableBulkUploadLegalEntityRelationshipCommand.withInputString(String)"
  })
  void testWithInputString() {
    // Arrange
    ImmutableBulkUploadLegalEntityRelationshipCommand
        immutableBulkUploadLegalEntityRelationshipCommand =
            ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
                .inputString("42")
                .legalEntityRelationshipKindId(1L)
                .updateMode(BulkUpdateMode.ADD_ONLY)
                .build();

    // Act
    ImmutableBulkUploadLegalEntityRelationshipCommand actualWithInputStringResult =
        immutableBulkUploadLegalEntityRelationshipCommand.withInputString("42");

    // Assert
    assertSame(immutableBulkUploadLegalEntityRelationshipCommand, actualWithInputStringResult);
  }

  /**
   * Test {@link ImmutableBulkUploadLegalEntityRelationshipCommand#withInputString(String)}.
   *
   * <ul>
   *   <li>Then return inputString is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadLegalEntityRelationshipCommand#withInputString(String)}
   */
  @Test
  @DisplayName("Test withInputString(String); then return inputString is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadLegalEntityRelationshipCommand ImmutableBulkUploadLegalEntityRelationshipCommand.withInputString(String)"
  })
  void testWithInputString_thenReturnInputStringIs42() {
    // Arrange and Act
    ImmutableBulkUploadLegalEntityRelationshipCommand actualWithInputStringResult =
        ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
            .inputString("Input String")
            .legalEntityRelationshipKindId(1L)
            .updateMode(BulkUpdateMode.ADD_ONLY)
            .build()
            .withInputString("42");

    // Assert
    assertEquals("42", actualWithInputStringResult.inputString());
    assertEquals(1L, actualWithInputStringResult.legalEntityRelationshipKindId());
    assertEquals(BulkUpdateMode.ADD_ONLY, actualWithInputStringResult.updateMode());
  }

  /**
   * Test {@link
   * ImmutableBulkUploadLegalEntityRelationshipCommand#withLegalEntityRelationshipKindId(long)}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadLegalEntityRelationshipCommand#withLegalEntityRelationshipKindId(long)}
   */
  @Test
  @DisplayName("Test withLegalEntityRelationshipKindId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadLegalEntityRelationshipCommand ImmutableBulkUploadLegalEntityRelationshipCommand.withLegalEntityRelationshipKindId(long)"
  })
  void testWithLegalEntityRelationshipKindId() {
    // Arrange
    ImmutableBulkUploadLegalEntityRelationshipCommand
        immutableBulkUploadLegalEntityRelationshipCommand =
            ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
                .inputString("Input String")
                .legalEntityRelationshipKindId(42L)
                .updateMode(BulkUpdateMode.ADD_ONLY)
                .build();

    // Act
    ImmutableBulkUploadLegalEntityRelationshipCommand
        actualWithLegalEntityRelationshipKindIdResult =
            immutableBulkUploadLegalEntityRelationshipCommand.withLegalEntityRelationshipKindId(
                42L);

    // Assert
    assertSame(
        immutableBulkUploadLegalEntityRelationshipCommand,
        actualWithLegalEntityRelationshipKindIdResult);
  }

  /**
   * Test {@link
   * ImmutableBulkUploadLegalEntityRelationshipCommand#withLegalEntityRelationshipKindId(long)}.
   *
   * <ul>
   *   <li>Then return {@code Input String}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadLegalEntityRelationshipCommand#withLegalEntityRelationshipKindId(long)}
   */
  @Test
  @DisplayName("Test withLegalEntityRelationshipKindId(long); then return 'Input String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadLegalEntityRelationshipCommand ImmutableBulkUploadLegalEntityRelationshipCommand.withLegalEntityRelationshipKindId(long)"
  })
  void testWithLegalEntityRelationshipKindId_thenReturnInputString() {
    // Arrange and Act
    ImmutableBulkUploadLegalEntityRelationshipCommand
        actualWithLegalEntityRelationshipKindIdResult =
            ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
                .inputString("Input String")
                .legalEntityRelationshipKindId(1L)
                .updateMode(BulkUpdateMode.ADD_ONLY)
                .build()
                .withLegalEntityRelationshipKindId(42L);

    // Assert
    assertEquals("Input String", actualWithLegalEntityRelationshipKindIdResult.inputString());
    assertEquals(
        42L, actualWithLegalEntityRelationshipKindIdResult.legalEntityRelationshipKindId());
    assertEquals(
        BulkUpdateMode.ADD_ONLY, actualWithLegalEntityRelationshipKindIdResult.updateMode());
  }

  /**
   * Test {@link ImmutableBulkUploadLegalEntityRelationshipCommand#withUpdateMode(BulkUpdateMode)}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadLegalEntityRelationshipCommand#withUpdateMode(BulkUpdateMode)}
   */
  @Test
  @DisplayName("Test withUpdateMode(BulkUpdateMode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadLegalEntityRelationshipCommand ImmutableBulkUploadLegalEntityRelationshipCommand.withUpdateMode(BulkUpdateMode)"
  })
  void testWithUpdateMode() {
    // Arrange
    ImmutableBulkUploadLegalEntityRelationshipCommand
        immutableBulkUploadLegalEntityRelationshipCommand =
            ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
                .inputString("Input String")
                .legalEntityRelationshipKindId(1L)
                .updateMode(BulkUpdateMode.ADD_ONLY)
                .build();

    // Act
    ImmutableBulkUploadLegalEntityRelationshipCommand actualWithUpdateModeResult =
        immutableBulkUploadLegalEntityRelationshipCommand.withUpdateMode(BulkUpdateMode.ADD_ONLY);

    // Assert
    assertSame(immutableBulkUploadLegalEntityRelationshipCommand, actualWithUpdateModeResult);
  }

  /**
   * Test {@link ImmutableBulkUploadLegalEntityRelationshipCommand#withUpdateMode(BulkUpdateMode)}.
   *
   * <ul>
   *   <li>Then return {@code Input String}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadLegalEntityRelationshipCommand#withUpdateMode(BulkUpdateMode)}
   */
  @Test
  @DisplayName("Test withUpdateMode(BulkUpdateMode); then return 'Input String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadLegalEntityRelationshipCommand ImmutableBulkUploadLegalEntityRelationshipCommand.withUpdateMode(BulkUpdateMode)"
  })
  void testWithUpdateMode_thenReturnInputString() {
    // Arrange and Act
    ImmutableBulkUploadLegalEntityRelationshipCommand actualWithUpdateModeResult =
        ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
            .inputString("Input String")
            .legalEntityRelationshipKindId(1L)
            .updateMode(BulkUpdateMode.REPLACE)
            .build()
            .withUpdateMode(BulkUpdateMode.ADD_ONLY);

    // Assert
    assertEquals("Input String", actualWithUpdateModeResult.inputString());
    assertEquals(1L, actualWithUpdateModeResult.legalEntityRelationshipKindId());
    assertEquals(BulkUpdateMode.ADD_ONLY, actualWithUpdateModeResult.updateMode());
  }
}
