package org.finos.waltz.service.entity_alias;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.data.entity_alias.EntityAliasDao;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityAliasServiceDiffblueTest {
  /**
   * Method under test:
   * {@link EntityAliasService#findAliasesForEntityReference(EntityReference)}
   */
  @Test
  void testFindAliasesForEntityReference() {
    // Arrange
    EntityAliasDao entityAliasDao = mock(EntityAliasDao.class);
    ArrayList<String> stringList = new ArrayList<>();
    when(entityAliasDao.findAliasesForEntityReference(Mockito.<EntityReference>any())).thenReturn(stringList);

    // Act
    List<String> actualFindAliasesForEntityReferenceResult = (new EntityAliasService(entityAliasDao))
        .findAliasesForEntityReference(null);

    // Assert
    verify(entityAliasDao).findAliasesForEntityReference(isNull());
    assertTrue(actualFindAliasesForEntityReferenceResult.isEmpty());
    assertSame(stringList, actualFindAliasesForEntityReferenceResult);
  }

  /**
   * Method under test:
   * {@link EntityAliasService#updateAliases(EntityReference, Collection)}
   */
  @Test
  void testUpdateAliases() {
    // Arrange
    EntityAliasDao entityAliasDao = mock(EntityAliasDao.class);
    when(entityAliasDao.updateAliases(Mockito.<EntityReference>any(), Mockito.<Collection<String>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    EntityAliasService entityAliasService = new EntityAliasService(entityAliasDao);

    // Act
    int[] actualUpdateAliasesResult = entityAliasService.updateAliases(null, new ArrayList<>());

    // Assert
    verify(entityAliasDao).updateAliases(isNull(), isA(Collection.class));
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualUpdateAliasesResult);
  }

  /**
   * Method under test:
   * {@link EntityAliasService#updateAliases(EntityReference, Collection)}
   */
  @Test
  void testUpdateAliases2() {
    // Arrange
    EntityAliasDao entityAliasDao = mock(EntityAliasDao.class);
    when(entityAliasDao.updateAliases(Mockito.<EntityReference>any(), Mockito.<Collection<String>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    EntityAliasService entityAliasService = new EntityAliasService(entityAliasDao);

    ArrayList<String> aliases = new ArrayList<>();
    aliases.add("foo");

    // Act
    int[] actualUpdateAliasesResult = entityAliasService.updateAliases(null, aliases);

    // Assert
    verify(entityAliasDao).updateAliases(isNull(), isA(Collection.class));
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualUpdateAliasesResult);
  }

  /**
   * Method under test:
   * {@link EntityAliasService#updateAliases(EntityReference, Collection)}
   */
  @Test
  void testUpdateAliases3() {
    // Arrange
    EntityAliasDao entityAliasDao = mock(EntityAliasDao.class);
    when(entityAliasDao.updateAliases(Mockito.<EntityReference>any(), Mockito.<Collection<String>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    EntityAliasService entityAliasService = new EntityAliasService(entityAliasDao);

    ArrayList<String> aliases = new ArrayList<>();
    aliases.add("42");
    aliases.add("foo");

    // Act
    int[] actualUpdateAliasesResult = entityAliasService.updateAliases(null, aliases);

    // Assert
    verify(entityAliasDao).updateAliases(isNull(), isA(Collection.class));
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualUpdateAliasesResult);
  }
}
