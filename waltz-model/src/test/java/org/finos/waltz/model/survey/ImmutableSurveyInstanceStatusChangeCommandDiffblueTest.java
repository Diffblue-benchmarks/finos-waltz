package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.Optional;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceStatusChangeCommand.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceStatusChangeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceStatusChangeCommandDiffblueTest {
  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceStatusChangeCommand#builder()}
   *   <li>{@link ImmutableSurveyInstanceStatusChangeCommand#newApprovalDueDate(LocalDate)}
   *   <li>{@link ImmutableSurveyInstanceStatusChangeCommand#newDueDate(LocalDate)}
   *   <li>{@link ImmutableSurveyInstanceStatusChangeCommand#reason(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstanceStatusChangeCommand Builder.build()",
      "Builder Builder.newApprovalDueDate(LocalDate)", "Builder Builder.newDueDate(LocalDate)",
      "Builder Builder.reason(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableSurveyInstanceStatusChangeCommand.builder();
    Builder actualNewApprovalDueDateResult = actualBuilderResult.newApprovalDueDate(LocalDate.of(1970, 1, 1));
    Optional<? extends LocalDate> newApprovalDueDate = Optional.of(LocalDate.of(1970, 1, 1));
    Builder actualNewApprovalDueDateResult2 = actualNewApprovalDueDateResult.newApprovalDueDate(newApprovalDueDate);
    Builder actualNewDueDateResult = actualNewApprovalDueDateResult2.newDueDate(LocalDate.of(1970, 1, 1));
    Optional<? extends LocalDate> newDueDate = Optional.of(LocalDate.of(1970, 1, 1));
    Builder actualReasonResult = actualNewDueDateResult.newDueDate(newDueDate).reason("Just cause");
    Optional<String> reason = Optional.of("foo");

    // Assert
    assertSame(actualReasonResult, actualReasonResult.reason(reason));
  }

  /**
   * Test Builder {@link Builder#action(SurveyInstanceAction)}.
   * <p>
   * Method under test: {@link Builder#action(SurveyInstanceAction)}
   */
  @Test
  @DisplayName("Test Builder action(SurveyInstanceAction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.action(SurveyInstanceAction)"})
  void testBuilderAction() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceStatusChangeCommand.builder();

    // Act
    Builder actualActionResult = builderResult.action(SurveyInstanceAction.SUBMITTING);

    // Assert
    assertEquals(SurveyInstanceAction.SUBMITTING, builderResult.build().action());
    assertSame(builderResult, actualActionResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceStatusChangeCommand)}.
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceStatusChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceStatusChangeCommand)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceStatusChangeCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceStatusChangeCommand.builder();
    SurveyInstanceStatusChangeCommand instance = mock(SurveyInstanceStatusChangeCommand.class);
    Optional<LocalDate> emptyResult = Optional.empty();
    when(instance.newApprovalDueDate()).thenReturn(emptyResult);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newDueDate()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.reason()).thenReturn(ofResult2);
    when(instance.action()).thenReturn(SurveyInstanceAction.SUBMITTING);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).action();
    verify(instance).newApprovalDueDate();
    verify(instance).newDueDate();
    verify(instance).reason();
    assertEquals(SurveyInstanceAction.SUBMITTING, builderResult.build().action());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceStatusChangeCommand)}.
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceStatusChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceStatusChangeCommand); given Optional with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceStatusChangeCommand)"})
  void testBuilderFrom_givenOptionalWithFoo() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceStatusChangeCommand.builder();
    SurveyInstanceStatusChangeCommand instance = mock(SurveyInstanceStatusChangeCommand.class);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newApprovalDueDate()).thenReturn(ofResult);
    Optional<LocalDate> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newDueDate()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.reason()).thenReturn(ofResult3);
    when(instance.action()).thenReturn(SurveyInstanceAction.SUBMITTING);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).action();
    verify(instance).newApprovalDueDate();
    verify(instance).newDueDate();
    verify(instance).reason();
    assertEquals(SurveyInstanceAction.SUBMITTING, builderResult.build().action());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceStatusChangeCommand)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceStatusChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceStatusChangeCommand); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceStatusChangeCommand)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceStatusChangeCommand.builder();
    SurveyInstanceStatusChangeCommand instance = mock(SurveyInstanceStatusChangeCommand.class);
    when(instance.reason()).thenThrow(new IllegalStateException("instance"));
    when(instance.action()).thenReturn(SurveyInstanceAction.SUBMITTING);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).action();
    verify(instance).reason();
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceStatusChangeCommand)}.
   * <ul>
   *   <li>When {@link SurveyInstanceStatusChangeCommand} {@link SurveyInstanceStatusChangeCommand#newDueDate()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceStatusChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceStatusChangeCommand); when SurveyInstanceStatusChangeCommand newDueDate() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceStatusChangeCommand)"})
  void testBuilderFrom_whenSurveyInstanceStatusChangeCommandNewDueDateReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceStatusChangeCommand.builder();
    SurveyInstanceStatusChangeCommand instance = mock(SurveyInstanceStatusChangeCommand.class);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newApprovalDueDate()).thenReturn(ofResult);
    Optional<LocalDate> emptyResult = Optional.empty();
    when(instance.newDueDate()).thenReturn(emptyResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.reason()).thenReturn(ofResult2);
    when(instance.action()).thenReturn(SurveyInstanceAction.SUBMITTING);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).action();
    verify(instance).newApprovalDueDate();
    verify(instance).newDueDate();
    verify(instance).reason();
    assertEquals(SurveyInstanceAction.SUBMITTING, builderResult.build().action());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceStatusChangeCommand)}.
   * <ul>
   *   <li>When {@link SurveyInstanceStatusChangeCommand} {@link SurveyInstanceStatusChangeCommand#reason()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceStatusChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceStatusChangeCommand); when SurveyInstanceStatusChangeCommand reason() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceStatusChangeCommand)"})
  void testBuilderFrom_whenSurveyInstanceStatusChangeCommandReasonReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceStatusChangeCommand.builder();
    SurveyInstanceStatusChangeCommand instance = mock(SurveyInstanceStatusChangeCommand.class);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newApprovalDueDate()).thenReturn(ofResult);
    Optional<LocalDate> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newDueDate()).thenReturn(ofResult2);
    Optional<String> emptyResult = Optional.empty();
    when(instance.reason()).thenReturn(emptyResult);
    when(instance.action()).thenReturn(SurveyInstanceAction.SUBMITTING);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).action();
    verify(instance).newApprovalDueDate();
    verify(instance).newDueDate();
    verify(instance).reason();
    assertEquals(SurveyInstanceAction.SUBMITTING, builderResult.build().action());
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
    Builder builderResult = ImmutableSurveyInstanceStatusChangeCommand.builder();
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
    Builder builderResult = ImmutableSurveyInstanceStatusChangeCommand.builder();
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
    Builder builderResult = ImmutableSurveyInstanceStatusChangeCommand.builder();
    Optional<String> reason = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.reason(reason));
  }

  /**
   * Test Json {@link Json#action()}.
   * <p>
   * Method under test: {@link Json#action()}
   */
  @Test
  @DisplayName("Test Json action()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SurveyInstanceAction Json.action()"})
  void testJsonAction() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).action());
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
    assertNull(actualJson.action);
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
}
