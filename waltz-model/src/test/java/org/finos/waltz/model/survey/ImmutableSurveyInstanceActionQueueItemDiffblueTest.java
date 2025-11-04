package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;
import org.finos.waltz.model.IdProvider;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceActionQueueItemDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionQueueItem.Builder#action(SurveyInstanceAction)}
   */
  @Test
  void testBuilderAction() {
    // Arrange
    ImmutableSurveyInstanceActionQueueItem.Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.action(SurveyInstanceAction.SUBMITTING));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionQueueItem.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyInstanceActionQueueItem.Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableSurveyInstanceActionQueueItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionQueueItem.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyInstanceActionQueueItem.Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableSurveyInstanceActionQueueItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionQueueItem.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSurveyInstanceActionQueueItem.Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionQueueItem.Builder#from(SurveyInstanceActionQueueItem)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSurveyInstanceActionQueueItem.Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();
    SurveyInstanceActionQueueItem instance = mock(SurveyInstanceActionQueueItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.message()).thenReturn("Not all who wander are lost");
    when(instance.status()).thenReturn(SurveyInstanceActionStatus.PENDING);
    when(instance.submittedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<SurveyInstanceActionParams> ofResult2 = Optional.of(new ImmutableSurveyInstanceActionParams.Json());
    when(instance.actionParams()).thenReturn(ofResult2);
    when(instance.action()).thenReturn(SurveyInstanceAction.SUBMITTING);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.surveyInstanceId()).thenReturn(1L);
    when(instance.actionedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.initialState()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.submittedBy()).thenReturn("Submitted By");

    // Act
    ImmutableSurveyInstanceActionQueueItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).action();
    verify(instance).actionParams();
    verify(instance).actionedAt();
    verify(instance).initialState();
    verify(instance).message();
    verify(instance).provenance();
    verify(instance).status();
    verify(instance).submittedAt();
    verify(instance).submittedBy();
    verify(instance).surveyInstanceId();
    ImmutableSurveyInstanceActionQueueItem buildResult = builderResult.build();
    assertEquals("Not all who wander are lost", buildResult.message());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("Submitted By", buildResult.submittedBy());
    assertEquals(1L, buildResult.surveyInstanceId().longValue());
    assertEquals(SurveyInstanceAction.SUBMITTING, buildResult.action());
    assertEquals(SurveyInstanceActionStatus.PENDING, buildResult.status());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, buildResult.initialState());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionQueueItem.Builder#from(SurveyInstanceActionQueueItem)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableSurveyInstanceActionQueueItem.Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();
    SurveyInstanceActionQueueItem instance = mock(SurveyInstanceActionQueueItem.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.message()).thenReturn("Not all who wander are lost");
    when(instance.status()).thenReturn(SurveyInstanceActionStatus.PENDING);
    when(instance.submittedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<SurveyInstanceActionParams> ofResult = Optional.of(new ImmutableSurveyInstanceActionParams.Json());
    when(instance.actionParams()).thenReturn(ofResult);
    when(instance.action()).thenReturn(SurveyInstanceAction.SUBMITTING);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.surveyInstanceId()).thenReturn(1L);
    when(instance.actionedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.initialState()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.submittedBy()).thenReturn("Submitted By");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).action();
    verify(instance).actionParams();
    verify(instance).actionedAt();
    verify(instance).initialState();
    verify(instance).message();
    verify(instance).provenance();
    verify(instance).status();
    verify(instance).submittedAt();
    verify(instance).submittedBy();
    verify(instance).surveyInstanceId();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionQueueItem.Builder#from(SurveyInstanceActionQueueItem)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableSurveyInstanceActionQueueItem.Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();
    SurveyInstanceActionQueueItem instance = mock(SurveyInstanceActionQueueItem.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.message()).thenReturn("Not all who wander are lost");
    when(instance.status()).thenReturn(SurveyInstanceActionStatus.PENDING);
    when(instance.submittedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<SurveyInstanceActionParams> ofResult = Optional.of(new ImmutableSurveyInstanceActionParams.Json());
    when(instance.actionParams()).thenReturn(ofResult);
    when(instance.action()).thenReturn(SurveyInstanceAction.SUBMITTING);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.surveyInstanceId()).thenReturn(1L);
    when(instance.actionedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.initialState()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.submittedBy()).thenReturn("Submitted By");

    // Act
    ImmutableSurveyInstanceActionQueueItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).action();
    verify(instance).actionParams();
    verify(instance).actionedAt();
    verify(instance).initialState();
    verify(instance).message();
    verify(instance).provenance();
    verify(instance).status();
    verify(instance).submittedAt();
    verify(instance).submittedBy();
    verify(instance).surveyInstanceId();
    ImmutableSurveyInstanceActionQueueItem buildResult = builderResult.build();
    assertEquals("Not all who wander are lost", buildResult.message());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("Submitted By", buildResult.submittedBy());
    assertEquals(1L, buildResult.surveyInstanceId().longValue());
    assertEquals(SurveyInstanceAction.SUBMITTING, buildResult.action());
    assertEquals(SurveyInstanceActionStatus.PENDING, buildResult.status());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, buildResult.initialState());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionQueueItem.Builder#from(SurveyInstanceActionQueueItem)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableSurveyInstanceActionQueueItem.Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();
    SurveyInstanceActionQueueItem instance = mock(SurveyInstanceActionQueueItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.message()).thenReturn(null);
    when(instance.status()).thenReturn(SurveyInstanceActionStatus.PENDING);
    when(instance.submittedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<SurveyInstanceActionParams> ofResult2 = Optional.of(new ImmutableSurveyInstanceActionParams.Json());
    when(instance.actionParams()).thenReturn(ofResult2);
    when(instance.action()).thenReturn(SurveyInstanceAction.SUBMITTING);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.surveyInstanceId()).thenReturn(1L);
    when(instance.actionedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.initialState()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.submittedBy()).thenReturn("Submitted By");

    // Act
    ImmutableSurveyInstanceActionQueueItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).action();
    verify(instance).actionParams();
    verify(instance).actionedAt();
    verify(instance).initialState();
    verify(instance).message();
    verify(instance).provenance();
    verify(instance).status();
    verify(instance).submittedAt();
    verify(instance).submittedBy();
    verify(instance).surveyInstanceId();
    ImmutableSurveyInstanceActionQueueItem buildResult = builderResult.build();
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("Submitted By", buildResult.submittedBy());
    assertNull(buildResult.message());
    assertEquals(1L, buildResult.surveyInstanceId().longValue());
    assertEquals(SurveyInstanceAction.SUBMITTING, buildResult.action());
    assertEquals(SurveyInstanceActionStatus.PENDING, buildResult.status());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, buildResult.initialState());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionQueueItem.Builder#from(SurveyInstanceActionQueueItem)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableSurveyInstanceActionQueueItem.Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();
    SurveyInstanceActionQueueItem instance = mock(SurveyInstanceActionQueueItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.message()).thenReturn("Not all who wander are lost");
    when(instance.status()).thenReturn(SurveyInstanceActionStatus.PENDING);
    when(instance.submittedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<SurveyInstanceActionParams> emptyResult = Optional.empty();
    when(instance.actionParams()).thenReturn(emptyResult);
    when(instance.action()).thenReturn(SurveyInstanceAction.SUBMITTING);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.surveyInstanceId()).thenReturn(1L);
    when(instance.actionedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.initialState()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.submittedBy()).thenReturn("Submitted By");

    // Act
    ImmutableSurveyInstanceActionQueueItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).action();
    verify(instance).actionParams();
    verify(instance).actionedAt();
    verify(instance).initialState();
    verify(instance).message();
    verify(instance).provenance();
    verify(instance).status();
    verify(instance).submittedAt();
    verify(instance).submittedBy();
    verify(instance).surveyInstanceId();
    ImmutableSurveyInstanceActionQueueItem buildResult = builderResult.build();
    assertEquals("Not all who wander are lost", buildResult.message());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("Submitted By", buildResult.submittedBy());
    assertEquals(1L, buildResult.surveyInstanceId().longValue());
    assertEquals(SurveyInstanceAction.SUBMITTING, buildResult.action());
    assertEquals(SurveyInstanceActionStatus.PENDING, buildResult.status());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, buildResult.initialState());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionQueueItem.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableSurveyInstanceActionQueueItem.Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionQueueItem.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableSurveyInstanceActionQueueItem.Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionQueueItem.Builder#initialState(SurveyInstanceStatus)}
   */
  @Test
  void testBuilderInitialState() {
    // Arrange
    ImmutableSurveyInstanceActionQueueItem.Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.initialState(SurveyInstanceStatus.NOT_STARTED));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionQueueItem.Builder#provenance(String)}
   */
  @Test
  void testBuilderProvenance() {
    // Arrange
    ImmutableSurveyInstanceActionQueueItem.Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.provenance("Provenance"));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionQueueItem.Builder#status(SurveyInstanceActionStatus)}
   */
  @Test
  void testBuilderStatus() {
    // Arrange
    ImmutableSurveyInstanceActionQueueItem.Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.status(SurveyInstanceActionStatus.PENDING));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionQueueItem.Builder#submittedAt(LocalDateTime)}
   */
  @Test
  void testBuilderSubmittedAt() {
    // Arrange
    ImmutableSurveyInstanceActionQueueItem.Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionQueueItem.Builder#submittedBy(String)}
   */
  @Test
  void testBuilderSubmittedBy() {
    // Arrange
    ImmutableSurveyInstanceActionQueueItem.Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.submittedBy("Submitted By"));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionQueueItem.Builder#surveyInstanceId(Long)}
   */
  @Test
  void testBuilderSurveyInstanceId() {
    // Arrange
    ImmutableSurveyInstanceActionQueueItem.Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyInstanceId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionQueueItem#copyOf(SurveyInstanceActionQueueItem)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyInstanceActionQueueItem instance = mock(SurveyInstanceActionQueueItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.message()).thenReturn("Not all who wander are lost");
    when(instance.status()).thenReturn(SurveyInstanceActionStatus.PENDING);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.submittedAt()).thenReturn(ofResult2.atStartOfDay());
    Optional<SurveyInstanceActionParams> ofResult3 = Optional.of(new ImmutableSurveyInstanceActionParams.Json());
    when(instance.actionParams()).thenReturn(ofResult3);
    when(instance.action()).thenReturn(SurveyInstanceAction.SUBMITTING);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.surveyInstanceId()).thenReturn(1L);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.actionedAt()).thenReturn(ofResult4.atStartOfDay());
    when(instance.initialState()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.submittedBy()).thenReturn("Submitted By");

    // Act
    ImmutableSurveyInstanceActionQueueItem actualCopyOfResult = ImmutableSurveyInstanceActionQueueItem.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).action();
    verify(instance).actionParams();
    verify(instance).actionedAt();
    verify(instance).initialState();
    verify(instance).message();
    verify(instance).provenance();
    verify(instance).status();
    verify(instance).submittedAt();
    verify(instance).submittedBy();
    verify(instance).surveyInstanceId();
    LocalDateTime actionedAtResult = actualCopyOfResult.actionedAt();
    LocalTime toLocalTimeResult = actionedAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = actionedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime submittedAtResult = actualCopyOfResult.submittedAt();
    LocalDate toLocalDateResult2 = submittedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    assertEquals("Not all who wander are lost", actualCopyOfResult.message());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("Submitted By", actualCopyOfResult.submittedBy());
    assertEquals(1L, actualCopyOfResult.surveyInstanceId().longValue());
    assertEquals(SurveyInstanceAction.SUBMITTING, actualCopyOfResult.action());
    assertEquals(SurveyInstanceActionStatus.PENDING, actualCopyOfResult.status());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualCopyOfResult.initialState());
    assertSame(toLocalTimeResult, submittedAtResult.toLocalTime());
    assertSame(ofResult4, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionQueueItem#copyOf(SurveyInstanceActionQueueItem)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    SurveyInstanceActionQueueItem instance = mock(SurveyInstanceActionQueueItem.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.message()).thenReturn("Not all who wander are lost");
    when(instance.status()).thenReturn(SurveyInstanceActionStatus.PENDING);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.submittedAt()).thenReturn(ofResult.atStartOfDay());
    Optional<SurveyInstanceActionParams> ofResult2 = Optional.of(new ImmutableSurveyInstanceActionParams.Json());
    when(instance.actionParams()).thenReturn(ofResult2);
    when(instance.action()).thenReturn(SurveyInstanceAction.SUBMITTING);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.surveyInstanceId()).thenReturn(1L);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.actionedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.initialState()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.submittedBy()).thenReturn("Submitted By");

    // Act
    ImmutableSurveyInstanceActionQueueItem actualCopyOfResult = ImmutableSurveyInstanceActionQueueItem.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).action();
    verify(instance).actionParams();
    verify(instance).actionedAt();
    verify(instance).initialState();
    verify(instance).message();
    verify(instance).provenance();
    verify(instance).status();
    verify(instance).submittedAt();
    verify(instance).submittedBy();
    verify(instance).surveyInstanceId();
    LocalDateTime actionedAtResult = actualCopyOfResult.actionedAt();
    LocalTime toLocalTimeResult = actionedAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = actionedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime submittedAtResult = actualCopyOfResult.submittedAt();
    LocalDate toLocalDateResult2 = submittedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    assertEquals("Not all who wander are lost", actualCopyOfResult.message());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("Submitted By", actualCopyOfResult.submittedBy());
    assertEquals(1L, actualCopyOfResult.surveyInstanceId().longValue());
    assertEquals(SurveyInstanceAction.SUBMITTING, actualCopyOfResult.action());
    assertEquals(SurveyInstanceActionStatus.PENDING, actualCopyOfResult.status());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualCopyOfResult.initialState());
    assertSame(toLocalTimeResult, submittedAtResult.toLocalTime());
    assertSame(ofResult3, toLocalDateResult);
    assertSame(ofResult, toLocalDateResult2);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceActionQueueItem#copyOf(SurveyInstanceActionQueueItem)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    SurveyInstanceActionQueueItem instance = mock(SurveyInstanceActionQueueItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.message()).thenReturn("Not all who wander are lost");
    when(instance.status()).thenReturn(SurveyInstanceActionStatus.PENDING);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.submittedAt()).thenReturn(ofResult2.atStartOfDay());
    Optional<SurveyInstanceActionParams> emptyResult = Optional.empty();
    when(instance.actionParams()).thenReturn(emptyResult);
    when(instance.action()).thenReturn(SurveyInstanceAction.SUBMITTING);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.surveyInstanceId()).thenReturn(1L);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.actionedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.initialState()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.submittedBy()).thenReturn("Submitted By");

    // Act
    ImmutableSurveyInstanceActionQueueItem actualCopyOfResult = ImmutableSurveyInstanceActionQueueItem.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).action();
    verify(instance).actionParams();
    verify(instance).actionedAt();
    verify(instance).initialState();
    verify(instance).message();
    verify(instance).provenance();
    verify(instance).status();
    verify(instance).submittedAt();
    verify(instance).submittedBy();
    verify(instance).surveyInstanceId();
    LocalDateTime actionedAtResult = actualCopyOfResult.actionedAt();
    LocalTime toLocalTimeResult = actionedAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = actionedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime submittedAtResult = actualCopyOfResult.submittedAt();
    LocalDate toLocalDateResult2 = submittedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    assertEquals("Not all who wander are lost", actualCopyOfResult.message());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("Submitted By", actualCopyOfResult.submittedBy());
    assertEquals(1L, actualCopyOfResult.surveyInstanceId().longValue());
    assertEquals(SurveyInstanceAction.SUBMITTING, actualCopyOfResult.action());
    assertEquals(SurveyInstanceActionStatus.PENDING, actualCopyOfResult.status());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualCopyOfResult.initialState());
    assertSame(toLocalTimeResult, submittedAtResult.toLocalTime());
    assertSame(ofResult3, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
  }
}
