package org.finos.waltz.model.changelog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.Severity;
import org.junit.jupiter.api.Test;

class ImmutableChangeLogDiffblueTest {
  /**
   * Method under test: {@link ImmutableChangeLog.Builder#childId(long)}
   */
  @Test
  void testBuilderChildId() {
    // Arrange
    ImmutableChangeLog.Builder builderResult = ImmutableChangeLog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.childId(1L));
  }

  /**
   * Method under test: {@link ImmutableChangeLog.Builder#childId(Optional)}
   */
  @Test
  void testBuilderChildId2() {
    // Arrange
    ImmutableChangeLog.Builder builderResult = ImmutableChangeLog.builder();
    Optional<Long> childId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.childId(childId));
  }

  /**
   * Method under test: {@link ImmutableChangeLog.Builder#from(ChangeLog)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableChangeLog.Builder builderResult = ImmutableChangeLog.builder();
    ChangeLog instance = mock(ChangeLog.class);
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.severity()).thenReturn(Severity.INFORMATION);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.childId()).thenReturn(ofResult);
    Optional<EntityKind> ofResult2 = Optional.of(EntityKind.ALL);
    when(instance.childKind()).thenReturn(ofResult2);
    when(instance.operation()).thenReturn(Operation.ADD);
    when(instance.userId()).thenReturn("42");
    when(instance.message()).thenReturn("Not all who wander are lost");
    when(instance.parentReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableChangeLog.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).childId();
    verify(instance).childKind();
    verify(instance).createdAt();
    verify(instance).message();
    verify(instance).operation();
    verify(instance).parentReference();
    verify(instance).severity();
    verify(instance).userId();
    ImmutableChangeLog buildResult = builderResult.build();
    assertEquals("42", buildResult.userId());
    assertEquals("Not all who wander are lost", buildResult.message());
    assertEquals(Operation.ADD, buildResult.operation());
    assertEquals(Severity.INFORMATION, buildResult.severity());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableChangeLog.Builder#from(ChangeLog)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableChangeLog.Builder builderResult = ImmutableChangeLog.builder();
    ChangeLog instance = mock(ChangeLog.class);
    when(instance.createdAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.severity()).thenReturn(Severity.INFORMATION);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.childId()).thenReturn(ofResult);
    Optional<EntityKind> ofResult2 = Optional.of(EntityKind.ALL);
    when(instance.childKind()).thenReturn(ofResult2);
    when(instance.operation()).thenReturn(Operation.ADD);
    when(instance.userId()).thenReturn("42");
    when(instance.message()).thenReturn("Not all who wander are lost");
    when(instance.parentReference()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).childId();
    verify(instance).childKind();
    verify(instance).createdAt();
    verify(instance).message();
    verify(instance).operation();
    verify(instance).parentReference();
    verify(instance).severity();
    verify(instance).userId();
  }

  /**
   * Method under test: {@link ImmutableChangeLog.Builder#from(ChangeLog)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableChangeLog.Builder builderResult = ImmutableChangeLog.builder();
    ChangeLog instance = mock(ChangeLog.class);
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.severity()).thenReturn(Severity.INFORMATION);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.childId()).thenReturn(emptyResult);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(instance.childKind()).thenReturn(ofResult);
    when(instance.operation()).thenReturn(Operation.ADD);
    when(instance.userId()).thenReturn("42");
    when(instance.message()).thenReturn("Not all who wander are lost");
    when(instance.parentReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableChangeLog.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).childId();
    verify(instance).childKind();
    verify(instance).createdAt();
    verify(instance).message();
    verify(instance).operation();
    verify(instance).parentReference();
    verify(instance).severity();
    verify(instance).userId();
    ImmutableChangeLog buildResult = builderResult.build();
    assertEquals("42", buildResult.userId());
    assertEquals("Not all who wander are lost", buildResult.message());
    assertEquals(Operation.ADD, buildResult.operation());
    assertEquals(Severity.INFORMATION, buildResult.severity());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableChangeLog.Builder#from(ChangeLog)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableChangeLog.Builder builderResult = ImmutableChangeLog.builder();
    ChangeLog instance = mock(ChangeLog.class);
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.severity()).thenReturn(Severity.INFORMATION);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.childId()).thenReturn(ofResult);
    Optional<EntityKind> emptyResult = Optional.empty();
    when(instance.childKind()).thenReturn(emptyResult);
    when(instance.operation()).thenReturn(Operation.ADD);
    when(instance.userId()).thenReturn("42");
    when(instance.message()).thenReturn("Not all who wander are lost");
    when(instance.parentReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableChangeLog.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).childId();
    verify(instance).childKind();
    verify(instance).createdAt();
    verify(instance).message();
    verify(instance).operation();
    verify(instance).parentReference();
    verify(instance).severity();
    verify(instance).userId();
    ImmutableChangeLog buildResult = builderResult.build();
    assertEquals("42", buildResult.userId());
    assertEquals("Not all who wander are lost", buildResult.message());
    assertEquals(Operation.ADD, buildResult.operation());
    assertEquals(Severity.INFORMATION, buildResult.severity());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableChangeLog.Builder#message(String)}
   */
  @Test
  void testBuilderMessage() {
    // Arrange
    ImmutableChangeLog.Builder builderResult = ImmutableChangeLog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.message("Not all who wander are lost"));
  }

  /**
   * Method under test: {@link ImmutableChangeLog.Builder#operation(Operation)}
   */
  @Test
  void testBuilderOperation() {
    // Arrange
    ImmutableChangeLog.Builder builderResult = ImmutableChangeLog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operation(Operation.ADD));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeLog.Builder#parentReference(EntityReference)}
   */
  @Test
  void testBuilderParentReference() {
    // Arrange
    ImmutableChangeLog.Builder builderResult = ImmutableChangeLog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentReference(mock(EntityReference.class)));
  }

  /**
   * Method under test: {@link ImmutableChangeLog.Builder#userId(String)}
   */
  @Test
  void testBuilderUserId() {
    // Arrange
    ImmutableChangeLog.Builder builderResult = ImmutableChangeLog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userId("42"));
  }

  /**
   * Method under test: {@link ImmutableChangeLog#copyOf(ChangeLog)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ChangeLog instance = mock(ChangeLog.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.severity()).thenReturn(Severity.INFORMATION);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.childId()).thenReturn(ofResult2);
    Optional<EntityKind> ofResult3 = Optional.of(EntityKind.ALL);
    when(instance.childKind()).thenReturn(ofResult3);
    when(instance.operation()).thenReturn(Operation.ADD);
    when(instance.userId()).thenReturn("42");
    when(instance.message()).thenReturn("Not all who wander are lost");
    when(instance.parentReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableChangeLog actualCopyOfResult = ImmutableChangeLog.copyOf(instance);

    // Assert
    verify(instance).childId();
    verify(instance).childKind();
    verify(instance).createdAt();
    verify(instance).message();
    verify(instance).operation();
    verify(instance).parentReference();
    verify(instance).severity();
    verify(instance).userId();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals("Not all who wander are lost", actualCopyOfResult.message());
    assertEquals(Operation.ADD, actualCopyOfResult.operation());
    assertEquals(Severity.INFORMATION, actualCopyOfResult.severity());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableChangeLog#copyOf(ChangeLog)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ChangeLog instance = mock(ChangeLog.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.severity()).thenReturn(Severity.INFORMATION);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.childId()).thenReturn(emptyResult);
    Optional<EntityKind> ofResult2 = Optional.of(EntityKind.ALL);
    when(instance.childKind()).thenReturn(ofResult2);
    when(instance.operation()).thenReturn(Operation.ADD);
    when(instance.userId()).thenReturn("42");
    when(instance.message()).thenReturn("Not all who wander are lost");
    when(instance.parentReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableChangeLog actualCopyOfResult = ImmutableChangeLog.copyOf(instance);

    // Assert
    verify(instance).childId();
    verify(instance).childKind();
    verify(instance).createdAt();
    verify(instance).message();
    verify(instance).operation();
    verify(instance).parentReference();
    verify(instance).severity();
    verify(instance).userId();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals("Not all who wander are lost", actualCopyOfResult.message());
    assertEquals(Operation.ADD, actualCopyOfResult.operation());
    assertEquals(Severity.INFORMATION, actualCopyOfResult.severity());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableChangeLog#copyOf(ChangeLog)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ChangeLog instance = mock(ChangeLog.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.severity()).thenReturn(Severity.INFORMATION);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.childId()).thenReturn(ofResult2);
    Optional<EntityKind> emptyResult = Optional.empty();
    when(instance.childKind()).thenReturn(emptyResult);
    when(instance.operation()).thenReturn(Operation.ADD);
    when(instance.userId()).thenReturn("42");
    when(instance.message()).thenReturn("Not all who wander are lost");
    when(instance.parentReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableChangeLog actualCopyOfResult = ImmutableChangeLog.copyOf(instance);

    // Assert
    verify(instance).childId();
    verify(instance).childKind();
    verify(instance).createdAt();
    verify(instance).message();
    verify(instance).operation();
    verify(instance).parentReference();
    verify(instance).severity();
    verify(instance).userId();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals("Not all who wander are lost", actualCopyOfResult.message());
    assertEquals(Operation.ADD, actualCopyOfResult.operation());
    assertEquals(Severity.INFORMATION, actualCopyOfResult.severity());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableChangeLog.Json#childId()}
   */
  @Test
  void testJsonChildId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeLog.Json()).childId());
  }

  /**
   * Method under test: {@link ImmutableChangeLog.Json#childKind()}
   */
  @Test
  void testJsonChildKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeLog.Json()).childKind());
  }

  /**
   * Method under test: {@link ImmutableChangeLog.Json#createdAt()}
   */
  @Test
  void testJsonCreatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeLog.Json()).createdAt());
  }

  /**
   * Method under test: {@link ImmutableChangeLog.Json#message()}
   */
  @Test
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeLog.Json()).message());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableChangeLog.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableChangeLog.Json actualJson = new ImmutableChangeLog.Json();

    // Assert
    assertNull(actualJson.message);
    assertNull(actualJson.userId);
    assertNull(actualJson.createdAt);
    assertNull(actualJson.parentReference);
    assertNull(actualJson.operation);
    assertNull(actualJson.severity);
    assertFalse(actualJson.childId.isPresent());
    assertFalse(actualJson.childKind.isPresent());
  }

  /**
   * Method under test: {@link ImmutableChangeLog.Json#operation()}
   */
  @Test
  void testJsonOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeLog.Json()).operation());
  }

  /**
   * Method under test: {@link ImmutableChangeLog.Json#parentReference()}
   */
  @Test
  void testJsonParentReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeLog.Json()).parentReference());
  }

  /**
   * Method under test: {@link ImmutableChangeLog.Json#severity()}
   */
  @Test
  void testJsonSeverity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeLog.Json()).severity());
  }

  /**
   * Method under test: {@link ImmutableChangeLog.Json#userId()}
   */
  @Test
  void testJsonUserId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeLog.Json()).userId());
  }
}
