package org.finos.waltz.service.legal_entity;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.data.legal_entity.LegalEntityDao;
import org.finos.waltz.data.legal_entity.search.LegalEntitySearchDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.legal_entity.LegalEntity;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LegalEntityServiceDiffblueTest {
  /**
   * Method under test: {@link LegalEntityService#search(EntitySearchOptions)}
   */
  @Test
  void testSearch() {
    // Arrange
    LegalEntitySearchDao legalEntitySearchDao = mock(LegalEntitySearchDao.class);
    ArrayList<LegalEntity> legalEntityList = new ArrayList<>();
    when(legalEntitySearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(legalEntityList);

    // Act
    Collection<LegalEntity> actualSearchResult = (new LegalEntityService(mock(LegalEntityDao.class),
        legalEntitySearchDao)).search(null);

    // Assert
    verify(legalEntitySearchDao).search(isNull());
    assertTrue(actualSearchResult instanceof List);
    assertTrue(actualSearchResult.isEmpty());
    assertSame(legalEntityList, actualSearchResult);
  }

  /**
   * Method under test: {@link LegalEntityService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    LegalEntityDao legalEntityDao = mock(LegalEntityDao.class);
    when(legalEntityDao.getById(anyLong())).thenReturn(null);

    // Act
    LegalEntity actualById = (new LegalEntityService(legalEntityDao, mock(LegalEntitySearchDao.class))).getById(1L);

    // Assert
    verify(legalEntityDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test:
   * {@link LegalEntityService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector() {
    // Arrange
    LegalEntityDao legalEntityDao = mock(LegalEntityDao.class);
    HashSet<LegalEntity> legalEntitySet = new HashSet<>();
    when(legalEntityDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(legalEntitySet);
    LegalEntityService legalEntityService = new LegalEntityService(legalEntityDao, mock(LegalEntitySearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<LegalEntity> actualFindBySelectorResult = legalEntityService.findBySelector(selectionOptions);

    // Assert
    verify(legalEntityDao).findBySelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(legalEntitySet, actualFindBySelectorResult);
  }

  /**
   * Method under test: {@link LegalEntityService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    LegalEntityDao legalEntityDao = mock(LegalEntityDao.class);
    HashSet<LegalEntity> legalEntitySet = new HashSet<>();
    when(legalEntityDao.findAll()).thenReturn(legalEntitySet);

    // Act
    Collection<LegalEntity> actualFindAllResult = (new LegalEntityService(legalEntityDao,
        mock(LegalEntitySearchDao.class))).findAll();

    // Assert
    verify(legalEntityDao).findAll();
    assertTrue(actualFindAllResult instanceof Set);
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(legalEntitySet, actualFindAllResult);
  }
}
