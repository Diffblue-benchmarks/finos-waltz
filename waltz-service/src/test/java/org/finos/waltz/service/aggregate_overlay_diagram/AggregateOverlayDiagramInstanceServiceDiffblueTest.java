package org.finos.waltz.service.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.aggregate_overlay_diagram.AggregateOverlayDiagramInstanceDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.aggregate_overlay_diagram.AggregateOverlayDiagramInstance;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagramInstance;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagramInstance.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramInstanceCreateCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AggregateOverlayDiagramInstanceServiceDiffblueTest {
  /**
   * Test {@link AggregateOverlayDiagramInstanceService#findAll()}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramInstanceService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AggregateOverlayDiagramInstanceService.findAll()"})
  void testFindAll() {
    // Arrange
    AggregateOverlayDiagramInstanceDao aggregateOverlayDiagramInstanceDao =
        mock(AggregateOverlayDiagramInstanceDao.class);
    when(aggregateOverlayDiagramInstanceDao.findAll()).thenReturn(new HashSet<>());

    // Act
    Set<AggregateOverlayDiagramInstance> actualFindAllResult =
        new AggregateOverlayDiagramInstanceService(aggregateOverlayDiagramInstanceDao).findAll();

    // Assert
    verify(aggregateOverlayDiagramInstanceDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramInstanceService#findByDiagramId(Long)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramInstanceService#findByDiagramId(Long)}
   */
  @Test
  @DisplayName("Test findByDiagramId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AggregateOverlayDiagramInstanceService.findByDiagramId(Long)"})
  void testFindByDiagramId() {
    // Arrange
    AggregateOverlayDiagramInstanceDao aggregateOverlayDiagramInstanceDao =
        mock(AggregateOverlayDiagramInstanceDao.class);
    when(aggregateOverlayDiagramInstanceDao.findByDiagramId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<AggregateOverlayDiagramInstance> actualFindByDiagramIdResult =
        new AggregateOverlayDiagramInstanceService(aggregateOverlayDiagramInstanceDao)
            .findByDiagramId(1L);

    // Assert
    verify(aggregateOverlayDiagramInstanceDao).findByDiagramId(1L);
    assertTrue(actualFindByDiagramIdResult.isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramInstanceService#getById(Long)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramInstanceService#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AggregateOverlayDiagramInstance AggregateOverlayDiagramInstanceService.getById(Long)"
  })
  void testGetById() {
    // Arrange
    AggregateOverlayDiagramInstanceDao aggregateOverlayDiagramInstanceDao =
        mock(AggregateOverlayDiagramInstanceDao.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(aggregateOverlayDiagramInstanceDao.getById(Mockito.<Long>any()))
        .thenReturn(
            nameResult
                .parentEntityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .svg("Svg")
                .build());

    // Act
    AggregateOverlayDiagramInstance actualById =
        new AggregateOverlayDiagramInstanceService(aggregateOverlayDiagramInstanceDao).getById(1L);

    // Assert
    verify(aggregateOverlayDiagramInstanceDao).getById(1L);
    EntityReference parentEntityReferenceResult = actualById.parentEntityReference();
    assertTrue(parentEntityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualById instanceof ImmutableAggregateOverlayDiagramInstance);
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("Name", actualById.name());
    assertEquals("Provenance", actualById.provenance());
    assertEquals("Svg", actualById.svg());
    assertEquals(
        "The characteristics of someone or something", parentEntityReferenceResult.description());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(1L, actualById.diagramId().longValue());
    assertEquals(1L, parentEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, parentEntityReferenceResult.kind());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualById.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link
   * AggregateOverlayDiagramInstanceService#createInstance(OverlayDiagramInstanceCreateCommand,
   * String)}.
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramInstanceService#createInstance(OverlayDiagramInstanceCreateCommand,
   * String)}
   */
  @Test
  @DisplayName("Test createInstance(OverlayDiagramInstanceCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AggregateOverlayDiagramInstanceService.createInstance(OverlayDiagramInstanceCreateCommand, String)"
  })
  void testCreateInstance() {
    // Arrange
    AggregateOverlayDiagramInstanceDao aggregateOverlayDiagramInstanceDao =
        mock(AggregateOverlayDiagramInstanceDao.class);
    when(aggregateOverlayDiagramInstanceDao.createInstance(
            Mockito.<OverlayDiagramInstanceCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1);

    // Act
    int actualCreateInstanceResult =
        new AggregateOverlayDiagramInstanceService(aggregateOverlayDiagramInstanceDao)
            .createInstance(null, "janedoe");

    // Assert
    verify(aggregateOverlayDiagramInstanceDao).createInstance(isNull(), eq("janedoe"));
    assertEquals(1, actualCreateInstanceResult);
  }
}
