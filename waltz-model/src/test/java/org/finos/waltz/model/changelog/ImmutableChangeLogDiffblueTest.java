package org.finos.waltz.model.changelog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.Severity;
import org.finos.waltz.model.changelog.ImmutableChangeLog.Builder;
import org.finos.waltz.model.changelog.ImmutableChangeLog.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableChangeLogDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#childKind(EntityKind)}
   *   <li>{@link Builder#createdAt(LocalDateTime)}
   *   <li>{@link Builder#severity(Severity)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeLog Builder.build()",
    "Builder Builder.childKind(EntityKind)",
    "Builder Builder.createdAt(LocalDateTime)",
    "Builder Builder.severity(Severity)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualChildIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<Long> childId = Optional.of(1L);
    Builder actualChildIdResult2 = actualChildIdResult.childId(childId);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);
    LocalDateTime createdAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    Builder actualOperationResult =
        actualChildIdResult2
            .childKind(childKind)
            .childKind(EntityKind.ALL)
            .createdAt(createdAt)
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    ImmutableEntityReference parentReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableChangeLog actualImmutableChangeLog =
        actualOperationResult
            .parentReference(parentReference)
            .severity(Severity.INFORMATION)
            .userId("42")
            .build();

    // Assert
    assertEquals("42", actualImmutableChangeLog.userId());
    assertEquals("Not all who wander are lost", actualImmutableChangeLog.message());
    assertEquals(Operation.ADD, actualImmutableChangeLog.operation());
    assertEquals(Severity.INFORMATION, actualImmutableChangeLog.severity());
    assertSame(createdAt, actualImmutableChangeLog.createdAt());
    assertSame(parentReference, actualImmutableChangeLog.parentReference());
  }

  /**
   * Test Builder {@link Builder#childId(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#childId(long)}
   */
  @Test
  @DisplayName("Test Builder childId(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.childId(long)"})
  void testBuilderChildIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableChangeLog.builder();

    // Act
    Builder actualChildIdResult = builderResult.childId(1L);

    // Assert
    assertSame(builderResult, actualChildIdResult);
  }

  /**
   * Test Builder {@link Builder#childId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#childId(Optional)}
   */
  @Test
  @DisplayName("Test Builder childId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.childId(Optional)"})
  void testBuilderChildIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableChangeLog.builder();
    Optional<Long> childId = Optional.of(1L);

    // Act
    Builder actualChildIdResult = builderResult.childId(childId);

    // Assert
    assertSame(builderResult, actualChildIdResult);
  }

  /**
   * Test Builder {@link Builder#childKind(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#childKind(Optional)}
   */
  @Test
  @DisplayName("Test Builder childKind(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.childKind(Optional)"})
  void testBuilderChildKindWithOptional() {
    // Arrange
    Builder builderResult = ImmutableChangeLog.builder();
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    // Act
    Builder actualChildKindResult = builderResult.childKind(childKind);

    // Assert
    assertSame(builderResult, actualChildKindResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeLog)}.
   *
   * <p>Method under test: {@link Builder#from(ChangeLog)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ChangeLog)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableChangeLog.builder();

    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    ImmutableChangeLog instance =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableChangeLog actualImmutableChangeLog = builderResult.build();
    assertEquals(instance, actualImmutableChangeLog);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeLog)}.
   *
   * <p>Method under test: {@link Builder#from(ChangeLog)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ChangeLog)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableChangeLog.builder();

    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.empty();

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    ImmutableChangeLog instance =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableChangeLog actualImmutableChangeLog = builderResult.build();
    assertEquals(instance, actualImmutableChangeLog);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#message(String)}.
   *
   * <ul>
   *   <li>When {@code Not all who wander are lost}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#message(String)}
   */
  @Test
  @DisplayName(
      "Test Builder message(String); when 'Not all who wander are lost'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.message(String)"})
  void testBuilderMessage_whenNotAllWhoWanderAreLost_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeLog.builder();

    // Act
    Builder actualMessageResult = builderResult.message("Not all who wander are lost");

    // Assert
    assertSame(builderResult, actualMessageResult);
  }

  /**
   * Test Builder {@link Builder#operation(Operation)}.
   *
   * <p>Method under test: {@link Builder#operation(Operation)}
   */
  @Test
  @DisplayName("Test Builder operation(Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operation(Operation)"})
  void testBuilderOperation() {
    // Arrange
    Builder builderResult = ImmutableChangeLog.builder();

    // Act
    Builder actualOperationResult = builderResult.operation(Operation.ADD);

    // Assert
    assertSame(builderResult, actualOperationResult);
  }

  /**
   * Test Builder {@link Builder#parentReference(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#parentReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder parentReference(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parentReference(EntityReference)"})
  void testBuilderParentReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeLog.builder();

    // Act
    Builder actualParentReferenceResult =
        builderResult.parentReference(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualParentReferenceResult);
  }

  /**
   * Test Builder {@link Builder#userId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#userId(String)}
   */
  @Test
  @DisplayName("Test Builder userId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.userId(String)"})
  void testBuilderUserId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeLog.builder();

    // Act
    Builder actualUserIdResult = builderResult.userId("42");

    // Assert
    assertSame(builderResult, actualUserIdResult);
  }

  /**
   * Test {@link ImmutableChangeLog#childId()}.
   *
   * <p>Method under test: {@link ImmutableChangeLog#childId()}
   */
  @Test
  @DisplayName("Test childId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableChangeLog.childId()"})
  void testChildId() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);

    // Act
    Optional<Long> actualChildIdResult =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build()
            .childId();

    // Assert
    assertEquals(1L, actualChildIdResult.get().longValue());
    assertTrue(actualChildIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableChangeLog#childKind()}.
   *
   * <p>Method under test: {@link ImmutableChangeLog#childKind()}
   */
  @Test
  @DisplayName("Test childKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableChangeLog.childKind()"})
  void testChildKind() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);

    // Act and Assert
    assertEquals(
        childKind,
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build()
            .childKind());
  }

  /**
   * Test {@link ImmutableChangeLog#copyOf(ChangeLog)}.
   *
   * <ul>
   *   <li>Then parentReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLog#copyOf(ChangeLog)}
   */
  @Test
  @DisplayName("Test copyOf(ChangeLog); then parentReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLog ImmutableChangeLog.copyOf(ChangeLog)"})
  void testCopyOf_thenParentReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(ofResult.atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    ImmutableChangeLog instance =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build();

    // Act
    ImmutableChangeLog actualCopyOfResult = ImmutableChangeLog.copyOf(instance);

    // Assert
    EntityReference parentReferenceResult = actualCopyOfResult.parentReference();
    assertTrue(parentReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals("Not all who wander are lost", actualCopyOfResult.message());
    assertEquals(
        "The characteristics of someone or something", parentReferenceResult.description());
    assertEquals(1L, parentReferenceResult.id());
    assertEquals(EntityKind.ALL, parentReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentReferenceResult.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualCopyOfResult.operation());
    assertEquals(Severity.INFORMATION, actualCopyOfResult.severity());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableChangeLog#createdAt()}.
   *
   * <p>Method under test: {@link ImmutableChangeLog#createdAt()}
   */
  @Test
  @DisplayName("Test createdAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableChangeLog.createdAt()"})
  void testCreatedAt() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(ofResult.atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);

    // Act
    LocalDateTime actualCreatedAtResult =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build()
            .createdAt();

    // Assert
    assertEquals("00:00", actualCreatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualCreatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableChangeLog#equals(Object)}, and {@link ImmutableChangeLog#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableChangeLog#equals(Object)}
   *   <li>{@link ImmutableChangeLog#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeLog.equals(Object)",
    "int ImmutableChangeLog.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    ImmutableChangeLog immutableChangeLog =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build();

    Builder childIdResult2 = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind2 = Optional.of(EntityKind.ALL);

    Builder operationResult2 =
        childIdResult2
            .childKind(childKind2)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    ImmutableChangeLog immutableChangeLog2 =
        operationResult2
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build();

    // Act and Assert
    assertEquals(immutableChangeLog, immutableChangeLog2);
    assertEquals(immutableChangeLog.hashCode(), immutableChangeLog2.hashCode());
  }

  /**
   * Test {@link ImmutableChangeLog#equals(Object)}, and {@link ImmutableChangeLog#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableChangeLog#equals(Object)}
   *   <li>{@link ImmutableChangeLog#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeLog.equals(Object)",
    "int ImmutableChangeLog.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    ImmutableChangeLog immutableChangeLog =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build();

    // Act and Assert
    assertEquals(immutableChangeLog, immutableChangeLog);
    int expectedHashCodeResult = immutableChangeLog.hashCode();
    assertEquals(expectedHashCodeResult, immutableChangeLog.hashCode());
  }

  /**
   * Test {@link ImmutableChangeLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeLog.equals(Object)",
    "int ImmutableChangeLog.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(2L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    ImmutableChangeLog immutableChangeLog =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build();

    Builder childIdResult2 = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind2 = Optional.of(EntityKind.ALL);

    Builder operationResult2 =
        childIdResult2
            .childKind(childKind2)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);

    // Act and Assert
    assertNotEquals(
        immutableChangeLog,
        operationResult2
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableChangeLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeLog.equals(Object)",
    "int ImmutableChangeLog.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ACTOR);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    ImmutableChangeLog immutableChangeLog =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build();

    Builder childIdResult2 = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind2 = Optional.of(EntityKind.ALL);

    Builder operationResult2 =
        childIdResult2
            .childKind(childKind2)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);

    // Act and Assert
    assertNotEquals(
        immutableChangeLog,
        operationResult2
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableChangeLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeLog.equals(Object)",
    "int ImmutableChangeLog.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.now().atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    ImmutableChangeLog immutableChangeLog =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build();

    Builder childIdResult2 = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind2 = Optional.of(EntityKind.ALL);

    Builder operationResult2 =
        childIdResult2
            .childKind(childKind2)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);

    // Act and Assert
    assertNotEquals(
        immutableChangeLog,
        operationResult2
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableChangeLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeLog.equals(Object)",
    "int ImmutableChangeLog.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("42")
            .operation(Operation.ADD);
    ImmutableChangeLog immutableChangeLog =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build();

    Builder childIdResult2 = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind2 = Optional.of(EntityKind.ALL);

    Builder operationResult2 =
        childIdResult2
            .childKind(childKind2)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);

    // Act and Assert
    assertNotEquals(
        immutableChangeLog,
        operationResult2
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableChangeLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeLog.equals(Object)",
    "int ImmutableChangeLog.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ATTEST);
    ImmutableChangeLog immutableChangeLog =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build();

    Builder childIdResult2 = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind2 = Optional.of(EntityKind.ALL);

    Builder operationResult2 =
        childIdResult2
            .childKind(childKind2)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);

    // Act and Assert
    assertNotEquals(
        immutableChangeLog,
        operationResult2
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableChangeLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeLog.equals(Object)",
    "int ImmutableChangeLog.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    ImmutableChangeLog immutableChangeLog =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build();

    Builder childIdResult2 = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind2 = Optional.of(EntityKind.ALL);

    Builder operationResult2 =
        childIdResult2
            .childKind(childKind2)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);

    // Act and Assert
    assertNotEquals(
        immutableChangeLog,
        operationResult2
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableChangeLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeLog.equals(Object)",
    "int ImmutableChangeLog.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    ImmutableChangeLog immutableChangeLog =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.WARNING)
            .userId("42")
            .build();

    Builder childIdResult2 = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind2 = Optional.of(EntityKind.ALL);

    Builder operationResult2 =
        childIdResult2
            .childKind(childKind2)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);

    // Act and Assert
    assertNotEquals(
        immutableChangeLog,
        operationResult2
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableChangeLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeLog.equals(Object)",
    "int ImmutableChangeLog.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    ImmutableChangeLog immutableChangeLog =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("Not all who wander are lost")
            .build();

    Builder childIdResult2 = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind2 = Optional.of(EntityKind.ALL);

    Builder operationResult2 =
        childIdResult2
            .childKind(childKind2)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);

    // Act and Assert
    assertNotEquals(
        immutableChangeLog,
        operationResult2
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableChangeLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeLog.equals(Object)",
    "int ImmutableChangeLog.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);

    // Act and Assert
    assertNotEquals(
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableChangeLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeLog.equals(Object)",
    "int ImmutableChangeLog.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);

    // Act and Assert
    assertNotEquals(
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build(),
        "Different type to ImmutableChangeLog");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableChangeLog#message()}
   *   <li>{@link ImmutableChangeLog#operation()}
   *   <li>{@link ImmutableChangeLog#parentReference()}
   *   <li>{@link ImmutableChangeLog#userId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableChangeLog.message()",
    "Operation ImmutableChangeLog.operation()",
    "EntityReference ImmutableChangeLog.parentReference()",
    "String ImmutableChangeLog.userId()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    ImmutableChangeLog immutableChangeLog =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build();

    // Act
    String actualMessageResult = immutableChangeLog.message();
    Operation actualOperationResult = immutableChangeLog.operation();
    EntityReference actualParentReferenceResult = immutableChangeLog.parentReference();

    // Assert
    assertTrue(actualParentReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", immutableChangeLog.userId());
    assertEquals("Not all who wander are lost", actualMessageResult);
    assertEquals(Operation.ADD, actualOperationResult);
  }

  /**
   * Test Json {@link Json#childId()}.
   *
   * <p>Method under test: {@link Json#childId()}
   */
  @Test
  @DisplayName("Test Json childId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.childId()"})
  void testJsonChildId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().childId());
  }

  /**
   * Test Json {@link Json#childKind()}.
   *
   * <p>Method under test: {@link Json#childKind()}
   */
  @Test
  @DisplayName("Test Json childKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.childKind()"})
  void testJsonChildKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().childKind());
  }

  /**
   * Test Json {@link Json#createdAt()}.
   *
   * <p>Method under test: {@link Json#createdAt()}
   */
  @Test
  @DisplayName("Test Json createdAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.createdAt()"})
  void testJsonCreatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().createdAt());
  }

  /**
   * Test Json {@link Json#message()}.
   *
   * <p>Method under test: {@link Json#message()}
   */
  @Test
  @DisplayName("Test Json message()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.message()"})
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().message());
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
   *
   * <p>Method under test: {@link Json#operation()}
   */
  @Test
  @DisplayName("Test Json operation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation Json.operation()"})
  void testJsonOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().operation());
  }

  /**
   * Test Json {@link Json#parentReference()}.
   *
   * <p>Method under test: {@link Json#parentReference()}
   */
  @Test
  @DisplayName("Test Json parentReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.parentReference()"})
  void testJsonParentReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parentReference());
  }

  /**
   * Test Json {@link Json#severity()}.
   *
   * <p>Method under test: {@link Json#severity()}
   */
  @Test
  @DisplayName("Test Json severity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Severity Json.severity()"})
  void testJsonSeverity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().severity());
  }

  /**
   * Test Json {@link Json#userId()}.
   *
   * <p>Method under test: {@link Json#userId()}
   */
  @Test
  @DisplayName("Test Json userId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.userId()"})
  void testJsonUserId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().userId());
  }

  /**
   * Test {@link ImmutableChangeLog#severity()}.
   *
   * <p>Method under test: {@link ImmutableChangeLog#severity()}
   */
  @Test
  @DisplayName("Test severity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Severity ImmutableChangeLog.severity()"})
  void testSeverity() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);

    // Act and Assert
    assertEquals(
        Severity.INFORMATION,
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build()
            .severity());
  }

  /**
   * Test {@link ImmutableChangeLog#toString()}.
   *
   * <p>Method under test: {@link ImmutableChangeLog#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableChangeLog.toString()"})
  void testToString() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);

    // Act and Assert
    assertEquals(
        "ChangeLog{parentReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, message=Not"
            + " all who wander are lost, userId=42, childKind=ALL, childId=1, operation=ADD, severity=INFORMATION,"
            + " createdAt=1970-01-01T00:00}",
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableChangeLog#toString()}.
   *
   * <p>Method under test: {@link ImmutableChangeLog#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableChangeLog.toString()"})
  void testToString2() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.empty();

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);

    // Act and Assert
    assertEquals(
        "ChangeLog{parentReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, message=Not"
            + " all who wander are lost, userId=42, childId=1, operation=ADD, severity=INFORMATION, createdAt=1970"
            + "-01-01T00:00}",
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableChangeLog#withChildId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableChangeLog#withChildId(Optional)}
   */
  @Test
  @DisplayName("Test withChildId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLog ImmutableChangeLog.withChildId(Optional)"})
  void testWithChildIdWithOptional() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    ImmutableChangeLog immutableChangeLog =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableChangeLog actualWithChildIdResult = immutableChangeLog.withChildId(optional);

    // Assert
    assertSame(immutableChangeLog, actualWithChildIdResult);
  }

  /**
   * Test {@link ImmutableChangeLog#withChildId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then parentReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLog#withChildId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withChildId(Optional) with 'optional'; then parentReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLog ImmutableChangeLog.withChildId(Optional)"})
  void testWithChildIdWithOptional_thenParentReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(2L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(ofResult.atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    ImmutableChangeLog immutableChangeLog =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableChangeLog actualWithChildIdResult = immutableChangeLog.withChildId(optional);

    // Assert
    EntityReference parentReferenceResult = actualWithChildIdResult.parentReference();
    assertTrue(parentReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime createdAtResult = actualWithChildIdResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithChildIdResult.userId());
    assertEquals("Not all who wander are lost", actualWithChildIdResult.message());
    assertEquals(
        "The characteristics of someone or something", parentReferenceResult.description());
    assertEquals(1L, parentReferenceResult.id());
    assertEquals(EntityKind.ALL, parentReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentReferenceResult.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualWithChildIdResult.operation());
    assertEquals(Severity.INFORMATION, actualWithChildIdResult.severity());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableChangeLog#withChildId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableChangeLog#withChildId(long)}
   */
  @Test
  @DisplayName("Test withChildId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLog ImmutableChangeLog.withChildId(long)"})
  void testWithChildIdWithValue() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    ImmutableChangeLog immutableChangeLog =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build();

    // Act
    ImmutableChangeLog actualWithChildIdResult = immutableChangeLog.withChildId(1L);

    // Assert
    assertSame(immutableChangeLog, actualWithChildIdResult);
  }

  /**
   * Test {@link ImmutableChangeLog#withChildId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then parentReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLog#withChildId(long)}
   */
  @Test
  @DisplayName(
      "Test withChildId(long) with 'value'; then parentReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLog ImmutableChangeLog.withChildId(long)"})
  void testWithChildIdWithValue_thenParentReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(ofResult.atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);

    // Act
    ImmutableChangeLog actualWithChildIdResult =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build()
            .withChildId(42L);

    // Assert
    EntityReference parentReferenceResult = actualWithChildIdResult.parentReference();
    assertTrue(parentReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime createdAtResult = actualWithChildIdResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithChildIdResult.userId());
    assertEquals("Not all who wander are lost", actualWithChildIdResult.message());
    assertEquals(
        "The characteristics of someone or something", parentReferenceResult.description());
    assertEquals(1L, parentReferenceResult.id());
    assertEquals(EntityKind.ALL, parentReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentReferenceResult.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualWithChildIdResult.operation());
    assertEquals(Severity.INFORMATION, actualWithChildIdResult.severity());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableChangeLog#withChildKind(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableChangeLog#withChildKind(Optional)}
   */
  @Test
  @DisplayName("Test withChildKind(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLog ImmutableChangeLog.withChildKind(Optional)"})
  void testWithChildKindWithOptional() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    ImmutableChangeLog immutableChangeLog =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build();
    Optional<? extends EntityKind> optional = Optional.of(EntityKind.ALL);

    // Act
    ImmutableChangeLog actualWithChildKindResult = immutableChangeLog.withChildKind(optional);

    // Assert
    assertSame(immutableChangeLog, actualWithChildKindResult);
  }

  /**
   * Test {@link ImmutableChangeLog#withChildKind(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then parentReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLog#withChildKind(Optional)}
   */
  @Test
  @DisplayName(
      "Test withChildKind(Optional) with 'optional'; then parentReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLog ImmutableChangeLog.withChildKind(Optional)"})
  void testWithChildKindWithOptional_thenParentReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ACTOR);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(ofResult.atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    ImmutableChangeLog immutableChangeLog =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build();
    Optional<? extends EntityKind> optional = Optional.of(EntityKind.ALL);

    // Act
    ImmutableChangeLog actualWithChildKindResult = immutableChangeLog.withChildKind(optional);

    // Assert
    EntityReference parentReferenceResult = actualWithChildKindResult.parentReference();
    assertTrue(parentReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime createdAtResult = actualWithChildKindResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithChildKindResult.userId());
    assertEquals("Not all who wander are lost", actualWithChildKindResult.message());
    assertEquals(
        "The characteristics of someone or something", parentReferenceResult.description());
    assertEquals(1L, parentReferenceResult.id());
    assertEquals(EntityKind.ALL, parentReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentReferenceResult.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualWithChildKindResult.operation());
    assertEquals(Severity.INFORMATION, actualWithChildKindResult.severity());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableChangeLog#withChildKind(EntityKind)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableChangeLog#withChildKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withChildKind(EntityKind) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLog ImmutableChangeLog.withChildKind(EntityKind)"})
  void testWithChildKindWithValue() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    ImmutableChangeLog immutableChangeLog =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build();

    // Act
    ImmutableChangeLog actualWithChildKindResult = immutableChangeLog.withChildKind(EntityKind.ALL);

    // Assert
    assertSame(immutableChangeLog, actualWithChildKindResult);
  }

  /**
   * Test {@link ImmutableChangeLog#withChildKind(EntityKind)} with {@code value}.
   *
   * <ul>
   *   <li>Then parentReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLog#withChildKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withChildKind(EntityKind) with 'value'; then parentReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLog ImmutableChangeLog.withChildKind(EntityKind)"})
  void testWithChildKindWithValue_thenParentReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ACTOR);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(ofResult.atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);

    // Act
    ImmutableChangeLog actualWithChildKindResult =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build()
            .withChildKind(EntityKind.ALL);

    // Assert
    EntityReference parentReferenceResult = actualWithChildKindResult.parentReference();
    assertTrue(parentReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime createdAtResult = actualWithChildKindResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithChildKindResult.userId());
    assertEquals("Not all who wander are lost", actualWithChildKindResult.message());
    assertEquals(
        "The characteristics of someone or something", parentReferenceResult.description());
    assertEquals(1L, parentReferenceResult.id());
    assertEquals(EntityKind.ALL, parentReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentReferenceResult.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualWithChildKindResult.operation());
    assertEquals(Severity.INFORMATION, actualWithChildKindResult.severity());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableChangeLog#withCreatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableChangeLog#withCreatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withCreatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLog ImmutableChangeLog.withCreatedAt(LocalDateTime)"})
  void testWithCreatedAt() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    ImmutableChangeLog immutableChangeLog =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build();

    // Act
    ImmutableChangeLog actualWithCreatedAtResult =
        immutableChangeLog.withCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableChangeLog, actualWithCreatedAtResult);
  }

  /**
   * Test {@link ImmutableChangeLog#withMessage(String)}.
   *
   * <p>Method under test: {@link ImmutableChangeLog#withMessage(String)}
   */
  @Test
  @DisplayName("Test withMessage(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLog ImmutableChangeLog.withMessage(String)"})
  void testWithMessage() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("42")
            .operation(Operation.ADD);
    ImmutableChangeLog immutableChangeLog =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build();

    // Act
    ImmutableChangeLog actualWithMessageResult = immutableChangeLog.withMessage("42");

    // Assert
    assertSame(immutableChangeLog, actualWithMessageResult);
  }

  /**
   * Test {@link ImmutableChangeLog#withMessage(String)}.
   *
   * <ul>
   *   <li>Then parentReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLog#withMessage(String)}
   */
  @Test
  @DisplayName("Test withMessage(String); then parentReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLog ImmutableChangeLog.withMessage(String)"})
  void testWithMessage_thenParentReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(ofResult.atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);

    // Act
    ImmutableChangeLog actualWithMessageResult =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build()
            .withMessage("42");

    // Assert
    EntityReference parentReferenceResult = actualWithMessageResult.parentReference();
    assertTrue(parentReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime createdAtResult = actualWithMessageResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithMessageResult.message());
    assertEquals("42", actualWithMessageResult.userId());
    assertEquals(
        "The characteristics of someone or something", parentReferenceResult.description());
    assertEquals(1L, parentReferenceResult.id());
    assertEquals(EntityKind.ALL, parentReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentReferenceResult.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualWithMessageResult.operation());
    assertEquals(Severity.INFORMATION, actualWithMessageResult.severity());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableChangeLog#withOperation(Operation)}.
   *
   * <p>Method under test: {@link ImmutableChangeLog#withOperation(Operation)}
   */
  @Test
  @DisplayName("Test withOperation(Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLog ImmutableChangeLog.withOperation(Operation)"})
  void testWithOperation() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    ImmutableChangeLog immutableChangeLog =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build();

    // Act
    ImmutableChangeLog actualWithOperationResult = immutableChangeLog.withOperation(Operation.ADD);

    // Assert
    assertSame(immutableChangeLog, actualWithOperationResult);
  }

  /**
   * Test {@link ImmutableChangeLog#withOperation(Operation)}.
   *
   * <ul>
   *   <li>Then parentReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLog#withOperation(Operation)}
   */
  @Test
  @DisplayName(
      "Test withOperation(Operation); then parentReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLog ImmutableChangeLog.withOperation(Operation)"})
  void testWithOperation_thenParentReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(ofResult.atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ATTEST);

    // Act
    ImmutableChangeLog actualWithOperationResult =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build()
            .withOperation(Operation.ADD);

    // Assert
    EntityReference parentReferenceResult = actualWithOperationResult.parentReference();
    assertTrue(parentReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime createdAtResult = actualWithOperationResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithOperationResult.userId());
    assertEquals("Not all who wander are lost", actualWithOperationResult.message());
    assertEquals(
        "The characteristics of someone or something", parentReferenceResult.description());
    assertEquals(1L, parentReferenceResult.id());
    assertEquals(EntityKind.ALL, parentReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentReferenceResult.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualWithOperationResult.operation());
    assertEquals(Severity.INFORMATION, actualWithOperationResult.severity());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableChangeLog#withParentReference(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableChangeLog#withParentReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withParentReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLog ImmutableChangeLog.withParentReference(EntityReference)"})
  void testWithParentReference() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    ImmutableChangeLog immutableChangeLog =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build();

    // Act
    ImmutableChangeLog actualWithParentReferenceResult =
        immutableChangeLog.withParentReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableChangeLog, actualWithParentReferenceResult);
  }

  /**
   * Test {@link ImmutableChangeLog#withSeverity(Severity)}.
   *
   * <p>Method under test: {@link ImmutableChangeLog#withSeverity(Severity)}
   */
  @Test
  @DisplayName("Test withSeverity(Severity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLog ImmutableChangeLog.withSeverity(Severity)"})
  void testWithSeverity() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    ImmutableChangeLog immutableChangeLog =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build();

    // Act
    ImmutableChangeLog actualWithSeverityResult =
        immutableChangeLog.withSeverity(Severity.INFORMATION);

    // Assert
    assertSame(immutableChangeLog, actualWithSeverityResult);
  }

  /**
   * Test {@link ImmutableChangeLog#withSeverity(Severity)}.
   *
   * <ul>
   *   <li>Then parentReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLog#withSeverity(Severity)}
   */
  @Test
  @DisplayName("Test withSeverity(Severity); then parentReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLog ImmutableChangeLog.withSeverity(Severity)"})
  void testWithSeverity_thenParentReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(ofResult.atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);

    // Act
    ImmutableChangeLog actualWithSeverityResult =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.WARNING)
            .userId("42")
            .build()
            .withSeverity(Severity.INFORMATION);

    // Assert
    EntityReference parentReferenceResult = actualWithSeverityResult.parentReference();
    assertTrue(parentReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime createdAtResult = actualWithSeverityResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithSeverityResult.userId());
    assertEquals("Not all who wander are lost", actualWithSeverityResult.message());
    assertEquals(
        "The characteristics of someone or something", parentReferenceResult.description());
    assertEquals(1L, parentReferenceResult.id());
    assertEquals(EntityKind.ALL, parentReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentReferenceResult.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualWithSeverityResult.operation());
    assertEquals(Severity.INFORMATION, actualWithSeverityResult.severity());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableChangeLog#withUserId(String)}.
   *
   * <p>Method under test: {@link ImmutableChangeLog#withUserId(String)}
   */
  @Test
  @DisplayName("Test withUserId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLog ImmutableChangeLog.withUserId(String)"})
  void testWithUserId() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    ImmutableChangeLog immutableChangeLog =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build();

    // Act
    ImmutableChangeLog actualWithUserIdResult = immutableChangeLog.withUserId("42");

    // Assert
    assertSame(immutableChangeLog, actualWithUserIdResult);
  }

  /**
   * Test {@link ImmutableChangeLog#withUserId(String)}.
   *
   * <ul>
   *   <li>Then parentReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLog#withUserId(String)}
   */
  @Test
  @DisplayName("Test withUserId(String); then parentReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLog ImmutableChangeLog.withUserId(String)"})
  void testWithUserId_thenParentReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(ofResult.atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);

    // Act
    ImmutableChangeLog actualWithUserIdResult =
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("userId")
            .build()
            .withUserId("42");

    // Assert
    EntityReference parentReferenceResult = actualWithUserIdResult.parentReference();
    assertTrue(parentReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime createdAtResult = actualWithUserIdResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithUserIdResult.userId());
    assertEquals("Not all who wander are lost", actualWithUserIdResult.message());
    assertEquals(
        "The characteristics of someone or something", parentReferenceResult.description());
    assertEquals(1L, parentReferenceResult.id());
    assertEquals(EntityKind.ALL, parentReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentReferenceResult.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualWithUserIdResult.operation());
    assertEquals(Severity.INFORMATION, actualWithUserIdResult.severity());
    assertSame(ofResult, toLocalDateResult);
  }
}
