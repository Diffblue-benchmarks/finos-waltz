package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceActionParams)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceActionParams)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceActionParams)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    Builder builderResult2 = ImmutableSurveyInstanceActionParams.builder();
    Builder newApprovalDueDateResult = builderResult2.newApprovalDueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceActionParams instance = newApprovalDueDateResult.newDueDate(LocalDate.of(1970, 1, 1))
        .reason("Just cause")
        .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#newApprovalDueDate(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#newApprovalDueDate(Optional)}
   */
  @Test
  @DisplayName("Test Builder newApprovalDueDate(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.newApprovalDueDate(Optional)"})
  void testBuilderNewApprovalDueDateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    Optional<? extends LocalDate> newApprovalDueDate = Optional.of(LocalDate.of(1970, 1, 1));

    // Act and Assert
    assertSame(builderResult, builderResult.newApprovalDueDate(newApprovalDueDate));
  }

  /**
   * Test Builder {@link Builder#newDueDate(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#newDueDate(Optional)}
   */
  @Test
  @DisplayName("Test Builder newDueDate(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.newDueDate(Optional)"})
  void testBuilderNewDueDateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    Optional<? extends LocalDate> newDueDate = Optional.of(LocalDate.of(1970, 1, 1));

    // Act and Assert
    assertSame(builderResult, builderResult.newDueDate(newDueDate));
  }

  /**
   * Test Builder {@link Builder#reason(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#reason(Optional)}
   */
  @Test
  @DisplayName("Test Builder reason(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.reason(Optional)"})
  void testBuilderReasonWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    Optional<String> reason = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.reason(reason));
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#copyOf(SurveyInstanceActionParams)}.
   * <ul>
   *   <li>Then return newApprovalDueDate toString is {@code 1970-01-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceActionParams#copyOf(SurveyInstanceActionParams)}
   */
  @Test
  @DisplayName("Test copyOf(SurveyInstanceActionParams); then return newApprovalDueDate toString is '1970-01-01'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableSurveyInstanceActionParams ImmutableSurveyInstanceActionParams.copyOf(SurveyInstanceActionParams)"})
  void testCopyOf_thenReturnNewApprovalDueDateToStringIs19700101() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    LocalDate newApprovalDueDate = LocalDate.of(1970, 1, 1);
    Builder newApprovalDueDateResult = builderResult.newApprovalDueDate(newApprovalDueDate);
    ImmutableSurveyInstanceActionParams instance = newApprovalDueDateResult.newDueDate(LocalDate.of(1970, 1, 1))
        .reason("Just cause")
        .build();

    // Act
    ImmutableSurveyInstanceActionParams actualCopyOfResult = ImmutableSurveyInstanceActionParams.copyOf(instance);

    // Assert
    Optional<LocalDate> newApprovalDueDateResult2 = actualCopyOfResult.newApprovalDueDate();
    LocalDate getResult = newApprovalDueDateResult2.get();
    assertEquals("1970-01-01", getResult.toString());
    Optional<String> reasonResult = actualCopyOfResult.reason();
    assertEquals("Just cause", reasonResult.get());
    assertTrue(newApprovalDueDateResult2.isPresent());
    assertTrue(reasonResult.isPresent());
    assertEquals(newApprovalDueDateResult2, actualCopyOfResult.newDueDate());
    assertSame(newApprovalDueDate, getResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#equals(Object)}, and {@link ImmutableSurveyInstanceActionParams#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceActionParams#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceActionParams#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSurveyInstanceActionParams.equals(Object)",
      "int ImmutableSurveyInstanceActionParams.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    Builder newApprovalDueDateResult = builderResult.newApprovalDueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceActionParams buildResult = newApprovalDueDateResult.newDueDate(LocalDate.of(1970, 1, 1))
        .reason("Just cause")
        .build();
    Builder builderResult2 = ImmutableSurveyInstanceActionParams.builder();
    Builder newApprovalDueDateResult2 = builderResult2.newApprovalDueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceActionParams buildResult2 = newApprovalDueDateResult2.newDueDate(LocalDate.of(1970, 1, 1))
        .reason("Just cause")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#equals(Object)}, and {@link ImmutableSurveyInstanceActionParams#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceActionParams#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceActionParams#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSurveyInstanceActionParams.equals(Object)",
      "int ImmutableSurveyInstanceActionParams.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    Builder newApprovalDueDateResult = builderResult.newApprovalDueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceActionParams buildResult = newApprovalDueDateResult.newDueDate(LocalDate.of(1970, 1, 1))
        .reason("Just cause")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceActionParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSurveyInstanceActionParams.equals(Object)",
      "int ImmutableSurveyInstanceActionParams.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    Builder newApprovalDueDateResult = builderResult.newApprovalDueDate(LocalDate.now());
    ImmutableSurveyInstanceActionParams buildResult = newApprovalDueDateResult.newDueDate(LocalDate.of(1970, 1, 1))
        .reason("Just cause")
        .build();
    Builder builderResult2 = ImmutableSurveyInstanceActionParams.builder();
    Builder newApprovalDueDateResult2 = builderResult2.newApprovalDueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceActionParams buildResult2 = newApprovalDueDateResult2.newDueDate(LocalDate.of(1970, 1, 1))
        .reason("Just cause")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceActionParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSurveyInstanceActionParams.equals(Object)",
      "int ImmutableSurveyInstanceActionParams.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    Builder newApprovalDueDateResult = builderResult.newApprovalDueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceActionParams buildResult = newApprovalDueDateResult.newDueDate(LocalDate.now())
        .reason("Just cause")
        .build();
    Builder builderResult2 = ImmutableSurveyInstanceActionParams.builder();
    Builder newApprovalDueDateResult2 = builderResult2.newApprovalDueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceActionParams buildResult2 = newApprovalDueDateResult2.newDueDate(LocalDate.of(1970, 1, 1))
        .reason("Just cause")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceActionParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSurveyInstanceActionParams.equals(Object)",
      "int ImmutableSurveyInstanceActionParams.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    Builder newApprovalDueDateResult = builderResult.newApprovalDueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceActionParams buildResult = newApprovalDueDateResult.newDueDate(LocalDate.of(1970, 1, 1))
        .reason("Reason")
        .build();
    Builder builderResult2 = ImmutableSurveyInstanceActionParams.builder();
    Builder newApprovalDueDateResult2 = builderResult2.newApprovalDueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceActionParams buildResult2 = newApprovalDueDateResult2.newDueDate(LocalDate.of(1970, 1, 1))
        .reason("Just cause")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceActionParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSurveyInstanceActionParams.equals(Object)",
      "int ImmutableSurveyInstanceActionParams.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    Builder newApprovalDueDateResult = builderResult.newApprovalDueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceActionParams buildResult = newApprovalDueDateResult.newDueDate(LocalDate.of(1970, 1, 1))
        .reason("Just cause")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceActionParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSurveyInstanceActionParams.equals(Object)",
      "int ImmutableSurveyInstanceActionParams.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    Builder newApprovalDueDateResult = builderResult.newApprovalDueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceActionParams buildResult = newApprovalDueDateResult.newDueDate(LocalDate.of(1970, 1, 1))
        .reason("Just cause")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableSurveyInstanceActionParams");
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return not newApprovalDueDate Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceActionParams#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; then return not newApprovalDueDate Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstanceActionParams ImmutableSurveyInstanceActionParams.fromJson(Json)"})
  void testFromJson_givenNull_thenReturnNotNewApprovalDueDatePresent() {
    // Arrange
    Json json = new Json();
    json.setReason(null);
    json.setNewDueDate(null);
    json.setNewApprovalDueDate(null);

    // Act
    ImmutableSurveyInstanceActionParams actualFromJsonResult = ImmutableSurveyInstanceActionParams.fromJson(json);

    // Assert
    Optional<LocalDate> newApprovalDueDateResult = actualFromJsonResult.newApprovalDueDate();
    assertFalse(newApprovalDueDateResult.isPresent());
    assertSame(newApprovalDueDateResult, actualFromJsonResult.newDueDate());
    assertSame(newApprovalDueDateResult, actualFromJsonResult.reason());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return newDueDate is {@link Json} (default constructor) {@link Json#reason}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceActionParams#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return newDueDate is Json (default constructor) reason")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstanceActionParams ImmutableSurveyInstanceActionParams.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnNewDueDateIsJsonReason() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableSurveyInstanceActionParams actualFromJsonResult = ImmutableSurveyInstanceActionParams.fromJson(json);

    // Assert
    Optional<String> optional = json.reason;
    assertSame(optional, actualFromJsonResult.newDueDate());
    assertSame(optional, actualFromJsonResult.reason());
  }

  /**
   * Test Json {@link Json#newApprovalDueDate()}.
   * <p>
   * Method under test: {@link Json#newApprovalDueDate()}
   */
  @Test
  @DisplayName("Test Json newApprovalDueDate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.newApprovalDueDate()"})
  void testJsonNewApprovalDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).newApprovalDueDate());
  }

  /**
   * Test Json {@link Json#newDueDate()}.
   * <p>
   * Method under test: {@link Json#newDueDate()}
   */
  @Test
  @DisplayName("Test Json newDueDate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.newDueDate()"})
  void testJsonNewDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).newDueDate());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#reason()}
   */
  @Test
  @DisplayName("Test Json reason()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.reason()"})
  void testJsonReason() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).reason());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#newApprovalDueDate()}.
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceActionParams#newApprovalDueDate()}
   */
  @Test
  @DisplayName("Test newApprovalDueDate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional ImmutableSurveyInstanceActionParams.newApprovalDueDate()"})
  void testNewApprovalDueDate() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    LocalDate newApprovalDueDate = LocalDate.of(1970, 1, 1);
    Builder newApprovalDueDateResult = builderResult.newApprovalDueDate(newApprovalDueDate);
    ImmutableSurveyInstanceActionParams buildResult = newApprovalDueDateResult.newDueDate(LocalDate.of(1970, 1, 1))
        .reason("Just cause")
        .build();

    // Act
    Optional<LocalDate> actualNewApprovalDueDateResult = buildResult.newApprovalDueDate();

    // Assert
    LocalDate getResult = actualNewApprovalDueDateResult.get();
    assertEquals("1970-01-01", getResult.toString());
    assertTrue(actualNewApprovalDueDateResult.isPresent());
    assertSame(newApprovalDueDate, getResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#newDueDate()}.
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceActionParams#newDueDate()}
   */
  @Test
  @DisplayName("Test newDueDate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional ImmutableSurveyInstanceActionParams.newDueDate()"})
  void testNewDueDate() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    Builder newApprovalDueDateResult = builderResult.newApprovalDueDate(LocalDate.of(1970, 1, 1));
    LocalDate newDueDate = LocalDate.of(1970, 1, 1);
    ImmutableSurveyInstanceActionParams buildResult = newApprovalDueDateResult.newDueDate(newDueDate)
        .reason("Just cause")
        .build();

    // Act
    Optional<LocalDate> actualNewDueDateResult = buildResult.newDueDate();

    // Assert
    LocalDate getResult = actualNewDueDateResult.get();
    assertEquals("1970-01-01", getResult.toString());
    assertTrue(actualNewDueDateResult.isPresent());
    assertSame(newDueDate, getResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#reason()}.
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceActionParams#reason()}
   */
  @Test
  @DisplayName("Test reason()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional ImmutableSurveyInstanceActionParams.reason()"})
  void testReason() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    Builder newApprovalDueDateResult = builderResult.newApprovalDueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceActionParams buildResult = newApprovalDueDateResult.newDueDate(LocalDate.of(1970, 1, 1))
        .reason("Just cause")
        .build();

    // Act
    Optional<String> actualReasonResult = buildResult.reason();

    // Assert
    assertEquals("Just cause", actualReasonResult.get());
    assertTrue(actualReasonResult.isPresent());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#withNewApprovalDueDate(Optional)} with {@code optional}.
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceActionParams#withNewApprovalDueDate(Optional)}
   */
  @Test
  @DisplayName("Test withNewApprovalDueDate(Optional) with 'optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableSurveyInstanceActionParams ImmutableSurveyInstanceActionParams.withNewApprovalDueDate(Optional)"})
  void testWithNewApprovalDueDateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    Builder newApprovalDueDateResult = builderResult.newApprovalDueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceActionParams buildResult = newApprovalDueDateResult.newDueDate(LocalDate.of(1970, 1, 1))
        .reason("Just cause")
        .build();
    Optional<? extends LocalDate> optional = Optional.of(LocalDate.of(1970, 1, 1));

    // Act and Assert
    assertEquals(buildResult, buildResult.withNewApprovalDueDate(optional));
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#withNewApprovalDueDate(LocalDate)} with {@code value}.
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceActionParams#withNewApprovalDueDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withNewApprovalDueDate(LocalDate) with 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableSurveyInstanceActionParams ImmutableSurveyInstanceActionParams.withNewApprovalDueDate(LocalDate)"})
  void testWithNewApprovalDueDateWithValue() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    Builder newApprovalDueDateResult = builderResult.newApprovalDueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceActionParams buildResult = newApprovalDueDateResult.newDueDate(LocalDate.of(1970, 1, 1))
        .reason("Just cause")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult.withNewApprovalDueDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#withNewDueDate(Optional)} with {@code optional}.
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceActionParams#withNewDueDate(Optional)}
   */
  @Test
  @DisplayName("Test withNewDueDate(Optional) with 'optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableSurveyInstanceActionParams ImmutableSurveyInstanceActionParams.withNewDueDate(Optional)"})
  void testWithNewDueDateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    Builder newApprovalDueDateResult = builderResult.newApprovalDueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceActionParams buildResult = newApprovalDueDateResult.newDueDate(LocalDate.of(1970, 1, 1))
        .reason("Just cause")
        .build();
    Optional<? extends LocalDate> optional = Optional.of(LocalDate.of(1970, 1, 1));

    // Act and Assert
    assertEquals(buildResult, buildResult.withNewDueDate(optional));
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#withNewDueDate(LocalDate)} with {@code value}.
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceActionParams#withNewDueDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withNewDueDate(LocalDate) with 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableSurveyInstanceActionParams ImmutableSurveyInstanceActionParams.withNewDueDate(LocalDate)"})
  void testWithNewDueDateWithValue() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    Builder newApprovalDueDateResult = builderResult.newApprovalDueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceActionParams buildResult = newApprovalDueDateResult.newDueDate(LocalDate.of(1970, 1, 1))
        .reason("Just cause")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult.withNewDueDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#withReason(Optional)} with {@code optional}.
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceActionParams#withReason(Optional)}
   */
  @Test
  @DisplayName("Test withReason(Optional) with 'optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstanceActionParams ImmutableSurveyInstanceActionParams.withReason(Optional)"})
  void testWithReasonWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    Builder newApprovalDueDateResult = builderResult.newApprovalDueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceActionParams buildResult = newApprovalDueDateResult.newDueDate(LocalDate.of(1970, 1, 1))
        .reason("42")
        .build();
    Optional<String> optional = Optional.of("42");

    // Act and Assert
    assertSame(buildResult, buildResult.withReason(optional));
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#withReason(Optional)} with {@code optional}.
   * <ul>
   *   <li>Then return newApprovalDueDate toString is {@code 1970-01-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceActionParams#withReason(Optional)}
   */
  @Test
  @DisplayName("Test withReason(Optional) with 'optional'; then return newApprovalDueDate toString is '1970-01-01'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstanceActionParams ImmutableSurveyInstanceActionParams.withReason(Optional)"})
  void testWithReasonWithOptional_thenReturnNewApprovalDueDateToStringIs19700101() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    LocalDate newApprovalDueDate = LocalDate.of(1970, 1, 1);
    Builder newApprovalDueDateResult = builderResult.newApprovalDueDate(newApprovalDueDate);
    ImmutableSurveyInstanceActionParams buildResult = newApprovalDueDateResult.newDueDate(LocalDate.of(1970, 1, 1))
        .reason("Just cause")
        .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableSurveyInstanceActionParams actualWithReasonResult = buildResult.withReason(optional);

    // Assert
    Optional<LocalDate> newApprovalDueDateResult2 = actualWithReasonResult.newApprovalDueDate();
    LocalDate getResult = newApprovalDueDateResult2.get();
    assertEquals("1970-01-01", getResult.toString());
    assertTrue(newApprovalDueDateResult2.isPresent());
    assertEquals(newApprovalDueDateResult2, actualWithReasonResult.newDueDate());
    assertEquals(optional, actualWithReasonResult.reason());
    assertSame(newApprovalDueDate, getResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#withReason(String)} with {@code value}.
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceActionParams#withReason(String)}
   */
  @Test
  @DisplayName("Test withReason(String) with 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstanceActionParams ImmutableSurveyInstanceActionParams.withReason(String)"})
  void testWithReasonWithValue() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    Builder newApprovalDueDateResult = builderResult.newApprovalDueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceActionParams buildResult = newApprovalDueDateResult.newDueDate(LocalDate.of(1970, 1, 1))
        .reason("42")
        .build();

    // Act and Assert
    assertSame(buildResult, buildResult.withReason("42"));
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionParams#withReason(String)} with {@code value}.
   * <ul>
   *   <li>Then return newApprovalDueDate toString is {@code 1970-01-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceActionParams#withReason(String)}
   */
  @Test
  @DisplayName("Test withReason(String) with 'value'; then return newApprovalDueDate toString is '1970-01-01'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstanceActionParams ImmutableSurveyInstanceActionParams.withReason(String)"})
  void testWithReasonWithValue_thenReturnNewApprovalDueDateToStringIs19700101() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    LocalDate newApprovalDueDate = LocalDate.of(1970, 1, 1);
    Builder newApprovalDueDateResult = builderResult.newApprovalDueDate(newApprovalDueDate);
    ImmutableSurveyInstanceActionParams buildResult = newApprovalDueDateResult.newDueDate(LocalDate.of(1970, 1, 1))
        .reason("Just cause")
        .build();

    // Act
    ImmutableSurveyInstanceActionParams actualWithReasonResult = buildResult.withReason("42");

    // Assert
    Optional<LocalDate> newApprovalDueDateResult2 = actualWithReasonResult.newApprovalDueDate();
    LocalDate getResult = newApprovalDueDateResult2.get();
    assertEquals("1970-01-01", getResult.toString());
    Optional<String> reasonResult = actualWithReasonResult.reason();
    assertEquals("42", reasonResult.get());
    assertTrue(newApprovalDueDateResult2.isPresent());
    assertTrue(reasonResult.isPresent());
    assertEquals(newApprovalDueDateResult2, actualWithReasonResult.newDueDate());
    assertSame(newApprovalDueDate, getResult);
  }
}
