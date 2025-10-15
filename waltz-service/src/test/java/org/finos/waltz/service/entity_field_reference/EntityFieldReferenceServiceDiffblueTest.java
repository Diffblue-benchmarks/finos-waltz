package org.finos.waltz.service.entity_field_reference;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.entity_field_reference.EntityFieldReferenceDao;
import org.finos.waltz.model.entity_field_reference.EntityFieldReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EntityFieldReferenceServiceDiffblueTest {
  @Mock private EntityFieldReferenceDao entityFieldReferenceDao;

  @InjectMocks private EntityFieldReferenceService entityFieldReferenceService;

  /**
   * Test {@link EntityFieldReferenceService#findAll()}.
   *
   * <p>Method under test: {@link EntityFieldReferenceService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set EntityFieldReferenceService.findAll()"})
  void testFindAll() {
    // Arrange
    when(entityFieldReferenceDao.findAll()).thenReturn(new HashSet<>());

    // Act
    Set<EntityFieldReference> actualFindAllResult = entityFieldReferenceService.findAll();

    // Assert
    verify(entityFieldReferenceDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }
}
