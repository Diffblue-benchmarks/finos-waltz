package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceStatusChangeCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceStatusChangeCommand.Builder#action(SurveyInstanceAction)}
   */
  @Test
  void testBuilderAction() {
    // Arrange
    ImmutableSurveyInstanceStatusChangeCommand.Builder builderResult = ImmutableSurveyInstanceStatusChangeCommand
        .builder();

    // Act
    ImmutableSurveyInstanceStatusChangeCommand.Builder actualActionResult = builderResult
        .action(SurveyInstanceAction.SUBMITTING);

    // Assert
    assertEquals(SurveyInstanceAction.SUBMITTING, actualActionResult.build().action());
    assertEquals(SurveyInstanceAction.SUBMITTING, builderResult.build().action());
    assertSame(builderResult, actualActionResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceStatusChangeCommand.Builder#from(SurveyInstanceStatusChangeCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyInstanceStatusChangeCommand.Builder builderResult = ImmutableSurveyInstanceStatusChangeCommand
        .builder();
    SurveyInstanceStatusChangeCommand instance = mock(SurveyInstanceStatusChangeCommand.class);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newApprovalDueDate()).thenReturn(ofResult);
    Optional<LocalDate> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newDueDate()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.reason()).thenReturn(ofResult3);
    when(instance.action()).thenReturn(SurveyInstanceAction.SUBMITTING);

    // Act
    ImmutableSurveyInstanceStatusChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).action();
    verify(instance).newApprovalDueDate();
    verify(instance).newDueDate();
    verify(instance).reason();
    assertEquals(SurveyInstanceAction.SUBMITTING, actualFromResult.build().action());
    assertEquals(SurveyInstanceAction.SUBMITTING, builderResult.build().action());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceStatusChangeCommand.Builder#from(SurveyInstanceStatusChangeCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyInstanceStatusChangeCommand.Builder builderResult = ImmutableSurveyInstanceStatusChangeCommand
        .builder();
    SurveyInstanceStatusChangeCommand instance = mock(SurveyInstanceStatusChangeCommand.class);
    when(instance.reason()).thenThrow(new IllegalStateException("instance"));
    when(instance.action()).thenReturn(SurveyInstanceAction.SUBMITTING);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).action();
    verify(instance).reason();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceStatusChangeCommand.Builder#from(SurveyInstanceStatusChangeCommand)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSurveyInstanceStatusChangeCommand.Builder builderResult = ImmutableSurveyInstanceStatusChangeCommand
        .builder();
    SurveyInstanceStatusChangeCommand instance = mock(SurveyInstanceStatusChangeCommand.class);
    Optional<LocalDate> emptyResult = Optional.empty();
    when(instance.newApprovalDueDate()).thenReturn(emptyResult);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newDueDate()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.reason()).thenReturn(ofResult2);
    when(instance.action()).thenReturn(SurveyInstanceAction.SUBMITTING);

    // Act
    ImmutableSurveyInstanceStatusChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).action();
    verify(instance).newApprovalDueDate();
    verify(instance).newDueDate();
    verify(instance).reason();
    assertEquals(SurveyInstanceAction.SUBMITTING, actualFromResult.build().action());
    assertEquals(SurveyInstanceAction.SUBMITTING, builderResult.build().action());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceStatusChangeCommand.Builder#from(SurveyInstanceStatusChangeCommand)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSurveyInstanceStatusChangeCommand.Builder builderResult = ImmutableSurveyInstanceStatusChangeCommand
        .builder();
    SurveyInstanceStatusChangeCommand instance = mock(SurveyInstanceStatusChangeCommand.class);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newApprovalDueDate()).thenReturn(ofResult);
    Optional<LocalDate> emptyResult = Optional.empty();
    when(instance.newDueDate()).thenReturn(emptyResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.reason()).thenReturn(ofResult2);
    when(instance.action()).thenReturn(SurveyInstanceAction.SUBMITTING);

    // Act
    ImmutableSurveyInstanceStatusChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).action();
    verify(instance).newApprovalDueDate();
    verify(instance).newDueDate();
    verify(instance).reason();
    assertEquals(SurveyInstanceAction.SUBMITTING, actualFromResult.build().action());
    assertEquals(SurveyInstanceAction.SUBMITTING, builderResult.build().action());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceStatusChangeCommand.Builder#from(SurveyInstanceStatusChangeCommand)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableSurveyInstanceStatusChangeCommand.Builder builderResult = ImmutableSurveyInstanceStatusChangeCommand
        .builder();
    SurveyInstanceStatusChangeCommand instance = mock(SurveyInstanceStatusChangeCommand.class);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newApprovalDueDate()).thenReturn(ofResult);
    Optional<LocalDate> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newDueDate()).thenReturn(ofResult2);
    Optional<String> emptyResult = Optional.empty();
    when(instance.reason()).thenReturn(emptyResult);
    when(instance.action()).thenReturn(SurveyInstanceAction.SUBMITTING);

    // Act
    ImmutableSurveyInstanceStatusChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).action();
    verify(instance).newApprovalDueDate();
    verify(instance).newDueDate();
    verify(instance).reason();
    assertEquals(SurveyInstanceAction.SUBMITTING, actualFromResult.build().action());
    assertEquals(SurveyInstanceAction.SUBMITTING, builderResult.build().action());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceStatusChangeCommand.Builder#reason(Optional)}
   */
  @Test
  void testBuilderReason() {
    // Arrange
    ImmutableSurveyInstanceStatusChangeCommand.Builder builderResult = ImmutableSurveyInstanceStatusChangeCommand
        .builder();
    Optional<String> reason = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.reason(reason));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceStatusChangeCommand#copyOf(SurveyInstanceStatusChangeCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyInstanceStatusChangeCommand instance = mock(SurveyInstanceStatusChangeCommand.class);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newApprovalDueDate()).thenReturn(ofResult);
    Optional<LocalDate> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newDueDate()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.reason()).thenReturn(ofResult3);
    when(instance.action()).thenReturn(SurveyInstanceAction.SUBMITTING);

    // Act
    ImmutableSurveyInstanceStatusChangeCommand actualCopyOfResult = ImmutableSurveyInstanceStatusChangeCommand
        .copyOf(instance);

    // Assert
    verify(instance).action();
    verify(instance).newApprovalDueDate();
    verify(instance).newDueDate();
    verify(instance).reason();
    assertEquals(SurveyInstanceAction.SUBMITTING, actualCopyOfResult.action());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceStatusChangeCommand#copyOf(SurveyInstanceStatusChangeCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    SurveyInstanceStatusChangeCommand instance = mock(SurveyInstanceStatusChangeCommand.class);
    Optional<LocalDate> emptyResult = Optional.empty();
    when(instance.newApprovalDueDate()).thenReturn(emptyResult);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newDueDate()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.reason()).thenReturn(ofResult2);
    when(instance.action()).thenReturn(SurveyInstanceAction.SUBMITTING);

    // Act
    ImmutableSurveyInstanceStatusChangeCommand actualCopyOfResult = ImmutableSurveyInstanceStatusChangeCommand
        .copyOf(instance);

    // Assert
    verify(instance).action();
    verify(instance).newApprovalDueDate();
    verify(instance).newDueDate();
    verify(instance).reason();
    assertEquals(SurveyInstanceAction.SUBMITTING, actualCopyOfResult.action());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceStatusChangeCommand#copyOf(SurveyInstanceStatusChangeCommand)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    SurveyInstanceStatusChangeCommand instance = mock(SurveyInstanceStatusChangeCommand.class);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newApprovalDueDate()).thenReturn(ofResult);
    Optional<LocalDate> emptyResult = Optional.empty();
    when(instance.newDueDate()).thenReturn(emptyResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.reason()).thenReturn(ofResult2);
    when(instance.action()).thenReturn(SurveyInstanceAction.SUBMITTING);

    // Act
    ImmutableSurveyInstanceStatusChangeCommand actualCopyOfResult = ImmutableSurveyInstanceStatusChangeCommand
        .copyOf(instance);

    // Assert
    verify(instance).action();
    verify(instance).newApprovalDueDate();
    verify(instance).newDueDate();
    verify(instance).reason();
    assertEquals(SurveyInstanceAction.SUBMITTING, actualCopyOfResult.action());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceStatusChangeCommand#copyOf(SurveyInstanceStatusChangeCommand)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    SurveyInstanceStatusChangeCommand instance = mock(SurveyInstanceStatusChangeCommand.class);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newApprovalDueDate()).thenReturn(ofResult);
    Optional<LocalDate> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newDueDate()).thenReturn(ofResult2);
    Optional<String> emptyResult = Optional.empty();
    when(instance.reason()).thenReturn(emptyResult);
    when(instance.action()).thenReturn(SurveyInstanceAction.SUBMITTING);

    // Act
    ImmutableSurveyInstanceStatusChangeCommand actualCopyOfResult = ImmutableSurveyInstanceStatusChangeCommand
        .copyOf(instance);

    // Assert
    verify(instance).action();
    verify(instance).newApprovalDueDate();
    verify(instance).newDueDate();
    verify(instance).reason();
    assertEquals(SurveyInstanceAction.SUBMITTING, actualCopyOfResult.action());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceStatusChangeCommand#fromJson(ImmutableSurveyInstanceStatusChangeCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSurveyInstanceStatusChangeCommand.Json json = new ImmutableSurveyInstanceStatusChangeCommand.Json();
    json.setAction(SurveyInstanceAction.SUBMITTING);
    json.setReason(null);
    json.setNewDueDate(null);
    json.setNewApprovalDueDate(null);

    // Act and Assert
    assertEquals(SurveyInstanceAction.SUBMITTING, ImmutableSurveyInstanceStatusChangeCommand.fromJson(json).action());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceStatusChangeCommand.Json#action()}
   */
  @Test
  void testJsonAction() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceStatusChangeCommand.Json()).action());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceStatusChangeCommand.Json#newApprovalDueDate()}
   */
  @Test
  void testJsonNewApprovalDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceStatusChangeCommand.Json()).newApprovalDueDate());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceStatusChangeCommand.Json#newDueDate()}
   */
  @Test
  void testJsonNewDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceStatusChangeCommand.Json()).newDueDate());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSurveyInstanceStatusChangeCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSurveyInstanceStatusChangeCommand.Json actualJson = new ImmutableSurveyInstanceStatusChangeCommand.Json();

    // Assert
    assertNull(actualJson.action);
    assertFalse(actualJson.newApprovalDueDate.isPresent());
    assertFalse(actualJson.newDueDate.isPresent());
    assertFalse(actualJson.reason.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceStatusChangeCommand.Json#reason()}
   */
  @Test
  void testJsonReason() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceStatusChangeCommand.Json()).reason());
  }
}
