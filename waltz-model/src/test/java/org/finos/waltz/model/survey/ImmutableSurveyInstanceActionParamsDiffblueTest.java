package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceActionParamsDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionParams.Builder#from(SurveyInstanceActionParams)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyInstanceActionParams.Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    SurveyInstanceActionParams instance = mock(SurveyInstanceActionParams.class);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newApprovalDueDate()).thenReturn(ofResult);
    Optional<LocalDate> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newDueDate()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.reason()).thenReturn(ofResult3);

    // Act
    ImmutableSurveyInstanceActionParams.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).newApprovalDueDate();
    verify(instance).newDueDate();
    verify(instance).reason();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionParams.Builder#from(SurveyInstanceActionParams)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyInstanceActionParams.Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    SurveyInstanceActionParams instance = mock(SurveyInstanceActionParams.class);
    Optional<LocalDate> emptyResult = Optional.empty();
    when(instance.newApprovalDueDate()).thenReturn(emptyResult);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newDueDate()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.reason()).thenReturn(ofResult2);

    // Act
    ImmutableSurveyInstanceActionParams.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).newApprovalDueDate();
    verify(instance).newDueDate();
    verify(instance).reason();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionParams.Builder#from(SurveyInstanceActionParams)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSurveyInstanceActionParams.Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    SurveyInstanceActionParams instance = mock(SurveyInstanceActionParams.class);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newApprovalDueDate()).thenReturn(ofResult);
    Optional<LocalDate> emptyResult = Optional.empty();
    when(instance.newDueDate()).thenReturn(emptyResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.reason()).thenReturn(ofResult2);

    // Act
    ImmutableSurveyInstanceActionParams.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).newApprovalDueDate();
    verify(instance).newDueDate();
    verify(instance).reason();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionParams.Builder#from(SurveyInstanceActionParams)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSurveyInstanceActionParams.Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    SurveyInstanceActionParams instance = mock(SurveyInstanceActionParams.class);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newApprovalDueDate()).thenReturn(ofResult);
    Optional<LocalDate> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newDueDate()).thenReturn(ofResult2);
    Optional<String> emptyResult = Optional.empty();
    when(instance.reason()).thenReturn(emptyResult);

    // Act
    ImmutableSurveyInstanceActionParams.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).newApprovalDueDate();
    verify(instance).newDueDate();
    verify(instance).reason();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionParams.Builder#reason(Optional)}
   */
  @Test
  void testBuilderReason() {
    // Arrange
    ImmutableSurveyInstanceActionParams.Builder builderResult = ImmutableSurveyInstanceActionParams.builder();
    Optional<String> reason = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.reason(reason));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionParams#copyOf(SurveyInstanceActionParams)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyInstanceActionParams instance = mock(SurveyInstanceActionParams.class);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newApprovalDueDate()).thenReturn(ofResult);
    Optional<LocalDate> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newDueDate()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.reason()).thenReturn(ofResult3);

    // Act
    ImmutableSurveyInstanceActionParams actualCopyOfResult = ImmutableSurveyInstanceActionParams.copyOf(instance);

    // Assert
    verify(instance).newApprovalDueDate();
    verify(instance).newDueDate();
    verify(instance).reason();
    assertEquals(ofResult3, actualCopyOfResult.reason());
    assertEquals(ofResult, actualCopyOfResult.newApprovalDueDate());
    assertEquals(ofResult, actualCopyOfResult.newDueDate());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionParams#copyOf(SurveyInstanceActionParams)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    SurveyInstanceActionParams instance = mock(SurveyInstanceActionParams.class);
    Optional<LocalDate> emptyResult = Optional.empty();
    when(instance.newApprovalDueDate()).thenReturn(emptyResult);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newDueDate()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.reason()).thenReturn(ofResult2);

    // Act
    ImmutableSurveyInstanceActionParams actualCopyOfResult = ImmutableSurveyInstanceActionParams.copyOf(instance);

    // Assert
    verify(instance).newApprovalDueDate();
    verify(instance).newDueDate();
    verify(instance).reason();
    Optional<LocalDate> newApprovalDueDateResult = actualCopyOfResult.newApprovalDueDate();
    assertFalse(newApprovalDueDateResult.isPresent());
    assertEquals(ofResult2, actualCopyOfResult.reason());
    assertEquals(ofResult, actualCopyOfResult.newDueDate());
    assertSame(emptyResult, newApprovalDueDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionParams#copyOf(SurveyInstanceActionParams)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    SurveyInstanceActionParams instance = mock(SurveyInstanceActionParams.class);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newApprovalDueDate()).thenReturn(ofResult);
    Optional<LocalDate> emptyResult = Optional.empty();
    when(instance.newDueDate()).thenReturn(emptyResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.reason()).thenReturn(ofResult2);

    // Act
    ImmutableSurveyInstanceActionParams actualCopyOfResult = ImmutableSurveyInstanceActionParams.copyOf(instance);

    // Assert
    verify(instance).newApprovalDueDate();
    verify(instance).newDueDate();
    verify(instance).reason();
    Optional<LocalDate> newDueDateResult = actualCopyOfResult.newDueDate();
    assertFalse(newDueDateResult.isPresent());
    assertEquals(ofResult2, actualCopyOfResult.reason());
    assertEquals(ofResult, actualCopyOfResult.newApprovalDueDate());
    assertSame(emptyResult, newDueDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionParams#copyOf(SurveyInstanceActionParams)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    SurveyInstanceActionParams instance = mock(SurveyInstanceActionParams.class);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newApprovalDueDate()).thenReturn(ofResult);
    Optional<LocalDate> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.newDueDate()).thenReturn(ofResult2);
    Optional<String> emptyResult = Optional.empty();
    when(instance.reason()).thenReturn(emptyResult);

    // Act
    ImmutableSurveyInstanceActionParams actualCopyOfResult = ImmutableSurveyInstanceActionParams.copyOf(instance);

    // Assert
    verify(instance).newApprovalDueDate();
    verify(instance).newDueDate();
    verify(instance).reason();
    Optional<String> reasonResult = actualCopyOfResult.reason();
    assertFalse(reasonResult.isPresent());
    assertEquals(ofResult, actualCopyOfResult.newApprovalDueDate());
    assertEquals(ofResult, actualCopyOfResult.newDueDate());
    assertSame(emptyResult, reasonResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionParams#fromJson(ImmutableSurveyInstanceActionParams.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSurveyInstanceActionParams.Json json = new ImmutableSurveyInstanceActionParams.Json();

    // Act
    ImmutableSurveyInstanceActionParams actualFromJsonResult = ImmutableSurveyInstanceActionParams.fromJson(json);

    // Assert
    Optional<LocalDate> newApprovalDueDateResult = actualFromJsonResult.newApprovalDueDate();
    assertFalse(newApprovalDueDateResult.isPresent());
    Optional<String> optional = json.reason;
    assertSame(optional, newApprovalDueDateResult);
    assertSame(optional, actualFromJsonResult.newDueDate());
    assertSame(optional, actualFromJsonResult.reason());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionParams#fromJson(ImmutableSurveyInstanceActionParams.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableSurveyInstanceActionParams.Json json = new ImmutableSurveyInstanceActionParams.Json();
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
   * Method under test:
   * {@link ImmutableSurveyInstanceActionParams.Json#newApprovalDueDate()}
   */
  @Test
  void testJsonNewApprovalDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceActionParams.Json()).newApprovalDueDate());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionParams.Json#newDueDate()}
   */
  @Test
  void testJsonNewDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceActionParams.Json()).newDueDate());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSurveyInstanceActionParams.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSurveyInstanceActionParams.Json actualJson = new ImmutableSurveyInstanceActionParams.Json();

    // Assert
    assertFalse(actualJson.newApprovalDueDate.isPresent());
    assertFalse(actualJson.newDueDate.isPresent());
    assertFalse(actualJson.reason.isPresent());
  }

  /**
   * Method under test: {@link ImmutableSurveyInstanceActionParams.Json#reason()}
   */
  @Test
  void testJsonReason() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstanceActionParams.Json()).reason());
  }
}
