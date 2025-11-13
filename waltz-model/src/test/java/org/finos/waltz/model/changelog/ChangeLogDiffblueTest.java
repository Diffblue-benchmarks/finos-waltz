package org.finos.waltz.model.changelog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChangeLogDiffblueTest {
  /**
   * Test {@link ChangeLog#childRef()}.
   *
   * <ul>
   *   <li>Then {@link Optional#get()} return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeLog#childRef()}
   */
  @Test
  @DisplayName("Test childRef(); then get() return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ChangeLog.childRef()"})
  void testChildRef_thenGetReturnImmutableEntityReference() {
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
    Optional<EntityReference> actualChildRefResult =
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
            .childRef();

    // Assert
    EntityReference getResult = actualChildRefResult.get();
    assertTrue(getResult instanceof ImmutableEntityReference);
    assertNull(getResult.description());
    assertEquals(1L, getResult.id());
    assertEquals(EntityKind.ALL, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertTrue(actualChildRefResult.isPresent());
  }

  /**
   * Test {@link ChangeLog#childRef()}.
   *
   * <ul>
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link ChangeLog#childRef()}
   */
  @Test
  @DisplayName("Test childRef(); then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ChangeLog.childRef()"})
  void testChildRef_thenReturnNotPresent() {
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
    assertFalse(
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
            .childRef()
            .isPresent());
  }

  /**
   * Test {@link ChangeLog#severity()}.
   *
   * <ul>
   *   <li>Then return {@code INFORMATION}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeLog#severity()}
   */
  @Test
  @DisplayName("Test severity(); then return 'INFORMATION'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Severity ChangeLog.severity()"})
  void testSeverity_thenReturnInformation() {
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
   * Test {@link ChangeLog#createdAt()}.
   *
   * <ul>
   *   <li>Then return toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeLog#createdAt()}
   */
  @Test
  @DisplayName("Test createdAt(); then return toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ChangeLog.createdAt()"})
  void testCreatedAt_thenReturnToLocalTimeToStringIs0000() {
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
}
