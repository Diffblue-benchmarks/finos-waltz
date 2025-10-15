package org.finos.waltz.service.legal_entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.legal_entity.LegalEntityDao;
import org.finos.waltz.data.legal_entity.search.LegalEntitySearchDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.legal_entity.ImmutableLegalEntity;
import org.finos.waltz.model.legal_entity.LegalEntity;
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
class LegalEntityServiceDiffblueTest {
  @Mock private LegalEntityDao legalEntityDao;

  @Mock private LegalEntitySearchDao legalEntitySearchDao;

  @InjectMocks private LegalEntityService legalEntityService;

  /**
   * Test {@link LegalEntityService#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link LegalEntityService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LegalEntityService.search(EntitySearchOptions)"})
  void testSearch() {
    // Arrange
    ArrayList<LegalEntity> legalEntityList = new ArrayList<>();
    when(legalEntitySearchDao.search(Mockito.<EntitySearchOptions>any()))
        .thenReturn(legalEntityList);

    // Act
    Collection<LegalEntity> actualSearchResult = legalEntityService.search(null);

    // Assert
    verify(legalEntitySearchDao).search(isNull());
    assertTrue(actualSearchResult instanceof List);
    assertTrue(actualSearchResult.isEmpty());
    assertSame(legalEntityList, actualSearchResult);
  }

  /**
   * Test {@link LegalEntityService#getById(long)}.
   *
   * <p>Method under test: {@link LegalEntityService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LegalEntity LegalEntityService.getById(long)"})
  void testGetById() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(legalEntityDao.getById(anyLong()))
        .thenReturn(
            ImmutableLegalEntity.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .build());

    // Act
    LegalEntity actualById = legalEntityService.getById(1L);

    // Assert
    verify(legalEntityDao).getById(1L);
    assertTrue(actualById instanceof ImmutableLegalEntity);
    LocalDateTime lastUpdatedAtResult = actualById.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("42", actualById.externalId());
    assertEquals("Name", actualById.name());
    assertEquals("Provenance", actualById.provenance());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualById.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link LegalEntityService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LegalEntityService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LegalEntityService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_thenReturnEmpty() {
    // Arrange
    when(legalEntityDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APPLICATION)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Set<LegalEntity> actualFindBySelectorResult =
        legalEntityService.findBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(legalEntityDao).findBySelector(isA(Select.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link LegalEntityService#findAll()}.
   *
   * <p>Method under test: {@link LegalEntityService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LegalEntityService.findAll()"})
  void testFindAll() {
    // Arrange
    HashSet<LegalEntity> legalEntitySet = new HashSet<>();
    when(legalEntityDao.findAll()).thenReturn(legalEntitySet);

    // Act
    Collection<LegalEntity> actualFindAllResult = legalEntityService.findAll();

    // Assert
    verify(legalEntityDao).findAll();
    assertTrue(actualFindAllResult instanceof Set);
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(legalEntitySet, actualFindAllResult);
  }
}
