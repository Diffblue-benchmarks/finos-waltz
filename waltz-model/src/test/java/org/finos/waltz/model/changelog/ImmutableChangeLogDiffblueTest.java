package org.finos.waltz.model.changelog;

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
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.Severity;
import org.finos.waltz.model.changelog.ImmutableChangeLog.Builder;
import org.finos.waltz.model.changelog.ImmutableChangeLog.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableChangeLogDiffblueTest {
  /**
   * Test {@link ImmutableChangeLog#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableChangeLog#builder()}
   *   <li>{@link ImmutableChangeLog#childKind(EntityKind)}
   *   <li>{@link ImmutableChangeLog#createdAt(LocalDateTime)}
   *   <li>{@link ImmutableChangeLog#severity(Severity)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableChangeLog Builder.build()", "Builder Builder.childKind(EntityKind)",
      "Builder Builder.createdAt(LocalDateTime)", "Builder Builder.severity(Severity)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualChildIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<Long> childId = Optional.<Long>of(1L);
    Builder actualChildIdResult2 = actualChildIdResult.childId(childId);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);
    Builder actualChildKindResult = actualChildIdResult2.childKind(childKind).childKind(EntityKind.ALL);
    Builder actualCreatedAtResult = actualChildKindResult.createdAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualCreatedAtResult, actualCreatedAtResult.severity(Severity.INFORMATION));
  }

  /**
   * Test Builder {@link Builder#childId(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#childId(long)}
   */
  @Test
  @DisplayName("Test Builder childId(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.childId(long)"})
  void testBuilderChildIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableChangeLog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.childId(1L));
  }

  /**
   * Test Builder {@link Builder#childId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#childId(Optional)}
   */
  @Test
  @DisplayName("Test Builder childId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.childId(Optional)"})
  void testBuilderChildIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableChangeLog.builder();
    Optional<Long> childId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.childId(childId));
  }

  /**
   * Test Builder {@link Builder#childKind(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#childKind(Optional)}
   */
  @Test
  @DisplayName("Test Builder childKind(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.childKind(Optional)"})
  void testBuilderChildKindWithOptional() {
    // Arrange
    Builder builderResult = ImmutableChangeLog.builder();
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    // Act and Assert
    assertSame(builderResult, builderResult.childKind(childKind));
  }

  /**
   * Test Builder {@link Builder#from(ChangeLog)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link ChangeLog} {@link ChangeLog#childId()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeLog)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeLog); given empty; when ChangeLog childId() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeLog)"})
  void testBuilderFrom_givenEmpty_whenChangeLogChildIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableChangeLog.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(ChangeLog)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link ChangeLog} {@link ChangeLog#childKind()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeLog)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeLog); given empty; when ChangeLog childKind() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeLog)"})
  void testBuilderFrom_givenEmpty_whenChangeLogChildKindReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableChangeLog.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(ChangeLog)}.
   * <ul>
   *   <li>Then builder build userId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeLog)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeLog); then builder build userId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeLog)"})
  void testBuilderFrom_thenBuilderBuildUserIdIs42() {
    // Arrange
    Builder builderResult = ImmutableChangeLog.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(ChangeLog)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeLog)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeLog); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeLog)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableChangeLog.builder();
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
   * Test Builder {@link Builder#message(String)}.
   * <p>
   * Method under test: {@link Builder#message(String)}
   */
  @Test
  @DisplayName("Test Builder message(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.message(String)"})
  void testBuilderMessage() {
    // Arrange
    Builder builderResult = ImmutableChangeLog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.message("Not all who wander are lost"));
  }

  /**
   * Test Builder {@link Builder#operation(Operation)}.
   * <p>
   * Method under test: {@link Builder#operation(Operation)}
   */
  @Test
  @DisplayName("Test Builder operation(Operation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.operation(Operation)"})
  void testBuilderOperation() {
    // Arrange
    Builder builderResult = ImmutableChangeLog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operation(Operation.ADD));
  }

  /**
   * Test Builder {@link Builder#parentReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#parentReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder parentReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parentReference(EntityReference)"})
  void testBuilderParentReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeLog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentReference(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#userId(String)}.
   * <p>
   * Method under test: {@link Builder#userId(String)}
   */
  @Test
  @DisplayName("Test Builder userId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.userId(String)"})
  void testBuilderUserId() {
    // Arrange
    Builder builderResult = ImmutableChangeLog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userId("42"));
  }

  /**
   * Test Json {@link Json#childId()}.
   * <p>
   * Method under test: {@link Json#childId()}
   */
  @Test
  @DisplayName("Test Json childId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.childId()"})
  void testJsonChildId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).childId());
  }

  /**
   * Test Json {@link Json#childKind()}.
   * <p>
   * Method under test: {@link Json#childKind()}
   */
  @Test
  @DisplayName("Test Json childKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.childKind()"})
  void testJsonChildKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).childKind());
  }

  /**
   * Test Json {@link Json#createdAt()}.
   * <p>
   * Method under test: {@link Json#createdAt()}
   */
  @Test
  @DisplayName("Test Json createdAt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime Json.createdAt()"})
  void testJsonCreatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).createdAt());
  }

  /**
   * Test Json {@link Json#message()}.
   * <p>
   * Method under test: {@link Json#message()}
   */
  @Test
  @DisplayName("Test Json message()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.message()"})
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).message());
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
   * Test Json {@link Json#operation()}.
   * <p>
   * Method under test: {@link Json#operation()}
   */
  @Test
  @DisplayName("Test Json operation()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Operation Json.operation()"})
  void testJsonOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).operation());
  }

  /**
   * Test Json {@link Json#parentReference()}.
   * <p>
   * Method under test: {@link Json#parentReference()}
   */
  @Test
  @DisplayName("Test Json parentReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.parentReference()"})
  void testJsonParentReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).parentReference());
  }

  /**
   * Test Json {@link Json#severity()}.
   * <p>
   * Method under test: {@link Json#severity()}
   */
  @Test
  @DisplayName("Test Json severity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Severity Json.severity()"})
  void testJsonSeverity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).severity());
  }

  /**
   * Test Json {@link Json#userId()}.
   * <p>
   * Method under test: {@link Json#userId()}
   */
  @Test
  @DisplayName("Test Json userId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.userId()"})
  void testJsonUserId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).userId());
  }
}
