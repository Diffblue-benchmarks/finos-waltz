package org.finos.waltz.service.allocation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.Severity;
import org.finos.waltz.model.allocation.Allocation;
import org.finos.waltz.model.allocation.ImmutableAllocation;
import org.finos.waltz.model.allocation.ImmutableMeasurablePercentageChange;
import org.finos.waltz.model.allocation.ImmutableMeasurablePercentageChange.Builder;
import org.finos.waltz.model.allocation.ImmutableMeasurableRatingPercentage;
import org.finos.waltz.model.allocation.MeasurablePercentageChange;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.changelog.ImmutableChangeLog;
import org.finos.waltz.service.allocation.AllocationUtilities.ValidationResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AllocationUtilitiesDiffblueTest {
  /**
   * Test {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}.
   *
   * <p>Method under test: {@link AllocationUtilities#validateAllocationChanges(Collection,
   * Collection)}
   */
  @Test
  @DisplayName("Test validateAllocationChanges(Collection, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationResult AllocationUtilities.validateAllocationChanges(Collection, Collection)"
  })
  void testValidateAllocationChanges() {
    // Arrange
    ArrayList<Allocation> currentAllocations = new ArrayList<>();
    currentAllocations.add(
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build());

    // Act
    ValidationResult actualValidateAllocationChangesResult =
        AllocationUtilities.validateAllocationChanges(currentAllocations, new ArrayList<>());

    // Assert
    assertEquals("", actualValidateAllocationChangesResult.message());
    assertFalse(actualValidateAllocationChangesResult.failed());
  }

  /**
   * Test {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}.
   *
   * <p>Method under test: {@link AllocationUtilities#validateAllocationChanges(Collection,
   * Collection)}
   */
  @Test
  @DisplayName("Test validateAllocationChanges(Collection, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationResult AllocationUtilities.validateAllocationChanges(Collection, Collection)"
  })
  void testValidateAllocationChanges2() {
    // Arrange
    ArrayList<Allocation> currentAllocations = new ArrayList<>();
    currentAllocations.add(
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build());
    currentAllocations.add(
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build());

    // Act
    ValidationResult actualValidateAllocationChangesResult =
        AllocationUtilities.validateAllocationChanges(currentAllocations, new ArrayList<>());

    // Assert
    assertEquals("", actualValidateAllocationChangesResult.message());
    assertFalse(actualValidateAllocationChangesResult.failed());
  }

  /**
   * Test {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}.
   *
   * <p>Method under test: {@link AllocationUtilities#validateAllocationChanges(Collection,
   * Collection)}
   */
  @Test
  @DisplayName("Test validateAllocationChanges(Collection, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationResult AllocationUtilities.validateAllocationChanges(Collection, Collection)"
  })
  void testValidateAllocationChanges3() {
    // Arrange
    ArrayList<Allocation> currentAllocations = new ArrayList<>();

    ArrayList<MeasurablePercentageChange> changes = new ArrayList<>();

    Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    changes.add(
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build());

    // Act
    ValidationResult actualValidateAllocationChangesResult =
        AllocationUtilities.validateAllocationChanges(currentAllocations, changes);

    // Assert
    assertEquals("", actualValidateAllocationChangesResult.message());
    assertFalse(actualValidateAllocationChangesResult.failed());
  }

  /**
   * Test {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}.
   *
   * <p>Method under test: {@link AllocationUtilities#validateAllocationChanges(Collection,
   * Collection)}
   */
  @Test
  @DisplayName("Test validateAllocationChanges(Collection, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationResult AllocationUtilities.validateAllocationChanges(Collection, Collection)"
  })
  void testValidateAllocationChanges4() {
    // Arrange
    ArrayList<Allocation> currentAllocations = new ArrayList<>();

    ArrayList<MeasurablePercentageChange> changes = new ArrayList<>();

    Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    changes.add(
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build());

    Builder builderResult2 = ImmutableMeasurablePercentageChange.builder();
    changes.add(
        builderResult2
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build());

    // Act
    ValidationResult actualValidateAllocationChangesResult =
        AllocationUtilities.validateAllocationChanges(currentAllocations, changes);

    // Assert
    assertEquals("", actualValidateAllocationChangesResult.message());
    assertFalse(actualValidateAllocationChangesResult.failed());
  }

  /**
   * Test {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}.
   *
   * <p>Method under test: {@link AllocationUtilities#validateAllocationChanges(Collection,
   * Collection)}
   */
  @Test
  @DisplayName("Test validateAllocationChanges(Collection, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationResult AllocationUtilities.validateAllocationChanges(Collection, Collection)"
  })
  void testValidateAllocationChanges5() {
    // Arrange
    ArrayList<Allocation> currentAllocations = new ArrayList<>();
    currentAllocations.add(
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build());

    ArrayList<MeasurablePercentageChange> changes = new ArrayList<>();

    Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    changes.add(
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build());

    // Act
    ValidationResult actualValidateAllocationChangesResult =
        AllocationUtilities.validateAllocationChanges(currentAllocations, changes);

    // Assert
    assertEquals(
        " Operations do not match up with current state",
        actualValidateAllocationChangesResult.message());
    assertTrue(actualValidateAllocationChangesResult.failed());
  }

  /**
   * Test {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}.
   *
   * <p>Method under test: {@link AllocationUtilities#validateAllocationChanges(Collection,
   * Collection)}
   */
  @Test
  @DisplayName("Test validateAllocationChanges(Collection, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationResult AllocationUtilities.validateAllocationChanges(Collection, Collection)"
  })
  void testValidateAllocationChanges6() {
    // Arrange
    ArrayList<Allocation> currentAllocations = new ArrayList<>();

    ArrayList<MeasurablePercentageChange> changes = new ArrayList<>();

    Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    changes.add(
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(-1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build());

    // Act
    ValidationResult actualValidateAllocationChangesResult =
        AllocationUtilities.validateAllocationChanges(currentAllocations, changes);

    // Assert
    assertEquals(
        " Cannot contain percentages less than 0%",
        actualValidateAllocationChangesResult.message());
    assertTrue(actualValidateAllocationChangesResult.failed());
  }

  /**
   * Test {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}.
   *
   * <p>Method under test: {@link AllocationUtilities#validateAllocationChanges(Collection,
   * Collection)}
   */
  @Test
  @DisplayName("Test validateAllocationChanges(Collection, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationResult AllocationUtilities.validateAllocationChanges(Collection, Collection)"
  })
  void testValidateAllocationChanges7() {
    // Arrange
    ArrayList<Allocation> currentAllocations = new ArrayList<>();

    ArrayList<MeasurablePercentageChange> changes = new ArrayList<>();

    Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    changes.add(
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ATTEST)
            .previousPercentage(1)
            .build());

    // Act
    ValidationResult actualValidateAllocationChangesResult =
        AllocationUtilities.validateAllocationChanges(currentAllocations, changes);

    // Assert
    assertEquals(
        " Operations do not match up with current state",
        actualValidateAllocationChangesResult.message());
    assertTrue(actualValidateAllocationChangesResult.failed());
  }

  /**
   * Test {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}.
   *
   * <p>Method under test: {@link AllocationUtilities#validateAllocationChanges(Collection,
   * Collection)}
   */
  @Test
  @DisplayName("Test validateAllocationChanges(Collection, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationResult AllocationUtilities.validateAllocationChanges(Collection, Collection)"
  })
  void testValidateAllocationChanges8() {
    // Arrange
    ArrayList<Allocation> currentAllocations = new ArrayList<>();

    ArrayList<MeasurablePercentageChange> changes = new ArrayList<>();

    Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    changes.add(
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.REMOVE)
            .previousPercentage(1)
            .build());

    // Act
    ValidationResult actualValidateAllocationChangesResult =
        AllocationUtilities.validateAllocationChanges(currentAllocations, changes);

    // Assert
    assertEquals(
        " Operations do not match up with current state",
        actualValidateAllocationChangesResult.message());
    assertTrue(actualValidateAllocationChangesResult.failed());
  }

  /**
   * Test {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}.
   *
   * <ul>
   *   <li>Then return message is {@code Total cannot exceed 100%}.
   * </ul>
   *
   * <p>Method under test: {@link AllocationUtilities#validateAllocationChanges(Collection,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test validateAllocationChanges(Collection, Collection); then return message is 'Total cannot exceed 100%'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationResult AllocationUtilities.validateAllocationChanges(Collection, Collection)"
  })
  void testValidateAllocationChanges_thenReturnMessageIsTotalCannotExceed100() {
    // Arrange
    ArrayList<Allocation> currentAllocations = new ArrayList<>();
    currentAllocations.add(
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(100)
            .provenance("Provenance")
            .schemeId(1L)
            .build());
    currentAllocations.add(
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build());

    // Act
    ValidationResult actualValidateAllocationChangesResult =
        AllocationUtilities.validateAllocationChanges(currentAllocations, new ArrayList<>());

    // Assert
    assertEquals(" Total cannot exceed 100%", actualValidateAllocationChangesResult.message());
    assertTrue(actualValidateAllocationChangesResult.failed());
  }

  /**
   * Test {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return message is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AllocationUtilities#validateAllocationChanges(Collection,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test validateAllocationChanges(Collection, Collection); when ArrayList(); then return message is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationResult AllocationUtilities.validateAllocationChanges(Collection, Collection)"
  })
  void testValidateAllocationChanges_whenArrayList_thenReturnMessageIsEmptyString() {
    // Arrange
    ArrayList<Allocation> currentAllocations = new ArrayList<>();

    // Act
    ValidationResult actualValidateAllocationChangesResult =
        AllocationUtilities.validateAllocationChanges(currentAllocations, new ArrayList<>());

    // Assert
    assertEquals("", actualValidateAllocationChangesResult.message());
    assertFalse(actualValidateAllocationChangesResult.failed());
  }

  /**
   * Test {@link AllocationUtilities#mkBasicLogEntry(EntityReference, String, String)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableChangeLog}.
   * </ul>
   *
   * <p>Method under test: {@link AllocationUtilities#mkBasicLogEntry(EntityReference, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test mkBasicLogEntry(EntityReference, String, String); then return ImmutableChangeLog")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChangeLog AllocationUtilities.mkBasicLogEntry(EntityReference, String, String)"
  })
  void testMkBasicLogEntry_thenReturnImmutableChangeLog() {
    // Arrange
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    ChangeLog actualMkBasicLogEntryResult =
        AllocationUtilities.mkBasicLogEntry(ref, "Not all who wander are lost", "42");

    // Assert
    assertTrue(actualMkBasicLogEntryResult instanceof ImmutableChangeLog);
    assertEquals("42", actualMkBasicLogEntryResult.userId());
    assertEquals("Not all who wander are lost", actualMkBasicLogEntryResult.message());
    assertEquals(Operation.UPDATE, actualMkBasicLogEntryResult.operation());
    assertEquals(Severity.INFORMATION, actualMkBasicLogEntryResult.severity());
    assertSame(ref, actualMkBasicLogEntryResult.parentReference());
  }

  /**
   * Test ValidationResult getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ValidationResult}
   *   <li>{@link ValidationResult#failed()}
   *   <li>{@link ValidationResult#message()}
   * </ul>
   */
  @Test
  @DisplayName("Test ValidationResult getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidationResult.<init>()",
    "boolean ValidationResult.failed()",
    "String ValidationResult.message()"
  })
  void testValidationResultGettersAndSetters() {
    // Arrange and Act
    ValidationResult actualValidationResult = new ValidationResult();
    boolean actualFailedResult = actualValidationResult.failed();

    // Assert
    assertEquals("", actualValidationResult.message());
    assertFalse(actualFailedResult);
  }
}
