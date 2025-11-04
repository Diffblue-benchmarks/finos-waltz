package org.finos.waltz.service.allocation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.finos.waltz.model.allocation.MeasurablePercentageChange;
import org.finos.waltz.model.allocation_scheme.AllocationScheme;
import org.finos.waltz.service.allocation_schemes.AllocationSchemeService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.measurable_rating.MeasurableRatingService;
import org.finos.waltz.service.permission.permission_checker.AllocationPermissionChecker;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AllocationServiceDiffblueTest {
  /**
   * Method under test: {@link AllocationService#findByEntity(EntityReference)}
   */
  @Test
  void testFindByEntity() {
    // Arrange
    AllocationDao allocationDao = mock(AllocationDao.class);
    ArrayList<Allocation> allocationList = new ArrayList<>();
    when(allocationDao.findByEntity(Mockito.<EntityReference>any())).thenReturn(allocationList);

    // Act
    Collection<Allocation> actualFindByEntityResult = (new AllocationService(allocationDao,
        mock(EntityReferenceNameResolver.class), mock(ChangeLogService.class), mock(MeasurableRatingService.class),
        mock(AllocationPermissionChecker.class), mock(AllocationSchemeService.class))).findByEntity(null);

    // Assert
    verify(allocationDao).findByEntity(isNull());
    assertTrue(actualFindByEntityResult instanceof List);
    assertTrue(actualFindByEntityResult.isEmpty());
    assertSame(allocationList, actualFindByEntityResult);
  }

  /**
   * Method under test: {@link AllocationService#findByEntity(EntityReference)}
   */
  @Test
  void testFindByEntity2() {
    // Arrange
    AllocationDao allocationDao = mock(AllocationDao.class);
    when(allocationDao.findByEntity(Mockito.<EntityReference>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AllocationService(allocationDao, mock(EntityReferenceNameResolver.class),
            mock(ChangeLogService.class), mock(MeasurableRatingService.class), mock(AllocationPermissionChecker.class),
            mock(AllocationSchemeService.class))).findByEntity(null));
    verify(allocationDao).findByEntity(isNull());
  }

  /**
   * Method under test:
   * {@link AllocationService#findForCategoryAndSubjectIdSelector(Select, long)}
   */
  @Test
  void testFindForCategoryAndSubjectIdSelector() {
    // Arrange
    AllocationDao allocationDao = mock(AllocationDao.class);
    ArrayList<Allocation> allocationList = new ArrayList<>();
    when(allocationDao.findForCategoryAndSubjectIdSelector(Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(allocationList);

    // Act
    Collection<Allocation> actualFindForCategoryAndSubjectIdSelectorResult = (new AllocationService(allocationDao,
        mock(EntityReferenceNameResolver.class), mock(ChangeLogService.class), mock(MeasurableRatingService.class),
        mock(AllocationPermissionChecker.class), mock(AllocationSchemeService.class)))
            .findForCategoryAndSubjectIdSelector(mock(Select.class), 1L);

    // Assert
    verify(allocationDao).findForCategoryAndSubjectIdSelector(isA(Select.class), eq(1L));
    assertTrue(actualFindForCategoryAndSubjectIdSelectorResult instanceof List);
    assertTrue(actualFindForCategoryAndSubjectIdSelectorResult.isEmpty());
    assertSame(allocationList, actualFindForCategoryAndSubjectIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link AllocationService#findForCategoryAndSubjectIdSelector(Select, long)}
   */
  @Test
  void testFindForCategoryAndSubjectIdSelector2() {
    // Arrange
    AllocationDao allocationDao = mock(AllocationDao.class);
    when(allocationDao.findForCategoryAndSubjectIdSelector(Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AllocationService(allocationDao, mock(EntityReferenceNameResolver.class),
            mock(ChangeLogService.class), mock(MeasurableRatingService.class), mock(AllocationPermissionChecker.class),
            mock(AllocationSchemeService.class))).findForCategoryAndSubjectIdSelector(mock(Select.class), 1L));
    verify(allocationDao).findForCategoryAndSubjectIdSelector(isA(Select.class), eq(1L));
  }

  /**
   * Method under test:
   * {@link AllocationService#findForCategoryAndMeasurableRatingIdSelector(Select, long)}
   */
  @Test
  void testFindForCategoryAndMeasurableRatingIdSelector() {
    // Arrange
    AllocationDao allocationDao = mock(AllocationDao.class);
    HashSet<Allocation> allocationSet = new HashSet<>();
    when(allocationDao.findForCategoryAndMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(allocationSet);

    // Act
    Set<Allocation> actualFindForCategoryAndMeasurableRatingIdSelectorResult = (new AllocationService(allocationDao,
        mock(EntityReferenceNameResolver.class), mock(ChangeLogService.class), mock(MeasurableRatingService.class),
        mock(AllocationPermissionChecker.class), mock(AllocationSchemeService.class)))
            .findForCategoryAndMeasurableRatingIdSelector(mock(Select.class), 1L);

    // Assert
    verify(allocationDao).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    assertTrue(actualFindForCategoryAndMeasurableRatingIdSelectorResult.isEmpty());
    assertSame(allocationSet, actualFindForCategoryAndMeasurableRatingIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link AllocationService#findForCategoryAndMeasurableRatingIdSelector(Select, long)}
   */
  @Test
  void testFindForCategoryAndMeasurableRatingIdSelector2() {
    // Arrange
    AllocationDao allocationDao = mock(AllocationDao.class);
    when(allocationDao.findForCategoryAndMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AllocationService(allocationDao, mock(EntityReferenceNameResolver.class),
            mock(ChangeLogService.class), mock(MeasurableRatingService.class), mock(AllocationPermissionChecker.class),
            mock(AllocationSchemeService.class))).findForCategoryAndMeasurableRatingIdSelector(mock(Select.class), 1L));
    verify(allocationDao).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
  }

  /**
   * Method under test:
   * {@link AllocationService#findByEntityAndScheme(EntityReference, long)}
   */
  @Test
  void testFindByEntityAndScheme() {
    // Arrange
    AllocationDao allocationDao = mock(AllocationDao.class);
    ArrayList<Allocation> allocationList = new ArrayList<>();
    when(allocationDao.findByEntityAndScheme(Mockito.<EntityReference>any(), anyLong())).thenReturn(allocationList);

    // Act
    List<Allocation> actualFindByEntityAndSchemeResult = (new AllocationService(allocationDao,
        mock(EntityReferenceNameResolver.class), mock(ChangeLogService.class), mock(MeasurableRatingService.class),
        mock(AllocationPermissionChecker.class), mock(AllocationSchemeService.class))).findByEntityAndScheme(null, 1L);

    // Assert
    verify(allocationDao).findByEntityAndScheme(isNull(), eq(1L));
    assertTrue(actualFindByEntityAndSchemeResult.isEmpty());
    assertSame(allocationList, actualFindByEntityAndSchemeResult);
  }

  /**
   * Method under test:
   * {@link AllocationService#findByEntityAndScheme(EntityReference, long)}
   */
  @Test
  void testFindByEntityAndScheme2() {
    // Arrange
    AllocationDao allocationDao = mock(AllocationDao.class);
    when(allocationDao.findByEntityAndScheme(Mockito.<EntityReference>any(), anyLong()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AllocationService(allocationDao, mock(EntityReferenceNameResolver.class),
            mock(ChangeLogService.class), mock(MeasurableRatingService.class), mock(AllocationPermissionChecker.class),
            mock(AllocationSchemeService.class))).findByEntityAndScheme(null, 1L));
    verify(allocationDao).findByEntityAndScheme(isNull(), eq(1L));
  }

  /**
   * Method under test:
   * {@link AllocationService#findByMeasurableAndScheme(long, long)}
   */
  @Test
  void testFindByMeasurableAndScheme() {
    // Arrange
    AllocationDao allocationDao = mock(AllocationDao.class);
    ArrayList<Allocation> allocationList = new ArrayList<>();
    when(allocationDao.findByMeasurableIdAndScheme(anyLong(), anyLong())).thenReturn(allocationList);

    // Act
    List<Allocation> actualFindByMeasurableAndSchemeResult = (new AllocationService(allocationDao,
        mock(EntityReferenceNameResolver.class), mock(ChangeLogService.class), mock(MeasurableRatingService.class),
        mock(AllocationPermissionChecker.class), mock(AllocationSchemeService.class))).findByMeasurableAndScheme(1L,
            1L);

    // Assert
    verify(allocationDao).findByMeasurableIdAndScheme(eq(1L), eq(1L));
    assertTrue(actualFindByMeasurableAndSchemeResult.isEmpty());
    assertSame(allocationList, actualFindByMeasurableAndSchemeResult);
  }

  /**
   * Method under test:
   * {@link AllocationService#findByMeasurableAndScheme(long, long)}
   */
  @Test
  void testFindByMeasurableAndScheme2() {
    // Arrange
    AllocationDao allocationDao = mock(AllocationDao.class);
    when(allocationDao.findByMeasurableIdAndScheme(anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AllocationService(allocationDao, mock(EntityReferenceNameResolver.class),
            mock(ChangeLogService.class), mock(MeasurableRatingService.class), mock(AllocationPermissionChecker.class),
            mock(AllocationSchemeService.class))).findByMeasurableAndScheme(1L, 1L));
    verify(allocationDao).findByMeasurableIdAndScheme(eq(1L), eq(1L));
  }

  /**
   * Method under test: {@link AllocationService#findByMeasurableRatingId(long)}
   */
  @Test
  void testFindByMeasurableRatingId() {
    // Arrange
    AllocationDao allocationDao = mock(AllocationDao.class);
    HashSet<Allocation> allocationSet = new HashSet<>();
    when(allocationDao.findByMeasurableRatingId(anyLong())).thenReturn(allocationSet);

    // Act
    Set<Allocation> actualFindByMeasurableRatingIdResult = (new AllocationService(allocationDao,
        mock(EntityReferenceNameResolver.class), mock(ChangeLogService.class), mock(MeasurableRatingService.class),
        mock(AllocationPermissionChecker.class), mock(AllocationSchemeService.class))).findByMeasurableRatingId(1L);

    // Assert
    verify(allocationDao).findByMeasurableRatingId(eq(1L));
    assertTrue(actualFindByMeasurableRatingIdResult.isEmpty());
    assertSame(allocationSet, actualFindByMeasurableRatingIdResult);
  }

  /**
   * Method under test: {@link AllocationService#findByMeasurableRatingId(long)}
   */
  @Test
  void testFindByMeasurableRatingId2() {
    // Arrange
    AllocationDao allocationDao = mock(AllocationDao.class);
    when(allocationDao.findByMeasurableRatingId(anyLong())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AllocationService(allocationDao, mock(EntityReferenceNameResolver.class),
            mock(ChangeLogService.class), mock(MeasurableRatingService.class), mock(AllocationPermissionChecker.class),
            mock(AllocationSchemeService.class))).findByMeasurableRatingId(1L));
    verify(allocationDao).findByMeasurableRatingId(eq(1L));
  }

  /**
   * Method under test:
   * {@link AllocationService#updateAllocations(EntityReference, long, Collection, String)}
   */
  @Test
  void testUpdateAllocations() {
    // Arrange
    AllocationDao allocationDao = mock(AllocationDao.class);
    when(allocationDao.updateAllocations(anyLong(), Mockito.<Collection<MeasurablePercentageChange>>any(),
        Mockito.<String>any())).thenReturn(true);
    when(allocationDao.findByEntityAndScheme(Mockito.<EntityReference>any(), anyLong())).thenReturn(new ArrayList<>());
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenThrow(new IllegalArgumentException("xs cannot be null"));
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.findForEntity(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    AllocationService allocationService = new AllocationService(allocationDao, nameResolver,
        mock(ChangeLogService.class), measurableRatingService, mock(AllocationPermissionChecker.class),
        mock(AllocationSchemeService.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> allocationService.updateAllocations(null, 1L, new ArrayList<>(), "janedoe"));
    verify(nameResolver).resolve(isA(List.class));
    verify(allocationDao).findByEntityAndScheme(isNull(), eq(1L));
    verify(allocationDao).updateAllocations(eq(1L), isA(Collection.class), eq("janedoe"));
    verify(measurableRatingService).findForEntity(isNull());
  }

  /**
   * Method under test:
   * {@link AllocationService#updateAllocations(EntityReference, long, Collection, String)}
   */
  @Test
  void testUpdateAllocations2() {
    // Arrange
    AllocationDao allocationDao = mock(AllocationDao.class);
    when(allocationDao.updateAllocations(anyLong(), Mockito.<Collection<MeasurablePercentageChange>>any(),
        Mockito.<String>any())).thenReturn(true);
    when(allocationDao.findByEntityAndScheme(Mockito.<EntityReference>any(), anyLong())).thenReturn(new ArrayList<>());
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.findForEntity(Mockito.<EntityReference>any()))
        .thenThrow(new IllegalArgumentException("xs cannot be null"));
    AllocationService allocationService = new AllocationService(allocationDao, mock(EntityReferenceNameResolver.class),
        mock(ChangeLogService.class), measurableRatingService, mock(AllocationPermissionChecker.class),
        mock(AllocationSchemeService.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> allocationService.updateAllocations(null, 1L, new ArrayList<>(), "janedoe"));
    verify(allocationDao).findByEntityAndScheme(isNull(), eq(1L));
    verify(allocationDao).updateAllocations(eq(1L), isA(Collection.class), eq("janedoe"));
    verify(measurableRatingService).findForEntity(isNull());
  }

  /**
   * Method under test:
   * {@link AllocationService#updateAllocations(EntityReference, long, Collection, String)}
   */
  @Test
  void testUpdateAllocations3() {
    // Arrange
    AllocationDao allocationDao = mock(AllocationDao.class);
    when(allocationDao.updateAllocations(anyLong(), Mockito.<Collection<MeasurablePercentageChange>>any(),
        Mockito.<String>any())).thenReturn(false);
    when(allocationDao.findByEntityAndScheme(Mockito.<EntityReference>any(), anyLong())).thenReturn(new ArrayList<>());
    AllocationService allocationService = new AllocationService(allocationDao, mock(EntityReferenceNameResolver.class),
        mock(ChangeLogService.class), mock(MeasurableRatingService.class), mock(AllocationPermissionChecker.class),
        mock(AllocationSchemeService.class));

    // Act
    Boolean actualUpdateAllocationsResult = allocationService.updateAllocations(null, 1L, new ArrayList<>(), "janedoe");

    // Assert
    verify(allocationDao).findByEntityAndScheme(isNull(), eq(1L));
    verify(allocationDao).updateAllocations(eq(1L), isA(Collection.class), eq("janedoe"));
    assertFalse(actualUpdateAllocationsResult);
  }

  /**
   * Method under test:
   * {@link AllocationService#updateAllocations(EntityReference, long, Collection, String)}
   */
  @Test
  void testUpdateAllocations4() {
    // Arrange
    Allocation allocation = mock(Allocation.class);
    when(allocation.percentage()).thenReturn(1);
    when(allocation.measurableRatingId()).thenReturn(1L);

    ArrayList<Allocation> allocationList = new ArrayList<>();
    allocationList.add(allocation);
    AllocationDao allocationDao = mock(AllocationDao.class);
    when(allocationDao.updateAllocations(anyLong(), Mockito.<Collection<MeasurablePercentageChange>>any(),
        Mockito.<String>any())).thenReturn(true);
    when(allocationDao.findByEntityAndScheme(Mockito.<EntityReference>any(), anyLong())).thenReturn(allocationList);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenThrow(new IllegalArgumentException("xs cannot be null"));
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.findForEntity(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    AllocationService allocationService = new AllocationService(allocationDao, nameResolver,
        mock(ChangeLogService.class), measurableRatingService, mock(AllocationPermissionChecker.class),
        mock(AllocationSchemeService.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> allocationService.updateAllocations(null, 1L, new ArrayList<>(), "janedoe"));
    verify(nameResolver).resolve(isA(List.class));
    verify(allocationDao).findByEntityAndScheme(isNull(), eq(1L));
    verify(allocationDao).updateAllocations(eq(1L), isA(Collection.class), eq("janedoe"));
    verify(allocation, atLeast(1)).measurableRatingId();
    verify(allocation).percentage();
    verify(measurableRatingService).findForEntity(isNull());
  }

  /**
   * Method under test:
   * {@link AllocationService#updateAllocations(EntityReference, long, Collection, String)}
   */
  @Test
  void testUpdateAllocations5() {
    // Arrange
    Allocation allocation = mock(Allocation.class);
    when(allocation.percentage()).thenReturn(1);
    when(allocation.measurableRatingId()).thenReturn(1L);
    Allocation allocation2 = mock(Allocation.class);
    when(allocation2.percentage()).thenReturn(1);
    when(allocation2.measurableRatingId()).thenReturn(1L);

    ArrayList<Allocation> allocationList = new ArrayList<>();
    allocationList.add(allocation2);
    allocationList.add(allocation);
    AllocationDao allocationDao = mock(AllocationDao.class);
    when(allocationDao.updateAllocations(anyLong(), Mockito.<Collection<MeasurablePercentageChange>>any(),
        Mockito.<String>any())).thenReturn(true);
    when(allocationDao.findByEntityAndScheme(Mockito.<EntityReference>any(), anyLong())).thenReturn(allocationList);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenThrow(new IllegalArgumentException("xs cannot be null"));
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.findForEntity(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    AllocationService allocationService = new AllocationService(allocationDao, nameResolver,
        mock(ChangeLogService.class), measurableRatingService, mock(AllocationPermissionChecker.class),
        mock(AllocationSchemeService.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> allocationService.updateAllocations(null, 1L, new ArrayList<>(), "janedoe"));
    verify(nameResolver).resolve(isA(List.class));
    verify(allocationDao).findByEntityAndScheme(isNull(), eq(1L));
    verify(allocationDao).updateAllocations(eq(1L), isA(Collection.class), eq("janedoe"));
    verify(allocation2, atLeast(1)).measurableRatingId();
    verify(allocation, atLeast(1)).measurableRatingId();
    verify(allocation2).percentage();
    verify(allocation).percentage();
    verify(measurableRatingService).findForEntity(isNull());
  }

  /**
   * Method under test:
   * {@link AllocationService#checkHasEditPermission(EntityReference, Long, String)}
   */
  @Test
  void testCheckHasEditPermission() throws InsufficientPrivelegeException {
    // Arrange
    AllocationSchemeService allocationSchemeService = mock(AllocationSchemeService.class);
    when(allocationSchemeService.getById(anyLong())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AllocationService(mock(AllocationDao.class), mock(EntityReferenceNameResolver.class),
            mock(ChangeLogService.class), mock(MeasurableRatingService.class), mock(AllocationPermissionChecker.class),
            allocationSchemeService)).checkHasEditPermission(null, 1L, "janedoe"));
    verify(allocationSchemeService).getById(eq(1L));
  }

  /**
   * Method under test:
   * {@link AllocationService#checkHasEditPermission(EntityReference, Long, String)}
   */
  @Test
  void testCheckHasEditPermission2() throws InsufficientPrivelegeException {
    // Arrange
    AllocationPermissionChecker allocationPermissionChecker = mock(AllocationPermissionChecker.class);
    doNothing().when(allocationPermissionChecker)
        .verifyEditPerms(Mockito.<Set<Operation>>any(), Mockito.<EntityKind>any(), Mockito.<String>any());
    when(allocationPermissionChecker.findAllocationPermissions(Mockito.<EntityReference>any(), anyLong(),
        Mockito.<String>any())).thenReturn(new HashSet<>());
    AllocationScheme allocationScheme = mock(AllocationScheme.class);
    when(allocationScheme.measurableCategoryId()).thenReturn(1L);
    AllocationSchemeService allocationSchemeService = mock(AllocationSchemeService.class);
    when(allocationSchemeService.getById(anyLong())).thenReturn(allocationScheme);

    // Act
    (new AllocationService(mock(AllocationDao.class), mock(EntityReferenceNameResolver.class),
        mock(ChangeLogService.class), mock(MeasurableRatingService.class), allocationPermissionChecker,
        allocationSchemeService)).checkHasEditPermission(null, 1L, "janedoe");

    // Assert
    verify(allocationScheme).measurableCategoryId();
    verify(allocationSchemeService).getById(eq(1L));
    verify(allocationPermissionChecker).findAllocationPermissions(isNull(), eq(1L), eq("janedoe"));
    verify(allocationPermissionChecker).verifyEditPerms(isA(Set.class), eq(EntityKind.MEASURABLE_RATING),
        eq("janedoe"));
  }
}
