package org.finos.waltz.service.allocation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.common.exception.InsufficientPrivelegeException;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.allocation.AllocationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.allocation.Allocation;
import org.finos.waltz.model.allocation.ImmutableAllocation;
import org.finos.waltz.model.allocation.ImmutableMeasurablePercentageChange;
import org.finos.waltz.model.allocation.ImmutableMeasurablePercentageChange.Builder;
import org.finos.waltz.model.allocation.ImmutableMeasurableRatingPercentage;
import org.finos.waltz.model.allocation.MeasurablePercentageChange;
import org.finos.waltz.model.allocation_scheme.ImmutableAllocationScheme;
import org.finos.waltz.service.allocation_schemes.AllocationSchemeService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.measurable_rating.MeasurableRatingService;
import org.finos.waltz.service.permission.permission_checker.AllocationPermissionChecker;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AllocationServiceDiffblueTest {
  @Mock private AllocationDao allocationDao;

  @Mock private AllocationPermissionChecker allocationPermissionChecker;

  @Mock private AllocationSchemeService allocationSchemeService;

  @InjectMocks private AllocationService allocationService;

  @Mock private ChangeLogService changeLogService;

  @Mock private EntityReferenceNameResolver entityReferenceNameResolver;

  @Mock private MeasurableRatingService measurableRatingService;

  /**
   * Test {@link AllocationService#findByEntity(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link AllocationDao} {@link AllocationDao#findByEntity(EntityReference)} return
   *       {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link AllocationService#findByEntity(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findByEntity(EntityReference); given AllocationDao findByEntity(EntityReference) return ArrayList(); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection AllocationService.findByEntity(EntityReference)"})
  void testFindByEntity_givenAllocationDaoFindByEntityReturnArrayList_thenReturnList() {
    // Arrange
    ArrayList<Allocation> allocationList = new ArrayList<>();
    when(allocationDao.findByEntity(Mockito.<EntityReference>any())).thenReturn(allocationList);

    // Act
    Collection<Allocation> actualFindByEntityResult = allocationService.findByEntity(null);

    // Assert
    verify(allocationDao).findByEntity(isNull());
    assertTrue(actualFindByEntityResult instanceof List);
    assertTrue(actualFindByEntityResult.isEmpty());
    assertSame(allocationList, actualFindByEntityResult);
  }

  /**
   * Test {@link AllocationService#findByEntity(EntityReference)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AllocationService#findByEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntity(EntityReference); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection AllocationService.findByEntity(EntityReference)"})
  void testFindByEntity_thenThrowIllegalArgumentException() {
    // Arrange
    when(allocationDao.findByEntity(Mockito.<EntityReference>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> allocationService.findByEntity(null));
    verify(allocationDao).findByEntity(isNull());
  }

  /**
   * Test {@link AllocationService#findForCategoryAndSubjectIdSelector(Select, long)}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link AllocationService#findForCategoryAndSubjectIdSelector(Select,
   * long)}
   */
  @Test
  @DisplayName("Test findForCategoryAndSubjectIdSelector(Select, long); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection AllocationService.findForCategoryAndSubjectIdSelector(Select, long)"
  })
  void testFindForCategoryAndSubjectIdSelector_thenReturnList() {
    // Arrange
    ArrayList<Allocation> allocationList = new ArrayList<>();
    when(allocationDao.findForCategoryAndSubjectIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(allocationList);

    // Act
    Collection<Allocation> actualFindForCategoryAndSubjectIdSelectorResult =
        allocationService.findForCategoryAndSubjectIdSelector(mock(Select.class), 1L);

    // Assert
    verify(allocationDao).findForCategoryAndSubjectIdSelector(isA(Select.class), eq(1L));
    assertTrue(actualFindForCategoryAndSubjectIdSelectorResult instanceof List);
    assertTrue(actualFindForCategoryAndSubjectIdSelectorResult.isEmpty());
    assertSame(allocationList, actualFindForCategoryAndSubjectIdSelectorResult);
  }

  /**
   * Test {@link AllocationService#findForCategoryAndSubjectIdSelector(Select, long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AllocationService#findForCategoryAndSubjectIdSelector(Select,
   * long)}
   */
  @Test
  @DisplayName(
      "Test findForCategoryAndSubjectIdSelector(Select, long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection AllocationService.findForCategoryAndSubjectIdSelector(Select, long)"
  })
  void testFindForCategoryAndSubjectIdSelector_thenThrowIllegalArgumentException() {
    // Arrange
    when(allocationDao.findForCategoryAndSubjectIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> allocationService.findForCategoryAndSubjectIdSelector(mock(Select.class), 1L));
    verify(allocationDao).findForCategoryAndSubjectIdSelector(isA(Select.class), eq(1L));
  }

  /**
   * Test {@link AllocationService#findForCategoryAndMeasurableRatingIdSelector(Select, long)}.
   *
   * <p>Method under test: {@link
   * AllocationService#findForCategoryAndMeasurableRatingIdSelector(Select, long)}
   */
  @Test
  @DisplayName("Test findForCategoryAndMeasurableRatingIdSelector(Select, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AllocationService.findForCategoryAndMeasurableRatingIdSelector(Select, long)"
  })
  void testFindForCategoryAndMeasurableRatingIdSelector() {
    // Arrange
    when(allocationDao.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            allocationService.findForCategoryAndMeasurableRatingIdSelector(mock(Select.class), 1L));
    verify(allocationDao).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
  }

  /**
   * Test {@link AllocationService#findForCategoryAndMeasurableRatingIdSelector(Select, long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * AllocationService#findForCategoryAndMeasurableRatingIdSelector(Select, long)}
   */
  @Test
  @DisplayName("Test findForCategoryAndMeasurableRatingIdSelector(Select, long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AllocationService.findForCategoryAndMeasurableRatingIdSelector(Select, long)"
  })
  void testFindForCategoryAndMeasurableRatingIdSelector_thenReturnEmpty() {
    // Arrange
    when(allocationDao.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());

    // Act
    Set<Allocation> actualFindForCategoryAndMeasurableRatingIdSelectorResult =
        allocationService.findForCategoryAndMeasurableRatingIdSelector(mock(Select.class), 1L);

    // Assert
    verify(allocationDao).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    assertTrue(actualFindForCategoryAndMeasurableRatingIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link AllocationService#findByEntityAndScheme(EntityReference, long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AllocationService#findByEntityAndScheme(EntityReference, long)}
   */
  @Test
  @DisplayName("Test findByEntityAndScheme(EntityReference, long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllocationService.findByEntityAndScheme(EntityReference, long)"})
  void testFindByEntityAndScheme_thenReturnEmpty() {
    // Arrange
    when(allocationDao.findByEntityAndScheme(Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Allocation> actualFindByEntityAndSchemeResult =
        allocationService.findByEntityAndScheme(null, 1L);

    // Assert
    verify(allocationDao).findByEntityAndScheme(isNull(), eq(1L));
    assertTrue(actualFindByEntityAndSchemeResult.isEmpty());
  }

  /**
   * Test {@link AllocationService#findByEntityAndScheme(EntityReference, long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AllocationService#findByEntityAndScheme(EntityReference, long)}
   */
  @Test
  @DisplayName(
      "Test findByEntityAndScheme(EntityReference, long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllocationService.findByEntityAndScheme(EntityReference, long)"})
  void testFindByEntityAndScheme_thenThrowIllegalArgumentException() {
    // Arrange
    when(allocationDao.findByEntityAndScheme(Mockito.<EntityReference>any(), anyLong()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> allocationService.findByEntityAndScheme(null, 1L));
    verify(allocationDao).findByEntityAndScheme(isNull(), eq(1L));
  }

  /**
   * Test {@link AllocationService#findByMeasurableAndScheme(long, long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AllocationService#findByMeasurableAndScheme(long, long)}
   */
  @Test
  @DisplayName("Test findByMeasurableAndScheme(long, long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllocationService.findByMeasurableAndScheme(long, long)"})
  void testFindByMeasurableAndScheme_thenReturnEmpty() {
    // Arrange
    when(allocationDao.findByMeasurableIdAndScheme(anyLong(), anyLong()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Allocation> actualFindByMeasurableAndSchemeResult =
        allocationService.findByMeasurableAndScheme(1L, 1L);

    // Assert
    verify(allocationDao).findByMeasurableIdAndScheme(1L, 1L);
    assertTrue(actualFindByMeasurableAndSchemeResult.isEmpty());
  }

  /**
   * Test {@link AllocationService#findByMeasurableAndScheme(long, long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AllocationService#findByMeasurableAndScheme(long, long)}
   */
  @Test
  @DisplayName("Test findByMeasurableAndScheme(long, long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllocationService.findByMeasurableAndScheme(long, long)"})
  void testFindByMeasurableAndScheme_thenThrowIllegalArgumentException() {
    // Arrange
    when(allocationDao.findByMeasurableIdAndScheme(anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> allocationService.findByMeasurableAndScheme(1L, 1L));
    verify(allocationDao).findByMeasurableIdAndScheme(1L, 1L);
  }

  /**
   * Test {@link AllocationService#findByMeasurableRatingId(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AllocationService#findByMeasurableRatingId(long)}
   */
  @Test
  @DisplayName("Test findByMeasurableRatingId(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AllocationService.findByMeasurableRatingId(long)"})
  void testFindByMeasurableRatingId_thenReturnEmpty() {
    // Arrange
    when(allocationDao.findByMeasurableRatingId(anyLong())).thenReturn(new HashSet<>());

    // Act
    Set<Allocation> actualFindByMeasurableRatingIdResult =
        allocationService.findByMeasurableRatingId(1L);

    // Assert
    verify(allocationDao).findByMeasurableRatingId(1L);
    assertTrue(actualFindByMeasurableRatingIdResult.isEmpty());
  }

  /**
   * Test {@link AllocationService#findByMeasurableRatingId(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AllocationService#findByMeasurableRatingId(long)}
   */
  @Test
  @DisplayName("Test findByMeasurableRatingId(long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AllocationService.findByMeasurableRatingId(long)"})
  void testFindByMeasurableRatingId_thenThrowIllegalArgumentException() {
    // Arrange
    when(allocationDao.findByMeasurableRatingId(anyLong()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> allocationService.findByMeasurableRatingId(1L));
    verify(allocationDao).findByMeasurableRatingId(1L);
  }

  /**
   * Test {@link AllocationService#updateAllocations(EntityReference, long, Collection, String)}.
   *
   * <p>Method under test: {@link AllocationService#updateAllocations(EntityReference, long,
   * Collection, String)}
   */
  @Test
  @DisplayName("Test updateAllocations(EntityReference, long, Collection, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AllocationService.updateAllocations(EntityReference, long, Collection, String)"
  })
  void testUpdateAllocations() {
    // Arrange
    when(allocationDao.findByEntityAndScheme(Mockito.<EntityReference>any(), anyLong()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> allocationService.updateAllocations(null, 1L, new ArrayList<>(), "janedoe"));
    verify(allocationDao).findByEntityAndScheme(isNull(), eq(1L));
  }

  /**
   * Test {@link AllocationService#updateAllocations(EntityReference, long, Collection, String)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityReferenceNameResolver#resolve(List)}.
   * </ul>
   *
   * <p>Method under test: {@link AllocationService#updateAllocations(EntityReference, long,
   * Collection, String)}
   */
  @Test
  @DisplayName(
      "Test updateAllocations(EntityReference, long, Collection, String); then calls resolve(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AllocationService.updateAllocations(EntityReference, long, Collection, String)"
  })
  void testUpdateAllocations_thenCallsResolve() {
    // Arrange
    when(allocationDao.updateAllocations(
            anyLong(),
            Mockito.<Collection<MeasurablePercentageChange>>any(),
            Mockito.<String>any()))
        .thenReturn(true);
    when(allocationDao.findByEntityAndScheme(Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenThrow(new IllegalArgumentException());
    when(measurableRatingService.findForEntity(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> allocationService.updateAllocations(null, 1L, new ArrayList<>(), "janedoe"));
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(allocationDao).findByEntityAndScheme(isNull(), eq(1L));
    verify(allocationDao).updateAllocations(eq(1L), isA(Collection.class), eq("janedoe"));
    verify(measurableRatingService).findForEntity(isNull());
  }

  /**
   * Test {@link AllocationService#updateAllocations(EntityReference, long, Collection, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AllocationService#updateAllocations(EntityReference, long,
   * Collection, String)}
   */
  @Test
  @DisplayName(
      "Test updateAllocations(EntityReference, long, Collection, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AllocationService.updateAllocations(EntityReference, long, Collection, String)"
  })
  void testUpdateAllocations_thenReturnFalse() {
    // Arrange
    when(allocationDao.updateAllocations(
            anyLong(),
            Mockito.<Collection<MeasurablePercentageChange>>any(),
            Mockito.<String>any()))
        .thenReturn(false);
    when(allocationDao.findByEntityAndScheme(Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(new ArrayList<>());

    // Act
    Boolean actualUpdateAllocationsResult =
        allocationService.updateAllocations(null, 1L, new ArrayList<>(), "janedoe");

    // Assert
    verify(allocationDao).findByEntityAndScheme(isNull(), eq(1L));
    verify(allocationDao).updateAllocations(eq(1L), isA(Collection.class), eq("janedoe"));
    assertFalse(actualUpdateAllocationsResult);
  }

  /**
   * Test {@link AllocationService#updateAllocations(EntityReference, long, Collection, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AllocationService#updateAllocations(EntityReference, long,
   * Collection, String)}
   */
  @Test
  @DisplayName(
      "Test updateAllocations(EntityReference, long, Collection, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AllocationService.updateAllocations(EntityReference, long, Collection, String)"
  })
  void testUpdateAllocations_thenReturnFalse2() {
    // Arrange
    ArrayList<Allocation> allocationList = new ArrayList<>();
    allocationList.add(
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
    when(allocationDao.updateAllocations(
            anyLong(),
            Mockito.<Collection<MeasurablePercentageChange>>any(),
            Mockito.<String>any()))
        .thenReturn(false);
    when(allocationDao.findByEntityAndScheme(Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(allocationList);

    // Act
    Boolean actualUpdateAllocationsResult =
        allocationService.updateAllocations(null, 1L, new ArrayList<>(), "janedoe");

    // Assert
    verify(allocationDao).findByEntityAndScheme(isNull(), eq(1L));
    verify(allocationDao).updateAllocations(eq(1L), isA(Collection.class), eq("janedoe"));
    assertFalse(actualUpdateAllocationsResult);
  }

  /**
   * Test {@link AllocationService#updateAllocations(EntityReference, long, Collection, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AllocationService#updateAllocations(EntityReference, long,
   * Collection, String)}
   */
  @Test
  @DisplayName(
      "Test updateAllocations(EntityReference, long, Collection, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AllocationService.updateAllocations(EntityReference, long, Collection, String)"
  })
  void testUpdateAllocations_thenReturnFalse3() {
    // Arrange
    ArrayList<Allocation> allocationList = new ArrayList<>();
    allocationList.add(
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
    allocationList.add(
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
    when(allocationDao.updateAllocations(
            anyLong(),
            Mockito.<Collection<MeasurablePercentageChange>>any(),
            Mockito.<String>any()))
        .thenReturn(false);
    when(allocationDao.findByEntityAndScheme(Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(allocationList);

    // Act
    Boolean actualUpdateAllocationsResult =
        allocationService.updateAllocations(null, 1L, new ArrayList<>(), "janedoe");

    // Assert
    verify(allocationDao).findByEntityAndScheme(isNull(), eq(1L));
    verify(allocationDao).updateAllocations(eq(1L), isA(Collection.class), eq("janedoe"));
    assertFalse(actualUpdateAllocationsResult);
  }

  /**
   * Test {@link AllocationService#updateAllocations(EntityReference, long, Collection, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AllocationService#updateAllocations(EntityReference, long,
   * Collection, String)}
   */
  @Test
  @DisplayName(
      "Test updateAllocations(EntityReference, long, Collection, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AllocationService.updateAllocations(EntityReference, long, Collection, String)"
  })
  void testUpdateAllocations_thenReturnFalse4() {
    // Arrange
    when(allocationDao.updateAllocations(
            anyLong(),
            Mockito.<Collection<MeasurablePercentageChange>>any(),
            Mockito.<String>any()))
        .thenReturn(false);
    when(allocationDao.findByEntityAndScheme(Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(new ArrayList<>());

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
    Boolean actualUpdateAllocationsResult =
        allocationService.updateAllocations(null, 1L, changes, "janedoe");

    // Assert
    verify(allocationDao).findByEntityAndScheme(isNull(), eq(1L));
    verify(allocationDao).updateAllocations(eq(1L), isA(Collection.class), eq("janedoe"));
    assertFalse(actualUpdateAllocationsResult);
  }

  /**
   * Test {@link AllocationService#updateAllocations(EntityReference, long, Collection, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AllocationService#updateAllocations(EntityReference, long,
   * Collection, String)}
   */
  @Test
  @DisplayName(
      "Test updateAllocations(EntityReference, long, Collection, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AllocationService.updateAllocations(EntityReference, long, Collection, String)"
  })
  void testUpdateAllocations_thenReturnFalse5() {
    // Arrange
    when(allocationDao.updateAllocations(
            anyLong(),
            Mockito.<Collection<MeasurablePercentageChange>>any(),
            Mockito.<String>any()))
        .thenReturn(false);
    when(allocationDao.findByEntityAndScheme(Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(new ArrayList<>());

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
    Boolean actualUpdateAllocationsResult =
        allocationService.updateAllocations(null, 1L, changes, "janedoe");

    // Assert
    verify(allocationDao).findByEntityAndScheme(isNull(), eq(1L));
    verify(allocationDao).updateAllocations(eq(1L), isA(Collection.class), eq("janedoe"));
    assertFalse(actualUpdateAllocationsResult);
  }

  /**
   * Test {@link AllocationService#updateAllocations(EntityReference, long, Collection, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AllocationService#updateAllocations(EntityReference, long,
   * Collection, String)}
   */
  @Test
  @DisplayName(
      "Test updateAllocations(EntityReference, long, Collection, String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AllocationService.updateAllocations(EntityReference, long, Collection, String)"
  })
  void testUpdateAllocations_thenThrowIllegalArgumentException() {
    // Arrange
    ArrayList<Allocation> allocationList = new ArrayList<>();
    allocationList.add(
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
    when(allocationDao.findByEntityAndScheme(Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(allocationList);

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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> allocationService.updateAllocations(null, 1L, changes, "janedoe"));
    verify(allocationDao).findByEntityAndScheme(isNull(), eq(1L));
  }

  /**
   * Test {@link AllocationService#checkHasEditPermission(EntityReference, Long, String)}.
   *
   * <p>Method under test: {@link AllocationService#checkHasEditPermission(EntityReference, Long,
   * String)}
   */
  @Test
  @DisplayName("Test checkHasEditPermission(EntityReference, Long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AllocationService.checkHasEditPermission(EntityReference, Long, String)"
  })
  void testCheckHasEditPermission() throws InsufficientPrivelegeException {
    // Arrange
    when(allocationPermissionChecker.findAllocationPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    when(allocationSchemeService.getById(anyLong()))
        .thenReturn(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> allocationService.checkHasEditPermission(null, 1L, "janedoe"));
    verify(allocationSchemeService).getById(1L);
    verify(allocationPermissionChecker).findAllocationPermissions(isNull(), eq(1L), eq("janedoe"));
  }

  /**
   * Test {@link AllocationService#checkHasEditPermission(EntityReference, Long, String)}.
   *
   * <ul>
   *   <li>Given {@link AllocationPermissionChecker}.
   * </ul>
   *
   * <p>Method under test: {@link AllocationService#checkHasEditPermission(EntityReference, Long,
   * String)}
   */
  @Test
  @DisplayName(
      "Test checkHasEditPermission(EntityReference, Long, String); given AllocationPermissionChecker")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AllocationService.checkHasEditPermission(EntityReference, Long, String)"
  })
  void testCheckHasEditPermission_givenAllocationPermissionChecker()
      throws InsufficientPrivelegeException {
    // Arrange
    when(allocationSchemeService.getById(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> allocationService.checkHasEditPermission(null, 1L, "janedoe"));
    verify(allocationSchemeService).getById(1L);
  }

  /**
   * Test {@link AllocationService#checkHasEditPermission(EntityReference, Long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link AllocationPermissionChecker#verifyEditPerms(Set, EntityKind, String)}.
   * </ul>
   *
   * <p>Method under test: {@link AllocationService#checkHasEditPermission(EntityReference, Long,
   * String)}
   */
  @Test
  @DisplayName(
      "Test checkHasEditPermission(EntityReference, Long, String); then calls verifyEditPerms(Set, EntityKind, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AllocationService.checkHasEditPermission(EntityReference, Long, String)"
  })
  void testCheckHasEditPermission_thenCallsVerifyEditPerms() throws InsufficientPrivelegeException {
    // Arrange
    doNothing()
        .when(allocationPermissionChecker)
        .verifyEditPerms(
            Mockito.<Set<Operation>>any(), Mockito.<EntityKind>any(), Mockito.<String>any());
    when(allocationPermissionChecker.findAllocationPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(allocationSchemeService.getById(anyLong()))
        .thenReturn(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    // Act
    allocationService.checkHasEditPermission(null, 1L, "janedoe");

    // Assert
    verify(allocationSchemeService).getById(1L);
    verify(allocationPermissionChecker).findAllocationPermissions(isNull(), eq(1L), eq("janedoe"));
    verify(allocationPermissionChecker)
        .verifyEditPerms(isA(Set.class), eq(EntityKind.MEASURABLE_RATING), eq("janedoe"));
  }
}
