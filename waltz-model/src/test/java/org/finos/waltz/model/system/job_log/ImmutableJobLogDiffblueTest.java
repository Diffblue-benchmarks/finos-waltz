package org.finos.waltz.model.system.job_log;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.system.job_log.ImmutableJobLog.Builder;
import org.finos.waltz.model.system.job_log.ImmutableJobLog.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableJobLogDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#end(LocalDateTime)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableJobLog Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.end(LocalDateTime)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualEndResult =
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<? extends LocalDateTime> end = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    LocalDateTime start = LocalDate.of(1970, 1, 1).atStartOfDay();
    ImmutableJobLog actualImmutableJobLog =
        actualEndResult
            .end(end)
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(start)
            .status(JobStatus.SUCCESS)
            .build();

    // Assert
    assertEquals("Name", actualImmutableJobLog.name());
    assertEquals(
        "The characteristics of someone or something", actualImmutableJobLog.description());
    assertEquals(EntityKind.ALL, actualImmutableJobLog.entityKind());
    assertEquals(JobStatus.SUCCESS, actualImmutableJobLog.status());
    assertSame(start, actualImmutableJobLog.start());
  }

  /**
   * Test Builder {@link Builder#end(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#end(Optional)}
   */
  @Test
  @DisplayName("Test Builder end(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.end(Optional)"})
  void testBuilderEndWithOptional() {
    // Arrange
    Builder builderResult = ImmutableJobLog.builder();
    Optional<? extends LocalDateTime> end = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    Builder actualEndResult = builderResult.end(end);

    // Assert
    assertSame(builderResult, actualEndResult);
  }

  /**
   * Test Builder {@link Builder#entityKind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#entityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder entityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityKind(EntityKind)"})
  void testBuilderEntityKind() {
    // Arrange
    Builder builderResult = ImmutableJobLog.builder();

    // Act
    Builder actualEntityKindResult = builderResult.entityKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualEntityKindResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableJobLog.builder();
    ImmutableJobLog instance =
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build();

    // Act and Assert
    ImmutableJobLog actualImmutableJobLog =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableJobLog);
    ImmutableJobLog actualImmutableJobLog2 = builderResult.build();
    assertEquals(instance, actualImmutableJobLog2);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableJobLog.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableJobLog.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(JobLog)} with {@code JobLog}.
   *
   * <p>Method under test: {@link Builder#from(JobLog)}
   */
  @Test
  @DisplayName("Test Builder from(JobLog) with 'JobLog'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(JobLog)"})
  void testBuilderFromWithJobLog() {
    // Arrange
    Builder builderResult = ImmutableJobLog.builder();
    ImmutableJobLog instance =
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableJobLog actualImmutableJobLog = builderResult.build();
    assertEquals(instance, actualImmutableJobLog);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(JobLog)} with {@code JobLog}.
   *
   * <p>Method under test: {@link Builder#from(JobLog)}
   */
  @Test
  @DisplayName("Test Builder from(JobLog) with 'JobLog'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(JobLog)"})
  void testBuilderFromWithJobLog2() {
    // Arrange
    Builder builderResult = ImmutableJobLog.builder();
    ImmutableJobLog instance =
        ImmutableJobLog.builder()
            .description(null)
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableJobLog actualImmutableJobLog = builderResult.build();
    assertEquals(instance, actualImmutableJobLog);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider() {
    // Arrange
    Builder builderResult = ImmutableJobLog.builder();
    ImmutableJobLog instance =
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build();

    // Act and Assert
    ImmutableJobLog actualImmutableJobLog = builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableJobLog);
    ImmutableJobLog actualImmutableJobLog2 = builderResult.build();
    assertEquals(instance, actualImmutableJobLog2);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider2() {
    // Arrange
    Builder builderResult = ImmutableJobLog.builder();
    ImmutableJobLog instance =
        ImmutableJobLog.builder()
            .description(null)
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build();

    // Act and Assert
    ImmutableJobLog actualImmutableJobLog = builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableJobLog);
    ImmutableJobLog actualImmutableJobLog2 = builderResult.build();
    assertEquals(instance, actualImmutableJobLog2);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableJobLog.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableJobLog.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#start(LocalDateTime)}.
   *
   * <p>Method under test: {@link Builder#start(LocalDateTime)}
   */
  @Test
  @DisplayName("Test Builder start(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.start(LocalDateTime)"})
  void testBuilderStart() {
    // Arrange
    Builder builderResult = ImmutableJobLog.builder();

    // Act
    Builder actualStartResult = builderResult.start(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(builderResult, actualStartResult);
  }

  /**
   * Test Builder {@link Builder#status(JobStatus)}.
   *
   * <p>Method under test: {@link Builder#status(JobStatus)}
   */
  @Test
  @DisplayName("Test Builder status(JobStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.status(JobStatus)"})
  void testBuilderStatus() {
    // Arrange
    Builder builderResult = ImmutableJobLog.builder();

    // Act
    Builder actualStatusResult = builderResult.status(JobStatus.SUCCESS);

    // Assert
    assertSame(builderResult, actualStatusResult);
  }

  /**
   * Test {@link ImmutableJobLog#copyOf(JobLog)}.
   *
   * <ul>
   *   <li>Then return start toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableJobLog#copyOf(JobLog)}
   */
  @Test
  @DisplayName("Test copyOf(JobLog); then return start toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableJobLog ImmutableJobLog.copyOf(JobLog)"})
  void testCopyOf_thenReturnStartToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableJobLog instance =
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(ofResult.atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build();

    // Act
    ImmutableJobLog actualCopyOfResult = ImmutableJobLog.copyOf(instance);

    // Assert
    LocalDateTime startResult = actualCopyOfResult.start();
    assertEquals("00:00", startResult.toLocalTime().toString());
    LocalDate toLocalDateResult = startResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.entityKind());
    assertEquals(JobStatus.SUCCESS, actualCopyOfResult.status());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableJobLog#end()}.
   *
   * <p>Method under test: {@link ImmutableJobLog#end()}
   */
  @Test
  @DisplayName("Test end()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableJobLog.end()"})
  void testEnd() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    Optional<LocalDateTime> actualEndResult =
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(ofResult.atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build()
            .end();

    // Assert
    LocalDateTime getResult = actualEndResult.get();
    assertEquals("00:00", getResult.toLocalTime().toString());
    LocalDate toLocalDateResult = getResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertTrue(actualEndResult.isPresent());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableJobLog#equals(Object)}, and {@link ImmutableJobLog#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableJobLog#equals(Object)}
   *   <li>{@link ImmutableJobLog#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableJobLog.equals(Object)", "int ImmutableJobLog.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableJobLog immutableJobLog =
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build();
    ImmutableJobLog immutableJobLog2 =
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build();

    // Act and Assert
    assertEquals(immutableJobLog, immutableJobLog2);
    assertEquals(immutableJobLog.hashCode(), immutableJobLog2.hashCode());
  }

  /**
   * Test {@link ImmutableJobLog#equals(Object)}, and {@link ImmutableJobLog#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableJobLog#equals(Object)}
   *   <li>{@link ImmutableJobLog#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableJobLog.equals(Object)", "int ImmutableJobLog.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableJobLog immutableJobLog =
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build();

    // Act and Assert
    assertEquals(immutableJobLog, immutableJobLog);
    int expectedHashCodeResult = immutableJobLog.hashCode();
    assertEquals(expectedHashCodeResult, immutableJobLog.hashCode());
  }

  /**
   * Test {@link ImmutableJobLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableJobLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableJobLog.equals(Object)", "int ImmutableJobLog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableJobLog immutableJobLog =
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.now().atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableJobLog,
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build());
  }

  /**
   * Test {@link ImmutableJobLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableJobLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableJobLog.equals(Object)", "int ImmutableJobLog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableJobLog immutableJobLog =
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ACTOR)
            .name("Name")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableJobLog,
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build());
  }

  /**
   * Test {@link ImmutableJobLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableJobLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableJobLog.equals(Object)", "int ImmutableJobLog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableJobLog immutableJobLog =
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("end")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableJobLog,
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build());
  }

  /**
   * Test {@link ImmutableJobLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableJobLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableJobLog.equals(Object)", "int ImmutableJobLog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableJobLog immutableJobLog =
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(LocalDate.now().atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableJobLog,
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build());
  }

  /**
   * Test {@link ImmutableJobLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableJobLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableJobLog.equals(Object)", "int ImmutableJobLog.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableJobLog immutableJobLog =
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.FAILURE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableJobLog,
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build());
  }

  /**
   * Test {@link ImmutableJobLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableJobLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableJobLog.equals(Object)", "int ImmutableJobLog.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableJobLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableJobLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableJobLog.equals(Object)", "int ImmutableJobLog.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build(),
        "Different type to ImmutableJobLog");
  }

  /**
   * Test {@link ImmutableJobLog#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@link LocalDate} with {@code 1970} and one and one atStartOfDay.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableJobLog#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given of LocalDate with '1970' and one and one atStartOfDay")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableJobLog ImmutableJobLog.fromJson(Json)"})
  void testFromJson_givenOfLocalDateWith1970AndOneAndOneAtStartOfDay() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setDescription(null);
    json.setStatus(JobStatus.SUCCESS);
    json.setEntityKind(EntityKind.ALL);
    json.setStart(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<LocalDateTime> end = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setEnd(end);

    // Act
    ImmutableJobLog actualFromJsonResult = ImmutableJobLog.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ALL, actualFromJsonResult.entityKind());
    assertEquals(JobStatus.SUCCESS, actualFromJsonResult.status());
    LocalDateTime expectedStartResult = json.start;
    assertSame(expectedStartResult, actualFromJsonResult.start());
  }

  /**
   * Test {@link ImmutableJobLog#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code SUCCESS}.
   *   <li>When {@link Json} (default constructor) Name is {@code Json}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableJobLog#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'SUCCESS'; when Json (default constructor) Name is 'Json'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableJobLog ImmutableJobLog.fromJson(Json)"})
  void testFromJson_givenSuccess_whenJsonNameIsJson_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setDescription(null);
    json.setStatus(JobStatus.SUCCESS);
    json.setEntityKind(EntityKind.ALL);
    json.setStart(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setEnd(null);

    // Act
    ImmutableJobLog actualFromJsonResult = ImmutableJobLog.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ALL, actualFromJsonResult.entityKind());
    assertEquals(JobStatus.SUCCESS, actualFromJsonResult.status());
    LocalDateTime expectedStartResult = json.start;
    assertSame(expectedStartResult, actualFromJsonResult.start());
  }

  /**
   * Test {@link ImmutableJobLog#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return description is {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableJobLog#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return description is 'The characteristics of someone or something'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableJobLog ImmutableJobLog.fromJson(Json)"})
  void testFromJson_thenReturnDescriptionIsTheCharacteristicsOfSomeoneOrSomething() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setDescription("The characteristics of someone or something");
    json.setStatus(JobStatus.SUCCESS);
    json.setEntityKind(EntityKind.ALL);
    json.setStart(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setEnd(null);

    // Act
    ImmutableJobLog actualFromJsonResult = ImmutableJobLog.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("The characteristics of someone or something", actualFromJsonResult.description());
    assertEquals(EntityKind.ALL, actualFromJsonResult.entityKind());
    assertEquals(JobStatus.SUCCESS, actualFromJsonResult.status());
    LocalDateTime expectedStartResult = json.start;
    assertSame(expectedStartResult, actualFromJsonResult.start());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableJobLog#description()}
   *   <li>{@link ImmutableJobLog#entityKind()}
   *   <li>{@link ImmutableJobLog#name()}
   *   <li>{@link ImmutableJobLog#start()}
   *   <li>{@link ImmutableJobLog#status()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableJobLog.description()",
    "EntityKind ImmutableJobLog.entityKind()",
    "String ImmutableJobLog.name()",
    "LocalDateTime ImmutableJobLog.start()",
    "JobStatus ImmutableJobLog.status()"
  })
  void testGettersAndSetters() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableJobLog immutableJobLog =
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(ofResult.atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build();

    // Act
    String actualDescriptionResult = immutableJobLog.description();
    EntityKind actualEntityKindResult = immutableJobLog.entityKind();
    String actualNameResult = immutableJobLog.name();
    LocalDateTime actualStartResult = immutableJobLog.start();

    // Assert
    assertEquals("00:00", actualStartResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualStartResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(EntityKind.ALL, actualEntityKindResult);
    assertEquals(JobStatus.SUCCESS, immutableJobLog.status());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test Json {@link Json#description()}.
   *
   * <p>Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
  }

  /**
   * Test Json {@link Json#end()}.
   *
   * <p>Method under test: {@link Json#end()}
   */
  @Test
  @DisplayName("Test Json end()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.end()"})
  void testJsonEnd() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().end());
  }

  /**
   * Test Json {@link Json#entityKind()}.
   *
   * <p>Method under test: {@link Json#entityKind()}
   */
  @Test
  @DisplayName("Test Json entityKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.entityKind()"})
  void testJsonEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityKind());
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
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
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.start);
    assertNull(actualJson.entityKind);
    assertNull(actualJson.status);
    assertFalse(actualJson.end.isPresent());
  }

  /**
   * Test Json {@link Json#start()}.
   *
   * <p>Method under test: {@link Json#start()}
   */
  @Test
  @DisplayName("Test Json start()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.start()"})
  void testJsonStart() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().start());
  }

  /**
   * Test Json {@link Json#status()}.
   *
   * <p>Method under test: {@link Json#status()}
   */
  @Test
  @DisplayName("Test Json status()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobStatus Json.status()"})
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().status());
  }

  /**
   * Test {@link ImmutableJobLog#toString()}.
   *
   * <p>Method under test: {@link ImmutableJobLog#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableJobLog.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "JobLog{name=Name, status=SUCCESS, entityKind=ALL, start=1970-01-01T00:00, end=1970-01-01T00:00}",
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableJobLog#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableJobLog#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableJobLog ImmutableJobLog.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    ImmutableJobLog immutableJobLog =
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build();

    // Act
    ImmutableJobLog actualWithDescriptionResult = immutableJobLog.withDescription("42");

    // Assert
    assertEquals(immutableJobLog, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableJobLog#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableJobLog#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableJobLog ImmutableJobLog.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    ImmutableJobLog immutableJobLog =
        ImmutableJobLog.builder()
            .description("42")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build();

    // Act
    ImmutableJobLog actualWithDescriptionResult = immutableJobLog.withDescription("42");

    // Assert
    assertSame(immutableJobLog, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableJobLog#withEnd(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableJobLog#withEnd(Optional)}
   */
  @Test
  @DisplayName("Test withEnd(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableJobLog ImmutableJobLog.withEnd(Optional)"})
  void testWithEndWithOptional() {
    // Arrange
    ImmutableJobLog immutableJobLog =
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build();
    Optional<? extends LocalDateTime> optional =
        Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableJobLog actualWithEndResult = immutableJobLog.withEnd(optional);

    // Assert
    assertEquals(immutableJobLog, actualWithEndResult);
  }

  /**
   * Test {@link ImmutableJobLog#withEnd(LocalDateTime)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableJobLog#withEnd(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withEnd(LocalDateTime) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableJobLog ImmutableJobLog.withEnd(LocalDateTime)"})
  void testWithEndWithValue() {
    // Arrange
    ImmutableJobLog immutableJobLog =
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build();

    // Act
    ImmutableJobLog actualWithEndResult =
        immutableJobLog.withEnd(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableJobLog, actualWithEndResult);
  }

  /**
   * Test {@link ImmutableJobLog#withEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableJobLog#withEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableJobLog ImmutableJobLog.withEntityKind(EntityKind)"})
  void testWithEntityKind() {
    // Arrange
    ImmutableJobLog immutableJobLog =
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build();

    // Act
    ImmutableJobLog actualWithEntityKindResult = immutableJobLog.withEntityKind(EntityKind.ALL);

    // Assert
    assertSame(immutableJobLog, actualWithEntityKindResult);
  }

  /**
   * Test {@link ImmutableJobLog#withEntityKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return start toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableJobLog#withEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withEntityKind(EntityKind); then return start toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableJobLog ImmutableJobLog.withEntityKind(EntityKind)"})
  void testWithEntityKind_thenReturnStartToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableJobLog actualWithEntityKindResult =
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ACTOR)
            .name("Name")
            .start(ofResult.atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build()
            .withEntityKind(EntityKind.ALL);

    // Assert
    LocalDateTime startResult = actualWithEntityKindResult.start();
    assertEquals("00:00", startResult.toLocalTime().toString());
    LocalDate toLocalDateResult = startResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Name", actualWithEntityKindResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithEntityKindResult.description());
    assertEquals(EntityKind.ALL, actualWithEntityKindResult.entityKind());
    assertEquals(JobStatus.SUCCESS, actualWithEntityKindResult.status());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableJobLog#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableJobLog#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableJobLog ImmutableJobLog.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableJobLog immutableJobLog =
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("42")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build();

    // Act
    ImmutableJobLog actualWithNameResult = immutableJobLog.withName("42");

    // Assert
    assertSame(immutableJobLog, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableJobLog#withName(String)}.
   *
   * <ul>
   *   <li>Then return start toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableJobLog#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return start toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableJobLog ImmutableJobLog.withName(String)"})
  void testWithName_thenReturnStartToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableJobLog actualWithNameResult =
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(ofResult.atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build()
            .withName("42");

    // Assert
    LocalDateTime startResult = actualWithNameResult.start();
    assertEquals("00:00", startResult.toLocalTime().toString());
    LocalDate toLocalDateResult = startResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(EntityKind.ALL, actualWithNameResult.entityKind());
    assertEquals(JobStatus.SUCCESS, actualWithNameResult.status());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableJobLog#withStart(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableJobLog#withStart(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withStart(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableJobLog ImmutableJobLog.withStart(LocalDateTime)"})
  void testWithStart() {
    // Arrange
    ImmutableJobLog immutableJobLog =
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build();

    // Act
    ImmutableJobLog actualWithStartResult =
        immutableJobLog.withStart(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableJobLog, actualWithStartResult);
  }

  /**
   * Test {@link ImmutableJobLog#withStatus(JobStatus)}.
   *
   * <p>Method under test: {@link ImmutableJobLog#withStatus(JobStatus)}
   */
  @Test
  @DisplayName("Test withStatus(JobStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableJobLog ImmutableJobLog.withStatus(JobStatus)"})
  void testWithStatus() {
    // Arrange
    ImmutableJobLog immutableJobLog =
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(LocalDate.of(1970, 1, 1).atStartOfDay())
            .status(JobStatus.SUCCESS)
            .build();

    // Act
    ImmutableJobLog actualWithStatusResult = immutableJobLog.withStatus(JobStatus.SUCCESS);

    // Assert
    assertSame(immutableJobLog, actualWithStatusResult);
  }

  /**
   * Test {@link ImmutableJobLog#withStatus(JobStatus)}.
   *
   * <ul>
   *   <li>Then return start toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableJobLog#withStatus(JobStatus)}
   */
  @Test
  @DisplayName("Test withStatus(JobStatus); then return start toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableJobLog ImmutableJobLog.withStatus(JobStatus)"})
  void testWithStatus_thenReturnStartToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableJobLog actualWithStatusResult =
        ImmutableJobLog.builder()
            .description("The characteristics of someone or something")
            .end(LocalDate.of(1970, 1, 1).atStartOfDay())
            .entityKind(EntityKind.ALL)
            .name("Name")
            .start(ofResult.atStartOfDay())
            .status(JobStatus.FAILURE)
            .build()
            .withStatus(JobStatus.SUCCESS);

    // Assert
    LocalDateTime startResult = actualWithStatusResult.start();
    assertEquals("00:00", startResult.toLocalTime().toString());
    LocalDate toLocalDateResult = startResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Name", actualWithStatusResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithStatusResult.description());
    assertEquals(EntityKind.ALL, actualWithStatusResult.entityKind());
    assertEquals(JobStatus.SUCCESS, actualWithStatusResult.status());
    assertSame(ofResult, toLocalDateResult);
  }
}
