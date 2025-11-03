package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceActionParams.Json;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceActionQueueItem.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceActionQueueItemDiffblueTest {
  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceActionQueueItem#builder()}
   *   <li>{@link ImmutableSurveyInstanceActionQueueItem#actionParams(SurveyInstanceActionParams)}
   *   <li>{@link ImmutableSurveyInstanceActionQueueItem#actionedAt(LocalDateTime)}
   *   <li>{@link ImmutableSurveyInstanceActionQueueItem#message(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.actionParams(SurveyInstanceActionParams)",
      "Builder Builder.actionedAt(LocalDateTime)", "ImmutableSurveyInstanceActionQueueItem Builder.build()",
      "Builder Builder.message(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableSurveyInstanceActionQueueItem.builder();
    Optional<? extends SurveyInstanceActionParams> actionParams = Optional.of(new Json());
    Builder actualActionParamsResult = actualBuilderResult.actionParams(actionParams);
    Builder actualActionParamsResult2 = actualActionParamsResult.actionParams(new Json());
    Builder actualIdResult = actualActionParamsResult2.actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay()).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    Builder actualIdResult2 = actualIdResult.id(id);

    // Assert
    assertSame(actualIdResult2, actualIdResult2.message("Not all who wander are lost"));
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
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.action(SurveyInstanceAction.SUBMITTING));
  }

  /**
   * Test Builder {@link Builder#actionParams(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#actionParams(Optional)}
   */
  @Test
  @DisplayName("Test Builder actionParams(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.actionParams(Optional)"})
  void testBuilderActionParamsWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();
    Optional<? extends SurveyInstanceActionParams> actionParams = Optional.of(new Json());

    // Act and Assert
    assertSame(builderResult, builderResult.actionParams(actionParams));
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceActionQueueItem)} with {@code SurveyInstanceActionQueueItem}.
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceActionQueueItem)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceActionQueueItem) with 'SurveyInstanceActionQueueItem'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceActionQueueItem)"})
  void testBuilderFromWithSurveyInstanceActionQueueItem() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();
    SurveyInstanceActionQueueItem instance = mock(SurveyInstanceActionQueueItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.message()).thenReturn("Not all who wander are lost");
    when(instance.status()).thenReturn(SurveyInstanceActionStatus.PENDING);
    when(instance.submittedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<SurveyInstanceActionParams> ofResult2 = Optional.of(new Json());
    when(instance.actionParams()).thenReturn(ofResult2);
    when(instance.action()).thenReturn(SurveyInstanceAction.SUBMITTING);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.surveyInstanceId()).thenReturn(1L);
    when(instance.actionedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.initialState()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.submittedBy()).thenReturn("Submitted By");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(SurveyInstanceActionQueueItem)} with {@code SurveyInstanceActionQueueItem}.
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceActionQueueItem)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceActionQueueItem) with 'SurveyInstanceActionQueueItem'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceActionQueueItem)"})
  void testBuilderFromWithSurveyInstanceActionQueueItem2() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();
    SurveyInstanceActionQueueItem instance = mock(SurveyInstanceActionQueueItem.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.message()).thenReturn("Not all who wander are lost");
    when(instance.status()).thenReturn(SurveyInstanceActionStatus.PENDING);
    when(instance.submittedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<SurveyInstanceActionParams> ofResult = Optional.of(new Json());
    when(instance.actionParams()).thenReturn(ofResult);
    when(instance.action()).thenReturn(SurveyInstanceAction.SUBMITTING);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.surveyInstanceId()).thenReturn(1L);
    when(instance.actionedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.initialState()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.submittedBy()).thenReturn("Submitted By");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(SurveyInstanceActionQueueItem)} with {@code SurveyInstanceActionQueueItem}.
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceActionQueueItem)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceActionQueueItem) with 'SurveyInstanceActionQueueItem'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceActionQueueItem)"})
  void testBuilderFromWithSurveyInstanceActionQueueItem3() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(SurveyInstanceActionQueueItem)} with {@code SurveyInstanceActionQueueItem}.
   * <ul>
   *   <li>Then builder build message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceActionQueueItem)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceActionQueueItem) with 'SurveyInstanceActionQueueItem'; then builder build message is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceActionQueueItem)"})
  void testBuilderFromWithSurveyInstanceActionQueueItem_thenBuilderBuildMessageIsNull() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();
    SurveyInstanceActionQueueItem instance = mock(SurveyInstanceActionQueueItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.message()).thenReturn(null);
    when(instance.status()).thenReturn(SurveyInstanceActionStatus.PENDING);
    when(instance.submittedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<SurveyInstanceActionParams> ofResult2 = Optional.of(new Json());
    when(instance.actionParams()).thenReturn(ofResult2);
    when(instance.action()).thenReturn(SurveyInstanceAction.SUBMITTING);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.surveyInstanceId()).thenReturn(1L);
    when(instance.actionedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.initialState()).thenReturn(SurveyInstanceStatus.NOT_STARTED);
    when(instance.submittedBy()).thenReturn("Submitted By");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(SurveyInstanceActionQueueItem)} with {@code SurveyInstanceActionQueueItem}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceActionQueueItem)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceActionQueueItem) with 'SurveyInstanceActionQueueItem'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceActionQueueItem)"})
  void testBuilderFromWithSurveyInstanceActionQueueItem_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();
    SurveyInstanceActionQueueItem instance = mock(SurveyInstanceActionQueueItem.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.message()).thenReturn("Not all who wander are lost");
    when(instance.status()).thenReturn(SurveyInstanceActionStatus.PENDING);
    when(instance.submittedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<SurveyInstanceActionParams> ofResult = Optional.of(new Json());
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
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#initialState(SurveyInstanceStatus)}.
   * <p>
   * Method under test: {@link Builder#initialState(SurveyInstanceStatus)}
   */
  @Test
  @DisplayName("Test Builder initialState(SurveyInstanceStatus)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.initialState(SurveyInstanceStatus)"})
  void testBuilderInitialState() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.initialState(SurveyInstanceStatus.NOT_STARTED));
  }

  /**
   * Test Builder {@link Builder#provenance(String)}.
   * <p>
   * Method under test: {@link Builder#provenance(String)}
   */
  @Test
  @DisplayName("Test Builder provenance(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.provenance(String)"})
  void testBuilderProvenance() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.provenance("Provenance"));
  }

  /**
   * Test Builder {@link Builder#status(SurveyInstanceActionStatus)}.
   * <p>
   * Method under test: {@link Builder#status(SurveyInstanceActionStatus)}
   */
  @Test
  @DisplayName("Test Builder status(SurveyInstanceActionStatus)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.status(SurveyInstanceActionStatus)"})
  void testBuilderStatus() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.status(SurveyInstanceActionStatus.PENDING));
  }

  /**
   * Test Builder {@link Builder#submittedAt(LocalDateTime)}.
   * <p>
   * Method under test: {@link Builder#submittedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test Builder submittedAt(LocalDateTime)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.submittedAt(LocalDateTime)"})
  void testBuilderSubmittedAt() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Test Builder {@link Builder#submittedBy(String)}.
   * <p>
   * Method under test: {@link Builder#submittedBy(String)}
   */
  @Test
  @DisplayName("Test Builder submittedBy(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.submittedBy(String)"})
  void testBuilderSubmittedBy() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.submittedBy("Submitted By"));
  }

  /**
   * Test Builder {@link Builder#surveyInstanceId(Long)}.
   * <p>
   * Method under test: {@link Builder#surveyInstanceId(Long)}
   */
  @Test
  @DisplayName("Test Builder surveyInstanceId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.surveyInstanceId(Long)"})
  void testBuilderSurveyInstanceId() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyInstanceId(1L));
  }
}
