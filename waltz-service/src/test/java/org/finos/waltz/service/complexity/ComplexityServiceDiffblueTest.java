package org.finos.waltz.service.complexity;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.complexity.ComplexityDao;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.complexity.Complexity;
import org.finos.waltz.model.complexity.ComplexityKind;
import org.finos.waltz.model.complexity.ComplexityTotal;
import org.finos.waltz.model.settings.Setting;
import org.finos.waltz.service.complexity_kind.ComplexityKindService;
import org.finos.waltz.service.settings.SettingsService;
import org.jooq.lambda.tuple.Tuple2;
import org.jooq.lambda.tuple.Tuple3;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ComplexityServiceDiffblueTest {
  /**
   * Method under test:
   * {@link ComplexityService#findByEntityReference(EntityReference)}
   */
  @Test
  void testFindByEntityReference() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    HashSet<Complexity> complexitySet = new HashSet<>();
    when(complexityDao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(complexitySet);
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    Set<Complexity> actualFindByEntityReferenceResult = (new ComplexityService(complexityDao, complexityKindService,
        new SettingsService(settingsDao, new ArrayList<>()))).findByEntityReference(null);

    // Assert
    verify(complexityDao).findByEntityReference(isNull());
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
    assertSame(complexitySet, actualFindByEntityReferenceResult);
  }

  /**
   * Method under test:
   * {@link ComplexityService#findByEntityReference(EntityReference)}
   */
  @Test
  void testFindByEntityReference2() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new ComplexityService(complexityDao, complexityKindService,
        new SettingsService(settingsDao, new ArrayList<>()))).findByEntityReference(null));
    verify(complexityDao).findByEntityReference(isNull());
  }

  /**
   * Method under test:
   * {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindBySelector() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    HashSet<Complexity> complexitySet = new HashSet<>();
    when(complexityDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(complexitySet);
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    ComplexityService complexityService = new ComplexityService(complexityDao, complexityKindService,
        new SettingsService(settingsDao, new ArrayList<>()));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    Set<Complexity> actualFindBySelectorResult = complexityService.findBySelector(EntityKind.APPLICATION, options);

    // Assert
    verify(complexityDao).findBySelector(isA(GenericSelector.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(complexitySet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindBySelector2() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findBySelector(Mockito.<GenericSelector>any()))
        .thenThrow(new IllegalArgumentException("targetKind cannot be null"));
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    ComplexityService complexityService = new ComplexityService(complexityDao, complexityKindService,
        new SettingsService(settingsDao, new ArrayList<>()));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> complexityService.findBySelector(EntityKind.APPLICATION, options));
    verify(complexityDao).findBySelector(isA(GenericSelector.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Method under test:
   * {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindBySelector3() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    HashSet<Complexity> complexitySet = new HashSet<>();
    when(complexityDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(complexitySet);
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    ComplexityService complexityService = new ComplexityService(complexityDao, complexityKindService,
        new SettingsService(settingsDao, new ArrayList<>()));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    Set<Complexity> actualFindBySelectorResult = complexityService.findBySelector(EntityKind.CHANGE_INITIATIVE,
        options);

    // Assert
    verify(complexityDao).findBySelector(isA(GenericSelector.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(complexitySet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindBySelector4() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    HashSet<Complexity> complexitySet = new HashSet<>();
    when(complexityDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(complexitySet);
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    ComplexityService complexityService = new ComplexityService(complexityDao, complexityKindService,
        new SettingsService(settingsDao, new ArrayList<>()));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    Set<Complexity> actualFindBySelectorResult = complexityService.findBySelector(EntityKind.CHANGE_INITIATIVE,
        options);

    // Assert
    verify(complexityDao).findBySelector(isA(GenericSelector.class));
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(complexitySet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ComplexityService#getComplexitySummaryForSelector(Long, EntityKind, IdSelectionOptions, int)}
   */
  @Test
  void testGetComplexitySummaryForSelector() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(complexityDao.getStandardDeviationAndVariance(Mockito.<Long>any(), Mockito.<GenericSelector>any(),
        Mockito.<BigDecimal>any(), Mockito.<Integer>any())).thenReturn(new Tuple2<>(bigDecimal, new BigDecimal("2.3")));
    when(complexityDao.findTopComplexityScoresForKindAndSelector(anyLong(), Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    when(complexityDao.getMappedAndMissingCountsForKindBySelector(Mockito.<Long>any(), Mockito.<GenericSelector>any()))
        .thenReturn(new Tuple2<>(1, 1));
    BigDecimal bigDecimal2 = new BigDecimal("2.3");
    BigDecimal bigDecimal3 = new BigDecimal("2.3");
    when(complexityDao.getAverageAndTotalAndMedianScoreByKindAndSelector(Mockito.<Long>any(),
        Mockito.<GenericSelector>any())).thenReturn(new Tuple3<>(bigDecimal2, bigDecimal3, new BigDecimal("2.3")));
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    when(complexityKindService.getById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException("targetKind cannot be null"));
    SettingsDao settingsDao = mock(SettingsDao.class);
    ComplexityService complexityService = new ComplexityService(complexityDao, complexityKindService,
        new SettingsService(settingsDao, new ArrayList<>()));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> complexityService.getComplexitySummaryForSelector(1L, EntityKind.APPLICATION, options, 1));
    verify(complexityDao).findTopComplexityScoresForKindAndSelector(eq(1L), isA(GenericSelector.class), eq(1));
    verify(complexityDao).getAverageAndTotalAndMedianScoreByKindAndSelector(eq(1L), isA(GenericSelector.class));
    verify(complexityDao).getMappedAndMissingCountsForKindBySelector(eq(1L), isA(GenericSelector.class));
    verify(complexityDao).getStandardDeviationAndVariance(eq(1L), isA(GenericSelector.class), isA(BigDecimal.class),
        eq(1));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    verify(complexityKindService).getById(eq(1L));
  }

  /**
   * Method under test:
   * {@link ComplexityService#findTotalsByTargetKindAndSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindTotalsByTargetKindAndSelector() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    HashSet<ComplexityTotal> complexityTotalSet = new HashSet<>();
    when(complexityDao.findTotalsByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(complexityTotalSet);
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    ComplexityService complexityService = new ComplexityService(complexityDao, complexityKindService,
        new SettingsService(settingsDao, new ArrayList<>()));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<ComplexityTotal> actualFindTotalsByTargetKindAndSelectorResult = complexityService
        .findTotalsByTargetKindAndSelector(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(complexityDao).findTotalsByGenericSelector(isA(GenericSelector.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindTotalsByTargetKindAndSelectorResult.isEmpty());
    assertSame(complexityTotalSet, actualFindTotalsByTargetKindAndSelectorResult);
  }

  /**
   * Method under test:
   * {@link ComplexityService#findTotalsByTargetKindAndSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindTotalsByTargetKindAndSelector2() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findTotalsByGenericSelector(Mockito.<GenericSelector>any()))
        .thenThrow(new IllegalArgumentException("targetKind cannot be null"));
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    ComplexityService complexityService = new ComplexityService(complexityDao, complexityKindService,
        new SettingsService(settingsDao, new ArrayList<>()));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> complexityService.findTotalsByTargetKindAndSelector(EntityKind.APPLICATION, selectionOptions));
    verify(complexityDao).findTotalsByGenericSelector(isA(GenericSelector.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
  }

  /**
   * Method under test:
   * {@link ComplexityService#findTotalsByTargetKindAndSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindTotalsByTargetKindAndSelector3() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    HashSet<ComplexityTotal> complexityTotalSet = new HashSet<>();
    when(complexityDao.findTotalsByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(complexityTotalSet);
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    ComplexityService complexityService = new ComplexityService(complexityDao, complexityKindService,
        new SettingsService(settingsDao, new ArrayList<>()));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<ComplexityTotal> actualFindTotalsByTargetKindAndSelectorResult = complexityService
        .findTotalsByTargetKindAndSelector(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(complexityDao).findTotalsByGenericSelector(isA(GenericSelector.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindTotalsByTargetKindAndSelectorResult.isEmpty());
    assertSame(complexityTotalSet, actualFindTotalsByTargetKindAndSelectorResult);
  }

  /**
   * Method under test:
   * {@link ComplexityService#findTotalsByTargetKindAndSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindTotalsByTargetKindAndSelector4() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    HashSet<ComplexityTotal> complexityTotalSet = new HashSet<>();
    when(complexityDao.findTotalsByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(complexityTotalSet);
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    ComplexityService complexityService = new ComplexityService(complexityDao, complexityKindService,
        new SettingsService(settingsDao, new ArrayList<>()));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<ComplexityTotal> actualFindTotalsByTargetKindAndSelectorResult = complexityService
        .findTotalsByTargetKindAndSelector(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(complexityDao).findTotalsByGenericSelector(isA(GenericSelector.class));
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindTotalsByTargetKindAndSelectorResult.isEmpty());
    assertSame(complexityTotalSet, actualFindTotalsByTargetKindAndSelectorResult);
  }

  /**
   * Method under test: {@link ComplexityService#populateMeasurableComplexities()}
   */
  @Test
  void testPopulateMeasurableComplexities() {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any())).thenReturn(null);

    // Act
    (new ComplexityService(mock(ComplexityDao.class), mock(ComplexityKindService.class),
        new SettingsService(settingsDao, new ArrayList<>()))).populateMeasurableComplexities();

    // Assert
    verify(settingsDao).getByName(eq("job.COMPLEXITY_REBUILD_MEASURABLE.params"));
  }

  /**
   * Method under test: {@link ComplexityService#populateMeasurableComplexities()}
   */
  @Test
  void testPopulateMeasurableComplexities2() {
    // Arrange
    Setting setting = mock(Setting.class);
    Optional<String> ofResult = Optional.of("foo");
    when(setting.value()).thenReturn(ofResult);
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any())).thenReturn(setting);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ComplexityService(mock(ComplexityDao.class), mock(ComplexityKindService.class),
            new SettingsService(settingsDao, new ArrayList<>()))).populateMeasurableComplexities());
    verify(settingsDao).getByName(eq("job.COMPLEXITY_REBUILD_MEASURABLE.params"));
    verify(setting).value();
  }

  /**
   * Method under test: {@link ComplexityService#populateMeasurableComplexities()}
   */
  @Test
  void testPopulateMeasurableComplexities3() {
    // Arrange
    Setting setting = mock(Setting.class);
    when(setting.value()).thenThrow(new IllegalArgumentException("job.%s.params"));
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any())).thenReturn(setting);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ComplexityService(mock(ComplexityDao.class), mock(ComplexityKindService.class),
            new SettingsService(settingsDao, new ArrayList<>()))).populateMeasurableComplexities());
    verify(settingsDao).getByName(eq("job.COMPLEXITY_REBUILD_MEASURABLE.params"));
    verify(setting).value();
  }

  /**
   * Method under test: {@link ComplexityService#populateMeasurableComplexities()}
   */
  @Test
  void testPopulateMeasurableComplexities4() {
    // Arrange
    Setting setting = mock(Setting.class);
    Optional<String> ofResult = Optional.of("foo");
    when(setting.value()).thenReturn(ofResult);
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any())).thenReturn(setting);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ComplexityService(mock(ComplexityDao.class), mock(ComplexityKindService.class),
            new SettingsService(settingsDao, new ArrayList<>()))).populateMeasurableComplexities());
    verify(settingsDao).getByName(eq("job.COMPLEXITY_REBUILD_MEASURABLE.params"));
    verify(setting).value();
  }

  /**
   * Method under test: {@link ComplexityService#populateMeasurableComplexities()}
   */
  @Test
  void testPopulateMeasurableComplexities5() {
    // Arrange
    Setting setting = mock(Setting.class);
    Optional<String> ofResult = Optional.of("42");
    when(setting.value()).thenReturn(ofResult);
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any())).thenReturn(setting);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ComplexityService(mock(ComplexityDao.class), mock(ComplexityKindService.class),
            new SettingsService(settingsDao, new ArrayList<>()))).populateMeasurableComplexities());
    verify(settingsDao).getByName(eq("job.COMPLEXITY_REBUILD_MEASURABLE.params"));
    verify(setting).value();
  }

  /**
   * Method under test: {@link ComplexityService#populateMeasurableComplexities()}
   */
  @Test
  void testPopulateMeasurableComplexities6() {
    // Arrange
    Setting setting = mock(Setting.class);
    Optional<String> ofResult = Optional.of("");
    when(setting.value()).thenReturn(ofResult);
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any())).thenReturn(setting);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ComplexityService(mock(ComplexityDao.class), mock(ComplexityKindService.class),
            new SettingsService(settingsDao, new ArrayList<>()))).populateMeasurableComplexities());
    verify(settingsDao).getByName(eq("job.COMPLEXITY_REBUILD_MEASURABLE.params"));
    verify(setting).value();
  }

  /**
   * Method under test: {@link ComplexityService#populateMeasurableComplexities()}
   */
  @Test
  void testPopulateMeasurableComplexities7() {
    // Arrange
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    when(complexityKindService.findAll()).thenReturn(new HashSet<>());
    Setting setting = mock(Setting.class);
    Optional<String> emptyResult = Optional.empty();
    when(setting.value()).thenReturn(emptyResult);
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any())).thenReturn(setting);

    // Act
    (new ComplexityService(mock(ComplexityDao.class), complexityKindService,
        new SettingsService(settingsDao, new ArrayList<>()))).populateMeasurableComplexities();

    // Assert
    verify(settingsDao).getByName(eq("job.COMPLEXITY_REBUILD_MEASURABLE.params"));
    verify(setting).value();
    verify(complexityKindService).findAll();
  }

  /**
   * Method under test: {@link ComplexityService#populateMeasurableComplexities()}
   */
  @Test
  void testPopulateMeasurableComplexities8() {
    // Arrange
    SettingsService settingsService = mock(SettingsService.class);
    when(settingsService.getByName(Mockito.<String>any())).thenReturn(null);

    // Act
    (new ComplexityService(mock(ComplexityDao.class), mock(ComplexityKindService.class), settingsService))
        .populateMeasurableComplexities();

    // Assert
    verify(settingsService).getByName(eq("job.COMPLEXITY_REBUILD_MEASURABLE.params"));
  }

  /**
   * Method under test: {@link ComplexityService#populateMeasurableComplexities()}
   */
  @Test
  void testPopulateMeasurableComplexities9() {
    // Arrange
    SettingsService settingsService = mock(SettingsService.class);
    when(settingsService.getByName(Mockito.<String>any())).thenThrow(new IllegalArgumentException("job.%s.params"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ComplexityService(mock(ComplexityDao.class), mock(ComplexityKindService.class), settingsService))
            .populateMeasurableComplexities());
    verify(settingsService).getByName(eq("job.COMPLEXITY_REBUILD_MEASURABLE.params"));
  }

  /**
   * Method under test: {@link ComplexityService#populateMeasurableComplexities()}
   */
  @Test
  void testPopulateMeasurableComplexities10() {
    // Arrange
    Setting setting = mock(Setting.class);
    Optional<String> ofResult = Optional.of("42");
    when(setting.value()).thenReturn(ofResult);
    SettingsService settingsService = mock(SettingsService.class);
    when(settingsService.getByName(Mockito.<String>any())).thenReturn(setting);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ComplexityService(mock(ComplexityDao.class), mock(ComplexityKindService.class), settingsService))
            .populateMeasurableComplexities());
    verify(setting).value();
    verify(settingsService).getByName(eq("job.COMPLEXITY_REBUILD_MEASURABLE.params"));
  }

  /**
   * Method under test: {@link ComplexityService#populateMeasurableComplexities()}
   */
  @Test
  void testPopulateMeasurableComplexities11() {
    // Arrange
    ComplexityKind complexityKind = mock(ComplexityKind.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(complexityKind.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(complexityKind.externalId()).thenReturn(ofResult2);

    HashSet<ComplexityKind> complexityKindSet = new HashSet<>();
    complexityKindSet.add(complexityKind);
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    when(complexityKindService.findAll()).thenReturn(complexityKindSet);
    Setting setting = mock(Setting.class);
    Optional<String> emptyResult = Optional.empty();
    when(setting.value()).thenReturn(emptyResult);
    SettingsService settingsService = mock(SettingsService.class);
    when(settingsService.getByName(Mockito.<String>any())).thenReturn(setting);

    // Act
    (new ComplexityService(mock(ComplexityDao.class), complexityKindService, settingsService))
        .populateMeasurableComplexities();

    // Assert
    verify(complexityKind, atLeast(1)).externalId();
    verify(complexityKind).id();
    verify(setting).value();
    verify(complexityKindService).findAll();
    verify(settingsService).getByName(eq("job.COMPLEXITY_REBUILD_MEASURABLE.params"));
  }
}
