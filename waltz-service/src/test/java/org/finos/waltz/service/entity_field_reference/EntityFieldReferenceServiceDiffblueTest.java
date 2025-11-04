package org.finos.waltz.service.entity_field_reference;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.entity_field_reference.EntityFieldReferenceDao;
import org.finos.waltz.model.entity_field_reference.EntityFieldReference;
import org.junit.jupiter.api.Test;

class EntityFieldReferenceServiceDiffblueTest {
  /**
   * Method under test: {@link EntityFieldReferenceService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    EntityFieldReferenceDao entityFieldReferenceDao = mock(EntityFieldReferenceDao.class);
    HashSet<EntityFieldReference> entityFieldReferenceSet = new HashSet<>();
    when(entityFieldReferenceDao.findAll()).thenReturn(entityFieldReferenceSet);

    // Act
    Set<EntityFieldReference> actualFindAllResult = (new EntityFieldReferenceService(entityFieldReferenceDao))
        .findAll();

    // Assert
    verify(entityFieldReferenceDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(entityFieldReferenceSet, actualFindAllResult);
  }
}
