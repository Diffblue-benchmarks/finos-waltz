package org.finos.waltz.model.survey;

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
import org.finos.waltz.model.survey.ImmutableSurveyInstanceActionParams.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceActionParams.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceActionParamsDiffblueTest {
  /**
   * Test Builder {@link Builder#from(SurveyInstanceActionParams)}.
   *
   * <p>Method under test: {@link Builder#from(SurveyInstanceActionParams)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceActionParams)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceActionParams)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    ImmutableSurveyInstanceActionParams instance =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyInstanceActionParams actualImmutableSurveyInstanceActionParams =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstanceActionParams);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#newApprovalDueDate(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#newApprovalDueDate(Optional)}
   */
  @Test
  @DisplayName("Test Builder newApprovalDueDate(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.newApprovalDueDate(Optional)"})
  void testBuilderNewApprovalDueDateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    Optional<? extends LocalDate> newApprovalDueDate = Optional.of(LocalDate.of(1970, 1, 1));

    // Act
    Builder actualNewApprovalDueDateResult = builderResult.newApprovalDueDate(newApprovalDueDate);

    // Assert
    assertSame(builderResult, actualNewApprovalDueDateResult);
  }

  /**
   * Test Builder {@link Builder#newDueDate(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#newDueDate(Optional)}
   */
  @Test
  @DisplayName("Test Builder newDueDate(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.newDueDate(Optional)"})
  void testBuilderNewDueDateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    Optional<? extends LocalDate> newDueDate = Optional.of(LocalDate.of(1970, 1, 1));

    // Act
    Builder actualNewDueDateResult = builderResult.newDueDate(newDueDate);

    // Assert
    assertSame(builderResult, actualNewDueDateResult);
  }

  /**
   * Test Builder {@link Builder#reason(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#reason(Optional)}
   */
  @Test
  @DisplayName("Test Builder reason(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.reason(Optional)"})
  void testBuilderReasonWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    Optional<String> reason = Optional.of("42");

    // Act
    Builder actualReasonResult = builderResult.reason(reason);

    // Assert
    assertSame(builderResult, actualReasonResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#copyOf(SurveyInstanceActionParams)}.
   *
   * <ul>
   *   <li>Then return newApprovalDueDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceActionParams#copyOf(SurveyInstanceActionParams)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SurveyInstanceActionParams); then return newApprovalDueDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionParams ImmutableSurveyInstanceActionParams.copyOf(SurveyInstanceActionParams)"
  })
  void testCopyOf_thenReturnNewApprovalDueDateToStringIs19700101() {
    // Arrange
    LocalDate newApprovalDueDate = LocalDate.of(1970, 1, 1);
    ImmutableSurveyInstanceActionParams instance =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(newApprovalDueDate)
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();

    // Act
    ImmutableSurveyInstanceActionParams actualCopyOfResult =
        ImmutableSurveyInstanceActionParams.copyOf(instance);

    // Assert
    Optional<LocalDate> newApprovalDueDateResult = actualCopyOfResult.newApprovalDueDate();
    LocalDate getResult = newApprovalDueDateResult.get();
    assertEquals("1970-01-01", getResult.toString());
    Optional<String> reasonResult = actualCopyOfResult.reason();
    assertEquals("Just cause", reasonResult.get());
    assertTrue(newApprovalDueDateResult.isPresent());
    assertTrue(reasonResult.isPresent());
    assertEquals(newApprovalDueDateResult, actualCopyOfResult.newDueDate());
    assertSame(newApprovalDueDate, getResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#equals(Object)}, and {@link
   * ImmutableSurveyInstanceActionParams#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceActionParams#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceActionParams#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceActionParams.equals(Object)",
    "int ImmutableSurveyInstanceActionParams.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams2 =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();

    // Act and Assert
    assertEquals(immutableSurveyInstanceActionParams, immutableSurveyInstanceActionParams2);
    assertEquals(
        immutableSurveyInstanceActionParams.hashCode(),
        immutableSurveyInstanceActionParams2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#equals(Object)}, and {@link
   * ImmutableSurveyInstanceActionParams#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceActionParams#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceActionParams#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceActionParams.equals(Object)",
    "int ImmutableSurveyInstanceActionParams.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();

    // Act and Assert
    assertEquals(immutableSurveyInstanceActionParams, immutableSurveyInstanceActionParams);
    int expectedHashCodeResult = immutableSurveyInstanceActionParams.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyInstanceActionParams.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceActionParams.equals(Object)",
    "int ImmutableSurveyInstanceActionParams.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.now())
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceActionParams,
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceActionParams.equals(Object)",
    "int ImmutableSurveyInstanceActionParams.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.now())
            .reason("Just cause")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceActionParams,
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceActionParams.equals(Object)",
    "int ImmutableSurveyInstanceActionParams.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Reason")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceActionParams,
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceActionParams.equals(Object)",
    "int ImmutableSurveyInstanceActionParams.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceActionParams.equals(Object)",
    "int ImmutableSurveyInstanceActionParams.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build(),
        "Different type to ImmutableSurveyInstanceActionParams");
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Reason is {@code null}.
   *   <li>Then return not reason Present.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionParams#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Reason is 'null'; then return not reason Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionParams ImmutableSurveyInstanceActionParams.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonReasonIsNull_thenReturnNotReasonPresent() {
    // Arrange
    Json json = new Json();
    json.setReason(null);
    Optional<LocalDate> newDueDate = Optional.of(LocalDate.of(1970, 1, 1));
    json.setNewDueDate(newDueDate);
    Optional<LocalDate> newApprovalDueDate = Optional.of(LocalDate.of(1970, 1, 1));
    json.setNewApprovalDueDate(newApprovalDueDate);

    // Act
    ImmutableSurveyInstanceActionParams actualFromJsonResult =
        ImmutableSurveyInstanceActionParams.fromJson(json);

    // Assert
    assertFalse(actualFromJsonResult.reason().isPresent());
    assertEquals(newApprovalDueDate, actualFromJsonResult.newApprovalDueDate());
    assertEquals(newApprovalDueDate, actualFromJsonResult.newDueDate());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@code 42}.
   *   <li>When {@link Json} (default constructor) NewDueDate is {@code null}.
   *   <li>Then return not newDueDate Present.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionParams#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of '42'; when Json (default constructor) NewDueDate is 'null'; then return not newDueDate Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionParams ImmutableSurveyInstanceActionParams.fromJson(Json)"
  })
  void testFromJson_givenOf42_whenJsonNewDueDateIsNull_thenReturnNotNewDueDatePresent() {
    // Arrange
    Json json = new Json();
    Optional<String> reason = Optional.of("42");
    json.setReason(reason);
    json.setNewDueDate(null);
    Optional<LocalDate> newApprovalDueDate = Optional.of(LocalDate.of(1970, 1, 1));
    json.setNewApprovalDueDate(newApprovalDueDate);

    // Act
    ImmutableSurveyInstanceActionParams actualFromJsonResult =
        ImmutableSurveyInstanceActionParams.fromJson(json);

    // Assert
    assertFalse(actualFromJsonResult.newDueDate().isPresent());
    assertEquals(reason, actualFromJsonResult.reason());
    assertEquals(newApprovalDueDate, actualFromJsonResult.newApprovalDueDate());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return not newApprovalDueDate Present.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionParams#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return not newApprovalDueDate Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionParams ImmutableSurveyInstanceActionParams.fromJson(Json)"
  })
  void testFromJson_thenReturnNotNewApprovalDueDatePresent() {
    // Arrange
    Json json = new Json();
    Optional<String> reason = Optional.of("42");
    json.setReason(reason);
    Optional<LocalDate> newDueDate = Optional.of(LocalDate.of(1970, 1, 1));
    json.setNewDueDate(newDueDate);
    json.setNewApprovalDueDate(null);

    // Act
    ImmutableSurveyInstanceActionParams actualFromJsonResult =
        ImmutableSurveyInstanceActionParams.fromJson(json);

    // Assert
    assertFalse(actualFromJsonResult.newApprovalDueDate().isPresent());
    assertEquals(reason, actualFromJsonResult.reason());
    assertEquals(newDueDate, actualFromJsonResult.newDueDate());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return newDueDate is {@link Json} (default constructor) {@link Json#reason}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionParams#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return newDueDate is Json (default constructor) reason")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionParams ImmutableSurveyInstanceActionParams.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnNewDueDateIsJsonReason() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableSurveyInstanceActionParams actualFromJsonResult =
        ImmutableSurveyInstanceActionParams.fromJson(json);

    // Assert
    Optional<String> optional = json.reason;
    assertSame(optional, actualFromJsonResult.newDueDate());
    assertSame(optional, actualFromJsonResult.reason());
  }

  /**
   * Test Json {@link Json#newApprovalDueDate()}.
   *
   * <p>Method under test: {@link Json#newApprovalDueDate()}
   */
  @Test
  @DisplayName("Test Json newApprovalDueDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.newApprovalDueDate()"})
  void testJsonNewApprovalDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().newApprovalDueDate());
  }

  /**
   * Test Json {@link Json#newDueDate()}.
   *
   * <p>Method under test: {@link Json#newDueDate()}
   */
  @Test
  @DisplayName("Test Json newDueDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.newDueDate()"})
  void testJsonNewDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().newDueDate());
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
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertFalse(actualJson.newApprovalDueDate.isPresent());
    assertFalse(actualJson.newDueDate.isPresent());
    assertFalse(actualJson.reason.isPresent());
  }

  /**
   * Test Json {@link Json#reason()}.
   *
   * <p>Method under test: {@link Json#reason()}
   */
  @Test
  @DisplayName("Test Json reason()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.reason()"})
  void testJsonReason() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().reason());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#newApprovalDueDate()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionParams#newApprovalDueDate()}
   */
  @Test
  @DisplayName("Test newApprovalDueDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyInstanceActionParams.newApprovalDueDate()"})
  void testNewApprovalDueDate() {
    // Arrange
    LocalDate newApprovalDueDate = LocalDate.of(1970, 1, 1);

    // Act
    Optional<LocalDate> actualNewApprovalDueDateResult =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(newApprovalDueDate)
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build()
            .newApprovalDueDate();

    // Assert
    LocalDate getResult = actualNewApprovalDueDateResult.get();
    assertEquals("1970-01-01", getResult.toString());
    assertTrue(actualNewApprovalDueDateResult.isPresent());
    assertSame(newApprovalDueDate, getResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#newDueDate()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionParams#newDueDate()}
   */
  @Test
  @DisplayName("Test newDueDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyInstanceActionParams.newDueDate()"})
  void testNewDueDate() {
    // Arrange
    LocalDate newDueDate = LocalDate.of(1970, 1, 1);

    // Act
    Optional<LocalDate> actualNewDueDateResult =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(newDueDate)
            .reason("Just cause")
            .build()
            .newDueDate();

    // Assert
    LocalDate getResult = actualNewDueDateResult.get();
    assertEquals("1970-01-01", getResult.toString());
    assertTrue(actualNewDueDateResult.isPresent());
    assertSame(newDueDate, getResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#reason()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionParams#reason()}
   */
  @Test
  @DisplayName("Test reason()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyInstanceActionParams.reason()"})
  void testReason() {
    // Arrange and Act
    Optional<String> actualReasonResult =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build()
            .reason();

    // Assert
    assertEquals("Just cause", actualReasonResult.get());
    assertTrue(actualReasonResult.isPresent());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionParams#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyInstanceActionParams.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "SurveyInstanceActionParams{reason=Just cause, newDueDate=1970-01-01, newApprovalDueDate=1970-01-01}",
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#withNewApprovalDueDate(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceActionParams#withNewApprovalDueDate(Optional)}
   */
  @Test
  @DisplayName("Test withNewApprovalDueDate(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionParams ImmutableSurveyInstanceActionParams.withNewApprovalDueDate(Optional)"
  })
  void testWithNewApprovalDueDateWithOptional() {
    // Arrange
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends LocalDate> optional = Optional.of(LocalDate.of(1970, 1, 1));

    // Act
    ImmutableSurveyInstanceActionParams actualWithNewApprovalDueDateResult =
        immutableSurveyInstanceActionParams.withNewApprovalDueDate(optional);

    // Assert
    assertEquals(immutableSurveyInstanceActionParams, actualWithNewApprovalDueDateResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#withNewApprovalDueDate(LocalDate)} with {@code
   * value}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceActionParams#withNewApprovalDueDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withNewApprovalDueDate(LocalDate) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionParams ImmutableSurveyInstanceActionParams.withNewApprovalDueDate(LocalDate)"
  })
  void testWithNewApprovalDueDateWithValue() {
    // Arrange
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();

    // Act
    ImmutableSurveyInstanceActionParams actualWithNewApprovalDueDateResult =
        immutableSurveyInstanceActionParams.withNewApprovalDueDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableSurveyInstanceActionParams, actualWithNewApprovalDueDateResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#withNewDueDate(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionParams#withNewDueDate(Optional)}
   */
  @Test
  @DisplayName("Test withNewDueDate(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionParams ImmutableSurveyInstanceActionParams.withNewDueDate(Optional)"
  })
  void testWithNewDueDateWithOptional() {
    // Arrange
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends LocalDate> optional = Optional.of(LocalDate.of(1970, 1, 1));

    // Act
    ImmutableSurveyInstanceActionParams actualWithNewDueDateResult =
        immutableSurveyInstanceActionParams.withNewDueDate(optional);

    // Assert
    assertEquals(immutableSurveyInstanceActionParams, actualWithNewDueDateResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#withNewDueDate(LocalDate)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionParams#withNewDueDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withNewDueDate(LocalDate) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionParams ImmutableSurveyInstanceActionParams.withNewDueDate(LocalDate)"
  })
  void testWithNewDueDateWithValue() {
    // Arrange
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();

    // Act
    ImmutableSurveyInstanceActionParams actualWithNewDueDateResult =
        immutableSurveyInstanceActionParams.withNewDueDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableSurveyInstanceActionParams, actualWithNewDueDateResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#withReason(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionParams#withReason(Optional)}
   */
  @Test
  @DisplayName("Test withReason(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionParams ImmutableSurveyInstanceActionParams.withReason(Optional)"
  })
  void testWithReasonWithOptional() {
    // Arrange
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("42")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSurveyInstanceActionParams actualWithReasonResult =
        immutableSurveyInstanceActionParams.withReason(optional);

    // Assert
    assertSame(immutableSurveyInstanceActionParams, actualWithReasonResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#withReason(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return newApprovalDueDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionParams#withReason(Optional)}
   */
  @Test
  @DisplayName(
      "Test withReason(Optional) with 'optional'; then return newApprovalDueDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionParams ImmutableSurveyInstanceActionParams.withReason(Optional)"
  })
  void testWithReasonWithOptional_thenReturnNewApprovalDueDateToStringIs19700101() {
    // Arrange
    LocalDate newApprovalDueDate = LocalDate.of(1970, 1, 1);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(newApprovalDueDate)
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSurveyInstanceActionParams actualWithReasonResult =
        immutableSurveyInstanceActionParams.withReason(optional);

    // Assert
    Optional<LocalDate> newApprovalDueDateResult = actualWithReasonResult.newApprovalDueDate();
    LocalDate getResult = newApprovalDueDateResult.get();
    assertEquals("1970-01-01", getResult.toString());
    assertTrue(newApprovalDueDateResult.isPresent());
    assertEquals(newApprovalDueDateResult, actualWithReasonResult.newDueDate());
    assertEquals(optional, actualWithReasonResult.reason());
    assertSame(newApprovalDueDate, getResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#withReason(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionParams#withReason(String)}
   */
  @Test
  @DisplayName("Test withReason(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionParams ImmutableSurveyInstanceActionParams.withReason(String)"
  })
  void testWithReasonWithValue() {
    // Arrange
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("42")
            .build();

    // Act
    ImmutableSurveyInstanceActionParams actualWithReasonResult =
        immutableSurveyInstanceActionParams.withReason("42");

    // Assert
    assertSame(immutableSurveyInstanceActionParams, actualWithReasonResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#withReason(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return newApprovalDueDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionParams#withReason(String)}
   */
  @Test
  @DisplayName(
      "Test withReason(String) with 'value'; then return newApprovalDueDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionParams ImmutableSurveyInstanceActionParams.withReason(String)"
  })
  void testWithReasonWithValue_thenReturnNewApprovalDueDateToStringIs19700101() {
    // Arrange
    LocalDate newApprovalDueDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableSurveyInstanceActionParams actualWithReasonResult =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(newApprovalDueDate)
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build()
            .withReason("42");

    // Assert
    Optional<LocalDate> newApprovalDueDateResult = actualWithReasonResult.newApprovalDueDate();
    LocalDate getResult = newApprovalDueDateResult.get();
    assertEquals("1970-01-01", getResult.toString());
    Optional<String> reasonResult = actualWithReasonResult.reason();
    assertEquals("42", reasonResult.get());
    assertTrue(newApprovalDueDateResult.isPresent());
    assertTrue(reasonResult.isPresent());
    assertEquals(newApprovalDueDateResult, actualWithReasonResult.newDueDate());
    assertSame(newApprovalDueDate, getResult);
  }
}
