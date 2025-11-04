package org.finos.waltz.service.actor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.actor.ActorDao;
import org.finos.waltz.data.actor.ActorSearchDao;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.actor.Actor;
import org.finos.waltz.model.actor.ActorCreateCommand;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ActorServiceDiffblueTest {
  /**
   * Method under test: {@link ActorService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    ActorDao actorDao = mock(ActorDao.class);
    ArrayList<Actor> actorList = new ArrayList<>();
    when(actorDao.findAll()).thenReturn(actorList);

    // Act
    List<Actor> actualFindAllResult = (new ActorService(actorDao, mock(ActorSearchDao.class))).findAll();

    // Assert
    verify(actorDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(actorList, actualFindAllResult);
  }

  /**
   * Method under test: {@link ActorService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.getById(anyLong())).thenReturn(null);

    // Act
    Actor actualById = (new ActorService(actorDao, mock(ActorSearchDao.class))).getById(1L);

    // Assert
    verify(actorDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link ActorService#create(ActorCreateCommand, String)}
   */
  @Test
  void testCreate() {
    // Arrange
    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.create(Mockito.<ActorCreateCommand>any(), Mockito.<String>any())).thenReturn(1L);

    // Act
    Long actualCreateResult = (new ActorService(actorDao, mock(ActorSearchDao.class)))
        .create(mock(ActorCreateCommand.class), "janedoe");

    // Assert
    verify(actorDao).create(isA(ActorCreateCommand.class), eq("janedoe"));
    assertEquals(1L, actualCreateResult.longValue());
  }

  /**
   * Method under test: {@link ActorService#delete(long)}
   */
  @Test
  void testDelete() {
    // Arrange
    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.deleteIfNotUsed(anyLong())).thenReturn(true);

    // Act
    boolean actualDeleteResult = (new ActorService(actorDao, mock(ActorSearchDao.class))).delete(1L);

    // Assert
    verify(actorDao).deleteIfNotUsed(eq(1L));
    assertTrue(actualDeleteResult);
  }

  /**
   * Method under test: {@link ActorService#delete(long)}
   */
  @Test
  void testDelete2() {
    // Arrange
    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.deleteIfNotUsed(anyLong())).thenReturn(false);

    // Act
    boolean actualDeleteResult = (new ActorService(actorDao, mock(ActorSearchDao.class))).delete(1L);

    // Assert
    verify(actorDao).deleteIfNotUsed(eq(1L));
    assertFalse(actualDeleteResult);
  }

  /**
   * Method under test: {@link ActorService#search(String)}
   */
  @Test
  void testSearch() {
    // Arrange
    ActorSearchDao actorSearchDao = mock(ActorSearchDao.class);
    when(actorSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(new ArrayList<>());

    // Act
    List<EntityReference> actualSearchResult = (new ActorService(mock(ActorDao.class), actorSearchDao)).search("Query");

    // Assert
    verify(actorSearchDao).search(isA(EntitySearchOptions.class));
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Method under test: {@link ActorService#search(String)}
   */
  @Test
  void testSearch2() {
    // Arrange, Act and Assert
    assertTrue((new ActorService(mock(ActorDao.class), mock(ActorSearchDao.class))).search("").isEmpty());
  }

  /**
   * Method under test: {@link ActorService#search(EntitySearchOptions)}
   */
  @Test
  void testSearch3() {
    // Arrange
    ActorSearchDao actorSearchDao = mock(ActorSearchDao.class);
    ArrayList<Actor> actorList = new ArrayList<>();
    when(actorSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(actorList);

    // Act
    List<Actor> actualSearchResult = (new ActorService(mock(ActorDao.class), actorSearchDao))
        .search((EntitySearchOptions) null);

    // Assert
    verify(actorSearchDao).search(isNull());
    assertTrue(actualSearchResult.isEmpty());
    assertSame(actorList, actualSearchResult);
  }
}
