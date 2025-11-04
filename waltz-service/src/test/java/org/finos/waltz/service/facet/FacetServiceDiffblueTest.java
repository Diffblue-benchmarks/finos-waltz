package org.finos.waltz.service.facet;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.tally.Tally;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FacetServiceDiffblueTest {
  /**
   * Method under test:
   * {@link FacetService#getApplicationKindTallies(IdSelectionOptions)}
   */
  @Test
  void testGetApplicationKindTallies() {
    // Arrange
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    when(applicationDao.countByApplicationKind(Mockito.<Select<Record1<Long>>>any())).thenReturn(tallyList);
    FacetService facetService = new FacetService(applicationDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);

    // Act
    List<Tally<String>> actualApplicationKindTallies = facetService.getApplicationKindTallies(options);

    // Assert
    verify(applicationDao).countByApplicationKind(isA(Select.class));
    verify(entityReference).kind();
    verify(options).entityReference();
    verify(options).scope();
    assertTrue(actualApplicationKindTallies.isEmpty());
    assertSame(tallyList, actualApplicationKindTallies);
  }

  /**
   * Method under test:
   * {@link FacetService#getApplicationKindTallies(IdSelectionOptions)}
   */
  @Test
  void testGetApplicationKindTallies2() {
    // Arrange
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    when(applicationDao.countByApplicationKind(Mockito.<Select<Record1<Long>>>any())).thenReturn(tallyList);
    FacetService facetService = new FacetService(applicationDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);

    // Act
    List<Tally<String>> actualApplicationKindTallies = facetService.getApplicationKindTallies(options);

    // Assert
    verify(applicationDao).countByApplicationKind(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityReference();
    verify(options).scope();
    assertTrue(actualApplicationKindTallies.isEmpty());
    assertSame(tallyList, actualApplicationKindTallies);
  }

  /**
   * Method under test:
   * {@link FacetService#getApplicationKindTallies(IdSelectionOptions)}
   */
  @Test
  void testGetApplicationKindTallies3() {
    // Arrange
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    when(applicationDao.countByApplicationKind(Mockito.<Select<Record1<Long>>>any())).thenReturn(tallyList);
    FacetService facetService = new FacetService(applicationDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);

    // Act
    List<Tally<String>> actualApplicationKindTallies = facetService.getApplicationKindTallies(options);

    // Assert
    verify(applicationDao).countByApplicationKind(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options).entityReference();
    verify(options).scope();
    assertTrue(actualApplicationKindTallies.isEmpty());
    assertSame(tallyList, actualApplicationKindTallies);
  }

  /**
   * Method under test:
   * {@link FacetService#getApplicationKindTallies(IdSelectionOptions)}
   */
  @Test
  void testGetApplicationKindTallies4() {
    // Arrange
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    when(applicationDao.countByApplicationKind(Mockito.<Select<Record1<Long>>>any())).thenReturn(tallyList);
    FacetService facetService = new FacetService(applicationDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);

    // Act
    List<Tally<String>> actualApplicationKindTallies = facetService.getApplicationKindTallies(options);

    // Assert
    verify(applicationDao).countByApplicationKind(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference).kind();
    verify(options).entityReference();
    verify(options).scope();
    assertTrue(actualApplicationKindTallies.isEmpty());
    assertSame(tallyList, actualApplicationKindTallies);
  }

  /**
   * Method under test:
   * {@link FacetService#getApplicationKindTallies(IdSelectionOptions)}
   */
  @Test
  void testGetApplicationKindTallies5() {
    // Arrange
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    when(applicationDao.countByApplicationKind(Mockito.<Select<Record1<Long>>>any())).thenReturn(tallyList);
    FacetService facetService = new FacetService(applicationDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);

    // Act
    List<Tally<String>> actualApplicationKindTallies = facetService.getApplicationKindTallies(options);

    // Assert
    verify(applicationDao).countByApplicationKind(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityReference();
    verify(options).scope();
    assertTrue(actualApplicationKindTallies.isEmpty());
    assertSame(tallyList, actualApplicationKindTallies);
  }
}
