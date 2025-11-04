package org.finos.waltz.service.entity_enum;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.entity_enum.EntityEnumDefinitionDao;
import org.finos.waltz.data.entity_enum.EntityEnumValueDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.entity_enum.EntityEnumDefinition;
import org.finos.waltz.model.entity_enum.EntityEnumValue;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityEnumServiceDiffblueTest {
  /**
   * Method under test:
   * {@link EntityEnumService#findDefinitionsByEntityKind(EntityKind)}
   */
  @Test
  void testFindDefinitionsByEntityKind() {
    // Arrange
    EntityEnumDefinitionDao entityEnumDefinitionDao = mock(EntityEnumDefinitionDao.class);
    ArrayList<EntityEnumDefinition> entityEnumDefinitionList = new ArrayList<>();
    when(entityEnumDefinitionDao.findByEntityKind(Mockito.<EntityKind>any())).thenReturn(entityEnumDefinitionList);

    // Act
    List<EntityEnumDefinition> actualFindDefinitionsByEntityKindResult = (new EntityEnumService(entityEnumDefinitionDao,
        mock(EntityEnumValueDao.class))).findDefinitionsByEntityKind(EntityKind.ALL);

    // Assert
    verify(entityEnumDefinitionDao).findByEntityKind(eq(EntityKind.ALL));
    assertTrue(actualFindDefinitionsByEntityKindResult.isEmpty());
    assertSame(entityEnumDefinitionList, actualFindDefinitionsByEntityKindResult);
  }

  /**
   * Method under test:
   * {@link EntityEnumService#findValuesByEntity(EntityReference)}
   */
  @Test
  void testFindValuesByEntity() {
    // Arrange
    EntityEnumValueDao entityEnumValueDao = mock(EntityEnumValueDao.class);
    ArrayList<EntityEnumValue> entityEnumValueList = new ArrayList<>();
    when(entityEnumValueDao.findByEntity(Mockito.<EntityReference>any())).thenReturn(entityEnumValueList);

    // Act
    List<EntityEnumValue> actualFindValuesByEntityResult = (new EntityEnumService(mock(EntityEnumDefinitionDao.class),
        entityEnumValueDao)).findValuesByEntity(mock(EntityReference.class));

    // Assert
    verify(entityEnumValueDao).findByEntity(isA(EntityReference.class));
    assertTrue(actualFindValuesByEntityResult.isEmpty());
    assertSame(entityEnumValueList, actualFindValuesByEntityResult);
  }
}
