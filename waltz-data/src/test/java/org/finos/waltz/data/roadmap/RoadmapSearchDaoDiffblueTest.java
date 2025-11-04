package org.finos.waltz.data.roadmap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.roadmap.Roadmap;
import org.junit.jupiter.api.Test;

class RoadmapSearchDaoDiffblueTest {
  /**
   * Method under test: {@link RoadmapSearchDao#search(EntitySearchOptions)}
   */
  @Test
  void testSearch() {
    // Arrange
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    when(roadmapDao.findAll()).thenReturn(new ArrayList<>());
    RoadmapSearchDao roadmapSearchDao = new RoadmapSearchDao(roadmapDao);
    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<Roadmap> actualSearchResult = roadmapSearchDao.search(options);

    // Assert
    verify(roadmapDao).findAll();
    verify(options).limit();
    verify(options).searchQuery();
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Method under test: {@link RoadmapSearchDao#search(EntitySearchOptions)}
   */
  @Test
  void testSearch2() {
    // Arrange
    Roadmap roadmap = mock(Roadmap.class);
    when(roadmap.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    ArrayList<Roadmap> roadmapList = new ArrayList<>();
    roadmapList.add(roadmap);
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    when(roadmapDao.findAll()).thenReturn(roadmapList);
    RoadmapSearchDao roadmapSearchDao = new RoadmapSearchDao(roadmapDao);
    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new ArrayList<>());
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<Roadmap> actualSearchResult = roadmapSearchDao.search(options);

    // Assert
    verify(roadmapDao).findAll();
    verify(roadmap).entityLifecycleStatus();
    verify(options).entityLifecycleStatuses();
    verify(options).limit();
    verify(options).searchQuery();
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Method under test: {@link RoadmapSearchDao#search(EntitySearchOptions)}
   */
  @Test
  void testSearch3() {
    // Arrange
    Roadmap roadmap = mock(Roadmap.class);
    when(roadmap.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    Roadmap roadmap2 = mock(Roadmap.class);
    when(roadmap2.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    ArrayList<Roadmap> roadmapList = new ArrayList<>();
    roadmapList.add(roadmap2);
    roadmapList.add(roadmap);
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    when(roadmapDao.findAll()).thenReturn(roadmapList);
    RoadmapSearchDao roadmapSearchDao = new RoadmapSearchDao(roadmapDao);
    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new ArrayList<>());
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<Roadmap> actualSearchResult = roadmapSearchDao.search(options);

    // Assert
    verify(roadmapDao).findAll();
    verify(roadmap2).entityLifecycleStatus();
    verify(roadmap).entityLifecycleStatus();
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options).limit();
    verify(options).searchQuery();
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Method under test: {@link RoadmapSearchDao#search(EntitySearchOptions)}
   */
  @Test
  void testSearch4() {
    // Arrange
    Roadmap roadmap = mock(Roadmap.class);
    when(roadmap.description()).thenReturn("The characteristics of someone or something");
    when(roadmap.name()).thenReturn("Name");
    when(roadmap.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    Roadmap roadmap2 = mock(Roadmap.class);
    when(roadmap2.description()).thenReturn("The characteristics of someone or something");
    when(roadmap2.name()).thenReturn("Name");
    when(roadmap2.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    ArrayList<Roadmap> roadmapList = new ArrayList<>();
    roadmapList.add(roadmap2);
    roadmapList.add(roadmap);
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    when(roadmapDao.findAll()).thenReturn(roadmapList);
    RoadmapSearchDao roadmapSearchDao = new RoadmapSearchDao(roadmapDao);

    ArrayList<EntityLifecycleStatus> entityLifecycleStatusList = new ArrayList<>();
    entityLifecycleStatusList.add(EntityLifecycleStatus.ACTIVE);
    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusList);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<Roadmap> actualSearchResult = roadmapSearchDao.search(options);

    // Assert
    verify(roadmapDao).findAll();
    verify(roadmap2).description();
    verify(roadmap).description();
    verify(roadmap2).entityLifecycleStatus();
    verify(roadmap).entityLifecycleStatus();
    verify(roadmap2).name();
    verify(roadmap).name();
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options).limit();
    verify(options).searchQuery();
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Method under test: {@link RoadmapSearchDao#search(EntitySearchOptions)}
   */
  @Test
  void testSearch5() {
    // Arrange
    Roadmap roadmap = mock(Roadmap.class);
    when(roadmap.description()).thenReturn("The characteristics of someone or something");
    when(roadmap.name()).thenReturn("Name");
    when(roadmap.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    Roadmap roadmap2 = mock(Roadmap.class);
    when(roadmap2.description()).thenReturn("The characteristics of someone or something");
    when(roadmap2.name()).thenReturn("Name");
    when(roadmap2.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    ArrayList<Roadmap> roadmapList = new ArrayList<>();
    roadmapList.add(roadmap2);
    roadmapList.add(roadmap);
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    when(roadmapDao.findAll()).thenReturn(roadmapList);
    RoadmapSearchDao roadmapSearchDao = new RoadmapSearchDao(roadmapDao);

    ArrayList<EntityLifecycleStatus> entityLifecycleStatusList = new ArrayList<>();
    entityLifecycleStatusList.add(EntityLifecycleStatus.ACTIVE);
    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusList);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("[");

    // Act
    List<Roadmap> actualSearchResult = roadmapSearchDao.search(options);

    // Assert
    verify(roadmapDao).findAll();
    verify(roadmap2).description();
    verify(roadmap2).entityLifecycleStatus();
    verify(roadmap2).name();
    verify(options).entityLifecycleStatuses();
    verify(options).limit();
    verify(options).searchQuery();
    assertEquals(1, actualSearchResult.size());
  }

  /**
   * Method under test: {@link RoadmapSearchDao#search(EntitySearchOptions)}
   */
  @Test
  void testSearch6() {
    // Arrange
    Roadmap roadmap = mock(Roadmap.class);
    when(roadmap.description()).thenReturn("The characteristics of someone or something");
    when(roadmap.name()).thenReturn("Name");
    when(roadmap.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    Roadmap roadmap2 = mock(Roadmap.class);
    when(roadmap2.description()).thenReturn("The characteristics of someone or something");
    when(roadmap2.name()).thenReturn("Name");
    when(roadmap2.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    ArrayList<Roadmap> roadmapList = new ArrayList<>();
    roadmapList.add(roadmap2);
    roadmapList.add(roadmap);
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    when(roadmapDao.findAll()).thenReturn(roadmapList);
    RoadmapSearchDao roadmapSearchDao = new RoadmapSearchDao(roadmapDao);

    ArrayList<EntityLifecycleStatus> entityLifecycleStatusList = new ArrayList<>();
    entityLifecycleStatusList.add(EntityLifecycleStatus.ACTIVE);
    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusList);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("foo");

    // Act
    List<Roadmap> actualSearchResult = roadmapSearchDao.search(options);

    // Assert
    verify(roadmapDao).findAll();
    verify(roadmap2).description();
    verify(roadmap).description();
    verify(roadmap2).entityLifecycleStatus();
    verify(roadmap).entityLifecycleStatus();
    verify(roadmap2).name();
    verify(roadmap).name();
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options).limit();
    verify(options).searchQuery();
    assertTrue(actualSearchResult.isEmpty());
  }
}
