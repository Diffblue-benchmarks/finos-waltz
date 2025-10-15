package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.Optional;
import org.finos.waltz.model.ImmutableDateChangeCommand.Builder;
import org.finos.waltz.model.ImmutableDateChangeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDateChangeCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#from(DateChangeCommand)}.
   *
   * <p>Method under test: {@link Builder#from(DateChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(DateChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DateChangeCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableDateChangeCommand.builder();
    ImmutableDateChangeCommand instance =
        ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableDateChangeCommand actualImmutableDateChangeCommand = builderResult.build();
    assertEquals(instance, actualImmutableDateChangeCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#newDateVal(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#newDateVal(Optional)}
   */
  @Test
  @DisplayName("Test Builder newDateVal(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.newDateVal(Optional)"})
  void testBuilderNewDateValWithOptional() {
    // Arrange
    Builder builderResult = ImmutableDateChangeCommand.builder();
    Optional<? extends LocalDate> newDateVal = Optional.of(LocalDate.of(1970, 1, 1));

    // Act
    Builder actualNewDateValResult = builderResult.newDateVal(newDateVal);

    // Assert
    assertSame(builderResult, actualNewDateValResult);
  }

  /**
   * Test {@link ImmutableDateChangeCommand#copyOf(DateChangeCommand)}.
   *
   * <ul>
   *   <li>Then return newDateVal toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateChangeCommand#copyOf(DateChangeCommand)}
   */
  @Test
  @DisplayName("Test copyOf(DateChangeCommand); then return newDateVal toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDateChangeCommand ImmutableDateChangeCommand.copyOf(DateChangeCommand)"
  })
  void testCopyOf_thenReturnNewDateValToStringIs19700101() {
    // Arrange
    LocalDate newDateVal = LocalDate.of(1970, 1, 1);
    ImmutableDateChangeCommand instance =
        ImmutableDateChangeCommand.builder().newDateVal(newDateVal).build();

    // Act and Assert
    Optional<LocalDate> newDateValResult = ImmutableDateChangeCommand.copyOf(instance).newDateVal();
    LocalDate getResult = newDateValResult.get();
    assertEquals("1970-01-01", getResult.toString());
    assertTrue(newDateValResult.isPresent());
    assertSame(newDateVal, getResult);
  }

  /**
   * Test {@link ImmutableDateChangeCommand#equals(Object)}, and {@link
   * ImmutableDateChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDateChangeCommand#equals(Object)}
   *   <li>{@link ImmutableDateChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDateChangeCommand.equals(Object)",
    "int ImmutableDateChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableDateChangeCommand immutableDateChangeCommand =
        ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build();
    ImmutableDateChangeCommand immutableDateChangeCommand2 =
        ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build();

    // Act and Assert
    assertEquals(immutableDateChangeCommand, immutableDateChangeCommand2);
    assertEquals(immutableDateChangeCommand.hashCode(), immutableDateChangeCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableDateChangeCommand#equals(Object)}, and {@link
   * ImmutableDateChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDateChangeCommand#equals(Object)}
   *   <li>{@link ImmutableDateChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDateChangeCommand.equals(Object)",
    "int ImmutableDateChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableDateChangeCommand immutableDateChangeCommand =
        ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build();

    // Act and Assert
    assertEquals(immutableDateChangeCommand, immutableDateChangeCommand);
    int expectedHashCodeResult = immutableDateChangeCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableDateChangeCommand.hashCode());
  }

  /**
   * Test {@link ImmutableDateChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDateChangeCommand.equals(Object)",
    "int ImmutableDateChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableDateChangeCommand immutableDateChangeCommand =
        ImmutableDateChangeCommand.builder().newDateVal(LocalDate.now()).build();

    // Act and Assert
    assertNotEquals(
        immutableDateChangeCommand,
        ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build());
  }

  /**
   * Test {@link ImmutableDateChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDateChangeCommand.equals(Object)",
    "int ImmutableDateChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build(), null);
  }

  /**
   * Test {@link ImmutableDateChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDateChangeCommand.equals(Object)",
    "int ImmutableDateChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build(),
        "Different type to ImmutableDateChangeCommand");
  }

  /**
   * Test {@link ImmutableDateChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) NewDateVal is {@code null}.
   *   <li>Then return not newDateVal Present.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) NewDateVal is 'null'; then return not newDateVal Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDateChangeCommand ImmutableDateChangeCommand.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonNewDateValIsNull_thenReturnNotNewDateValPresent() {
    // Arrange
    Json json = new Json();
    json.setNewDateVal(null);

    // Act
    ImmutableDateChangeCommand actualFromJsonResult = ImmutableDateChangeCommand.fromJson(json);

    // Assert
    assertFalse(actualFromJsonResult.newDateVal().isPresent());
  }

  /**
   * Test {@link ImmutableDateChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return not newDateVal Present.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return not newDateVal Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDateChangeCommand ImmutableDateChangeCommand.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnNotNewDateValPresent() {
    // Arrange and Act
    ImmutableDateChangeCommand actualFromJsonResult =
        ImmutableDateChangeCommand.fromJson(new Json());

    // Assert
    assertFalse(actualFromJsonResult.newDateVal().isPresent());
  }

  /**
   * Test Json {@link Json#newDateVal()}.
   *
   * <p>Method under test: {@link Json#newDateVal()}
   */
  @Test
  @DisplayName("Test Json newDateVal()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.newDateVal()"})
  void testJsonNewDateVal() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().newDateVal());
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
    assertFalse(new Json().newDateVal.isPresent());
  }

  /**
   * Test {@link ImmutableDateChangeCommand#newDateVal()}.
   *
   * <p>Method under test: {@link ImmutableDateChangeCommand#newDateVal()}
   */
  @Test
  @DisplayName("Test newDateVal()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableDateChangeCommand.newDateVal()"})
  void testNewDateVal() {
    // Arrange
    LocalDate newDateVal = LocalDate.of(1970, 1, 1);

    // Act
    Optional<LocalDate> actualNewDateValResult =
        ImmutableDateChangeCommand.builder().newDateVal(newDateVal).build().newDateVal();

    // Assert
    LocalDate getResult = actualNewDateValResult.get();
    assertEquals("1970-01-01", getResult.toString());
    assertTrue(actualNewDateValResult.isPresent());
    assertSame(newDateVal, getResult);
  }

  /**
   * Test {@link ImmutableDateChangeCommand#toString()}.
   *
   * <p>Method under test: {@link ImmutableDateChangeCommand#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutableDateChangeCommand.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "DateChangeCommand{newDateVal=1970-01-01}",
        ImmutableDateChangeCommand.builder()
            .newDateVal(LocalDate.of(1970, 1, 1))
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableDateChangeCommand#withNewDateVal(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableDateChangeCommand#withNewDateVal(Optional)}
   */
  @Test
  @DisplayName("Test withNewDateVal(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDateChangeCommand ImmutableDateChangeCommand.withNewDateVal(Optional)"
  })
  void testWithNewDateValWithOptional() {
    // Arrange
    ImmutableDateChangeCommand immutableDateChangeCommand =
        ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build();
    Optional<? extends LocalDate> optional = Optional.of(LocalDate.of(1970, 1, 1));

    // Act
    ImmutableDateChangeCommand actualWithNewDateValResult =
        immutableDateChangeCommand.withNewDateVal(optional);

    // Assert
    assertEquals(immutableDateChangeCommand, actualWithNewDateValResult);
  }

  /**
   * Test {@link ImmutableDateChangeCommand#withNewDateVal(LocalDate)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableDateChangeCommand#withNewDateVal(LocalDate)}
   */
  @Test
  @DisplayName("Test withNewDateVal(LocalDate) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDateChangeCommand ImmutableDateChangeCommand.withNewDateVal(LocalDate)"
  })
  void testWithNewDateValWithValue() {
    // Arrange
    ImmutableDateChangeCommand immutableDateChangeCommand =
        ImmutableDateChangeCommand.builder().newDateVal(LocalDate.of(1970, 1, 1)).build();

    // Act
    ImmutableDateChangeCommand actualWithNewDateValResult =
        immutableDateChangeCommand.withNewDateVal(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableDateChangeCommand, actualWithNewDateValResult);
  }
}
