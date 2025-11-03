package org.finos.waltz.service.allocation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.Severity;
import org.finos.waltz.model.allocation.Allocation;
import org.finos.waltz.model.allocation.MeasurablePercentageChange;
import org.finos.waltz.model.allocation.MeasurableRatingPercentage;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.changelog.ImmutableChangeLog;
import org.finos.waltz.service.allocation.AllocationUtilities.ValidationResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AllocationUtilitiesDiffblueTest {
  /**
   * Test {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}.
   * <p>
   * Method under test: {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}
   */
  @Test
  @DisplayName("Test validateAllocationChanges(Collection, Collection)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult AllocationUtilities.validateAllocationChanges(Collection, Collection)"})
  void testValidateAllocationChanges() {
    // Arrange
    Allocation allocation = mock(Allocation.class);
    when(allocation.measurableRatingId()).thenReturn(1L);
    Allocation allocation2 = mock(Allocation.class);
    when(allocation2.measurableRatingId()).thenReturn(1L);

    ArrayList<Allocation> currentAllocations = new ArrayList<>();
    currentAllocations.add(allocation2);
    currentAllocations.add(allocation);
    MeasurableRatingPercentage measurableRatingPercentage = mock(MeasurableRatingPercentage.class);
    when(measurableRatingPercentage.percentage()).thenReturn(1);
    when(measurableRatingPercentage.measurableRatingId()).thenReturn(1L);
    MeasurablePercentageChange measurablePercentageChange = mock(MeasurablePercentageChange.class);
    when(measurablePercentageChange.measurablePercentage()).thenReturn(measurableRatingPercentage);
    MeasurableRatingPercentage measurableRatingPercentage2 = mock(MeasurableRatingPercentage.class);
    when(measurableRatingPercentage2.percentage()).thenReturn(1);
    when(measurableRatingPercentage2.measurableRatingId()).thenReturn(1L);
    MeasurablePercentageChange measurablePercentageChange2 = mock(MeasurablePercentageChange.class);
    when(measurablePercentageChange2.operation()).thenReturn(Operation.ADD);
    when(measurablePercentageChange2.measurablePercentage()).thenReturn(measurableRatingPercentage2);

    ArrayList<MeasurablePercentageChange> changes = new ArrayList<>();
    changes.add(measurablePercentageChange2);
    changes.add(measurablePercentageChange);

    // Act
    ValidationResult actualValidateAllocationChangesResult = AllocationUtilities
        .validateAllocationChanges(currentAllocations, changes);

    // Assert
    verify(allocation2, atLeast(1)).measurableRatingId();
    verify(allocation, atLeast(1)).measurableRatingId();
    verify(measurablePercentageChange, atLeast(1)).measurablePercentage();
    verify(measurablePercentageChange2, atLeast(1)).measurablePercentage();
    verify(measurablePercentageChange2).operation();
    verify(measurableRatingPercentage).measurableRatingId();
    verify(measurableRatingPercentage2, atLeast(1)).measurableRatingId();
    verify(measurableRatingPercentage2, atLeast(1)).percentage();
    verify(measurableRatingPercentage, atLeast(1)).percentage();
    assertEquals(" Operations do not match up with current state", actualValidateAllocationChangesResult.message());
    assertTrue(actualValidateAllocationChangesResult.failed());
  }

  /**
   * Test {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}.
   * <p>
   * Method under test: {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}
   */
  @Test
  @DisplayName("Test validateAllocationChanges(Collection, Collection)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult AllocationUtilities.validateAllocationChanges(Collection, Collection)"})
  void testValidateAllocationChanges2() {
    // Arrange
    Allocation allocation = mock(Allocation.class);
    when(allocation.measurableRatingId()).thenReturn(1L);
    Allocation allocation2 = mock(Allocation.class);
    when(allocation2.measurableRatingId()).thenReturn(1L);

    ArrayList<Allocation> currentAllocations = new ArrayList<>();
    currentAllocations.add(allocation2);
    currentAllocations.add(allocation);
    MeasurableRatingPercentage measurableRatingPercentage = mock(MeasurableRatingPercentage.class);
    when(measurableRatingPercentage.percentage()).thenReturn(1);
    when(measurableRatingPercentage.measurableRatingId()).thenReturn(1L);
    MeasurablePercentageChange measurablePercentageChange = mock(MeasurablePercentageChange.class);
    when(measurablePercentageChange.measurablePercentage()).thenReturn(measurableRatingPercentage);
    MeasurableRatingPercentage measurableRatingPercentage2 = mock(MeasurableRatingPercentage.class);
    when(measurableRatingPercentage2.percentage()).thenReturn(1);
    when(measurableRatingPercentage2.measurableRatingId()).thenReturn(1L);
    MeasurablePercentageChange measurablePercentageChange2 = mock(MeasurablePercentageChange.class);
    when(measurablePercentageChange2.operation()).thenReturn(Operation.ATTEST);
    when(measurablePercentageChange2.measurablePercentage()).thenReturn(measurableRatingPercentage2);

    ArrayList<MeasurablePercentageChange> changes = new ArrayList<>();
    changes.add(measurablePercentageChange2);
    changes.add(measurablePercentageChange);

    // Act
    ValidationResult actualValidateAllocationChangesResult = AllocationUtilities
        .validateAllocationChanges(currentAllocations, changes);

    // Assert
    verify(allocation2, atLeast(1)).measurableRatingId();
    verify(allocation, atLeast(1)).measurableRatingId();
    verify(measurablePercentageChange, atLeast(1)).measurablePercentage();
    verify(measurablePercentageChange2, atLeast(1)).measurablePercentage();
    verify(measurablePercentageChange2).operation();
    verify(measurableRatingPercentage).measurableRatingId();
    verify(measurableRatingPercentage2, atLeast(1)).measurableRatingId();
    verify(measurableRatingPercentage2, atLeast(1)).percentage();
    verify(measurableRatingPercentage, atLeast(1)).percentage();
    assertEquals(" Operations do not match up with current state", actualValidateAllocationChangesResult.message());
    assertTrue(actualValidateAllocationChangesResult.failed());
  }

  /**
   * Test {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}.
   * <p>
   * Method under test: {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}
   */
  @Test
  @DisplayName("Test validateAllocationChanges(Collection, Collection)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult AllocationUtilities.validateAllocationChanges(Collection, Collection)"})
  void testValidateAllocationChanges3() {
    // Arrange
    Allocation allocation = mock(Allocation.class);
    when(allocation.measurableRatingId()).thenReturn(1L);
    Allocation allocation2 = mock(Allocation.class);
    when(allocation2.measurableRatingId()).thenReturn(1L);

    ArrayList<Allocation> currentAllocations = new ArrayList<>();
    currentAllocations.add(allocation2);
    currentAllocations.add(allocation);
    MeasurableRatingPercentage measurableRatingPercentage = mock(MeasurableRatingPercentage.class);
    when(measurableRatingPercentage.percentage()).thenReturn(1);
    when(measurableRatingPercentage.measurableRatingId()).thenReturn(1L);
    MeasurablePercentageChange measurablePercentageChange = mock(MeasurablePercentageChange.class);
    when(measurablePercentageChange.operation()).thenReturn(Operation.ADD);
    when(measurablePercentageChange.measurablePercentage()).thenReturn(measurableRatingPercentage);
    MeasurableRatingPercentage measurableRatingPercentage2 = mock(MeasurableRatingPercentage.class);
    when(measurableRatingPercentage2.percentage()).thenReturn(1);
    when(measurableRatingPercentage2.measurableRatingId()).thenReturn(1L);
    MeasurablePercentageChange measurablePercentageChange2 = mock(MeasurablePercentageChange.class);
    when(measurablePercentageChange2.operation()).thenReturn(Operation.REMOVE);
    when(measurablePercentageChange2.measurablePercentage()).thenReturn(measurableRatingPercentage2);

    ArrayList<MeasurablePercentageChange> changes = new ArrayList<>();
    changes.add(measurablePercentageChange2);
    changes.add(measurablePercentageChange);

    // Act
    ValidationResult actualValidateAllocationChangesResult = AllocationUtilities
        .validateAllocationChanges(currentAllocations, changes);

    // Assert
    verify(allocation2, atLeast(1)).measurableRatingId();
    verify(allocation, atLeast(1)).measurableRatingId();
    verify(measurablePercentageChange2, atLeast(1)).measurablePercentage();
    verify(measurablePercentageChange, atLeast(1)).measurablePercentage();
    verify(measurablePercentageChange2).operation();
    verify(measurablePercentageChange).operation();
    verify(measurableRatingPercentage2, atLeast(1)).measurableRatingId();
    verify(measurableRatingPercentage, atLeast(1)).measurableRatingId();
    verify(measurableRatingPercentage2, atLeast(1)).percentage();
    verify(measurableRatingPercentage, atLeast(1)).percentage();
    assertEquals(" Operations do not match up with current state", actualValidateAllocationChangesResult.message());
    assertTrue(actualValidateAllocationChangesResult.failed());
  }

  /**
   * Test {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}.
   * <p>
   * Method under test: {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}
   */
  @Test
  @DisplayName("Test validateAllocationChanges(Collection, Collection)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult AllocationUtilities.validateAllocationChanges(Collection, Collection)"})
  void testValidateAllocationChanges4() {
    // Arrange
    Allocation allocation = mock(Allocation.class);
    when(allocation.measurableRatingId()).thenReturn(1L);
    Allocation allocation2 = mock(Allocation.class);
    when(allocation2.measurableRatingId()).thenReturn(1L);

    ArrayList<Allocation> currentAllocations = new ArrayList<>();
    currentAllocations.add(allocation2);
    currentAllocations.add(allocation);
    MeasurableRatingPercentage measurableRatingPercentage = mock(MeasurableRatingPercentage.class);
    when(measurableRatingPercentage.percentage()).thenReturn(1);
    when(measurableRatingPercentage.measurableRatingId()).thenReturn(1L);
    MeasurablePercentageChange measurablePercentageChange = mock(MeasurablePercentageChange.class);
    when(measurablePercentageChange.operation()).thenReturn(Operation.ADD);
    when(measurablePercentageChange.measurablePercentage()).thenReturn(measurableRatingPercentage);
    MeasurableRatingPercentage measurableRatingPercentage2 = mock(MeasurableRatingPercentage.class);
    when(measurableRatingPercentage2.percentage()).thenReturn(-1);
    when(measurableRatingPercentage2.measurableRatingId()).thenReturn(1L);
    MeasurablePercentageChange measurablePercentageChange2 = mock(MeasurablePercentageChange.class);
    when(measurablePercentageChange2.operation()).thenReturn(Operation.REMOVE);
    when(measurablePercentageChange2.measurablePercentage()).thenReturn(measurableRatingPercentage2);

    ArrayList<MeasurablePercentageChange> changes = new ArrayList<>();
    changes.add(measurablePercentageChange2);
    changes.add(measurablePercentageChange);

    // Act
    ValidationResult actualValidateAllocationChangesResult = AllocationUtilities
        .validateAllocationChanges(currentAllocations, changes);

    // Assert
    verify(allocation2, atLeast(1)).measurableRatingId();
    verify(allocation, atLeast(1)).measurableRatingId();
    verify(measurablePercentageChange, atLeast(1)).measurablePercentage();
    verify(measurablePercentageChange2, atLeast(1)).measurablePercentage();
    verify(measurablePercentageChange2).operation();
    verify(measurablePercentageChange).operation();
    verify(measurableRatingPercentage2, atLeast(1)).measurableRatingId();
    verify(measurableRatingPercentage, atLeast(1)).measurableRatingId();
    verify(measurableRatingPercentage).percentage();
    verify(measurableRatingPercentage2, atLeast(1)).percentage();
    assertEquals(" Cannot contain percentages less than 0% Operations do not match up with current state",
        actualValidateAllocationChangesResult.message());
    assertTrue(actualValidateAllocationChangesResult.failed());
  }

  /**
   * Test {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}.
   * <p>
   * Method under test: {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}
   */
  @Test
  @DisplayName("Test validateAllocationChanges(Collection, Collection)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult AllocationUtilities.validateAllocationChanges(Collection, Collection)"})
  void testValidateAllocationChanges5() {
    // Arrange
    Allocation allocation = mock(Allocation.class);
    when(allocation.measurableRatingId()).thenReturn(1L);
    Allocation allocation2 = mock(Allocation.class);
    when(allocation2.measurableRatingId()).thenReturn(1L);

    ArrayList<Allocation> currentAllocations = new ArrayList<>();
    currentAllocations.add(allocation2);
    currentAllocations.add(allocation);
    MeasurableRatingPercentage measurableRatingPercentage = mock(MeasurableRatingPercentage.class);
    when(measurableRatingPercentage.percentage()).thenReturn(1);
    when(measurableRatingPercentage.measurableRatingId()).thenReturn(0L);
    MeasurablePercentageChange measurablePercentageChange = mock(MeasurablePercentageChange.class);
    when(measurablePercentageChange.operation()).thenReturn(Operation.ADD);
    when(measurablePercentageChange.measurablePercentage()).thenReturn(measurableRatingPercentage);
    MeasurableRatingPercentage measurableRatingPercentage2 = mock(MeasurableRatingPercentage.class);
    when(measurableRatingPercentage2.percentage()).thenReturn(1);
    when(measurableRatingPercentage2.measurableRatingId()).thenReturn(1L);
    MeasurablePercentageChange measurablePercentageChange2 = mock(MeasurablePercentageChange.class);
    when(measurablePercentageChange2.operation()).thenReturn(Operation.REMOVE);
    when(measurablePercentageChange2.measurablePercentage()).thenReturn(measurableRatingPercentage2);

    ArrayList<MeasurablePercentageChange> changes = new ArrayList<>();
    changes.add(measurablePercentageChange2);
    changes.add(measurablePercentageChange);

    // Act
    ValidationResult actualValidateAllocationChangesResult = AllocationUtilities
        .validateAllocationChanges(currentAllocations, changes);

    // Assert
    verify(allocation2, atLeast(1)).measurableRatingId();
    verify(allocation, atLeast(1)).measurableRatingId();
    verify(measurablePercentageChange2, atLeast(1)).measurablePercentage();
    verify(measurablePercentageChange, atLeast(1)).measurablePercentage();
    verify(measurablePercentageChange2).operation();
    verify(measurablePercentageChange).operation();
    verify(measurableRatingPercentage2, atLeast(1)).measurableRatingId();
    verify(measurableRatingPercentage, atLeast(1)).measurableRatingId();
    verify(measurableRatingPercentage2, atLeast(1)).percentage();
    verify(measurableRatingPercentage, atLeast(1)).percentage();
    assertEquals("", actualValidateAllocationChangesResult.message());
    assertFalse(actualValidateAllocationChangesResult.failed());
  }

  /**
   * Test {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}.
   * <ul>
   *   <li>Then return message is {@code Total cannot exceed 100%}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}
   */
  @Test
  @DisplayName("Test validateAllocationChanges(Collection, Collection); then return message is 'Total cannot exceed 100%'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult AllocationUtilities.validateAllocationChanges(Collection, Collection)"})
  void testValidateAllocationChanges_thenReturnMessageIsTotalCannotExceed100() {
    // Arrange
    Allocation allocation = mock(Allocation.class);
    when(allocation.percentage()).thenReturn(1);
    when(allocation.measurableRatingId()).thenReturn(1L);
    Allocation allocation2 = mock(Allocation.class);
    when(allocation2.percentage()).thenReturn(100);
    when(allocation2.measurableRatingId()).thenReturn(1L);

    ArrayList<Allocation> currentAllocations = new ArrayList<>();
    currentAllocations.add(allocation2);
    currentAllocations.add(allocation);

    // Act
    ValidationResult actualValidateAllocationChangesResult = AllocationUtilities
        .validateAllocationChanges(currentAllocations, new ArrayList<>());

    // Assert
    verify(allocation2, atLeast(1)).measurableRatingId();
    verify(allocation, atLeast(1)).measurableRatingId();
    verify(allocation2).percentage();
    verify(allocation).percentage();
    assertEquals(" Total cannot exceed 100%", actualValidateAllocationChangesResult.message());
    assertTrue(actualValidateAllocationChangesResult.failed());
  }

  /**
   * Test {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link Allocation#percentage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}
   */
  @Test
  @DisplayName("Test validateAllocationChanges(Collection, Collection); when ArrayList(); then calls percentage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult AllocationUtilities.validateAllocationChanges(Collection, Collection)"})
  void testValidateAllocationChanges_whenArrayList_thenCallsPercentage() {
    // Arrange
    Allocation allocation = mock(Allocation.class);
    when(allocation.percentage()).thenReturn(1);
    when(allocation.measurableRatingId()).thenReturn(1L);

    ArrayList<Allocation> currentAllocations = new ArrayList<>();
    currentAllocations.add(allocation);

    // Act
    ValidationResult actualValidateAllocationChangesResult = AllocationUtilities
        .validateAllocationChanges(currentAllocations, new ArrayList<>());

    // Assert
    verify(allocation, atLeast(1)).measurableRatingId();
    verify(allocation).percentage();
    assertEquals("", actualValidateAllocationChangesResult.message());
    assertFalse(actualValidateAllocationChangesResult.failed());
  }

  /**
   * Test {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link Allocation#percentage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}
   */
  @Test
  @DisplayName("Test validateAllocationChanges(Collection, Collection); when ArrayList(); then calls percentage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult AllocationUtilities.validateAllocationChanges(Collection, Collection)"})
  void testValidateAllocationChanges_whenArrayList_thenCallsPercentage2() {
    // Arrange
    Allocation allocation = mock(Allocation.class);
    when(allocation.percentage()).thenReturn(1);
    when(allocation.measurableRatingId()).thenReturn(1L);
    Allocation allocation2 = mock(Allocation.class);
    when(allocation2.percentage()).thenReturn(1);
    when(allocation2.measurableRatingId()).thenReturn(1L);

    ArrayList<Allocation> currentAllocations = new ArrayList<>();
    currentAllocations.add(allocation2);
    currentAllocations.add(allocation);

    // Act
    ValidationResult actualValidateAllocationChangesResult = AllocationUtilities
        .validateAllocationChanges(currentAllocations, new ArrayList<>());

    // Assert
    verify(allocation2, atLeast(1)).measurableRatingId();
    verify(allocation, atLeast(1)).measurableRatingId();
    verify(allocation2).percentage();
    verify(allocation).percentage();
    assertEquals("", actualValidateAllocationChangesResult.message());
    assertFalse(actualValidateAllocationChangesResult.failed());
  }

  /**
   * Test {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return message is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AllocationUtilities#validateAllocationChanges(Collection, Collection)}
   */
  @Test
  @DisplayName("Test validateAllocationChanges(Collection, Collection); when ArrayList(); then return message is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult AllocationUtilities.validateAllocationChanges(Collection, Collection)"})
  void testValidateAllocationChanges_whenArrayList_thenReturnMessageIsEmptyString() {
    // Arrange
    ArrayList<Allocation> currentAllocations = new ArrayList<>();

    // Act
    ValidationResult actualValidateAllocationChangesResult = AllocationUtilities
        .validateAllocationChanges(currentAllocations, new ArrayList<>());

    // Assert
    assertEquals("", actualValidateAllocationChangesResult.message());
    assertFalse(actualValidateAllocationChangesResult.failed());
  }

  /**
   * Test {@link AllocationUtilities#mkBasicLogEntry(EntityReference, String, String)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return {@link ImmutableChangeLog}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AllocationUtilities#mkBasicLogEntry(EntityReference, String, String)}
   */
  @Test
  @DisplayName("Test mkBasicLogEntry(EntityReference, String, String); when EntityReference; then return ImmutableChangeLog")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ChangeLog AllocationUtilities.mkBasicLogEntry(EntityReference, String, String)"})
  void testMkBasicLogEntry_whenEntityReference_thenReturnImmutableChangeLog() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);

    // Act
    ChangeLog actualMkBasicLogEntryResult = AllocationUtilities.mkBasicLogEntry(ref, "Not all who wander are lost",
        "42");

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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ValidationResult}
   *   <li>{@link ValidationResult#failed()}
   *   <li>{@link ValidationResult#message()}
   * </ul>
   */
  @Test
  @DisplayName("Test ValidationResult getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ValidationResult.<init>()", "boolean ValidationResult.failed()",
      "String ValidationResult.message()"})
  void testValidationResultGettersAndSetters() {
    // Arrange and Act
    ValidationResult actualValidationResult = new ValidationResult();
    boolean actualFailedResult = actualValidationResult.failed();

    // Assert
    assertEquals("", actualValidationResult.message());
    assertFalse(actualFailedResult);
  }
}
